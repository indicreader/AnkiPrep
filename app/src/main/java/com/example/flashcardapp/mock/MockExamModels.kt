package com.example.flashcardapp.mock

import com.example.flashcardapp.mcq.Mcq

/**
 * Standard competitive exam configurations with negative marking rules.
 */
enum class ExamPreset(
    val title: String,
    val durationMinutes: Int,
    val positiveMarks: Float,
    val negativePenalty: Float,
    val description: String
) {
    SSC_CGL(
        title = "SSC CGL / CHSL",
        durationMinutes = 60,
        positiveMarks = 2.0f,
        negativePenalty = 0.50f,
        description = "+2 for correct, -0.50 for wrong (1/4th penalty)"
    ),
    UPSC_PRELIMS(
        title = "UPSC Civil Services (GS)",
        durationMinutes = 120,
        positiveMarks = 2.0f,
        negativePenalty = 0.667f,
        description = "+2 for correct, -0.66 for wrong (1/3rd penalty)"
    ),
    NEET(
        title = "NEET / Medical Entrance",
        durationMinutes = 180,
        positiveMarks = 4.0f,
        negativePenalty = 1.0f,
        description = "+4 for correct, -1.0 for wrong (1/4th penalty)"
    ),
    BANKING_IBPS(
        title = "Banking / IBPS PO",
        durationMinutes = 60,
        positiveMarks = 1.0f,
        negativePenalty = 0.25f,
        description = "+1 for correct, -0.25 for wrong (1/4th penalty)"
    ),
    RAPID_PRACTICE(
        title = "Rapid Drill (15 Mins)",
        durationMinutes = 15,
        positiveMarks = 1.0f,
        negativePenalty = 0.33f,
        description = "Quick timed drill with negative marking"
    ),
    CUSTOM(
        title = "Custom Configuration",
        durationMinutes = 30,
        positiveMarks = 1.0f,
        negativePenalty = 0.25f,
        description = "Configure custom time and penalty"
    )
}

/**
 * Question Status in real competitive exam palettes.
 */
enum class QuestionStatus(val label: String, val colorHex: Long) {
    NOT_VISITED("Not Visited", 0xFF6C757D),           // Grey
    NOT_ANSWERED("Not Answered", 0xFFE63946),        // Red
    ANSWERED("Answered", 0xFF2A9D8F),                 // Green
    MARKED_FOR_REVIEW("Marked Review", 0xFF8338EC),  // Purple
    ANSWERED_AND_MARKED("Ans & Review", 0xFF3A86FF)   // Blue
}

/**
 * Live state of an individual question during a mock test.
 */
data class QuestionAttemptState(
    val questionIndex: Int,
    var selectedOptionIndex: Int? = null,
    var status: QuestionStatus = QuestionStatus.NOT_VISITED,
    var timeSpentSeconds: Long = 0
)

/**
 * Detail for question-by-question post-exam audit.
 */
data class QuestionResultDetail(
    val questionIndex: Int,
    val mcq: Mcq,
    val selectedOptionIndex: Int?,
    val isCorrect: Boolean,
    val isAttempted: Boolean,
    val status: QuestionStatus,
    val timeSpentSeconds: Long,
    val marksAwarded: Float
)

/**
 * Comprehensive Scorecard generated at the end of a Mock Exam.
 */
data class MockExamScorecard(
    val examTitle: String,
    val totalQuestions: Int,
    val attempted: Int,
    val correct: Int,
    val incorrect: Int,
    val skipped: Int,
    val positiveMarks: Float,
    val negativeMarks: Float,
    val netScore: Float,
    val maxScore: Float,
    val accuracyPercentage: Float,
    val totalTimeSeconds: Long,
    val details: List<QuestionResultDetail>
) {
    val speedSecondsPerQuestion: Float
        get() = if (attempted > 0) totalTimeSeconds.toFloat() / attempted else 0f
}
