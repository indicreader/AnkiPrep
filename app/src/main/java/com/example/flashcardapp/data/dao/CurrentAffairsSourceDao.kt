package com.example.flashcardapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.flashcardapp.data.entities.CurrentAffairsSourceEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CurrentAffairsSourceDao {

    @Query("SELECT * FROM current_affairs_sources ORDER BY addedTimestamp ASC")
    abstract fun observeAllSources(): Flow<List<CurrentAffairsSourceEntity>>

    @Query("SELECT * FROM current_affairs_sources ORDER BY addedTimestamp ASC")
    abstract suspend fun getAllSourcesSync(): List<CurrentAffairsSourceEntity>

    @Query("SELECT * FROM current_affairs_sources WHERE isActive = 1 ORDER BY addedTimestamp ASC")
    abstract suspend fun getActiveSourcesSync(): List<CurrentAffairsSourceEntity>

    @Query("SELECT COUNT(*) FROM current_affairs_sources")
    abstract suspend fun getSourceCount(): Int

    @Query("SELECT * FROM current_affairs_sources WHERE id = :id LIMIT 1")
    abstract suspend fun getSourceById(id: String): CurrentAffairsSourceEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun rawInsert(source: CurrentAffairsSourceEntity)

    /**
     * Inserts a feed source with strict pre-check enforcing a maximum limit of 5 sources.
     * Throws [IllegalStateException] if limit is reached for new sources.
     */
    @Transaction
    open suspend fun safeInsertSource(source: CurrentAffairsSourceEntity) {
        val existing = getSourceById(source.id)
        if (existing == null) {
            val count = getSourceCount()
            if (count >= 5) {
                throw IllegalStateException("Maximum limit of 5 feed sources reached")
            }
        }
        rawInsert(source)
    }

    @Query("UPDATE current_affairs_sources SET isActive = :isActive WHERE id = :id")
    abstract suspend fun updateActiveStatus(id: String, isActive: Boolean)

    @Query("DELETE FROM current_affairs_sources WHERE id = :id")
    abstract suspend fun deleteSourceById(id: String)
}
