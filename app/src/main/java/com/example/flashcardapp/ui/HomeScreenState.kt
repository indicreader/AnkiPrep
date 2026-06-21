package com.example.flashcardapp.ui

import com.example.flashcardapp.data.AnkiDeck
import com.example.flashcardapp.data.entities.SessionRecordEntity
import com.example.flashcardapp.session.StreakCalculator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Calendar

/**
 * Represents the full set of pre-computed statistics shown on the Dashboard tab.
 *
 * All fields are computed once on [Dispatchers.Default] and cached — no
 * recomputation happens on the composition thread.
 */
data class HomeStats(
    val pendingCount: Int,
    val mastery: Float,
    val velocity: Float,
    val last7DaysCompletion: Int,
    val streakInfo: StreakCalculator.StreakInfo,
    /** Epoch-millisecond timestamps (midnight-aligned) for the 7-dot row */
    val studiedDayTimestamps: Set<Long>
)

/** Sealed state for the Dashboard loading lifecycle. */
sealed class HomeScreenState {
    /** Shown immediately on first render before any data is ready. */
    object Loading : HomeScreenState()

    /** Shown once all stats have been computed off the main thread. */
    data class Loaded(
        val stats: HomeStats,
        val decks: List<AnkiDeck>
    ) : HomeScreenState()
}

/**
 * Computes all expensive dashboard statistics off the main thread.
 * Call this from [kotlinx.coroutines.CoroutineScope] with [Dispatchers.Default].
 */
suspend fun computeHomeStats(
    cardCount: Int,
    sessionRecords: List<SessionRecordEntity>
): HomeStats = withContext(Dispatchers.Default) {

    // ── Pending cards ────────────────────────────────────────────────────────
    val pendingCount = (cardCount - sessionRecords.sumOf { it.totalQuestions }).coerceAtLeast(0)

    // ── Mastery ──────────────────────────────────────────────────────────────
    val totalQuestions = sessionRecords.sumOf { it.totalQuestions }
    val totalCorrect   = sessionRecords.sumOf { it.score }
    val mastery = if (totalQuestions > 0) (totalCorrect.toFloat() / totalQuestions * 100f) else 0f

    // ── Velocity (avg seconds per recall) ────────────────────────────────────
    val totalTime = sessionRecords.sumOf { it.timeTakenSeconds }
    val velocity  = if (totalQuestions > 0) (totalTime.toFloat() / totalQuestions) else 0f

    // ── Last-7-days completion ───────────────────────────────────────────────
    val now = System.currentTimeMillis()
    val completedDays = mutableSetOf<String>()
    val fmt = java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.US)
    val cal = Calendar.getInstance()
    sessionRecords.forEach { record ->
        val diffDays = (now - record.timestamp) / (1000 * 60 * 60 * 24)
        if (diffDays in 0..6) {
            cal.timeInMillis = record.timestamp
            completedDays.add(fmt.format(cal.time))
        }
    }

    // ── Streak ───────────────────────────────────────────────────────────────
    val streakInfo = StreakCalculator.calculate(sessionRecords)

    // ── 7-day dot timestamps (midnight-aligned epoch ms) ─────────────────────
    val studiedDayTimestamps: Set<Long> = sessionRecords.map { r ->
        Calendar.getInstance().let { c ->
            c.timeInMillis = r.timestamp
            c.set(Calendar.HOUR_OF_DAY, 0); c.set(Calendar.MINUTE, 0)
            c.set(Calendar.SECOND, 0); c.set(Calendar.MILLISECOND, 0)
            c.timeInMillis
        }
    }.toHashSet()

    HomeStats(
        pendingCount = pendingCount,
        mastery = mastery,
        velocity = velocity,
        last7DaysCompletion = completedDays.size,
        streakInfo = streakInfo,
        studiedDayTimestamps = studiedDayTimestamps
    )
}
