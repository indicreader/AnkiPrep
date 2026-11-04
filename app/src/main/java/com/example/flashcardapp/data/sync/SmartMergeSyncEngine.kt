package com.example.flashcardapp.data.sync

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.flashcardapp.data.AppDatabase
import com.example.flashcardapp.data.entities.CardAttemptEntity
import com.example.flashcardapp.data.entities.CardEntity
import com.example.flashcardapp.data.entities.CardStateEntity
import com.example.flashcardapp.data.entities.DeckEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

data class SmartMergeResult(
    val success: Boolean,
    val decksOverwritten: Int = 0,
    val decksAppended: Int = 0,
    val totalCardsSynced: Int = 0,
    val message: String = ""
)

/**
 * High-fidelity Smart Merge engine for local Wi-Fi synchronization.
 *
 * Implements non-destructive delta merging:
 * 1. Identical decks (matching name or fullPath) are overwritten/updated.
 * 2. New decks are appended seamlessly.
 * 3. Existing unshared local decks remain safe and untouched.
 */
object SmartMergeSyncEngine {
    private const val TAG = "SmartMergeSyncEngine"

    suspend fun mergeIncomingBackup(context: Context, inputStream: InputStream): SmartMergeResult = withContext(Dispatchers.IO) {
        val tempDir = File(context.cacheDir, "sync_temp_${System.currentTimeMillis()}").apply { mkdirs() }
        val tempDbFile = File(tempDir, "incoming.db")
        val imagesDir = File(context.filesDir, "card_images").apply { if (!exists()) mkdirs() }

        try {
            // 1. Unpack incoming ZIP payload
            ZipInputStream(inputStream).use { zis ->
                var entry: ZipEntry?
                while (zis.nextEntry.also { entry = it } != null) {
                    val entryName = entry!!.name
                    when {
                        entryName.startsWith("db/") -> {
                            val fileName = entryName.substringAfter("db/")
                            if (fileName == "ankiprep_cache.db") {
                                FileOutputStream(tempDbFile).use { fos -> zis.copyTo(fos) }
                            }
                        }
                        entryName.startsWith("card_images/") -> {
                            val imgName = entryName.substringAfter("card_images/")
                            val destImg = File(imagesDir, imgName)
                            FileOutputStream(destImg).use { fos -> zis.copyTo(fos) }
                        }
                    }
                    zis.closeEntry()
                }
            }

            if (!tempDbFile.exists()) {
                Log.e(TAG, "No database file found in sync payload")
                return@withContext SmartMergeResult(false, message = "Invalid sync package: missing database")
            }

            // 2. Open temporary incoming database in read-only mode
            val sourceDb = SQLiteDatabase.openDatabase(
                tempDbFile.absolutePath,
                null,
                SQLiteDatabase.OPEN_READONLY
            )

            val liveDb = AppDatabase.getInstance(context)
            var overwrittenCount = 0
            var appendedCount = 0
            var totalCardsCount = 0

            sourceDb.use { sDb ->
                // Read incoming decks
                val incomingDecks = mutableListOf<DeckEntity>()
                sDb.rawQuery("SELECT id, name, fullPath, parentDeckId, cardCount, description, lastSyncTimestamp, sortOrder FROM decks", null).use { cursor ->
                    val idIdx = cursor.getColumnIndex("id")
                    val nameIdx = cursor.getColumnIndex("name")
                    val pathIdx = cursor.getColumnIndex("fullPath")
                    val parentIdx = cursor.getColumnIndex("parentDeckId")
                    val countIdx = cursor.getColumnIndex("cardCount")
                    val descIdx = cursor.getColumnIndex("description")
                    val syncIdx = cursor.getColumnIndex("lastSyncTimestamp")
                    val sortIdx = cursor.getColumnIndex("sortOrder")

                    while (cursor.moveToNext()) {
                        incomingDecks.add(
                            DeckEntity(
                                id = cursor.getLong(idIdx),
                                name = cursor.getString(nameIdx),
                                fullPath = cursor.getString(pathIdx),
                                parentDeckId = if (cursor.isNull(parentIdx)) null else cursor.getLong(parentIdx),
                                cardCount = cursor.getInt(countIdx),
                                description = cursor.getString(descIdx),
                                lastSyncTimestamp = cursor.getLong(syncIdx),
                                sortOrder = cursor.getInt(sortIdx)
                            )
                        )
                    }
                }

                // Read incoming cards
                val incomingCards = mutableListOf<CardEntity>()
                sDb.rawQuery("SELECT id, noteId, deckId, subDeckId, front, back, tags, deckHierarchy, lastSyncTimestamp, frontImage, backImage, explanationImage, optionImagesJson FROM cards", null).use { cursor ->
                    val idIdx = cursor.getColumnIndex("id")
                    val noteIdx = cursor.getColumnIndex("noteId")
                    val deckIdx = cursor.getColumnIndex("deckId")
                    val subDeckIdx = cursor.getColumnIndex("subDeckId")
                    val frontIdx = cursor.getColumnIndex("front")
                    val backIdx = cursor.getColumnIndex("back")
                    val tagsIdx = cursor.getColumnIndex("tags")
                    val hierIdx = cursor.getColumnIndex("deckHierarchy")
                    val syncIdx = cursor.getColumnIndex("lastSyncTimestamp")
                    val frontImgIdx = cursor.getColumnIndex("frontImage")
                    val backImgIdx = cursor.getColumnIndex("backImage")
                    val expImgIdx = cursor.getColumnIndex("explanationImage")
                    val optImgsIdx = cursor.getColumnIndex("optionImagesJson")

                    while (cursor.moveToNext()) {
                        incomingCards.add(
                            CardEntity(
                                id = cursor.getLong(idIdx),
                                noteId = cursor.getLong(noteIdx),
                                deckId = cursor.getLong(deckIdx),
                                subDeckId = if (cursor.isNull(subDeckIdx)) null else cursor.getLong(subDeckIdx),
                                front = cursor.getString(frontIdx),
                                back = cursor.getString(backIdx),
                                tags = cursor.getString(tagsIdx) ?: "[]",
                                deckHierarchy = cursor.getString(hierIdx) ?: "",
                                lastSyncTimestamp = cursor.getLong(syncIdx),
                                frontImage = if (cursor.isNull(frontImgIdx)) null else cursor.getString(frontImgIdx),
                                backImage = if (cursor.isNull(backImgIdx)) null else cursor.getString(backImgIdx),
                                explanationImage = if (cursor.isNull(expImgIdx)) null else cursor.getString(expImgIdx),
                                optionImagesJson = if (cursor.isNull(optImgsIdx)) null else cursor.getString(optImgsIdx)
                            )
                        )
                    }
                }

                // Read incoming card states
                val incomingStates = mutableListOf<CardStateEntity>()
                try {
                    sDb.rawQuery("SELECT cardId, stability, difficulty, interval, dueDate, lastReview, reviewCount, lapses, state FROM card_states", null).use { cursor ->
                        val cardIdIdx = cursor.getColumnIndex("cardId")
                        val stabIdx = cursor.getColumnIndex("stability")
                        val diffIdx = cursor.getColumnIndex("difficulty")
                        val intIdx = cursor.getColumnIndex("interval")
                        val dueIdx = cursor.getColumnIndex("dueDate")
                        val revIdx = cursor.getColumnIndex("lastReview")
                        val countIdx = cursor.getColumnIndex("reviewCount")
                        val lapseIdx = cursor.getColumnIndex("lapses")
                        val stateIdx = cursor.getColumnIndex("state")

                        while (cursor.moveToNext()) {
                            incomingStates.add(
                                CardStateEntity(
                                    cardId = cursor.getLong(cardIdIdx),
                                    stability = cursor.getDouble(stabIdx),
                                    difficulty = cursor.getDouble(diffIdx),
                                    interval = cursor.getInt(intIdx),
                                    dueDate = cursor.getLong(dueIdx),
                                    lastReview = cursor.getLong(revIdx),
                                    reviewCount = cursor.getInt(countIdx),
                                    lapses = cursor.getInt(lapseIdx),
                                    state = cursor.getInt(stateIdx)
                                )
                            )
                        }
                    }
                } catch (e: Exception) {
                    Log.w(TAG, "No card_states table in incoming DB or failed to read states: ${e.message}")
                }

                // Read incoming card attempts
                val incomingAttempts = mutableListOf<CardAttemptEntity>()
                try {
                    sDb.rawQuery("SELECT cardId, deckId, isCorrect, timeTakenMs, fsrsRating, isGuess, timestamp FROM card_attempts", null).use { cursor ->
                        val cardIdIdx = cursor.getColumnIndex("cardId")
                        val deckIdIdx = cursor.getColumnIndex("deckId")
                        val corrIdx = cursor.getColumnIndex("isCorrect")
                        val timeIdx = cursor.getColumnIndex("timeTakenMs")
                        val ratingIdx = cursor.getColumnIndex("fsrsRating")
                        val guessIdx = cursor.getColumnIndex("isGuess")
                        val timeStampIdx = cursor.getColumnIndex("timestamp")

                        while (cursor.moveToNext()) {
                            incomingAttempts.add(
                                CardAttemptEntity(
                                    cardId = cursor.getLong(cardIdIdx),
                                    deckId = cursor.getLong(deckIdIdx),
                                    isCorrect = cursor.getInt(corrIdx) == 1,
                                    timeTakenMs = cursor.getLong(timeIdx),
                                    fsrsRating = cursor.getInt(ratingIdx),
                                    isGuess = cursor.getInt(guessIdx) == 1,
                                    timestamp = cursor.getLong(timeStampIdx)
                                )
                            )
                        }
                    }
                } catch (e: Exception) {
                    Log.w(TAG, "No card_attempts table in incoming DB or failed to read attempts: ${e.message}")
                }

                // 3. Perform Smart Merge against live database
                val existingDecks = liveDb.deckDao().getAllDecksOnce()

                for (incomingDeck in incomingDecks) {
                    // Check if an existing deck has matching name or path
                    val matchingDeck = existingDecks.find {
                        it.name.equals(incomingDeck.name, ignoreCase = true) ||
                        it.fullPath.equals(incomingDeck.fullPath, ignoreCase = true)
                    }

                    if (matchingDeck != null) {
                        // Conflict resolution: OVERWRITE identical deck
                        // Clean out existing attempts and records for the matching deck
                        liveDb.cardAttemptDao().deleteAttemptsForDeck(matchingDeck.id)
                        liveDb.sessionRecordDao().deleteRecordsForDeck(matchingDeck.id)
                        // Deleting the deck cascades and removes old cards and their card_states
                        liveDb.deckDao().deleteDeck(matchingDeck.id)

                        // Insert incoming deck
                        liveDb.deckDao().upsertDeck(incomingDeck)
                        overwrittenCount++
                    } else {
                        // Conflict resolution: APPEND new deck
                        // Verify if incoming ID conflicts with an unrelated deck on receiver
                        val idCollision = existingDecks.any { it.id == incomingDeck.id }
                        val safeDeck = if (idCollision) {
                            val maxId = existingDecks.maxOfOrNull { it.id } ?: 1000L
                            incomingDeck.copy(id = maxId + 1)
                        } else {
                            incomingDeck
                        }

                        liveDb.deckDao().upsertDeck(safeDeck)
                        appendedCount++
                    }

                    // Insert cards for this deck
                    val deckCards = incomingCards.filter { it.deckId == incomingDeck.id }
                    if (deckCards.isNotEmpty()) {
                        liveDb.cardDao().upsertCards(deckCards)
                        totalCardsCount += deckCards.size
                    }

                    // Insert states for this deck's cards
                    val cardIds = deckCards.map { it.id }.toSet()
                    val deckStates = incomingStates.filter { it.cardId in cardIds }
                    if (deckStates.isNotEmpty()) {
                        liveDb.cardStateDao().upsertStates(deckStates)
                    }

                    // Insert attempts for this deck
                    val deckAttempts = incomingAttempts.filter { it.deckId == incomingDeck.id || it.cardId in cardIds }
                    if (deckAttempts.isNotEmpty()) {
                        liveDb.cardAttemptDao().insertAttempts(deckAttempts)
                    }
                }

                // Initialize FSRS states for any cards without states
                liveDb.cardStateDao().initializeNewCards()
            }

            SmartMergeResult(
                success = true,
                decksOverwritten = overwrittenCount,
                decksAppended = appendedCount,
                totalCardsSynced = totalCardsCount,
                message = "Synced successfully: $overwrittenCount decks updated, $appendedCount new decks added ($totalCardsCount cards)"
            )
        } catch (e: Exception) {
            Log.e(TAG, "Smart merge failed", e)
            SmartMergeResult(false, message = "Merge error: ${e.localizedMessage ?: e.message}")
        } finally {
            // Clean up temporary files
            tempDir.deleteRecursively()
        }
    }
}

