package com.example.flashcardapp.data.core

import org.junit.Assert.assertEquals
import org.junit.Test

class CsvQuoteUtilsTest {

    @Test
    fun testAlreadyQuotedTextAvoidsDoubleWrapping() {
        val input = "\"What is the speed of light?\""
        val output = CsvQuoteUtils.quoteRfc4180(input)
        assertEquals("\"What is the speed of light?\"", output)
    }

    @Test
    fun testDoubleWrappedTextIsCleaned() {
        val input = "\"\"What is the speed of light?\"\""
        val output = CsvQuoteUtils.quoteRfc4180(input)
        assertEquals("\"What is the speed of light?\"", output)
    }

    @Test
    fun testMissingQuotesAddedWhenSeparatorsPresent() {
        val input = "What is 1, 2, and 3?"
        val output = CsvQuoteUtils.quoteRfc4180(input, ',')
        assertEquals("\"What is 1, 2, and 3?\"", output)
    }

    @Test
    fun testSanitizeAndQuoteCsvUnquotedQuestionsWithCommas() {
        val csvInput = "What are prime, composite, and odd numbers?, Ans: Prime numbers\nSecond question, Second answer"
        val sanitized = CsvQuoteUtils.sanitizeAndQuoteCsv(csvInput, ',')
        val parsed = CsvQuoteUtils.parseCsv(sanitized, ',')

        assertEquals(2, parsed.size)
        assertEquals("What are prime, composite, and odd numbers?", parsed[0][0])
        assertEquals("Ans: Prime numbers", parsed[0][1])
        assertEquals("Second question", parsed[1][0])
        assertEquals("Second answer", parsed[1][1])
    }

    @Test
    fun testSanitizeAndQuoteCsvPreservesAlreadyQuotedLines() {
        val csvInput = "\"What is 1, 2, and 3?\", \"Answer 1\"\n\"Question 2\", \"Answer 2\""
        val sanitized = CsvQuoteUtils.sanitizeAndQuoteCsv(csvInput, ',')
        val parsed = CsvQuoteUtils.parseCsv(sanitized, ',')

        assertEquals(2, parsed.size)
        assertEquals("What is 1, 2, and 3?", parsed[0][0])
        assertEquals("Answer 1", parsed[0][1])
    }

    @Test
    fun testSanitizeOptionsFillsMissingSlotsWithNoneOfTheAbove() {
        val optionsInput = "1922| 1320||1920| |"
        val sanitized = CsvQuoteUtils.sanitizeOptions(optionsInput)
        assertEquals("1922 | 1320 | None of the above | 1920", sanitized)
    }

    @Test
    fun testUserExampleQuestionWithUnquotedCommasAndMissingOption() {
        val csvInput = "when did the champaran ,movement started, in india?, 1922| 1320| |1920| "
        val sanitized = CsvQuoteUtils.sanitizeAndQuoteCsv(csvInput, ',')
        val parsed = CsvQuoteUtils.parseCsv(sanitized, ',')

        assertEquals(1, parsed.size)
        assertEquals("when did the champaran ,movement started, in india?", parsed[0][0])
        assertEquals("1922 | 1320 | None of the above | 1920", parsed[0][1])
    }

    @Test
    fun testExportScrapedCardsToCsvFormatAndParsing() {
        val card1 = com.example.flashcardapp.data.scraper.ScrapedCard(
            question = "Which number is even, prime, and divisible by 2?",
            answer = "2",
            options = listOf("2", "3", "5", "7"),
            explanation = "2 is the only even prime number."
        )
        val card2 = com.example.flashcardapp.data.scraper.ScrapedCard(
            question = "What is the capital of France?",
            answer = "Paris",
            options = listOf("London", "Berlin", "Paris", "Madrid"),
            explanation = "Paris is the French capital."
        )

        val csvOutput = CsvQuoteUtils.exportScrapedCardsToCsv(listOf(card1, card2))

        // Check UTF-8 BOM
        org.junit.Assert.assertTrue(csvOutput.startsWith("\uFEFF"))

        // Parse rows
        val parsedRows = CsvQuoteUtils.parseCsv(csvOutput, ',')
        assertEquals(3, parsedRows.size)

        // Header check
        assertEquals("question", parsedRows[0][0])
        assertEquals("answer|option 1|option 2|option 3|explaination", parsedRows[0][1])

        // Row 1 check
        assertEquals("Which number is even, prime, and divisible by 2?", parsedRows[1][0])
        assertEquals("2|3|5|7|2 is the only even prime number.", parsedRows[1][1])

        // Row 2 check
        assertEquals("What is the capital of France?", parsedRows[2][0])
        assertEquals("Paris|London|Berlin|Madrid|Paris is the French capital.", parsedRows[2][1])
    }

    @Test
    fun testOneLinerCsvWith3ColumnsAndExplanation() {
        val csvInput = """
            question, answer, explaination
            Who wrote the National Anthem of India?, Rabindranath Tagore, Jana Gana Mana was originally composed in Bengali.
            What is the capital of Australia?, Canberra, It was chosen as a compromise between Sydney and Melbourne.
        """.trimIndent()
        val sanitized = CsvQuoteUtils.sanitizeAndQuoteCsv(csvInput, ',')
        val parsed = CsvQuoteUtils.parseCsv(sanitized, ',')

        assertEquals(3, parsed.size)
        assertEquals(3, parsed[0].size)
        assertEquals("question", parsed[0][0])
        assertEquals("answer", parsed[0][1])
        assertEquals("explaination", parsed[0][2])

        assertEquals("Who wrote the National Anthem of India?", parsed[1][0])
        assertEquals("Rabindranath Tagore", parsed[1][1])
        assertEquals("Jana Gana Mana was originally composed in Bengali.", parsed[1][2])
    }

    @Test
    fun testOneLinerCsvWithoutHeaderDoesNotCollapseColumns() {
        val csvInput = """
            Light year is unit of?, Distance, It measures astronomical distance.
            Speed of sound in air, 343 m/s, Measured at 20 degrees Celsius.
        """.trimIndent()
        val sanitized = CsvQuoteUtils.sanitizeAndQuoteCsv(csvInput, ',')
        val parsed = CsvQuoteUtils.parseCsv(sanitized, ',')

        assertEquals(2, parsed.size)
        assertEquals(3, parsed[0].size)
        assertEquals("Light year is unit of?", parsed[0][0])
        assertEquals("Distance", parsed[0][1])
        assertEquals("It measures astronomical distance.", parsed[0][2])
    }

    @Test
    fun testFiveColumnTopicSubtopicWithNumericCommaAndQuestionMark() {
        val csvInput = "history, medevial, what was the range of mesolithi period between?, 10,000 to 6000 bce, explain"
        val sanitized = CsvQuoteUtils.sanitizeAndQuoteCsv(csvInput, ',')
        val parsed = CsvQuoteUtils.parseCsv(sanitized, ',')

        assertEquals(1, parsed.size)
        assertEquals(5, parsed[0].size)
        assertEquals("history", parsed[0][0])
        assertEquals("medevial", parsed[0][1])
        assertEquals("what was the range of mesolithi period between?", parsed[0][2])
        assertEquals("10,000 to 6000 bce", parsed[0][3])
        assertEquals("explain", parsed[0][4])
    }

    @Test
    fun testFiveColumnTopicSubtopicWithoutQuestionMark() {
        val csvInput = "history, medevial, range of mesolithic period between, 10,000 to 6000 bce, explain"
        val sanitized = CsvQuoteUtils.sanitizeAndQuoteCsv(csvInput, ',')
        val parsed = CsvQuoteUtils.parseCsv(sanitized, ',')

        assertEquals(1, parsed.size)
        assertEquals(5, parsed[0].size)
        assertEquals("history", parsed[0][0])
        assertEquals("medevial", parsed[0][1])
        assertEquals("range of mesolithic period between", parsed[0][2])
        assertEquals("10,000 to 6000 bce", parsed[0][3])
        assertEquals("explain", parsed[0][4])
    }

    @Test
    fun testFiveColumnTopicSubtopicWithHeader() {
        val csvInput = """
            topic, subtopic, question, answer, explaination
            history, medevial, what was the range of mesolithi period between?, 10,000 to 6000 bce, transitional era
        """.trimIndent()
        val sanitized = CsvQuoteUtils.sanitizeAndQuoteCsv(csvInput, ',')
        val parsed = CsvQuoteUtils.parseCsv(sanitized, ',')

        assertEquals(2, parsed.size)
        assertEquals(5, parsed[0].size)
        assertEquals("topic", parsed[0][0])
        assertEquals("subtopic", parsed[0][1])
        assertEquals("question", parsed[0][2])
        assertEquals("answer", parsed[0][3])
        assertEquals("explaination", parsed[0][4])

        assertEquals("history", parsed[1][0])
        assertEquals("medevial", parsed[1][1])
        assertEquals("what was the range of mesolithi period between?", parsed[1][2])
        assertEquals("10,000 to 6000 bce", parsed[1][3])
        assertEquals("transitional era", parsed[1][4])
    }
}

