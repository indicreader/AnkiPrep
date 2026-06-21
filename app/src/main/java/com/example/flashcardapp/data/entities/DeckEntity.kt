package com.example.flashcardapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Room entity representing an AnkiDroid deck.
 *
 * Supports hierarchical decks — [parentDeckId] is null for root decks and
 * references the parent's [id] for subdecks. The [fullPath] stores the
 * full Anki deck path (e.g. "Science::Biology::Genetics") while [name]
 * holds only the leaf segment ("Genetics").
 */
@Entity(tableName = "decks")
data class DeckEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val fullPath: String,
    val parentDeckId: Long? = null,
    val cardCount: Int = 0,
    val description: String = "",
    val lastSyncTimestamp: Long = System.currentTimeMillis()
)
