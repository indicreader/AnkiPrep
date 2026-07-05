package com.example.flashcardapp.data

import android.content.Context
import com.example.flashcardapp.data.entities.DeckProgressLedger

class PersistentProgressManager(context: Context) {
    private val db = AppDatabase.getInstance(context)
    private val ledgerDao = db.deckProgressLedgerDao()

    suspend fun logAttempt(cardId: Long, deckId: Long) {
        val finalDeckId = if (deckId < 0) {
            db.cardDao().getCardById(cardId)?.deckId ?: deckId
        } else {
            deckId
        }
        ledgerDao.insert(DeckProgressLedger(cardId, finalDeckId))
    }

    suspend fun getAttemptedCardIds(deckId: Long): List<Long> {
        return ledgerDao.getAttemptedCardIdsForDeck(deckId)
    }

    suspend fun getAllAttemptedCardIds(): List<Long> {
        return ledgerDao.getAllAttemptedCardIds()
    }

    suspend fun getRemainingCount(deckId: Long, totalCardCount: Int): Int {
        val attempted = ledgerDao.getAttemptedCountForDeck(deckId)
        return (totalCardCount - attempted).coerceAtLeast(0)
    }

    suspend fun clearProgress(deckId: Long) {
        ledgerDao.clearProgressForDeck(deckId)
    }
}
