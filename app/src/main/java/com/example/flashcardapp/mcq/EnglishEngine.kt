package com.example.flashcardapp.mcq

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

data class EnglishQuestion(
    val conceptId: String,
    val type: String,
    val wordOrSentence: String,
    val correctAnswer: String,
    val meaning: String,
    val associatedWords: String
)

class EnglishDatabaseHelper(private val context: Context) : 
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        private const val DB_NAME = "aliases_english.db"
        private const val DB_VERSION = 1
    }

    private val dbPath: String = context.getDatabasePath(DB_NAME).absolutePath

    init {
        copyDatabaseIfNotExist()
    }

    private fun copyDatabaseIfNotExist() {
        val dbFile = File(dbPath)
        if (!dbFile.exists()) {
            dbFile.parentFile?.mkdirs()
            try {
                context.assets.open("databases/$DB_NAME").use { inputStream ->
                    FileOutputStream(dbFile).use { outputStream ->
                        val buffer = ByteArray(1024)
                        var length: Int
                        while (inputStream.read(buffer).also { length = it } > 0) {
                            outputStream.write(buffer, 0, length)
                        }
                    }
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {}
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}
}

class EnglishEngine(private val dbHelper: EnglishDatabaseHelper) {

    private fun getDailyDoseQuestions(limit: Int): List<EnglishQuestion> {
        val db = dbHelper.readableDatabase
        val questions = mutableListOf<EnglishQuestion>()
        val types = listOf("synonym", "antonym", "substitute")
        val limitPerType = limit / 3
        val remainder = limit % 3

        types.forEachIndexed { index, type ->
            val currentLimit = limitPerType + if (index < remainder) 1 else 0
            if (currentLimit > 0) {
                val cursor = db.rawQuery(
                    "SELECT * FROM english_dictionary WHERE type = ? ORDER BY RANDOM() LIMIT ?",
                    arrayOf(type, currentLimit.toString())
                )
                while (cursor.moveToNext()) {
                    questions.add(
                        EnglishQuestion(
                            conceptId = cursor.getString(cursor.getColumnIndexOrThrow("concept_id")),
                            type = cursor.getString(cursor.getColumnIndexOrThrow("type")),
                            wordOrSentence = cursor.getString(cursor.getColumnIndexOrThrow("word_or_sentence")),
                            correctAnswer = cursor.getString(cursor.getColumnIndexOrThrow("correct_answer")),
                            meaning = cursor.getString(cursor.getColumnIndexOrThrow("meaning")),
                            associatedWords = cursor.getString(cursor.getColumnIndexOrThrow("associated_words")) ?: ""
                        )
                    )
                }
                cursor.close()
            }
        }
        return questions.shuffled()
    }

    private fun generateMcqOptions(targetRow: EnglishQuestion): List<String> {
        val db = dbHelper.readableDatabase
        val associated = targetRow.associatedWords
        val bannedList = associated.split("|").map { it.trim() }.filter { it.isNotEmpty() }.toMutableList()
        bannedList.add(targetRow.correctAnswer)
        val distinctBanned = bannedList.distinct()

        val placeholders = distinctBanned.joinToString(",") { "?" }
        val query = "SELECT correct_answer FROM english_dictionary WHERE type = ? AND correct_answer NOT IN ($placeholders) ORDER BY RANDOM() LIMIT 3"
        
        val args = arrayOf(targetRow.type) + distinctBanned.toTypedArray()
        val cursor = db.rawQuery(query, args)
        
        val distractors = mutableListOf<String>()
        while (cursor.moveToNext()) {
            distractors.add(cursor.getString(cursor.getColumnIndexOrThrow("correct_answer")))
        }
        cursor.close()

        while (distractors.size < 3) {
            distractors.add("Fallback Option ${distractors.size + 1}")
        }

        val finalOptions = distractors + targetRow.correctAnswer
        return finalOptions.shuffled()
    }

    private fun buildDynamicExplanation(optionsList: List<String>): Map<String, String> {
        if (optionsList.isEmpty()) return emptyMap()
        
        val db = dbHelper.readableDatabase
        val placeholders = optionsList.joinToString(",") { "?" }
        val query = "SELECT correct_answer, meaning FROM english_dictionary WHERE correct_answer IN ($placeholders)"
        
        val cursor = db.rawQuery(query, optionsList.toTypedArray())
        val explanationMap = mutableMapOf<String, String>()
        
        while (cursor.moveToNext()) {
            val correctAns = cursor.getString(cursor.getColumnIndexOrThrow("correct_answer"))
            val meaning = cursor.getString(cursor.getColumnIndexOrThrow("meaning"))
            explanationMap[correctAns] = meaning
        }
        cursor.close()

        for (opt in optionsList) {
            if (!explanationMap.containsKey(opt)) {
                explanationMap[opt] = "Meaning not found in database."
            }
        }
        return explanationMap
    }

    fun generateQuiz(limit: Int): List<Mcq> {
        val questions = getDailyDoseQuestions(limit)
        return questions.mapIndexed { index, q ->
            val options = generateMcqOptions(q)
            val explanationMap = buildDynamicExplanation(options)
            
            val formattedExplanation = buildString {
                append("Meanings:\n")
                options.forEach { opt ->
                    append("• $opt: ${explanationMap[opt]}\n")
                }
            }
            
            val questionPrefix = when (q.type) {
                "synonym" -> "What is a synonym for: "
                "antonym" -> "What is an antonym for: "
                "substitute" -> "What word means: "
                else -> ""
            }

            Mcq(
                question = "$questionPrefix${q.wordOrSentence}",
                options = options,
                correctIndex = options.indexOf(q.correctAnswer),
                sourceCardId = index.toLong(),
                distractorSourceIds = listOf(-1L, -1L, -1L),
                deckHierarchy = "English Daily Dose",
                explanation = formattedExplanation.trim(),
                difficulty = "medium",
                answerType = q.type
            )
        }
    }
}
