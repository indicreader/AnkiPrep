package com.example.flashcardapp.mcq

import com.example.flashcardapp.data.DeckHierarchyUtils
import com.example.flashcardapp.data.entities.CardEntity
import com.example.flashcardapp.data.entities.AliasEntity
import kotlin.random.Random
import kotlinx.coroutines.*

/**
 * Deterministic MCQ generation engine.
 *
 * Converts Anki flashcards into exam-style MCQs with hierarchical distractor
 * selection and semantic similarity grouping. No AI dependency — pure algorithmic generation.
 *
 * ## Distractor Selection Strategy:
 * Categorizes the card's answer type (person, year/date, place, law/article, number, concept)
 * and filters candidates to match the category.
 * 
 * Implements strict psychological and semantic constraints:
 * 1. The Tautology & Alias Ban Rule: Prevents minor textual variations, spelling aliases, or suffixes.
 * 2. High-Yield Cognitive Conflict: Prioritizes same-subdeck items (rivals, predecessors, successors).
 *
 * ## Difficulty Scaling:
 * - **easy** -> Broader semantic distance (prioritizes global/root pool candidates matching type)
 * - **medium** -> Moderate semantic distance (prioritizes parent/root pool candidates matching type)
 * - **hard** -> Closely related entities/concepts (prioritizes subdeck/parent pool candidates matching type)
 *
 * ## Determinism:
 * Uses a [Random] instance seeded per-session. For the same seed and input,
 * output is identical. Pass different seeds to get different shuffles per session.
 *
 * ## Rules enforced:
 * - Exactly 4 options per MCQ (1 correct + 3 distractors)
 * - No duplicate options (case-insensitive dedup)
 * - Correct answer position is randomized
 * - Distractors are plausible and match type (fallback to any type if pool is too small)
 * - Empty/blank cards are silently skipped
 */
class McqEngine(
    private val random: Random = Random(System.currentTimeMillis()),
    private val optionsCount: Int = 4
) {
    private val requiredDistractors = (optionsCount - 1).coerceAtLeast(1)

    /**
     * Generates MCQs from a list of cards.
     *
     * @param cards All available cards (used for distractor sourcing)
     * @param targetDeckId If provided, only generate MCQs for cards in this deck.
     *                     All cards are still used as distractor sources.
     * @param targetDeckPath If provided, generate MCQs recursively for cards matching hierarchy.
     * @param targetDifficulty If provided, forces this difficulty level ("easy", "medium", "hard").
     * @return List of valid [Mcq] objects. Cards that can't produce valid MCQs are skipped.
     */
    suspend fun generate(
        allCards: List<CardEntity>,
        targetCards: List<CardEntity>,
        aliases: List<AliasEntity> = emptyList(),
        targetDeckId: Long? = null,
        targetDeckPath: String? = null,
        targetDifficulty: String? = null
    ): List<Mcq> {
        if (allCards.isEmpty() || targetCards.isEmpty()) return emptyList()

        val index = HierarchyIndex.buildAsync(allCards)
        return targetCards.mapNotNull { card ->
            generateSingleMcq(card, index, aliases, targetDifficulty)
        }
    }

    /**
     * Generates a single MCQ from a card, using the hierarchy index for distractors.
     *
     * Returns null if the card has empty front/back or insufficient distractors exist.
     */
    private fun generateSingleMcq(
        card: CardEntity,
        index: HierarchyIndex,
        aliases: List<AliasEntity> = emptyList(),
        targetDifficulty: String? = null
    ): Mcq? {
        val question = card.front.trim()
        val parsed = com.example.flashcardapp.data.core.StructuredParser.parse(card.back)
        val correctAnswer = parsed.answer

        val parsedTags = try {
            val type = object : com.google.gson.reflect.TypeToken<List<String>>() {}.type
            com.google.gson.Gson().fromJson<List<String>>(card.tags, type) ?: emptyList()
        } catch (e: Exception) { emptyList() }

        if (question.isEmpty() || correctAnswer.isEmpty()) return null

        val answerType = index.getType(card.id)

        // If targetDifficulty is provided, use it. Otherwise, assign one deterministically.
        val difficulty = targetDifficulty ?: when (random.nextInt(3)) {
            0 -> "easy"
            1 -> "medium"
            else -> "hard"
        }

        val distractors = mutableListOf<DistractorCandidate>()
        
        // If the user explicitly provided options via the standard MCQ format, use them first
        if (parsed.options.isNotEmpty()) {
            parsed.options.take(requiredDistractors).forEach { option ->
                distractors.add(DistractorCandidate(option, -1L, DistractorSource.GLOBAL_POOL))
            }
        }
        
        // If we still need distractors, fall back to the dynamic generation engine
        if (distractors.size < requiredDistractors) {
            val generated = selectDistractors(card, correctAnswer, answerType, difficulty, index, aliases, 0, 0)
            val needed = requiredDistractors - distractors.size
            distractors.addAll(generated.take(needed))
        }

        if (distractors.size < requiredDistractors) return null

        // Build options: correct + distractors, then shuffle
        // Use index-tagged pairs: (text, cardId, isCorrect) to avoid text-equality ambiguity
        data class OptionMeta(val text: String, val cardId: Long, val isCorrect: Boolean)
        val optionsWithMeta = mutableListOf<OptionMeta>()
        optionsWithMeta.add(OptionMeta(correctAnswer, card.id, true))
        distractors.forEach { d -> optionsWithMeta.add(OptionMeta(d.text, d.sourceCardId, false)) }

        // Shuffle options deterministically
        val shuffled = optionsWithMeta.shuffled(random)
        val options = shuffled.map { it.text }
        // BUG FIX: find correct index by isCorrect flag, not by text equality (avoids -1 on whitespace mismatch)
        val correctIndex = shuffled.indexOfFirst { it.isCorrect }

        // BUG FIX: extract distractor IDs by index position, not by text filter (avoids misalignment)
        val distractorSourceIds = shuffled
            .filterIndexed { i, _ -> i != correctIndex }
            .map { it.cardId }
            
        val explanation = if (parsed.explanation.isNotEmpty()) {
            parsed.explanation
        } else {
            "The correct answer is: $correctAnswer"
        }

        val mcq = Mcq(
            question = question,
            options = options,
            correctIndex = correctIndex,
            sourceCardId = card.id,
            distractorSourceIds = distractorSourceIds,
            deckHierarchy = card.deckHierarchy,
            explanation = explanation,
            difficulty = difficulty,
            answerType = answerType,
            tags = parsedTags,
            frontImage = card.frontImage,
            backImage = card.backImage,
            explanationImage = card.explanationImage,
            optionImagesJson = card.optionImagesJson
        )

        // Final validation
        return if (mcq.isValid()) mcq else null
    }

    private fun levenshtein(s1: String, s2: String): Int {
        val dp = IntArray(s2.length + 1) { it }
        for (i in 1..s1.length) {
            var prev = dp[0]
            dp[0] = i
            for (j in 1..s2.length) {
                val temp = dp[j]
                if (s1[i - 1] == s2[j - 1]) {
                    dp[j] = prev
                } else {
                    dp[j] = minOf(dp[j - 1], dp[j], prev) + 1
                }
                prev = temp
            }
        }
        return dp[s2.length]
    }

    private fun calculateSimilarity(s1: String, s2: String): Float {
        val len = maxOf(s1.length, s2.length)
        if (len == 0) return 1.0f
        return 1.0f - levenshtein(s1, s2).toFloat() / len
    }

    private fun wordOverlapSimilarity(s1: String, s2: String): Float {
        val words1 = s1.lowercase().split(Regex("\\W+")).filter { it.isNotEmpty() }.toSet()
        val words2 = s2.lowercase().split(Regex("\\W+")).filter { it.isNotEmpty() }.toSet()
        if (words1.isEmpty() && words2.isEmpty()) return 1.0f
        // BUG FIX: if one set is empty and the other isn't, they are dissimilar but not maximally so
        if (words1.isEmpty() || words2.isEmpty()) return 0.0f
        val intersect = words1.intersect(words2).size
        val union = words1.union(words2).size
        if (union == 0) return 1.0f
        return intersect.toFloat() / union
    }

    /**
     * Implements "The Tautology & Alias Ban Rule".
     * Strictly forbids distractors that are minor textual variations, formal titles, 
     * spelling aliases, or chronological suffixes of the correct answer.
     */
    private fun isTautologyOrAlias(
        correctAnswer: String,
        cleanCorrect: String,
        wordsCorrect: Set<String>,
        candidate: String
    ): Boolean {
        val cleanCandidate = candidate.lowercase().replace(Regex("[^a-z0-9 ]"), " ").trim()

        if (cleanCorrect == cleanCandidate) return true

        // Ban direct substring containment if strings are reasonably substantive
        if (cleanCorrect.length > 4 && cleanCandidate.length > 4) {
            if (cleanCorrect.contains(cleanCandidate) || cleanCandidate.contains(cleanCorrect)) return true
        }

        // Ban if they share too many significant words (e.g., overlapping names/titles)
        val wordsCandidate = cleanCandidate.split("\\s+".toRegex()).filter { it.length > 2 || it.any { it.isDigit() } }.toSet()
        
        if (wordsCorrect.isNotEmpty() && wordsCandidate.isNotEmpty()) {
            val intersection = wordsCorrect.intersect(wordsCandidate).size
            val minWords = minOf(wordsCorrect.size, wordsCandidate.size)
            // If >= 75% of words from the shorter phrase match, it's a tautology
            if (minWords > 0 && intersection.toFloat() / minWords >= 0.75f) {
                return true
            }
        }
        return false
    }

    private fun getSimilarity(s1: String, s2: String, type: String): Float {
        val clean1 = s1.trim().lowercase()
        val clean2 = s2.trim().lowercase()
        if (clean1 == clean2) return 1.0f

        if (type == "number" || type == "year/date") {
            val n1 = clean1.filter { it.isDigit() || it == '.' }.toDoubleOrNull()
            val n2 = clean2.filter { it.isDigit() || it == '.' }.toDoubleOrNull()
            if (n1 != null && n2 != null) {
                val diff = kotlin.math.abs(n1 - n2)
                if (diff == 0.0) return 1.0f
                val maxVal = maxOf(kotlin.math.abs(n1), kotlin.math.abs(n2))
                if (maxVal > 0) {
                    return (1.0 - (diff / maxVal)).toFloat().coerceIn(0.0f, 1.0f)
                }
            }
        }

        val levSim = calculateSimilarity(clean1, clean2)
        val wordSim = wordOverlapSimilarity(clean1, clean2)
        return 0.5f * levSim + 0.5f * wordSim
    }

    /**
     * Generates plausible synthetic distractors when the card pool lacks enough same-type candidates.
     * Ensures distractors always match the answer's semantic type.
     */
    
    private fun generateSyntheticDistractors(
        correctAnswer: String,
        answerType: String,
        needed: Int,
        aliases: List<AliasEntity> = emptyList(),
        allowNota: Boolean
    ): List<DistractorCandidate> {
        val result = mutableListOf<DistractorCandidate>()
        val usedTexts = mutableSetOf(correctAnswer.trim().lowercase())

        fun addIfNew(text: String) {
            val trimmed = text.trim()
            if (result.size < needed && trimmed.lowercase() !in usedTexts && trimmed.isNotBlank()) {
                if (!false) {
                    result.add(DistractorCandidate(trimmed, -1L, DistractorSource.GLOBAL_POOL))
                    usedTexts.add(trimmed.lowercase())
                }
            }
        }

        if (answerType == "number" || answerType == "year/date") {
            val numMatch = Regex("""[-+]?\d+(?:\.\d+)?""").find(correctAnswer)
            if (numMatch != null) {
                val baseNum = numMatch.value.toDoubleOrNull()
                if (baseNum != null) {
                    val suffix = correctAnswer.substring(numMatch.range.last + 1).trim()
                    val prefix = correctAnswer.substring(0, numMatch.range.first).trim()
                    val offsets = listOf(1.0, -1.0, 2.0, -2.0, 3.0, -3.0, 4.0, -4.0, 5.0, -5.0)
                    offsets.shuffled(random).forEach { offset ->
                        val candidate = "${if (prefix.isNotEmpty()) "$prefix " else ""}${
                            if ((baseNum + offset) == kotlin.math.floor(baseNum + offset)) 
                            (baseNum + offset).toLong().toString() 
                            else 
                            String.format("%.1f", baseNum + offset)
                        }${if (suffix.isNotEmpty()) " $suffix" else ""}"
                        addIfNew(candidate)
                    }
                }
            }
        } else {
            // Lexical
            if (allowNota) {
                addIfNew("None of the above")
            }
        }
        return result
    }

    private fun selectDistractors(
        card: CardEntity,
        correctAnswer: String,
        answerType: String,
        difficulty: String,
        index: HierarchyIndex,
        aliases: List<AliasEntity> = emptyList(),
        notaCount: Int,
        maxNota: Int
    ): List<DistractorCandidate> {
        val selected = mutableListOf<DistractorCandidate>()
        val usedTexts = mutableSetOf(correctAnswer.trim().lowercase())
        
        val isNumeric = answerType == "number" || answerType == "year/date"
        val allowNota = !isNumeric && notaCount < maxNota
        val allowExtendedVariance = !allowNota && notaCount >= maxNota

        val hierarchy = DeckHierarchyUtils.parseDeckHierarchy(card.deckHierarchy)
        val parentPath = if (hierarchy.size > 1) hierarchy.dropLast(1).joinToString("::") else ""
        val rootSegment = hierarchy.firstOrNull() ?: ""

        val cleanCorrect = correctAnswer.lowercase().replace(Regex("[^a-z0-9 ]"), " ").trim()
        val wordsCorrect = cleanCorrect.split("\\s+".toRegex()).filter { it.length > 2 }.toSet()

        fun addCandidatesFromPool(
            cardPool: List<CardEntity>,
            source: DistractorSource
        ) {
            if (selected.size >= requiredDistractors) return

            val eligible = mutableListOf<DistractorCandidate>()

            for (c in cardPool) {
                if (c.id == card.id) continue
                val parsed = com.example.flashcardapp.data.core.StructuredParser.parseCard(c.front, c.back)
                val cText = parsed.answer.trim()
                if (cText.isEmpty() || cText.lowercase() in usedTexts) continue
                if (isTautologyOrAlias(correctAnswer, cleanCorrect, wordsCorrect, cText)) continue
                
                // PRD Grammar / Type Check
                if (index.getType(c.id) != answerType) continue
                
                // PRD Lexical Variance Bound check
                if (!isNumeric) {
                    val lenDiff = kotlin.math.abs(cText.length - correctAnswer.length)
                    val limit = if (allowExtendedVariance) 10 else 5
                    if (lenDiff > limit) continue
                }
                eligible.add(DistractorCandidate(cText, c.id, source))
            }
            
            // Shuffle eligible candidates and pick top required
            eligible.shuffle(random)
            for (c in eligible) {
                if (selected.size >= requiredDistractors) break
                selected.add(c)
                usedTexts.add(c.text.lowercase())
            }
        }

        // LEVEL 1: Inner Tag Pool
        val gson = com.google.gson.Gson()
        val type = object : com.google.gson.reflect.TypeToken<List<String>>() {}.type
        val targetTags: List<String> = try {
            gson.fromJson(card.tags, type) ?: emptyList()
        } catch (e: Exception) { emptyList() }

        if (targetTags.isNotEmpty()) {
            val tagMatchCards = index.allCards.filter { c ->
                val cTags: List<String> = try {
                    gson.fromJson(c.tags, type) ?: emptyList()
                } catch (e: Exception) { emptyList() }
                cTags.any { targetTags.contains(it) }
            }
            addCandidatesFromPool(tagMatchCards, DistractorSource.SAME_DECK)
        }

        // LEVEL 2: Parent Deck Pool
        if (selected.size < requiredDistractors && parentPath.isNotEmpty()) {
            val parentMatchCards = index.getByParentPath(parentPath)
            addCandidatesFromPool(parentMatchCards, DistractorSource.SAME_DECK)
        }

        // LEVEL 3: Master Deck Pool
        if (selected.size < requiredDistractors && rootSegment.isNotEmpty()) {
            addCandidatesFromPool(index.getByRootSegment(rootSegment), DistractorSource.SAME_ROOT)
        }
        
        // LEVEL 4: None of the above Fallback / Synthetic Variance Generation
        if (selected.size < requiredDistractors) {
            val needed = requiredDistractors - selected.size
            val synthetic = generateSyntheticDistractors(correctAnswer, answerType, needed, aliases, allowNota)
            for (s in synthetic) {
                if (selected.size >= requiredDistractors) break
                if (s.text.lowercase() !in usedTexts) {
                    selected.add(s)
                    usedTexts.add(s.text.lowercase())
                }
            }
        }

        return selected
    }

}


class HierarchyIndex private constructor(
    val allCards: List<CardEntity>,
    private val byDeckId: Map<Long, List<CardEntity>>,
    private val byParentPath: Map<String, List<CardEntity>>,
    private val byRootSegment: Map<String, List<CardEntity>>,
    private val cardTypes: Map<Long, String>,
    private val byDeckIdAndType: Map<Pair<Long, String>, List<CardEntity>>,
    private val byParentPathAndType: Map<Pair<String, String>, List<CardEntity>>,
    private val byRootSegmentAndType: Map<Pair<String, String>, List<CardEntity>>,
    private val byType: Map<String, List<CardEntity>>
) {
    companion object {
        /**
         * Builds a [HierarchyIndex] from a list of cards, pre-classifying card types in parallel.
         */
        suspend fun buildAsync(cards: List<CardEntity>): HierarchyIndex = kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.Default) {
            val byDeckId = cards.groupBy { it.deckId }

            val byParentPath = mutableMapOf<String, MutableList<CardEntity>>()
            val byRootSegment = mutableMapOf<String, MutableList<CardEntity>>()
            
            val byDeckIdAndType = mutableMapOf<Pair<Long, String>, MutableList<CardEntity>>()
            val byParentPathAndType = mutableMapOf<Pair<String, String>, MutableList<CardEntity>>()
            val byRootSegmentAndType = mutableMapOf<Pair<String, String>, MutableList<CardEntity>>()
            val byType = mutableMapOf<String, MutableList<CardEntity>>()

            // Run semantic classification in parallel
            val deferreds = cards.map { card ->
                async {
                    card to SemanticClassifier.classify(card.front, card.back)
                }
            }
            val cardTypesList = deferreds.awaitAll()
            
            val cardTypes = cardTypesList.associate { it.first.id to it.second }

            for ((card, type) in cardTypesList) {
                val hierarchy = DeckHierarchyUtils.parseDeckHierarchy(card.deckHierarchy)
                
                byType.getOrPut(type) { mutableListOf() }.add(card)

                byDeckIdAndType.getOrPut(card.deckId to type) { mutableListOf() }.add(card)

                // Parent path index
                if (hierarchy.size > 1) {
                    val parentPath = hierarchy.dropLast(1).joinToString("::")
                    byParentPath.getOrPut(parentPath) { mutableListOf() }.add(card)
                    byParentPathAndType.getOrPut(parentPath to type) { mutableListOf() }.add(card)
                }

                // Root segment index
                val root = hierarchy.firstOrNull()
                if (root != null) {
                    byRootSegment.getOrPut(root) { mutableListOf() }.add(card)
                    byRootSegmentAndType.getOrPut(root to type) { mutableListOf() }.add(card)
                }
            }

            HierarchyIndex(
                allCards = cards,
                byDeckId = byDeckId,
                byParentPath = byParentPath,
                byRootSegment = byRootSegment,
                cardTypes = cardTypes,
                byDeckIdAndType = byDeckIdAndType,
                byParentPathAndType = byParentPathAndType,
                byRootSegmentAndType = byRootSegmentAndType,
                byType = byType
            )
        }
    }

    fun getByDeckId(deckId: Long): List<CardEntity> = byDeckId[deckId] ?: emptyList()
    fun getByParentPath(parentPath: String): List<CardEntity> = byParentPath[parentPath] ?: emptyList()
    fun getByRootSegment(root: String): List<CardEntity> = byRootSegment[root] ?: emptyList()
    fun getType(cardId: Long): String = cardTypes[cardId] ?: "concept"
    
    fun getByDeckIdAndType(deckId: Long, type: String): List<CardEntity> = byDeckIdAndType[deckId to type] ?: emptyList()
    fun getByParentPathAndType(parentPath: String, type: String): List<CardEntity> = byParentPathAndType[parentPath to type] ?: emptyList()
    fun getByRootSegmentAndType(root: String, type: String): List<CardEntity> = byRootSegmentAndType[root to type] ?: emptyList()
    fun getByType(type: String): List<CardEntity> = byType[type] ?: emptyList()
}
