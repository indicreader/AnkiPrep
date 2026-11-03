package com.example.flashcardapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.flashcardapp.data.entities.CardAttemptEntity
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for individual card attempts.
 */
@Dao
interface CardAttemptDao {

    @Insert
    suspend fun insertAttempt(attempt: CardAttemptEntity): Long

    @Insert
    suspend fun insertAttempts(attempts: List<CardAttemptEntity>)

    @Query("SELECT * FROM card_attempts WHERE cardId = :cardId ORDER BY timestamp DESC")
    suspend fun getAttemptsForCard(cardId: Long): List<CardAttemptEntity>

    @Query("SELECT * FROM card_attempts ORDER BY timestamp DESC")
    suspend fun getAllAttempts(): List<CardAttemptEntity>

    @Query("SELECT * FROM card_attempts WHERE timestamp >= :sinceTimestamp ORDER BY timestamp DESC")
    fun observeAttemptsSince(sinceTimestamp: Long): Flow<List<CardAttemptEntity>>

    @Query("DELETE FROM card_attempts WHERE cardId IN (SELECT id FROM cards WHERE deckId = :deckId)")
    suspend fun deleteAttemptsForDeck(deckId: Long)

    @Query("DELETE FROM card_attempts")
    suspend fun deleteAllAttempts()

    /**
     * Reactive rolling accuracy metrics grouped by deck.
     * Joins decks and card_attempts so deck renames immediately update the UI.
     */
    @Query("""
        SELECT 
            d.id AS deckId,
            d.name AS deckName,
            d.fullPath AS deckPath,
            COUNT(a.id) AS totalAttempts,
            SUM(CASE WHEN a.isCorrect THEN 1 ELSE 0 END) AS correctAttempts,
            SUM(CASE WHEN a.isGuess THEN 1 ELSE 0 END) AS guessAttempts
        FROM decks d
        INNER JOIN card_attempts a ON a.deckId = d.id
        GROUP BY d.id
        ORDER BY totalAttempts DESC
    """)
    fun observeDeckAccuracyStats(): Flow<List<DeckAccuracyStats>>
}

/**
 * Rolling attempt counts and accuracy metrics grouped by deck.
 */
data class DeckAccuracyStats(
    val deckId: Long,
    val deckName: String,
    val deckPath: String,
    val totalAttempts: Int,
    val correctAttempts: Int,
    val guessAttempts: Int
) {
    val accuracy: Float
        get() = if (totalAttempts > 0) (correctAttempts.toFloat() / totalAttempts) * 100f else 0f

    val accuracyTier: DeckAccuracyTier
        get() = when {
            totalAttempts == 0 -> DeckAccuracyTier.UNTESTED
            accuracy >= 85f -> DeckAccuracyTier.STRONG
            accuracy >= 60f -> DeckAccuracyTier.MODERATE
            else -> DeckAccuracyTier.FOCUS_NEEDED
        }
}

enum class DeckAccuracyTier {
    UNTESTED,
    STRONG,        // >= 85%
    MODERATE,      // 60% - 84%
    FOCUS_NEEDED   // < 60%
}
