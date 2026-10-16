package com.example.flashcardapp.data.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class TenColumnCsvParserTest {

    private val sample10ColCsv = """
"id","type","tags","question","option_a","option_b","option_c","option_d","correct_option","explanation"
"his_35","mcq","History;Ancient History;Mauryan Period;SSC CGL","In Kautilya's Saptanga theory, 'Amatya' refers to which of the following?","Territory","Friend","Minister and Officer","Fort","C","Kautilya has mentioned Saptanga (seven components) to help the king in administration: 1. Swami (King), 2. Amatya (Minister and Officer), 3. Janapada (Territory), 4. Durga (a fortified capital), 5. Kosha (Treasury), 6. Danda (Justice or Force), 7. Mitra (Ally)."
"his_pm_06","statement","History;Ancient History;Post Mauryan Period;Indo-Greek;SSC CPO","Consider the following statements regarding the Indo-Greeks:
1. The most famous Indo-Greek ruler was Menander.
2. Menander is identified with King Milinda described in the famous Buddhist text Milindapanha.
3. Milindapanha contains philosophical questions that Milinda asked Amrapali.
4. Impressed by the answers, King Milinda accepted Buddhism as his religion.
Which of the above statements are correct?","Only 1, 2 and 3","Only 3, 2 and 4","Only 1, 3 and 4","Only 1, 2 and 4","D","Statement 3 is incorrect because in Milindapanha, the philosophical questions were asked by Milinda to the Buddhist monk Nagasena, not to Amrapali. Statements 1, 2, and 4 are correct. Demetrius I is considered the founder of Indo-Greek rule in India. Menander's capital was Sakala (Sagala)."
""".trimIndent()

    @Test
    fun testMultilineQuotedQuestionPreservedInSanitizeAndQuoteCsv() {
        val sanitized = CsvQuoteUtils.sanitizeAndQuoteCsv(sample10ColCsv, ',')
        val rows = CsvQuoteUtils.parseCsv(sanitized, ',')

        // Header + 2 data rows = 3 rows
        assertEquals(3, rows.size)

        // Row 1: his_35
        assertEquals(10, rows[1].size)
        assertEquals("his_35", rows[1][0])
        assertEquals("In Kautilya's Saptanga theory, 'Amatya' refers to which of the following?", rows[1][3])
        assertEquals("C", rows[1][8])

        // Row 2: his_pm_06 (multiline statement)
        assertEquals(10, rows[2].size)
        assertEquals("his_pm_06", rows[2][0])
        assertTrue(rows[2][3].contains("Consider the following statements regarding the Indo-Greeks:"))
        assertTrue(rows[2][3].contains("1. The most famous Indo-Greek ruler was Menander."))
        assertTrue(rows[2][3].contains("Which of the above statements are correct?"))
        assertEquals("D", rows[2][8])
    }

    @Test
    fun testSemicolonSeparatedTagsSplitting() {
        val rawTags = "History;Ancient History;Mauryan Period;SSC CGL"
        val (tags, question) = TagQuestionUtils.parseAndFilterTags(rawTags)

        assertEquals(4, tags.size)
        assertEquals("History", tags[0])
        assertEquals("Ancient History", tags[1])
        assertEquals("Mauryan Period", tags[2])
        assertEquals("SSC CGL", tags[3])
    }

    @Test
    fun testOptionLetterResolutionAndStructuredBack() {
        val rows = CsvQuoteUtils.parseCsv(sample10ColCsv, ',')
        val header = rows[0]
        val dataRow = rows[1] // his_35: correct_option = "C"

        val optA = dataRow[4] // Territory
        val optB = dataRow[5] // Friend
        val optC = dataRow[6] // Minister and Officer
        val optD = dataRow[7] // Fort
        val rawAnswerKey = dataRow[8] // "C"
        val explanation = dataRow[9]

        val optionsList = listOf(optA, optB, optC, optD)
        val resolvedAnswer = when (rawAnswerKey.uppercase().trim()) {
            "A", "1" -> optA
            "B", "2" -> optB
            "C", "3" -> optC
            "D", "4" -> optD
            else -> rawAnswerKey
        }

        assertEquals("Minister and Officer", resolvedAnswer)

        val distractors = optionsList.filter { it.trim().lowercase() != resolvedAnswer.trim().lowercase() }
        assertEquals(listOf("Territory", "Friend", "Fort"), distractors)

        val back = "$resolvedAnswer | ${distractors.joinToString(" | ")} {explain} $explanation"

        val parsedCard = StructuredParser.parse(back)
        assertEquals("Minister and Officer", parsedCard.answer)
        assertEquals(3, parsedCard.options.size)
        assertTrue(parsedCard.options.contains("Territory"))
        assertTrue(parsedCard.options.contains("Friend"))
        assertTrue(parsedCard.options.contains("Fort"))
        assertTrue(parsedCard.explanation.contains("Kautilya has mentioned Saptanga"))
    }
}
