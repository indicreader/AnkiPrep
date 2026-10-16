package com.example.flashcardapp.mock

import com.example.flashcardapp.mcq.Mcq

object MockExamEvaluator {

    /**
     * Calculates the official scorecard adhering strictly to the exam preset's negative marking rules.
     */
    fun evaluate(
        examTitle: String,
        questions: List<Mcq>,
        attempts: Map<Int, QuestionAttemptState>,
        positiveMark: Float,
        negativePenalty: Float,
        totalTimeSeconds: Long
    ): MockExamScorecard {
        var correctCount = 0
        var incorrectCount = 0
        var skippedCount = 0

        val detailList = mutableListOf<QuestionResultDetail>()

        for (i in questions.indices) {
            val mcq = questions[i]
            val attempt = attempts[i] ?: QuestionAttemptState(questionIndex = i)
            val selected = attempt.selectedOptionIndex
            val isAttempted = selected != null

            var marks = 0f
            var isCorrect = false

            if (isAttempted) {
                if (selected == mcq.correctIndex) {
                    correctCount++
                    marks = positiveMark
                    isCorrect = true
                } else {
                    incorrectCount++
                    marks = -negativePenalty
                    isCorrect = false
                }
            } else {
                skippedCount++
                marks = 0f
            }

            detailList.add(
                QuestionResultDetail(
                    questionIndex = i,
                    mcq = mcq,
                    selectedOptionIndex = selected,
                    isCorrect = isCorrect,
                    isAttempted = isAttempted,
                    status = attempt.status,
                    timeSpentSeconds = attempt.timeSpentSeconds,
                    marksAwarded = marks
                )
            )
        }

        val positiveTotal = correctCount * positiveMark
        val negativeTotal = incorrectCount * negativePenalty
        val netScore = positiveTotal - negativeTotal
        val maxScore = questions.size * positiveMark
        val accuracy = if (correctCount + incorrectCount > 0) {
            (correctCount.toFloat() / (correctCount + incorrectCount)) * 100f
        } else {
            0f
        }

        return MockExamScorecard(
            examTitle = examTitle,
            totalQuestions = questions.size,
            attempted = correctCount + incorrectCount,
            correct = correctCount,
            incorrect = incorrectCount,
            skipped = skippedCount,
            positiveMarks = positiveTotal,
            negativeMarks = negativeTotal,
            netScore = netScore,
            maxScore = maxScore,
            accuracyPercentage = accuracy,
            totalTimeSeconds = totalTimeSeconds,
            details = detailList
        )
    }
}
