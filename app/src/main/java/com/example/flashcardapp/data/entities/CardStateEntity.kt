package com.example.flashcardapp.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * FSRS scheduling state for a single card.
 *
 * This is the **isolation layer** — keeps CardEntity pure (import/cache data)
 * while storing all spaced repetition metadata separately.
 *
 * One-to-one relationship with [CardEntity] via [cardId].
 */
@Entity(
    tableName = "card_states",
    foreignKeys = [
        ForeignKey(
            entity = CardEntity::class,
            parentColumns = ["id"],
            childColumns = ["cardId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["cardId"], unique = true),
        Index(value = ["dueDate"]),
        Index(value = ["state"])
    ]
)
data class CardStateEntity(
    @PrimaryKey
    val cardId: Long,

    /** FSRS Stability (S) — days until retrievability drops to 90% */
    val stability: Double = 2.5,

    /** FSRS Difficulty (D) — inherent card complexity, range [1.0, 10.0] */
    val difficulty: Double = 5.0,

    /** Current review interval in days */
    val interval: Int = 0,

    /** Epoch millis — when this card is next due for review */
    val dueDate: Long = 0L,

    /** Epoch millis — when this card was last reviewed */
    val lastReview: Long = 0L,

    /** Number of successful reviews */
    val reviewCount: Int = 0,

    /** Number of times the card was forgotten (answered Again) */
    val lapses: Int = 0,

    /** Card lifecycle state: 0=New, 1=Relearning, 2=Review */
    val state: Int = 0,

    /** Probability of recall at the current moment [0.0, 1.0] */
    val retrievability: Double = 0.0,

    /** Timestamp when retrievability was last evaluated */
    val retrievabilityTimestamp: Long = 0L
)
