package com.example.flashcardapp.data.core

import java.util.regex.Pattern

/**
 * Universal Text and Font Normalization Engine for Exam Booklets and Study PDFs.
 *
 * Cleans font encoding artifacts, replaces non-printable character codes,
 * removes recurring page headers/footers, editorial notes, disclaimers, and normalizes whitespaces.
 */
object PyqTextNormalizer {

    // Regex to match non-printable font artifact '\u0018' (\x18)
    private val FONT_ARTIFACT_PATTERN = Pattern.compile("\u0018")

    // Common header/footer patterns and note noise found across any PDF exam or study booklet
    private val HEADER_PATTERNS = listOf(
        Regex("(?i)Page\\s+\\d+\\s+(?:of|/)\\s+\\d+"),
        Regex("(?i)\\bPage\\s+\\d+\\b"),
        Regex("(?i)www\\.[a-zA-Z0-9.-]+\\.[a-z]+"),
        Regex("(?i)https?://[a-zA-Z0-9.-]+"),
        Regex("(?i)^[\\s*\\-–—=~_#]{4,}$"), // horizontal decorative line rules
        Regex("(?i)^(?:Note|Notes|Important\\s+Note|Disclaimer|Preface|Syllabus|Contents|Index|Chapter\\s*Summary|Table\\s+of\\s+Contents)\\s*[:.]?$"),
        Regex("(?i)^(?:Copyright|All\\s+rights\\s+reserved|Published\\s+by|Printed\\s+by|Author|Edition|ISBN|Price|MRP|Publisher)\\b.*")
    )

    /**
     * Checks if a line is pure study theory, chapter summary, or editorial note that should not be parsed as a question.
     */
    fun isIgnorableNoteOrBoilerplate(line: String): Boolean {
        val t = line.trim()
        if (t.length < 3) return false
        val notePrefixes = listOf(
            Regex("(?i)^(?:Note|Please\\s+Note|Important\\s+Points?|Key\\s+Points?|Summary|Theory|Overview|Remember|Tips?|Quick\\s+Facts?|Points?\\s+to\\s+Remember)\\s*[:.-]"),
            Regex("(?i)^(?:Copyright|All\\s+rights\\s+reserved|Published\\s+by|Printed\\s+by|Author|Edition|ISBN|Disclaimer|Preface|Foreword|Introduction)\\b"),
            Regex("(?i)^(?:Chapter|Unit|Module|Lesson|Section)\\s*\\d*\\s*[:.-]?\\s*(?:Summary|Revision|Overview|Introduction|Notes)$"),
            Regex("(?i)^For\\s+(?:more\\s+details|online\\s+classes|mock\\s+tests|updates|queries|free\\s+study\\s+material)\\b"),
            Regex("(?i)^(?:Join\\s+our\\s+Telegram|Subscribe\\s+to|Download\\s+(?:our\\s+)?App|Call\\s+us|Helpline|Visit\\s+our\\s+website)\\b")
        )
        return notePrefixes.any { it.containsMatchIn(t) }
    }

    /**
     * Normalizes raw extracted text from PDF pages.
     *
     * @param rawText Raw text string from PDF parser page
     * @return Cleaned, normalized string ready for structure parsing
     */
    fun normalizeText(rawText: String?): String {
        if (rawText.isNullOrEmpty()) return ""

        var text = rawText

        // 1. Correct custom font encoding artifacts: '\u0018' -> '1'
        text = text.replace("\u0018", "1")
        text = text.replace("\u0010", "0")
        text = text.replace("\u0019", "2")

        // 2. Strip recurring headers & footers line by line
        val lines = text.split("\n")
        val cleanedLines = ArrayList<String>()

        for (line in lines) {
            val trimmedLine = line.trim()
            if (trimmedLine.isEmpty()) continue

            // Skip lines matching header/footer patterns
            var isHeader = false
            for (pattern in HEADER_PATTERNS) {
                if (pattern.containsMatchIn(trimmedLine)) {
                    isHeader = true
                    break
                }
            }
            if (!isHeader && !isIgnorableNoteOrBoilerplate(trimmedLine)) {
                cleanedLines.add(trimmedLine)
            }
        }

        // 3. Join lines preserving structural spacing
        text = cleanedLines.joinToString("\n")

        // 4. Normalize multiple spaces and non-breaking spaces
        text = text.replace('\u00A0', ' ') // non-breaking space
        text = text.replace(Regex("[ \\t]+"), " ")

        return text.trim()
    }

    /**
     * Cleans an isolated question or choice string by stripping leading numbers/bullets/serials.
     */
    fun cleanQuestionStatement(statement: String): String {
        var clean = normalizeText(statement)
        // Strip leading question serial prefixes (Q1., Q1, Q.1, Q. 1, Question 1, 1., 1), (1), [1], Prob 1., Item 1., etc.)
        val serialRegex = Regex(
            "(?i)^\\s*(?:" +
            "(?:(?:Q(?:uestion|ue)?|Prob(?:lem)?|Item)\\s*[-.:]?\\s*\\(?\\d{1,4}\\)?\\s*[-.:)]?)" +
            "|" +
            "(?:\\(?\\d{1,4}\\s*[-.:)]\\s*)" +
            "|" +
            "(?:\\(\\d{1,4}\\)|\\[\\d{1,4}\\])" +
            "|" +
            "(?:Q\\s*[:.-])" +
            "|" +
            "(?:Q\\d{1,4}\\b)" +
            ")\\s*"
        )
        clean = clean.replace(serialRegex, "")
        clean = clean.replace(serialRegex, "")
        return clean.trim()
    }

    /**
     * Cleans option choice text by stripping (a)-(e), (1)-(5), A.-E., 1.-5. prefixes.
     */
    fun cleanOptionText(optionText: String): String {
        var clean = normalizeText(optionText)
        clean = clean.replace(Regex("^(?i)(?:\\([a-e1-5]\\)|\\[[a-e1-5]\\]|[a-e1-5][.):\\-])\\s*"), "")
        return clean.trim()
    }
}
