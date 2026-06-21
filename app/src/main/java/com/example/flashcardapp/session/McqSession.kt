package com.example.flashcardapp.session

import android.os.Handler
import android.os.Looper
import com.example.flashcardapp.mcq.Mcq

/**
 * Modes of the MCQ learning session.
 */
enum class McqSessionMode {
    /**
     * Practice Mode: Instant feedback after answering each question.
     */
    PRACTICE,

    /**
     * Test Mode: Delayed feedback (results shown at the end), timed overall or per question.
     */
    TEST,

    /**
     * Revision Mode: Focuses on weak cards only (instant feedback).
     */
    REVISION
}

/**
 * Records the user's response to a single MCQ question.
 */
data class AnswerRecord(
    val question: Mcq,
    val selectedOptionIndex: Int,
    val isCorrect: Boolean,
    val timeTakenMs: Long
)

/**
 * Immutable representation of the MCQ Session State.
 */
data class McqSessionState(
    val mode: McqSessionMode = McqSessionMode.PRACTICE,
    val questions: List<Mcq> = emptyList(),
    val currentQuestionIndex: Int = 0,
    val score: Int = 0,
    val answeredQuestions: List<AnswerRecord> = emptyList(),
    // Selections mapped by question index
    val selections: Map<Int, Int> = emptyMap(),
    // Question times in milliseconds mapped by question index
    val questionTimingsMs: Map<Int, Long> = emptyMap(),
    val totalTimeTakenMs: Long = 0L,
    val isFinished: Boolean = false
) {
    val currentQuestion: Mcq?
        get() = questions.getOrNull(currentQuestionIndex)

    val progress: Float
        get() = if (questions.isEmpty()) 0f else (currentQuestionIndex.toFloat() / questions.size)

    fun getSelectionForIndex(index: Int): Int? = selections[index]
    fun isQuestionAnswered(index: Int): Boolean = selections.containsKey(index)
}

/**
 * Manages the MCQ session lifecycle, sequence of questions, and state transitions.
 *
 * This system is independent of the UI and raw data layer, complying with clean architecture.
 */
class McqSessionManager(
    private val mode: McqSessionMode,
    private val questions: List<Mcq>
) {
    private var state = McqSessionState(
        mode = mode,
        questions = questions,
        currentQuestionIndex = 0,
        score = 0,
        answeredQuestions = emptyList(),
        selections = emptyMap(),
        questionTimingsMs = emptyMap(),
        totalTimeTakenMs = 0L,
        isFinished = questions.isEmpty()
    )

    private val listeners = mutableListOf<(McqSessionState) -> Unit>()

    init {
        SessionLogger.i(TAG, "═══════════════════════════════════════════════════════")
        SessionLogger.i(TAG, "  MCQ SESSION STARTED")
        SessionLogger.i(TAG, "  Mode:       $mode")
        SessionLogger.i(TAG, "  Questions:  ${questions.size}")
        questions.forEachIndexed { index, mcq ->
            SessionLogger.d(TAG, "    [$index] Card ID: ${mcq.sourceCardId} | Q: ${mcq.question.take(40)}...")
        }
        SessionLogger.i(TAG, "═══════════════════════════════════════════════════════")
    }

    /**
     * Registers a listener to receive state updates.
     */
    fun addListener(listener: (McqSessionState) -> Unit) {
        listeners.add(listener)
        listener(state)
    }

    /**
     * Unregisters a listener.
     */
    fun removeListener(listener: (McqSessionState) -> Unit) {
        listeners.remove(listener)
    }

    /**
     * Gets the current session state.
     */
    fun getCurrentState(): McqSessionState = state

    /**
     * Registers selection of an option for the current question.
     *
     * In [McqSessionMode.PRACTICE] or [McqSessionMode.REVISION], this locks the answer,
     * updates score, records stats, and triggers feedback.
     * In [McqSessionMode.TEST], this records/updates selection temporarily.
     */
    fun selectOption(optionIndex: Int, timeTakenMs: Long): McqSessionState {
        if (state.isFinished) {
            SessionLogger.w(TAG, "Cannot select option: session is finished.")
            return state
        }

        val currentIndex = state.currentQuestionIndex
        val currentMcq = state.currentQuestion ?: return state

        if (mode == McqSessionMode.PRACTICE || mode == McqSessionMode.REVISION) {
            // Instant feedback mode: Ignore if already answered
            if (state.isQuestionAnswered(currentIndex)) {
                return state
            }

            val isCorrect = optionIndex == currentMcq.correctIndex
            val newScore = if (isCorrect) state.score + 1 else state.score

            val record = AnswerRecord(
                question = currentMcq,
                selectedOptionIndex = optionIndex,
                isCorrect = isCorrect,
                timeTakenMs = timeTakenMs
            )

            val updatedSelections = state.selections + (currentIndex to optionIndex)
            val updatedTimings = state.questionTimingsMs + (currentIndex to timeTakenMs)
            val updatedAnswered = state.answeredQuestions + record
            val newTotalTime = state.totalTimeTakenMs + timeTakenMs

            state = state.copy(
                score = newScore,
                selections = updatedSelections,
                questionTimingsMs = updatedTimings,
                answeredQuestions = updatedAnswered,
                totalTimeTakenMs = newTotalTime
            )

            SessionLogger.i(TAG, "  Practice Answer Selected: Q#$currentIndex -> Option $optionIndex | Correct: $isCorrect")
        } else {
            // Test Mode: Temporary selection allowed
            val updatedSelections = state.selections + (currentIndex to optionIndex)
            val previousTime = state.questionTimingsMs[currentIndex] ?: 0L
            val updatedTimings = state.questionTimingsMs + (currentIndex to (previousTime + timeTakenMs))
            val newTotalTime = state.totalTimeTakenMs + timeTakenMs

            state = state.copy(
                selections = updatedSelections,
                questionTimingsMs = updatedTimings,
                totalTimeTakenMs = newTotalTime
            )

            SessionLogger.i(TAG, "  Test Option Selected: Q#$currentIndex -> Option $optionIndex (temporary)")
        }

        notifyListeners()
        return state
    }

    /**
     * Navigates to the next question.
     */
    fun nextQuestion(): McqSessionState {
        if (state.currentQuestionIndex < state.questions.size - 1) {
            state = state.copy(currentQuestionIndex = state.currentQuestionIndex + 1)
            SessionLogger.d(TAG, "  Navigated Next to question ${state.currentQuestionIndex}")
            notifyListeners()
        } else if (mode == McqSessionMode.PRACTICE || mode == McqSessionMode.REVISION) {
            // Practice Mode auto-finishes when clicking Next on the last question
            finishSession()
        }
        return state
    }

    /**
     * Navigates to the previous question.
     */
    fun previousQuestion(): McqSessionState {
        if (state.currentQuestionIndex > 0) {
            state = state.copy(currentQuestionIndex = state.currentQuestionIndex - 1)
            SessionLogger.d(TAG, "  Navigated Previous to question ${state.currentQuestionIndex}")
            notifyListeners()
        }
        return state
    }

    var onSessionFinished: ((McqSessionState) -> Unit)? = null

    /**
     * Finishes the session, calculating scores for Test Mode and setting isFinished to true.
     */
    fun finishSession(): McqSessionState {
        if (state.isFinished) return state

        if (mode == McqSessionMode.TEST) {
            // Evaluate all selections for TEST mode
            var finalScore = 0
            val records = mutableListOf<AnswerRecord>()

            state.questions.forEachIndexed { index, mcq ->
                val selection = state.selections[index] ?: -1 // -1 means unanswered
                val isCorrect = selection == mcq.correctIndex
                if (isCorrect) finalScore++

                val time = state.questionTimingsMs[index] ?: 0L
                records.add(
                    AnswerRecord(
                        question = mcq,
                        selectedOptionIndex = selection,
                        isCorrect = isCorrect,
                        timeTakenMs = time
                    )
                )
            }

            state = state.copy(
                score = finalScore,
                answeredQuestions = records,
                isFinished = true
            )
        } else {
            state = state.copy(isFinished = true)
        }

        SessionLogger.i(TAG, "═══════════════════════════════════════════════════════")
        SessionLogger.i(TAG, "  MCQ SESSION FINISHED")
        SessionLogger.i(TAG, "  Final Score: ${state.score}/${state.questions.size}")
        SessionLogger.i(TAG, "  Total Time:  ${state.totalTimeTakenMs}ms")
        SessionLogger.i(TAG, "═══════════════════════════════════════════════════════")

        notifyListeners()
        onSessionFinished?.invoke(state)
        return state
    }

    /**
     * Updates the current question in the session state (e.g., after an edit).
     */
    fun updateCurrentQuestion(updatedMcq: Mcq) {
        if (state.questions.isEmpty()) return
        val updatedQuestions = state.questions.toMutableList()
        updatedQuestions[state.currentQuestionIndex] = updatedMcq
        state = state.copy(questions = updatedQuestions)
        SessionLogger.d(TAG, "  Current question updated (ID: ${updatedMcq.sourceCardId})")
        notifyListeners()
    }

    /**
     * Inserts a new question immediately after the current question.
     */
    fun insertNextQuestion(newMcq: Mcq) {
        val updatedQuestions = state.questions.toMutableList()
        if (state.questions.isEmpty()) {
            updatedQuestions.add(newMcq)
        } else {
            updatedQuestions.add(state.currentQuestionIndex + 1, newMcq)
        }
        state = state.copy(questions = updatedQuestions)
        SessionLogger.d(TAG, "  New question inserted at index ${if (state.questions.size == 1) 0 else state.currentQuestionIndex + 1} (ID: ${newMcq.sourceCardId})")
        notifyListeners()
    }

    /**
     * Deletes the current question from the session state.
     */
    fun deleteCurrentQuestion() {
        if (state.questions.isEmpty()) return
        val currentIndex = state.currentQuestionIndex
        val updatedQuestions = state.questions.toMutableList()
        val currentMcq = state.currentQuestion
        updatedQuestions.removeAt(currentIndex)
        
        val newIndex = when {
            updatedQuestions.isEmpty() -> 0
            currentIndex >= updatedQuestions.size -> updatedQuestions.size - 1
            else -> currentIndex
        }
        
        val updatedSelections = mutableMapOf<Int, Int>()
        state.selections.forEach { (idx, value) ->
            if (idx < currentIndex) {
                updatedSelections[idx] = value
            } else if (idx > currentIndex) {
                updatedSelections[idx - 1] = value
            }
        }
        val updatedTimings = mutableMapOf<Int, Long>()
        state.questionTimingsMs.forEach { (idx, value) ->
            if (idx < currentIndex) {
                updatedTimings[idx] = value
            } else if (idx > currentIndex) {
                updatedTimings[idx - 1] = value
            }
        }
        
        val updatedAnswered = state.answeredQuestions.filter { it.question.sourceCardId != currentMcq?.sourceCardId }

        state = state.copy(
            questions = updatedQuestions,
            currentQuestionIndex = newIndex,
            selections = updatedSelections,
            questionTimingsMs = updatedTimings,
            answeredQuestions = updatedAnswered,
            isFinished = updatedQuestions.isEmpty()
        )
        SessionLogger.d(TAG, "  Current question deleted from session (index: $currentIndex)")
        notifyListeners()
    }

    private val mainHandler: Handler? by lazy {
        try {
            Handler(Looper.getMainLooper())
        } catch (e: Exception) {
            null
        }
    }

    private fun notifyListeners() {
        // Snapshot the state and listener list to avoid races / ConcurrentModificationException.
        val snapshot = state
        val listenersCopy = listeners.toList()
        val handler = mainHandler
        if (handler != null) {
            // Post to main looper so callers on any thread don't block the composition thread.
            handler.post {
                listenersCopy.forEach { it(snapshot) }
            }
        } else {
            listenersCopy.forEach { it(snapshot) }
        }
    }

    companion object {
        private const val TAG = "McqSessionDiagnostics"
    }
}
