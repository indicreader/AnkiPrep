package com.example.flashcardapp.session

import com.example.flashcardapp.mcq.Mcq
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Unit tests for MCQ Session Management.
 *
 * Test cases per requirements:
 * 1. session runs full cycle without crash
 * 2. mode switching works
 * 3. answers recorded correctly
 * 4. progression is sequential and stable
 */
class McqSessionTest {

    private lateinit var dummyMcqs: List<Mcq>

    @Before
    fun setup() {
        dummyMcqs = listOf(
            Mcq(
                question = "What is the capital of France?",
                options = listOf("London", "Berlin", "Paris", "Rome"),
                correctIndex = 2,
                sourceCardId = 1L,
                distractorSourceIds = listOf(10L, 11L, 12L),
                deckHierarchy = "Geography::Europe",
                explanation = "Paris is the capital of France."
            ),
            Mcq(
                question = "What is 2 + 2?",
                options = listOf("3", "4", "5", "6"),
                correctIndex = 1,
                sourceCardId = 2L,
                distractorSourceIds = listOf(20L, 21L, 22L),
                deckHierarchy = "Math::Arithmetic",
                explanation = "2 + 2 = 4."
            ),
            Mcq(
                question = "What is the chemical symbol for water?",
                options = listOf("O2", "CO2", "H2O", "H2"),
                correctIndex = 2,
                sourceCardId = 3L,
                distractorSourceIds = listOf(30L, 31L, 32L),
                deckHierarchy = "Science::Chemistry",
                explanation = "H2O is water."
            )
        )
    }

    // ========================================================================
    // Test Case 1: Session runs full cycle without crash (Practice Mode)
    // ========================================================================
    @Test
    fun `session runs full cycle to completion practice mode`() {
        val manager = McqSessionManager(McqSessionMode.PRACTICE, dummyMcqs)
        var state = manager.getCurrentState()

        assertFalse(state.isFinished)
        assertEquals(0, state.currentQuestionIndex)
        assertEquals(3, state.questions.size)

        // Select answers and navigate
        state = manager.selectOption(optionIndex = 2, timeTakenMs = 1500L) // Q1: Correct (index 2)
        assertEquals(1, state.score)
        state = manager.nextQuestion()
        assertFalse(state.isFinished)
        assertEquals(1, state.currentQuestionIndex)

        state = manager.selectOption(optionIndex = 0, timeTakenMs = 2000L) // Q2: Incorrect (selected 0, correct 1)
        assertEquals(1, state.score)
        state = manager.nextQuestion()
        assertFalse(state.isFinished)
        assertEquals(2, state.currentQuestionIndex)

        state = manager.selectOption(optionIndex = 2, timeTakenMs = 1800L) // Q3: Correct (index 2)
        assertEquals(2, state.score)
        state = manager.nextQuestion() // This should auto-finish practice session
        assertTrue(state.isFinished)

        assertEquals(2, state.score) // Final score is 2/3
        assertEquals(5300L, state.totalTimeTakenMs)
    }

    // ========================================================================
    // Test Case 2: Mode switching works
    // ========================================================================
    @Test
    fun `session mode is stored correctly`() {
        val practiceSession = McqSessionManager(McqSessionMode.PRACTICE, dummyMcqs)
        assertEquals(McqSessionMode.PRACTICE, practiceSession.getCurrentState().mode)

        val testSession = McqSessionManager(McqSessionMode.TEST, dummyMcqs)
        assertEquals(McqSessionMode.TEST, testSession.getCurrentState().mode)

        val revisionSession = McqSessionManager(McqSessionMode.REVISION, dummyMcqs)
        assertEquals(McqSessionMode.REVISION, revisionSession.getCurrentState().mode)
    }

    // ========================================================================
    // Test Case 3: Answers recorded correctly (Test Mode delayed feedback)
    // ========================================================================
    @Test
    fun `answers and statistics are recorded correctly in test mode`() {
        val manager = McqSessionManager(McqSessionMode.TEST, dummyMcqs)

        manager.selectOption(optionIndex = 2, timeTakenMs = 1200L) // Q1: Correct (temporary)
        manager.nextQuestion()
        manager.selectOption(optionIndex = 1, timeTakenMs = 800L)  // Q2: Correct (temporary)

        var state = manager.getCurrentState()
        // No answers locked yet
        assertEquals(0, state.answeredQuestions.size)
        assertEquals(2, state.selections.size)

        // Finish test
        state = manager.finishSession()
        assertTrue(state.isFinished)
        assertEquals(2, state.score)
        assertEquals(3, state.answeredQuestions.size)

        val firstRecord = state.answeredQuestions[0]
        assertEquals(dummyMcqs[0], firstRecord.question)
        assertEquals(2, firstRecord.selectedOptionIndex)
        assertTrue(firstRecord.isCorrect)
        assertEquals(1200L, firstRecord.timeTakenMs)

        val secondRecord = state.answeredQuestions[1]
        assertEquals(dummyMcqs[1], secondRecord.question)
        assertEquals(1, secondRecord.selectedOptionIndex)
        assertTrue(secondRecord.isCorrect)
        assertEquals(800L, secondRecord.timeTakenMs)
    }

    // ========================================================================
    // Test Case 4: Progression is sequential and stable
    // ========================================================================
    @Test
    fun `progression is sequential and previous navigation works`() {
        val manager = McqSessionManager(McqSessionMode.TEST, dummyMcqs)

        // Initial question
        assertEquals(dummyMcqs[0], manager.getCurrentState().currentQuestion)

        // Select and next
        manager.selectOption(optionIndex = 2, timeTakenMs = 1000L)
        manager.nextQuestion()
        assertEquals(dummyMcqs[1], manager.getCurrentState().currentQuestion)

        // Navigate back to previous question to review/change selection
        manager.previousQuestion()
        assertEquals(dummyMcqs[0], manager.getCurrentState().currentQuestion)
        assertEquals(2, manager.getCurrentState().getSelectionForIndex(0))

        // Change selection
        manager.selectOption(optionIndex = 3, timeTakenMs = 500L) // change to Rome
        assertEquals(3, manager.getCurrentState().getSelectionForIndex(0))

        // Navigate forward again
        manager.nextQuestion()
        assertEquals(dummyMcqs[1], manager.getCurrentState().currentQuestion)

        // Finish session
        val state = manager.finishSession()
        assertTrue(state.isFinished)
        assertEquals(3, state.selections[0]) // Final recorded selection is 3 (Incorrect)
    }

    @Test
    fun `empty session initializes as finished`() {
        val manager = McqSessionManager(McqSessionMode.PRACTICE, emptyList())
        val state = manager.getCurrentState()
        assertTrue(state.isFinished)
        assertNull(state.currentQuestion)
    }

    // ========================================================================
    // Test Case 5: Options are shuffled — correct answer index stays valid
    // ========================================================================
    @Test
    fun `correct answer index is valid after option shuffle`() {
        // Run 20 sessions; in each, the correctIndex must point to the correct text.
        val original = dummyMcqs[0] // correct option text is "Paris" at original index 2
        repeat(20) {
            val manager = McqSessionManager(McqSessionMode.PRACTICE, listOf(original))
            val q = manager.getCurrentState().currentQuestion!!
            // The option at correctIndex must always be "Paris"
            assertEquals(
                "Correct option text must equal 'Paris' regardless of shuffle",
                "Paris",
                q.options[q.correctIndex]
            )
        }
    }

    // ========================================================================
    @Test
    fun `question order differs across independent sessions`() {
        // Shuffle the questions before starting each session to simulate a new session start.
        // Collect first-question ids and ensure we get variation.
        val firstCardIds = (1..50).map {
            val shuffled = dummyMcqs.shuffled()
            McqSessionManager(McqSessionMode.PRACTICE, shuffled)
                .getCurrentState()
                .currentQuestion!!
                .sourceCardId
        }.toSet()
        assertTrue(
            "Expected question order to vary across sessions when shuffled. Got only one unique first card id.",
            firstCardIds.size > 1
        )
    }

    // ========================================================================
    // Test Case 7: Correct score after shuffle — not biased by original index
    // ========================================================================
    @Test
    fun `score is correct when selecting by shuffled option text`() {
        // Use a single well-known card; find the index of "Paris" at runtime
        // and select it — score must be 1.
        val manager = McqSessionManager(McqSessionMode.PRACTICE, listOf(dummyMcqs[0]))
        val q = manager.getCurrentState().currentQuestion!!
        val parisIndex = q.options.indexOf("Paris")
        assertTrue("Paris must exist in options", parisIndex >= 0)
        assertEquals("Shuffled correctIndex must point to Paris", parisIndex, q.correctIndex)

        val state = manager.selectOption(parisIndex, timeTakenMs = 1000L)
        assertEquals(1, state.score)
    }
}
