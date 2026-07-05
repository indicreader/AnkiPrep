package com.example.flashcardapp.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Room entity representing user metadata for a card, such as ratings and star bookmarks.
 *
 * Separated from sync caches to ensure user preference data survives cache refreshes.
 */
@Entity(
    tableName = "card_user_metadata",
    foreignKeys = [
        ForeignKey(
            entity = CardEntity::class,
            parentColumns = ["id"],
            childColumns = ["cardId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["cardId"], unique = true)
    ]
)
data class CardUserMetadataEntity(
    @PrimaryKey
    val cardId: Long,
    val isStarred: Boolean = false,
    val rating: Int = 0 // 0 means unrated, 1 to 5 for ratings
)
