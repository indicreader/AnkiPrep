package com.example.flashcardapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.flashcardapp.data.entities.DeckProgressLedger

@Dao
interface DeckProgressLedgerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ledger: DeckProgressLedger)

    @Query("SELECT cardId FROM DeckProgressLedger WHERE deckId = :deckId")
    suspend fun getAttemptedCardIdsForDeck(deckId: Long): List<Long>

    @Query("SELECT cardId FROM DeckProgressLedger")
    suspend fun getAllAttemptedCardIds(): List<Long>

    @Query("SELECT COUNT(cardId) FROM DeckProgressLedger WHERE deckId = :deckId")
    suspend fun getAttemptedCountForDeck(deckId: Long): Int

    @Query("DELETE FROM DeckProgressLedger WHERE deckId = :deckId")
    suspend fun clearProgressForDeck(deckId: Long)
}
