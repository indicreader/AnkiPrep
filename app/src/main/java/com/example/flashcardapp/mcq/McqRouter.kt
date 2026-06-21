package com.example.flashcardapp.mcq

import com.example.flashcardapp.data.entities.CardEntity

/**
 * Input/output contract for [McqRouter].
 *
 * Both input types (A and B) produce a [RouteResult] on success.
 *
 * **Type A** (raw Q&A): `question` + `answer` fields only.
 *   Example card back: `"Paris"`
 *
 * **Type B** (pre-built MCQ): back field already contains the pipe-delimited
 *   MCQ format: `"CorrectAnswer|Option1|Option2|Option3; Explanation"`
 *   The router validates and passes it through unchanged.
 */
sealed class RouteResult {
    /**
     * Successfully routed input. Contains the fully-formed MCQ string in output format:
     * `question, Correct Answer |Option1|Option2|Option3; Explanation`
     */
    data class Success(
        val formatted: String,
        val mcq: Mcq,
        val inputType: InputType
    ) : RouteResult()

    /** Input could not be parsed or MCQ generation failed. */
    data class Failure(val reason: String) : RouteResult()
}

enum class InputType { TYPE_A, TYPE_B }

/**
 * MCQ Input Router
 *
 * Classifies input cards into two types and routes them accordingly:
 *
 * - **TYPE A** (one-liner): `question` and raw `answer` only →
 *   delegates to [McqEngine] for distractor generation via dataset-level similarity.
 *
 * - **TYPE B** (pre-built MCQ): back field already encodes the canonical format
 *   `Correct Answer |Option1|Option2|Option3; Explanation` →
 *   validates and passes through with zero modification.
 *
 * Semantic relationships (Graphify clusters / dataset similarity) are used
 * opportunistically by the underlying [McqEngine] — they are **not** a required
 * runtime dependency. If the dataset pool is thin, the engine falls back to
 * structural/synthetic distractor generation.
 *
 * ## Output format (strict):
 * ```
 * question, Correct Answer |Option1|Option2|Option3; Explanation
 * ```
 */
class McqRouter(
    private val engine: McqEngine = McqEngine()
) {

    /**
     * Routes a single card to either the MCQ generator (Type A) or the
     * pass-through validator (Type B).
     *
     * @param card        The source card.
     * @param allCards    The full dataset pool used for semantic distractor sourcing.
     *                    Pass an empty list if unavailable — the engine will synthesize
     *                    distractors from structural rules instead.
     * @param difficulty  Optional difficulty override ("easy", "medium", "hard").
     */
    suspend fun route(
        card: CardEntity,
        allCards: List<CardEntity> = emptyList(),
        difficulty: String? = null
    ): RouteResult {
        val back = card.back.trim()

        return if (isTypeBFormat(back)) {
            routeTypeB(card, back)
        } else {
            routeTypeA(card, allCards, difficulty)
        }
    }

    /**
     * Batch routes a list of cards. Preserves order; failures are included in the result list.
     */
    suspend fun routeAll(
        cards: List<CardEntity>,
        allCards: List<CardEntity> = emptyList(),
        difficulty: String? = null
    ): List<RouteResult> {
        return cards.map { route(it, allCards, difficulty) }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Type detection
    // ─────────────────────────────────────────────────────────────────────────

    /**
     * Detects Type B format.
     *
     * A card back qualifies as Type B when it contains **at least one pipe character `|`**
     * before the first semicolon (or anywhere if no semicolon is present).
     * This matches the canonical MCQ encoding:
     * `Correct Answer |Option1|Option2|Option3; Explanation`
     *
     * Cards that happen to have a pipe in their explanation (after `;`) are NOT treated
     * as Type B — the pipe must appear in the answer/options section.
     */
    private fun isTypeBFormat(back: String): Boolean {
        val semicolonIdx = back.indexOf(';')
        val optionsSection = if (semicolonIdx != -1) back.substring(0, semicolonIdx) else back
        val pipeCount = optionsSection.count { it == '|' }
        // Require at least 3 pipes to have a full 4-option MCQ (correct + 3 distractors)
        return pipeCount >= 3
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Type B — pass-through
    // ─────────────────────────────────────────────────────────────────────────

    /**
     * Validates and passes through a pre-built MCQ card.
     *
     * Format expected in `back`:
     * `Correct Answer |Option1|Option2|Option3; Explanation`
     *
     * Rules:
     * - The correct answer is always the **first** token before the first `|`.
     * - Exactly 3 distractors are expected (tokens 2-4 separated by `|`).
     * - Explanation is separated by `;` (optional).
     * - No modification is made to any field.
     */
    private fun routeTypeB(card: CardEntity, back: String): RouteResult {
        val semicolonIdx = back.indexOf(';')
        val explanation = if (semicolonIdx != -1) back.substring(semicolonIdx + 1).trim() else ""
        val optionsPart = if (semicolonIdx != -1) back.substring(0, semicolonIdx).trim() else back

        val parts = optionsPart.split("|").map { it.trim() }.filter { it.isNotEmpty() }
        if (parts.size < 4) {
            return RouteResult.Failure(
                "TYPE_B format requires exactly 4 options (1 correct + 3 distractors), " +
                        "got ${parts.size} in card id=${card.id}"
            )
        }

        val correctAnswer = parts[0]
        val distractors = parts.drop(1).take(3)

        // Validate uniqueness (case-insensitive)
        val allOptions = listOf(correctAnswer) + distractors
        if (allOptions.map { it.lowercase() }.distinct().size != allOptions.size) {
            return RouteResult.Failure(
                "TYPE_B card id=${card.id} has duplicate options after normalisation."
            )
        }

        // Build the Mcq model with the correct answer locked at index 0 (pass-through preserves order)
        val mcq = Mcq(
            question = card.front.trim(),
            options = allOptions,
            correctIndex = 0,
            sourceCardId = card.id,
            distractorSourceIds = listOf(-1L, -1L, -1L), // pre-built; no source card IDs
            deckHierarchy = card.deckHierarchy,
            explanation = explanation,
            difficulty = "medium",
            answerType = "concept"
        )

        if (!mcq.isValid()) {
            return RouteResult.Failure("TYPE_B card id=${card.id} failed MCQ invariant check.")
        }

        return RouteResult.Success(
            formatted = formatOutput(mcq),
            mcq = mcq,
            inputType = InputType.TYPE_B
        )
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Type A — generator
    // ─────────────────────────────────────────────────────────────────────────

    /**
     * Generates a full 4-option MCQ from a raw Q&A card using [McqEngine].
     *
     * Distractor priority (handled by the engine):
     * 1. Semantically similar answers from the same dataset (PRIORITY 1 / BEST)
     *    - Same subdeck → parent deck → root deck → global pool
     * 2. Structural similarity fallback (PRIORITY 2 / FALLBACK):
     *    - Similar word length, similar word count, numeric/year format match
     * 3. Synthetic generation (last resort when pool is too thin)
     */
    private suspend fun routeTypeA(
        card: CardEntity,
        allCards: List<CardEntity>,
        difficulty: String?
    ): RouteResult {
        // Use allCards as the distractor pool. If empty, the engine will synthesize.
        val pool = allCards.ifEmpty { listOf(card) }

        val mcqs = engine.generate(
            allCards = pool,
            targetCards = listOf(card),
            targetDifficulty = difficulty
        )

        // Find the MCQ corresponding to this specific card
        val mcq = mcqs.firstOrNull { it.sourceCardId == card.id }
            ?: return RouteResult.Failure(
                "TYPE_A generation failed for card id=${card.id}: " +
                        "insufficient distractors in dataset pool (size=${pool.size})."
            )

        return RouteResult.Success(
            formatted = formatOutput(mcq),
            mcq = mcq,
            inputType = InputType.TYPE_A
        )
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Output formatter
    // ─────────────────────────────────────────────────────────────────────────

    /**
     * Produces the strict canonical output string:
     * ```
     * question, Correct Answer |Option1|Option2|Option3; Explanation
     * ```
     *
     * - The correct answer always appears **first** in the options section.
     * - Distractors follow in their shuffled order from the engine.
     * - The explanation is appended after `;` (omitted if blank).
     */
    private fun formatOutput(mcq: Mcq): String {
        val correct = mcq.correctAnswer
        val distractors = mcq.options.filterIndexed { i, _ -> i != mcq.correctIndex }

        val optionsPart = buildString {
            append(correct)
            distractors.forEach { append(" |").append(it) }
        }

        val explanationPart = if (mcq.explanation.isNotBlank()) "; ${mcq.explanation}" else ""

        return "${mcq.question}, $optionsPart$explanationPart"
    }
}
