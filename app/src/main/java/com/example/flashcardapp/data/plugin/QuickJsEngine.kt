package com.example.flashcardapp.data.plugin

import app.cash.quickjs.QuickJs
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout

/**
 * Sandboxed Native QuickJS Engine wrapper for executing untrusted JS plugin scripts.
 * Runs on Dispatchers.IO with a 10-second hard execution ceiling to prevent infinite loops.
 */
object QuickJsEngine {

    private val gson = Gson()
    private const val DEFAULT_TIMEOUT_MS = 10_000L

    /**
     * Executes the plugin script's `parse(input)` entrypoint with [rawInput].
     * Returns a parsed list of [PluginParsedQuestion] objects.
     */
    suspend fun parseQuestions(
        scriptContent: String,
        rawInput: String,
        timeoutMs: Long = DEFAULT_TIMEOUT_MS
    ): Result<List<PluginParsedQuestion>> = withContext(Dispatchers.IO) {
        runCatching {
            withTimeout(timeoutMs) {
                val quickJs = QuickJs.create()
                try {
                    // Evaluate the plugin script to define the parse(input) function
                    quickJs.evaluate(scriptContent)

                    // Execute parse(input) passing the raw input string
                    // We escape rawInput as a JSON string literal for safe JS parameter injection
                    val safeInputJson = gson.toJson(rawInput)
                    val runnerScript = """
                        (function() {
                            if (typeof parse !== 'function') {
                                throw new Error("Plugin script does not export a 'parse(input)' function.");
                            }
                            var rawInputStr = $safeInputJson;
                            var result = parse(rawInputStr);
                            if (typeof result === 'string') {
                                return result;
                            }
                            return JSON.stringify(result || []);
                        })();
                    """.trimIndent()

                    val jsonResult = quickJs.evaluate(runnerScript) as? String
                        ?: throw IllegalStateException("QuickJS returned null or empty result.")

                    val listType = object : TypeToken<List<PluginParsedQuestion>>() {}.type
                    val questions: List<PluginParsedQuestion> = gson.fromJson(jsonResult, listType) ?: emptyList()
                    questions
                } finally {
                    quickJs.close()
                }
            }
        }
    }

    /**
     * Validates that a plugin script compiles in QuickJS and contains a valid `parse(input)` function.
     */
    suspend fun validatePluginScript(
        scriptContent: String,
        timeoutMs: Long = 5_000L
    ): Result<Boolean> = withContext(Dispatchers.IO) {
        runCatching {
            withTimeout(timeoutMs) {
                val quickJs = QuickJs.create()
                try {
                    quickJs.evaluate(scriptContent)
                    val checkScript = "typeof parse === 'function';"
                    val isFunction = quickJs.evaluate(checkScript) as? Boolean ?: false
                    if (!isFunction) {
                        throw IllegalArgumentException("Script must contain a function named 'parse(input)'")
                    }
                    true
                } finally {
                    quickJs.close()
                }
            }
        }
    }
}
