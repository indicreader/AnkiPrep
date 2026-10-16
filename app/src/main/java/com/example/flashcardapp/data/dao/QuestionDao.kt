package com.example.flashcardapp.data.dao

import androidx.room.*
import com.example.flashcardapp.data.entities.QuestionEntity
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for Room PYQ questions table.
 */
@Dao
interface QuestionDao {

    @Query("SELECT * FROM pyq_questions ORDER BY id ASC")
    fun observeAllQuestions(): Flow<List<QuestionEntity>>

    @Query("SELECT * FROM pyq_questions WHERE subject = :subject ORDER BY id ASC")
    fun observeQuestionsBySubject(subject: String): Flow<List<QuestionEntity>>

    @Query("SELECT * FROM pyq_questions WHERE subject = :subject ORDER BY id ASC")
    suspend fun getQuestionsBySubjectOnce(subject: String): List<QuestionEntity>

    @Query("SELECT * FROM pyq_questions WHERE subject = :subject AND subTopic = :subTopic ORDER BY id ASC")
    suspend fun getQuestionsByTopicOnce(subject: String, subTopic: String): List<QuestionEntity>

    @Query("SELECT * FROM pyq_questions ORDER BY RANDOM() LIMIT :limit")
    suspend fun getRandomQuestionsOnce(limit: Int): List<QuestionEntity>

    @Query("SELECT DISTINCT subject FROM pyq_questions ORDER BY subject ASC")
    suspend fun getSubjects(): List<String>

    @Query("SELECT DISTINCT subTopic FROM pyq_questions WHERE subject = :subject ORDER BY subTopic ASC")
    suspend fun getSubTopics(subject: String): List<String>

    @Query("SELECT COUNT(*) FROM pyq_questions")
    suspend fun getQuestionCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertQuestions(questions: List<QuestionEntity>)

    @Query("DELETE FROM pyq_questions WHERE subject = :subject")
    suspend fun deleteQuestionsBySubject(subject: String)

    @Query("DELETE FROM pyq_questions")
    suspend fun deleteAllQuestions()
}
