package com.example.flashcardapp.data.updater

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.core.content.FileProvider
import com.example.flashcardapp.data.SettingsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream
import java.util.concurrent.TimeUnit

sealed class UpdateStatus {
    object Idle : UpdateStatus()
    object Checking : UpdateStatus()
    data class UpdateAvailable(
        val latestVersion: String,
        val releaseNotes: String,
        val downloadUrl: String,
        val apkFileName: String
    ) : UpdateStatus()
    object UpToDate : UpdateStatus()
    data class Downloading(val progressPercent: Int) : UpdateStatus()
    data class ReadyToInstall(val apkFile: File) : UpdateStatus()
    data class Error(val message: String) : UpdateStatus()
}

class AppUpdateManager(private val context: Context) {

    private val client = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .followRedirects(true)
        .build()

    companion object {
        const val GITHUB_REPO_API = "https://api.github.com/repos/indicreader/AnkiPrep/releases/latest"
    }

    fun getCurrentAppVersion(): Pair<String, Long> {
        return try {
            val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            val versionName = packageInfo.versionName ?: "1.0"
            val versionCode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                packageInfo.longVersionCode
            } else {
                @Suppress("DEPRECATION")
                packageInfo.versionCode.toLong()
            }
            Pair(versionName, versionCode)
        } catch (e: Exception) {
            Pair("5.12", 176L)
        }
    }

    suspend fun checkForUpdates(): UpdateStatus = withContext(Dispatchers.IO) {
        try {
            val request = Request.Builder()
                .url(GITHUB_REPO_API)
                .header("User-Agent", "AnkiPrep-AppUpdater")
                .header("Accept", "application/vnd.github.v3+json")
                .build()

            val response = client.newCall(request).execute()
            if (!response.isSuccessful) {
                return@withContext UpdateStatus.Error("Server returned code ${response.code}")
            }

            val body = response.body?.string() ?: return@withContext UpdateStatus.Error("Empty response")
            val json = JSONObject(body)

            val tagName = json.optString("tag_name", "").removePrefix("v").trim()
            val releaseNotes = json.optString("body", "Bug fixes and improvements.")
            val assets = json.optJSONArray("assets")

            var downloadUrl: String? = null
            var apkName = "AnkiPrep-Update.apk"

            if (assets != null) {
                for (i in 0 until assets.length()) {
                    val asset = assets.getJSONObject(i)
                    val name = asset.optString("name", "")
                    if (name.endsWith(".apk", ignoreCase = true)) {
                        downloadUrl = asset.optString("browser_download_url")
                        apkName = name
                        break
                    }
                }
            }

            if (downloadUrl.isNullOrBlank()) {
                return@withContext UpdateStatus.Error("No APK found in the latest release.")
            }

            val (currentName, currentCode) = getCurrentAppVersion()

            // Compare version names or tags
            val isNewer = isVersionNewer(remoteVersion = tagName, localVersion = currentName)
            if (isNewer) {
                UpdateStatus.UpdateAvailable(
                    latestVersion = tagName,
                    releaseNotes = releaseNotes,
                    downloadUrl = downloadUrl,
                    apkFileName = apkName
                )
            } else {
                UpdateStatus.UpToDate
            }
        } catch (e: Exception) {
            UpdateStatus.Error(e.localizedMessage ?: "Failed to connect to update server.")
        }
    }

    suspend fun downloadApk(
        downloadUrl: String,
        apkFileName: String,
        onProgress: (Int) -> Unit
    ): Result<File> = withContext(Dispatchers.IO) {
        runCatching {
            val request = Request.Builder()
                .url(downloadUrl)
                .header("User-Agent", "AnkiPrep-AppUpdater")
                .build()

            val response = client.newCall(request).execute()
            if (!response.isSuccessful) throw IllegalStateException("Download failed with code ${response.code}")

            val body = response.body ?: throw IllegalStateException("Empty download body")
            val totalBytes = body.contentLength()

            val cacheDir = context.externalCacheDir ?: context.cacheDir
            val updatesDir = File(cacheDir, "updates")
            if (!updatesDir.exists()) updatesDir.mkdirs()

            val destinationFile = File(updatesDir, apkFileName)
            if (destinationFile.exists()) destinationFile.delete()

            body.byteStream().use { inputStream ->
                FileOutputStream(destinationFile).use { outputStream ->
                    val buffer = ByteArray(8 * 1024)
                    var bytesRead: Int
                    var totalRead = 0L

                    while (inputStream.read(buffer).also { bytesRead = it } != -1) {
                        outputStream.write(buffer, 0, bytesRead)
                        totalRead += bytesRead
                        if (totalBytes > 0) {
                            val percent = ((totalRead * 100) / totalBytes).toInt().coerceIn(0, 100)
                            onProgress(percent)
                        }
                    }
                    outputStream.flush()
                }
            }
            destinationFile
        }
    }

    fun triggerInstall(apkFile: File) {
        val uri = FileProvider.getUriForFile(
            context,
            "${context.packageName}.provider",
            apkFile
        )

        val intent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(uri, "application/vnd.android.package-archive")
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_GRANT_READ_URI_PERMISSION
        }
        context.startActivity(intent)
    }

    private fun isVersionNewer(remoteVersion: String, localVersion: String): Boolean {
        if (remoteVersion.isBlank()) return false
        val cleanRemote = remoteVersion.removePrefix("v").trim()
        val cleanLocal = localVersion.removePrefix("v").trim()
        if (cleanRemote == cleanLocal) return false

        val remoteParts = cleanRemote.split(".").mapNotNull { it.toIntOrNull() }
        val localParts = cleanLocal.split(".").mapNotNull { it.toIntOrNull() }

        val maxLen = maxOf(remoteParts.size, localParts.size)
        for (i in 0 until maxLen) {
            val r = remoteParts.getOrElse(i) { 0 }
            val l = localParts.getOrElse(i) { 0 }
            if (r > l) return true
            if (r < l) return false
        }
        return false
    }
}

