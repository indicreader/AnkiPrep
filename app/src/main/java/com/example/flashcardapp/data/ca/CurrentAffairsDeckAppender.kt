package com.example.flashcardapp.data.ca

import android.content.Context
import com.example.flashcardapp.data.AppDatabase
import com.example.flashcardapp.data.core.CsvQuoteUtils
import com.example.flashcardapp.data.entities.QuestionEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.nio.charset.StandardCharsets
import java.util.Calendar

/**
 * Utility class responsible for appending synthesized Current Affairs MCQs directly
 * to a persistent, year-stamped CSV deck (`context.filesDir/current_affairs_<YEAR>.csv`)
 * and bulk-inserting records into Room DB.
 */
object CurrentAffairsDeckAppender {

    private const val UTF8_BOM = "\uFEFF"

    /**
     * Appends [questions] to `current_affairs_<YEAR>.csv` and synchronizes them into Room DB.
     *
     * @param context Application Context
     * @param questions Synthesized MCQs to append
     * @return Output CSV [File] object
     */
    suspend fun appendQuestionsAndSyncDb(
        context: Context,
        questions: List<QuestionEntity>
    ): File = withContext(Dispatchers.IO) {
        val year = Calendar.getInstance().get(Calendar.YEAR)
        val fileName = "current_affairs_$year.csv"
        val targetFile = File(context.filesDir, fileName)
        val isNewFile = !targetFile.exists() || targetFile.length() == 0L

        if (questions.isNotEmpty()) {
            FileOutputStream(targetFile, true).use { fos ->
                OutputStreamWriter(fos, StandardCharsets.UTF_8).use { writer ->
                    if (isNewFile) {
                        // Prepend UTF-8 BOM header and standard 14-column header row
                        writer.write(UTF8_BOM)
                        val header = CsvQuoteUtils.buildCsvRow(
                            "id",
                            "subject",
                            "topic",
                            "sub_topic",
                            "question",
                            "option_a",
                            "option_b",
                            "option_c",
                            "option_d",
                            "answer",
                            "explanation",
                            "exam_name",
                            "exam_year",
                            "exam_raw_tag"
                        )
                        writer.write(header)
                        writer.write("\n")
                    }

                    for (q in questions) {
                        val row = CsvQuoteUtils.buildCsvRow(
                            q.id,
                            q.subject,
                            "Current Affairs",
                            q.subTopic,
                            q.questionText,
                            q.optionA,
                            q.optionB,
                            q.optionC,
                            q.optionD,
                            q.correctAnswer,
                            q.explanation,
                            q.examName,
                            q.examYear,
                            q.examRawTag
                        )
                        writer.write(row)
                        writer.write("\n")
                    }
                    writer.flush()
                }
            }

            // Room DB Synchronization inside Room's upsert transaction
            AppDatabase.getInstance(context).questionDao().upsertQuestions(questions)
        }

        targetFile
    }

    /**
     * Returns existing normalized question title keys already stored in Room or CSV
     * to prevent duplicating stories.
     */
    suspend fun getExistingQuestionKeys(context: Context): Set<String> = withContext(Dispatchers.IO) {
        val dbQuestions = AppDatabase.getInstance(context).questionDao().getQuestionsBySubjectOnce("Current Affairs")
        val keys = HashSet<String>()
        dbQuestions.forEach { q ->
            val extractTitle = extractTitleFromQuestion(q.questionText)
            val normKey = extractTitle.lowercase().replace(Regex("[^a-z0-9]"), "")
            if (normKey.isNotBlank()) {
                keys.add(normKey)
            }
        }
        keys
    }

    private fun extractTitleFromQuestion(qText: String): String {
        val startMarker = "headline: '"
        val endMarker = "'. Which"
        val startIndex = qText.indexOf(startMarker)
        val endIndex = qText.indexOf(endMarker)
        if (startIndex != -1 && endIndex > startIndex) {
            return qText.substring(startIndex + startMarker.length, endIndex)
        }
        return qText
    }
}
