package com.example.flashcardapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.flashcardapp.data.entities.CardUserMetadataEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CardUserMetadataDao {

    @Query("SELECT * FROM card_user_metadata WHERE cardId = :cardId")
    suspend fun getMetadataForCard(cardId: Long): CardUserMetadataEntity?

    @Query("SELECT * FROM card_user_metadata")
    fun getAllMetadataFlow(): Flow<List<CardUserMetadataEntity>>

    @Query("SELECT * FROM card_user_metadata")
    suspend fun getAllMetadataOnce(): List<CardUserMetadataEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertMetadata(metadata: CardUserMetadataEntity)

    @Query("DELETE FROM card_user_metadata WHERE cardId = :cardId")
    suspend fun deleteMetadata(cardId: Long)
}
