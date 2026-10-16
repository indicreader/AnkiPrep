package com.example.flashcardapp.data.plugin

import com.google.gson.Gson
import java.util.Locale

object PluginManifestParser {

    private val gson = Gson()

    /**
     * Extracts `@manifest` JSON block from plugin script comments.
     */
    fun parseManifest(script: String, fallbackIdHint: String = "plugin_custom"): PluginManifest {
        try {
            // Find @manifest tag
            val manifestIndex = script.indexOf("@manifest")
            if (manifestIndex != -1) {
                // Search for starting '{' after @manifest
                val startBrace = script.indexOf('{', manifestIndex)
                if (startBrace != -1) {
                    var openBraces = 0
                    var endBrace = -1
                    for (i in startBrace until script.length) {
                        val char = script[i]
                        if (char == '{') openBraces++
                        else if (char == '}') {
                            openBraces--
                            if (openBraces == 0) {
                                endBrace = i
                                break
                            }
                        }
                    }

                    if (endBrace != -1) {
                        val jsonSub = script.substring(startBrace, endBrace + 1)
                            .lines()
                            .joinToString("\n") { line ->
                                line.replace(Regex("^\\s*\\*\\s?"), "") // Remove leading JSDoc asterisks
                            }
                        val manifest = gson.fromJson(jsonSub, PluginManifest::class.java)
                        if (manifest != null && manifest.id.isNotBlank()) {
                            return sanitizeManifest(manifest)
                        }
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        // Fallback if no @manifest present or parsing failed
        val sanitizedId = fallbackIdHint
            .lowercase(Locale.ROOT)
            .replace(Regex("[^a-z0-9_]"), "_")
            .trim('_')
            .ifBlank { "plugin_${System.currentTimeMillis()}" }

        return PluginManifest(
            id = sanitizedId,
            name = sanitizedId.replace('_', ' ').split(" ").joinToString(" ") { it.replaceFirstChar { c -> c.uppercase() } },
            version = "1.0.0",
            author = "Local User",
            inputType = "TEXT_PDF",
            description = "Custom JS Question Extractor Plugin"
        )
    }

    private fun sanitizeManifest(manifest: PluginManifest): PluginManifest {
        val cleanId = manifest.id
            .lowercase(Locale.ROOT)
            .replace(Regex("[^a-z0-9_]"), "_")
            .trim('_')
            .ifBlank { "plugin_${System.currentTimeMillis()}" }

        val normalizedInputType = when (manifest.inputType.uppercase(Locale.ROOT)) {
            "RSS_ATOM", "RSS", "ATOM" -> "RSS_ATOM"
            "HTML_SCRAPE", "HTML", "WEB" -> "HTML_SCRAPE"
            else -> "TEXT_PDF"
        }

        return manifest.copy(
            id = cleanId,
            name = manifest.name.ifBlank { cleanId },
            inputType = normalizedInputType
        )
    }
}
