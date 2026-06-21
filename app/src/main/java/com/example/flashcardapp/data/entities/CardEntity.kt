package com.example.flashcardapp.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Room entity representing a single flashcard cached from AnkiDroid.
 *
 * This is the **internal normalized Card model** defined in the requirements.
 * It stores extracted front/back content, tags as a JSON-serialized list,
 * and links to the deck hierarchy via [deckId] and optional [subDeckId].
 *
 * No MCQ, session, or FSRS metadata lives here — this is purely data extraction + caching.
 */
@Entity(
    tableName = "cards",
    foreignKeys = [
        ForeignKey(
            entity = DeckEntity::class,
            parentColumns = ["id"],
            childColumns = ["deckId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["deckId"]),
        Index(value = ["noteId"])
    ]
)
data class CardEntity(
    @PrimaryKey
    val id: Long,
    val noteId: Long,
    val deckId: Long,
    val subDeckId: Long? = null,
    val front: String,
    val back: String,
    /** JSON-serialized list of tags, e.g. ["anatomy", "chapter-3"] */
    val tags: String = "[]",
    val deckHierarchy: String = "",
    val lastSyncTimestamp: Long = System.currentTimeMillis(),
    val frontImage: String? = null,
    val backImage: String? = null,
    val explanationImage: String? = null,
    val optionImagesJson: String? = null
)
