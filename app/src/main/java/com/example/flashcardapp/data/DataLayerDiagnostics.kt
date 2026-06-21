package com.example.flashcardapp.data

import android.content.Context
import android.util.Log

/**
 * Debug diagnostics utility for the Anki Data Layer.
 *
 * Prints structured diagnostic output to logcat covering:
 * - Total decks loaded
 * - Total cards loaded
 * - Sample 5 cards with front/back/tags/deck
 * - Cache persistence confirmation
 *
 * Usage:
 * ```kotlin
 * DataLayerDiagnostics.runFullDiagnostics(context)
 * ```
 *
 * All output is tagged with "AnkiDiagnostics" for easy logcat filtering:
 * `adb logcat -s AnkiDiagnostics`
 */
object DataLayerDiagnostics {
    private const val TAG = "AnkiDiagnostics"
    private const val SEPARATOR = "═══════════════════════════════════════════════════════"
    private const val THIN_SEP = "───────────────────────────────────────────────────────"

    /**
     * Runs the complete diagnostics suite and prints results to logcat.
     *
     * This is safe to call from any coroutine scope — it runs all
     * database operations on IO dispatcher via the repository.
     *
     * @param context Application context
     * @param syncFirst If true, triggers a fresh sync from AnkiDroid before diagnostics
     * @return [DiagnosticsReport] with all collected data
     */
    suspend fun runFullDiagnostics(
        context: Context,
        syncFirst: Boolean = true
    ): DiagnosticsReport {
        val repo = AnkiDataRepository.getInstance(context)

        Log.i(TAG, "")
        Log.i(TAG, SEPARATOR)
        Log.i(TAG, "  ANKI DATA LAYER — DIAGNOSTICS REPORT")
        Log.i(TAG, SEPARATOR)

        // Step 1: Sync (if requested)
        var syncResult: SyncResult? = null
        if (syncFirst) {
            Log.i(TAG, "")
            Log.i(TAG, "▶ Phase 1: Syncing from AnkiDroid...")
            syncResult = repo.syncFromAnkiDroid()
            if (syncResult.success) {
                Log.i(TAG, "  ✅ Sync succeeded in ${syncResult.durationMs}ms")
            } else {
                Log.e(TAG, "  ❌ Sync failed: ${syncResult.error}")
            }
        }

        // Step 2: Deck count
        Log.i(TAG, "")
        Log.i(TAG, "▶ Phase 2: Deck Inventory")
        Log.i(TAG, THIN_SEP)
        val allDecks = repo.getAllDecks()
        val deckCount = allDecks.size
        Log.i(TAG, "  Total decks loaded: $deckCount")

        for (deck in allDecks) {
            val hierarchy = if (deck.parentDeckId != null) "  ↳ subdeck of ${deck.parentDeckId}" else "  (root)"
            Log.i(TAG, "  • [${deck.id}] ${deck.fullPath} — ${deck.cardCount} cards$hierarchy")
        }

        // Step 3: Card count
        Log.i(TAG, "")
        Log.i(TAG, "▶ Phase 3: Card Inventory")
        Log.i(TAG, THIN_SEP)
        val cardCount = repo.getCardCount()
        Log.i(TAG, "  Total cards loaded: $cardCount")

        // Step 4: Sample cards
        Log.i(TAG, "")
        Log.i(TAG, "▶ Phase 4: Sample Cards (first 5)")
        Log.i(TAG, THIN_SEP)
        val sampleCards = repo.getSampleCards(5)
        if (sampleCards.isEmpty()) {
            Log.w(TAG, "  ⚠️ No cards in cache!")
        } else {
            for ((index, card) in sampleCards.withIndex()) {
                val tags = repo.parseTags(card.tags)
                val tagStr = if (tags.isNotEmpty()) tags.joinToString(", ") else "(no tags)"
                Log.i(TAG, "  Card ${index + 1}:")
                Log.i(TAG, "    ID:    ${card.id}")
                Log.i(TAG, "    Deck:  ${card.deckHierarchy}")
                Log.i(TAG, "    Front: ${card.front.take(80)}${if (card.front.length > 80) "..." else ""}")
                Log.i(TAG, "    Back:  ${card.back.take(80)}${if (card.back.length > 80) "..." else ""}")
                Log.i(TAG, "    Tags:  $tagStr")
                if (index < sampleCards.size - 1) Log.i(TAG, "    ---")
            }
        }

        // Step 5: Cache persistence check
        Log.i(TAG, "")
        Log.i(TAG, "▶ Phase 5: Cache Persistence Verification")
        Log.i(TAG, THIN_SEP)
        val isCached = repo.isCachePopulated()
        if (isCached) {
            Log.i(TAG, "  ✅ Cache is populated — data persists across restarts")
            Log.i(TAG, "  ✅ Room database file exists on disk")
        } else {
            Log.w(TAG, "  ⚠️ Cache is empty — no persistent data found")
        }

        // Summary
        Log.i(TAG, "")
        Log.i(TAG, SEPARATOR)
        Log.i(TAG, "  SUMMARY")
        Log.i(TAG, "  Decks:  $deckCount")
        Log.i(TAG, "  Cards:  $cardCount")
        Log.i(TAG, "  Cache:  ${if (isCached) "VERIFIED ✅" else "EMPTY ⚠️"}")
        Log.i(TAG, "  Status: ${if (deckCount > 0 && cardCount > 0) "DATA LAYER HEALTHY ✅" else "NEEDS ATTENTION ⚠️"}")
        Log.i(TAG, SEPARATOR)
        Log.i(TAG, "")

        return DiagnosticsReport(
            syncResult = syncResult,
            totalDecks = deckCount,
            totalCards = cardCount,
            sampleCards = sampleCards,
            cachePopulated = isCached,
            allDecks = allDecks
        )
    }
}

/**
 * Structured diagnostics report returned by [DataLayerDiagnostics.runFullDiagnostics].
 */
data class DiagnosticsReport(
    val syncResult: SyncResult?,
    val totalDecks: Int,
    val totalCards: Int,
    val sampleCards: List<com.example.flashcardapp.data.entities.CardEntity>,
    val cachePopulated: Boolean,
    val allDecks: List<com.example.flashcardapp.data.entities.DeckEntity>
)
