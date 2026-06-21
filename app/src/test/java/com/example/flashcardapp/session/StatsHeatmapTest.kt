package com.example.flashcardapp.session

import com.example.flashcardapp.data.entities.SessionRecordEntity
import org.junit.Assert.*
import org.junit.Test
import java.util.Calendar

/**
 * Unit tests for Stats + Heatmap System.
 *
 * Test cases per requirements:
 * 1. Calendar color correctness
 * 2. Multi-mode same-day behavior
 * 3. Mastery calculations
 */
class StatsHeatmapTest {

    private fun createRecord(
        mode: String,
        score: Int,
        totalQuestions: Int,
        daysAgo: Int = 0
    ): SessionRecordEntity {
        val cal = Calendar.getInstance()
        cal.add(Calendar.DAY_OF_YEAR, -daysAgo)
        return SessionRecordEntity(
            deckId = 1L,
            deckName = "Test Deck",
            mode = mode,
            score = score,
            totalQuestions = totalQuestions,
            timeTakenSeconds = 60,
            timestamp = cal.timeInMillis
        )
    }

    // ========================================================================
    // Test Case 1: Calendar color correctness
    // ========================================================================

    @Test
    fun `heatmap entry practice completed flag is correct`() {
        val records = listOf(
            createRecord(mode = "PRACTICE", score = 5, totalQuestions = 5, daysAgo = 0)
        )
        val heatmap = StatsHeatmapProcessor.computeHeatmapData(records)
        assertEquals(1, heatmap.size)
        assertTrue(heatmap[0].practiceCompleted)
        assertFalse(heatmap[0].revisionCompleted)
        assertFalse(heatmap[0].testCompleted)
        assertFalse(heatmap[0].allModesCompleted)
    }

    @Test
    fun `heatmap entry revision completed flag is correct`() {
        val records = listOf(
            createRecord(mode = "REVISION", score = 3, totalQuestions = 5, daysAgo = 0)
        )
        val heatmap = StatsHeatmapProcessor.computeHeatmapData(records)
        assertEquals(1, heatmap.size)
        assertFalse(heatmap[0].practiceCompleted)
        assertTrue(heatmap[0].revisionCompleted)
        assertFalse(heatmap[0].testCompleted)
        assertFalse(heatmap[0].allModesCompleted)
    }

    @Test
    fun `heatmap entry test completed flag is correct`() {
        val records = listOf(
            createRecord(mode = "TEST", score = 4, totalQuestions = 5, daysAgo = 0)
        )
        val heatmap = StatsHeatmapProcessor.computeHeatmapData(records)
        assertEquals(1, heatmap.size)
        assertFalse(heatmap[0].practiceCompleted)
        assertFalse(heatmap[0].revisionCompleted)
        assertTrue(heatmap[0].testCompleted)
        assertFalse(heatmap[0].allModesCompleted)
    }

    // ========================================================================
    // Test Case 2: Multi-mode same-day behavior
    // ========================================================================

    @Test
    fun `multiple modes on same day sets all completed flags`() {
        val records = listOf(
            createRecord(mode = "PRACTICE", score = 3, totalQuestions = 5, daysAgo = 0),
            createRecord(mode = "REVISION", score = 2, totalQuestions = 5, daysAgo = 0),
            createRecord(mode = "TEST", score = 4, totalQuestions = 5, daysAgo = 0)
        )
        val heatmap = StatsHeatmapProcessor.computeHeatmapData(records)
        assertEquals(1, heatmap.size)
        assertTrue(heatmap[0].practiceCompleted)
        assertTrue(heatmap[0].revisionCompleted)
        assertTrue(heatmap[0].testCompleted)
        assertTrue(heatmap[0].allModesCompleted)
    }

    @Test
    fun `datesWithAllModesCompleted returns correct dates`() {
        val records = listOf(
            createRecord(mode = "PRACTICE", score = 3, totalQuestions = 5, daysAgo = 0),
            createRecord(mode = "REVISION", score = 2, totalQuestions = 5, daysAgo = 0),
            createRecord(mode = "TEST", score = 4, totalQuestions = 5, daysAgo = 0),
            createRecord(mode = "PRACTICE", score = 5, totalQuestions = 5, daysAgo = 1),
            createRecord(mode = "TEST", score = 5, totalQuestions = 5, daysAgo = 1)
        )
        val allModesDates = StatsHeatmapProcessor.datesWithAllModesCompleted(records)
        assertEquals(1, allModesDates.size)
    }

    @Test
    fun `heatmap groups records by day correctly`() {
        val records = listOf(
            createRecord(mode = "PRACTICE", score = 3, totalQuestions = 5, daysAgo = 0),
            createRecord(mode = "PRACTICE", score = 4, totalQuestions = 5, daysAgo = 0),
            createRecord(mode = "PRACTICE", score = 2, totalQuestions = 5, daysAgo = 1)
        )
        val heatmap = StatsHeatmapProcessor.computeHeatmapData(records)
        assertEquals(2, heatmap.size)
    }

    // ========================================================================
    // Test Case 3: Mastery calculations
    // ========================================================================

    @Test
    fun `learning stats calculates mastered cards correctly`() {
        val totalCards = 100
        val records = listOf(
            createRecord(mode = "PRACTICE", score = 10, totalQuestions = 10, daysAgo = 0),
            createRecord(mode = "TEST", score = 15, totalQuestions = 20, daysAgo = 1)
        )
        val stats = StatsHeatmapProcessor.computeLearningStats(totalCards, records)
        assertEquals(25, stats.masteredCards)
    }

    @Test
    fun `learning stats calculates revision due correctly`() {
        val totalCards = 100
        val records = listOf(
            createRecord(mode = "REVISION", score = 5, totalQuestions = 10, daysAgo = 0),
            createRecord(mode = "REVISION", score = 3, totalQuestions = 10, daysAgo = 1)
        )
        val stats = StatsHeatmapProcessor.computeLearningStats(totalCards, records)
        assertEquals(12, stats.revisionDue)
    }

    @Test
    fun `learning stats calculates untouched cards correctly`() {
        val totalCards = 100
        val records = listOf(
            createRecord(mode = "PRACTICE", score = 5, totalQuestions = 20, daysAgo = 0),
            createRecord(mode = "TEST", score = 10, totalQuestions = 30, daysAgo = 1)
        )
        val stats = StatsHeatmapProcessor.computeLearningStats(totalCards, records)
        assertEquals(50, stats.untouchedCards)
    }

    @Test
    fun `learning stats calculates total attempts correctly`() {
        val totalCards = 100
        val records = listOf(
            createRecord(mode = "PRACTICE", score = 5, totalQuestions = 10, daysAgo = 0),
            createRecord(mode = "TEST", score = 8, totalQuestions = 15, daysAgo = 1),
            createRecord(mode = "REVISION", score = 3, totalQuestions = 5, daysAgo = 2)
        )
        val stats = StatsHeatmapProcessor.computeLearningStats(totalCards, records)
        assertEquals(30, stats.totalAttempts)
    }

    @Test
    fun `learning stats calculates accuracy correctly`() {
        val totalCards = 100
        val records = listOf(
            createRecord(mode = "PRACTICE", score = 8, totalQuestions = 10, daysAgo = 0),
            createRecord(mode = "TEST", score = 15, totalQuestions = 20, daysAgo = 1)
        )
        val stats = StatsHeatmapProcessor.computeLearningStats(totalCards, records)
        assertEquals(76.67f, stats.accuracy, 0.01f)
    }

    @Test
    fun `learning stats with no records returns zeros`() {
        val stats = StatsHeatmapProcessor.computeLearningStats(100, emptyList())
        assertEquals(0, stats.masteredCards)
        assertEquals(0, stats.revisionDue)
        assertEquals(100, stats.untouchedCards)
        assertEquals(0, stats.totalAttempts)
        assertEquals(0f, stats.accuracy, 0.01f)
    }

    @Test
    fun `heatmap with empty records returns empty list`() {
        val heatmap = StatsHeatmapProcessor.computeHeatmapData(emptyList())
        assertTrue(heatmap.isEmpty())
    }

    @Test
    fun `dates with all modes completed handles empty records`() {
        val dates = StatsHeatmapProcessor.datesWithAllModesCompleted(emptyList())
        assertTrue(dates.isEmpty())
    }
}