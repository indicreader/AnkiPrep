package com.example.flashcardapp.data

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import android.util.Log
import androidx.room.withTransaction
import com.example.flashcardapp.data.entities.CardEntity
import com.example.flashcardapp.data.entities.DeckEntity
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Imports flashcard decks from a CSV file.
 *
 * Expected CSV format (header optional):
 *   front,back[,tags]
 *   front;back[;tags]   (semicolon also supported)
 *   front\tback[\ttags] (tab also supported)
 *
 * The deck name is derived from the filename (without extension).
 * All cards are assigned to a single deck.
 * Rows with empty front OR empty back are silently skipped.
 */
object CsvImporter {
    private const val TAG = "CsvImporter"
    private const val BATCH_SIZE = 200

    /**
     * @param targetDeckId If non-null, cards are merged into this existing deck.
     *                     If null, a new deck is created from the filename.
     * @param targetDeckName Must be supplied when [targetDeckId] is non-null so that
     *                       the `deckHierarchy` field on each card is set correctly.
     */
    suspend fun importCsv(
        context: Context,
        uri: Uri,
        targetDeckId: Long? = null,
        targetDeckName: String? = null,
        duplicateStrategy: String = "UPDATE" // "SKIP", "IMPORT", "UPDATE"
    ): ImportResult = withContext(Dispatchers.IO) {
        val fileName = getFileName(context, uri)
        // Resolve the deck identity: merge into existing OR create new
        val deckId: Long
        val deckName: String
        if (targetDeckId != null && targetDeckName != null) {
            deckId = targetDeckId
            deckName = targetDeckName
            Log.i(TAG, "Merging CSV into existing deck: '$deckName' (id=$deckId)")
        } else {
            deckName = fileName.removeSuffix(".csv").removeSuffix(".CSV").trim()
                .ifEmpty { "Imported Deck" }
            deckId = deckName.hashCode().toLong().and(0x7FFFFFFF)
            Log.i(TAG, "Starting CSV import: $fileName → new deck '$deckName' (id=$deckId)")
        }

        try {
            val inputStream = context.contentResolver.openInputStream(uri)
                ?: throw IllegalArgumentException("Cannot open URI: $uri")

            val lines = mutableListOf<String>()
            BufferedReader(InputStreamReader(inputStream, Charsets.UTF_8)).use { reader ->
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    val trimmed = line!!.trim()
                    if (trimmed.isNotEmpty()) lines.add(trimmed)
                }
            }

            if (lines.isEmpty()) {
                return@withContext ImportResult(
                    success = false,
                    fileName = fileName,
                    totalDecks = 0,
                    totalNotes = 0,
                    totalCards = 0,
                    error = "CSV file is empty"
                )
            }

            // Auto-detect delimiter from first line
            val delimiter = detectDelimiter(lines.first())

            // Skip header row if it looks like one (i.e., first cells are non-numeric label words)
            val dataLines = if (looksLikeHeader(lines.first(), delimiter)) {
                Log.d(TAG, "Detected CSV header row, skipping: ${lines.first()}")
                lines.drop(1)
            } else {
                lines
            }

            if (dataLines.isEmpty()) {
                return@withContext ImportResult(
                    success = false,
                    fileName = fileName,
                    totalDecks = 0,
                    totalNotes = 0,
                    totalCards = 0,
                    error = "No data rows found after skipping header"
                )
            }

            // deckId is already resolved above (new or existing target)
            val timestamp = System.currentTimeMillis()

            // Fetch existing cards to handle duplicates
            val appDb = AppDatabase.getInstance(context)
            val existingCards = if (targetDeckId != null) appDb.cardDao().getCardsForDeckOnce(deckId) else emptyList()
            val existingFronts = existingCards.associateBy { it.front.trim().lowercase() }

            val cardsToUpdate = mutableListOf<CardEntity>()
            val cardsToInsert = mutableListOf<CardEntity>()
            val gson = Gson()

            for ((index, line) in dataLines.withIndex()) {
                val parts = splitCsvLine(line, delimiter)

                var tagsRaw = ""
                var front = ""
                var back = ""
                var tagsJson = "[]"

                if (parts.size >= 3) {
                    tagsRaw = parts[0].trim().trimQuotes()
                    front = parts[1].trim().trimQuotes()
                    back = parts[2].trim().trimQuotes()

                    if (parts.size >= 4) {
                        val explanation = parts[3].trim().trimQuotes()
                        if (explanation.isNotEmpty()) {
                            back = "$back {explain} $explanation"
                        }
                    }
                } else if (parts.size == 2) {
                    front = parts[0].trim().trimQuotes()
                    back = parts[1].trim().trimQuotes()
                }

                if (front.isEmpty() || back.isEmpty()) continue

                val tags = tagsRaw.split(",", " ").map { it.trim() }.filter { it.isNotEmpty() }
                tagsJson = gson.toJson(tags)

                // Stable card ID: deck hash XOR row index
                var cardId = (deckId xor index.toLong())

                // Duplicate Handling Strategy
                val frontKey = front.lowercase()
                val existing = existingFronts[frontKey]

                var isUpdate = false

                if (existing != null) {
                    when (duplicateStrategy) {
                        "SKIP" -> {
                            Log.d(TAG, "Skipping duplicate card: $front")
                            continue
                        }
                        "IMPORT" -> {
                            // Force import: generate a new unique ID
                            cardId = (deckId xor index.toLong() xor System.nanoTime())
                            Log.d(TAG, "Importing duplicate as new card: $front")
                        }
                        "UPDATE" -> {
                            // Overwrite existing
                            cardId = existing.id
                            isUpdate = true
                            Log.d(TAG, "Updating existing card: $front")
                        }
                    }
                } else if (targetDeckId != null) {
                    // To prevent ID collisions with previously imported CSV cards in the same deck,
                    // we generate a new unique ID for net-new cards.
                    cardId = (deckId xor index.toLong() xor System.nanoTime())
                }

                val newCard = CardEntity(
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
                
                if (isUpdate) {
                    cardsToUpdate.add(newCard)
                } else {
                    cardsToInsert.add(newCard)
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
                    error = "No valid flashcard rows found. Check that each row has at least two non-empty columns (front, back)."
                )
            }

            // Batch insert into Room
            appDb.withTransaction {
                if (targetDeckId == null) {
                    // Only upsert the deck entity when creating a new deck
                    val deckEntity = DeckEntity(
                        id = deckId,
                        name = deckName,
                        fullPath = deckName,
                        parentDeckId = null,
                        cardCount = totalProcessed,
                        lastSyncTimestamp = timestamp
                    )
                    appDb.deckDao().insertDecksIgnore(listOf(deckEntity))
                } else {
                    // Merging — update the existing deck's cardCount and sync timestamp
                    val existingDeck = appDb.deckDao().getDeckById(deckId)
                    if (existingDeck != null) {
                        appDb.deckDao().updateDeck(
                            existingDeck.copy(
                                cardCount = existingDeck.cardCount + cardsToInsert.size, // Only increase by new inserts
                                lastSyncTimestamp = timestamp
                            )
                        )
                    }
                }
                cardsToInsert.chunked(BATCH_SIZE).forEach { batch ->
                    appDb.cardDao().insertCardsIgnore(batch)
                }
                cardsToUpdate.chunked(BATCH_SIZE).forEach { batch ->
                    appDb.cardDao().updateCards(batch)
                }
            }

            Log.i(TAG, "CSV import complete. Deck='$deckName', Inserted=${cardsToInsert.size}, Updated=${cardsToUpdate.size}")

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

    /** Detect delimiter character from the first line. Prefers comma, then semicolon, then tab. */
    private fun detectDelimiter(firstLine: String): Char {
        val counts = mapOf(
            ',' to firstLine.count { it == ',' },
            ';' to firstLine.count { it == ';' },
            '\t' to firstLine.count { it == '\t' }
        )
        return counts.maxByOrNull { it.value }?.takeIf { it.value > 0 }?.key ?: ','
    }

    /**
     * Heuristic: first row is a header if the first two tokens are short alphabetic words
     * like "front", "back", "question", "answer", etc.
     */
    private fun looksLikeHeader(firstLine: String, delimiter: Char): Boolean {
        val parts = splitCsvLine(firstLine, delimiter)
        val headers = setOf("front", "back", "question", "answer", "term", "definition", "q", "a", "tags")
        val first = parts.getOrNull(0)?.trim()?.trimQuotes()?.lowercase() ?: return false
        return first in headers
    }

    /**
     * Splits a CSV line by delimiter, respecting double-quoted fields.
     */
    private fun splitCsvLine(line: String, delimiter: Char): List<String> {
        val result = mutableListOf<String>()
        val current = StringBuilder()
        var inQuotes = false
        var i = 0
        while (i < line.length) {
            val c = line[i]
            when {
                c == '"' && !inQuotes -> inQuotes = true
                c == '"' && inQuotes && i + 1 < line.length && line[i + 1] == '"' -> {
                    current.append('"'); i++ // escaped quote
                }
                c == '"' && inQuotes -> inQuotes = false
                c == delimiter && !inQuotes -> {
                    result.add(current.toString())
                    current.clear()
                }
                else -> current.append(c)
            }
            i++
        }
        result.add(current.toString())
        return result
    }

    private fun String.trimQuotes(): String {
        return if (length >= 2 && startsWith('"') && endsWith('"')) {
            substring(1, length - 1)
        } else this
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
