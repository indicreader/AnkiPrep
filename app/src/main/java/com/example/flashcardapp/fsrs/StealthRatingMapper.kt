package com.example.flashcardapp.fsrs

/**
 * Converts MCQ quiz performance into FSRS ratings using the
 * "Hybrid Stealth" method — zero friction for the user.
 *
 * Mapping (from PROJECT_KNOWLEDGE.md §3):
 *   Wrong Answer       → Again
 *   Correct in < 5s    → Easy
 *   Correct in 5–15s   → Good
 *   Correct in > 15s   → Hard
 */
object StealthRatingMapper {

    private const val EASY_THRESHOLD_MS = 5_000L
    private const val GOOD_THRESHOLD_MS = 15_000L

    /**
     * Map a single MCQ response to an FSRS [Rating].
     *
     * @param isCorrect Whether the user selected the correct option.
     * @param timeTakenMs Milliseconds the user spent on this question.
     * @return The FSRS rating to use for scheduling.
     */
    fun mapToRating(isCorrect: Boolean, timeTakenMs: Long): Rating {
        if (!isCorrect) return Rating.Again
        return when {
            timeTakenMs < EASY_THRESHOLD_MS -> Rating.Easy
            timeTakenMs <= GOOD_THRESHOLD_MS -> Rating.Good
            else -> Rating.Hard
        }
    }
}
