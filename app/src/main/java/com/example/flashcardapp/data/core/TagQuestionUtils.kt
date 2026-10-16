package com.example.flashcardapp.data.core

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Utility for parsing and normalizing tags and extracting misplaced questions from tags.
 *
 * Rules enforced:
 * 1. Tags are separated strictly by commas (`,`).
 * 2. Tags must be short: contains not more than 5 words.
 * 3. In case there is a tag which ends with `/` or looks like a question, it is treated
 *    as a question (and extracted accordingly), and excluded from the tags list.
 * 4. Extracted questions have trailing `/` stripped.
 */
object TagQuestionUtils {

    private val gson = Gson()
    private val tagListType = object : TypeToken<List<String>>() {}.type

    private val QUESTION_STARTERS = setOf(
        "what", "which", "who", "whom", "whose", "where", "when", "why", "how",
        "name", "identify", "define", "state", "choose", "find", "fill", "explain",
        "in which", "at what", "from which", "by whom", "during which"
    )

    /**
     * Determines whether a candidate text string ends with '/' or looks like a question.
     */
    fun isQuestionCandidate(text: String): Boolean {
        val trimmed = text.trim()
        if (trimmed.isEmpty()) return false

        // Rule: Ends with '/'
        if (trimmed.endsWith("/")) return true

        // Rule: Ends with '?'
        if (trimmed.endsWith("?")) return true

        // Fill-in-the-blank blanks or ellipses preceding a slash/question
        if (trimmed.contains("____") || trimmed.contains(".....") || trimmed.contains("/?")) {
            return true
        }

        val lower = trimmed.lowercase().removePrefix("#").trim()
        val words = lower.split(Regex("\\s+")).filter { it.isNotEmpty() }

        // Check if starts with a known question phrase
        for (starter in QUESTION_STARTERS) {
            if (lower.startsWith(starter) && words.size >= 3) {
                return true
            }
        }

        // Tags containing more than 5 words are not valid tags; if they are sentence-like, treat as question
        if (words.size > 5 && (trimmed.contains(" ") && (lower.contains(" is ") || lower.contains(" are ") || lower.contains(" was ") || lower.contains(" were ")))) {
            return true
        }

        return false
    }

    /**
     * Cleans trailing slashes and redundant whitespaces from an extracted question string.
     */
    fun normalizeExtractedQuestion(rawQuestion: String): String {
        var clean = rawQuestion.trim()
        while (clean.endsWith("/") || clean.endsWith("\\")) {
            clean = clean.dropLast(1).trim()
        }
        return clean
    }

    /**
     * Parses a raw tags input (JSON array or comma-separated string) and separates it into:
     * - `first`: A list of valid tags (each <= 5 words, separated by comma, no questions).
     * - `second`: An extracted question if any tag ended with `/` or matched a question pattern.
     */
    fun parseAndFilterTags(tagsInput: String?): Pair<List<String>, String?> {
        if (tagsInput.isNullOrBlank()) return Pair(emptyList(), null)
        val trimmed = tagsInput.trim()

        val rawItems = mutableListOf<String>()

        if (trimmed.startsWith("[")) {
            try {
                val list: List<String>? = gson.fromJson(trimmed, tagListType)
                if (list != null) {
                    for (item in list) {
                        // Even within JSON array elements, check if multiple comma- or semicolon-separated items exist
                        if (item.contains(",") || item.contains(";")) {
                            rawItems.addAll(item.split(Regex("[,;]")))
                        } else {
                            rawItems.add(item)
                        }
                    }
                }
            } catch (e: Exception) {
                // Fallback: strip brackets and split by comma or semicolon
                val unbracketed = trimmed.removePrefix("[").removeSuffix("]")
                rawItems.addAll(unbracketed.split(Regex("[,;]")))
            }
        } else {
            // Split by comma or semicolon
            rawItems.addAll(trimmed.split(Regex("[,;]")))
        }

        val cleanTags = mutableListOf<String>()
        var extractedQuestion: String? = null

        for (raw in rawItems) {
            val item = raw.trim().removePrefix("#").trim()
            if (item.isEmpty()) continue

            if (isQuestionCandidate(item)) {
                // Treat as question
                if (extractedQuestion == null) {
                    extractedQuestion = normalizeExtractedQuestion(item)
                }
            } else {
                // Check word count constraint: not more than 5 words
                val words = item.split(Regex("\\s+")).filter { it.isNotEmpty() }
                if (words.isNotEmpty() && words.size <= 5) {
                    cleanTags.add(item)
                } else if (words.size > 5 && extractedQuestion == null) {
                    // Tag is too long; treat it as the question
                    extractedQuestion = normalizeExtractedQuestion(item)
                }
            }
        }

        return Pair(cleanTags.distinct(), extractedQuestion)
    }

    /**
     * Converts a raw tags input into a JSON-serialized string of cleaned, valid tags.
     */
    fun sanitizeTagsToJson(tagsInput: String?): String {
        val (cleanTags, _) = parseAndFilterTags(tagsInput)
        return gson.toJson(cleanTags)
    }
}
