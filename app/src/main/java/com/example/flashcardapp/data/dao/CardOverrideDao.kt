package com.example.flashcardapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.flashcardapp.data.entities.CardOverrideEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CardOverrideDao {

    @Query("SELECT * FROM card_overrides WHERE cardId = :cardId")
    suspend fun getOverrideForCard(cardId: Long): CardOverrideEntity?

    @Query("SELECT * FROM card_overrides WHERE cardId = :cardId")
    fun observeOverrideForCard(cardId: Long): Flow<CardOverrideEntity?>

    @Query("SELECT * FROM card_overrides")
    suspend fun getAllOverridesOnce(): List<CardOverrideEntity>

    @Query("SELECT * FROM card_overrides")
    fun observeAllOverrides(): Flow<List<CardOverrideEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertOverride(override: CardOverrideEntity)

    @Query("DELETE FROM card_overrides WHERE cardId = :cardId")
    suspend fun deleteOverride(cardId: Long)

    @Query("DELETE FROM card_overrides")
    suspend fun deleteAllOverrides()
}

