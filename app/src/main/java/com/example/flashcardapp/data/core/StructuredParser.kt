package com.example.flashcardapp.data.core

import java.util.Locale

data class ParsedCard(
    val question: String = "",
    val answer: String,
    val explanation: String,
    val hints: List<String> = emptyList(),
    val metadata: Map<String, String> = emptyMap(),
    val options: List<String> = emptyList(),
    val rawContent: String
)

object StructuredParser {
    private val EXPLANATION_TAGS = setOf("explain", "explanation", "explaination")
    private val FUTURE_TAGS = setOf("hint", "mnemonic", "warning", "formula", "memorytrap")

    fun parse(content: String?): ParsedCard {
        val raw = content ?: ""
        if (raw.isBlank()) {
            return ParsedCard("", "", "", emptyList(), emptyMap(), emptyList(), raw)
        }

        // Find all tags in format {tagname}
        val tagRegex = Regex("""\{([a-zA-Z0-9_-]+)\}""")
        val matches = tagRegex.findAll(raw).toList()

        val firstTagStart = if (matches.isNotEmpty()) matches.first().range.first else raw.length
        val rawAnswerBlock = raw.substring(0, firstTagStart).trim()

        var answer = rawAnswerBlock
        var explanation = ""
        var options = emptyList<String>()

        // Split by pipe to extract answers, options, and explanation
        val parts = answer.split("|").map { it.trim() }.filter { it.isNotEmpty() }
        if (parts.size > 1) {
            answer = parts[0]
            val remainingParts = parts.drop(1).toMutableList()
            
            // Check if the last part has a semicolon separating the explanation
            val lastPart = remainingParts.last()
            val semicolonIndex = lastPart.lastIndexOf(';')
            if (semicolonIndex != -1) {
                val optText = lastPart.substring(0, semicolonIndex).trim()
                val explText = lastPart.substring(semicolonIndex + 1).trim()
                if (explText.isNotEmpty()) {
                    explanation = explText
                }
                if (optText.isNotEmpty()) {
                    remainingParts[remainingParts.size - 1] = optText
                } else {
                    remainingParts.removeAt(remainingParts.size - 1)
                }
            } else {
                // If there's no semicolon, check if the last part is actually an explanation.
                // It is an explanation if parts.size >= 5 (standard: answer | 3 options | explanation)
                // OR if it contains spaces and is longer than 15 chars.
                val hasExplanation = parts.size >= 5 || (parts.size >= 3 && lastPart.contains(" ") && lastPart.length > 15)
                if (hasExplanation) {
                    explanation = lastPart
                    remainingParts.removeAt(remainingParts.size - 1)
                }
            }
            options = remainingParts
        } else {
             // Handle cases where there might just be a semicolon separator for explanation without options
             val semicolonIndex = answer.lastIndexOf(';')
             if (semicolonIndex != -1) {
                 explanation = answer.substring(semicolonIndex + 1).trim()
                 answer = answer.substring(0, semicolonIndex).trim()
             }
        }

        val hints = mutableListOf<String>()
        val metadata = mutableMapOf<String, String>()

        // Process each tag block
        for (i in matches.indices) {
            val currentMatch = matches[i]
            val tagName = currentMatch.groupValues[1].lowercase(Locale.ROOT)
            val contentStart = currentMatch.range.last + 1
            val contentEnd = if (i + 1 < matches.size) {
                matches[i + 1].range.first
            } else {
                raw.length
            }

            val blockContent = raw.substring(contentStart, contentEnd).trim()

            when {
                EXPLANATION_TAGS.contains(tagName) -> {
                    explanation = if (explanation.isEmpty()) blockContent else "$explanation\n$blockContent"
                }
                tagName == "hint" -> {
                    if (blockContent.isNotEmpty()) {
                        hints.add(blockContent)
                    }
                }
                else -> {
                    metadata[tagName] = blockContent
                }
            }
        }

        return ParsedCard(
            question = "",
            answer = answer,
            explanation = explanation.trim(),
            hints = hints,
            metadata = metadata,
            options = options,
            rawContent = raw
        )
    }

    /**
     * Parses a card given its front and back. Handles cases where the MCQ format is embedded
     * in the front (e.g. "question: correct answer | option 1 | option 2 | option 3")
     * or in the back (e.g. "correct answer | option 1 | option 2 | option 3").
     */
    private fun splitByCommaOrColon(text: String): List<String> {
        val parts = mutableListOf<String>()
        val current = StringBuilder()
        var inParentheses = 0
        var inQuotes = false
        var i = 0
        while (i < text.length) {
            val c = text[i]
            when {
                c == '"' -> inQuotes = !inQuotes
                c == '(' && !inQuotes -> inParentheses++
                c == ')' && !inQuotes -> inParentheses = (inParentheses - 1).coerceAtLeast(0)
                (c == ',' || c == ':') && !inQuotes && inParentheses == 0 -> {
                    parts.add(current.toString())
                    current.clear()
                }
                else -> current.append(c)
            }
            i++
        }
        parts.add(current.toString())
        return parts.map { it.trim() }.filter { it.isNotEmpty() }
    }

    private fun parseOneLinerBack(back: String): Pair<String, String> {
        val parts = splitByCommaOrColon(back)
        if (parts.size >= 2) {
            val lastPart = parts.last()
            val hasExplanation = lastPart.contains(" ") || lastPart.length > 15
            if (hasExplanation) {
                val explanation = lastPart
                val answer = parts.take(parts.size - 1).joinToString(", ")
                return Pair(answer, explanation)
            }
        }

        val semicolonIndex = back.lastIndexOf(';')
        if (semicolonIndex != -1) {
            val answer = back.substring(0, semicolonIndex).trim()
            val explanation = back.substring(semicolonIndex + 1).trim()
            return Pair(answer, explanation)
        }

        return Pair(back, "")
    }

    /**
     * Parses a card given its front and back. Handles cases where the MCQ format is embedded
     * in the front (e.g. "question: correct answer | option 1 | option 2 | option 3")
     * or in the back (e.g. "correct answer | option 1 | option 2 | option 3").
     */
    fun parseCard(front: String, back: String): ParsedCard {
        val cleanFront = front.trim()
        val cleanBack = back.trim()

        if (cleanFront.contains("|")) {
            val firstPipeIndex = cleanFront.indexOf('|')
            val colonIndex = cleanFront.lastIndexOf(':', firstPipeIndex)
            val commaIndex = cleanFront.lastIndexOf(',', firstPipeIndex)
            val separatorIndex = maxOf(colonIndex, commaIndex)
            val questionText: String
            val mcqPart: String
            if (separatorIndex != -1) {
                questionText = cleanFront.substring(0, separatorIndex).trim()
                mcqPart = cleanFront.substring(separatorIndex + 1).trim()
            } else {
                questionText = cleanFront.substring(0, firstPipeIndex).trim()
                mcqPart = cleanFront.substring(firstPipeIndex).trim()
            }

            val parsedMcq = parse(mcqPart)
            val parsedBack = parse(cleanBack)

            val mergedExplanation = listOf(parsedMcq.explanation, parsedBack.answer, parsedBack.explanation)
                .filter { it.isNotEmpty() }
                .distinct()
                .joinToString("\n")

            return ParsedCard(
                question = questionText,
                answer = parsedMcq.answer,
                explanation = mergedExplanation,
                hints = (parsedMcq.hints + parsedBack.hints).distinct(),
                metadata = parsedMcq.metadata + parsedBack.metadata,
                options = parsedMcq.options,
                rawContent = front + "\n" + back
            )
        } else if (cleanBack.contains("|")) {
            val parsedBack = parse(cleanBack)
            return ParsedCard(
                question = cleanFront,
                answer = parsedBack.answer,
                explanation = parsedBack.explanation,
                hints = parsedBack.hints,
                metadata = parsedBack.metadata,
                options = parsedBack.options,
                rawContent = front + "\n" + back
            )
        } else {
            if (cleanBack.isEmpty() && (cleanFront.contains(",") || cleanFront.contains(":"))) {
                val parts = splitByCommaOrColon(cleanFront)
                if (parts.size >= 2) {
                    val lastPart = parts.last()
                    val hasExplanation = lastPart.contains(" ") || lastPart.length > 15
                    val qText: String
                    val aText: String
                    var eText = ""

                    if (parts.size >= 3 && hasExplanation) {
                        eText = lastPart
                        aText = parts[parts.size - 2]
                        qText = parts.take(parts.size - 2).joinToString(", ")
                    } else {
                        aText = lastPart
                        qText = parts.take(parts.size - 1).joinToString(", ")
                    }

                    return ParsedCard(
                        question = qText.trim(),
                        answer = aText.trim(),
                        explanation = eText.trim(),
                        rawContent = front
                    )
                }
            }

            val parsedBack = parseOneLinerBack(cleanBack)
            return ParsedCard(
                question = cleanFront,
                answer = parsedBack.first,
                explanation = parsedBack.second,
                rawContent = front + "\n" + back
            )
        }
    }
}
