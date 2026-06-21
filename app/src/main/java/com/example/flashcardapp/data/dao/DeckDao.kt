package com.example.flashcardapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.flashcardapp.data.entities.DeckEntity
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for deck operations.
 *
 * All queries are read-heavy. The [upsertDecks] operation uses REPLACE strategy
 * to handle re-syncs from AnkiDroid without duplicate conflicts.
 */
@Dao
interface DeckDao {

    @Query("SELECT * FROM decks ORDER BY fullPath ASC")
    fun getAllDecks(): Flow<List<DeckEntity>>

    @Query("SELECT * FROM decks ORDER BY fullPath ASC")
    suspend fun getAllDecksOnce(): List<DeckEntity>

    @Query("SELECT * FROM decks WHERE id = :deckId")
    suspend fun getDeckById(deckId: Long): DeckEntity?

    @Query("SELECT * FROM decks WHERE parentDeckId = :parentId ORDER BY name ASC")
    suspend fun getSubDecks(parentId: Long): List<DeckEntity>

    @Query("SELECT * FROM decks WHERE parentDeckId IS NULL ORDER BY name ASC")
    suspend fun getRootDecks(): List<DeckEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertDecks(decks: List<DeckEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertDeck(deck: DeckEntity)

    @Update
    suspend fun updateDeck(deck: DeckEntity)

    @Update
    suspend fun updateDecks(decks: List<DeckEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDecksIgnore(decks: List<DeckEntity>): List<Long>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDeckIgnore(deck: DeckEntity): Long

    @Query("DELETE FROM decks WHERE id = :deckId")
    suspend fun deleteDeck(deckId: Long)

    @Query("DELETE FROM decks")
    suspend fun deleteAllDecks()

    @Query("SELECT COUNT(*) FROM decks")
    suspend fun getDeckCount(): Int
}
