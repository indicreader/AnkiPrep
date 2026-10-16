package com.example.flashcardapp.data

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import android.util.JsonReader
import android.util.JsonToken
import android.util.Log
import androidx.room.withTransaction
import com.example.flashcardapp.data.entities.CardEntity
import com.example.flashcardapp.data.entities.DeckEntity
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStreamReader
import java.util.UUID

/**
 * High-performance streaming JSON question importer.
 *
 * Uses Android's low-overhead [JsonReader] to stream large JSON arrays (1,000+ items)
 * directly into atomic Room database batches on [Dispatchers.IO] without loading
 * full trees or strings into heap memory.
 *
 * Supported schemas:
 * 1. Root JSON Array of Question Objects:
 *    `[ { "question": "...", "answer": "...", "options": [...], "explanation": "..." }, ... ]`
 * 2. Root JSON Object with questions / cards array:
 *    `{ "deck": "Optional Name", "questions": [ { ... } ] }`
 */
object JsonImporter {
    private const val TAG = "JsonImporter"
    private const val BATCH_SIZE = 250

    suspend fun importJson(
        context: Context,
        uri: Uri,
        targetDeckId: Long? = null,
        targetDeckName: String? = null,
        duplicateStrategy: String = "UPDATE",
        onProgress: ((importedCount: Int, totalEstimate: Int) -> Unit)? = null
    ): ImportResult = withContext(Dispatchers.IO) {
        val repo = AnkiDataRepository.getInstance(context)
        val fileName = repo.getFileName(uri)
        val appDb = AppDatabase.getInstance(context)

        val defaultDeckName = fileName.removeSuffix(".json").removeSuffix(".JSON").trim().ifEmpty { "Imported JSON Deck" }
        var resolvedDeckName = targetDeckName ?: defaultDeckName
        val deckId = targetDeckId ?: kotlin.math.abs(UUID.randomUUID().mostSignificantBits)

        try {
            val timestamp = System.currentTimeMillis()
            val existingCards = if (targetDeckId != null) appDb.cardDao().getCardsForDeckOnce(deckId) else emptyList()
            val existingFronts = existingCards.associateBy { it.front.trim().lowercase() }

            val cardsToInsertBatch = mutableListOf<CardEntity>()
            val cardsToUpdateBatch = mutableListOf<CardEntity>()
            val sampleCardsCollected = mutableListOf<CardEntity>()
            var totalProcessed = 0
            var skippedCount = 0
            val gson = Gson()

            // Open stream directly via FileImportUtils
            com.example.flashcardapp.data.core.FileImportUtils.openBufferedReader(context, uri).use { bufferedReader ->
                val reader = JsonReader(bufferedReader)
                reader.isLenient = true

                if (reader.peek() == JsonToken.BEGIN_OBJECT) {
                    reader.beginObject()
                    while (reader.hasNext()) {
                        val name = reader.nextName()
                        if (name.equals("deck", ignoreCase = true) || name.equals("deckName", ignoreCase = true) || name.equals("name", ignoreCase = true)) {
                            if (targetDeckName == null && reader.peek() == JsonToken.STRING) {
                                resolvedDeckName = reader.nextString().trim().ifEmpty { defaultDeckName }
                            } else {
                                reader.skipValue()
                            }
                        } else if (name.equals("questions", ignoreCase = true) || name.equals("cards", ignoreCase = true) || name.equals("items", ignoreCase = true)) {
                            if (reader.peek() == JsonToken.BEGIN_ARRAY) {
                                streamQuestionArray(
                                    reader = reader,
                                    appDb = appDb,
                                    deckId = deckId,
                                    deckName = resolvedDeckName,
                                    existingFronts = existingFronts,
                                    duplicateStrategy = duplicateStrategy,
                                    timestamp = timestamp,
                                    targetDeckId = targetDeckId,
                                    gson = gson,
                                    cardsToInsertBatch = cardsToInsertBatch,
                                    cardsToUpdateBatch = cardsToUpdateBatch,
                                    sampleCardsCollected = sampleCardsCollected,
                                    onBatchFlush = { inserted, updated ->
                                        totalProcessed += (inserted + updated)
                                        onProgress?.invoke(totalProcessed, -1)
                                    },
                                    onSkip = { skippedCount++ }
                                )
                            } else {
                                reader.skipValue()
                            }
                        } else {
                            reader.skipValue()
                        }
                    }
                    reader.endObject()
                } else if (reader.peek() == JsonToken.BEGIN_ARRAY) {
                    streamQuestionArray(
                        reader = reader,
                        appDb = appDb,
                        deckId = deckId,
                        deckName = resolvedDeckName,
                        existingFronts = existingFronts,
                        duplicateStrategy = duplicateStrategy,
                        timestamp = timestamp,
                        targetDeckId = targetDeckId,
                        gson = gson,
                        cardsToInsertBatch = cardsToInsertBatch,
                        cardsToUpdateBatch = cardsToUpdateBatch,
                        sampleCardsCollected = sampleCardsCollected,
                        onBatchFlush = { inserted, updated ->
                            totalProcessed += (inserted + updated)
                            onProgress?.invoke(totalProcessed, -1)
                        },
                        onSkip = { skippedCount++ }
                    )
                } else {
                    return@withContext ImportResult(
                        success = false,
                        fileName = fileName,
                        totalDecks = 0,
                        totalNotes = 0,
                        totalCards = 0,
                        error = "JSON root must be an array of questions or an object with a questions array."
                    )
                }
            }

            // Flush any remaining cards in an atomic transaction
            if (cardsToInsertBatch.isNotEmpty() || cardsToUpdateBatch.isNotEmpty()) {
                val insertChunk = cardsToInsertBatch.toList()
                val updateChunk = cardsToUpdateBatch.toList()
                cardsToInsertBatch.clear()
                cardsToUpdateBatch.clear()

                appDb.withTransaction {
                    ensureDeckExists(appDb, deckId, resolvedDeckName, totalProcessed + insertChunk.size, timestamp)
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
                    error = "No valid flashcard questions found in JSON file ($skippedCount items skipped)."
                )
            }

            Log.i(TAG, "Streaming JSON import finished for '$resolvedDeckName'. Total: $totalProcessed, Skipped: $skippedCount")
            ImportResult(
                success = true,
                fileName = fileName,
                totalDecks = 1,
                totalNotes = totalProcessed,
                totalCards = totalProcessed,
                sampleCards = sampleCardsCollected
            )
        } catch (e: Exception) {
            Log.e(TAG, "Streaming JSON import error", e)
            ImportResult(
                success = false,
                fileName = fileName,
                totalDecks = 0,
                totalNotes = 0,
                totalCards = 0,
                error = e.message ?: "Unknown JSON error"
            )
        }
    }

    private suspend fun streamQuestionArray(
        reader: JsonReader,
        appDb: AppDatabase,
        deckId: Long,
        deckName: String,
        existingFronts: Map<String, CardEntity>,
        duplicateStrategy: String,
        timestamp: Long,
        targetDeckId: Long?,
        gson: Gson,
        cardsToInsertBatch: MutableList<CardEntity>,
        cardsToUpdateBatch: MutableList<CardEntity>,
        sampleCardsCollected: MutableList<CardEntity>,
        onBatchFlush: suspend (insertedCount: Int, updatedCount: Int) -> Unit,
        onSkip: () -> Unit
    ) {
        reader.beginArray()
        var questionIndex = 0

        while (reader.hasNext()) {
            if (reader.peek() != JsonToken.BEGIN_OBJECT) {
                reader.skipValue()
                onSkip()
                continue
            }

            questionIndex++
            var front = ""
            var answer = ""
            var explanation = ""
            var topic = ""
            var subtopic = ""
            val optionsList = mutableListOf<String>()
            val tagsList = mutableListOf<String>()

            reader.beginObject()
            while (reader.hasNext()) {
                val fieldName = reader.nextName().lowercase().trim()
                when (fieldName) {
                    "question", "front", "prompt", "q" -> {
                        front = readStringSafely(reader)
                    }
                    "answer", "back", "correct_answer", "correct_option", "key", "a" -> {
                        answer = readStringSafely(reader)
                    }
                    "explanation", "explain", "notes", "rationale", "sol", "solution" -> {
                        explanation = readStringSafely(reader)
                    }
                    "topic", "category", "subject" -> {
                        topic = readStringSafely(reader)
                    }
                    "subtopic", "sub_topic", "sub-topic" -> {
                        subtopic = readStringSafely(reader)
                    }
                    "options", "choices", "distractors" -> {
                        if (reader.peek() == JsonToken.BEGIN_ARRAY) {
                            reader.beginArray()
                            while (reader.hasNext()) {
                                val opt = readStringSafely(reader).trim()
                                if (opt.isNotEmpty()) optionsList.add(opt)
                            }
                            reader.endArray()
                        } else {
                            val optStr = readStringSafely(reader)
                            if (optStr.contains('|')) {
                                optionsList.addAll(optStr.split('|').map { it.trim() }.filter { it.isNotEmpty() })
                            } else if (optStr.isNotEmpty()) {
                                optionsList.add(optStr)
                            }
                        }
                    }
                    "tags" -> {
                        if (reader.peek() == JsonToken.BEGIN_ARRAY) {
                            reader.beginArray()
                            while (reader.hasNext()) {
                                val tag = readStringSafely(reader).trim()
                                if (tag.isNotEmpty()) tagsList.add(tag)
                            }
                            reader.endArray()
                        } else {
                            val tagStr = readStringSafely(reader)
                            tagsList.addAll(tagStr.split(Regex("[,;]")).map { it.trim() }.filter { it.isNotEmpty() })
                        }
                    }
                    else -> {
                        if (fieldName.startsWith("option_") || fieldName.startsWith("opt_")) {
                            val opt = readStringSafely(reader).trim()
                            if (opt.isNotEmpty()) optionsList.add(opt)
                        } else {
                            reader.skipValue()
                        }
                    }
                }
            }
            reader.endObject()

            if (front.isBlank() || answer.isBlank()) {
                onSkip()
                continue
            }

            // Resolve letter keys like "B" or "2" into matching option text if present
            var resolvedAnswer = answer.trim()
            val cleanKey = resolvedAnswer.uppercase().removePrefix("(").removeSuffix(")").removeSuffix(".").trim()
            if (cleanKey in listOf("A", "B", "C", "D", "1", "2", "3", "4") && optionsList.isNotEmpty()) {
                resolvedAnswer = when (cleanKey) {
                    "A", "1" -> optionsList.getOrNull(0) ?: answer
                    "B", "2" -> optionsList.getOrNull(1) ?: answer
                    "C", "3" -> optionsList.getOrNull(2) ?: answer
                    "D", "4" -> optionsList.getOrNull(3) ?: answer
                    else -> answer
                }
            }

            // Format MCQ back with distractors
            val distractors = optionsList.filter {
                !it.equals(resolvedAnswer, ignoreCase = true)
            }
            var back = if (distractors.isNotEmpty()) {
                "$resolvedAnswer | ${distractors.joinToString(" | ")}"
            } else {
                resolvedAnswer
            }
            if (explanation.isNotBlank()) {
                back = "$back {explain} ${explanation.trim()}"
            }

            if (topic.isNotBlank()) tagsList.add("topic:${topic.removePrefix("topic:").trim()}")
            if (subtopic.isNotBlank()) tagsList.add("subtopic:${subtopic.removePrefix("subtopic:").trim()}")
            val tagsJson = gson.toJson(tagsList.distinct())

            var cardId = kotlin.math.abs(UUID.randomUUID().mostSignificantBits)
            val frontKey = front.trim().lowercase()
            val existing = existingFronts[frontKey]
            var isUpdate = false

            if (existing != null) {
                when (duplicateStrategy) {
                    "SKIP" -> {
                        onSkip()
                        continue
                    }
                    "IMPORT" -> cardId = kotlin.math.abs(UUID.randomUUID().mostSignificantBits)
                    "UPDATE" -> {
                        cardId = existing.id
                        isUpdate = true
                    }
                }
            } else if (targetDeckId != null) {
                cardId = kotlin.math.abs(UUID.randomUUID().mostSignificantBits)
            }

            val card = CardEntity(
                id = cardId,
                noteId = cardId,
                deckId = deckId,
                subDeckId = null,
                front = front.trim(),
                back = back.trim(),
                tags = tagsJson,
                deckHierarchy = deckName,
                lastSyncTimestamp = timestamp
            )

            if (isUpdate) {
                cardsToUpdateBatch.add(card)
            } else {
                cardsToInsertBatch.add(card)
            }
            if (sampleCardsCollected.size < 6) {
                sampleCardsCollected.add(card)
            }

            // Flush chunk if threshold reached
            if (cardsToInsertBatch.size + cardsToUpdateBatch.size >= BATCH_SIZE) {
                val insertChunk = cardsToInsertBatch.toList()
                val updateChunk = cardsToUpdateBatch.toList()
                cardsToInsertBatch.clear()
                cardsToUpdateBatch.clear()

                appDb.withTransaction {
                    ensureDeckExists(appDb, deckId, deckName, insertChunk.size, timestamp)
                    if (insertChunk.isNotEmpty()) {
                        appDb.cardDao().insertCardsIgnore(insertChunk)
                    }
                    if (updateChunk.isNotEmpty()) {
                        appDb.cardDao().updateCards(updateChunk)
                    }
                }
                onBatchFlush(insertChunk.size, updateChunk.size)
            }
        }
        reader.endArray()
    }

    private fun readStringSafely(reader: JsonReader): String {
        return when (reader.peek()) {
            JsonToken.STRING, JsonToken.NUMBER -> reader.nextString()
            JsonToken.BOOLEAN -> reader.nextBoolean().toString()
            JsonToken.NULL -> {
                reader.nextNull()
                ""
            }
            else -> {
                reader.skipValue()
                ""
            }
        }
    }

    private suspend fun ensureDeckExists(
        appDb: AppDatabase,
        deckId: Long,
        deckName: String,
        countToAdd: Int,
        timestamp: Long
    ) {
        val existingDeck = appDb.deckDao().getDeckById(deckId)
        if (existingDeck == null) {
            val leafName = if (deckName.contains("::")) deckName.substringAfterLast("::") else deckName
            val deckEntity = DeckEntity(
                id = deckId,
                name = leafName,
                fullPath = deckName,
                parentDeckId = null,
                cardCount = countToAdd,
                lastSyncTimestamp = timestamp
            )
            appDb.deckDao().insertDecksIgnore(listOf(deckEntity))
        } else {
            appDb.deckDao().updateDeck(
                existingDeck.copy(
                    cardCount = existingDeck.cardCount + countToAdd,
                    lastSyncTimestamp = timestamp
                )
            )
        }
    }
}
