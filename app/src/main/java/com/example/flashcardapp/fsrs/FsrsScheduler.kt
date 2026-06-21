package com.example.flashcardapp.fsrs

import com.example.flashcardapp.data.dao.CardStateDao
import com.example.flashcardapp.data.entities.CardStateEntity
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

/**
 * FSRS Scheduling Service — the bridge between quiz results and the algorithm.
 *
 * Responsibilities:
 * 1. Take an MCQ answer → compute stealth FSRS rating → run algorithm → persist state
 * 2. Provide due-card queries for session/dashboard
 * 3. Handle post-exam "I struggled" rating overrides
 *
 * This class is safe to instantiate multiple times (stateless besides DAO).
 */
class FsrsScheduler(private val cardStateDao: CardStateDao) {

    private val algorithm = FsrsAlgorithm()

    /**
     * Process a single MCQ answer and update the card's FSRS scheduling state.
     *
     * Called automatically at session end for every answered question.
     *
     * @param cardId The source card ID from the MCQ.
     * @param isCorrect Whether the user answered correctly.
     * @param timeTakenMs Time spent on this question in milliseconds.
     * @return The [Rating] that was computed and applied.
     */
    suspend fun processAnswer(cardId: Long, isCorrect: Boolean, timeTakenMs: Long): Rating {
        val rating = StealthRatingMapper.mapToRating(isCorrect, timeTakenMs)
        applyRating(cardId, rating, isCorrect)
        return rating
    }

    /**
     * Override a card's rating post-exam (e.g., user flags "I guessed").
     *
     * Re-runs the FSRS algorithm with the new rating and persists the updated state.
     * This replaces the stealth-computed scheduling with the user's manual override.
     *
     * @param cardId The card to override.
     * @param newRating The new rating to apply (typically [Rating.Hard] for "I guessed").
     */
    suspend fun overrideRating(cardId: Long, newRating: Rating) {
        applyRating(cardId, newRating, isCorrect = newRating != Rating.Again)
    }

    /**
     * Get card IDs that are due for review in a specific deck.
     */
    suspend fun getDueCardIds(deckId: Long): List<Long> {
        val now = System.currentTimeMillis()
        return cardStateDao.getDueCards(deckId, now).map { it.cardId }
    }

    /**
     * Get new (never reviewed) card IDs for a deck.
     */
    suspend fun getNewCardIds(deckId: Long, limit: Int = 20): List<Long> {
        return cardStateDao.getNewCards(deckId, limit).map { it.cardId }
    }

    /**
     * Count of due cards across all decks (for dashboard badge).
     */
    suspend fun getTotalDueCount(): Int {
        return cardStateDao.getTotalDueCount(System.currentTimeMillis())
    }

    /**
     * Count of due cards for a specific deck.
     */
    suspend fun getDueCount(deckId: Long): Int {
        return cardStateDao.getDueCount(deckId, System.currentTimeMillis())
    }

    /**
     * Ensure all cards have FSRS state entries. Called after imports.
     */
    suspend fun initializeNewCards() {
        cardStateDao.initializeNewCards()
    }

    // ── Internal ──────────────────────────────────────────────

    private suspend fun applyRating(cardId: Long, rating: Rating, isCorrect: Boolean) {
        // Get or create the card's current FSRS state
        val currentState = cardStateDao.getCardState(cardId)
            ?: CardStateEntity(cardId = cardId)

        // Convert DB entity → algorithm model
        val fsrsCard = FsrsCard(
            stability = currentState.stability,
            difficulty = currentState.difficulty,
            interval = currentState.interval,
            dueDate = if (currentState.dueDate > 0) currentState.dueDate.toLocalDateTime() else LocalDateTime.now(),
            reviewCount = currentState.reviewCount,
            lastReview = if (currentState.lastReview > 0) currentState.lastReview.toLocalDateTime() else LocalDateTime.now(),
            state = CardState.entries.firstOrNull { it.value == currentState.state } ?: CardState.New
        )

        // Run FSRS algorithm
        val results = algorithm.calculate(fsrsCard)
        val result = results[rating] ?: return

        // Compute new due date
        val newDueDate = addMillisToNow(result.durationMillis)

        // Build updated state
        val updatedState = currentState.copy(
            stability = result.stability,
            difficulty = result.difficulty,
            interval = result.interval,
            dueDate = newDueDate.toEpochMillis(),
            lastReview = System.currentTimeMillis(),
            reviewCount = if (isCorrect) currentState.reviewCount + 1 else currentState.reviewCount,
            lapses = if (!isCorrect) currentState.lapses + 1 else currentState.lapses,
            state = result.newState.value
        )

        // Persist
        cardStateDao.upsertState(updatedState)
    }
}
