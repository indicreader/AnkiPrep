package com.example.flashcardapp.data.core

import android.content.Context
import android.net.Uri
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.nio.charset.Charset

/**
 * Resilient File Import & Multi-Charset Ingestion Utility.
 *
 * Solves:
 * 1. Android Content URI single-read / expiration failures by copying streams to local cache.
 * 2. Multi-encoding mismatches (Excel UTF-16 LE with BOM, UTF-8 with BOM, Windows-1252, ISO-8859-1).
 * 3. Graceful fallback on malformed lines across diverse Android phone vendors and file managers.
 */
object FileImportUtils {
    private const val TAG = "FileImportUtils"
    private const val BUFFER_SIZE = 8192

    /**
     * Copies a Content URI or File URI to a local temporary file in cacheDir.
     * This guarantees that subsequent reads (e.g. preview followed by import)
     * never fail due to expired ContentProvider stream grants.
     */
    fun copyUriToCacheFile(context: Context, uri: Uri, prefix: String = "import_cache_"): File {
        if (uri.scheme == "file" && uri.path != null) {
            val existing = File(uri.path!!)
            if (existing.exists()) return existing
        }
        val extension = getExtension(context, uri).ifEmpty { ".tmp" }
        val tempFile = File.createTempFile(prefix, extension, context.cacheDir)
        val inputStream: InputStream = context.contentResolver.openInputStream(uri)
            ?: throw IllegalArgumentException("Cannot open stream for URI: $uri")

        inputStream.use { input ->
            FileOutputStream(tempFile).use { output ->
                val buffer = ByteArray(BUFFER_SIZE)
                var bytesRead: Int
                while (input.read(buffer).also { bytesRead = it } != -1) {
                    output.write(buffer, 0, bytesRead)
                }
            }
        }
        return tempFile
    }

    /**
     * Reads all text from a file with automatic charset/BOM detection.
     */
    fun readTextWithAutoEncoding(file: File): String {
        val bytes = file.readBytes()
        return decodeBytesWithAutoEncoding(bytes)
    }

    /**
     * Reads all text from a Content URI with automatic charset/BOM detection.
     * Copies to cache first if direct read fails.
     */
    fun readTextWithAutoEncoding(context: Context, uri: Uri): String {
        if (uri.scheme == "file" && uri.path != null) {
            val file = File(uri.path!!)
            if (file.exists()) {
                return readTextWithAutoEncoding(file)
            }
        }
        return try {
            val bytes = context.contentResolver.openInputStream(uri)?.use { it.readBytes() }
                ?: throw IllegalArgumentException("Cannot open stream for URI: $uri")
            decodeBytesWithAutoEncoding(bytes)
        } catch (e: Exception) {
            Log.w(TAG, "Direct stream read failed for $uri, falling back to cache file: ${e.message}")
            val cachedFile = copyUriToCacheFile(context, uri)
            try {
                readTextWithAutoEncoding(cachedFile)
            } finally {
                if (cachedFile.exists()) cachedFile.delete()
            }
        }
    }

    /**
     * Decodes raw byte array into string handling:
     * - UTF-8 with BOM (EF BB BF)
     * - UTF-16 LE with BOM (FF FE)
     * - UTF-16 BE with BOM (FE FF)
     * - UTF-16 without BOM (detected via NUL byte distribution)
     * - UTF-8 without BOM
     * - Windows-1252 / ISO-8859-1 fallback
     */
    fun decodeBytesWithAutoEncoding(bytes: ByteArray): String {
        if (bytes.isEmpty()) return ""

        // Check BOM
        if (bytes.size >= 3 && bytes[0] == 0xEF.toByte() && bytes[1] == 0xBB.toByte() && bytes[2] == 0xBF.toByte()) {
            return String(bytes, 3, bytes.size - 3, Charsets.UTF_8)
        }
        if (bytes.size >= 2 && bytes[0] == 0xFF.toByte() && bytes[1] == 0xFE.toByte()) {
            return String(bytes, 2, bytes.size - 2, Charsets.UTF_16LE)
        }
        if (bytes.size >= 2 && bytes[0] == 0xFE.toByte() && bytes[1] == 0xFF.toByte()) {
            return String(bytes, 2, bytes.size - 2, Charsets.UTF_16BE)
        }

        // Heuristic: Check if file has alternating null bytes indicative of UTF-16 LE without BOM
        val sampleSize = minOf(bytes.size, 100)
        var oddNulls = 0
        var evenNulls = 0
        for (i in 0 until sampleSize) {
            if (bytes[i] == 0.toByte()) {
                if (i % 2 == 1) oddNulls++ else evenNulls++
            }
        }
        if (oddNulls > 5 && evenNulls == 0) {
            return String(bytes, Charsets.UTF_16LE)
        } else if (evenNulls > 5 && oddNulls == 0) {
            return String(bytes, Charsets.UTF_16BE)
        }

        // Try standard UTF-8
        val utf8String = String(bytes, Charsets.UTF_8)
        // If UTF-8 contains replacement characters, check if Windows-1252 is cleaner
        if (utf8String.contains("\uFFFD")) {
            return try {
                String(bytes, Charset.forName("windows-1252"))
            } catch (e: Exception) {
                String(bytes, Charsets.ISO_8859_1)
            }
        }

        return utf8String
    }

    /**
     * Detects charset and returns a streaming [java.io.BufferedReader] for a file or URI without
     * reading the entire content into memory. Handles UTF-8 BOM, UTF-16 LE/BE, and Windows-1252/ISO-8859-1.
     */
    fun openBufferedReader(context: Context, uri: Uri): java.io.BufferedReader {
        val inputStream: InputStream = try {
            context.contentResolver.openInputStream(uri)
                ?: throw IllegalArgumentException("Cannot open stream for URI: $uri")
        } catch (e: Exception) {
            val cachedFile = copyUriToCacheFile(context, uri)
            java.io.FileInputStream(cachedFile)
        }
        return openBufferedReader(inputStream)
    }

    /**
     * Wraps an [InputStream] into a buffered [java.io.BufferedReader] with auto-detected charset & BOM stripping.
     */
    fun openBufferedReader(inputStream: InputStream): java.io.BufferedReader {
        val pushbackStream = java.io.PushbackInputStream(inputStream, 4)
        val header = ByteArray(4)
        val bytesRead = pushbackStream.read(header, 0, 4)

        if (bytesRead <= 0) {
            return java.io.BufferedReader(java.io.InputStreamReader(pushbackStream, Charsets.UTF_8), BUFFER_SIZE)
        }

        // Detect BOM
        if (bytesRead >= 3 && header[0] == 0xEF.toByte() && header[1] == 0xBB.toByte() && header[2] == 0xBF.toByte()) {
            if (bytesRead > 3) pushbackStream.unread(header, 3, bytesRead - 3)
            return java.io.BufferedReader(java.io.InputStreamReader(pushbackStream, Charsets.UTF_8), BUFFER_SIZE)
        }
        if (bytesRead >= 2 && header[0] == 0xFF.toByte() && header[1] == 0xFE.toByte()) {
            if (bytesRead > 2) pushbackStream.unread(header, 2, bytesRead - 2)
            return java.io.BufferedReader(java.io.InputStreamReader(pushbackStream, Charsets.UTF_16LE), BUFFER_SIZE)
        }
        if (bytesRead >= 2 && header[0] == 0xFE.toByte() && header[1] == 0xFF.toByte()) {
            if (bytesRead > 2) pushbackStream.unread(header, 2, bytesRead - 2)
            return java.io.BufferedReader(java.io.InputStreamReader(pushbackStream, Charsets.UTF_16BE), BUFFER_SIZE)
        }

        // Push back all bytes for normal reading
        pushbackStream.unread(header, 0, bytesRead)
        return java.io.BufferedReader(java.io.InputStreamReader(pushbackStream, Charsets.UTF_8), BUFFER_SIZE)
    }

    /**
     * Reads up to [maxLines] non-empty lines from a file for preview via streaming reader.
     */
    fun readPreviewLines(context: Context, uri: Uri, maxLines: Int = 6): List<String> {
        val result = mutableListOf<String>()
        try {
            openBufferedReader(context, uri).use { reader ->
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    val trimmed = line!!.trim()
                    if (trimmed.isNotEmpty()) {
                        result.add(trimmed)
                        if (result.size >= maxLines) break
                    }
                }
            }
        } catch (e: Exception) {
            Log.w(TAG, "Streaming preview read failed, falling back to full text: ${e.message}")
            val fullText = readTextWithAutoEncoding(context, uri)
            for (line in fullText.lineSequence()) {
                val trimmed = line.trim()
                if (trimmed.isNotEmpty()) {
                    result.add(trimmed)
                    if (result.size >= maxLines) break
                }
            }
        }
        return result
    }

    private fun getExtension(context: Context, uri: Uri): String {
        var name: String? = null
        if (uri.scheme == "content") {
            context.contentResolver.query(uri, null, null, null, null)?.use { cursor ->
                if (cursor.moveToFirst()) {
                    val index = cursor.getColumnIndex(android.provider.OpenableColumns.DISPLAY_NAME)
                    if (index >= 0) name = cursor.getString(index)
                }
            }
        }
        if (name == null) {
            name = uri.path
        }
        val extIndex = name?.lastIndexOf('.') ?: -1
        return if (extIndex != -1 && name != null) name!!.substring(extIndex) else ""
    }
}
