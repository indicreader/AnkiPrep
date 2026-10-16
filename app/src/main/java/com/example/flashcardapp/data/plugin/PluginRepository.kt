package com.example.flashcardapp.data.plugin

import android.content.Context
import android.net.Uri
import com.example.flashcardapp.data.dao.PluginDao
import com.example.flashcardapp.data.entities.PluginEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.concurrent.TimeUnit

class PluginRepository(
    private val pluginDao: PluginDao
) {
    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .followRedirects(true)
        .build()

    fun observeAllPlugins(): Flow<List<PluginEntity>> = pluginDao.observeAllPlugins()

    suspend fun getAllPluginsSync(): List<PluginEntity> = pluginDao.getAllPluginsSync()

    suspend fun getEnabledPluginsForType(inputType: String): List<PluginEntity> =
        pluginDao.getEnabledPluginsForType(inputType)

    /**
     * Validates and installs a plugin JS script into the database.
     */
    suspend fun installPluginFromScript(
        scriptContent: String,
        fallbackNameHint: String = "custom_plugin.js"
    ): Result<PluginEntity> = withContext(Dispatchers.IO) {
        runCatching {
            require(scriptContent.isNotBlank()) { "Plugin script content cannot be empty." }

            // 1. Validate script execution in QuickJS sandbox
            QuickJsEngine.validatePluginScript(scriptContent).getOrThrow()

            // 2. Parse JSDoc @manifest
            val manifest = PluginManifestParser.parseManifest(scriptContent, fallbackNameHint)

            // 3. Construct Plugin Entity
            val entity = PluginEntity(
                id = manifest.id,
                name = manifest.name,
                version = manifest.version,
                author = manifest.author,
                inputType = manifest.inputType,
                description = manifest.description,
                scriptContent = scriptContent,
                isEnabled = true,
                installedAt = System.currentTimeMillis()
            )

            // 4. Save to Room DB
            pluginDao.upsertPlugin(entity)
            entity
        }
    }

    /**
     * Downloads a JS script from a remote URL (e.g. GitHub raw file / Gist) and installs it.
     */
    suspend fun installPluginFromUrl(url: String): Result<PluginEntity> = withContext(Dispatchers.IO) {
        runCatching {
            require(url.startsWith("http://") || url.startsWith("https://")) {
                "URL must start with http:// or https://"
            }

            val request = Request.Builder()
                .url(url)
                .header("User-Agent", "AnkiPrep-Android-PluginManager/1.0")
                .build()

            val response = okHttpClient.newCall(request).execute()
            if (!response.isSuccessful) {
                throw IllegalStateException("Failed to download plugin (HTTP ${response.code})")
            }

            val scriptText = response.body?.string()
                ?: throw IllegalStateException("Received empty body from plugin URL")

            val urlFilename = url.substringAfterLast('/').substringBefore('?')
            installPluginFromScript(scriptText, fallbackNameHint = urlFilename).getOrThrow()
        }
    }

    /**
     * Reads a JS script from a local Uri (e.g. storage file picker) and installs it.
     */
    suspend fun installPluginFromUri(context: Context, uri: Uri): Result<PluginEntity> = withContext(Dispatchers.IO) {
        runCatching {
            val contentResolver = context.contentResolver
            val scriptText = contentResolver.openInputStream(uri)?.use { inputStream ->
                BufferedReader(InputStreamReader(inputStream)).readText()
            } ?: throw IllegalStateException("Could not open file stream for $uri")

            val uriName = uri.lastPathSegment?.substringAfterLast('/') ?: "imported_plugin.js"
            installPluginFromScript(scriptText, fallbackNameHint = uriName).getOrThrow()
        }
    }

    suspend fun togglePluginEnabled(id: String, isEnabled: Boolean) {
        pluginDao.updateEnabledStatus(id, isEnabled)
    }

    suspend fun deletePlugin(id: String) {
        pluginDao.deletePluginById(id)
    }

    /**
     * Seeds preset community plugins if zero plugins are currently installed.
     */
    suspend fun seedPresetPluginsIfEmpty() = withContext(Dispatchers.IO) {
        val existing = pluginDao.getAllPluginsSync()
        if (existing.isEmpty()) {
            PluginPresetTemplates.allPresets.forEach { preset ->
                installPluginFromScript(preset.scriptContent, preset.id)
            }
        }
    }
}
