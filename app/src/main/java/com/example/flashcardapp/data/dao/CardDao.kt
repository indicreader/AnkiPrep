package com.example.flashcardapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.flashcardapp.data.entities.CardEntity
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for card operations.
 *
 * Cards are the core cached data from AnkiDroid. All mutation is done through
 * [upsertCards] during sync — the rest is read-only queries.
 */
@Dao
interface CardDao {

    @Query("SELECT * FROM cards WHERE deckId = :deckId ORDER BY id ASC")
    fun getCardsForDeck(deckId: Long): Flow<List<CardEntity>>

    @Query("SELECT * FROM cards WHERE deckId = :deckId ORDER BY id ASC")
    suspend fun getCardsForDeckOnce(deckId: Long): List<CardEntity>

    @Query("SELECT * FROM cards WHERE deckHierarchy = :rootPath OR deckHierarchy LIKE :rootPathPrefix")
    suspend fun getCardsForRootHierarchyOnce(rootPath: String, rootPathPrefix: String): List<CardEntity>

    @Query("SELECT * FROM cards ORDER BY RANDOM() LIMIT :limit")
    suspend fun getRandomCardsOnce(limit: Int): List<CardEntity>

    @Query("SELECT * FROM cards ORDER BY id ASC")
    suspend fun getAllCardsOnce(): List<CardEntity>

    @Query("SELECT * FROM cards WHERE id = :cardId")
    suspend fun getCardById(cardId: Long): CardEntity?

    @Query("SELECT * FROM cards WHERE deckId = :deckId LIMIT :limit")
    suspend fun getSampleCards(deckId: Long, limit: Int = 5): List<CardEntity>

    @Query("SELECT * FROM cards LIMIT :limit")
    suspend fun getSampleCardsGlobal(limit: Int = 5): List<CardEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertCards(cards: List<CardEntity>)

    @Update
    suspend fun updateCards(cards: List<CardEntity>)

    @Update
    suspend fun updateCard(card: CardEntity)

    @Query("UPDATE cards SET deckId = :newDeckId, deckHierarchy = :newHierarchy WHERE deckId = :oldDeckId")
    suspend fun updateCardsDeckAndHierarchy(oldDeckId: Long, newDeckId: Long, newHierarchy: String)

    @Query("UPDATE cards SET deckHierarchy = :newHierarchy WHERE deckId = :deckId")
    suspend fun updateCardsHierarchyForDeck(deckId: Long, newHierarchy: String)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCardsIgnore(cards: List<CardEntity>): List<Long>

    @Query("DELETE FROM cards WHERE id = :cardId")
    suspend fun deleteCard(cardId: Long)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(card: CardEntity): Long

    @Query("DELETE FROM cards WHERE deckId = :deckId")
    suspend fun deleteCardsForDeck(deckId: Long)

    @Query("DELETE FROM cards")
    suspend fun deleteAllCards()

    @Query("SELECT COUNT(*) FROM cards")
    suspend fun getCardCount(): Int

    @Query("SELECT COUNT(*) FROM cards WHERE deckId = :deckId")
    suspend fun getCardCountForDeck(deckId: Long): Int

    @Query("SELECT COUNT(*) FROM cards WHERE (frontImage = :imagePath OR backImage = :imagePath OR explanationImage = :imagePath OR optionImagesJson LIKE '%' || :imagePath || '%') AND id != :excludeCardId")
    suspend fun countImageReferences(imagePath: String, excludeCardId: Long): Int
}
