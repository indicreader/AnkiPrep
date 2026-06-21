package com.example.flashcardapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.flashcardapp.data.entities.SessionRecordEntity
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for session statistics.
 */
@Dao
interface SessionRecordDao {

    @Insert
    suspend fun insertRecord(record: SessionRecordEntity): Long

    @Query("SELECT * FROM session_records ORDER BY timestamp DESC")
    fun getAllRecordsFlow(): Flow<List<SessionRecordEntity>>

    @Query("SELECT * FROM session_records ORDER BY timestamp DESC")
    suspend fun getAllRecords(): List<SessionRecordEntity>

    @Query("SELECT COUNT(*) FROM session_records")
    suspend fun getSessionCount(): Int

    @Query("SELECT SUM(totalQuestions) FROM session_records")
    suspend fun getTotalQuestionsAnswered(): Int?

    @Query("SELECT SUM(score) FROM session_records")
    suspend fun getTotalCorrectAnswers(): Int?

    @Query("SELECT COUNT(*) FROM session_records WHERE mode = 'PRACTICE'")
    suspend fun getPracticeSessionCount(): Int

    @Query("SELECT COUNT(*) FROM session_records WHERE mode = 'REVISION'")
    suspend fun getRevisionSessionCount(): Int

    @Query("SELECT COUNT(*) FROM session_records WHERE mode = 'TEST'")
    suspend fun getTestSessionCount(): Int

    @Query("DELETE FROM session_records WHERE deckId = :deckId")
    suspend fun deleteRecordsForDeck(deckId: Long)

    @Query("DELETE FROM session_records")
    suspend fun deleteAllRecords()
}
