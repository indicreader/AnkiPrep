package com.example.flashcardapp.data

import android.content.Context
import android.net.Uri
import android.util.Log
import com.example.flashcardapp.data.entities.DeckEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.util.zip.ZipInputStream

/**
 * Importer for ZIP archives containing multiple CSV files (Chapters) and media assets.
 * Creates a parent deck ("Book") and subdecks ("Chapters") under Book::Chapter hierarchy.
 */
object ZipImporter {
    private const val TAG = "ZipImporter"

    suspend fun importZip(
        context: Context,
        uri: Uri,
        targetDeckId: Long? = null,
        targetDeckName: String? = null,
        duplicateStrategy: String = "UPDATE", // "SKIP", "IMPORT", "UPDATE"
        columnMapping: Map<Int, String>? = null
    ): ImportResult = withContext(Dispatchers.IO) {
        val fileName = getFileName(context, uri)
        val appDb = AppDatabase.getInstance(context)

        val bookName = targetDeckName?.trim()?.ifEmpty { null }
            ?: fileName.removeSuffix(".zip").removeSuffix(".ZIP").trim()
                .ifEmpty { "Imported Book" }

        val bookDeckId = targetDeckId ?: kotlin.math.abs(bookName.hashCode().toLong() xor System.currentTimeMillis())

        Log.i(TAG, "Starting ZIP Book Import: '$bookName' (id=$bookDeckId) from $fileName")

        // 1. Ensure parent "Book" deck entity exists
        var parentDeck = appDb.deckDao().getAllDecksOnce().find { it.fullPath == bookName || it.id == bookDeckId }
        if (parentDeck == null) {
            parentDeck = DeckEntity(
                id = bookDeckId,
                name = bookName,
                fullPath = bookName,
                parentDeckId = null,
                cardCount = 0
            )
            appDb.deckDao().insertDecksIgnore(listOf(parentDeck))
        }

        val csvEntries = mutableListOf<Pair<String, String>>() // <ChapterName, RawCsvText>
        var totalNotesCount = 0
        var totalCardsCount = 0
        var totalDecksCount = 0

        try {
            val inputStream = context.contentResolver.openInputStream(uri)
                ?: return@withContext ImportResult(
                    success = false,
                    fileName = fileName,
                    totalDecks = 0,
                    totalNotes = 0,
                    totalCards = 0,
                    error = "Cannot open ZIP URI: $uri"
                )

            ZipInputStream(inputStream).use { zis ->
                var entry = zis.nextEntry
                while (entry != null) {
                    val entryName = entry.name
                    val cleanName = entryName.replace('\\', '/').trim()

                    if (!entry.isDirectory && !cleanName.startsWith("__MACOSX") && !cleanName.startsWith(".") && !cleanName.contains("/.")) {
                        val lowerName = cleanName.lowercase()
                        val simpleFileName = cleanName.substringAfterLast('/')
                        
                        // Extract relative path inside zip, ignoring top-level folder if it matches bookName
                        val relativePath = if (cleanName.startsWith("$bookName/", ignoreCase = true)) {
                            cleanName.substring(bookName.length + 1)
                        } else {
                            cleanName
                        }

                        if (lowerName.endsWith(".csv") || lowerName.endsWith(".txt")) {
                            val bytes = zis.readBytes()
                            val csvText = com.example.flashcardapp.data.core.FileImportUtils.decodeBytesWithAutoEncoding(bytes)
                            val relativeNoExt = relativePath.substringBeforeLast('.')
                            val chapterHierarchy = relativeNoExt.replace("/", "::")
                            if (csvText.isNotBlank() && chapterHierarchy.isNotEmpty()) {
                                csvEntries.add(Pair(chapterHierarchy, csvText))
                            }
                        } else if (isMediaFile(lowerName)) {
                            try {
                                saveMediaFile(context, simpleFileName, zis)
                            } catch (e: Exception) {
                                Log.w(TAG, "Failed to save media file '$simpleFileName': ${e.message}")
                            }
                        }
                    }
                    entry = zis.nextEntry
                }
            }

            if (csvEntries.isEmpty()) {
                return@withContext ImportResult(
                    success = false,
                    fileName = fileName,
                    totalDecks = 0,
                    totalNotes = 0,
                    totalCards = 0,
                    error = "No valid .csv or .txt files found inside ZIP archive '$fileName'"
                )
            }

            // Sort CSV entries by filename for consistent chapter order
            csvEntries.sortBy { it.first }

            // 2. Process each CSV chapter file as a subdeck under Book
            for ((index, entryPair) in csvEntries.withIndex()) {
                val chapterPath = entryPair.first
                val csvText = entryPair.second
                val fullSubdeckPath = if (chapterPath.startsWith(bookName)) chapterPath else "$bookName::$chapterPath"
                val subdeckId = kotlin.math.abs(fullSubdeckPath.hashCode().toLong() xor (bookDeckId shl 16) xor index.toLong())

                val result = CsvImporter.importCsvString(
                    context = context,
                    rawContent = csvText,
                    fileName = "${chapterPath.substringAfterLast("::")}.csv",
                    targetDeckId = subdeckId,
                    targetDeckName = fullSubdeckPath,
                    parentDeckId = bookDeckId,
                    parentDeckName = bookName,
                    duplicateStrategy = duplicateStrategy,
                    columnMapping = columnMapping
                )

                if (result.success) {
                    totalDecksCount++
                    totalNotesCount += result.totalNotes
                    totalCardsCount += result.totalCards
                }
            }

            // Recalculate card counts for parent and subdecks
            val allDecks = appDb.deckDao().getAllDecksOnce()
            for (deck in allDecks) {
                val count = appDb.cardDao().getCardsForDeckOnce(deck.id).size
                appDb.deckDao().updateDeck(deck.copy(cardCount = count))
            }

            Log.i(TAG, "ZIP Book Import complete: '$bookName' ($totalDecksCount chapters, $totalCardsCount cards)")

            ImportResult(
                success = true,
                fileName = fileName,
                totalDecks = totalDecksCount,
                totalNotes = totalNotesCount,
                totalCards = totalCardsCount
            )
        } catch (e: Exception) {
            Log.e(TAG, "ZIP import error: ${e.message}", e)
            ImportResult(
                success = false,
                fileName = fileName,
                totalDecks = 0,
                totalNotes = 0,
                totalCards = 0,
                error = "ZIP processing error: ${e.message}"
            )
        }
    }

    private fun isMediaFile(fileName: String): Boolean {
        val lower = fileName.lowercase()
        return lower.endsWith(".png") || lower.endsWith(".jpg") || lower.endsWith(".jpeg") ||
                lower.endsWith(".gif") || lower.endsWith(".svg") || lower.endsWith(".webp") ||
                lower.endsWith(".bmp") || lower.endsWith(".wav") || lower.endsWith(".mp3")
    }

    private fun saveMediaFile(context: Context, fileName: String, zis: ZipInputStream) {
        val imagesDir = File(context.filesDir, "images")
        if (!imagesDir.exists()) imagesDir.mkdirs()
        val destFile = File(imagesDir, fileName)
        destFile.outputStream().use { out ->
            val buffer = ByteArray(8192)
            var bytesRead: Int
            while (zis.read(buffer).also { bytesRead = it } != -1) {
                out.write(buffer, 0, bytesRead)
            }
        }
    }

    private fun getFileName(context: Context, uri: Uri): String {
        var result: String? = null
        if (uri.scheme == "content") {
            val cursor = context.contentResolver.query(uri, null, null, null, null)
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    val index = cursor.getColumnIndex(android.provider.OpenableColumns.DISPLAY_NAME)
                    if (index != -1) result = cursor.getString(index)
                }
            } finally {
                cursor?.close()
            }
        }
        if (result == null) {
            result = uri.path
            val cut = result?.lastIndexOf('/') ?: -1
            if (cut != -1) result = result?.substring(cut + 1)
        }
        return result ?: "imported_book.zip"
    }
}
