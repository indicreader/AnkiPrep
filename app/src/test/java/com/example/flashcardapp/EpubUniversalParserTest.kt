package com.example.flashcardapp

import org.jsoup.Jsoup
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class EpubUniversalParserTest {

    private val qStartRegex = Regex("""(?i)(?:^|\n)\s*(?:\*\*|\b)?(?:Q(?:uestion|\.|\s*\d+)?\s*[\.:\)]|\d+[\.\)]\s+Question|\d+\.\s+)(?![A-D]\b)""")

    private val optAPattern = Regex("""(?i)(?:^|[\s\n])(?:\(|\[)?(?:A|1)(?:\)|\]|\.|\:)\s*(.*?)(?=(?:[\s\n])(?:\(|\[)?(?:B|2)(?:\)|\]|\.|\:))""", RegexOption.DOT_MATCHES_ALL)
    private val optBPattern = Regex("""(?i)(?:^|[\s\n])(?:\(|\[)?(?:B|2)(?:\)|\]|\.|\:)\s*(.*?)(?=(?:[\s\n])(?:\(|\[)?(?:C|3)(?:\)|\]|\.|\:))""", RegexOption.DOT_MATCHES_ALL)
    private val optCPattern = Regex("""(?i)(?:^|[\s\n])(?:\(|\[)?(?:C|3)(?:\)|\]|\.|\:)\s*(.*?)(?=(?:[\s\n])(?:\(|\[)?(?:D|4)(?:\)|\]|\.|\:))""", RegexOption.DOT_MATCHES_ALL)
    private val optDPattern = Regex("""(?i)(?:^|[\s\n])(?:\(|\[)?(?:D|4)(?:\)|\]|\.|\:)\s*(.*?)(?=(?:\*\*Answer:|\bAnswer:|\bAns(?:wer)?|\bCorrect|\bKey|\bSol(?:ution)?|\bRight\s*Answer|$))""", RegexOption.DOT_MATCHES_ALL)

    private val ansKeyPattern = Regex(
        """(?i)(?:\*\*Answer:\*\*|\bAnswer:|\bAns(?:wer)?\s*[:\.-]|\bCorrect\s*(?:Option|Answer)\s*[:\.-]|\bKey\s*[:\.-]|\bRight\s*Answer\s*[:\.-])\s*(?:\(|\[)?([A-E1-5a-e])?(?:\)|\]|\.|\:)?\s*(.*?)(?=(?:\*\*Explanation:\*\*|\bExplanation:|\bExp(?:lanation)?\s*[:\.-]|\bSol(?:ution)?\s*[:\.-]|\bReason\s*[:\.-]|\bHint\s*[:\.-]|$))""",
        RegexOption.DOT_MATCHES_ALL
    )
    private val expKeyPattern = Regex(
        """(?i)(?:\*\*Explanation:\*\*|\bExplanation:|\bExp(?:lanation)?\s*[:\.-]|\bSol(?:ution)?\s*[:\.-]|\bReason\s*[:\.-]|\bHint\s*[:\.-])\s*(.*)""",
        RegexOption.DOT_MATCHES_ALL
    )

    private data class ParsedQ(
        val question: String,
        val answer: String,
        val optA: String,
        val optB: String,
        val optC: String,
        val optD: String,
        val explanation: String
    )

    private fun parseHtmlChapter(html: String): List<ParsedQ> {
        val doc = Jsoup.parse(html)
        val textWithNewlines = html.replace(Regex("(?i)<br\\s*/?>|</p>|</div>|</li>|</h1>|</h2>|</h3>|</h4>|<hr\\s*/?>"), "\n")
        val fullText = Jsoup.parse(textWithNewlines).wholeText()

        val hrBlocks = doc.body().html().split(Regex("(?i)<hr\\s*/?>|---|===|____"))
            .map { Jsoup.parse(it).text().trim() }
            .filter { it.length > 15 }

        val questionChunks = mutableListOf<String>()
        if (hrBlocks.size > 1 && hrBlocks.count { qStartRegex.containsMatchIn(it) || it.contains(Regex("(?i)Ans(?:wer)?:")) } >= 2) {
            questionChunks.addAll(hrBlocks)
        } else {
            val matches = qStartRegex.findAll(fullText).toList()
            if (matches.isNotEmpty()) {
                for (i in matches.indices) {
                    val start = matches[i].range.first
                    val end = if (i + 1 < matches.size) matches[i + 1].range.first else fullText.length
                    val chunk = fullText.substring(start, end).trim()
                    if (chunk.length > 15) {
                        questionChunks.add(chunk)
                    }
                }
            } else if (hrBlocks.isNotEmpty()) {
                questionChunks.addAll(hrBlocks)
            } else if (fullText.length > 15) {
                questionChunks.add(fullText)
            }
        }

        val results = mutableListOf<ParsedQ>()
        for (chunk in questionChunks) {
            val mHead = qStartRegex.find(chunk)
            val bodyAfterHead = if (mHead != null && mHead.range.first < 20) {
                chunk.substring(mHead.range.last + 1).trim()
            } else {
                chunk
            }

            val mAns = ansKeyPattern.find(bodyAfterHead)
            val mA = optAPattern.find(bodyAfterHead)
            val mB = optBPattern.find(bodyAfterHead)
            val mC = optCPattern.find(bodyAfterHead)
            val mD = optDPattern.find(bodyAfterHead)

            if (mAns != null || (mA != null && mB != null)) {
                val rawQuestion = when {
                    mA != null -> bodyAfterHead.substring(0, mA.range.first).trim()
                    mAns != null -> bodyAfterHead.substring(0, mAns.range.first).trim()
                    else -> bodyAfterHead.trim()
                }

                val optA = mA?.groupValues?.get(1)?.trim() ?: ""
                val optB = mB?.groupValues?.get(1)?.trim() ?: ""
                val optC = mC?.groupValues?.get(1)?.trim() ?: ""
                val optD = mD?.groupValues?.get(1)?.trim() ?: ""

                val ansLetter = mAns?.groupValues?.get(1)?.trim()?.uppercase() ?: ""
                val ansRaw = mAns?.groupValues?.get(2)?.trim() ?: ""
                val mExp = expKeyPattern.find(bodyAfterHead)
                val explanation = mExp?.groupValues?.get(1)?.trim() ?: ""

                var resolvedAnswer = ansRaw
                if (resolvedAnswer.isEmpty() || resolvedAnswer.uppercase() in listOf("A", "B", "C", "D", "1", "2", "3", "4")) {
                    val key = if (ansLetter.isNotEmpty()) ansLetter else resolvedAnswer.uppercase()
                    resolvedAnswer = when (key) {
                        "A", "1" -> optA
                        "B", "2" -> optB
                        "C", "3" -> optC
                        "D", "4" -> optD
                        else -> ansRaw
                    }
                }
                if (resolvedAnswer.isEmpty() && optA.isNotEmpty()) {
                    resolvedAnswer = optA
                }

                results.add(
                    ParsedQ(
                        question = rawQuestion,
                        answer = resolvedAnswer,
                        optA = optA,
                        optB = optB,
                        optC = optC,
                        optD = optD,
                        explanation = explanation
                    )
                )
            }
        }
        return results
    }

    @Test
    fun testContinuousHtmlChapterWithoutHrTags() {
        val html = """
            <html>
            <body>
                <h1>Indian Economy</h1>
                <p>1. In which year was the Reserve Bank of India established?</p>
                <p>(A) 1930</p>
                <p>(B) 1935</p>
                <p>(C) 1947</p>
                <p>(D) 1950</p>
                <p>Ans: (b)</p>
                <p>Exp: RBI was established on 1 April 1935 via the RBI Act 1934.</p>

                <p>2. Who was the first Indian to calculate National Income?</p>
                <p>1) Dadabhai Naoroji</p>
                <p>2) V.K.R.V. Rao</p>
                <p>3) P.C. Mahalanobis</p>
                <p>4) Amartya Sen</p>
                <p>Correct Option: 1</p>
                <p>Sol: Dadabhai Naoroji estimated per capita income in 1867-68.</p>

                <p>Q.3 The SI unit of electric potential difference is:</p>
                <p>A. Ampere</p>
                <p>B. Volt</p>
                <p>C. Ohm</p>
                <p>D. Watt</p>
                <p>Answer: B) Volt</p>
                <p>Explanation: One volt equals one joule per coulomb.</p>
            </body>
            </html>
        """.trimIndent()

        val parsed = parseHtmlChapter(html)
        assertEquals("Must extract all 3 questions from continuous HTML without <hr/> tags", 3, parsed.size)

        // Q1 verification
        assertTrue(parsed[0].question.contains("Reserve Bank of India established"))
        assertEquals("1930", parsed[0].optA)
        assertEquals("1935", parsed[0].optB)
        assertEquals("1935", parsed[0].answer) // Resolved from (b)
        assertTrue(parsed[0].explanation.contains("1 April 1935"))

        // Q2 verification
        assertTrue(parsed[1].question.contains("calculate National Income"))
        assertEquals("Dadabhai Naoroji", parsed[1].optA)
        assertEquals("Dadabhai Naoroji", parsed[1].answer) // Resolved from Correct Option: 1
        assertTrue(parsed[1].explanation.contains("1867-68"))

        // Q3 verification
        assertTrue(parsed[2].question.contains("electric potential difference"))
        assertEquals("Ampere", parsed[2].optA)
        assertEquals("Volt", parsed[2].optB)
        assertEquals("Volt", parsed[2].answer)
        assertTrue(parsed[2].explanation.contains("joule per coulomb"))
    }
}
