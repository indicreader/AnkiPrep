package com.example.flashcardapp.session

import com.example.flashcardapp.data.entities.SessionRecordEntity
import java.util.Calendar

data class HeatmapEntry(
    val date: Long,
    val practiceCompleted: Boolean = false,
    val revisionCompleted: Boolean = false,
    val testCompleted: Boolean = false
) {
    val allModesCompleted: Boolean
        get() = practiceCompleted && revisionCompleted && testCompleted
}

data class DailyModeStats(
    val date: Long,
    val practiceCount: Int = 0,
    val revisionCount: Int = 0,
    val testCount: Int = 0
)

data class LearningStats(
    val masteredCards: Int = 0,
    val revisionDue: Int = 0,
    val untouchedCards: Int = 0,
    val totalAttempts: Int = 0,
    val accuracy: Float = 0f
)

object StatsHeatmapProcessor {

    fun computeHeatmapData(records: List<SessionRecordEntity>): List<HeatmapEntry> {
        val dailyStatsMap = mutableMapOf<Long, DailyModeStats>()

        records.forEach { record ->
            val date = truncateToDay(record.timestamp)
            val current = dailyStatsMap[date] ?: DailyModeStats(date = date)
            val updated = when (record.mode) {
                "PRACTICE" -> current.copy(practiceCount = current.practiceCount + 1)
                "REVISION" -> current.copy(revisionCount = current.revisionCount + 1)
                "TEST" -> current.copy(testCount = current.testCount + 1)
                else -> current
            }
            dailyStatsMap[date] = updated
        }

        return dailyStatsMap.values.map { stats ->
            HeatmapEntry(
                date = stats.date,
                practiceCompleted = stats.practiceCount > 0,
                revisionCompleted = stats.revisionCount > 0,
                testCompleted = stats.testCount > 0
            )
        }.sortedBy { it.date }
    }

    fun computeLearningStats(
        totalCards: Int,
        sessionRecords: List<SessionRecordEntity>
    ): LearningStats {
        val totalAttempts = sessionRecords.sumOf { it.totalQuestions }
        val totalCorrect = sessionRecords.sumOf { it.score }
        val accuracy = if (totalAttempts > 0) {
            (totalCorrect.toFloat() / totalAttempts * 100f)
        } else 0f

        val cardsAttempted = sessionRecords.sumOf { it.totalQuestions }
        val untouchedCards = maxOf(0, totalCards - cardsAttempted)

        val revisionDue = sessionRecords
            .filter { it.mode == "REVISION" }
            .sumOf { it.totalQuestions - it.score }

        val masteredCards = sessionRecords
            .filter { it.mode == "PRACTICE" || it.mode == "TEST" }
            .sumOf { it.score }

        return LearningStats(
            masteredCards = masteredCards,
            revisionDue = revisionDue,
            untouchedCards = untouchedCards,
            totalAttempts = totalAttempts,
            accuracy = accuracy
        )
    }

    fun datesWithAllModesCompleted(records: List<SessionRecordEntity>): Set<Long> {
        val heatmapData = computeHeatmapData(records)
        return heatmapData
            .filter { it.allModesCompleted }
            .map { it.date }
            .toSet()
    }

    private fun truncateToDay(timestamp: Long): Long {
        val cal = Calendar.getInstance()
        cal.timeInMillis = timestamp
        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)
        return cal.timeInMillis
    }
}
