package com.example.flashcardapp.data.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Room entity representing a PYQ (Previous Year Question) extracted from PDF/CSV booklets.
 *
 * Designed with strict non-nullable fallbacks to prevent runtime null crashes during quiz execution.
 */
@Entity(
    tableName = "pyq_questions",
    indices = [
        Index(value = ["subject"]),
        Index(value = ["subTopic"]),
        Index(value = ["examYear"])
    ]
)
data class QuestionEntity(
    @PrimaryKey
    val id: String = "",
    val questionText: String = "",
    val optionA: String = "",
    val optionB: String = "",
    val optionC: String = "",
    val optionD: String = "",
    val correctAnswer: String = "A", // "A", "B", "C", "D"
    val explanation: String = "NA",
    val subject: String = "General",
    val subTopic: String = "Miscellaneous",
    val examRawTag: String = "",
    val examName: String = "SSC General",
    val examYear: Int = 0,
    val tagsJson: String = "[]",
    val timestamp: Long = System.currentTimeMillis()
)
