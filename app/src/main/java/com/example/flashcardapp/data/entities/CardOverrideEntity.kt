package com.example.flashcardapp.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * Room entity representing local overrides for a flashcard.
 *
 * This allows users to edit cards without mutating the original imported data.
 */
@Entity(
    tableName = "card_overrides",
    foreignKeys = [
        ForeignKey(
            entity = CardEntity::class,
            parentColumns = ["id"],
            childColumns = ["cardId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CardOverrideEntity(
    @PrimaryKey
    val cardId: Long,
    val frontOverride: String,
    val backOverride: String,
    val tagsOverride: String? = null,
    val timestamp: Long = System.currentTimeMillis(),
    val frontImageOverride: String? = null,
    val backImageOverride: String? = null,
    val explanationImageOverride: String? = null,
    val optionImagesOverrideJson: String? = null
)
