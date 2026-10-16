package com.example.flashcardapp.data

import android.content.Context
import android.net.Uri
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.UUID

/**
 * Manages local storage of card images inside the app's internal files directory.
 */
object ImageStorageManager {
    private const val TAG = "ImageStorageManager"
    private const val IMAGES_DIR = "card_images"

    /**
     * Copies an image from a content/file [Uri] to the app's internal storage.
     *
     * @return The relative path of the stored file (e.g., "card_images/img_123.jpg") or null if failed.
     */
    fun copyImageToLocalStorage(context: Context, uri: Uri): String? {
        return try {
            val resolver = context.contentResolver
            val mimeType = resolver.getType(uri)
            val extension = when {
                mimeType?.contains("png") == true -> "png"
                mimeType?.contains("gif") == true -> "gif"
                mimeType?.contains("webp") == true -> "webp"
                else -> "jpg"
            }
            
            val dir = File(context.filesDir, IMAGES_DIR)
            if (!dir.exists()) {
                dir.mkdirs()
            }
            
            val filename = "img_${UUID.randomUUID()}.$extension"
            val targetFile = File(dir, filename)
            
            resolver.openInputStream(uri)?.use { input ->
                FileOutputStream(targetFile).use { output ->
                    input.copyTo(output)
                }
            }
            
            Log.d(TAG, "Copied image to local storage: ${targetFile.absolutePath}")
            "$IMAGES_DIR/$filename"
        } catch (e: Exception) {
            Log.e(TAG, "Failed to copy image to local storage: ${e.message}", e)
            null
        }
    }

    /**
     * Deletes a stored local image file.
     *
     * @param relativePath The relative path returned by [copyImageToLocalStorage].
     */
    fun deleteImageFromLocalStorage(context: Context, relativePath: String) {
        try {
            val file = File(context.filesDir, relativePath)
            if (file.exists() && file.isFile) {
                val deleted = file.delete()
                Log.d(TAG, "Deleted local image file: $relativePath (success: $deleted)")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to delete local image file $relativePath: ${e.message}", e)
        }
    }

    /**
     * Downloads an image from a remote [url] and saves it to the app's internal storage.
     *
     * @return The relative path of the stored file or null if failed.
     */
    fun downloadImageFromUrl(context: Context, url: String): String? {
        return try {
            val connection = URL(url).openConnection() as HttpURLConnection
            connection.connectTimeout = 10_000
            connection.readTimeout = 15_000
            connection.setRequestProperty("User-Agent", "Mozilla/5.0")
            connection.connect()

            val contentType = connection.contentType ?: "image/jpeg"
            val extension = when {
                contentType.contains("png") -> "png"
                contentType.contains("gif") -> "gif"
                contentType.contains("webp") -> "webp"
                else -> "jpg"
            }

            val dir = File(context.filesDir, IMAGES_DIR)
            if (!dir.exists()) dir.mkdirs()

            val filename = "img_${UUID.randomUUID()}.$extension"
            val targetFile = File(dir, filename)

            connection.inputStream.use { input ->
                FileOutputStream(targetFile).use { output ->
                    input.copyTo(output)
                }
            }
            connection.disconnect()

            Log.d(TAG, "Downloaded image from URL to: ${targetFile.absolutePath}")
            "$IMAGES_DIR/$filename"
        } catch (e: Exception) {
            Log.e(TAG, "Failed to download image from URL: ${e.message}", e)
            null
        }
    }

    /**
     * Resolves a relative path to the absolute [File] object.
     */
    fun getFullFile(context: Context, relativePath: String): File {
        return File(context.filesDir, relativePath)
    }

    /**
     * Resolves an image path, URL, file URI, content URI, or asset URI into an object usable by Coil/AsyncImage.
     */
    fun resolveImageModel(context: Context, imagePath: String?): Any? {
        if (imagePath.isNullOrBlank()) return null
        val trimmed = imagePath.trim()
        return when {
            trimmed.startsWith("http://", ignoreCase = true) || trimmed.startsWith("https://", ignoreCase = true) -> trimmed
            trimmed.startsWith("content://", ignoreCase = true) -> Uri.parse(trimmed)
            trimmed.startsWith("file:///android_asset/", ignoreCase = true) -> Uri.parse(trimmed)
            trimmed.startsWith("file://", ignoreCase = true) -> {
                val parsed = Uri.parse(trimmed)
                val file = parsed.path?.let { File(it) } ?: File(trimmed.removePrefix("file://"))
                if (file.exists() && file.isFile && file.length() > 0) file else null
            }
            trimmed.startsWith("/") -> {
                val file = File(trimmed)
                if (file.exists() && file.isFile && file.length() > 0) file else null
            }
            else -> {
                val file = File(context.filesDir, trimmed)
                if (file.exists() && file.isFile && file.length() > 0) file else null
            }
        }
    }

    /**
     * Extracts image source URIs/paths from Markdown `![alt](src)` and HTML `<img src="src">` tags.
     */
    fun extractEmbeddedImageSources(text: String): List<String> {
        if (text.isBlank()) return emptyList()
        val sources = mutableListOf<String>()

        val htmlRegex = Regex("""<img[^>]+src=["']([^"']+)["']""", RegexOption.IGNORE_CASE)
        htmlRegex.findAll(text).forEach { match ->
            sources.add(match.groupValues[1])
        }

        val mdRegex = Regex("""!\[.*?\]\((.*?)\)""")
        mdRegex.findAll(text).forEach { match ->
            sources.add(match.groupValues[1])
        }

        return sources.distinct()
    }

    /**
     * Cleans Markdown/HTML image tags from text to allow pure text rendering without broken raw tags.
     */
    fun cleanImageTagsFromText(text: String): String {
        var clean = text.replace(Regex("""<img[^>]*>""", RegexOption.IGNORE_CASE), "")
        clean = clean.replace(Regex("""!\[.*?\]\(.*?\)"""), "")
        return clean.trim()
    }
}
