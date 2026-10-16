package com.example.flashcardapp.data

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.room.withTransaction
import com.example.flashcardapp.data.entities.CardEntity
import com.example.flashcardapp.data.entities.DeckEntity
import com.google.gson.Gson
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

            val epubData = extractSpineHtmlAndSubjects(fileBytes)
            val htmlContents = epubData.htmlList
            val epubSubjects = epubData.subjects

            if (htmlContents.isEmpty()) {
                throw IllegalStateException("No valid HTML spine content found in EPUB")
            }

            val baseDeckName = targetDeckName ?: fileName.removeSuffix(".epub").removeSuffix(".EPUB").trim().ifEmpty { "Imported EPUB" }
            val finalDeckId = targetDeckId ?: (baseDeckName.hashCode().toLong() and 0x7FFFFFFF)
            val gson = Gson()
            
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

            fun getOrCreateDeckId(path: String): Long {
                if (path == baseDeckName) return finalDeckId
                val existing = decksToInsert[path]
                if (existing != null) return existing.id

                val parts = path.split("::")
                var cumulative = ""
                var parentId: Long? = if (targetDeckId != null) finalDeckId else null

                for (i in parts.indices) {
                    val part = parts[i]
                    cumulative = if (cumulative.isEmpty()) part else "$cumulative::$part"
                    if (cumulative == baseDeckName) {
                        parentId = finalDeckId
                        continue
                    }
                    val currentDeck = decksToInsert[cumulative]
                    if (currentDeck == null) {
                        val newId = (cumulative.hashCode().toLong() and 0x7FFFFFFF)
                        decksToInsert[cumulative] = DeckEntity(
                            id = newId,
                            name = part,
                            fullPath = cumulative,
                            parentDeckId = parentId,
                            cardCount = 0,
                            lastSyncTimestamp = System.currentTimeMillis()
                        )
                        parentId = newId
                    } else {
                        parentId = currentDeck.id
                    }
                }
                return parentId ?: finalDeckId
            }

            // ── Strategy 1: Universal Structured Q&A / MCQ Extraction ──────────────
            var currentChapter = ""
            var currentSubtopic = ""

            val qStartRegex = Regex("""(?i)(?:^|\n)\s*(?:\*\*|\b)?(?:Q(?:uestion|\.|\s*\d+)?\s*[\.:\)]|\d+[\.\)]\s+Question|\d+\.\s+)(?![A-D]\b)""")

            val optAPattern = Regex("""(?i)(?:^|[\s\n])(?:\(|\[)?(?:A|1)(?:\)|\]|\.|\:)\s*(.*?)(?=(?:[\s\n])(?:\(|\[)?(?:B|2)(?:\)|\]|\.|\:))""", RegexOption.DOT_MATCHES_ALL)
            val optBPattern = Regex("""(?i)(?:^|[\s\n])(?:\(|\[)?(?:B|2)(?:\)|\]|\.|\:)\s*(.*?)(?=(?:[\s\n])(?:\(|\[)?(?:C|3)(?:\)|\]|\.|\:))""", RegexOption.DOT_MATCHES_ALL)
            val optCPattern = Regex("""(?i)(?:^|[\s\n])(?:\(|\[)?(?:C|3)(?:\)|\]|\.|\:)\s*(.*?)(?=(?:[\s\n])(?:\(|\[)?(?:D|4)(?:\)|\]|\.|\:))""", RegexOption.DOT_MATCHES_ALL)
            val optDPattern = Regex("""(?i)(?:^|[\s\n])(?:\(|\[)?(?:D|4)(?:\)|\]|\.|\:)\s*(.*?)(?=(?:\*\*Answer:|\bAnswer:|\bAns(?:wer)?|\bCorrect|\bKey|\bSol(?:ution)?|\bRight\s*Answer|$))""", RegexOption.DOT_MATCHES_ALL)

            val ansKeyPattern = Regex(
                """(?i)(?:\*\*Answer:\*\*|\bAnswer:|\bAns(?:wer)?\s*[:\.-]|\bCorrect\s*(?:Option|Answer)\s*[:\.-]|\bKey\s*[:\.-]|\bRight\s*Answer\s*[:\.-])\s*(?:\(|\[)?([A-E1-5a-e])?(?:\)|\]|\.|\:)?\s*(.*?)(?=(?:\*\*Explanation:\*\*|\bExplanation:|\bExp(?:lanation)?\s*[:\.-]|\bSol(?:ution)?\s*[:\.-]|\bReason\s*[:\.-]|\bHint\s*[:\.-]|$))""",
                RegexOption.DOT_MATCHES_ALL
            )
            val expKeyPattern = Regex(
                """(?i)(?:\*\*Explanation:\*\*|\bExplanation:|\bExp(?:lanation)?\s*[:\.-]|\bSol(?:ution)?\s*[:\.-]|\bReason\s*[:\.-]|\bHint\s*[:\.-])\s*(.*)""",
                RegexOption.DOT_MATCHES_ALL
            )

            for (html in htmlContents) {
                val doc = Jsoup.parse(html)
                val textWithNewlines = html.replace(Regex("(?i)<br\\s*/?>|</p>|</div>|</li>|</h1>|</h2>|</h3>|</h4>|<hr\\s*/?>"), "\n")
                val fullText = Jsoup.parse(textWithNewlines).wholeText()

                val h1OrH2 = doc.body().select("h1, h2").firstOrNull()?.text()?.trim()
                if (!h1OrH2.isNullOrEmpty()) {
                    currentChapter = h1OrH2.replace(Regex("(?i)^(Chapter|Section)\\s*\\d*[:\\.-]?\\s*"), "").ifEmpty { h1OrH2 }
                    currentSubtopic = ""
                }

                val hrBlocks = doc.body().html().split(Regex("(?i)<hr\\s*/?>|---|===|____"))
                    .map { Jsoup.parse(it).text().trim() }
                    .filter { it.length > 15 }

                val questionChunks = mutableListOf<String>()
                if (hrBlocks.size > 1 && hrBlocks.count { qStartRegex.containsMatchIn(it) || it.contains(Regex("(?i)Ans(?:wer)?:")) } >= 2) {
                    questionChunks.addAll(hrBlocks)
                } else {
                    val matches = qStartRegex.findAll(fullText).toList()
                    if (matches.isNotEmpty()) {
                        for (i in matches.indices) {
                            val start = matches[i].range.first
                            val end = if (i + 1 < matches.size) matches[i + 1].range.first else fullText.length
                            val chunk = fullText.substring(start, end).trim()
                            if (chunk.length > 15) {
                                questionChunks.add(chunk)
                            }
                        }
                    } else if (hrBlocks.isNotEmpty()) {
                        questionChunks.addAll(hrBlocks)
                    } else if (fullText.length > 15) {
                        questionChunks.add(fullText)
                    }
                }

                for (chunk in questionChunks) {
                    // Check for inline subtopic tag
                    val subtopicMatch = Regex("""(?i)(?:^|\n)###?\s*(.*?)(?=\n|$)""").find(chunk)
                    if (subtopicMatch != null) {
                        val st = subtopicMatch.groupValues[1].trim()
                        if (st.length in 3..60 && !st.contains(Regex("(?i)^Q\\d+"))) {
                            currentSubtopic = st
                        }
                    }

                    val mHead = qStartRegex.find(chunk)
                    val bodyAfterHead = if (mHead != null && mHead.range.first < 20) {
                        chunk.substring(mHead.range.last + 1).trim()
                    } else {
                        chunk
                    }

                    val mAns = ansKeyPattern.find(bodyAfterHead)
                    val mA = optAPattern.find(bodyAfterHead)
                    val mB = optBPattern.find(bodyAfterHead)
                    val mC = optCPattern.find(bodyAfterHead)
                    val mD = optDPattern.find(bodyAfterHead)

                    if (mAns != null || (mA != null && mB != null)) {
                        val rawQuestion = when {
                            mA != null -> bodyAfterHead.substring(0, mA.range.first).trim()
                            mAns != null -> bodyAfterHead.substring(0, mAns.range.first).trim()
                            else -> bodyAfterHead.trim()
                        }

                        val optA = mA?.groupValues?.get(1)?.trim() ?: ""
                        val optB = mB?.groupValues?.get(1)?.trim() ?: ""
                        val optC = mC?.groupValues?.get(1)?.trim() ?: ""
                        val optD = mD?.groupValues?.get(1)?.trim() ?: ""

                        val ansLetter = mAns?.groupValues?.get(1)?.trim()?.uppercase() ?: ""
                        val ansRaw = mAns?.groupValues?.get(2)?.trim() ?: ""
                        val mExp = expKeyPattern.find(bodyAfterHead)
                        val explanation = mExp?.groupValues?.get(1)?.trim() ?: ""

                        var resolvedAnswer = ansRaw
                        if (resolvedAnswer.isEmpty() || resolvedAnswer.uppercase() in listOf("A", "B", "C", "D", "1", "2", "3", "4")) {
                            val key = if (ansLetter.isNotEmpty()) ansLetter else resolvedAnswer.uppercase()
                            resolvedAnswer = when (key) {
                                "A", "1" -> optA
                                "B", "2" -> optB
                                "C", "3" -> optC
                                "D", "4" -> optD
                                else -> ansRaw
                            }
                        }
                        if (resolvedAnswer.isEmpty() && optA.isNotEmpty()) {
                            resolvedAnswer = optA
                        }

                        val backStr = if (optA.isNotEmpty() && optB.isNotEmpty()) {
                            "$resolvedAnswer | $optA | $optB | ${optC.ifEmpty { "Option C" }} | ${optD.ifEmpty { "Option D" }}" +
                                (if (explanation.isNotEmpty()) " {explain} $explanation" else "")
                        } else {
                            resolvedAnswer + (if (explanation.isNotEmpty()) " {explain} $explanation" else "")
                        }

                        var fullPath = baseDeckName
                        if (currentChapter.isNotEmpty()) {
                            fullPath = "$fullPath::$currentChapter"
                        }
                        if (currentSubtopic.isNotEmpty()) {
                            fullPath = "$fullPath::$currentSubtopic"
                        }
                        val targetDeckForCardId = getOrCreateDeckId(fullPath)

                        val tagsList = (epubSubjects + listOf(baseDeckName, currentChapter, currentSubtopic).filter { it.isNotEmpty() }).distinct()
                        val (cleanTags, extractedQ) = com.example.flashcardapp.data.core.TagQuestionUtils.parseAndFilterTags(gson.toJson(tagsList))
                        var finalQ = com.example.flashcardapp.data.core.TagQuestionUtils.normalizeExtractedQuestion(rawQuestion)
                        if (finalQ.isEmpty() && extractedQ != null) {
                            finalQ = extractedQ
                        }

                        if (finalQ.isNotEmpty() && resolvedAnswer.isNotEmpty()) {
                            val uniqueCardId = kotlin.math.abs(java.util.UUID.randomUUID().mostSignificantBits)
                            cardEntities.add(
                                CardEntity(
                                    id = uniqueCardId,
                                    noteId = uniqueCardId,
                                    deckId = targetDeckForCardId,
                                    front = finalQ,
                                    back = backStr,
                                    tags = gson.toJson(cleanTags),
                                    deckHierarchy = fullPath
                                )
                            )
                        }
                    }
                }
            }

            // ── Strategy 2: General Heading & Paragraph Fallback Parser ───────────
            if (cardEntities.isEmpty()) {
                Log.i(TAG, "Strategy 1 produced 0 cards. Falling back to Strategy 2 (DOM Heading & Paragraph Parser)")
                currentChapter = ""
                currentSubtopic = ""

                for (html in htmlContents) {
                    val doc = Jsoup.parse(html)

                    for (element in doc.body().select("h1, h2, h3, h4, p, li, dt, dd, blockquote")) {
                        val tagName = element.tagName()
                        val text = element.text().trim()

                        if (tagName in listOf("h1", "h2")) {
                            if (text.isNotEmpty()) {
                                currentChapter = text.replace(Regex("(?i)^(Chapter|Section)\\s*\\d*[:\\.-]?\\s*"), "").ifEmpty { text }
                                currentSubtopic = ""
                            }
                        } else if (tagName in listOf("h3", "h4")) {
                            if (text.isNotEmpty()) currentSubtopic = text
                        } else if (text.length >= 20) {
                            var front = ""
                            var back = ""

                            val boldChild = element.selectFirst("b, strong, dt")
                            if (boldChild != null) {
                                val term = boldChild.text().trim().removeSuffix(":").removeSuffix("-")
                                val body = text.substringAfter(boldChild.text()).trim().removePrefix(":").removePrefix("-").trim()
                                if (term.length in 3..100 && body.isNotEmpty()) {
                                    front = term
                                    back = body
                                }
                            }

                            if (front.isEmpty() && back.isEmpty()) {
                                val colonIdx = text.indexOf(':')
                                if (colonIdx in 3..60) {
                                    front = text.substring(0, colonIdx).trim()
                                    back = text.substring(colonIdx + 1).trim()
                                } else {
                                    val sentenceEnd = text.indexOfAny(charArrayOf('.', '?', '!'))
                                    if (sentenceEnd in 10..120) {
                                        front = text.substring(0, sentenceEnd + 1).trim()
                                        back = text.substring(sentenceEnd + 1).trim()
                                    } else {
                                        val topicName = currentSubtopic.ifEmpty { currentChapter }.ifEmpty { baseDeckName }
                                        front = "Concept in $topicName"
                                        back = text
                                    }
                                }
                            }

                            if (front.isNotEmpty() && back.isNotEmpty()) {
                                var fullPath = baseDeckName
                                if (currentChapter.isNotEmpty()) fullPath = "$fullPath::$currentChapter"
                                if (currentSubtopic.isNotEmpty()) fullPath = "$fullPath::$currentSubtopic"
                                val targetDeckForCardId = getOrCreateDeckId(fullPath)

                                val tagsList = (epubSubjects + listOf(baseDeckName, currentChapter, currentSubtopic).filter { it.isNotEmpty() }).distinct()
                                val (cleanTags, extractedQ) = com.example.flashcardapp.data.core.TagQuestionUtils.parseAndFilterTags(gson.toJson(tagsList))
                                var finalFront = com.example.flashcardapp.data.core.TagQuestionUtils.normalizeExtractedQuestion(front)
                                if (finalFront.isEmpty() && extractedQ != null) {
                                    finalFront = extractedQ
                                }

                                val uniqueCardId = kotlin.math.abs(java.util.UUID.randomUUID().mostSignificantBits)
                                val card = CardEntity(
                                    id = uniqueCardId,
                                    noteId = uniqueCardId,
                                    deckId = targetDeckForCardId,
                                    front = finalFront,
                                    back = back,
                                    tags = gson.toJson(cleanTags),
                                    deckHierarchy = fullPath
                                )
                                cardEntities.add(card)
                            }
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
                    error = "No readable flashcard content or paragraphs found in EPUB file."
                )
            }

            // Roll up card counts hierarchically to all ancestor decks
            cardEntities.forEach { card ->
                val parts = card.deckHierarchy.split("::")
                var cumulative = ""
                for (part in parts) {
                    cumulative = if (cumulative.isEmpty()) part else "$cumulative::$part"
                    decksToInsert[cumulative]?.let { d ->
                        decksToInsert[cumulative] = d.copy(cardCount = d.cardCount + 1)
                    }
                }
            }

            val appDb = AppDatabase.getInstance(context)
            appDb.deckDao().insertDecksIgnore(decksToInsert.values.toList())

            // Update cardCount for any existing decks in Room
            decksToInsert.values.forEach { deck ->
                val existing = appDb.deckDao().getDeckById(deck.id)
                if (existing != null) {
                    appDb.deckDao().updateDeck(existing.copy(cardCount = existing.cardCount + deck.cardCount))
                }
            }

            appDb.withTransaction {
                cardEntities.chunked(BATCH_SIZE).forEach { appDb.cardDao().insertCardsIgnore(it) }
            }

            Log.i(TAG, "EPUB import complete. Cards inserted: ${cardEntities.size} across ${decksToInsert.size} decks")

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

    private data class EpubData(val htmlList: List<String>, val subjects: List<String>)

    private fun extractSpineHtmlAndSubjects(epubBytes: ByteArray): EpubData {
        val files = mutableMapOf<String, ByteArray>()
        var rootFilePath: String? = null
        val subjects = mutableListOf<String>()

        ZipInputStream(epubBytes.inputStream()).use { zis ->
            var entry: ZipEntry?
            while (zis.nextEntry.also { entry = it } != null) {
                if (!entry!!.isDirectory) {
                    files[entry!!.name] = zis.readBytes()
                }
                zis.closeEntry()
            }
        }

        val containerXml = files["META-INF/container.xml"] ?: return EpubData(emptyList(), emptyList())
        val factory = DocumentBuilderFactory.newInstance()
        val builder = factory.newDocumentBuilder()
        val containerDoc = builder.parse(containerXml.inputStream())
        val rootfiles = containerDoc.getElementsByTagName("rootfile")
        if (rootfiles.length > 0) {
            rootFilePath = (rootfiles.item(0) as Element).getAttribute("full-path")
        }
        
        if (rootFilePath == null || !files.containsKey(rootFilePath)) return EpubData(emptyList(), emptyList())

        val opfContent = files[rootFilePath!!] ?: return EpubData(emptyList(), emptyList())
        val opfDoc = builder.parse(opfContent.inputStream())
        
        // Extract subjects from OPF metadata
        val subjectNodes = opfDoc.getElementsByTagName("dc:subject")
        for (i in 0 until subjectNodes.length) {
            val text = subjectNodes.item(i).textContent.trim()
            if (text.isNotEmpty()) subjects.add(text)
        }

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

        return EpubData(htmlList, subjects)
    }
}
