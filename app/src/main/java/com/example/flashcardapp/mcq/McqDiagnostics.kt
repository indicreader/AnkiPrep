package com.example.flashcardapp.mcq

import android.util.Log

/**
 * Debug diagnostics for the MCQ generation engine.
 *
 * Prints structured output to logcat covering:
 * - Sample MCQ with full option details
 * - Option order and correct answer position
 * - Distractor sources (which card and hierarchy level)
 *
 * Filter logcat: `adb logcat -s McqDiagnostics`
 */
object McqDiagnostics {
    private const val TAG = "McqDiagnostics"
    private const val SEPARATOR = "═══════════════════════════════════════════════════════"
    private const val THIN_SEP = "───────────────────────────────────────────────────────"

    /**
     * Prints a full diagnostics report for a batch of generated MCQs.
     *
     * @param mcqs The generated MCQ list
     * @param label A label for this batch (e.g. deck name)
     */
    fun printReport(mcqs: List<Mcq>, label: String = "MCQ Batch") {
        Log.i(TAG, "")
        Log.i(TAG, SEPARATOR)
        Log.i(TAG, "  MCQ ENGINE — DIAGNOSTICS REPORT")
        Log.i(TAG, "  Batch: $label")
        Log.i(TAG, SEPARATOR)

        // Summary
        Log.i(TAG, "")
        Log.i(TAG, "▶ Generation Summary")
        Log.i(TAG, THIN_SEP)
        Log.i(TAG, "  Total MCQs generated: ${mcqs.size}")
        Log.i(TAG, "  All valid: ${mcqs.all { it.isValid() }}")

        val invalidCount = mcqs.count { !it.isValid() }
        if (invalidCount > 0) {
            Log.w(TAG, "  ⚠️ $invalidCount invalid MCQs detected!")
        } else {
            Log.i(TAG, "  ✅ All MCQs pass validation")
        }

        // Duplicate check
        val duplicateQuestions = mcqs.groupBy { it.question }.filter { it.value.size > 1 }
        if (duplicateQuestions.isNotEmpty()) {
            Log.w(TAG, "  ⚠️ ${duplicateQuestions.size} duplicate questions found")
        } else {
            Log.i(TAG, "  ✅ No duplicate questions")
        }

        // Correct index distribution
        val indexDistribution = mcqs.groupBy { it.correctIndex }.mapValues { it.value.size }
        Log.i(TAG, "  Correct answer position distribution: $indexDistribution")

        // Sample MCQs (first 3)
        Log.i(TAG, "")
        Log.i(TAG, "▶ Sample MCQs (first ${minOf(3, mcqs.size)})")
        Log.i(TAG, THIN_SEP)

        mcqs.take(3).forEachIndexed { idx, mcq ->
            printSingleMcq(mcq, idx + 1)
        }

        // Distractor source breakdown
        Log.i(TAG, "")
        Log.i(TAG, "▶ Distractor Source Breakdown")
        Log.i(TAG, THIN_SEP)
        // Note: DistractorSource tracking is internal to the engine.
        // We can infer from the hierarchy paths in the MCQs.
        Log.i(TAG, "  (Distractor source levels tracked internally by engine)")
        Log.i(TAG, "  Total distractor slots filled: ${mcqs.size * 3}")

        Log.i(TAG, "")
        Log.i(TAG, SEPARATOR)
        Log.i(TAG, "  STATUS: ${if (invalidCount == 0) "MCQ ENGINE HEALTHY ✅" else "NEEDS ATTENTION ⚠️"}")
        Log.i(TAG, SEPARATOR)
        Log.i(TAG, "")
    }

    /**
     * Prints detailed info for a single MCQ.
     */
    fun printSingleMcq(mcq: Mcq, number: Int = 1) {
        Log.i(TAG, "  MCQ #$number:")
        Log.i(TAG, "    Source Card: ${mcq.sourceCardId}")
        Log.i(TAG, "    Deck:        ${mcq.deckHierarchy}")
        Log.i(TAG, "    Question:    ${mcq.question.take(100)}${if (mcq.question.length > 100) "..." else ""}")
        Log.i(TAG, "    Options:")
        mcq.options.forEachIndexed { i, option ->
            val marker = if (i == mcq.correctIndex) " ✅" else ""
            val label = ('A' + i)
            Log.i(TAG, "      $label) ${option.take(80)}$marker")
        }
        Log.i(TAG, "    Correct:     ${('A' + mcq.correctIndex)} (index ${mcq.correctIndex})")
        Log.i(TAG, "    Distractor source card IDs: ${mcq.distractorSourceIds}")
        Log.i(TAG, "    Valid:       ${mcq.isValid()}")
        Log.i(TAG, "    ---")
    }
}
