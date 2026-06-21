package com.example.flashcardapp.fsrs

import org.junit.Assert.assertEquals
import org.junit.Test

class StealthRatingMapperTest {

    @Test
    fun testWrongAnswerAlwaysMapsToAgain() {
        assertEquals(Rating.Again, StealthRatingMapper.mapToRating(isCorrect = false, timeTakenMs = 1000L))
        assertEquals(Rating.Again, StealthRatingMapper.mapToRating(isCorrect = false, timeTakenMs = 4999L))
        assertEquals(Rating.Again, StealthRatingMapper.mapToRating(isCorrect = false, timeTakenMs = 5000L))
        assertEquals(Rating.Again, StealthRatingMapper.mapToRating(isCorrect = false, timeTakenMs = 10000L))
        assertEquals(Rating.Again, StealthRatingMapper.mapToRating(isCorrect = false, timeTakenMs = 15000L))
        assertEquals(Rating.Again, StealthRatingMapper.mapToRating(isCorrect = false, timeTakenMs = 15001L))
        assertEquals(Rating.Again, StealthRatingMapper.mapToRating(isCorrect = false, timeTakenMs = 30000L))
    }

    @Test
    fun testCorrectAnswerUnder5SecondsMapsToEasy() {
        assertEquals(Rating.Easy, StealthRatingMapper.mapToRating(isCorrect = true, timeTakenMs = 0L))
        assertEquals(Rating.Easy, StealthRatingMapper.mapToRating(isCorrect = true, timeTakenMs = 1L))
        assertEquals(Rating.Easy, StealthRatingMapper.mapToRating(isCorrect = true, timeTakenMs = 4999L))
    }

    @Test
    fun testCorrectAnswerBetween5And15SecondsMapsToGood() {
        assertEquals(Rating.Good, StealthRatingMapper.mapToRating(isCorrect = true, timeTakenMs = 5000L))
        assertEquals(Rating.Good, StealthRatingMapper.mapToRating(isCorrect = true, timeTakenMs = 5001L))
        assertEquals(Rating.Good, StealthRatingMapper.mapToRating(isCorrect = true, timeTakenMs = 10000L))
        assertEquals(Rating.Good, StealthRatingMapper.mapToRating(isCorrect = true, timeTakenMs = 14999L))
        assertEquals(Rating.Good, StealthRatingMapper.mapToRating(isCorrect = true, timeTakenMs = 15000L))
    }

    @Test
    fun testCorrectAnswerOver15SecondsMapsToHard() {
        assertEquals(Rating.Hard, StealthRatingMapper.mapToRating(isCorrect = true, timeTakenMs = 15001L))
        assertEquals(Rating.Hard, StealthRatingMapper.mapToRating(isCorrect = true, timeTakenMs = 20000L))
        assertEquals(Rating.Hard, StealthRatingMapper.mapToRating(isCorrect = true, timeTakenMs = 30000L))
    }
}
