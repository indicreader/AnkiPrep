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

    @Query("DELETE FROM card_attempts WHERE cardId IN (SELECT id FROM cards WHERE deckId = :deckId)")
    suspend fun deleteAttemptsForDeck(deckId: Long)

    @Query("DELETE FROM card_attempts")
    suspend fun deleteAllAttempts()
}
