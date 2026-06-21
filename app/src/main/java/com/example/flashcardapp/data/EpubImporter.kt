package com.example.flashcardapp.data

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.room.withTransaction
import com.example.flashcardapp.data.entities.CardEntity
import com.example.flashcardapp.data.entities.DeckEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.w3c.dom.Element
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import javax.xml.parsers.DocumentBuilderFactory

object EpubImporter {
    private const val TAG = "EpubImporter"
    private const val BATCH_SIZE = 200

    suspend fun importEpub(
        context: Context,
        uri: Uri,
        targetDeckId: Long? = null,
        targetDeckName: String? = null,
    ): ImportResult = withContext(Dispatchers.IO) {
        val fileName = AnkiDataRepository.getInstance(context).getFileName(uri)
        Log.i(TAG, "Starting EPUB import: $fileName")

        val cardEntities = mutableListOf<CardEntity>()

        try {
            val fileBytes = context.contentResolver.openInputStream(uri)?.readBytes()
                ?: throw IllegalArgumentException("Cannot open URI: $uri")

            val htmlContents = extractSpineHtml(fileBytes)
            if (htmlContents.isEmpty()) {
                throw IllegalStateException("No valid HTML spine content found in EPUB")
            }

            var currentChapter = ""
            var currentSubtopic = ""

            // Regex patterns based on the prompt structure
            val qPattern = Regex("""\*\*Q\d+\.\*\*(.*?)(?=\s*[A-D]\))""", RegexOption.DOT_MATCHES_ALL)
            val aPattern = Regex("""A\)(.*?)(?=B\))""", RegexOption.DOT_MATCHES_ALL)
            val bPattern = Regex("""B\)(.*?)(?=C\))""", RegexOption.DOT_MATCHES_ALL)
            val cPattern = Regex("""C\)(.*?)(?=D\))""", RegexOption.DOT_MATCHES_ALL)
            val dPattern = Regex("""D\)(.*?)(?=\*\*Answer:\*\*)""", RegexOption.DOT_MATCHES_ALL)
            val ansPattern = Regex("""\*\*Answer:\*\*\s*[A-D]\)\s*(.*?)(?=\*\*Explanation:\*\*)""", RegexOption.DOT_MATCHES_ALL)
            val expPattern = Regex("""\*\*Explanation:\*\*(.*)""", RegexOption.DOT_MATCHES_ALL)

            val baseDeckName = targetDeckName ?: fileName.removeSuffix(".epub").removeSuffix(".EPUB").trim().ifEmpty { "Imported EPUB" }
            val finalDeckId = targetDeckId ?: (baseDeckName.hashCode().toLong() and 0x7FFFFFFF)
            
            val decksToInsert = mutableMapOf<String, DeckEntity>()

            if (targetDeckId == null) {
                decksToInsert[baseDeckName] = DeckEntity(
                    id = finalDeckId,
                    name = baseDeckName,
                    fullPath = baseDeckName,
                    parentDeckId = null,
                    cardCount = 0,
                    lastSyncTimestamp = System.currentTimeMillis()
                )
            }

            var globalIndex = 0L
            for (html in htmlContents) {
                val doc = Jsoup.parse(html)
                
                // Track headers to maintain deck hierarchy
                for (element in doc.body().children()) {
                    if (element.tagName() == "h1" || element.tagName() == "h2") {
                        val text = element.text()
                        if (text.contains("Chapter:", ignoreCase = true)) {
                            currentChapter = text.replace("Chapter:", "", ignoreCase = true).trim()
                            currentSubtopic = "" // Reset subtopic
                        } else if (currentChapter.isEmpty()) {
                            // First header might be book title
                        }
                    } else if (element.tagName() == "h3") {
                        currentSubtopic = element.text().trim()
                    }
                }

                // Split by horizontal rule to separate questions
                val blocks = doc.body().html().split("<hr>", "<hr/>", "<hr />", "---")
                
                for (blockHtml in blocks) {
                    val blockText = Jsoup.parse(blockHtml).text()
                    
                    if (blockText.contains("**Q") && blockText.contains("**Answer:**")) {
                        val qMatch = qPattern.find(blockText)
                        val aMatch = aPattern.find(blockText)
                        val bMatch = bPattern.find(blockText)
                        val cMatch = cPattern.find(blockText)
                        val dMatch = dPattern.find(blockText)
                        val ansMatch = ansPattern.find(blockText)
                        val expMatch = expPattern.find(blockText)

                        if (qMatch != null && aMatch != null && bMatch != null && 
                            cMatch != null && dMatch != null && ansMatch != null) {
                            
                            val question = qMatch.groupValues[1].trim()
                            val optA = aMatch.groupValues[1].trim()
                            val optB = bMatch.groupValues[1].trim()
                            val optC = cMatch.groupValues[1].trim()
                            val optD = dMatch.groupValues[1].trim()
                            val answer = ansMatch.groupValues[1].trim()
                            val explanation = expMatch?.groupValues?.get(1)?.trim() ?: ""

                            val front = question
                            val back = "$answer\n$explanation\n|\n$optA\n$optB\n$optC\n$optD"

                            var fullPath = baseDeckName
                            var parentId = finalDeckId
                            
                            if (currentChapter.isNotEmpty()) {
                                val chapPath = "$fullPath::$currentChapter"
                                val chapId = (chapPath.hashCode().toLong() and 0x7FFFFFFF)
                                decksToInsert[chapPath] = DeckEntity(
                                    id = chapId, name = currentChapter, fullPath = chapPath,
                                    parentDeckId = parentId, cardCount = 0, lastSyncTimestamp = System.currentTimeMillis()
                                )
                                fullPath = chapPath
                                parentId = chapId
                            }
                            if (currentSubtopic.isNotEmpty()) {
                                val subPath = "$fullPath::$currentSubtopic"
                                val subId = (subPath.hashCode().toLong() and 0x7FFFFFFF)
                                decksToInsert[subPath] = DeckEntity(
                                    id = subId, name = currentSubtopic, fullPath = subPath,
                                    parentDeckId = parentId, cardCount = 0, lastSyncTimestamp = System.currentTimeMillis()
                                )
                                fullPath = subPath
                                parentId = subId
                            }

                            val card = CardEntity(
                                id = (parentId xor globalIndex),
                                noteId = (parentId xor globalIndex),
                                deckId = parentId,
                                front = front,
                                back = back,
                                tags = "[]",
                                deckHierarchy = fullPath
                            )
                            cardEntities.add(card)
                            globalIndex++
                        }
                    }
                }
            }

            if (cardEntities.isEmpty()) {
                return@withContext ImportResult(
                    success = false,
                    fileName = fileName,
                    totalDecks = 0,
                    totalNotes = 0,
                    totalCards = 0,
                    error = "No valid flashcard content found in EPUB. Check formatting."
                )
            }

            // Recalculate card counts for decks
            cardEntities.forEach { card ->
                decksToInsert[card.deckHierarchy]?.let { d ->
                    decksToInsert[card.deckHierarchy] = d.copy(cardCount = d.cardCount + 1)
                }
            }

            val appDb = AppDatabase.getInstance(context)
            appDb.deckDao().insertDecksIgnore(decksToInsert.values.toList())

            appDb.withTransaction {
                cardEntities.chunked(BATCH_SIZE).forEach { appDb.cardDao().insertCardsIgnore(it) }
            }

            Log.i(TAG, "EPUB import complete. Cards inserted: ${cardEntities.size}")

            ImportResult(
                success = true,
                fileName = fileName,
                totalDecks = decksToInsert.size,
                totalNotes = cardEntities.size,
                totalCards = cardEntities.size,
                sampleCards = cardEntities.take(3)
            )

        } catch (e: Exception) {
            Log.e(TAG, "EPUB import failed", e)
            ImportResult(
                success = false,
                fileName = fileName,
                totalDecks = 0,
                totalNotes = 0,
                totalCards = 0,
                error = e.message ?: "Unknown error"
            )
        }
    }

    private fun extractSpineHtml(epubBytes: ByteArray): List<String> {
        val files = mutableMapOf<String, ByteArray>()
        var rootFilePath: String? = null

        // Unzip into memory map
        ZipInputStream(epubBytes.inputStream()).use { zis ->
            var entry: ZipEntry?
            while (zis.nextEntry.also { entry = it } != null) {
                if (!entry!!.isDirectory) {
                    files[entry!!.name] = zis.readBytes()
                }
                zis.closeEntry()
            }
        }

        // Parse container.xml to find OPF path
        val containerXml = files["META-INF/container.xml"] ?: return emptyList()
        val factory = DocumentBuilderFactory.newInstance()
        val builder = factory.newDocumentBuilder()
        val containerDoc = builder.parse(containerXml.inputStream())
        val rootfiles = containerDoc.getElementsByTagName("rootfile")
        if (rootfiles.length > 0) {
            rootFilePath = (rootfiles.item(0) as Element).getAttribute("full-path")
        }
        
        if (rootFilePath == null || !files.containsKey(rootFilePath)) return emptyList()

        // Parse OPF
        val opfContent = files[rootFilePath!!] ?: return emptyList()
        val opfDoc = builder.parse(opfContent.inputStream())
        
        val manifestMap = mutableMapOf<String, String>()
        val manifestItems = opfDoc.getElementsByTagName("item")
        for (i in 0 until manifestItems.length) {
            val el = manifestItems.item(i) as Element
            manifestMap[el.getAttribute("id")] = el.getAttribute("href")
        }

        val spineList = mutableListOf<String>()
        val spineItems = opfDoc.getElementsByTagName("itemref")
        for (i in 0 until spineItems.length) {
            val el = spineItems.item(i) as Element
            spineList.add(el.getAttribute("idref"))
        }

        // Resolve paths and extract HTML
        val basePath = if (rootFilePath!!.contains("/")) rootFilePath!!.substringBeforeLast("/") + "/" else ""
        val htmlList = mutableListOf<String>()

        for (idref in spineList) {
            val href = manifestMap[idref]
            if (href != null) {
                val resolvedPath = basePath + href
                val htmlBytes = files[resolvedPath]
                if (htmlBytes != null) {
                    htmlList.add(String(htmlBytes))
                }
            }
        }

        return htmlList
    }
}
