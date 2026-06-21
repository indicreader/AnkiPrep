package com.example.flashcardapp.fsrs

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import kotlin.math.abs
import kotlin.math.exp
import kotlin.math.floor
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.random.Random

// ═══════════════════════════════════════════════════════════════
//  FSRS v6 — Free Spaced Repetition Scheduler
//  Ported from: github.com/open-spaced-repetition/FSRS-Kotlin
//  License: MIT
// ═══════════════════════════════════════════════════════════════

/**
 * FSRS rating mapped from MCQ performance.
 * Values match the FSRS specification (1–4).
 */
enum class Rating(val value: Int) {
    Again(1),
    Hard(2),
    Good(3),
    Easy(4)
}

/**
 * Lifecycle phase of a card in the FSRS system.
 */
enum class CardState(val value: Int) {
    /** Never reviewed — brand new card */
    New(0),
    /** Failed review — short re-learning intervals */
    Relearning(1),
    /** Graduated — long-term review intervals */
    Review(2)
}

/**
 * In-memory representation of a card's FSRS scheduling state.
 * This is NOT the Room entity — see [CardStateEntity] for persistence.
 */
data class FsrsCard(
    val stability: Double = 2.5,
    val difficulty: Double = 5.0,
    val interval: Int = 0,
    val dueDate: LocalDateTime = LocalDateTime.now(),
    val reviewCount: Int = 0,
    val lastReview: LocalDateTime = LocalDateTime.now(),
    val state: CardState = CardState.New
)

/**
 * The result of running FSRS for a single rating choice.
 */
data class SchedulingResult(
    val stability: Double,
    val difficulty: Double,
    val interval: Int,
    val durationMillis: Long,
    val displayText: String,
    val rating: Rating,
    val newState: CardState
)

/**
 * Pure FSRS v6 scheduling algorithm.
 *
 * Thread-safe, stateless calculator. Create one instance and reuse.
 *
 * @param requestRetention Desired retention rate (0.0–1.0). Default 0.9.
 * @param params 21 FSRS v6 model parameters. Uses published defaults.
 */
class FsrsAlgorithm(
    private val requestRetention: Double = 0.9,
    private val params: List<Double> = DEFAULT_PARAMS
) {
    companion object {
        /** Official FSRS v5 default parameters */
        val DEFAULT_PARAMS = listOf(
            0.40255, 1.18385, 3.173, 15.69105, // p[0]–p[3]: initial stability
            7.1949, 0.5345,                    // p[4]–p[5]: initial difficulty
            1.4604, 0.0046,                    // p[6]–p[7]: difficulty update
            1.54575, 0.1192, 1.01925,          // p[8]–p[10]: recall stability
            1.9395, 0.11, 0.29605, 2.2698,     // p[11]–p[14]: forget stability
            0.2315, 2.9898,                    // p[15]–p[16]: hard penalty / easy bonus
            0.51655, 0.6621                    // p[17]–p[18]: short-term stability
        )

        private const val DAY_MILLIS = 24L * 60 * 60 * 1000
    }

    private data class InitState(var difficulty: Double = 0.0, var stability: Double = 0.0)

    private val decay = -0.5
    private val factor = 19.0 / 81.0
    private val enableFuzz = true

    /**
     * Calculate scheduling options for all 4 ratings given the current card state.
     *
     * @return Map of [Rating] → [SchedulingResult] with 4 entries.
     */
    fun calculate(card: FsrsCard): Map<Rating, SchedulingResult> {
        val stateAgain: InitState
        val stateHard: InitState
        val stateGood: InitState
        val stateEasy: InitState

        var durationHard = 5 * 60 * 1000L // 5min
        val durationGood: Long
        val durationEasy: Long

        var ivlHard = 0
        var ivlGood = 0
        var ivlEasy = 0

        val txtHard: String
        val txtGood: String
        val txtEasy: String

        // Prevent NaN/Infinity/Invalid values on inputs
        val cardS = card.stability.sanitize(2.5, minVal = 0.1)
        val cardD = card.difficulty.sanitize(5.0, minVal = 1.0, maxVal = 10.0)

        when (card.state) {
            CardState.New -> {
                stateAgain = initState(Rating.Again)
                stateHard = initState(Rating.Hard)
                stateGood = initState(Rating.Good)
                stateEasy = initState(Rating.Easy)

                ivlEasy = nextInterval(stateEasy.stability)
                ivlEasy = max(1, ivlEasy)

                txtHard = "5 Min"
                txtGood = "10 Min"
                txtEasy = convertDays(ivlEasy)

                durationGood = 10 * 60 * 1000L
                durationEasy = ivlEasy * DAY_MILLIS
            }

            CardState.Relearning -> {
                if (cardD <= 0.0 || cardD.isNaN()) {
                    stateAgain = initState(Rating.Again)
                    stateHard = initState(Rating.Hard)
                    stateGood = initState(Rating.Good)
                    stateEasy = initState(Rating.Easy)
                } else {
                    stateAgain = InitState(
                        difficulty = nextDifficulty(cardD, Rating.Again),
                        stability = nextShortTermStability(cardS, Rating.Again)
                    )
                    stateHard = InitState(
                        difficulty = nextDifficulty(cardD, Rating.Hard),
                        stability = nextShortTermStability(cardS, Rating.Hard)
                    )
                    stateGood = InitState(
                        difficulty = nextDifficulty(cardD, Rating.Good),
                        stability = nextShortTermStability(cardS, Rating.Good)
                    )
                    stateEasy = InitState(
                        difficulty = nextDifficulty(cardD, Rating.Easy),
                        stability = nextShortTermStability(cardS, Rating.Easy)
                    )
                }

                ivlGood = nextInterval(stateGood.stability)
                ivlEasy = nextInterval(stateEasy.stability)
                ivlEasy = max(ivlEasy, ivlGood + 1)

                txtHard = "10 Min"
                txtGood = convertDays(ivlGood)
                txtEasy = convertDays(ivlEasy)

                durationGood = ivlGood * DAY_MILLIS
                durationEasy = ivlEasy * DAY_MILLIS
            }

            CardState.Review -> {
                val interval = card.interval
                val retrievability = forgettingCurve(interval.toDouble(), cardS)

                stateAgain = InitState(
                    difficulty = nextDifficulty(cardD, Rating.Again),
                    stability = nextForgetStability(cardD, cardS, retrievability)
                )
                stateHard = InitState(
                    difficulty = nextDifficulty(cardD, Rating.Hard),
                    stability = nextRecallStability(cardD, cardS, retrievability, Rating.Hard)
                )
                stateGood = InitState(
                    difficulty = nextDifficulty(cardD, Rating.Good),
                    stability = nextRecallStability(cardD, cardS, retrievability, Rating.Good)
                )
                stateEasy = InitState(
                    difficulty = nextDifficulty(cardD, Rating.Easy),
                    stability = nextRecallStability(cardD, cardS, retrievability, Rating.Easy)
                )

                ivlHard = nextInterval(stateHard.stability)
                ivlGood = nextInterval(stateGood.stability)
                ivlEasy = nextInterval(stateEasy.stability)

                ivlHard = min(ivlHard, ivlGood)
                ivlGood = max(ivlGood, ivlHard + 1)
                ivlEasy = max(ivlEasy, ivlGood + 1)

                txtHard = convertDays(ivlHard)
                txtGood = convertDays(ivlGood)
                txtEasy = convertDays(ivlEasy)

                durationHard = ivlHard * DAY_MILLIS
                durationGood = ivlGood * DAY_MILLIS
                durationEasy = ivlEasy * DAY_MILLIS
            }
        }

        val newStateForRating = { rating: Rating ->
            when {
                rating == Rating.Again -> CardState.Relearning
                card.state == CardState.New && rating >= Rating.Good -> CardState.Review
                card.state == CardState.New -> CardState.Relearning
                card.state == CardState.Relearning && rating >= Rating.Good -> CardState.Review
                else -> CardState.Review
            }
        }

        return mapOf(
            Rating.Easy to SchedulingResult(
                stability = stateEasy.stability,
                difficulty = stateEasy.difficulty,
                interval = ivlEasy,
                durationMillis = durationEasy,
                displayText = txtEasy,
                rating = Rating.Easy,
                newState = newStateForRating(Rating.Easy)
            ),
            Rating.Good to SchedulingResult(
                stability = stateGood.stability,
                difficulty = stateGood.difficulty,
                interval = ivlGood,
                durationMillis = durationGood,
                displayText = txtGood,
                rating = Rating.Good,
                newState = newStateForRating(Rating.Good)
            ),
            Rating.Hard to SchedulingResult(
                stability = stateHard.stability,
                difficulty = stateHard.difficulty,
                interval = ivlHard,
                durationMillis = durationHard,
                displayText = txtHard,
                rating = Rating.Hard,
                newState = newStateForRating(Rating.Hard)
            ),
            Rating.Again to SchedulingResult(
                stability = stateAgain.stability,
                difficulty = stateAgain.difficulty,
                interval = card.interval,
                durationMillis = 3 * 60 * 1000L,
                displayText = "< 3 Min",
                rating = Rating.Again,
                newState = newStateForRating(Rating.Again)
            )
        )
    }

    // ── Internal FSRS math ──────────────────────────────────────

    private fun Double.sanitize(defaultValue: Double, minVal: Double = Double.NEGATIVE_INFINITY, maxVal: Double = Double.POSITIVE_INFINITY): Double {
        if (this.isNaN() || this.isInfinite()) return defaultValue
        return this.coerceIn(minVal, maxVal)
    }

    private fun Double.formatToTwoDecimals(defaultValue: Double): Double {
        val value = if (this.isNaN() || this.isInfinite()) defaultValue else this
        return try {
            String.format(java.util.Locale.US, "%.2f", value).toDouble()
        } catch (e: Exception) {
            defaultValue
        }
    }

    private fun convertDays(days: Int): String {
        return when {
            days > 365 -> "${String.format(java.util.Locale.US, "%.1f", days / 365.0)} yr"
            days > 30  -> "${String.format(java.util.Locale.US, "%.1f", days / 30.0)} mo"
            else       -> "$days d"
        }
    }

    private fun Double.safeRoundToInt(defaultVal: Int = 0): Int {
        if (this.isNaN() || this.isInfinite()) return defaultVal
        return if (this < Int.MIN_VALUE) Int.MIN_VALUE
        else if (this > Int.MAX_VALUE) Int.MAX_VALUE
        else this.roundToInt()
    }

    private fun applyFuzz(interval: Double, fuzzFactor: Double): Double {
        val sanitizedInterval = interval.sanitize(2.5, minVal = 0.0)
        if (!enableFuzz || sanitizedInterval < 2.5) return sanitizedInterval
        val fFactor = fuzzFactor.sanitize(0.5, minVal = 0.0, maxVal = 1.0)
        val ivl = sanitizedInterval.safeRoundToInt(2)
        val minIvl = max(2, (ivl * 0.95 - 1).safeRoundToInt(2))
        val maxIvl = (ivl * 1.05 + 1).safeRoundToInt(2)
        val result = floor(fFactor * (maxIvl - minIvl + 1) + minIvl)
        return result.sanitize(sanitizedInterval)
    }

    private fun forgettingCurve(interval: Double, stability: Double): Double {
        val s = stability.sanitize(2.5, minVal = 0.1)
        val i = interval.sanitize(0.0, minVal = 0.0)
        return (1.0 + factor * (i / s)).pow(decay).sanitize(0.9, minVal = 0.0, maxVal = 1.0)
    }

    private fun generateFuzzFactor(): Double {
        return Random(System.currentTimeMillis()).nextDouble()
    }

    private fun initDifficulty(rating: Rating): Double {
        val raw = params[4] - params[5] * (rating.value - 3)
        return raw.formatToTwoDecimals(5.0).coerceIn(1.0, 10.0)
    }

    private fun initStability(rating: Rating): Double {
        val index = rating.value - 1
        val value = params.getOrElse(index) { 0.1 }
        return value.formatToTwoDecimals(0.1).coerceAtLeast(0.1)
    }

    private fun initState(rating: Rating): InitState {
        return InitState(
            difficulty = initDifficulty(rating),
            stability = initStability(rating)
        )
    }

    private fun linearDamping(delta: Double, oldD: Double): Double {
        return delta * (10.0 - oldD) / 9.0
    }

    private fun meanReversion(initD: Double, nextD: Double): Double {
        return params[7] * initD + (1.0 - params[7]) * nextD
    }

    private fun nextInterval(stability: Double, maxInterval: Int = 36500): Int {
        val fuzzFactor = generateFuzzFactor()
        val s = stability.sanitize(2.5, minVal = 0.1)
        val power = 1.0 / decay
        val retentionTerm = requestRetention.pow(power) - 1
        val rawInterval = (s / factor * retentionTerm).sanitize(1.0, minVal = 0.0)
        val fuzzed = applyFuzz(rawInterval, fuzzFactor)
        return fuzzed.safeRoundToInt(1).coerceIn(1, maxInterval)
    }

    private fun nextDifficulty(currentD: Double, rating: Rating): Double {
        val d = currentD.sanitize(5.0, minVal = 1.0, maxVal = 10.0)
        val deltaD = -params[6] * (rating.value - 3)
        val damped = linearDamping(deltaD, d)
        val nextD = d + damped
        val reverted = meanReversion(initDifficulty(Rating.Good), nextD)
        return reverted.formatToTwoDecimals(5.0).coerceIn(1.0, 10.0)
    }

    private fun nextShortTermStability(currentS: Double, rating: Rating): Double {
        val s = currentS.sanitize(2.5, minVal = 0.1)
        val exponent = params[17] * (rating.value - 3 + params[18])
        var sinc = exp(exponent)
        if (rating.value >= 3) {
            sinc = max(sinc, 1.0)
        }
        val result = abs(s * sinc)
        return result.formatToTwoDecimals(s.coerceAtLeast(0.1))
    }

    private fun nextForgetStability(difficulty: Double, stability: Double, retrievability: Double): Double {
        val d = difficulty.sanitize(5.0, minVal = 1.0, maxVal = 10.0)
        val s = stability.sanitize(2.5, minVal = 0.1)
        val r = retrievability.sanitize(0.9, minVal = 0.0, maxVal = 1.0)
        val sMin = s / exp(params[17] * params[18])
        val term1 = params[11]
        val term2 = d.pow(-params[12])
        val term3 = (s + 1).pow(params[13]) - 1
        val term4 = exp((1 - r) * params[14])
        val result = (term1 * term2 * term3 * term4).sanitize(sMin)
        return min(result, sMin).formatToTwoDecimals(sMin)
    }

    private fun nextRecallStability(d: Double, s: Double, r: Double, rating: Rating): Double {
        val sanitizedD = d.sanitize(5.0, minVal = 1.0, maxVal = 10.0)
        val sanitizedS = s.sanitize(2.5, minVal = 0.1)
        val sanitizedR = r.sanitize(0.9, minVal = 0.0, maxVal = 1.0)
        val hardPenalty = if (rating == Rating.Hard) params[15] else 1.0
        val easyBonus = if (rating == Rating.Easy) params[16] else 1.0
        val f = exp(params[8]) *
                (11 - sanitizedD) *
                sanitizedS.pow(-params[9]) *
                (exp((1 - sanitizedR) * params[10]) - 1) *
                hardPenalty *
                easyBonus
        val result = sanitizedS * (1 + f)
        return result.formatToTwoDecimals(sanitizedS)
    }
}

// ── Utility: epoch millis ↔ LocalDateTime ─────────────────────

fun Long.toLocalDateTime(): LocalDateTime =
    LocalDateTime.ofInstant(Instant.ofEpochMilli(this), ZoneId.systemDefault())

fun LocalDateTime.toEpochMillis(): Long =
    this.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()

fun addMillisToNow(millis: Long): LocalDateTime {
    val newInstant = Instant.now().plusMillis(millis)
    return LocalDateTime.ofInstant(newInstant, ZoneId.systemDefault())
}
