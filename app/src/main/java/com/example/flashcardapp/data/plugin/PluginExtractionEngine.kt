package com.example.flashcardapp.data.plugin

import com.example.flashcardapp.data.dao.QuestionDao
import com.example.flashcardapp.data.entities.PluginEntity
import com.example.flashcardapp.data.entities.QuestionEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Extraction Engine bridging raw inputs (PDF/RSS/HTML text) -> QuickJS Engine -> Room DB.
 */
class PluginExtractionEngine(
    private val pluginRepository: PluginRepository,
    private val questionDao: QuestionDao
) {

    /**
     * Executes extraction using the given [plugin] and [rawInputString].
     * Saves resulting questions to Room DB (`pyq_questions` table) and returns the count.
     */
    suspend fun executeExtraction(
        plugin: PluginEntity,
        rawInputString: String
    ): Result<Int> = withContext(Dispatchers.IO) {
        runCatching {
            require(rawInputString.isNotBlank()) { "Input text for plugin extraction cannot be empty." }

            // 1. Run QuickJS sandboxed parsing
            val parsedQuestions = QuickJsEngine.parseQuestions(
                scriptContent = plugin.scriptContent,
                rawInput = rawInputString
            ).getOrThrow()

            if (parsedQuestions.isEmpty()) {
                return@runCatching 0
            }

            // 2. Map PluginParsedQuestion -> QuestionEntity
            val entities = parsedQuestions.mapIndexed { index, pq ->
                val validAns = when (pq.answer.trim().uppercase()) {
                    "A", "1" -> "A"
                    "B", "2" -> "B"
                    "C", "3" -> "C"
                    "D", "4" -> "D"
                    else -> "A"
                }

                QuestionEntity(
                    id = java.util.UUID.randomUUID().toString(),
                    questionText = pq.question.ifBlank { "Plugin Question #${index + 1}" },
                    optionA = pq.optionA.ifBlank { "Option A" },
                    optionB = pq.optionB.ifBlank { "Option B" },
                    optionC = pq.optionC.ifBlank { "Option C" },
                    optionD = pq.optionD.ifBlank { "Option D" },
                    correctAnswer = validAns,
                    explanation = pq.explanation.ifBlank { "Extracted via ${plugin.name}" },
                    subject = pq.topic.ifBlank { "Plugin Imports" },
                    subTopic = pq.subTopic.ifBlank { plugin.name },
                    examName = if (pq.examRawTag.isNotBlank()) pq.examRawTag else plugin.name,
                    examYear = 2026,
                    examRawTag = pq.examRawTag
                )
            }

            // 3. Batch insert into Room DB
            questionDao.upsertQuestions(entities)
            entities.size
        }
    }

    /**
     * Finds active plugins matching [inputType] and executes extraction.
     */
    suspend fun extractWithFirstAvailablePlugin(
        inputType: String,
        rawInputString: String
    ): Result<Int> = withContext(Dispatchers.IO) {
        runCatching {
            val enabledPlugins = pluginRepository.getEnabledPluginsForType(inputType)
            if (enabledPlugins.isEmpty()) {
                throw IllegalStateException("No active plugin installed for input type: $inputType")
            }
            val activePlugin = enabledPlugins.first()
            executeExtraction(activePlugin, rawInputString).getOrThrow()
        }
    }
}
