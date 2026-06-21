package com.example.flashcardapp.session

import com.example.flashcardapp.data.entities.SessionRecordEntity
import java.util.Calendar

/**
 * Calculates the user's study streak — consecutive calendar days with at least one session.
 */
object StreakCalculator {

    data class StreakInfo(
        /** Current consecutive day streak. */
        val currentStreak: Int,
        /** Longest streak ever recorded. */
        val longestStreak: Int,
        /** Whether the user has studied today. */
        val studiedToday: Boolean,
        /** Number of unique days studied in the last 30 days. */
        val activeDaysLast30: Int
    )

    /**
     * Computes streak metrics from the list of completed session records.
     * Sessions are grouped by calendar day (local time) and counted.
     */
    fun calculate(records: List<SessionRecordEntity>): StreakInfo {
        if (records.isEmpty()) {
            return StreakInfo(
                currentStreak = 0,
                longestStreak = 0,
                studiedToday = false,
                activeDaysLast30 = 0
            )
        }

        // Collect unique study days as epoch-day integers (midnight-aligned)
        val studyDays = records
            .map { epochDayOf(it.timestamp) }
            .toSortedSet()

        val todayEpochDay = epochDayOf(System.currentTimeMillis())
        val studiedToday = studyDays.contains(todayEpochDay)

        // Current streak: count backwards from today
        var currentStreak = 0
        var day = todayEpochDay
        while (studyDays.contains(day)) {
            currentStreak++
            day--
        }
        // If not studied today, check if yesterday was the last session (streak still alive)
        if (!studiedToday) {
            var yesterdayStreak = 0
            var d = todayEpochDay - 1
            while (studyDays.contains(d)) {
                yesterdayStreak++
                d--
            }
            currentStreak = yesterdayStreak
        }

        // Longest streak: sliding window through sorted days
        var longestStreak = 0
        var runLength = 1
        val daysList = studyDays.toList()
        for (i in 1 until daysList.size) {
            if (daysList[i] == daysList[i - 1] + 1) {
                runLength++
            } else {
                longestStreak = maxOf(longestStreak, runLength)
                runLength = 1
            }
        }
        longestStreak = maxOf(longestStreak, runLength)

        // Active days in last 30 calendar days
        val thirtyDaysAgo = todayEpochDay - 29
        val activeDaysLast30 = studyDays.count { it in thirtyDaysAgo..todayEpochDay }

        return StreakInfo(
            currentStreak = currentStreak,
            longestStreak = longestStreak,
            studiedToday = studiedToday,
            activeDaysLast30 = activeDaysLast30
        )
    }

    /** Returns midnight-aligned epoch day for a given timestamp (milliseconds). */
    private fun epochDayOf(timestampMs: Long): Int {
        val cal = Calendar.getInstance()
        cal.timeInMillis = timestampMs
        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)
        return (cal.timeInMillis / 86_400_000L).toInt()
    }
}
