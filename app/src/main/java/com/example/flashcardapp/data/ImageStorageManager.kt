package com.example.flashcardapp.data

import android.content.Context
import android.net.Uri
import android.util.Log
import java.io.File
import java.io.FileOutputStream
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
     * Resolves a relative path to the absolute [File] object.
     */
    fun getFullFile(context: Context, relativePath: String): File {
        return File(context.filesDir, relativePath)
    }
}
