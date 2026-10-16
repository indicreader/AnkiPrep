package com.example.flashcardapp.data.sync

import android.content.Context
import com.example.flashcardapp.data.AppDatabase
import com.example.flashcardapp.data.core.CsvQuoteUtils
import com.example.flashcardapp.data.core.PyqMetadataExtractor
import com.example.flashcardapp.data.core.PyqTextNormalizer
import com.example.flashcardapp.data.entities.QuestionEntity
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.File
import java.io.InputStream
import java.io.InputStreamReader
import java.util.UUID

/**
 * Result data holder for PYQ Booklet Extraction process.
 */
data class PyqExtractionResult(
    val success: Boolean,
    val totalQuestionsExtracted: Int,
    val subjectFileMap: Map<String, File>,
    val errorMessage: String? = null
)

/**
 * High-Performance, Low-Memory PYQ PDF/Text Extraction Worker.
 *
 * Sequentially parses PYQ booklet text/streams (e.g. Rakesh Yadav GS 7300+), normalizes font encoding
 * artifacts, categorizes questions by Subject & Sub-Topic, generates topic-wise RFC-4180 CSV files,
 * and inserts records into the offline Room database.
 */
class PyqPdfParser(private val context: Context) {

    private val db = AppDatabase.getInstance(context)
    private val questionDao = db.questionDao()
    private val gson = Gson()

    /**
     * Parses a text stream page-by-page or block-by-block on [Dispatchers.IO].
     *
     * @param inputStream Stream containing the booklet text (or extracted PDF stream)
     * @param totalEstimatedPages Estimated total pages/blocks for progress tracking
     * @param onProgress Progress callback reporting `(processedPages, totalPages, status)`
     */
    suspend fun parseAndIngestStream(
        inputStream: InputStream,
        totalEstimatedPages: Int = 100,
        onProgress: (processedPages: Int, totalPages: Int, statusMessage: String) -> Unit = { _, _, _ -> }
    ): PyqExtractionResult = withContext(Dispatchers.IO) {
        try {
            onProgress(0, totalEstimatedPages, "Starting PDF/Text normalization...")

            val allExtractedQuestions = mutableListOf<QuestionEntity>()
            val subjectGroupedQuestions = mutableMapOf<String, MutableList<QuestionEntity>>()

            var currentSubject = "ECONOMICS"
            var currentSubTopic = "General"
            var pageCounter = 0

            val reader = BufferedReader(InputStreamReader(inputStream, Charsets.UTF_8))
            val textBuilder = StringBuilder()
            var line: String?

            while (reader.readLine().also { line = it } != null) {
                val currentLine = line ?: continue
                
                // Track simulated page breaks or header boundaries
                if (currentLine.contains("--- PAGE BREAK ---") || currentLine.contains("\u000C")) {
                    pageCounter++
                    if (pageCounter % 5 == 0) {
                        onProgress(
                            pageCounter,
                            totalEstimatedPages,
                            "Processing Page $pageCounter ($currentSubject - $currentSubTopic)"
                        )
                    }
                    continue
                }

                // Check for Subject Chapter changes
                val detectedSubject = PyqMetadataExtractor.detectSubject(currentLine)
                if (detectedSubject != null) {
                    currentSubject = detectedSubject
                    currentSubTopic = "General"
                } else if (PyqMetadataExtractor.isSubTopicHeader(currentLine)) {
                    currentSubTopic = PyqTextNormalizer.normalizeText(currentLine)
                }

                textBuilder.append(currentLine).append("\n")
            }

            // Normalize full text stream
            val normalizedFullText = PyqTextNormalizer.normalizeText(textBuilder.toString())

            // Parse questions from normalized text block
            val parsedQuestions = parseQuestionsFromText(normalizedFullText, currentSubject, currentSubTopic)
            allExtractedQuestions.addAll(parsedQuestions)

            onProgress(
                totalEstimatedPages / 2,
                totalEstimatedPages,
                "Extracted ${allExtractedQuestions.size} questions. Writing topic-wise CSV files..."
            )

            // Group questions by Subject
            for (q in allExtractedQuestions) {
                subjectGroupedQuestions.getOrPut(q.subject) { mutableListOf() }.add(q)
            }

            // Output RFC-4180 CSV files to context.filesDir
            val generatedFilesMap = mutableMapOf<String, File>()
            for ((subj, qList) in subjectGroupedQuestions) {
                val csvFileName = PyqMetadataExtractor.getCsvFileName(subj)
                val csvFile = CsvQuoteUtils.writeSubjectCsv(context, csvFileName, qList)
                generatedFilesMap[subj] = csvFile
            }

            onProgress(
                (totalEstimatedPages * 0.8f).toInt(),
                totalEstimatedPages,
                "Inserting questions into offline Room Database..."
            )

            // Batch insert into Room database
            questionDao.upsertQuestions(allExtractedQuestions)

            onProgress(
                totalEstimatedPages,
                totalEstimatedPages,
                "Complete! Extracted ${allExtractedQuestions.size} questions across ${generatedFilesMap.size} topics."
            )

            PyqExtractionResult(
                success = true,
                totalQuestionsExtracted = allExtractedQuestions.size,
                subjectFileMap = generatedFilesMap
            )
        } catch (e: Exception) {
            PyqExtractionResult(
                success = false,
                totalQuestionsExtracted = 0,
                subjectFileMap = emptyMap(),
                errorMessage = e.localizedMessage ?: "Unknown parsing error"
            )
        }
    }

    /**
     * Internal stateful block parser for extracting Q&A, options, answers, explanations, and exam tags.
     */
    private fun parseQuestionsFromText(
        normalizedText: String,
        initialSubject: String,
        initialSubTopic: String
    ): List<QuestionEntity> {
        val result = mutableListOf<QuestionEntity>()
        val lines = normalizedText.split("\n")

        var activeSubject = initialSubject
        var activeSubTopic = initialSubTopic

        var currentQuestionText = StringBuilder()
        var optA = ""
        var optB = ""
        var optC = ""
        var optD = ""
        var correctAnswer = "A"
        var explanationText = StringBuilder()
        var rawExamTag = ""

        var isCollectingQuestion = false
        var isCollectingExplanation = false
        var questionCounter = 1000

        fun flushCurrentQuestion() {
            val qText = PyqTextNormalizer.cleanQuestionStatement(currentQuestionText.toString())
            if (qText.isNotBlank()) {
                questionCounter++
                val examMeta = PyqMetadataExtractor.parseExamMetadata(rawExamTag.ifEmpty { qText })
                
                // Safe non-nullable defaults
                val safeId = "${activeSubject.take(3).uppercase()}_$questionCounter"
                val safeExplanation = PyqTextNormalizer.normalizeText(explanationText.toString()).ifEmpty { "NA" }
                val safeSubTopic = activeSubTopic.ifEmpty { "General" }
                val tagsList = listOf(activeSubject, safeSubTopic, examMeta.examName)

                val questionEntity = QuestionEntity(
                    id = safeId,
                    questionText = qText,
                    optionA = PyqTextNormalizer.cleanOptionText(optA).ifEmpty { "Option A" },
                    optionB = PyqTextNormalizer.cleanOptionText(optB).ifEmpty { "Option B" },
                    optionC = PyqTextNormalizer.cleanOptionText(optC).ifEmpty { "Option C" },
                    optionD = PyqTextNormalizer.cleanOptionText(optD).ifEmpty { "Option D" },
                    correctAnswer = correctAnswer,
                    explanation = safeExplanation,
                    subject = activeSubject,
                    subTopic = safeSubTopic,
                    examRawTag = examMeta.rawTag,
                    examName = examMeta.examName,
                    examYear = examMeta.year,
                    tagsJson = gson.toJson(tagsList)
                )

                result.add(questionEntity)
            }

            // Reset buffers
            currentQuestionText = StringBuilder()
            optA = ""
            optB = ""
            optC = ""
            optD = ""
            correctAnswer = "A"
            explanationText = StringBuilder()
            rawExamTag = ""
            isCollectingQuestion = false
            isCollectingExplanation = false
        }

        for (line in lines) {
            val trimmed = line.trim()
            if (trimmed.isEmpty()) continue

            // Subject Header check
            val subjMatch = PyqMetadataExtractor.detectSubject(trimmed)
            if (subjMatch != null) {
                if (isCollectingQuestion || currentQuestionText.isNotEmpty()) {
                    flushCurrentQuestion()
                }
                activeSubject = subjMatch
                activeSubTopic = "General"
                continue
            }

            // Sub-topic Header check
            if (PyqMetadataExtractor.isSubTopicHeader(trimmed)) {
                if (isCollectingQuestion || currentQuestionText.isNotEmpty()) {
                    flushCurrentQuestion()
                }
                activeSubTopic = trimmed
                continue
            }

            // Question Start detection (e.g., "1.", "101.", "Q1.", "\u0018.")
            val isQuestionStart = Regex("^(?:\\d{1,4}\\.|Q\\.?\\d+)\\s+").containsMatchIn(trimmed)
            if (isQuestionStart) {
                if (currentQuestionText.isNotEmpty()) {
                    flushCurrentQuestion()
                }
                isCollectingQuestion = true
                currentQuestionText.append(trimmed).append(" ")

                // Check if line contains exam tag [S.S.C ...]
                if (trimmed.contains("[")) {
                    rawExamTag = trimmed
                }
                continue
            }

            // Option detection: (a), (b), (c), (d) or (A), (B), (C), (D)
            val optAMatch = Regex("(?i)^(?:\\(a\\)|a[.):\\-])\\s+(.*)").find(trimmed)
            if (optAMatch != null) {
                isCollectingQuestion = false
                optA = optAMatch.groupValues[1]
                continue
            }

            val optBMatch = Regex("(?i)^(?:\\(b\\)|b[.):\\-])\\s+(.*)").find(trimmed)
            if (optBMatch != null) {
                optB = optBMatch.groupValues[1]
                continue
            }

            val optCMatch = Regex("(?i)^(?:\\(c\\)|c[.):\\-])\\s+(.*)").find(trimmed)
            if (optCMatch != null) {
                optC = optCMatch.groupValues[1]
                continue
            }

            val optDMatch = Regex("(?i)^(?:\\(d\\)|d[.):\\-])\\s+(.*)").find(trimmed)
            if (optDMatch != null) {
                optD = optDMatch.groupValues[1]
                continue
            }

            // Answer & Explanation detection: "Ans: (a)", "Ans. (b)", "Expl:- ..."
            val ansMatch = Regex("(?i)^(?:Ans|Answer)\\s*[:.]?\\s*\\(?([a-d])\\)?").find(trimmed)
            if (ansMatch != null) {
                correctAnswer = ansMatch.groupValues[1].uppercase()
                isCollectingExplanation = true
                val remaining = trimmed.substring(ansMatch.range.last + 1).trim()
                if (remaining.isNotEmpty()) {
                    explanationText.append(remaining).append(" ")
                }
                continue
            }

            val explMatch = Regex("(?i)^Expl(?:anation)?\\s*[:-]+\\s*(.*)").find(trimmed)
            if (explMatch != null) {
                isCollectingExplanation = true
                explanationText.append(explMatch.groupValues[1]).append(" ")
                continue
            }

            // Append lines based on active mode
            if (isCollectingExplanation) {
                explanationText.append(trimmed).append(" ")
            } else if (isCollectingQuestion) {
                currentQuestionText.append(trimmed).append(" ")
                if (trimmed.contains("[")) {
                    rawExamTag = trimmed
                }
            }
        }

        // Flush remaining question
        if (currentQuestionText.isNotEmpty()) {
            flushCurrentQuestion()
        }

        return result
    }
}
