package com.example.flashcardapp.data

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import android.util.Log
import androidx.room.withTransaction
import com.example.flashcardapp.data.entities.CardEntity
import com.example.flashcardapp.data.entities.DeckEntity
import com.example.flashcardapp.data.core.CsvQuoteUtils
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStreamReader

/**
 * Imports flashcard decks from a CSV file.
 *
 * Expected CSV format (header optional):
 *   front,back[,tags]
 *   front;back[;tags]   (semicolon also supported)
 *   front\tback[\ttags] (tab also supported)
 *
 * Supports RFC 4180 escaped quotes, multiline fields, UTF-8 BOM stripping,
 * flexible case-insensitive column header mapping, and graceful fallback for bad rows.
 */
object CsvImporter {
    private const val TAG = "CsvImporter"
    private const val BATCH_SIZE = 200

    suspend fun importCsv(
        context: Context,
        uri: Uri,
        targetDeckId: Long? = null,
        targetDeckName: String? = null,
        duplicateStrategy: String = "UPDATE", // "SKIP", "IMPORT", "UPDATE"
        columnMapping: Map<Int, String>? = null,
        onProgress: ((importedCount: Int, totalEstimate: Int) -> Unit)? = null
    ): ImportResult = withContext(Dispatchers.IO) {
        val fileName = getFileName(context, uri)
        val appDb = AppDatabase.getInstance(context)

        val deckId: Long
        val deckName: String
        if (targetDeckId != null && targetDeckName != null) {
            deckId = targetDeckId
            deckName = targetDeckName
            Log.i(TAG, "Importing CSV streaming into deck: '$deckName' (id=$deckId)")
        } else {
            deckName = fileName.removeSuffix(".csv").removeSuffix(".CSV").trim()
                .ifEmpty { "Imported Deck" }
            val existingDeck = appDb.deckDao().getAllDecksOnce().find { it.fullPath == deckName || it.name == deckName }
            deckId = existingDeck?.id ?: kotlin.math.abs(java.util.UUID.randomUUID().mostSignificantBits)
            Log.i(TAG, "Starting CSV streaming import: $fileName → deck '$deckName' (id=$deckId)")
        }

        try {
            // First pass on sample lines to determine delimiter, expected cols, and header mapping without full string load
            val sampleLines = com.example.flashcardapp.data.core.FileImportUtils.readPreviewLines(context, uri, maxLines = 10)
            if (sampleLines.isEmpty()) {
                return@withContext ImportResult(
                    success = false,
                    fileName = fileName,
                    totalDecks = 0,
                    totalNotes = 0,
                    totalCards = 0,
                    error = "CSV file is empty"
                )
            }

            val delimiter = detectDelimiterFromLines(sampleLines)
            val firstLineParsed = CsvQuoteUtils.parseCsvLine(sampleLines.first(), delimiter)
            val isHeaderRow = looksLikeHeader(firstLineParsed)
            val activeColumnMapping = columnMapping ?: if (isHeaderRow) resolveColumnMapping(firstLineParsed) else null

            val sampleParsedRows = sampleLines.map { CsvQuoteUtils.parseCsvLine(it, delimiter) }
            val dataSampleRows = if (isHeaderRow) sampleParsedRows.drop(1) else sampleParsedRows
            val expectedCols = if (dataSampleRows.isNotEmpty()) {
                dataSampleRows.map { it.size }.groupBy { it }.maxByOrNull { it.value.size }?.key ?: 2
            } else {
                2
            }

            val timestamp = System.currentTimeMillis()
            val existingCards = if (targetDeckId != null) appDb.cardDao().getCardsForDeckOnce(deckId) else emptyList()
            val existingFronts = existingCards.associateBy { it.front.trim().lowercase() }

            val cardsToUpdateBatch = mutableListOf<CardEntity>()
            val cardsToInsertBatch = mutableListOf<CardEntity>()
            val sampleCardsCollected = mutableListOf<CardEntity>()
            var totalProcessed = 0
            var skippedCount = 0
            val gson = Gson()

            // Open streaming BufferedReader directly from ContentResolver / Cache
            com.example.flashcardapp.data.core.FileImportUtils.openBufferedReader(context, uri).use { reader ->
                var rowIndex = 0
                while (true) {
                    val rawRow = CsvQuoteUtils.parseStreamingRow(reader, delimiter) ?: break
                    if (rawRow.all { it.isBlank() }) continue

                    if (rowIndex == 0 && isHeaderRow) {
                        rowIndex++
                        continue
                    }
                    rowIndex++

                    val sanitizedRow = CsvQuoteUtils.sanitizeStreamingRow(rawRow, expectedCols, delimiter)
                    val cardEntityResult = buildCardEntityFromRow(
                        row = sanitizedRow,
                        rowIndex = rowIndex,
                        activeColumnMapping = activeColumnMapping,
                        existingFronts = existingFronts,
                        duplicateStrategy = duplicateStrategy,
                        targetDeckId = targetDeckId,
                        deckId = deckId,
                        deckName = deckName,
                        timestamp = timestamp,
                        gson = gson
                    )

                    if (cardEntityResult != null) {
                        val (card, isUpdate) = cardEntityResult
                        if (isUpdate) {
                            cardsToUpdateBatch.add(card)
                        } else {
                            cardsToInsertBatch.add(card)
                        }
                        if (sampleCardsCollected.size < 6) {
                            sampleCardsCollected.add(card)
                        }

                        // When batch reaches BATCH_SIZE (250), flush atomically
                        if (cardsToInsertBatch.size + cardsToUpdateBatch.size >= BATCH_SIZE) {
                            val insertChunk = cardsToInsertBatch.toList()
                            val updateChunk = cardsToUpdateBatch.toList()
                            cardsToInsertBatch.clear()
                            cardsToUpdateBatch.clear()

                            appDb.withTransaction {
                                ensureDeckEntityExists(appDb, deckId, deckName, totalProcessed + insertChunk.size, timestamp)
                                if (insertChunk.isNotEmpty()) {
                                    appDb.cardDao().insertCardsIgnore(insertChunk)
                                }
                                if (updateChunk.isNotEmpty()) {
                                    appDb.cardDao().updateCards(updateChunk)
                                }
                            }
                            totalProcessed += (insertChunk.size + updateChunk.size)
                            onProgress?.invoke(totalProcessed, -1)
                        }
                    } else {
                        skippedCount++
                    }
                }
            }

            // Flush remaining cards in atomic transaction
            if (cardsToInsertBatch.isNotEmpty() || cardsToUpdateBatch.isNotEmpty()) {
                val insertChunk = cardsToInsertBatch.toList()
                val updateChunk = cardsToUpdateBatch.toList()
                cardsToInsertBatch.clear()
                cardsToUpdateBatch.clear()

                appDb.withTransaction {
                    ensureDeckEntityExists(appDb, deckId, deckName, totalProcessed + insertChunk.size, timestamp)
                    if (insertChunk.isNotEmpty()) {
                        appDb.cardDao().insertCardsIgnore(insertChunk)
                    }
                    if (updateChunk.isNotEmpty()) {
                        appDb.cardDao().updateCards(updateChunk)
                    }
                }
                totalProcessed += (insertChunk.size + updateChunk.size)
                onProgress?.invoke(totalProcessed, totalProcessed)
            }

            if (totalProcessed == 0) {
                return@withContext ImportResult(
                    success = false,
                    fileName = fileName,
                    totalDecks = 0,
                    totalNotes = 0,
                    totalCards = 0,
                    error = "No valid flashcard rows found. ($skippedCount rows skipped due to empty front/back or parsing errors)."
                )
            }

            Log.i(TAG, "Streaming CSV import complete for '$deckName'. Success: $totalProcessed, Skipped: $skippedCount")
            ImportResult(
                success = true,
                fileName = fileName,
                totalDecks = 1,
                totalNotes = totalProcessed,
                totalCards = totalProcessed,
                sampleCards = sampleCardsCollected
            )
        } catch (e: Exception) {
            Log.e(TAG, "Streaming CSV import failed", e)
            ImportResult(
                success = false,
                fileName = fileName,
                totalDecks = 0,
                totalNotes = 0,
                totalCards = 0,
                error = e.message ?: "Unknown error"
            )
        }
    }

    private suspend fun ensureDeckEntityExists(
        appDb: AppDatabase,
        deckId: Long,
        deckName: String,
        currentCount: Int,
        timestamp: Long,
        parentDeckId: Long? = null
    ) {
        val existingDeck = appDb.deckDao().getDeckById(deckId)
        if (existingDeck == null) {
            val leafName = if (deckName.contains("::")) deckName.substringAfterLast("::") else deckName
            val deckEntity = DeckEntity(
                id = deckId,
                name = leafName,
                fullPath = deckName,
                parentDeckId = parentDeckId,
                cardCount = currentCount,
                lastSyncTimestamp = timestamp
            )
            appDb.deckDao().insertDecksIgnore(listOf(deckEntity))
        } else {
            appDb.deckDao().updateDeck(
                existingDeck.copy(
                    cardCount = existingDeck.cardCount + currentCount,
                    parentDeckId = parentDeckId ?: existingDeck.parentDeckId,
                    lastSyncTimestamp = timestamp
                )
            )
        }
    }

    suspend fun importCsvString(
        context: Context,
        rawContent: String,
        fileName: String,
        targetDeckId: Long? = null,
        targetDeckName: String? = null,
        parentDeckId: Long? = null,
        parentDeckName: String? = null,
        duplicateStrategy: String = "UPDATE",
        columnMapping: Map<Int, String>? = null,
        onProgress: ((importedCount: Int, totalEstimate: Int) -> Unit)? = null
    ): ImportResult = withContext(Dispatchers.IO) {
        val appDb = AppDatabase.getInstance(context)

        val deckId: Long
        val deckName: String
        if (targetDeckId != null && targetDeckName != null) {
            deckId = targetDeckId
            deckName = targetDeckName
            Log.i(TAG, "Importing CSV string into deck: '$deckName' (id=$deckId)")
        } else {
            deckName = fileName.removeSuffix(".csv").removeSuffix(".CSV").trim()
                .ifEmpty { "Imported Deck" }
            val existingDeck = appDb.deckDao().getAllDecksOnce().find { it.fullPath == deckName || it.name == deckName }
            deckId = existingDeck?.id ?: kotlin.math.abs(java.util.UUID.randomUUID().mostSignificantBits)
            Log.i(TAG, "Starting CSV import: $fileName → deck '$deckName' (id=$deckId)")
        }

        try {
            if (rawContent.isBlank()) {
                return@withContext ImportResult(
                    success = false,
                    fileName = fileName,
                    totalDecks = 0,
                    totalNotes = 0,
                    totalCards = 0,
                    error = "CSV file is empty"
                )
            }

            val delimiter = detectDelimiter(rawContent)
            val sanitizedContent = CsvQuoteUtils.sanitizeAndQuoteCsv(rawContent, delimiter)
            val allRows = CsvQuoteUtils.parseCsv(sanitizedContent, delimiter)

            if (allRows.isEmpty()) {
                return@withContext ImportResult(
                    success = false,
                    fileName = fileName,
                    totalDecks = 0,
                    totalNotes = 0,
                    totalCards = 0,
                    error = "No readable rows found in CSV file"
                )
            }

            val firstRow = allRows.first()
            val isHeaderRow = looksLikeHeader(firstRow)
            val activeColumnMapping = columnMapping ?: if (isHeaderRow) resolveColumnMapping(firstRow) else null
            val dataRows = if (isHeaderRow) allRows.drop(1) else allRows

            if (dataRows.isEmpty()) {
                return@withContext ImportResult(
                    success = false,
                    fileName = fileName,
                    totalDecks = 0,
                    totalNotes = 0,
                    totalCards = 0,
                    error = "No data rows found after header processing"
                )
            }

            val timestamp = System.currentTimeMillis()
            val existingCards = if (targetDeckId != null) appDb.cardDao().getCardsForDeckOnce(deckId) else emptyList()
            val existingFronts = existingCards.associateBy { it.front.trim().lowercase() }

            val cardsToUpdate = mutableListOf<CardEntity>()
            val cardsToInsert = mutableListOf<CardEntity>()
            var skippedCount = 0
            val gson = Gson()

            for ((index, row) in dataRows.withIndex()) {
                val cardEntityResult = buildCardEntityFromRow(
                    row = row,
                    rowIndex = index,
                    activeColumnMapping = activeColumnMapping,
                    existingFronts = existingFronts,
                    duplicateStrategy = duplicateStrategy,
                    targetDeckId = targetDeckId,
                    deckId = deckId,
                    deckName = deckName,
                    timestamp = timestamp,
                    gson = gson
                )
                if (cardEntityResult != null) {
                    val (card, isUpdate) = cardEntityResult
                    if (isUpdate) cardsToUpdate.add(card) else cardsToInsert.add(card)
                } else {
                    skippedCount++
                }
            }

            val totalProcessed = cardsToUpdate.size + cardsToInsert.size
            if (totalProcessed == 0) {
                return@withContext ImportResult(
                    success = false,
                    fileName = fileName,
                    totalDecks = 0,
                    totalNotes = 0,
                    totalCards = 0,
                    error = "No valid flashcard rows found. ($skippedCount rows skipped due to empty front/back or parsing errors)."
                )
            }

            appDb.withTransaction {
                ensureDeckEntityExists(appDb, deckId, deckName, cardsToInsert.size, timestamp, parentDeckId)
                cardsToInsert.chunked(BATCH_SIZE).forEach { batch ->
                    appDb.cardDao().insertCardsIgnore(batch)
                }
                cardsToUpdate.chunked(BATCH_SIZE).forEach { batch ->
                    appDb.cardDao().updateCards(batch)
                }
            }
            onProgress?.invoke(totalProcessed, totalProcessed)

            Log.i(TAG, "CSV import complete for '$deckName'. Success: $totalProcessed, Skipped: $skippedCount")
            ImportResult(
                success = true,
                fileName = fileName,
                totalDecks = 1,
                totalNotes = totalProcessed,
                totalCards = totalProcessed,
                sampleCards = cardsToInsert.take(3) + cardsToUpdate.take(3)
            )
        } catch (e: Exception) {
            Log.e(TAG, "CSV import failed", e)
            ImportResult(
                success = false,
                fileName = fileName,
                totalDecks = 0,
                totalNotes = 0,
                totalCards = 0,
                error = e.message ?: "Unknown error"
            )
        }
    }

    private fun buildCardEntityFromRow(
        row: List<String>,
        rowIndex: Int,
        activeColumnMapping: Map<Int, String>?,
        existingFronts: Map<String, CardEntity>,
        duplicateStrategy: String,
        targetDeckId: Long?,
        deckId: Long,
        deckName: String,
        timestamp: Long,
        gson: Gson
    ): Pair<CardEntity, Boolean>? {
        var front = ""
        var back = ""
        var tagsJson = "[]"

        if (activeColumnMapping != null && activeColumnMapping.isNotEmpty()) {
            var question = ""
            var answer = ""
            var explanation = ""
            val tagsList = mutableListOf<String>()
            val optionsList = mutableListOf<String>()
            var optA = ""
            var optB = ""
            var optC = ""
            var optD = ""

            activeColumnMapping.forEach { (colIndex, mapping) ->
                val cellValue = row.getOrNull(colIndex)?.trim() ?: ""
                if (cellValue.isNotEmpty()) {
                    when (mapping.uppercase()) {
                        "FRONT", "QUESTION" -> question = cellValue
                        "BACK", "ANSWER" -> answer = cellValue
                        "EXPLANATION" -> explanation = cellValue
                        "TOPIC" -> tagsList.add("topic:${cellValue.removePrefix("topic:").trim()}")
                        "SUBTOPIC" -> tagsList.add("subtopic:${cellValue.removePrefix("subtopic:").trim()}")
                        "TAGS" -> {
                            val (parsed, extractedQ) = com.example.flashcardapp.data.core.TagQuestionUtils.parseAndFilterTags(cellValue)
                            tagsList.addAll(parsed)
                            if (question.isEmpty() && extractedQ != null) {
                                question = extractedQ
                            }
                        }
                        "OPTION_A" -> { optA = cellValue; optionsList.add(cellValue) }
                        "OPTION_B" -> { optB = cellValue; optionsList.add(cellValue) }
                        "OPTION_C" -> { optC = cellValue; optionsList.add(cellValue) }
                        "OPTION_D" -> { optD = cellValue; optionsList.add(cellValue) }
                        "OPTION" -> optionsList.add(cellValue)
                    }
                }
            }

            if (question.isEmpty() || answer.isEmpty()) {
                return null
            }

            var resolvedAnswer = answer
            val upperAns = answer.uppercase().removePrefix("(").removeSuffix(")").removeSuffix(".").trim()
            if (upperAns in listOf("A", "B", "C", "D", "1", "2", "3", "4")) {
                resolvedAnswer = when (upperAns) {
                    "A", "1" -> if (optA.isNotEmpty()) optA else optionsList.getOrNull(0) ?: answer
                    "B", "2" -> if (optB.isNotEmpty()) optB else optionsList.getOrNull(1) ?: answer
                    "C", "3" -> if (optC.isNotEmpty()) optC else optionsList.getOrNull(2) ?: answer
                    "D", "4" -> if (optD.isNotEmpty()) optD else optionsList.getOrNull(3) ?: answer
                    else -> answer
                }
            }

            front = com.example.flashcardapp.data.core.TagQuestionUtils.normalizeExtractedQuestion(question)
            val distractors = optionsList.filter {
                it.trim().lowercase() != resolvedAnswer.trim().lowercase()
            }
            back = if (distractors.isNotEmpty()) {
                "$resolvedAnswer | ${distractors.joinToString(" | ")}"
            } else {
                resolvedAnswer
            }
            if (explanation.isNotEmpty()) {
                back = "$back {explain} $explanation"
            }

            if (tagsList.none { it.startsWith("topic:") } && tagsList.isNotEmpty()) {
                val nonSpecial = tagsList.filter { !it.contains(":") }
                if (nonSpecial.isNotEmpty()) {
                    tagsList.add("topic:${nonSpecial[0]}")
                }
                if (nonSpecial.size > 1) {
                    tagsList.add("subtopic:${nonSpecial[1]}")
                }
            }
            tagsJson = gson.toJson(tagsList.distinct())
        } else {
            val tagsList = mutableListOf<String>()
            if (row.size == 5) {
                val topic = row[0].trim()
                val subtopic = row[1].trim()
                front = row[2].trim()
                back = row[3].trim()
                val explanation = row[4].trim()

                if (topic.isNotEmpty()) tagsList.add("topic:${topic.removePrefix("topic:").trim()}")
                if (subtopic.isNotEmpty()) tagsList.add("subtopic:${subtopic.removePrefix("subtopic:").trim()}")
                if (explanation.isNotEmpty()) back = "$back {explain} $explanation"
            } else if (row.size >= 2) {
                front = row[0].trim()
                back = row[1].trim()

                if (row.size == 3) {
                    val col2 = row[2].trim()
                    if (col2.isNotEmpty()) {
                        val (parsed, extractedQ) = com.example.flashcardapp.data.core.TagQuestionUtils.parseAndFilterTags(col2)
                        val wordCount = col2.split(Regex("\\s+")).filter { it.isNotEmpty() }.size
                        val isExplanation = wordCount > 5 || col2.contains(".") || col2.contains(";") || parsed.isEmpty() || extractedQ != null
                        if (isExplanation) {
                            val cleanExpl = (extractedQ ?: col2).trim()
                            back = "$back {explain} $cleanExpl"
                        } else {
                            tagsList.addAll(parsed)
                        }
                    }
                } else if (row.size == 4) {
                    val col0 = row[0].trim()
                    val col1 = row[1].trim()
                    val col2 = row[2].trim()
                    val col3 = row[3].trim()

                    if (col2.contains("|") || com.example.flashcardapp.data.core.TagQuestionUtils.isQuestionCandidate(col1)) {
                        val (parsed, _) = com.example.flashcardapp.data.core.TagQuestionUtils.parseAndFilterTags(col0)
                        tagsList.addAll(parsed)
                        front = col1
                        back = col2
                        if (col3.isNotEmpty()) back = "$back {explain} $col3"
                    } else {
                        front = col0
                        back = col1
                        if (col2.isNotEmpty()) {
                            val (parsed, extractedQ) = com.example.flashcardapp.data.core.TagQuestionUtils.parseAndFilterTags(col2)
                            tagsList.addAll(parsed)
                            if (front.isEmpty() && extractedQ != null) front = extractedQ
                        }
                        if (col3.isNotEmpty()) back = "$back {explain} $col3"
                    }
                } else {
                    val w0 = row[0].split(Regex("\\s+")).size
                    val w1 = row[1].split(Regex("\\s+")).size
                    if (w0 <= 5 && w1 <= 5) {
                        val topic = row[0].trim()
                        val subtopic = row[1].trim()
                        front = row[2].trim()
                        back = row[3].trim()
                        val explanation = row[4].trim()
                        if (topic.isNotEmpty()) tagsList.add("topic:${topic.removePrefix("topic:").trim()}")
                        if (subtopic.isNotEmpty()) tagsList.add("subtopic:${subtopic.removePrefix("subtopic:").trim()}")
                        if (explanation.isNotEmpty()) back = "$back {explain} $explanation"
                    } else {
                        val col2 = row[2].trim()
                        if (col2.isNotEmpty()) {
                            val (parsed, extractedQ) = com.example.flashcardapp.data.core.TagQuestionUtils.parseAndFilterTags(col2)
                            tagsList.addAll(parsed)
                            if (front.isEmpty() && extractedQ != null) front = extractedQ
                        }
                        val explanation = row[3].trim()
                        if (explanation.isNotEmpty()) back = "$back {explain} $explanation"
                    }
                }
            }

            if (front.isEmpty() || back.isEmpty()) {
                return null
            }
            front = com.example.flashcardapp.data.core.TagQuestionUtils.normalizeExtractedQuestion(front)
            tagsJson = gson.toJson(tagsList.distinct())
        }

        var cardId = kotlin.math.abs(java.util.UUID.randomUUID().mostSignificantBits)
        val frontKey = front.lowercase()
        val existing = existingFronts[frontKey]
        var isUpdate = false

        if (existing != null) {
            when (duplicateStrategy) {
                "SKIP" -> return null
                "IMPORT" -> cardId = kotlin.math.abs(java.util.UUID.randomUUID().mostSignificantBits)
                "UPDATE" -> {
                    cardId = existing.id
                    isUpdate = true
                }
            }
        } else if (targetDeckId != null) {
            cardId = kotlin.math.abs(java.util.UUID.randomUUID().mostSignificantBits)
        }

        val card = CardEntity(
            id = cardId,
            noteId = cardId,
            deckId = deckId,
            subDeckId = null,
            front = front,
            back = back,
            tags = tagsJson,
            deckHierarchy = deckName,
            lastSyncTimestamp = timestamp
        )
        return Pair(card, isUpdate)
    }

    private fun detectDelimiterFromLines(lines: List<String>): Char {
        val counts = mapOf(
            ',' to lines.sumOf { l -> l.count { it == ',' } },
            ';' to lines.sumOf { l -> l.count { it == ';' } },
            '\t' to lines.sumOf { l -> l.count { it == '\t' } }
        )
        return counts.maxByOrNull { it.value }?.takeIf { it.value > 0 }?.key ?: ','
    }


    /**
     * Reads a full CSV text stream into rows of cell arrays according to RFC 4180.
     * Handles BOM removal, multiline fields within double quotes, escaped quotes (""),
     * and arbitrary line endings (\r\n, \n, \r).
     */
    private fun parseCsv(rawContent: String, delimiter: Char): List<List<String>> {
        return CsvQuoteUtils.parseCsv(rawContent, delimiter)
    }

    private fun detectDelimiter(rawContent: String): Char {
        val firstLine = rawContent.lines().firstOrNull { it.isNotBlank() } ?: rawContent
        val counts = mapOf(
            ',' to firstLine.count { it == ',' },
            ';' to firstLine.count { it == ';' },
            '\t' to firstLine.count { it == '\t' }
        )
        return counts.maxByOrNull { it.value }?.takeIf { it.value > 0 }?.key ?: ','
    }

    private fun looksLikeHeader(row: List<String>): Boolean {
        val headers = setOf(
            "front", "back", "question", "answer", "term", "definition", "q", "a", "tags", "tag",
            "prompt", "response", "explanation", "explain", "explaination", "options", "option", "distractor",
            "option_a", "option_b", "option_c", "option_d", "opt_a", "opt_b", "opt_c", "opt_d",
            "correct_option", "correct_opt", "correct_answer", "correct", "key",
            "topic", "subtopic", "sub_topic", "sub-topic", "category",
            "ques", "ans", "fact", "liner ques", "one-liner", "detail", "sol", "solution",
            "id", "type"
        )
        val firstCell = row.getOrNull(0)?.trim()?.lowercase() ?: return false
        return firstCell in headers || row.any { cell -> cell.trim().lowercase() in headers }
    }

    private fun resolveColumnMapping(headerRow: List<String>): Map<Int, String> {
        val map = mutableMapOf<Int, String>()
        headerRow.forEachIndexed { index, rawHeader ->
            val clean = rawHeader.trim().lowercase()
            when {
                clean in setOf("topic") -> map[index] = "TOPIC"
                clean in setOf("subtopic", "sub_topic", "sub-topic") -> map[index] = "SUBTOPIC"
                clean in setOf("front", "question", "q", "ques", "term", "prompt", "fact", "one-liner", "liner ques") -> map[index] = "FRONT"
                clean in setOf(
                    "back", "answer", "ans", "a", "definition", "response",
                    "correct_option", "correct_opt", "correct_answer", "correct", "key", "right_answer",
                    "correct option", "right answer", "answer_key", "answer key"
                ) || clean.startsWith("answer|") || clean.startsWith("ans|") || clean.startsWith("back|") || clean.contains("answer|option") -> map[index] = "BACK"
                clean in setOf("explanation", "explain", "explaination", "notes", "rationale", "comment", "detail", "sol", "solution") -> map[index] = "EXPLANATION"
                clean in setOf("tags", "tag", "categories", "category", "labels", "keywords") -> map[index] = "TAGS"
                clean in setOf("option_a", "opt_a", "option 1", "opt 1", "choice_a") -> map[index] = "OPTION_A"
                clean in setOf("option_b", "opt_b", "option 2", "opt 2", "choice_b") -> map[index] = "OPTION_B"
                clean in setOf("option_c", "opt_c", "option 3", "opt 3", "choice_c") -> map[index] = "OPTION_C"
                clean in setOf("option_d", "opt_d", "option 4", "opt 4", "choice_d") -> map[index] = "OPTION_D"
                clean.startsWith("option") || clean.startsWith("opt") || clean in setOf("a", "b", "c", "d", "choice", "distractor") -> map[index] = "OPTION"
            }
        }

        // If the header had some matches but missed either FRONT or BACK, fall back gracefully
        if (!map.values.contains("FRONT") || !map.values.contains("BACK")) {
            val frontCandidate = map.entries.firstOrNull { it.value == "FRONT" }?.key
            val backCandidate = map.entries.firstOrNull { it.value == "BACK" }?.key

            if (frontCandidate == null && headerRow.isNotEmpty()) {
                val candidateCol = if (backCandidate != 0) 0 else 1
                if (candidateCol < headerRow.size) {
                    map[candidateCol] = "FRONT"
                }
            }
            if (backCandidate == null && headerRow.size >= 2) {
                val candidateCol = if (map[0] == "FRONT") 1 else 0
                if (candidateCol < headerRow.size) {
                    map[candidateCol] = "BACK"
                }
            }
        }

        return map
    }

    private fun getFileName(context: Context, uri: Uri): String {
        var result: String? = null
        if (uri.scheme == "content") {
            context.contentResolver.query(uri, null, null, null, null)?.use { cursor ->
                if (cursor.moveToFirst()) {
                    val index = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                    if (index >= 0) result = cursor.getString(index)
                }
            }
        }
        if (result == null) {
            result = uri.path
            val cut = result?.lastIndexOf('/') ?: -1
            if (cut != -1) result = result?.substring(cut + 1)
        }
        return result ?: "import.csv"
    }
}

