package com.example.flashcardapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Tracks individual attempts for a card during a session.
 * Now includes timing and FSRS rating data for the stealth scheduling pipeline.
 */
@Entity(tableName = "card_attempts")
data class CardAttemptEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val cardId: Long,
    val deckId: Long,
    val isCorrect: Boolean,
    /** Time the user spent answering this specific question, in milliseconds */
    val timeTakenMs: Long = 0L,
    /** FSRS rating computed by StealthRatingMapper: 1=Again, 2=Hard, 3=Good, 4=Easy */
    val fsrsRating: Int = 0,
    val timestamp: Long = System.currentTimeMillis()
)
