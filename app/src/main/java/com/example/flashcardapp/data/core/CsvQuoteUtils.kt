package com.example.flashcardapp.data.core

import android.content.Context
import com.example.flashcardapp.data.entities.QuestionEntity
import com.example.flashcardapp.data.scraper.ScrapedCard
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.nio.charset.StandardCharsets

/**
 * Custom Idempotent RFC-4180 CSV Formatting & Pre-Checking Utility.
 *
 * Guarantees zero double-wrapped quote artifacts (""text"") and ensures internal commas (,),
 * slashes (/), em-dashes (--), and line breaks never alter CSV column boundaries.
 * Pre-checks raw CSV text, detects unquoted multiple separators in questions/options,
 * applies proper RFC-4180 "" wrapping on questions and options, and parses rows cleanly.
 */
object CsvQuoteUtils {

    private const val UTF8_BOM = "\uFEFF"

    /**
     * Idempotently formats a text field for RFC-4180 compliance.
     *
     * Rules:
     * - If string is null or empty, returns empty string `""`.
     * - If string already starts and ends with double quotes `"` and does NOT contain illegal double-wrapped pattern, returns as-is (avoids double wrapping).
     * - Cleans any redundant `""text""` outer quote artifacts.
     * - If quotes are missing and text contains delimiter, quotes, newlines, option pipe (|), or forceQuote is true, wraps in `"..."` with escaped internal quotes.
     */
    fun quoteRfc4180(text: String?, delimiter: Char = ',', forceQuote: Boolean = false): String {
        if (text == null) return ""
        var trimmed = text.trim()
        if (trimmed.isEmpty()) return ""

        // Handle double-wrapper artifacts like `""text""`
        while (trimmed.length >= 4 && trimmed.startsWith("\"\"") && trimmed.endsWith("\"\"")) {
            trimmed = trimmed.substring(1, trimmed.length - 1).trim()
        }

        // Check if string is already fully quoted cleanly: starts with '"' and ends with '"'
        val isAlreadyQuoted = trimmed.length >= 2 && trimmed.startsWith("\"") && trimmed.endsWith("\"") &&
                !trimmed.substring(1, trimmed.length - 1).startsWith("\"")

        if (isAlreadyQuoted) {
            return trimmed
        }

        // Clean unbalanced single outer quotes if present
        if (trimmed.startsWith("\"") && !trimmed.endsWith("\"") && trimmed.count { it == '"' } == 1) {
            trimmed = trimmed.substring(1)
        } else if (!trimmed.startsWith("\"") && trimmed.endsWith("\"") && trimmed.count { it == '"' } == 1) {
            trimmed = trimmed.substring(0, trimmed.length - 1)
        }

        // Check if quoting is needed for CSV column safety
        val needsQuoting = forceQuote ||
                trimmed.contains(delimiter) ||
                trimmed.contains('"') ||
                trimmed.contains('\n') ||
                trimmed.contains('\r') ||
                trimmed.contains('|')

        return if (needsQuoting) {
            val escaped = trimmed.replace("\"", "\"\"")
            "\"$escaped\""
        } else {
            trimmed
        }
    }

    /**
     * Pre-checks raw CSV content before importing/parsing.
     * Scans for lines where questions, options, or fields contain unquoted delimiters
     * (e.g. multiple commas in unquoted questions like: "What are 1, 2, and 3?, Option A, Ans").
     * Reconstructs broken fields, fills missing/blank option slots with "None of the above",
     * and ensures every field containing delimiters, quotes, or option separators is safely quote-wrapped ("...") according to RFC-4180.
     */
    /**
     * Merges adjacent cells that were inadvertently split on internal thousands commas in numbers
     * (e.g. ["10", "000 to 6000 bce"] -> ["10,000 to 6000 bce"]).
     */
    fun mergeSplitNumericCommas(cells: List<String>): List<String> {
        if (cells.size <= 1) return cells
        val result = mutableListOf<String>()
        var i = 0
        while (i < cells.size) {
            var current = cells[i]
            while (i + 1 < cells.size &&
                Regex("""(?:^|\D)\d{1,3}$""").containsMatchIn(current.trim()) &&
                Regex("""^\d{3}(?:\D.*|$)""").matches(cells[i + 1].trim())
            ) {
                current = "$current,${cells[i + 1]}"
                i++
            }
            result.add(current)
            i++
        }
        return result
    }

    /**
     * Pre-checks raw CSV content before importing/parsing.
     * Scans for lines where questions, options, or fields contain unquoted delimiters
     * (e.g. multiple commas in unquoted questions like: "What are 1, 2, and 3?, Option A, Ans").
     * Reconstructs broken fields, fills missing/blank option slots with "None of the above",
     * and ensures every field containing delimiters, quotes, or option separators is safely quote-wrapped ("...") according to RFC-4180.
     */
    fun sanitizeAndQuoteCsv(rawContent: String, delimiter: Char = ','): String {
        if (rawContent.isBlank()) return rawContent

        val cleanContent = if (rawContent.startsWith(UTF8_BOM)) rawContent.substring(1) else rawContent
        if (cleanContent.isBlank()) return rawContent

        val initialParsedRows = parseCsv(cleanContent, delimiter)
        if (initialParsedRows.isEmpty()) return rawContent

        val expectedCols = determineExpectedColumns(initialParsedRows)

        val sb = StringBuilder()
        if (rawContent.startsWith(UTF8_BOM)) {
            sb.append(UTF8_BOM)
        }

        for (row in initialParsedRows) {
            val parsedCells = mergeSplitNumericCommas(row)

            val finalCells: List<String> = if (parsedCells.size > expectedCols && expectedCols >= 2) {
                repairMalformedRow(parsedCells, expectedCols, delimiter)
            } else {
                parsedCells
            }

            val sanitizedCells = finalCells.map { cell ->
                if (cell.contains('|')) sanitizeOptions(cell) else cell
            }

            val formattedRow = sanitizedCells.joinToString(delimiter.toString()) { quoteRfc4180(it, delimiter) }
            sb.append(formattedRow).append("\n")
        }

        return sb.toString().trimEnd('\n')
    }

    /**
     * Sanitizes pipe-separated option strings (e.g. "1922| 1320||1920| |").
     * Replaces blank or missing options with "None of the above" as default,
     * ensuring that options lists are complete and valid.
     */
    fun sanitizeOptions(text: String): String {
        if (!text.contains('|')) return text

        val rawParts = text.split('|').map { it.trim() }
        if (rawParts.all { it.isEmpty() }) return text

        val filledParts = rawParts.map { part ->
            if (part.isEmpty()) "None of the above" else part
        }.toMutableList()

        while (filledParts.size > 4 && filledParts.last() == "None of the above") {
            filledParts.removeAt(filledParts.size - 1)
        }

        return filledParts.joinToString(" | ")
    }

    private fun determineExpectedColumns(rows: List<List<String>>): Int {
        if (rows.isEmpty()) return 2
        val firstRow = rows.first()
        if (looksLikeHeader(firstRow)) {
            return firstRow.size.coerceAtLeast(2)
        }
        val counts = rows.map { rawRow ->
            val row = mergeSplitNumericCommas(rawRow)
            val qIndex = row.indexOfFirst { it.contains('?') }
            if (qIndex >= 2 && row.size >= 5) {
                5
            } else if (qIndex >= 0 && qIndex < row.size - 1) {
                1 + (row.size - 1 - qIndex)
            } else {
                row.size
            }
        }.filter { it >= 2 }

        if (counts.isEmpty()) return 2
        // Use the mode (most common column count) so a few 2-column rows don't collapse 3-column rows
        val frequencyMap = counts.groupingBy { it }.eachCount()
        return frequencyMap.maxByOrNull { it.value }?.key?.coerceAtLeast(2) ?: 2
    }

    fun looksLikeHeader(row: List<String>): Boolean {
        val headers = setOf(
            "front", "back", "question", "answer", "term", "definition", "q", "a", "tags", "tag",
            "prompt", "response", "explanation", "explain", "explaination", "options", "option", "distractor",
            "option_a", "option_b", "option_c", "option_d", "subject", "sub_topic", "topic", "subtopic", "sub-topic",
            "category", "subcategory", "sub_category", "sub-category",
            "ques", "ans", "fact", "liner ques", "one-liner", "detail", "sol", "solution"
        )
        val firstCell = row.getOrNull(0)?.trim()?.removeSurrounding("\"")?.lowercase() ?: return false
        return firstCell in headers || row.any { cell -> cell.trim().removeSurrounding("\"").lowercase() in headers }
    }

    private fun repairMalformedRow(
        parsedCells: List<String>,
        expectedCols: Int,
        delimiter: Char
    ): List<String> {
        if (expectedCols == 5 && parsedCells.size > 5) {
            val qMarkIndex = parsedCells.indexOfFirst { it.contains('?') }
            return if (qMarkIndex >= 2 && qMarkIndex < parsedCells.size - 1) {
                val topic = parsedCells[0]
                val subtopic = parsedCells[1]
                val question = parsedCells.subList(2, qMarkIndex + 1).joinToString(delimiter.toString())
                val remaining = parsedCells.subList(qMarkIndex + 1, parsedCells.size)
                when (remaining.size) {
                    1 -> listOf(topic, subtopic, question, remaining[0], "")
                    2 -> listOf(topic, subtopic, question, remaining[0], remaining[1])
                    else -> {
                        val explanation = remaining.last()
                        val answer = remaining.subList(0, remaining.size - 1).joinToString(delimiter.toString())
                        listOf(topic, subtopic, question, answer, explanation)
                    }
                }
            } else {
                // No ? mark: Topic = Col 0, Subtopic = Col 1, Explanation = last, Answer = 2nd to last, Middle = Question
                val topic = parsedCells[0]
                val subtopic = parsedCells[1]
                val explanation = parsedCells.last()
                val answer = parsedCells[parsedCells.size - 2]
                val question = parsedCells.subList(2, parsedCells.size - 2).joinToString(delimiter.toString())
                listOf(topic, subtopic, question, answer, explanation)
            }
        }

        val qMarkIndex = parsedCells.indexOfFirst { it.contains('?') }
        return if (qMarkIndex >= 0 && qMarkIndex < parsedCells.size - 1) {
            val questionField = parsedCells.subList(0, qMarkIndex + 1).joinToString(delimiter.toString())
            val remainingCells = parsedCells.subList(qMarkIndex + 1, parsedCells.size)
            if (remainingCells.size <= expectedCols - 1) {
                listOf(questionField) + remainingCells
            } else {
                val answerField = remainingCells.subList(0, remainingCells.size - (expectedCols - 2))
                    .joinToString(delimiter.toString())
                val trailingFields = remainingCells.subList(remainingCells.size - (expectedCols - 2), remainingCells.size)
                listOf(questionField, answerField) + trailingFields
            }
        } else {
            val trailingCount = expectedCols - 1
            val questionField = parsedCells.subList(0, parsedCells.size - trailingCount).joinToString(delimiter.toString())
            val trailingFields = parsedCells.subList(parsedCells.size - trailingCount, parsedCells.size)
            listOf(questionField) + trailingFields
        }
    }

    /**
     * Parses a single CSV line according to RFC-4180 rules.
     */
    fun parseCsvLine(line: String, delimiter: Char = ','): List<String> {
        val result = mutableListOf<String>()
        val current = StringBuilder()
        var inQuotes = false
        var i = 0
        val len = line.length

        while (i < len) {
            val c = line[i]
            val nextC = if (i + 1 < len) line[i + 1] else '\u0000'

            if (inQuotes) {
                if (c == '"') {
                    if (nextC == '"') {
                        current.append('"')
                        i++
                    } else {
                        inQuotes = false
                    }
                } else {
                    current.append(c)
                }
            } else {
                when {
                    c == '"' -> {
                        inQuotes = true
                    }
                    c == delimiter -> {
                        result.add(current.toString())
                        current.clear()
                    }
                    else -> current.append(c)
                }
            }
            i++
        }
        result.add(current.toString())
        return result
    }

    /**
     * Reads a full CSV text stream into rows of cell arrays according to RFC 4180.
     * Handles BOM removal, multiline fields within double quotes, escaped quotes (""),
     * and arbitrary line endings (\r\n, \n, \r).
     */
    /**
     * Reads a full CSV text stream into rows of cell arrays according to RFC 4180.
     * Handles BOM removal, multiline fields within double quotes, escaped quotes (""),
     * and arbitrary line endings (\r\n, \n, \r).
     */
    fun parseCsv(rawContent: String, delimiter: Char = ','): List<List<String>> {
        val cleanContent = if (rawContent.startsWith(UTF8_BOM)) {
            rawContent.substring(1)
        } else {
            rawContent
        }

        val rows = mutableListOf<List<String>>()
        val currentRow = mutableListOf<String>()
        val currentCell = StringBuilder()
        var inQuotes = false
        var i = 0
        val len = cleanContent.length

        while (i < len) {
            val c = cleanContent[i]
            val nextC = if (i + 1 < len) cleanContent[i + 1] else '\u0000'

            if (inQuotes) {
                if (c == '"') {
                    if (nextC == '"') {
                        currentCell.append('"')
                        i++
                    } else {
                        inQuotes = false
                    }
                } else {
                    currentCell.append(c)
                }
            } else {
                when {
                    c == '"' -> {
                        inQuotes = true
                    }
                    c == delimiter -> {
                        currentRow.add(currentCell.toString())
                        currentCell.clear()
                    }
                    c == '\r' -> {
                        if (nextC == '\n') i++
                        currentRow.add(currentCell.toString())
                        currentCell.clear()
                        rows.add(currentRow.toList())
                        currentRow.clear()
                    }
                    c == '\n' -> {
                        currentRow.add(currentCell.toString())
                        currentCell.clear()
                        rows.add(currentRow.toList())
                        currentRow.clear()
                    }
                    else -> {
                        currentCell.append(c)
                    }
                }
            }
            i++
        }

        if (currentCell.isNotEmpty() || currentRow.isNotEmpty()) {
            currentRow.add(currentCell.toString())
            rows.add(currentRow.toList())
        }

        return rows.filter { row -> row.any { it.trim().isNotEmpty() } }
    }

    /**
     * Streaming RFC-4180 CSV parser that yields row-by-row lists of cells directly from a [java.io.Reader].
     * Supports multiline quoted cells, escaped quotes (""), and arbitrary line endings without loading
     * the entire file into heap memory.
     */
    fun parseStreamingRow(reader: java.io.Reader, delimiter: Char = ','): List<String>? {
        val currentRow = mutableListOf<String>()
        val currentCell = StringBuilder()
        var inQuotes = false
        var hasContent = false

        while (true) {
            val chInt = reader.read()
            if (chInt == -1) {
                break
            }
            val c = chInt.toChar()

            if (inQuotes) {
                if (c == '"') {
                    reader.mark(1)
                    val nextInt = reader.read()
                    if (nextInt != -1 && nextInt.toChar() == '"') {
                        currentCell.append('"')
                        hasContent = true
                    } else {
                        inQuotes = false
                        if (nextInt != -1) {
                            reader.reset()
                        }
                    }
                } else {
                    currentCell.append(c)
                    hasContent = true
                }
            } else {
                when (c) {
                    '"' -> {
                        inQuotes = true
                        hasContent = true
                    }
                    delimiter -> {
                        currentRow.add(currentCell.toString())
                        currentCell.clear()
                        hasContent = true
                    }
                    '\r' -> {
                        reader.mark(1)
                        val nextInt = reader.read()
                        if (nextInt != -1 && nextInt.toChar() != '\n') {
                            reader.reset()
                        }
                        currentRow.add(currentCell.toString())
                        return currentRow.toList()
                    }
                    '\n' -> {
                        currentRow.add(currentCell.toString())
                        return currentRow.toList()
                    }
                    else -> {
                        currentCell.append(c)
                        hasContent = true
                    }
                }
            }
        }

        if (hasContent || currentRow.isNotEmpty() || currentCell.isNotEmpty()) {
            currentRow.add(currentCell.toString())
            return currentRow.toList()
        }
        return null
    }

    /**
     * Sanitizes a single raw parsed CSV row using expected column repair and pipe option validation.
     */
    fun sanitizeStreamingRow(row: List<String>, expectedCols: Int, delimiter: Char = ','): List<String> {
        val merged = mergeSplitNumericCommas(row)
        val repaired = if (merged.size > expectedCols && expectedCols >= 2) {
            repairMalformedRow(merged, expectedCols, delimiter)
        } else {
            merged
        }
        return repaired.map { cell ->
            if (cell.contains('|')) sanitizeOptions(cell) else cell
        }
    }

    /**
     * Builds a single RFC-4180 compliant CSV line from a list of cell values.
     */
    fun buildCsvRow(vararg fields: Any?): String {
        return fields.joinToString(separator = ",") { quoteRfc4180(it?.toString()) }
    }

    /**
     * Writes a list of [QuestionEntity] objects to a topic-wise CSV file with UTF-8 BOM encoding.
     *
     * @param context Android Application Context
     * @param fileName Name of the target file (e.g., "economics.csv", "polity.csv")
     * @param questions List of questions to write
     * @return Output [File] object saved in `context.filesDir`
     */
    fun writeSubjectCsv(
        context: Context,
        fileName: String,
        questions: List<QuestionEntity>
    ): File {
        val targetFile = File(context.filesDir, fileName)
        FileOutputStream(targetFile).use { fos ->
            OutputStreamWriter(fos, StandardCharsets.UTF_8).use { writer ->
                // Write UTF-8 BOM header for universal spreadsheet compatibility
                writer.write(UTF8_BOM)

                // CSV Header Row (standard columns for flashcards / quiz shooting)
                val header = buildCsvRow(
                    "question",
                    "answer",
                    "option_a",
                    "option_b",
                    "option_c",
                    "option_d",
                    "explanation",
                    "subject",
                    "sub_topic",
                    "exam_tag",
                    "exam_name",
                    "exam_year"
                )
                writer.write(header)
                writer.write("\n")

                // CSV Data Rows
                for (q in questions) {
                    val row = buildCsvRow(
                        q.questionText,
                        q.correctAnswer,
                        q.optionA,
                        q.optionB,
                        q.optionC,
                        q.optionD,
                        q.explanation,
                        q.subject,
                        q.subTopic,
                        q.examRawTag,
                        q.examName,
                        if (q.examYear > 0) q.examYear else ""
                    )
                    writer.write(row)
                    writer.write("\n")
                }
                writer.flush()
            }
        }
        return targetFile
    }

    /**
     * Converts a list of [ScrapedCard] items into RFC-4180 compliant CSV string
     * with the standardized format: question,answer|option 1|option 2|option 3|explaination
     */
    fun exportScrapedCardsToCsv(cards: List<ScrapedCard>): String {
        val sb = StringBuilder()
        sb.append(UTF8_BOM)
        sb.append("question,answer|option 1|option 2|option 3|explaination\n")
        for (card in cards) {
            val answerText = card.answer.trim()
            val distractors = mutableListOf<String>()
            var foundAnswerInOptions = false
            for (opt in card.options) {
                val trimmedOpt = opt.trim()
                if (!foundAnswerInOptions && trimmedOpt.equals(answerText, ignoreCase = true)) {
                    foundAnswerInOptions = true
                } else if (trimmedOpt.isNotEmpty()) {
                    distractors.add(trimmedOpt)
                }
            }
            val optionsList = if (distractors.isNotEmpty()) distractors else card.options.map { it.trim() }.filter { it.isNotEmpty() }
            val parts = mutableListOf<String>()
            parts.add(answerText)
            parts.addAll(optionsList)
            if (card.explanation.isNotBlank()) {
                parts.add(card.explanation.trim())
            }
            val backColumn = parts.joinToString("|")
            val row = buildCsvRow(card.question.trim(), backColumn)
            sb.append(row).append("\n")
        }
        return sb.toString()
    }

    /**
     * Writes a list of [ScrapedCard] items directly to an [OutputStream] with UTF-8 BOM encoding.
     */
    fun writeScrapedCardsToStream(cards: List<ScrapedCard>, outputStream: OutputStream) {
        val csvData = exportScrapedCardsToCsv(cards)
        outputStream.write(csvData.toByteArray(StandardCharsets.UTF_8))
        outputStream.flush()
    }
}

