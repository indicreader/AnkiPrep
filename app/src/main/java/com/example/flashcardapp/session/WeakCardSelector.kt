package com.example.flashcardapp.session

import com.example.flashcardapp.data.entities.CardAttemptEntity
import com.example.flashcardapp.data.entities.CardEntity
import com.example.flashcardapp.mcq.Mcq

/**
 * Selects "weak" cards for REVISION mode.
 *
 * Cards are ranked by historical accuracy derived from [CardAttemptEntity] records.
 * Only cards with at least one incorrect attempt and an overall accuracy below
 * [masteryThreshold] are included. This ensures Revision mode specifically targets
 * the user's weak points.
 */
object WeakCardSelector {

    /**
     * Cards with accuracy below this are considered "weak" and prioritised.
     * 1.0f = 100% — we only want cards that have been answered wrong at least once.
     */
    private const val MASTERY_THRESHOLD = 1.0f

    /**
     * Returns a list of MCQs ordered and filtered by weakness score.
     *
     * @param allMcqs        Full list of generated MCQs for the deck.
     * @param cardAttempts   All historical card attempts.
     * @param maxCards       Maximum number of cards to return.
     * @return               Ordered list (weakest first), capped at [maxCards].
     */
    fun selectWeakCards(
        cards: List<CardEntity>,
        cardAttempts: List<CardAttemptEntity>,
        maxCards: Int
    ): List<CardEntity> {
        if (cardAttempts.isEmpty()) {
            // The user expects revision to only show "wrong questions". If no wrong questions exist,
            // return empty list.
            return emptyList()
        }

        // Build per-card accuracy map
        val cardAccuracyMap = buildCardAccuracyMap(cardAttempts)

        // Only include cards that have a history AND their accuracy is below threshold
        val weakCardsScored = cards.mapNotNull { card ->
            val accuracy = cardAccuracyMap[card.id]
            if (accuracy != null && accuracy < MASTERY_THRESHOLD) {
                Pair(card, accuracy)
            } else {
                null
            }
        }

        if (weakCardsScored.isEmpty()) {
            // No weak cards found (maybe all 100% or no attempts for this specific deck).
            // Return empty list so the UI can show "no questions found" or handle gracefully.
            return emptyList()
        }

        // Sort by lowest accuracy first
        return weakCardsScored
            .sortedBy { (_, accuracy) -> accuracy }
            .map { (card, _) -> card }
            .take(maxCards)
    }

    /**
     * Computes per-card accuracy from attempt records.
     * Maps: cardId → average accuracy float
     */
    private fun buildCardAccuracyMap(records: List<CardAttemptEntity>): Map<Long, Float> {
        val cardStats = mutableMapOf<Long, Pair<Int, Int>>() // cardId -> (totalCorrect, totalAttempts)

        records.forEach { record ->
            val existing = cardStats[record.cardId] ?: Pair(0, 0)
            cardStats[record.cardId] = Pair(
                existing.first + if (record.isCorrect) 1 else 0,
                existing.second + 1
            )
        }

        return cardStats.mapValues { (_, stats) ->
            val (correct, total) = stats
            if (total > 0) correct.toFloat() / total else 0f
        }
    }
}
