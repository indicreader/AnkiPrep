package com.example.flashcardapp.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import android.provider.OpenableColumns
import android.util.Log
import androidx.room.withTransaction
import com.example.flashcardapp.data.entities.CardEntity
import com.example.flashcardapp.data.entities.DeckEntity
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.util.zip.ZipFile

/**
 * Result of a .apkg file import operation.
 */
data class ImportResult(
    val success: Boolean,
    val fileName: String,
    val totalDecks: Int,
    val totalNotes: Int,
    val totalCards: Int,
    val sampleCards: List<CardEntity> = emptyList(),
    val error: String? = null
)

/**
 * Handles offline-first importing of .apkg files.
 *
 * Implements streaming file copy (preventing OOM), unzips the SQLite collection database
 * (collection.anki2 or collection.anki21), parses the decks/notes/cards tables, and
 * stores them into the Room database.
 */
object ApkgImporter {
    private const val TAG = "ApkgImporter"
    private const val BUFFER_SIZE = 8192

    suspend fun importApkg(
        context: Context, 
        uri: Uri,
        targetDeckId: Long? = null,
        targetDeckName: String? = null
    ): ImportResult = withContext(Dispatchers.IO) {
        val fileName = getFileName(context, uri)
        Log.i(TAG, "Starting import of APKG: $fileName")

        var tempApkgFile: File? = null
        var tempDbFile: File? = null
        var db: SQLiteDatabase? = null

        try {
            // Step 1: Copy InputStream safely to a temp file (stream-buffered to prevent memory OOM)
            tempApkgFile = File.createTempFile("import_temp_", ".apkg", context.cacheDir)
            val inputStream: InputStream = context.contentResolver.openInputStream(uri)
                ?: throw IllegalArgumentException("Failed to open input stream for URI: $uri")

            inputStream.use { input ->
                FileOutputStream(tempApkgFile).use { output ->
                    val buffer = ByteArray(BUFFER_SIZE)
                    var bytesRead: Int
                    while (input.read(buffer).also { bytesRead = it } != -1) {
                        output.write(buffer, 0, bytesRead)
                    }
                }
            }

            // Step 2: Open ZipFile to locate and extract collection database
            val zipFile = ZipFile(tempApkgFile)
            var dbEntry = zipFile.getEntry("collection.anki21")
            if (dbEntry == null) {
                dbEntry = zipFile.getEntry("collection.anki2")
            }
            if (dbEntry == null) {
                // Fallback: look for any entry whose name starts with collection.anki2
                val entries = zipFile.entries()
                while (entries.hasMoreElements()) {
                    val entry = entries.nextElement()
                    if (entry.name.startsWith("collection.anki2")) {
                        dbEntry = entry
                        break
                    }
                }
            }

            if (dbEntry == null) {
                throw IllegalStateException("Invalid APKG: collection.anki2/anki21 database not found inside zip.")
            }

            // Extract the database file to a temporary file
            tempDbFile = File.createTempFile("anki_db_", ".db", context.cacheDir)
            zipFile.getInputStream(dbEntry).use { zipInput ->
                FileOutputStream(tempDbFile).use { fileOutput ->
                    val buffer = ByteArray(BUFFER_SIZE)
                    var bytesRead: Int
                    while (zipInput.read(buffer).also { bytesRead = it } != -1) {
                        fileOutput.write(buffer, 0, bytesRead)
                    }
                }
            }
            zipFile.close()

            // Step 3: Open SQLite Database in read-only mode
            db = SQLiteDatabase.openDatabase(tempDbFile.absolutePath, null, SQLiteDatabase.OPEN_READONLY)

            // Step 4: Parse Decks
            val decksMap = parseDecks(db)
            if (decksMap.isEmpty()) {
                throw IllegalStateException("No decks found in the imported Anki database.")
            }

            // Step 5: Query and map cards and notes
            val cardsQuery = """
                SELECT c.id AS card_id, c.nid AS note_id, c.did AS deck_id, n.flds AS fields, n.tags AS tags 
                FROM cards c 
                JOIN notes n ON c.nid = n.id
            """.trimIndent()

            val cardEntities = mutableListOf<CardEntity>()
            val parsedNoteIds = mutableSetOf<Long>()
            val deckPathToId = decksMap.entries.associate { it.value to it.key }

            db.rawQuery(cardsQuery, null).use { cursor ->
                val cardIdIndex = cursor.getColumnIndex("card_id")
                val noteIdIndex = cursor.getColumnIndex("note_id")
                val deckIdIndex = cursor.getColumnIndex("deck_id")
                val fieldsIndex = cursor.getColumnIndex("fields")
                val tagsIndex = cursor.getColumnIndex("tags")

                if (cardIdIndex >= 0 && noteIdIndex >= 0 && deckIdIndex >= 0 && fieldsIndex >= 0 && tagsIndex >= 0) {
                    while (cursor.moveToNext()) {
                        val cardId = cursor.getLong(cardIdIndex)
                        val noteId = cursor.getLong(noteIdIndex)
                        val deckId = cursor.getLong(deckIdIndex)
                        val fields = cursor.getString(fieldsIndex) ?: ""
                        val tagsString = cursor.getString(tagsIndex) ?: ""

                        parsedNoteIds.add(noteId)

                        val parts = fields.split("\u001f")
                        val rawFront = parts.getOrNull(0) ?: ""
                        val rawBack = parts.getOrNull(1) ?: ""

                        val front = DeckHierarchyUtils.stripHtml(rawFront)
                        val back = DeckHierarchyUtils.stripHtml(rawBack)

                        if (front.isEmpty() || back.isEmpty()) {
                            continue
                        }

                        // Parse space-separated tags
                        val tagsList = tagsString.split(" ")
                            .map { it.trim() }
                            .filter { it.isNotEmpty() }
                        val tagsJson = Gson().toJson(tagsList)

                        val rawDeckName = decksMap[deckId] ?: "Deck $deckId"
                        
                        // If we are merging/renaming into a target deck:
                        // Map the root deck name in APKG to targetDeckName, and subdecks as children.
                        val finalDeckName = if (targetDeckName != null) {
                            val apkRoot = decksMap.values.filter { !it.contains("::") }.firstOrNull()
                            if (apkRoot != null && rawDeckName.startsWith(apkRoot)) {
                                rawDeckName.replaceFirst(apkRoot, targetDeckName)
                            } else {
                                targetDeckName
                            }
                        } else {
                            rawDeckName
                        }

                        val finalDeckId = if (targetDeckId != null && rawDeckName == finalDeckName) {
                            targetDeckId
                        } else {
                            deckId
                        }

                        // Hierarchy resolution
                        val segments = DeckHierarchyUtils.parseDeckHierarchy(finalDeckName)
                        val subDeckId = if (segments.size > 1) {
                            deckPathToId[rawDeckName] ?: finalDeckId
                        } else {
                            null
                        }

                        cardEntities.add(
                            CardEntity(
                                id = cardId,
                                noteId = noteId,
                                deckId = finalDeckId,
                                subDeckId = subDeckId,
                                front = front,
                                back = back,
                                tags = tagsJson,
                                deckHierarchy = finalDeckName,
                                lastSyncTimestamp = System.currentTimeMillis()
                            )
                        )
                    }
                }
            }

            if (cardEntities.isEmpty()) {
                throw IllegalStateException("No valid flashcards parsed from database.")
            }

            // Map original deck ID to updated target values
            val finalDecksMap = decksMap.mapValues { (id, fullPath) ->
                if (targetDeckName != null) {
                    val apkRoot = decksMap.values.filter { !it.contains("::") }.firstOrNull()
                    if (apkRoot != null && fullPath.startsWith(apkRoot)) {
                        fullPath.replaceFirst(apkRoot, targetDeckName)
                    } else {
                        targetDeckName
                    }
                } else {
                    fullPath
                }
            }

            val finalDeckIdMap = decksMap.map { (id, fullPath) ->
                val updatedName = finalDecksMap[id] ?: fullPath
                val updatedId = if (targetDeckId != null && updatedName == targetDeckName) {
                    targetDeckId
                } else {
                    id
                }
                id to updatedId
            }.toMap()

            // Calculate card count per deck
            val deckCardCounts = cardEntities.groupBy { it.deckId }.mapValues { it.value.size }

            // Step 6: Map to DeckEntities
            val deckEntities = finalDecksMap.map { (id, fullPath) ->
                val finalId = finalDeckIdMap[id] ?: id
                val hierarchy = DeckHierarchyUtils.parseDeckHierarchy(fullPath)
                val leafName = hierarchy.lastOrNull() ?: fullPath
                val parentPath = DeckHierarchyUtils.getParentDeckPath(fullPath)
                
                // Map parent path to target if needed
                val parentId = parentPath?.let { path ->
                    val origId = decksMap.entries.find { it.value == path }?.key
                    origId?.let { finalDeckIdMap[it] }
                }
                val cardCount = deckCardCounts[finalId] ?: 0

                DeckEntity(
                    id = finalId,
                    name = leafName,
                    fullPath = fullPath,
                    parentDeckId = parentId,
                    cardCount = cardCount,
                    lastSyncTimestamp = System.currentTimeMillis()
                )
            }.filter { it.cardCount > 0 } // Skip empty decks for MVP selection simplicity

            // Step 7: Store into Room database in transaction
            val appDb = AppDatabase.getInstance(context)
            
            // Separate cards into updates and inserts to prevent cascade delete
            val existingCardIds = appDb.cardDao().getAllCardsOnce().map { it.id }.toSet()
            val cardsToUpdate = cardEntities.filter { it.id in existingCardIds }
            val cardsToInsert = cardEntities.filter { it.id !in existingCardIds }
            
            val existingDeckIds = appDb.deckDao().getAllDecksOnce().map { it.id }.toSet()
            val decksToUpdate = deckEntities.filter { it.id in existingDeckIds }
            val decksToInsert = deckEntities.filter { it.id !in existingDeckIds }
            
            appDb.withTransaction {
                // If merging into existing, check if we need to update deck cardCount first
                if (targetDeckId != null) {
                    val existingDeck = appDb.deckDao().getDeckById(targetDeckId)
                    if (existingDeck != null) {
                        val addedCount = deckCardCounts[targetDeckId] ?: 0
                        appDb.deckDao().updateDeck(existingDeck.copy(cardCount = existingDeck.cardCount + addedCount))
                    }
                }
                
                appDb.deckDao().insertDecksIgnore(decksToInsert)
                appDb.deckDao().updateDecks(decksToUpdate)
                
                cardsToInsert.chunked(500).forEach { appDb.cardDao().insertCardsIgnore(it) }
                cardsToUpdate.chunked(500).forEach { appDb.cardDao().updateCards(it) }
            }

            Log.i(TAG, "Successfully imported APKG. Decks: ${deckEntities.size}, Notes: ${parsedNoteIds.size}, Cards: ${cardEntities.size} (Inserted: ${cardsToInsert.size}, Updated: ${cardsToUpdate.size})")

            val sampleCards = cardEntities.take(3)

            // Print Mandatory Debug Requirements
            println("=== APKG IMPORT DEBUG REPORT ===")
            println("File Name: $fileName")
            println("Total Decks Found: ${deckEntities.size}")
            println("Total Notes Parsed: ${parsedNoteIds.size}")
            println("Total Cards Created: ${cardEntities.size}")
            println("Sample Cards Output:")
            sampleCards.forEachIndexed { index, card ->
                println("  Card #${index + 1}:")
                println("    ID: ${card.id}")
                println("    Deck: ${card.deckHierarchy}")
                println("    Front: ${card.front}")
                println("    Back: ${card.back}")
                println("    Tags: ${card.tags}")
            }
            println("=================================")

            ImportResult(
                success = true,
                fileName = fileName,
                totalDecks = deckEntities.size,
                totalNotes = parsedNoteIds.size,
                totalCards = cardEntities.size,
                sampleCards = sampleCards
            )
        } catch (e: Exception) {
            Log.e(TAG, "Import failed", e)
            val friendlyError = when {
                e is java.util.zip.ZipException && e.message?.contains("END header not found", ignoreCase = true) == true ->
                    "The selected file is not a valid Anki package (.apkg) or is corrupted (ZIP END header not found)."
                e is java.util.zip.ZipException ->
                    "Failed to parse Anki package: ${e.message}"
                tempApkgFile != null && tempApkgFile.length() == 0L ->
                    "The selected file is empty (0 bytes)."
                else -> e.message ?: "Unknown error occurred"
            }
            ImportResult(
                success = false,
                fileName = fileName,
                totalDecks = 0,
                totalNotes = 0,
                totalCards = 0,
                error = friendlyError
            )
        } finally {
            // Step 8: Clean up database and temp files safely
            try {
                db?.close()
            } catch (e: Exception) {
                Log.e(TAG, "Failed to close database", e)
            }
            tempApkgFile?.let {
                if (it.exists()) it.delete()
            }
            tempDbFile?.let {
                if (it.exists()) it.delete()
            }
        }
    }

    /**
     * Parses the deck mapping mapping deck ID -> full deck path.
     * Supports both modern 'decks' table and older JSON column format inside 'col' table.
     */
    private fun parseDecks(db: SQLiteDatabase): Map<Long, String> {
        val decksMap = mutableMapOf<Long, String>()

        // 1. Try modern database schema with 'decks' table
        try {
            val cursor = db.rawQuery("SELECT id, name FROM decks", null)
            cursor.use {
                val idIndex = it.getColumnIndex("id")
                val nameIndex = it.getColumnIndex("name")
                if (idIndex >= 0 && nameIndex >= 0) {
                    while (it.moveToNext()) {
                        val id = it.getLong(idIndex)
                        val name = it.getString(nameIndex) ?: ""
                        decksMap[id] = name
                    }
                }
            }
        } catch (e: Exception) {
            Log.d(TAG, "Could not query decks table: ${e.message}. Trying 'col' table 'decks' JSON mapping...")
        }

        // 2. Try older schema with 'col' table decks JSON column
        if (decksMap.isEmpty()) {
            try {
                val cursor = db.rawQuery("SELECT decks FROM col LIMIT 1", null)
                cursor.use {
                    if (it.moveToFirst()) {
                        val decksJson = it.getString(0)
                        val json = JSONObject(decksJson)
                        val keys = json.keys()
                        while (keys.hasNext()) {
                            val key = keys.next()
                            val deckObj = json.getJSONObject(key)
                            val id = deckObj.getLong("id")
                            val name = deckObj.getString("name")
                            decksMap[id] = name
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "Could not query col table decks column: ${e.message}")
            }
        }

        return decksMap
    }

    /**
     * Helper to retrieve display name of file from URI.
     */
    private fun getFileName(context: Context, uri: Uri): String {
        var result: String? = null
        if (uri.scheme == "content") {
            val cursor = context.contentResolver.query(uri, null, null, null, null)
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    val index = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                    if (index >= 0) {
                        result = cursor.getString(index)
                    }
                }
            } finally {
                cursor?.close()
            }
        }
        if (result == null) {
            result = uri.path
            val cut = result?.lastIndexOf('/') ?: -1
            if (cut != -1) {
                result = result?.substring(cut + 1)
            }
        }
        return result ?: "unknown.apkg"
    }
}
