package com.example.flashcardapp.data.core

import java.util.regex.Pattern

/**
 * Metadata & Subject Classification Extractor for PYQ Booklets.
 *
 * Extracts subject names, sub-topic section headers, and exam metadata from text blocks.
 */
data class ExamMetadata(
    val rawTag: String = "",
    val examName: String = "SSC General",
    val year: Int = 0
)

object PyqMetadataExtractor {

    // Known top-level Subject Chapters
    val KNOWN_SUBJECTS = listOf(
        "ECONOMICS",
        "INDIAN POLITY",
        "INDIAN HISTORY",
        "ANCIENT HISTORY",
        "MEDIEVAL HISTORY",
        "MODERN HISTORY",
        "GEOGRAPHY",
        "PHYSICS",
        "CHEMISTRY",
        "BIOLOGY",
        "SPORTS",
        "COMPUTER",
        "ENVIRONMENT",
        "GENERAL SCIENCE"
    )

    // Regex to match exam tag blocks like `[S.S.C LDC Exam, 2015]`, `[SSC CGL Tier-I 2018]`, `[SSC CPO 2021]`
    private val EXAM_TAG_PATTERN = Pattern.compile("\\[([^\\]]+)\\]")

    // Regex to extract 4-digit exam year (e.g., 2015, 2019, 2022)
    private val YEAR_PATTERN = Pattern.compile("\\b(19\\d{2}|20\\d{2})\\b")

    /**
     * Checks if a line is a Subject Chapter Header (e.g. "ECONOMICS", "INDIAN POLITY").
     */
    fun detectSubject(line: String): String? {
        val uppercaseLine = line.trim().uppercase()
        for (subj in KNOWN_SUBJECTS) {
            if (uppercaseLine == subj || uppercaseLine == "CHAPTER: $subj" || uppercaseLine.startsWith("$subj ")) {
                return subj
            }
        }
        return null
    }

    /**
     * Checks if a line is a Sub-Topic Section Header (e.g. "Macro Economics", "National Income", "Preamble").
     */
    fun isSubTopicHeader(line: String): Boolean {
        val trimmed = line.trim()
        if (trimmed.length < 3 || trimmed.length > 60) return false
        // Skip lines that look like questions, choices, or answers
        if (trimmed.startsWith("[") || trimmed.startsWith("(") || trimmed.contains("Expl:-")) return false
        if (Regex("^(?i)(?:Q\\d|Ans\\.|Expl)").containsMatchIn(trimmed)) return false
        
        // Match title-case section headers or uppercase topics without ending periods
        return (trimmed == trimmed.uppercase() || trimmed == trimmed.split(" ").joinToString(" ") { 
            it.replaceFirstChar { c -> if (c.isLowerCase()) c.titlecase() else c.toString() } 
        }) && !trimmed.endsWith(".")
    }

    /**
     * Parses an exam tag string like `"[S.S.C LDC Exam, 2015]"` into structured [ExamMetadata].
     */
    fun parseExamMetadata(text: String): ExamMetadata {
        val matcher = EXAM_TAG_PATTERN.matcher(text)
        if (matcher.find()) {
            val rawTag = matcher.group(0) ?: ""
            val innerContent = matcher.group(1) ?: rawTag

            // Extract Year
            var year = 0
            val yearMatcher = YEAR_PATTERN.matcher(innerContent)
            if (yearMatcher.find()) {
                year = yearMatcher.group(1)?.toIntOrNull() ?: 0
            }

            // Clean Exam Name (strip year and commas)
            var examName = innerContent.replace(YEAR_PATTERN.pattern().toRegex(), "")
                .replace(",", "")
                .replace("Exam", "")
                .replace("S.S.C", "SSC")
                .trim()

            if (examName.isEmpty()) examName = "SSC General"

            return ExamMetadata(
                rawTag = rawTag,
                examName = examName,
                year = year
            )
        }

        return ExamMetadata()
    }

    /**
     * Maps subject names to clean target filenames (e.g., "ECONOMICS" -> "economics.csv").
     */
    fun getCsvFileName(subject: String): String {
        val clean = subject.lowercase()
            .replace("indian ", "")
            .replace(" ", "_")
            .replace("-", "_")
        return "${clean}.csv"
    }
}
