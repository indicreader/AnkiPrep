package com.example.flashcardapp

import com.example.flashcardapp.data.core.CsvQuoteUtils
import com.example.flashcardapp.data.core.StructuredParser
import com.example.flashcardapp.data.core.TagQuestionUtils
import com.example.flashcardapp.data.entities.CardEntity
import com.example.flashcardapp.mcq.McqEngine
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class CsvImportRegressionTest {

    // Mirror CsvImporter's looksLikeHeader and resolveColumnMapping
    private val headers = setOf(
        "front", "back", "question", "answer", "term", "definition", "q", "a", "tags", "tag",
        "prompt", "response", "explanation", "explain", "explaination", "options", "option", "distractor",
        "option_a", "option_b", "option_c", "option_d", "opt_a", "opt_b", "opt_c", "opt_d",
        "correct_option", "correct_opt", "correct_answer", "correct", "key",
        "topic", "subtopic", "sub_topic", "sub-topic", "category",
        "ques", "ans", "fact", "liner ques", "one-liner", "detail", "sol", "solution",
        "id", "type"
    )

    private fun looksLikeHeader(row: List<String>): Boolean {
        val firstCell = row.getOrNull(0)?.trim()?.lowercase() ?: return false
        return firstCell in headers || row.any { cell -> cell.trim().lowercase() in headers }
    }

    private fun resolveColumnMapping(headerRow: List<String>): Map<Int, String> {
        val map = mutableMapOf<Int, String>()
        headerRow.forEachIndexed { index, rawHeader ->
            val clean = rawHeader.trim().lowercase()
            when {
                clean in setOf("topic") -> map[index] = "TOPIC"
                clean in setOf("subtopic", "sub_topic", "sub-topic") -> map[index] = "SUBTOPIC"
                clean in setOf("front", "question", "q", "ques", "term", "prompt", "fact", "one-liner", "liner ques") -> map[index] = "FRONT"
                clean in setOf(
                    "back", "answer", "ans", "a", "definition", "response",
                    "correct_option", "correct_opt", "correct_answer", "correct", "key", "right_answer",
                    "correct option", "right answer", "answer_key", "answer key"
                ) || clean.startsWith("answer|") || clean.startsWith("ans|") || clean.startsWith("back|") || clean.contains("answer|option") -> map[index] = "BACK"
                clean in setOf("explanation", "explain", "explaination", "notes", "rationale", "comment", "detail", "sol", "solution") -> map[index] = "EXPLANATION"
                clean in setOf("tags", "tag", "categories", "category", "labels", "keywords") -> map[index] = "TAGS"
                clean in setOf("option_a", "opt_a", "option 1", "opt 1", "choice_a") -> map[index] = "OPTION_A"
                clean in setOf("option_b", "opt_b", "option 2", "opt 2", "choice_b") -> map[index] = "OPTION_B"
                clean in setOf("option_c", "opt_c", "option 3", "opt 3", "choice_c") -> map[index] = "OPTION_C"
                clean in setOf("option_d", "opt_d", "option 4", "opt 4", "choice_d") -> map[index] = "OPTION_D"
                clean.startsWith("option") || clean.startsWith("opt") || clean in setOf("a", "b", "c", "d", "choice", "distractor") -> map[index] = "OPTION"
            }
        }

        // If the header had some matches but missed either FRONT or BACK, fall back gracefully
        if (!map.values.contains("FRONT") || !map.values.contains("BACK")) {
            val frontCandidate = map.entries.firstOrNull { it.value == "FRONT" }?.key
            val backCandidate = map.entries.firstOrNull { it.value == "BACK" }?.key

            if (frontCandidate == null && headerRow.isNotEmpty()) {
                val candidateCol = if (backCandidate != 0) 0 else 1
                if (candidateCol < headerRow.size) {
                    map[candidateCol] = "FRONT"
                }
            }
            if (backCandidate == null && headerRow.size >= 2) {
                val candidateCol = if (map[0] == "FRONT") 1 else 0
                if (candidateCol < headerRow.size) {
                    map[candidateCol] = "BACK"
                }
            }
        }

        return map
    }

    private data class ParsedRowResult(val front: String, val back: String, val tags: List<String>)

    private fun simulateCsvImport(rawContent: String, userMapping: Map<Int, String>? = null): List<ParsedRowResult> {
        val delimiter = ','
        val sanitizedContent = CsvQuoteUtils.sanitizeAndQuoteCsv(rawContent, delimiter)
        val allRows = CsvQuoteUtils.parseCsv(sanitizedContent, delimiter)

        if (allRows.isEmpty()) return emptyList()

        val firstRow = allRows.first()
        val isHeaderRow = looksLikeHeader(firstRow)
        val activeColumnMapping = userMapping ?: if (isHeaderRow) resolveColumnMapping(firstRow) else null
        val dataRows = if (isHeaderRow) allRows.drop(1) else allRows

        val results = mutableListOf<ParsedRowResult>()
        for (row in dataRows) {
            var front = ""
            var back = ""
            val tagsList = mutableListOf<String>()

            if (activeColumnMapping != null && activeColumnMapping.isNotEmpty()) {
                var question = ""
                var answer = ""
                var explanation = ""
                val optionsList = mutableListOf<String>()
                var optA = ""
                var optB = ""
                var optC = ""
                var optD = ""

                activeColumnMapping.forEach { (colIndex, mapping) ->
                    val cellValue = row.getOrNull(colIndex)?.trim() ?: ""
                    if (cellValue.isNotEmpty()) {
                        when (mapping.uppercase()) {
                            "FRONT", "QUESTION" -> question = cellValue
                            "BACK", "ANSWER" -> answer = cellValue
                            "EXPLANATION" -> explanation = cellValue
                            "TOPIC" -> tagsList.add("topic:${cellValue.removePrefix("topic:").trim()}")
                            "SUBTOPIC" -> tagsList.add("subtopic:${cellValue.removePrefix("subtopic:").trim()}")
                            "TAGS" -> {
                                val (parsed, extractedQ) = TagQuestionUtils.parseAndFilterTags(cellValue)
                                tagsList.addAll(parsed)
                                if (question.isEmpty() && extractedQ != null) {
                                    question = extractedQ
                                }
                            }
                            "OPTION_A" -> { optA = cellValue; optionsList.add(cellValue) }
                            "OPTION_B" -> { optB = cellValue; optionsList.add(cellValue) }
                            "OPTION_C" -> { optC = cellValue; optionsList.add(cellValue) }
                            "OPTION_D" -> { optD = cellValue; optionsList.add(cellValue) }
                            "OPTION" -> optionsList.add(cellValue)
                        }
                    }
                }

                if (question.isEmpty() || answer.isEmpty()) {
                    continue
                }

                var resolvedAnswer = answer
                val upperAns = answer.uppercase().removePrefix("(").removeSuffix(")").removeSuffix(".").trim()
                if (upperAns in listOf("A", "B", "C", "D", "1", "2", "3", "4")) {
                    resolvedAnswer = when (upperAns) {
                        "A", "1" -> if (optA.isNotEmpty()) optA else optionsList.getOrNull(0) ?: answer
                        "B", "2" -> if (optB.isNotEmpty()) optB else optionsList.getOrNull(1) ?: answer
                        "C", "3" -> if (optC.isNotEmpty()) optC else optionsList.getOrNull(2) ?: answer
                        "D", "4" -> if (optD.isNotEmpty()) optD else optionsList.getOrNull(3) ?: answer
                        else -> answer
                    }
                }

                front = TagQuestionUtils.normalizeExtractedQuestion(question)
                val distractors = optionsList.filter {
                    it.trim().lowercase() != resolvedAnswer.trim().lowercase()
                }
                back = if (distractors.isNotEmpty()) {
                    "$resolvedAnswer | ${distractors.joinToString(" | ")}"
                } else {
                    resolvedAnswer
                }
                if (explanation.isNotEmpty()) {
                    back = "$back {explain} $explanation"
                }
            } else {
                if (row.size == 5) {
                    val topic = row[0].trim()
                    val subtopic = row[1].trim()
                    front = row[2].trim()
                    back = row[3].trim()
                    val explanation = row[4].trim()
                    if (topic.isNotEmpty()) tagsList.add("topic:${topic.removePrefix("topic:").trim()}")
                    if (subtopic.isNotEmpty()) tagsList.add("subtopic:${subtopic.removePrefix("subtopic:").trim()}")
                    if (explanation.isNotEmpty()) back = "$back {explain} $explanation"
                } else if (row.size >= 2) {
                    front = row[0].trim()
                    back = row[1].trim()
                    if (row.size == 3) {
                        val col2 = row[2].trim()
                        if (col2.isNotEmpty()) {
                            val (parsed, extractedQ) = TagQuestionUtils.parseAndFilterTags(col2)
                            val wordCount = col2.split(Regex("\\s+")).filter { it.isNotEmpty() }.size
                            val isExplanation = wordCount > 5 || col2.contains(".") || col2.contains(";") || parsed.isEmpty() || extractedQ != null
                            if (isExplanation) {
                                val cleanExpl = (extractedQ ?: col2).trim()
                                back = "$back {explain} $cleanExpl"
                            } else {
                                tagsList.addAll(parsed)
                            }
                        }
                    } else if (row.size == 4) {
                        val col0 = row[0].trim()
                        val col1 = row[1].trim()
                        val col2 = row[2].trim()
                        val col3 = row[3].trim()

                        if (col2.contains("|") || TagQuestionUtils.isQuestionCandidate(col1)) {
                            val (parsed, _) = TagQuestionUtils.parseAndFilterTags(col0)
                            tagsList.addAll(parsed)
                            front = col1
                            back = col2
                            if (col3.isNotEmpty()) {
                                back = "$back {explain} $col3"
                            }
                        } else {
                            front = col0
                            back = col1
                            if (col2.isNotEmpty()) {
                                val (parsed, extractedQ) = TagQuestionUtils.parseAndFilterTags(col2)
                                tagsList.addAll(parsed)
                                if (front.isEmpty() && extractedQ != null) {
                                    front = extractedQ
                                }
                            }
                            if (col3.isNotEmpty()) {
                                back = "$back {explain} $col3"
                            }
                        }
                    }
                }
            }

            if (front.isNotEmpty() && back.isNotEmpty()) {
                results.add(ParsedRowResult(front, back, tagsList))
            }
        }
        return results
    }

    @Test
    fun testStandardFormatWithPipeDelimitedOptionsHeader() {
        val csv = """
            question,answer|option 1|option 2|option 3|explaination
            What is the capital of France?,Paris|London|Berlin|Madrid|Paris is the capital of France.
            What is the capital of Germany?,Berlin|Munich|Frankfurt|Hamburg|Berlin is the capital of Germany.
        """.trimIndent()

        val parsed = simulateCsvImport(csv)
        println("testStandardFormatWithPipeDelimitedOptionsHeader parsed size: ${parsed.size}")
        assertEquals(2, parsed.size)
    }

    @Test
    fun testTwoColumnCsvWithoutHeader() {
        val csv = """
            What is the capital of France?,Paris
            What is the capital of Germany?,Berlin
            What is the capital of Italy?,Rome
            What is the capital of Spain?,Madrid
        """.trimIndent()

        val parsed = simulateCsvImport(csv)
        println("testTwoColumnCsvWithoutHeader parsed size: ${parsed.size}")
        assertEquals(4, parsed.size)
    }

    @Test
    fun testThreeColumnOneLinerCsvWithHeader() {
        val csv = """
            question, answer, explaination
            Who wrote the National Anthem of India?, Rabindranath Tagore, Jana Gana Mana
            What is the capital of Australia?, Canberra, Capital city
        """.trimIndent()

        val parsed = simulateCsvImport(csv)
        println("testThreeColumnOneLinerCsvWithHeader parsed size: ${parsed.size}")
        assertEquals(2, parsed.size)
    }

    @Test
    fun testFourColumnSampleMcq() {
        val csv = """
            "Quant, Number Systems", "What is the remainder when 2^31 is divided by 5?", "3 | 1 | 2 | 4", "Cycle of powers of 2 mod 5 is 2, 4, 3, 1"
            "Quant, Geometry", "The sum of interior angles of a regular hexagon is equal to:", "720 degrees | 540 degrees | 360 degrees | 900 degrees", "Sum of angles"
        """.trimIndent()

        val parsed = simulateCsvImport(csv)
        println("testFourColumnSampleMcq parsed size: ${parsed.size}")
        if (parsed.isNotEmpty()) {
            println("Row 0 front: ${parsed[0].front}")
            println("Row 0 back: ${parsed[0].back}")
        }
        assertEquals(2, parsed.size)
        // Check that front is the question, NOT the tag!
        assertTrue(parsed[0].front.contains("remainder"))
        assertTrue(parsed[0].back.contains("3 | 1 | 2 | 4"))
    }
}
