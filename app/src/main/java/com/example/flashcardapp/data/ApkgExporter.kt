package com.example.flashcardapp.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import android.util.Log
import com.example.flashcardapp.data.entities.CardEntity
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

object ApkgExporter {
    private const val TAG = "ApkgExporter"

    suspend fun exportDeck(
        context: Context,
        deckId: Long,
        deckName: String,
        cards: List<CardEntity>,
        uri: Uri
    ): Boolean = withContext(Dispatchers.IO) {
        Log.i(TAG, "Starting APKG export for deck: $deckName (${cards.size} cards)")
        var tempDbFile: File? = null
        var db: SQLiteDatabase? = null
        var tempZipFile: File? = null

        try {
            // 1. Create a temp file for SQLite database
            tempDbFile = File.createTempFile("export_anki_", ".db", context.cacheDir)
            if (tempDbFile.exists()) tempDbFile.delete()

            // 2. Open the database
            db = SQLiteDatabase.openOrCreateDatabase(tempDbFile, null)

            // 3. Create schema
            db.execSQL("CREATE TABLE decks (id INTEGER PRIMARY KEY, name TEXT)")
            db.execSQL("CREATE TABLE notes (id INTEGER PRIMARY KEY, flds TEXT, tags TEXT)")
            db.execSQL("CREATE TABLE cards (id INTEGER PRIMARY KEY, nid INTEGER, did INTEGER)")

            // 4. Insert deck info
            db.execSQL(
                "INSERT INTO decks (id, name) VALUES (?, ?)",
                arrayOf(deckId, deckName)
            )

            // 5. Insert cards & notes
            val gson = Gson()
            for (card in cards) {
                // Ensure noteId is valid, fallback to card id if necessary
                val noteId = if (card.noteId != 0L) card.noteId else card.id

                val fieldsStr = "${card.front}\u001f${card.back}"
                
                // Convert JSON tags to space-separated string
                val tagsList = try {
                    val type = object : com.google.gson.reflect.TypeToken<List<String>>() {}.type
                    gson.fromJson<List<String>>(card.tags, type) ?: emptyList()
                } catch (e: Exception) {
                    emptyList<String>()
                }
                val tagsStr = tagsList.joinToString(" ")

                db.execSQL(
                    "INSERT INTO notes (id, flds, tags) VALUES (?, ?, ?)",
                    arrayOf(noteId, fieldsStr, tagsStr)
                )

                db.execSQL(
                    "INSERT INTO cards (id, nid, did) VALUES (?, ?, ?)",
                    arrayOf(card.id, noteId, deckId)
                )
            }

            db.close()
            db = null

            // 6. Zip collection database into temp ZIP file as collection.anki21
            tempZipFile = File.createTempFile("export_zip_", ".apkg", context.cacheDir)
            ZipOutputStream(FileOutputStream(tempZipFile)).use { zos ->
                val entry = ZipEntry("collection.anki21")
                zos.putNextEntry(entry)
                tempDbFile.inputStream().use { input ->
                    input.copyTo(zos)
                }
                zos.closeEntry()
            }

            // 7. Write temp ZIP file to destination Uri
            context.contentResolver.openOutputStream(uri)?.use { outputStream ->
                tempZipFile.inputStream().use { input ->
                    input.copyTo(outputStream)
                }
            } ?: throw IllegalStateException("Cannot open output stream for URI: $uri")

            Log.i(TAG, "Successfully exported APKG to $uri")
            true
        } catch (e: Exception) {
            Log.e(TAG, "APKG export failed", e)
            false
        } finally {
            try {
                db?.close()
            } catch (e: Exception) {
                // Ignore
            }
            tempDbFile?.let { if (it.exists()) it.delete() }
            tempZipFile?.let { if (it.exists()) it.delete() }
        }
    }
}
