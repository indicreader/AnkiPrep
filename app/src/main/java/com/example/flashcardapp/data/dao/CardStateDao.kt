package com.example.flashcardapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.flashcardapp.data.entities.CardStateEntity

/**
 * DAO for FSRS card scheduling state.
 *
 * Key queries:
 * - [getDueCards]: Cards whose due date has passed (ready for review).
 * - [getNewCards]: Cards that have never been reviewed.
 * - [getDueCount]: Quick count for dashboard badge.
 */
@Dao
interface CardStateDao {

    /**
     * Get all cards due for review in a specific deck.
     * Returns card IDs where dueDate <= now, ordered by most overdue first.
     */
    @Query("""
        SELECT cs.* FROM card_states cs
        INNER JOIN cards c ON cs.cardId = c.id
        WHERE c.deckId = :deckId AND cs.dueDate <= :nowMillis AND cs.state > 0
        ORDER BY cs.dueDate ASC
    """)
    suspend fun getDueCards(deckId: Long, nowMillis: Long): List<CardStateEntity>

    /**
     * Get cards that have never been reviewed in a deck (state = New).
     */
    @Query("""
        SELECT cs.* FROM card_states cs
        INNER JOIN cards c ON cs.cardId = c.id
        WHERE c.deckId = :deckId AND cs.state = 0
        ORDER BY cs.cardId ASC
        LIMIT :limit
    """)
    suspend fun getNewCards(deckId: Long, limit: Int = 20): List<CardStateEntity>

    /**
     * Count of cards due for review right now in a deck.
     */
    @Query("""
        SELECT COUNT(*) FROM card_states cs
        INNER JOIN cards c ON cs.cardId = c.id
        WHERE c.deckId = :deckId AND cs.dueDate <= :nowMillis AND cs.state > 0
    """)
    suspend fun getDueCount(deckId: Long, nowMillis: Long): Int

    /**
     * Count of all due cards across all decks (for dashboard badge).
     */
    @Query("SELECT COUNT(*) FROM card_states WHERE dueDate <= :nowMillis AND state > 0")
    suspend fun getTotalDueCount(nowMillis: Long): Int

    /**
     * Get the FSRS state for a single card.
     */
    @Query("SELECT * FROM card_states WHERE cardId = :cardId")
    suspend fun getCardState(cardId: Long): CardStateEntity?

    /**
     * Insert or update card state. Uses REPLACE strategy
     * since cardId is the primary key.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertState(state: CardStateEntity)

    /**
     * Bulk insert/update card states (used during import initialization).
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertStates(states: List<CardStateEntity>)

    /**
     * Initialize FSRS state for cards that don't have one yet.
     * Called after importing new cards.
     */
    @Query("""
        INSERT OR IGNORE INTO card_states (cardId, stability, difficulty, interval, dueDate, lastReview, reviewCount, lapses, state)
        SELECT id, 2.5, 5.0, 0, 0, 0, 0, 0, 0 FROM cards
        WHERE id NOT IN (SELECT cardId FROM card_states)
    """)
    suspend fun initializeNewCards()
}
