package com.example.flashcardapp.data.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class TagQuestionUtilsTest {

    @Test
    fun testValidShortTagsSeparatedByComma() {
        val input = "History, Modern India, Chapter 4, World War II"
        val (tags, question) = TagQuestionUtils.parseAndFilterTags(input)

        assertEquals(listOf("History", "Modern India", "Chapter 4", "World War II"), tags)
        assertNull(question)
    }

    @Test
    fun testTagEndingWithSlashIsTreatedAsQuestion() {
        val input = "History, What was the treaty signed in 1802 /, Science"
        val (tags, question) = TagQuestionUtils.parseAndFilterTags(input)

        // "What was the treaty signed in 1802 /" must NOT be in tags
        assertEquals(listOf("History", "Science"), tags)
        // Must be extracted as question with trailing '/' stripped
        assertEquals("What was the treaty signed in 1802", question)
    }

    @Test
    fun testTagLookingLikeQuestionIsTreatedAsQuestion() {
        val input = "Polity, Which article guarantees the right to equality?, Law"
        val (tags, question) = TagQuestionUtils.parseAndFilterTags(input)

        assertEquals(listOf("Polity", "Law"), tags)
        assertEquals("Which article guarantees the right to equality?", question)
    }

    @Test
    fun testTagsOverFiveWordsAreNotTreatedAsTags() {
        // Tag with 7 words: "This is a very long tag that exceeds five words"
        val input = "Short Tag, This is a very long tag that exceeds five words, Physics"
        val (tags, _) = TagQuestionUtils.parseAndFilterTags(input)

        assertEquals(listOf("Short Tag", "Physics"), tags)
    }

    @Test
    fun testJsonSerializedTagsInput() {
        val jsonInput = "[\"Ancient India\", \"Battle of Panipat /\", \"Mughals\"]"
        val (tags, question) = TagQuestionUtils.parseAndFilterTags(jsonInput)

        assertEquals(listOf("Ancient India", "Mughals"), tags)
        assertEquals("Battle of Panipat", question)
    }

    @Test
    fun testStructuredParserUsesExtractedQuestionFromTagWhenFrontIsEmpty() {
        val front = ""
        val back = "Treaty of Bassein"
        val tags = "History, What was the treaty signed in 1802 /"

        val parsed = StructuredParser.parseCard(front, back, tags)

        assertEquals("What was the treaty signed in 1802", parsed.question)
        assertEquals("Treaty of Bassein", parsed.answer)
        assertEquals(listOf("History"), parsed.tags)
    }

    @Test
    fun testStructuredParserStripsTrailingSlashFromFrontQuestion() {
        val front = "Who discovered penicillin /"
        val back = "Alexander Fleming"

        val parsed = StructuredParser.parseCard(front, back)

        assertEquals("Who discovered penicillin", parsed.question)
        assertEquals("Alexander Fleming", parsed.answer)
    }

    @Test
    fun testIsQuestionCandidateIdentification() {
        assertTrue(TagQuestionUtils.isQuestionCandidate("Speed of sound in air is /"))
        assertTrue(TagQuestionUtils.isQuestionCandidate("Who was the founder of Nalanda University?"))
        assertTrue(TagQuestionUtils.isQuestionCandidate("Capital of France is ____"))
        assertFalse(TagQuestionUtils.isQuestionCandidate("General Science"))
        assertFalse(TagQuestionUtils.isQuestionCandidate("Indian History"))
    }
}
