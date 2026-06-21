package com.example.flashcardapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Room entity representing a completed study or quiz session.
 * Used to populate actual analytics data instead of mock statistics.
 */
@Entity(tableName = "session_records")
data class SessionRecordEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val deckId: Long,
    val deckName: String,
    val mode: String, // PRACTICE, TEST, REVISION
    val score: Int,
    val totalQuestions: Int,
    val timeTakenSeconds: Long,
    val timestamp: Long = System.currentTimeMillis()
)
