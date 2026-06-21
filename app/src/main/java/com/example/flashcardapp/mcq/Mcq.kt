package com.example.flashcardapp.mcq

/**
 * Output model for a single MCQ question generated from an Anki card.
 *
 * This is the contract between the MCQ engine and any consumer (UI, tests, export).
 *
 * Invariants enforced by [McqEngine]:
 * - [options] always has exactly 4 entries
 * - [correctIndex] is always in range [0, 3]
 * - [options] contains no duplicates (case-insensitive)
 * - The correct answer is always present at [correctIndex]
 * - [distractorSourceIds] has exactly 3 entries matching the 3 distractor options
 */
data class Mcq(
    /** The question text, derived from card.front */
    val question: String,
    /** Dynamic options: 1 correct + (N - 1) distractors, shuffled */
    val options: List<String>,
    /** Index of the correct answer in [options] */
    val correctIndex: Int,
    /** ID of the source card this MCQ was generated from */
    val sourceCardId: Long,
    /** IDs of the cards that supplied the distractors, in option order */
    val distractorSourceIds: List<Long>,
    /** Deck hierarchy path of the source card */
    val deckHierarchy: String,
    /** Human-readable explanation shown after answering */
    val explanation: String,
    /** Difficulty level: easy, medium, hard */
    val difficulty: String = "medium",
    /** Answer category type: person, year/date, place, law/article, number, concept */
    val answerType: String = "concept",
    /** Tags associated with the card (e.g. subtopics) */
    val tags: List<String> = emptyList(),
    /** Image to display with the question, if any */
    val frontImage: String? = null,
    /** Image to display with the correct answer, if any */
    val backImage: String? = null,
    /** Image to display with the explanation, if any */
    val explanationImage: String? = null,
    /** JSON string array of option images, if any */
    val optionImagesJson: String? = null
) {
    /** The correct answer text. */
    val correctAnswer: String get() = options[correctIndex]

    /** Serializes the MCQ to the requested JSON format. */
    fun toJsonString(): String {
        val map = mapOf(
            "question" to question,
            "correct_answer" to correctAnswer,
            "options" to options,
            "difficulty" to difficulty,
            "answer_type" to answerType
        )
        return com.google.gson.GsonBuilder().setPrettyPrinting().create().toJson(map)
    }

    /** Validates all invariants. Returns true if this MCQ is well-formed. */
    fun isValid(): Boolean {
        val totalOptions = options.size
        if (totalOptions < 2) return false
        if (correctIndex !in 0 until totalOptions) return false
        if (distractorSourceIds.size != totalOptions - 1) return false
        // No duplicate options (case-insensitive)
        val normalized = options.map { it.trim().lowercase() }
        if (normalized.distinct().size != totalOptions) return false
        return true
    }
}

/**
 * Metadata about a distractor that was selected for an MCQ.
 * Used internally by the engine for traceability.
 */
data class DistractorCandidate(
    /** The distractor text (card.back) */
    val text: String,
    /** ID of the card this distractor came from */
    val sourceCardId: Long,
    /** Where in the hierarchy this distractor was found */
    val source: DistractorSource
)

/**
 * Describes where a distractor was sourced from in the deck hierarchy.
 */
enum class DistractorSource {
    /** Sourced from cards sharing the same tags (top priority) */
    SAME_TAG,
    /** Same subdeck as the question card (highest priority) */
    SAME_SUBDECK,
    /** Same parent deck but different subdeck */
    SAME_DECK,
    /** Same root deck family */
    SAME_ROOT,
    /** Global pool — different deck entirely (lowest priority) */
    GLOBAL_POOL
}
