package com.example.flashcardapp.session

import android.content.Context
import com.example.flashcardapp.data.AnkiDataRepository
import com.example.flashcardapp.data.PersistentProgressManager
import com.example.flashcardapp.data.entities.CardEntity

class SessionGenerationEngine(private val context: Context) {
    private val repo = AnkiDataRepository.getInstance(context)
    private val progressManager = PersistentProgressManager(context)

    suspend fun getRemainingUniqueCards(
        deckHierarchy: String,
        deckId: Long,
        isStarredOnly: Boolean = false,
        customDeckIds: List<Long>? = null
    ): List<CardEntity> {
        val basePool = if (isStarredOnly) {
            val starredIds = repo.getAllUserMetadataOnce().filter { it.isStarred }.map { it.cardId }.toSet()
            repo.getAllCards().filter { starredIds.contains(it.id) }
        } else if (customDeckIds != null) {
            repo.getAllCards().filter { customDeckIds.contains(it.deckId) }
        } else {
            repo.getCardsForHierarchy(deckHierarchy)
        }

        val attemptedIds = when {
            isStarredOnly -> progressManager.getAllAttemptedCardIds().toSet()
            customDeckIds != null -> customDeckIds.flatMap { progressManager.getAttemptedCardIds(it) }.toSet()
            else -> progressManager.getAttemptedCardIds(deckId).toSet()
        }

        return basePool.filter { !attemptedIds.contains(it.id) }
    }

    suspend fun generateSessionCards(
        deckHierarchy: String,
        deckId: Long,
        questionLimit: Int,
        isStarredOnly: Boolean,
        customDeckIds: List<Long>?
    ): List<CardEntity> {
        val basePool: List<CardEntity> = if (isStarredOnly) {
            val starredIds = repo.getAllUserMetadataOnce().filter { it.isStarred }.map { it.cardId }.toSet()
            repo.getAllCards().filter { starredIds.contains(it.id) }
        } else if (customDeckIds != null) {
            repo.getAllCards().filter { customDeckIds.contains(it.deckId) }
        } else {
            repo.getCardsForHierarchy(deckHierarchy)
        }

        val attemptedIds = progressManager.getAttemptedCardIds(deckId).toSet()
        val unattemptedPool = basePool.filter { !attemptedIds.contains(it.id) }

        // Filter duplicates and shuffle
        val shuffledPool = unattemptedPool.shuffled()
        
        // Prioritize unattempted (all in this pool are unattempted because we filtered)
        val selectedCards = if (questionLimit > 0) {
            shuffledPool.take(questionLimit)
        } else {
            shuffledPool
        }
        
        return selectedCards.shuffled()
    }
}
