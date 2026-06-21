package com.example.flashcardapp.data

import android.content.Context
import android.util.Log
import androidx.room.withTransaction
import com.example.flashcardapp.data.dao.CardDao
import com.example.flashcardapp.data.dao.DeckDao
import com.example.flashcardapp.data.entities.CardEntity
import com.example.flashcardapp.data.entities.DeckEntity
import com.google.gson.Gson
import com.example.flashcardapp.data.EpubImporter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.withContext
import android.net.Uri

import com.example.flashcardapp.data.dao.SessionRecordDao
import com.example.flashcardapp.data.entities.SessionRecordEntity
import com.example.flashcardapp.data.dao.CardOverrideDao
import com.example.flashcardapp.data.entities.CardOverrideEntity
import com.example.flashcardapp.data.dao.CardAttemptDao
import com.example.flashcardapp.data.entities.CardAttemptEntity
import com.example.flashcardapp.data.dao.CardStateDao
import com.example.flashcardapp.fsrs.FsrsScheduler

/**
 * Repository that orchestrates the data flow:
 *   AnkiDroid Content Provider → Normalization → Room Cache
 *
 * This is the single entry point for all data operations in the app.
 * Consumers (ViewModels, engines) interact with this repository only.
 *
 * Sync strategy:
 * - [syncFromAnkiDroid] pulls fresh data from AnkiDroid and upserts into Room
 * - All read operations return data from Room (single source of truth)
 * - Mock data is used transparently when AnkiDroid is unavailable
 */
import com.example.flashcardapp.data.dao.AliasDao
import com.example.flashcardapp.data.entities.AliasEntity
import java.io.BufferedReader
import java.io.InputStreamReader

class AnkiDataRepository(
    private val context: Context,
    private val deckDao: DeckDao,
    private val cardDao: CardDao,
    private val sessionRecordDao: SessionRecordDao,
    private val cardOverrideDao: CardOverrideDao,
    private val cardAttemptDao: CardAttemptDao,
    val cardStateDao: CardStateDao,
    val aliasDao: AliasDao
) {
    private val gson = Gson()
    val fsrsScheduler = FsrsScheduler(cardStateDao)

    companion object {
        private const val TAG = "AnkiDataRepository"

        @Volatile
        private var INSTANCE: AnkiDataRepository? = null

        fun getInstance(context: Context): AnkiDataRepository {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: run {
                    val db = AppDatabase.getInstance(context)
                    AnkiDataRepository(
                        context = context.applicationContext,
                        deckDao = db.deckDao(),
                        cardDao = db.cardDao(),
                        sessionRecordDao = db.sessionRecordDao(),
                        cardOverrideDao = db.cardOverrideDao(),
                        cardAttemptDao = db.cardAttemptDao(),
                        cardStateDao = db.cardStateDao(),
                        aliasDao = db.aliasDao()
                    ).also { INSTANCE = it }
                }
            }
        }
    }


    // ========================================================================
    // Sync: AnkiDroid → Room
    // ========================================================================

    /**
     * Full sync from AnkiDroid content provider to local Room cache.
     *
     * Steps:
     * 1. Fetch all decks from AnkiDroid
     * 2. Build deck hierarchy (resolve parent/child relationships)
     * 3. Upsert decks into Room
     * 4. For each deck, fetch cards with tags
     * 5. Normalize cards into [CardEntity] format
     * 6. Upsert cards into Room
     *
     * This is idempotent — safe to call multiple times.
     *
     * @return [SyncResult] with counts and status
     */
    suspend fun syncFromAnkiDroid(): SyncResult = withContext(Dispatchers.IO) {
        Log.d(TAG, "━━━ Starting AnkiDroid sync ━━━")
        val startTime = System.currentTimeMillis()

        try {
            // Step 1: Fetch decks
            val rawDecks = AnkiDroidBridge.getDecks(context)
            Log.d(TAG, "Fetched ${rawDecks.size} raw decks from AnkiDroid")

            if (rawDecks.isEmpty()) {
                Log.w(TAG, "No decks found — aborting sync")
                return@withContext SyncResult(
                    success = false,
                    totalDecks = 0,
                    totalCards = 0,
                    durationMs = System.currentTimeMillis() - startTime,
                    error = "No decks found in AnkiDroid"
                )
            }

            // Step 2: Build deck hierarchy
            val existingDecksMap = deckDao.getAllDecksOnce().associateBy { it.id }
            val deckPaths = mutableMapOf<Long, String>()
            val deckNames = mutableMapOf<Long, String>()
            for (deck in rawDecks) {
                val existing = existingDecksMap[deck.id]
                if (existing != null) {
                    deckPaths[deck.id] = existing.fullPath
                    deckNames[deck.id] = existing.name
                } else {
                    val hierarchy = AnkiDroidBridge.parseDeckHierarchy(deck.name)
                    deckPaths[deck.id] = deck.name
                    deckNames[deck.id] = hierarchy.lastOrNull() ?: deck.name
                }
            }

            val deckPathToId = deckPaths.entries.associate { it.value to it.key }
            val deckEntities = rawDecks.map { deck ->
                val resolvedPath = deckPaths[deck.id]!!
                val resolvedName = deckNames[deck.id]!!
                val parentPath = AnkiDroidBridge.getParentDeckPath(resolvedPath)
                val parentId = parentPath?.let { deckPathToId[it] }

                DeckEntity(
                    id = deck.id,
                    name = resolvedName,
                    fullPath = resolvedPath,
                    parentDeckId = parentId,
                    cardCount = 0, // Updated after card sync
                    lastSyncTimestamp = System.currentTimeMillis()
                )
            }

            // Step 3: Upsert decks
            deckDao.upsertDecks(deckEntities)
            Log.d(TAG, "Upserted ${deckEntities.size} decks into Room")

            // Step 4 & 5: Fetch and normalize cards for each deck
            var totalCards = 0
            for (deck in rawDecks) {
                val rawCards = AnkiDroidBridge.getCardsAndNotesForDeck(context, deck.id)
                if (rawCards.isEmpty()) {
                    Log.d(TAG, "  Deck '${deck.name}': 0 cards (empty deck — skipping)")
                    continue
                }

                val resolvedPath = deckPaths[deck.id]!!
                val cardEntities = rawCards.map { card ->
                    CardEntity(
                        id = card.cardId,
                        noteId = card.noteId,
                        deckId = deck.id,
                        subDeckId = resolveSubDeckId(resolvedPath, deckPathToId),
                        front = card.front,
                        back = card.back,
                        tags = gson.toJson(card.tags),
                        deckHierarchy = resolvedPath,
                        lastSyncTimestamp = System.currentTimeMillis()
                    )
                }

                // Step 6: Upsert cards
                cardDao.upsertCards(cardEntities)
                totalCards += cardEntities.size
                Log.d(TAG, "  Deck '${resolvedPath}': ${cardEntities.size} cards cached")

                // Update card count on deck
                deckDao.upsertDeck(
                    deckEntities.first { it.id == deck.id }.copy(cardCount = cardEntities.size)
                )
            }

            val duration = System.currentTimeMillis() - startTime
            Log.d(TAG, "━━━ Sync complete: $totalCards cards across ${deckEntities.size} decks in ${duration}ms ━━━")

            // Initialize FSRS states for any new cards
            fsrsScheduler.initializeNewCards()

            SyncResult(
                success = true,
                totalDecks = deckEntities.size,
                totalCards = totalCards,
                durationMs = duration
            )
        } catch (e: Exception) {
            val duration = System.currentTimeMillis() - startTime
            Log.e(TAG, "Sync failed after ${duration}ms", e)
            SyncResult(
                success = false,
                totalDecks = 0,
                totalCards = 0,
                durationMs = duration,
                error = e.message ?: "Unknown error"
            )
        }
    }

    /**
     * Resolves the subdeck ID for a card based on its deck hierarchy.
     *
     * If the deck name contains '::', the subdeck is the immediate leaf deck.
     * For root-level decks, returns null.
     */
    private fun resolveSubDeckId(deckPath: String, deckPathToId: Map<String, Long>): Long? {
        val segments = AnkiDroidBridge.parseDeckHierarchy(deckPath)
        return if (segments.size > 1) {
            deckPathToId[deckPath] // The leaf deck itself is the subdeck
        } else {
            null
        }
    }

    // ========================================================================
    // Read Operations (from Room cache)
    // ========================================================================

    /** Reactive stream of all cached decks, ordered by hierarchy path. */
    fun observeDecks(): Flow<List<DeckEntity>> = deckDao.getAllDecks()

    /** One-shot fetch of all cached decks. */
    suspend fun getAllDecks(): List<DeckEntity> = withContext(Dispatchers.IO) {
        deckDao.getAllDecksOnce()
    }

    /** One-shot fetch of root-level decks (no parent). */
    suspend fun getRootDecks(): List<DeckEntity> = withContext(Dispatchers.IO) {
        deckDao.getRootDecks()
    }

    /** One-shot fetch of sub-decks for a parent deck. */
    suspend fun getSubDecks(parentDeckId: Long): List<DeckEntity> = withContext(Dispatchers.IO) {
        deckDao.getSubDecks(parentDeckId)
    }

    /** Reactive stream of cards for a specific deck, merging local overrides. */
    fun observeCardsForDeck(deckId: Long): Flow<List<CardEntity>> {
        return cardDao.getCardsForDeck(deckId).combine(cardOverrideDao.observeAllOverrides()) { cards, overrides ->
            val overrideMap = overrides.associateBy { it.cardId }
            if (overrideMap.isEmpty()) cards
            else cards.map { card ->
                val override = overrideMap[card.id]
                if (override != null) {
                    card.copy(
                        front = override.frontOverride,
                        back = override.backOverride,
                        tags = override.tagsOverride ?: card.tags,
                        frontImage = override.frontImageOverride ?: card.frontImage,
                        backImage = override.backImageOverride ?: card.backImage,
                        explanationImage = override.explanationImageOverride ?: card.explanationImage,
                        optionImagesJson = override.optionImagesOverrideJson ?: card.optionImagesJson
                    )
                } else {
                    card
                }
            }
        }
    }

    /** One-shot fetch of cards for a specific deck, merging local overrides. */
    suspend fun getCardsForDeck(deckId: Long): List<CardEntity> = withContext(Dispatchers.IO) {
        applyOverrides(cardDao.getCardsForDeckOnce(deckId))
    }

    /** One-shot fetch of all cached cards, merging local overrides. */
    suspend fun getAllCards(): List<CardEntity> = withContext(Dispatchers.IO) {
        applyOverrides(cardDao.getAllCardsOnce())
    }

    /** One-shot fetch of cards for a specific hierarchy, merging local overrides. */
    suspend fun getCardsForHierarchy(rootPath: String): List<CardEntity> = withContext(Dispatchers.IO) {
        applyOverrides(cardDao.getCardsForRootHierarchyOnce(rootPath, "$rootPath::%"))
    }

    /** Sample cards for debug output, merging local overrides. */
    suspend fun getSampleCards(limit: Int = 5): List<CardEntity> = withContext(Dispatchers.IO) {
        applyOverrides(cardDao.getSampleCardsGlobal(limit))
    }

    /** Helper to apply local overrides to a list of CardEntities. */
    private suspend fun applyOverrides(cards: List<CardEntity>): List<CardEntity> {
        val overrides = cardOverrideDao.getAllOverridesOnce().associateBy { it.cardId }
        if (overrides.isEmpty()) return cards
        return cards.map { card ->
            val override = overrides[card.id]
            if (override != null) {
                card.copy(
                    front = override.frontOverride,
                    back = override.backOverride,
                    tags = override.tagsOverride ?: card.tags,
                    frontImage = override.frontImageOverride ?: card.frontImage,
                    backImage = override.backImageOverride ?: card.backImage,
                    explanationImage = override.explanationImageOverride ?: card.explanationImage,
                    optionImagesJson = override.optionImagesOverrideJson ?: card.optionImagesJson
                )
            } else {
                card
            }
        }
    }

    // ========================================================================
    // Card Override CRUD Operations
    // ========================================================================

    suspend fun getOverrideForCard(cardId: Long): CardOverrideEntity? = withContext(Dispatchers.IO) {
        cardOverrideDao.getOverrideForCard(cardId)
    }

    suspend fun getCardById(cardId: Long): CardEntity? = withContext(Dispatchers.IO) {
        val card = cardDao.getCardById(cardId) ?: return@withContext null
        val override = cardOverrideDao.getOverrideForCard(cardId)
        if (override != null) {
            card.copy(
                front = override.frontOverride,
                back = override.backOverride,
                tags = override.tagsOverride ?: card.tags,
                frontImage = override.frontImageOverride ?: card.frontImage,
                backImage = override.backImageOverride ?: card.backImage,
                explanationImage = override.explanationImageOverride ?: card.explanationImage,
                optionImagesJson = override.optionImagesOverrideJson ?: card.optionImagesJson
            )
        } else {
            card
        }
    }

    fun observeOverrideForCard(cardId: Long): Flow<CardOverrideEntity?> {
        return cardOverrideDao.observeOverrideForCard(cardId)
    }

    suspend fun upsertOverride(override: CardOverrideEntity) = withContext(Dispatchers.IO) {
        cardOverrideDao.upsertOverride(override)
        val card = cardDao.getCardById(override.cardId)
        if (card != null) {
            val updatedCard = card.copy(
                front = override.frontOverride,
                back = override.backOverride,
                tags = override.tagsOverride ?: card.tags,
                lastSyncTimestamp = System.currentTimeMillis(),
                frontImage = override.frontImageOverride,
                backImage = override.backImageOverride,
                explanationImage = override.explanationImageOverride,
                optionImagesJson = override.optionImagesOverrideJson
            )
            cardDao.insertCard(updatedCard)
        }
        Log.d(TAG, "Upserted card override and updated card ID: ${override.cardId}")
    }

    suspend fun deleteOverride(cardId: Long) = withContext(Dispatchers.IO) {
        cardOverrideDao.deleteOverride(cardId)
        Log.d(TAG, "Deleted card override for card ID: $cardId")
    }


    /** Total cached deck count. */
    suspend fun getDeckCount(): Int = withContext(Dispatchers.IO) {
        deckDao.getDeckCount()
    }

    /** Total cached card count. */
    suspend fun getCardCount(): Int = withContext(Dispatchers.IO) {
        cardDao.getCardCount()
    }

    /** Parse tags JSON string back to List<String>. */
    fun parseTags(tagsJson: String): List<String> {
        return try {
            val type = object : com.google.gson.reflect.TypeToken<List<String>>() {}.type
            gson.fromJson<List<String>>(tagsJson, type) ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    /** Exports a deck to .apkg format. */
    suspend fun exportApkg(deckId: Long, deckName: String, uri: Uri): Boolean {
        val cards = getCardsForDeck(deckId)
        return ApkgExporter.exportDeck(context, deckId, deckName, cards, uri)
    }

    /** Imports a local .apkg file into the Room database. */
    suspend fun importApkg(
        uri: Uri,
        targetDeckId: Long? = null,
        targetDeckName: String? = null
    ): ImportResult {
        val result = ApkgImporter.importApkg(context, uri, targetDeckId, targetDeckName)
        if (result.success) {
            fsrsScheduler.initializeNewCards()
        }
        return result
    }

    /** Imports a local .epub file into the Room database. */
    suspend fun importEpub(
        uri: Uri,
        targetDeckId: Long? = null,
        targetDeckName: String? = null
    ): ImportResult {
        val result = EpubImporter.importEpub(context, uri, targetDeckId, targetDeckName)
        if (result.success) {
            fsrsScheduler.initializeNewCards()
        }
        return result
    }

    /** Imports a .csv flashcard file into the Room database as a new deck. */
    suspend fun importCsv(uri: Uri, duplicateStrategy: String = "UPDATE"): ImportResult {
        val result = CsvImporter.importCsv(context, uri, duplicateStrategy = duplicateStrategy)
        if (result.success) {
            fsrsScheduler.initializeNewCards()
        }
        return result
    }

    /**
     * Merges a .csv flashcard file into an EXISTING deck.
     *
     * Cards are assigned [targetDeckId]/[targetDeckName] instead of creating a new deck.
     * Duplicate card IDs (same front+back position) will be overwritten via upsert.
     */
    suspend fun importCsvIntoExistingDeck(
        uri: Uri,
        targetDeckId: Long,
        targetDeckName: String,
        duplicateStrategy: String = "UPDATE"
    ): ImportResult {
        val result = CsvImporter.importCsv(context, uri, targetDeckId, targetDeckName, duplicateStrategy)
        if (result.success) {
            fsrsScheduler.initializeNewCards()
        }
        return result
    }

    /** Resolves the filename of a URI. */
    fun getFileName(uri: Uri): String {
        var result: String? = null
        if (uri.scheme == "content") {
            context.contentResolver.query(uri, null, null, null, null)?.use { cursor ->
                if (cursor.moveToFirst()) {
                    val index = cursor.getColumnIndex(android.provider.OpenableColumns.DISPLAY_NAME)
                    if (index >= 0) result = cursor.getString(index)
                }
            }
        }
        if (result == null) {
            result = uri.path
            val cut = result?.lastIndexOf('/') ?: -1
            if (cut != -1) result = result?.substring(cut + 1)
        }
        return result ?: "import_file"
    }

    /** Imports a file, auto-detecting APKG, CSV, or EPUB based on filename. */
    suspend fun importFile(uri: Uri): ImportResult {
        val fileName = getFileName(uri).lowercase()
        return if (fileName.endsWith(".csv") || fileName.endsWith(".txt")) {
            importCsv(uri)
        } else if (fileName.endsWith(".epub")) {
            EpubImporter.importEpub(context, uri)
        } else {
            importApkg(uri)
        }
    }


    // ========================================================================
    // Session Statistics & History
    // ========================================================================

    /** Saves a completed quiz/study session record. */
    suspend fun saveSessionRecord(record: SessionRecordEntity): Long = withContext(Dispatchers.IO) {
        Log.d(TAG, "Saving session record for deck ${record.deckName} (score: ${record.score}/${record.totalQuestions})")
        sessionRecordDao.insertRecord(record)
    }

    /** Reactive stream of all completed session records. */
    fun observeSessionRecords(): Flow<List<SessionRecordEntity>> = sessionRecordDao.getAllRecordsFlow()

    /** One-shot fetch of all session records. */
    suspend fun getSessionRecords(): List<SessionRecordEntity> = withContext(Dispatchers.IO) {
        sessionRecordDao.getAllRecords()
    }

    /** Saves a list of card attempts. */
    suspend fun saveCardAttempts(attempts: List<CardAttemptEntity>) = withContext(Dispatchers.IO) {
        cardAttemptDao.insertAttempts(attempts)
    }

    /** One-shot fetch of all card attempts. */
    suspend fun getAllCardAttempts(): List<CardAttemptEntity> = withContext(Dispatchers.IO) {
        cardAttemptDao.getAllAttempts()
    }

    /** Total number of sessions completed. */
    suspend fun getSessionCount(): Int = withContext(Dispatchers.IO) {
        sessionRecordDao.getSessionCount()
    }

    /** Total questions answered across all sessions. */
    suspend fun getTotalQuestionsAnswered(): Int = withContext(Dispatchers.IO) {
        sessionRecordDao.getTotalQuestionsAnswered() ?: 0
    }

    /** Total correct answers across all sessions. */
    suspend fun getTotalCorrectAnswers(): Int = withContext(Dispatchers.IO) {
        sessionRecordDao.getTotalCorrectAnswers() ?: 0
    }

    /** Total practice sessions completed. */
    suspend fun getPracticeSessionCount(): Int = withContext(Dispatchers.IO) {
        sessionRecordDao.getPracticeSessionCount()
    }

    /** Total revision sessions completed. */
    suspend fun getRevisionSessionCount(): Int = withContext(Dispatchers.IO) {
        sessionRecordDao.getRevisionSessionCount()
    }

    /** Total test sessions completed. */
    suspend fun getTestSessionCount(): Int = withContext(Dispatchers.IO) {
        sessionRecordDao.getTestSessionCount()
    }

    // ========================================================================
    // Cache Management
    // ========================================================================

    /** Deletes a deck, its subdecks, and all their associated cards from the database cache. */
    suspend fun deleteDeck(deckId: Long): Unit = withContext(Dispatchers.IO) {
        Log.d(TAG, "Deleting deck with ID $deckId and its subdecks/cards")
        val subDecks = deckDao.getSubDecks(deckId)
        for (subDeck in subDecks) {
            deleteDeck(subDeck.id)
        }
        
        // Image cleanup if policy is set
        val deleteImages = SettingsRepository.getInstance(context).deleteImagesOnCardDelete
        if (deleteImages) {
            val cards = cardDao.getCardsForDeckOnce(deckId)
            cards.forEach { card ->
                suspend fun safeDelete(path: String) {
                    if (cardDao.countImageReferences(path, card.id) == 0) {
                        ImageStorageManager.deleteImageFromLocalStorage(context, path)
                    }
                }
                card.frontImage?.let { safeDelete(it) }
                card.backImage?.let { safeDelete(it) }
                card.explanationImage?.let { safeDelete(it) }
                card.optionImagesJson?.let { json ->
                    try {
                        val tokenType = object : com.google.gson.reflect.TypeToken<List<String>>() {}.type
                        val list: List<String> = gson.fromJson(json, tokenType) ?: emptyList()
                        list.forEach { img -> safeDelete(img) }
                    } catch (e: Exception) {
                        Log.e(TAG, "Error deleting option images for deck deletion", e)
                    }
                }
            }
        }

        cardAttemptDao.deleteAttemptsForDeck(deckId)
        sessionRecordDao.deleteRecordsForDeck(deckId)
        cardDao.deleteCardsForDeck(deckId)
        deckDao.deleteDeck(deckId)
    }

    /** Adds a new card using its hierarchy to resolve the deck. */
    suspend fun addCard(
        deckHierarchy: String,
        front: String,
        back: String,
        tagsJson: String = "[]",
        frontImage: String? = null,
        backImage: String? = null,
        explanationImage: String? = null,
        optionImagesJson: String? = null
    ): Long = withContext(Dispatchers.IO) {
        val allDecks = deckDao.getAllDecksOnce()
        val deckId = allDecks.find { it.fullPath == deckHierarchy }?.id 
            ?: allDecks.firstOrNull()?.id 
            ?: return@withContext -1L

        val newCard = CardEntity(
            id = System.currentTimeMillis(), // Generating a temporary unique ID
            noteId = System.currentTimeMillis(),
            deckId = deckId,
            subDeckId = resolveSubDeckId(deckHierarchy, emptyMap()), // Best effort if not syncing
            front = front,
            back = back,
            tags = tagsJson,
            deckHierarchy = deckHierarchy,
            lastSyncTimestamp = System.currentTimeMillis(),
            frontImage = frontImage,
            backImage = backImage,
            explanationImage = explanationImage,
            optionImagesJson = optionImagesJson
        )
        val id = cardDao.insertCard(newCard)
        Log.d(TAG, "Added new card with ID $id to deck $deckId")
        
        // Update deck card count
        val deck = deckDao.getDeckById(deckId)
        if (deck != null) {
            deckDao.updateDeck(deck.copy(cardCount = deck.cardCount + 1))
        }
        return@withContext id
    }

    /** Deletes a specific card by its ID and decrements the deck count automatically. */
    suspend fun deleteCard(cardId: Long) = withContext(Dispatchers.IO) {
        val card = cardDao.getCardById(cardId) ?: return@withContext
        val deckId = card.deckId
        
        // Image cleanup if policy is set
        val deleteImages = SettingsRepository.getInstance(context).deleteImagesOnCardDelete
        if (deleteImages) {
            suspend fun safeDelete(path: String) {
                if (cardDao.countImageReferences(path, card.id) == 0) {
                    ImageStorageManager.deleteImageFromLocalStorage(context, path)
                }
            }
            card.frontImage?.let { safeDelete(it) }
            card.backImage?.let { safeDelete(it) }
            card.explanationImage?.let { safeDelete(it) }
            card.optionImagesJson?.let { json ->
                try {
                    val tokenType = object : com.google.gson.reflect.TypeToken<List<String>>() {}.type
                    val list: List<String> = gson.fromJson(json, tokenType) ?: emptyList()
                    list.forEach { img -> safeDelete(img) }
                } catch (e: Exception) {
                    Log.e(TAG, "Error deleting option images for card deletion", e)
                }
            }
        }
        
        cardDao.deleteCard(cardId)
        cardOverrideDao.deleteOverride(cardId)
        Log.d(TAG, "Deleted card $cardId from deck $deckId")
        
        // Update deck card count
        val deck = deckDao.getDeckById(deckId)
        if (deck != null) {
            deckDao.updateDeck(deck.copy(cardCount = maxOf(0, deck.cardCount - 1)))
        }
    }
    /** Renames a deck and updates its subdecks and cards' hierarchy paths. */
    suspend fun renameDeck(deckId: Long, newLeafName: String): Unit = withContext(Dispatchers.IO) {
        val targetDeck = deckDao.getDeckById(deckId) ?: return@withContext
        val oldFullPath = targetDeck.fullPath
        
        val parentPath = AnkiDroidBridge.getParentDeckPath(oldFullPath)
        val newFullPath = if (parentPath != null) "$parentPath::$newLeafName" else newLeafName
        
        AppDatabase.getInstance(context).withTransaction {
            val allDecks = deckDao.getAllDecksOnce()
            for (deck in allDecks) {
                if (deck.fullPath == oldFullPath) {
                    val updatedDeck = deck.copy(
                        name = newLeafName,
                        fullPath = newFullPath,
                        lastSyncTimestamp = System.currentTimeMillis()
                    )
                    deckDao.updateDeck(updatedDeck)
                    
                    cardDao.updateCardsHierarchyForDeck(deck.id, newFullPath)
                } else if (deck.fullPath.startsWith("$oldFullPath::")) {
                    val suffix = deck.fullPath.removePrefix(oldFullPath)
                    val updatedFullPath = newFullPath + suffix
                    val updatedDeck = deck.copy(
                        fullPath = updatedFullPath,
                        lastSyncTimestamp = System.currentTimeMillis()
                    )
                    deckDao.updateDeck(updatedDeck)
                    
                    cardDao.updateCardsHierarchyForDeck(deck.id, updatedFullPath)
                }
            }
        }
    }

    /** Clears card attempt history and session statistics for a deck and its subdecks. */
    suspend fun clearDeckProgress(deckId: Long): Unit = withContext(Dispatchers.IO) {
        Log.d(TAG, "Clearing progress for deck with ID $deckId and its subdecks")
        val subDecks = deckDao.getSubDecks(deckId)
        for (subDeck in subDecks) {
            clearDeckProgress(subDeck.id)
        }
        cardAttemptDao.deleteAttemptsForDeck(deckId)
        sessionRecordDao.deleteRecordsForDeck(deckId)
    }

    /** Creates a new deck (and any parent decks if specified with '::'). */
    suspend fun createDeck(deckName: String): Unit = withContext(Dispatchers.IO) {
        Log.d(TAG, "Creating new deck with name: $deckName")
        val parts = deckName.split("::")
        var currentPath = ""
        var parentId: Long? = null
        val decks = deckDao.getAllDecksOnce()
        val deckPathToId = decks.associate { it.fullPath to it.id }

        for (i in parts.indices) {
            val part = parts[i]
            currentPath = if (currentPath.isEmpty()) part else "${currentPath}::${part}"
            var existingId = deckPathToId[currentPath]
            if (existingId == null) {
                val newId = kotlin.math.abs(java.util.UUID.randomUUID().mostSignificantBits)
                val newDeck = DeckEntity(
                    id = newId,
                    name = part,
                    fullPath = currentPath,
                    parentDeckId = parentId,
                    cardCount = 0,
                    lastSyncTimestamp = System.currentTimeMillis()
                )
                deckDao.insertDeckIgnore(newDeck)
                existingId = newId
            }
            parentId = existingId
        }
    }


    /** Clear all cached data. */
    suspend fun clearCache() = withContext(Dispatchers.IO) {
        Log.d(TAG, "Clearing all cached data")
        cardDao.deleteAllCards()
        deckDao.deleteAllDecks()
        sessionRecordDao.deleteAllRecords()
        cardAttemptDao.deleteAllAttempts()
    }

    /** Check if cache has data (useful for determining if sync is needed). */
    suspend fun isCachePopulated(): Boolean = withContext(Dispatchers.IO) {
        deckDao.getDeckCount() > 0
    }

    suspend fun getAllAliases(): List<AliasEntity> = withContext(Dispatchers.IO) {
        aliasDao.getAllAliases()
    }

    suspend fun addCustomAlias(name: String, alias: String): Boolean = withContext(Dispatchers.IO) {
        val normName = name.trim().lowercase()
        val normAlias = alias.trim().lowercase()
        if (normName.isEmpty() || normAlias.isEmpty()) return@withContext false
        val exists = aliasDao.exists(normName, normAlias) > 0
        if (exists) {
            true
        } else {
            aliasDao.insertAlias(AliasEntity(normName, normAlias))
            false
        }
    }

    suspend fun loadDefaultAliasesIfNeeded() = withContext(Dispatchers.IO) {
        try {
            val existing = aliasDao.getAllAliases()
            if (existing.isNotEmpty()) {
                Log.d(TAG, "Aliases already loaded: ${existing.size}")
                return@withContext
            }
            Log.d(TAG, "Loading default aliases from assets...")
            val assetManager = context.assets
            val subjects = listOf("history.csv", "science.csv", "aliases_geography.csv")
            for (subj in subjects) {
                try {
                    val stream = assetManager.open("aliases/$subj")
                    BufferedReader(InputStreamReader(stream)).use { reader ->
                        var line: String? = reader.readLine()
                        var isFirstLine = true
                        var isNewFormat = false
                        while (line != null) {
                            val trimmedLine = line.trim()
                            if (trimmedLine.isNotEmpty()) {
                                if (isFirstLine) {
                                    isFirstLine = false
                                    if (trimmedLine.startsWith("concept_id")) {
                                        isNewFormat = true
                                        line = reader.readLine()
                                        continue
                                    }
                                }
                                if (isNewFormat) {
                                    val parts = trimmedLine.split(",", limit = 3)
                                    if (parts.size >= 3) {
                                        val primaryName = parts[1].trim().lowercase()
                                        val aliasList = parts[2].trim().lowercase()
                                        if (primaryName.isNotEmpty() && aliasList.isNotEmpty()) {
                                            aliasList.split("|").forEach { aliasPart ->
                                                val cleanAlias = aliasPart.trim()
                                                if (cleanAlias.isNotEmpty()) {
                                                    aliasDao.insertAlias(AliasEntity(primaryName, cleanAlias))
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    val parts = trimmedLine.split(",")
                                    if (parts.size >= 2) {
                                        val name = parts[0].trim().lowercase()
                                        val alias = parts[1].trim().lowercase()
                                        if (name.isNotEmpty() && alias.isNotEmpty()) {
                                            aliasDao.insertAlias(AliasEntity(name, alias))
                                        }
                                    }
                                }
                            }
                            line = reader.readLine()
                        }
                    }
                    Log.d(TAG, "Loaded default aliases for $subj")
                } catch (e: Exception) {
                    Log.e(TAG, "Failed to load default aliases for $subj: ${e.message}")
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error in loadDefaultAliasesIfNeeded: ${e.message}")
        }
    }

    /** Merges the cards, subdecks, attempt history, and session logs of source deck into target deck. */
    suspend fun mergeDecks(sourceDeckId: Long, targetDeckId: Long): Unit = withContext(Dispatchers.IO) {
        Log.d(TAG, "Merging deck $sourceDeckId into deck $targetDeckId")
        
        AppDatabase.getInstance(context).withTransaction {
            val sourceDeck = deckDao.getDeckById(sourceDeckId) ?: return@withTransaction
            val targetDeck = deckDao.getDeckById(targetDeckId) ?: return@withTransaction

            // 1. Move all cards from source deck directly to target deck
            cardDao.updateCardsDeckAndHierarchy(sourceDeckId, targetDeckId, targetDeck.fullPath)
            
            // Update the target deck's cardCount so the UI doesn't say 0 cards.
            val sourceCardCount = cardDao.getCardCountForDeck(targetDeckId) - targetDeck.cardCount // Approximation, but it's updated anyway
            val updatedTargetDeck = targetDeck.copy(cardCount = targetDeck.cardCount + sourceCardCount)
            deckDao.updateDeck(updatedTargetDeck)

            // 2. Move subdecks of source deck under target deck
            val allDecks = deckDao.getAllDecksOnce()
            for (deck in allDecks) {
                if (deck.fullPath.startsWith("${sourceDeck.fullPath}::")) {
                    val suffix = deck.fullPath.removePrefix(sourceDeck.fullPath)
                    val newFullPath = targetDeck.fullPath + suffix
                    val updatedDeck = deck.copy(
                        fullPath = newFullPath,
                        parentDeckId = if (deck.parentDeckId == sourceDeckId) targetDeckId else deck.parentDeckId,
                        lastSyncTimestamp = System.currentTimeMillis()
                    )
                    deckDao.updateDeck(updatedDeck)

                    // Update subdeck's cards hierarchy
                    cardDao.updateCardsHierarchyForDeck(deck.id, newFullPath)
                }
            }

            // 3. Migrate attempt logs and session records in SQLite using raw SupportSQLiteDatabase
            try {
                val db = AppDatabase.getInstance(context)
                db.openHelper.writableDatabase.let { sqlDb ->
                    sqlDb.execSQL("UPDATE card_attempts SET deckId = ? WHERE deckId = ?", arrayOf(targetDeckId, sourceDeckId))
                    sqlDb.execSQL("UPDATE session_records SET deckId = ?, deckName = ? WHERE deckId = ?", arrayOf(targetDeckId, targetDeck.name, sourceDeckId))
                }
                Log.d(TAG, "Attempts and session history merged in SQLite database")
            } catch (e: Exception) {
                Log.e(TAG, "Failed to run SQLite raw updates during merge: ${e.message}", e)
            }

            // 4. Delete the source deck
            deckDao.deleteDeck(sourceDeckId)
            Log.d(TAG, "Source deck $sourceDeckId successfully deleted and merged into target $targetDeckId")
        }
    }
}

/**
 * Result of a sync operation from AnkiDroid → Room.
 */
data class SyncResult(
    val success: Boolean,
    val totalDecks: Int,
    val totalCards: Int,
    val durationMs: Long,
    val error: String? = null
)
