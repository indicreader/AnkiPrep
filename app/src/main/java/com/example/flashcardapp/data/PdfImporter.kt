package com.example.flashcardapp.data

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Rect
import android.graphics.pdf.PdfRenderer
import android.net.Uri
import android.os.ParcelFileDescriptor
import android.util.Log
import androidx.room.withTransaction
import com.example.flashcardapp.data.core.PyqMetadataExtractor
import com.example.flashcardapp.data.core.PyqTextNormalizer
import com.example.flashcardapp.data.entities.CardEntity
import com.example.flashcardapp.data.entities.DeckEntity
import com.google.android.gms.tasks.Tasks
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.Text
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream

/**
 * Column extraction modes for PDF layouts.
 */
enum class PdfColumnMode(val displayName: String) {
    AUTO("Auto-Detect (1, 2, or 3+ Columns)"),
    SINGLE("1 Column (Standard / Full Width)"),
    TWO_COLUMN("2 Columns (Booklet / Exam Paper)"),
    THREE_COLUMN("3 Columns (Dense Multi-Column)")
}

/**
 * Language filter for bilingual book extraction.
 */
enum class PdfLanguageFilter(val displayName: String) {
    BOTH("Both (Bilingual with Mid-Test Translation)"),
    ENGLISH_ONLY("English Only"),
    HINDI_ONLY("Hindi Only")
}

/**
 * 100% Offline, Privacy-First Multi-Column PDF Question Ingestion Engine.
 *
 * Uses native [PdfRenderer] to rasterize pages sequentially without memory spikes,
 * runs bundled on-device ML Kit Text Recognition, and performs spatial gutter
 * histogram segmentation to cleanly serialize 1, 2, 3, or more columns into
 * natural human reading order.
 */
object PdfImporter {

    private const val TAG = "PdfImporter"
    private const val RENDER_DPI_SCALE = 2.0f // 2x density for sharp OCR

    /**
     * Imports a PDF booklet into the offline database.
     *
     * @param context Android context
     * @param uri URI of the picked PDF file
     * @param duplicateStrategy "SKIP", "IMPORT", or "UPDATE"
     * @param targetDeckId Optional existing deck ID to merge questions into
     * @param targetDeckName Optional target deck name (default = PDF filename)
     * @param columnMode Spatial segmentation mode ([PdfColumnMode.AUTO] default)
     * @param onProgress Callback receiving (currentPage, totalPages, statusMessage)
     */
    suspend fun importPdf(
        context: Context,
        uri: Uri,
        duplicateStrategy: String = "IMPORT",
        targetDeckId: Long? = null,
        targetDeckName: String? = null,
        columnMode: PdfColumnMode = PdfColumnMode.AUTO,
        languageFilter: PdfLanguageFilter = PdfLanguageFilter.BOTH,
        onProgress: (currentPage: Int, totalPages: Int, status: String) -> Unit = { _, _, _ -> }
    ): ImportResult = withContext(Dispatchers.IO) {
        val repo = AnkiDataRepository.getInstance(context)
        val fileName = repo.getFileName(uri)
        Log.i(TAG, "Starting PDF import: $fileName (Mode: ${columnMode.displayName})")

        val db = AppDatabase.getInstance(context)
        val cardDao = db.cardDao()
        val deckDao = db.deckDao()

        // Cache PDF locally to safely obtain a seekable FileDescriptor
        val cacheFile = File(context.cacheDir, "temp_import_${System.currentTimeMillis()}.pdf")
        var pfd: ParcelFileDescriptor? = null
        var renderer: PdfRenderer? = null
        val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

        try {
            onProgress(0, 1, "Opening PDF document...")
            context.contentResolver.openInputStream(uri)?.use { input ->
                FileOutputStream(cacheFile).use { output -> input.copyTo(output) }
            } ?: throw IllegalArgumentException("Cannot open PDF URI: $uri")

            pfd = ParcelFileDescriptor.open(cacheFile, ParcelFileDescriptor.MODE_READ_ONLY)
            renderer = PdfRenderer(pfd)
            val pageCount = renderer.pageCount

            if (pageCount == 0) {
                return@withContext ImportResult(
                    success = false,
                    fileName = fileName,
                    totalDecks = 0,
                    totalNotes = 0,
                    totalCards = 0,
                    error = "PDF file contains 0 pages."
                )
            }

            val baseDeckName = targetDeckName?.ifBlank { null }
                ?: fileName.removeSuffix(".pdf").removeSuffix(".PDF").trim().ifEmpty { "Imported PDF" }
            val finalDeckId = targetDeckId ?: (baseDeckName.hashCode().toLong() and 0x7FFFFFFF)

            val fullTextBuilder = StringBuilder()

            for (pageIndex in 0 until pageCount) {
                onProgress(pageIndex + 1, pageCount, "Reading page ${pageIndex + 1} of $pageCount...")

                val page = renderer.openPage(pageIndex)
                val baseW = page.width
                val baseH = page.height
                val maxDim = maxOf(baseW, baseH)
                val scale = if (maxDim > 0) minOf(RENDER_DPI_SCALE, 2048f / maxDim) else RENDER_DPI_SCALE
                val width = (baseW * scale).toInt().coerceAtLeast(100)
                val height = (baseH * scale).toInt().coerceAtLeast(100)

                val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
                page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
                page.close()

                try {
                    val inputImage = InputImage.fromBitmap(bitmap, 0)
                    // Synchronously await ML Kit local recognition with 25s timeout to prevent freezes
                    val visionText: Text = Tasks.await(recognizer.process(inputImage), 25, java.util.concurrent.TimeUnit.SECONDS)
                    val orderedPageText = segmentPageIntoColumns(visionText, width.toFloat(), columnMode)
                    fullTextBuilder.append(orderedPageText).append("\n")
                } catch (e: Exception) {
                    Log.w(TAG, "OCR timeout or warning on page ${pageIndex + 1}: ${e.message}")
                } finally {
                    bitmap.recycle()
                }
            }

            onProgress(pageCount, pageCount, "Structuring questions and answer choices...")

            // Clean full text with PYQ Normalizer (strips font artifacts, headers/footers)
            val normalizedText = PyqTextNormalizer.normalizeText(fullTextBuilder.toString())
            val extractedCards = parseExtractedQuestions(normalizedText, baseDeckName, finalDeckId, languageFilter = languageFilter)

            if (extractedCards.isEmpty()) {
                return@withContext ImportResult(
                    success = false,
                    fileName = fileName,
                    totalDecks = 0,
                    totalNotes = 0,
                    totalCards = 0,
                    error = "No multiple-choice questions found. Ensure the PDF contains numbered questions (e.g. 1., Q1.) and option choices (a, b, c, d)."
                )
            }

            onProgress(pageCount, pageCount, "Saving ${extractedCards.size} cards to offline database...")

            db.withTransaction {
                // Ensure parent/target deck exists
                if (targetDeckId == null) {
                    val existingDeck = deckDao.getDeckById(finalDeckId)
                    if (existingDeck == null) {
                        deckDao.upsertDeck(
                            DeckEntity(
                                id = finalDeckId,
                                name = baseDeckName,
                                fullPath = baseDeckName,
                                parentDeckId = null,
                                cardCount = extractedCards.size,
                                lastSyncTimestamp = System.currentTimeMillis()
                            )
                        )
                    }
                }

                // Insert or merge cards based on duplicate strategy
                for (card in extractedCards) {
                    when (duplicateStrategy) {
                        "SKIP" -> {
                            val exists = cardDao.getCardsForDeckOnce(card.deckId).any {
                                it.front.trim().equals(card.front.trim(), ignoreCase = true)
                            }
                            if (!exists) cardDao.insertCard(card)
                        }
                        "UPDATE" -> {
                            val existing = cardDao.getCardsForDeckOnce(card.deckId).firstOrNull {
                                it.front.trim().equals(card.front.trim(), ignoreCase = true)
                            }
                            if (existing != null) {
                                cardDao.updateCard(card.copy(id = existing.id))
                            } else {
                                cardDao.insertCard(card)
                            }
                        }
                        else -> { // "IMPORT" (allow duplicates)
                            cardDao.insertCard(card)
                        }
                    }
                }

                // Update deck card count
                val actualCount = cardDao.getCardCountForDeck(finalDeckId)
                val targetDeck = deckDao.getDeckById(finalDeckId)
                if (targetDeck != null) {
                    deckDao.updateDeck(targetDeck.copy(cardCount = actualCount))
                }
            }

            Log.i(TAG, "Successfully imported ${extractedCards.size} cards from PDF into deck '$baseDeckName'")

            ImportResult(
                success = true,
                fileName = fileName,
                totalDecks = 1,
                totalNotes = extractedCards.size,
                totalCards = extractedCards.size,
                sampleCards = extractedCards.take(5)
            )

        } catch (e: Exception) {
            Log.e(TAG, "Failed to import PDF: ${e.message}", e)
            ImportResult(
                success = false,
                fileName = fileName,
                totalDecks = 0,
                totalNotes = 0,
                totalCards = 0,
                error = e.localizedMessage ?: "Unknown PDF extraction error."
            )
        } finally {
            try { recognizer.close() } catch (_: Exception) {}
            try { renderer?.close() } catch (_: Exception) {}
            try { pfd?.close() } catch (_: Exception) {}
            cacheFile.delete()
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // SEGMENTED IMPORT API
    // ─────────────────────────────────────────────────────────────────────────

    /**
     * Fast preview scan: samples every 3rd page at 1x DPI, extracts chapter headings.
     * Returns [PdfPreviewInfo] with page count and detected sections.
     *
     * @param context Android context
     * @param uri     URI of the PDF file (may be a content:// or file:// URI)
     * @param onProgress Optional progress callback (currentSample, totalSamples, status)
     */
    suspend fun scanPdfPreview(
        context: Context,
        uri: Uri,
        onProgress: (current: Int, total: Int, status: String) -> Unit = { _, _, _ -> }
    ): PdfPreviewInfo = withContext(Dispatchers.IO) {
        val cacheFile = File(context.cacheDir, "preview_scan_${System.currentTimeMillis()}.pdf")
        var pfd: ParcelFileDescriptor? = null
        var renderer: PdfRenderer? = null
        val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

        // Headings detection patterns
        val headingPatterns = listOf(
            Regex("(?i)^(?:chapter|part|unit|section|topic|chapter no\\.?|ch\\.?)\\s*[\\dIVXivx]+"),
            Regex("^[A-Z][A-Z &,\\-]{4,}$"),      // ALL CAPS line
            Regex("(?i)^[\\w &,\\-]{3,50}:\\s*$"), // Title ending with colon
            Regex("(?i)^(?:exercise|practice|revision|mock|test|set)\\s*[\\d]+")
        )

        try {
            context.contentResolver.openInputStream(uri)?.use { input ->
                FileOutputStream(cacheFile).use { output -> input.copyTo(output) }
            } ?: return@withContext PdfPreviewInfo(0, emptyList())

            pfd = ParcelFileDescriptor.open(cacheFile, ParcelFileDescriptor.MODE_READ_ONLY)
            renderer = PdfRenderer(pfd)
            val pageCount = renderer.pageCount
            if (pageCount == 0) return@withContext PdfPreviewInfo(0, emptyList())

            val chapters = mutableListOf<DetectedChapter>()
            val sampleStep = 3
            val samplePages = (0 until pageCount).filter { it % sampleStep == 0 }

            for ((idx, pageIndex) in samplePages.withIndex()) {
                onProgress(idx + 1, samplePages.size, "Scanning page ${pageIndex + 1} of $pageCount...")

                val page = renderer.openPage(pageIndex)
                // Use 1x DPI for speed — good enough for heading detection
                val scale = 1.0f
                val width = (page.width * scale).toInt().coerceAtLeast(100)
                val height = (page.height * scale).toInt().coerceAtLeast(100)
                val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
                page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
                page.close()

                try {
                    val inputImage = InputImage.fromBitmap(bitmap, 0)
                    val visionText = Tasks.await(
                        recognizer.process(inputImage), 15, java.util.concurrent.TimeUnit.SECONDS
                    )
                    // Scan the first few blocks of each page for heading signatures
                    for (block in visionText.textBlocks.take(5)) {
                        val lineText = block.lines.firstOrNull()?.text?.trim() ?: continue
                        if (lineText.length < 3 || lineText.length > 120) continue
                        val isHeading = headingPatterns.any { it.containsMatchIn(lineText) }
                        if (isHeading) {
                            chapters.add(DetectedChapter(pageIndex + 1, lineText))
                            break // One heading per page
                        }
                    }
                } catch (e: Exception) {
                    Log.w(TAG, "Preview scan timeout page ${pageIndex + 1}: ${e.message}")
                } finally {
                    bitmap.recycle()
                }
            }

            PdfPreviewInfo(pageCount = pageCount, chapters = chapters)
        } catch (e: Exception) {
            Log.e(TAG, "scanPdfPreview failed: ${e.message}", e)
            PdfPreviewInfo(0, emptyList())
        } finally {
            try { recognizer.close() } catch (_: Exception) {}
            try { renderer?.close() } catch (_: Exception) {}
            try { pfd?.close() } catch (_: Exception) {}
            cacheFile.delete()
        }
    }

    /**
     * Segmented PDF import that processes page ranges by content role.
     *
     * When [segments] is empty or contains only [PdfSegmentRole.AUTO] segments,
     * this falls through to the standard [importPdf] behaviour.
     *
     * For multi-role configurations the engine:
     * 1. OCRs each segment's page range at full 2x DPI.
     * 2. Routes text to the correct role-specific parser.
     * 3. Merges ANSWER_KEY and EXPLANATION maps into cards by Q-number.
     */
    suspend fun importSegmented(
        context: Context,
        uri: Uri,
        segments: List<PdfSegmentConfig>,
        duplicateStrategy: String = "IMPORT",
        targetDeckId: Long? = null,
        targetDeckName: String? = null,
        columnMode: PdfColumnMode = PdfColumnMode.AUTO,
        languageFilter: PdfLanguageFilter = PdfLanguageFilter.BOTH,
        onProgress: (currentPage: Int, totalPages: Int, status: String) -> Unit = { _, _, _ -> }
    ): ImportResult = withContext(Dispatchers.IO) {
        // Check if there is a custom page range or non-AUTO role
        val isFullDocAuto = segments.size == 1 &&
                segments[0].role == PdfSegmentRole.AUTO &&
                segments[0].pageStart <= 1 &&
                segments[0].pageEnd >= 99999
        if (segments.isEmpty() || isFullDocAuto) {
            return@withContext importPdf(
                context, uri, duplicateStrategy, targetDeckId, targetDeckName, columnMode, languageFilter, onProgress
            )
        }

        val repo = AnkiDataRepository.getInstance(context)
        val fileName = repo.getFileName(uri)
        Log.i(TAG, "Starting SEGMENTED PDF import: $fileName (${segments.size} segments)")

        val db = AppDatabase.getInstance(context)
        val cardDao = db.cardDao()
        val deckDao = db.deckDao()

        val cacheFile = File(context.cacheDir, "seg_import_${System.currentTimeMillis()}.pdf")
        var pfd: ParcelFileDescriptor? = null
        var renderer: PdfRenderer? = null
        val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

        try {
            onProgress(0, 1, "Opening PDF document...")
            context.contentResolver.openInputStream(uri)?.use { input ->
                FileOutputStream(cacheFile).use { output -> input.copyTo(output) }
            } ?: throw IllegalArgumentException("Cannot open PDF URI: $uri")

            pfd = ParcelFileDescriptor.open(cacheFile, ParcelFileDescriptor.MODE_READ_ONLY)
            renderer = PdfRenderer(pfd)
            val pageCount = renderer.pageCount

            val baseDeckName = targetDeckName?.ifBlank { null }
                ?: fileName.removeSuffix(".pdf").removeSuffix(".PDF").trim().ifEmpty { "Imported PDF" }
            val finalDeckId = targetDeckId ?: (baseDeckName.hashCode().toLong() and 0x7FFFFFFF)

            // Track total pages across all segments for progress reporting
            val totalPagesToProcess = segments.sumOf {
                it.pageEndIndex(pageCount) - it.pageStartIndex + 1
            }.coerceAtLeast(1)
            var pagesProcessed = 0

            // Containers for merged data
            val questionTextBySegment = mutableListOf<String>()     // QUESTIONS / AUTO segments
            val answerKeyMap = mutableMapOf<Int, String>()           // Q-number → correct option letter
            val explanationMap = mutableMapOf<Int, String>()         // Q-number → explanation text

            for (segment in segments) {
                val startIdx = segment.pageStartIndex
                val endIdx = segment.pageEndIndex(pageCount)
                val segTextBuilder = StringBuilder()

                for (pageIndex in startIdx..endIdx) {
                    val progressMsg = "[${segment.role.displayName}] Reading page ${pageIndex + 1}..."
                    onProgress(pagesProcessed + 1, totalPagesToProcess, progressMsg)

                    val page = renderer.openPage(pageIndex)
                    val baseW = page.width
                    val baseH = page.height
                    val maxDim = maxOf(baseW, baseH)
                    val scale = if (maxDim > 0) minOf(RENDER_DPI_SCALE, 2048f / maxDim) else RENDER_DPI_SCALE
                    val width = (baseW * scale).toInt().coerceAtLeast(100)
                    val height = (baseH * scale).toInt().coerceAtLeast(100)
                    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
                    page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
                    page.close()

                    try {
                        val inputImage = InputImage.fromBitmap(bitmap, 0)
                        val visionText = Tasks.await(
                            recognizer.process(inputImage), 25, java.util.concurrent.TimeUnit.SECONDS
                        )
                        val pageText = segmentPageIntoColumns(visionText, width.toFloat(), columnMode)
                        segTextBuilder.append(pageText).append("\n")
                    } catch (e: Exception) {
                        Log.w(TAG, "OCR timeout on page ${pageIndex + 1}: ${e.message}")
                    } finally {
                        bitmap.recycle()
                        pagesProcessed++
                    }
                }

                val segText = PyqTextNormalizer.normalizeText(segTextBuilder.toString())

                when (segment.role) {
                    PdfSegmentRole.QUESTIONS, PdfSegmentRole.AUTO -> {
                        questionTextBySegment.add(segText)
                    }
                    PdfSegmentRole.ANSWER_KEY -> {
                        val extracted = parseAnswerKey(segText)
                        answerKeyMap.putAll(extracted)
                        Log.i(TAG, "Answer key segment '${segment.label}': ${extracted.size} entries")
                    }
                    PdfSegmentRole.EXPLANATION -> {
                        val extracted = parseExplanations(segText)
                        explanationMap.putAll(extracted)
                        Log.i(TAG, "Explanation segment '${segment.label}': ${extracted.size} entries")
                    }
                }
            }

            onProgress(totalPagesToProcess, totalPagesToProcess, "Structuring cards from ${questionTextBySegment.size} question segment(s)...")

            // Parse cards from all question segments combined and merge external answer key and explanations directly
            val combinedQuestionText = questionTextBySegment.joinToString("\n")
            val extractedCards = parseExtractedQuestions(
                text = combinedQuestionText,
                deckName = baseDeckName,
                deckId = finalDeckId,
                externalAnswerKeyMap = answerKeyMap,
                externalExplanationMap = explanationMap,
                languageFilter = languageFilter
            )

            if (extractedCards.isEmpty()) {
                return@withContext ImportResult(
                    success = false,
                    fileName = fileName,
                    totalDecks = 0,
                    totalNotes = 0,
                    totalCards = 0,
                    error = "No questions found. Verify that the QUESTIONS segment page range contains numbered MCQ questions."
                )
            }

            onProgress(totalPagesToProcess, totalPagesToProcess, "Saving ${extractedCards.size} cards...")

            db.withTransaction {
                if (targetDeckId == null) {
                    val existingDeck = deckDao.getDeckById(finalDeckId)
                    if (existingDeck == null) {
                        deckDao.upsertDeck(
                            DeckEntity(
                                id = finalDeckId,
                                name = baseDeckName,
                                fullPath = baseDeckName,
                                parentDeckId = null,
                                cardCount = extractedCards.size,
                                lastSyncTimestamp = System.currentTimeMillis()
                            )
                        )
                    }
                }
                for (card in extractedCards) {
                    when (duplicateStrategy) {
                        "SKIP" -> {
                            val exists = cardDao.getCardsForDeckOnce(card.deckId).any {
                                it.front.trim().equals(card.front.trim(), ignoreCase = true)
                            }
                            if (!exists) cardDao.insertCard(card)
                        }
                        "UPDATE" -> {
                            val existing = cardDao.getCardsForDeckOnce(card.deckId).firstOrNull {
                                it.front.trim().equals(card.front.trim(), ignoreCase = true)
                            }
                            if (existing != null) cardDao.updateCard(card.copy(id = existing.id))
                            else cardDao.insertCard(card)
                        }
                        else -> cardDao.insertCard(card)
                    }
                }
                val actualCount = cardDao.getCardCountForDeck(finalDeckId)
                val targetDeck = deckDao.getDeckById(finalDeckId)
                if (targetDeck != null) deckDao.updateDeck(targetDeck.copy(cardCount = actualCount))
            }

            Log.i(TAG, "Segmented import done: ${extractedCards.size} cards into '$baseDeckName'")
            ImportResult(
                success = true,
                fileName = fileName,
                totalDecks = 1,
                totalNotes = extractedCards.size,
                totalCards = extractedCards.size,
                sampleCards = extractedCards.take(5)
            )
        } catch (e: Exception) {
            Log.e(TAG, "importSegmented failed: ${e.message}", e)
            ImportResult(
                success = false,
                fileName = fileName,
                totalDecks = 0,
                totalNotes = 0,
                totalCards = 0,
                error = e.localizedMessage ?: "Unknown segmented import error."
            )
        } finally {
            try { recognizer.close() } catch (_: Exception) {}
            try { renderer?.close() } catch (_: Exception) {}
            try { pfd?.close() } catch (_: Exception) {}
            cacheFile.delete()
        }
    }

    /**
     * Parses an answer-key page into a map of [questionNumber → correctOptionLetter].
     *
     * Handles formats:
     *  - "1. (b)"  "1-B"  "1) b"  "Ans 1: B"  "1 → C"  "1 b" (space separated)
     *  - Multi-column answer key grids
     */
    fun parseAnswerKey(text: String): Map<Int, String> {
        val result = mutableMapOf<Int, String>()
        fun normalizeKey(raw: String): String = when (raw.trim().uppercase()) {
            "1", "I", "ONE"   -> "A"
            "2", "II", "TWO"  -> "B"
            "3", "III", "THREE" -> "C"
            "4", "IV", "FOUR" -> "D"
            "5", "V", "FIVE"  -> "E"
            else              -> raw.trim().uppercase()
        }

        // Pattern: optional label then (number)(separator)(option)
        // Covers: "1. (b)", "1-b", "1) b", "Ans 1: B", "1→C", "1 b", "Q1: A", "(1) B"
        val pattern = Regex(
            "(?i)" +
            "(?:Ans(?:wer)?\\s*\\.?\\s*|Q(?:uestion|ue)?\\.?\\s*)?" +
            "\\(?(\\d{1,4})\\)?" +
            "\\s*[.:\\-→=)\\s]\\s*" +
            "\\(?([a-e1-5]|i{1,3}|iv|v)\\)?"
        )

        for (line in text.split("\n")) {
            val t = line.trim()
            // Skip lines that look like headings or boilerplate
            if (t.isBlank() || t.length > 200) continue
            // Extract ALL matches per line (multi-answer key grids have many per line)
            for (match in pattern.findAll(t)) {
                val num = match.groupValues[1].toIntOrNull() ?: continue
                val letter = normalizeKey(match.groupValues[2])
                if (num > 0 && letter.isNotBlank()) {
                    result[num] = letter
                }
            }
        }
        return result
    }

    /**
     * Parses an explanation page into a map of [questionNumber → explanationText].
     *
     * Handles headers like:
     *  - "Sol. 1."  "1. Explanation:"  "Ans. (1):"  "Q.1 Exp:"  "Solution to Q1"
     */
    fun parseExplanations(text: String): Map<Int, String> {
        val result = mutableMapOf<Int, String>()
        val lines = text.split("\n")

        // Header patterns that start a new explanation block: "Sol. 1.", "1. Explanation:", "Ans. (1):", "Q.1 Exp:", "1."
        val headerPattern = Regex(
            "(?i)" +
            "^\\s*(?:Sol(?:ution)?\\.?|Exp(?:lanation)?\\.?|Q(?:uestion|ue)?\\.?|Ans(?:wer)?\\.?\\s*\\(?)?\\s*" +
            "\\(?(\\d{1,4})\\)?" +
            "[).:\\-]?\\s*(.*)"
        )

        var currentNum: Int? = null
        val buffer = StringBuilder()

        fun flushCurrent() {
            val num = currentNum ?: return
            val expl = buffer.toString().trim()
            if (expl.isNotBlank()) result[num] = expl
            buffer.clear()
            currentNum = null
        }

        for (line in lines) {
            val t = line.trim()
            if (t.isBlank()) continue

            val headerMatch = headerPattern.find(t)
            if (headerMatch != null) {
                flushCurrent()
                currentNum = headerMatch.groupValues[1].toIntOrNull()
                val remainder = headerMatch.groupValues[2].trim()
                if (remainder.isNotBlank()) buffer.append(remainder)
            } else if (currentNum != null) {
                // Continuation line for current explanation
                if (buffer.isNotEmpty()) buffer.append(" ")
                buffer.append(t)
            }
        }
        flushCurrent()
        return result
    }

    /**
     * Merges an external answer key map and explanation map into parsed [CardEntity] list.
     *
     * Each card's Q-number is inferred from its `front` text (the leading number in the question).
     * If a match is found, the card's `back` field is rebuilt with the correct answer and explanation.
     */
    private fun mergeKeyAndExplanationsIntoCards(
        cards: List<CardEntity>,
        answerKeyMap: Map<Int, String>,
        explanationMap: Map<Int, String>
    ): List<CardEntity> {
        if (answerKeyMap.isEmpty() && explanationMap.isEmpty()) return cards

        val qNumRegex = Regex("^(?:Q\\.?|Question\\.?)?\\s*(\\d{1,4})[.:\\-)\\s]")

        return cards.map { card ->
            val qNum = qNumRegex.find(card.front)?.groupValues?.get(1)?.toIntOrNull()
                ?: return@map card  // Can't determine Q-number → pass through unchanged

            val newExplanation = explanationMap[qNum]
            val newAnswerLetter = answerKeyMap[qNum]

            if (newAnswerLetter == null && newExplanation == null) return@map card

            // Rebuild back field: "CorrectAnswer | opt1 | opt2 | opt3 {explain} explanation"
            val existingBack = card.back
            val explSplit = existingBack.split(" {explain} ", limit = 2)
            val optionsPart = explSplit.getOrElse(0) { existingBack }
            val existingExpl = explSplit.getOrElse(1) { "" }

            val newBack = buildString {
                if (newAnswerLetter != null) {
                    // Re-map answer in the options string: swap the first token (current answer) with new one
                    val parts = optionsPart.split(" | ")
                    if (parts.size >= 2) {
                        // Find the option text that corresponds to the key letter
                        val optMap = mapOf(
                            "A" to parts.getOrElse(0) { "" },
                            "B" to parts.getOrElse(1) { "" },
                            "C" to parts.getOrElse(2) { "" },
                            "D" to parts.getOrElse(3) { "" },
                            "E" to parts.getOrElse(4) { "" }
                        )
                        val correctText = optMap[newAnswerLetter.uppercase()] ?: parts[0]
                        val distractors = parts.filter { it != correctText }
                        append(correctText)
                        if (distractors.isNotEmpty()) append(" | ").append(distractors.joinToString(" | "))
                    } else {
                        append(optionsPart) // Single-answer card — keep as-is
                    }
                } else {
                    append(optionsPart)
                }
                val finalExpl = (newExplanation ?: existingExpl).trim()
                if (finalExpl.isNotEmpty() && finalExpl != "NA") {
                    append(" {explain} ").append(finalExpl)
                }
            }
            card.copy(back = newBack)
        }
    }

    /**
     * Segments recognized text blocks into columns using horizontal histogram gutter detection.
     */
    fun segmentPageIntoColumns(
        visionText: Text,
        pageWidth: Float,
        columnMode: PdfColumnMode
    ): String {
        val blocks = visionText.textBlocks
        if (blocks.isEmpty()) return ""

        // Separate full-width spanning headers (e.g. Chapter titles spanning across columns)
        val spanningThreshold = pageWidth * 0.72f
        val spanningHeaders = mutableListOf<Text.TextBlock>()
        val bodyBlocks = mutableListOf<Text.TextBlock>()

        for (block in blocks) {
            val rect = block.boundingBox ?: Rect(0, 0, 0, 0)
            if (rect.width() >= spanningThreshold) {
                spanningHeaders.add(block)
            } else {
                bodyBlocks.add(block)
            }
        }

        // Determine column division lines (gutters)
        val gutters = when (columnMode) {
            PdfColumnMode.SINGLE -> emptyList()
            PdfColumnMode.TWO_COLUMN -> listOf(pageWidth * 0.5f)
            PdfColumnMode.THREE_COLUMN -> listOf(pageWidth * 0.33f, pageWidth * 0.66f)
            PdfColumnMode.AUTO -> detectGuttersAdaptive(bodyBlocks, pageWidth)
        }

        if (gutters.isEmpty()) {
            // 1 Column: natural top-to-bottom
            return blocks.sortedBy { it.boundingBox?.top ?: 0 }
                .joinToString("\n") { it.text }
        }

        // Group body blocks into columns based on horizontal center
        val columns = List(gutters.size + 1) { mutableListOf<Text.TextBlock>() }

        for (block in bodyBlocks) {
            val rect = block.boundingBox ?: Rect(0, 0, 0, 0)
            val cx = rect.exactCenterX()

            var colIndex = gutters.indexOfFirst { cx < it }
            if (colIndex == -1) colIndex = gutters.size
            columns[colIndex].add(block)
        }

        // Sort each column top-to-bottom and concatenate
        val pageBuilder = StringBuilder()

        // Spanning headers placed at top
        if (spanningHeaders.isNotEmpty()) {
            spanningHeaders.sortedBy { it.boundingBox?.top ?: 0 }.forEach {
                pageBuilder.append(it.text).append("\n")
            }
        }

        // Output column 1, then column 2, etc.
        for (col in columns) {
            col.sortedBy { it.boundingBox?.top ?: 0 }.forEach {
                pageBuilder.append(it.text).append("\n")
            }
        }

        return pageBuilder.toString()
    }

    /**
     * Projects bounding boxes onto a 100-bin horizontal density histogram to locate whitespace gutters.
     */
    private fun detectGuttersAdaptive(blocks: List<Text.TextBlock>, pageWidth: Float): List<Float> {
        if (blocks.size < 4 || pageWidth <= 0f) return emptyList()

        val bins = FloatArray(100)
        for (block in blocks) {
            val rect = block.boundingBox ?: continue
            val startBin = ((rect.left.toFloat() / pageWidth) * 100).toInt().coerceIn(0, 99)
            val endBin = ((rect.right.toFloat() / pageWidth) * 100).toInt().coerceIn(0, 99)
            for (i in startBin..endBin) {
                bins[i] += 1f
            }
        }

        // Search for valleys in typical column transition zones:
        // 2-column center: [40..60]
        // 3-column splits: [25..40] and [60..75]
        val gutters = mutableListOf<Float>()

        val centerMin = (40..60).minByOrNull { bins[it] } ?: 50
        val centerPeakLeft = (20..38).maxOfOrNull { bins[it] } ?: 0f
        val centerPeakRight = (62..80).maxOfOrNull { bins[it] } ?: 0f

        // Check for 3-column layout first (distinct dips around 33% and 66%)
        val valley1 = (27..38).minByOrNull { bins[it] } ?: 33
        val valley2 = (62..73).minByOrNull { bins[it] } ?: 66
        val peak1 = (10..24).maxOfOrNull { bins[it] } ?: 0f
        val peak2 = (42..58).maxOfOrNull { bins[it] } ?: 0f
        val peak3 = (76..90).maxOfOrNull { bins[it] } ?: 0f

        val is3Column = peak1 > 2f && peak2 > 2f && peak3 > 2f &&
                bins[valley1] <= peak1 * 0.4f && bins[valley2] <= peak3 * 0.4f

        if (is3Column) {
            gutters.add((valley1 / 100f) * pageWidth)
            gutters.add((valley2 / 100f) * pageWidth)
            return gutters
        }

        // Check for 2-column layout (distinct valley in center)
        val is2Column = centerPeakLeft > 2f && centerPeakRight > 2f &&
                bins[centerMin] <= (centerPeakLeft + centerPeakRight) / 2f * 0.45f

        if (is2Column) {
            gutters.add((centerMin / 100f) * pageWidth)
            return gutters
        }

        // Default to single column if no strong gutter valleys are detected
        return emptyList()
    }

    /**
     * Parses questions, options (letters/numbers/inline), answer keys, and explanations from booklet text.
     */
    fun parseExtractedQuestions(
        text: String,
        deckName: String,
        deckId: Long,
        externalAnswerKeyMap: Map<Int, String> = emptyMap(),
        externalExplanationMap: Map<Int, String> = emptyMap(),
        languageFilter: PdfLanguageFilter = PdfLanguageFilter.BOTH
    ): List<CardEntity> {
        val lines = text.split("\n")

        data class RawQuestion(
            val qNum: Int?,
            var questionText: String = "",
            val options: MutableMap<String, String> = linkedMapOf(), // "A", "B", "C", "D", "E"
            var answerLetter: String? = null,
            var explanation: String = "",
            val subject: String
        )

        val rawQuestions = mutableListOf<RawQuestion>()
        val answerKeyMap = mutableMapOf<Int, String>()

        var currentSubject = deckName
        var currentQuestion: RawQuestion? = null
        var isCollectingQuestion = false
        var isCollectingExplanation = false
        var lastOptionKey = "A"
        var inAnswerKeySection = false

        fun normalizeKey(raw: String): String {
            return when (raw.trim().uppercase()) {
                "1", "I", "ONE" -> "A"
                "2", "II", "TWO" -> "B"
                "3", "III", "THREE" -> "C"
                "4", "IV", "FOUR" -> "D"
                "5", "V", "FIVE" -> "E"
                else -> raw.trim().uppercase()
            }
        }

        fun extractOptionsFromLine(line: String): List<Pair<String, String>> {
            // Supports (A), [A], A., A), A:, 1., (1), [1], 1), (i), (ii), (iii), (iv), i., ii.
            val markerRegex = Regex("(?i)(?:^|\\s+)(?:\\(([a-e1-5]|i{1,3}|iv|v)\\)|\\[([a-e1-5]|i{1,3}|iv|v)\\]|([a-e1-5]|i{1,3}|iv|v)[.):\\-])\\s+")
            val matches = markerRegex.findAll(line).toList()
            if (matches.isEmpty()) return emptyList()

            // If line doesn't start with a marker, only treat as inline options if 2+ markers exist
            val startsWithMarker = markerRegex.find(line.trimStart())?.range?.first == 0
            if (!startsWithMarker && matches.size < 2) return emptyList()

            val list = mutableListOf<Pair<String, String>>()
            for (i in matches.indices) {
                val match = matches[i]
                val rawKey = match.groupValues.drop(1).firstOrNull { it.isNotBlank() } ?: "A"
                val key = normalizeKey(rawKey)
                val textStart = match.range.last + 1
                val textEnd = if (i + 1 < matches.size) matches[i + 1].range.first else line.length
                val optContent = line.substring(textStart, textEnd).trim()
                list.add(key to optContent)
            }
            return list
        }

        val inlineAnsRegex = Regex("(?i)\\[?(?:Ans(?:wer)?|Correct(?:\\s*(?:Option|Answer))?|Right\\s*Answer|Key)\\s*[:.\\-=]?\\s*\\(?([a-e1-5]|i{1,3}|iv|v)\\)?\\]?")

        fun isQuestionLine(line: String): Boolean {
            val t = line.trim()
            if (PyqTextNormalizer.isIgnorableNoteOrBoilerplate(t)) return false
            // Question markers: "1.", "101.", "Q1.", "Q.1", "Question 1:", "Q:", "Prob 1.", "Item 1."
            if (Regex("^(?i)(?:Q(?:uestion|ue)?\\.?|Prob(?:lem)?\\.?|Item\\.?)\\s*\\d{1,4}[.:\\-)]\\s*.*").matches(t)) return true
            if (Regex("^\\d{1,4}[.:\\-)]\\s+.*").matches(t)) return true
            if (Regex("^(?i)Q(?:uestion|ue)?\\s*[:.]\\s*.*").matches(t)) return true
            // Question mark at end of sentence
            if (t.endsWith("?") && t.length in 10..350) return true
            // True / False statements: "1. The Earth is flat. (True/False)"
            if (Regex("(?i)\\((?:True\\s*/\\s*False|T\\s*/\\s*F|Yes\\s*/\\s*No)\\)").containsMatchIn(t)) return true
            // Fill in the blanks: Contains "_______" or "......" with question framing
            if (Regex("_{3,}|\\.{4,}").containsMatchIn(t) && t.length in 10..300) return true
            // One-liner question-answer pattern: "Capital of India - New Delhi" or "Q: Who was... Ans: ..."
            if (Regex("(?i)^(?:Who|What|Where|When|Why|Which|How|Name|Define|State|Identify|Explain briefly|Capital of|Founder of|Full form of|Unit of)\\b").containsMatchIn(t) &&
                (t.contains("-") || t.contains(":") || t.contains("—") || t.contains("Ans", ignoreCase = true))) {
                return true
            }
            return false
        }

        fun isOptionsLine(line: String, currentQ: RawQuestion?): Boolean {
            val t = line.trim()
            if (t.endsWith("?") || t.contains("?")) return false
            // If current question already has an answer or explanation, it is finished; next line is never its option
            if (currentQ != null && (currentQ.answerLetter != null || currentQ.explanation.isNotEmpty())) {
                return false
            }
            // Check if line contains one-liner delimiter with answer
            if (Regex("^\\d{1,4}[.:\\-)].*(?:\\s+-\\s+|\\s+:\\s+|\\s+—\\s+|\\s+->\\s+)").containsMatchIn(t)) {
                return false
            }
            val markerRegex = Regex("(?i)(?:^|\\s+)(?:\\(([a-e1-5]|i{1,3}|iv|v)\\)|\\[([a-e1-5]|i{1,3}|iv|v)\\]|([a-e]|i{1,3}|iv|v)[.):\\-]|([1-5])[.):\\-])\\s+")
            val matches = markerRegex.findAll(t).toList()
            if (matches.isEmpty()) return false
            if (matches.size >= 2) return true

            val startsWithMarker = markerRegex.find(t)?.range?.first == 0
            if (startsWithMarker) {
                // If marker is a bare number like "2." or "3." (without parens):
                val isBareNumber = Regex("^\\d{1,4}[.:\\-]\\s+").containsMatchIn(t)
                if (isBareNumber) {
                    if (currentQ != null && currentQ.options.containsKey("A") && !currentQ.options.containsKey("B")) {
                        return t.length < 100
                    }
                    return false // Bare "1.", "2." is a Question!
                }
                val words = t.split(Regex("\\s+"))
                val firstWordAfterMarker = words.getOrNull(1)?.lowercase() ?: ""
                val questionStarters = setOf(
                    "who", "what", "which", "where", "when", "why", "how", "name", "define", "identify",
                    "question", "first", "second", "the", "in", "at", "during", "is", "are", "was", "were"
                )
                if (firstWordAfterMarker in questionStarters && (t.length > 30 || t.contains("?"))) return false
                return true
            }
            return false
        }

        for (line in lines) {
            var trimmed = line.trim()
            if (trimmed.isEmpty()) continue

            // 0. Skip study notes and editorial boilerplate
            if (PyqTextNormalizer.isIgnorableNoteOrBoilerplate(trimmed)) {
                // If we were collecting notes/explanation, stop collecting
                isCollectingExplanation = false
                isCollectingQuestion = false
                continue
            }

            // 1. Detect Answer Key section header (e.g. "Answers", "Answer Key", "Solutions", "Keys", "Correct Answers")
            val isAnswerKeyHeader = Regex("(?i)^(?:Answers?(?:\\s*Key)?|Key(?:\\s*Answers?)?|Solutions?|Answer\\s*Sheet|Correct\\s*Answers?)\\s*[:.]?$")
                .containsMatchIn(trimmed)
            if (isAnswerKeyHeader) {
                inAnswerKeySection = true
                if (currentQuestion != null) {
                    rawQuestions.add(currentQuestion)
                    currentQuestion = null
                }
                continue
            }

            // 2. If in Answer Key section, extract mappings: e.g. "1. (b) 2. (c)" or "1-A, 2-C" or "1. B, 2. D"
            if (inAnswerKeySection) {
                val keyMatches = Regex("(?i)(?:^|\\s)(?:Q(?:uestion|ue)?\\.?\\s*)?(\\d{1,4})\\s*[:.\\-)]?\\s*\\(?([a-e1-5]|i{1,3}|iv|v)\\)?")
                    .findAll(trimmed)
                for (km in keyMatches) {
                    val num = km.groupValues[1].toIntOrNull()
                    val ans = normalizeKey(km.groupValues[2])
                    if (num != null) answerKeyMap[num] = ans
                }
                continue
            }

            // 3. Subject Chapter detection
            val detectedSubj = PyqMetadataExtractor.detectSubject(trimmed)
            if (detectedSubj != null) {
                if (currentQuestion != null) {
                    rawQuestions.add(currentQuestion)
                    currentQuestion = null
                }
                currentSubject = detectedSubj
                continue
            }

            // Check if this line looks like an options line
            val optLine = isOptionsLine(trimmed, currentQuestion)

            // 4. Question Start detection: e.g. "1.", "101.", "Q1.", "Q. 1", "Question 1:", "Prob 1.", or ending with '?'
            val qStartRegex = Regex("(?i)^(?:(?:Q(?:uestion|ue)?\\.?|Prob(?:lem)?\\.?|Item\\.?)\\s*[-.:]?\\s*\\(?(\\d{1,4})\\)?[.:\\-)]?|\\(?(\\d{1,4})\\)?[.:\\-)]|\\((\\d{1,4})\\)|\\[(\\d{1,4})\\])(?:\\s+(.*))?$")
            val qStartMatch = if (optLine && currentQuestion != null) null else qStartRegex.find(trimmed)
            if (qStartMatch != null || (!optLine && isQuestionLine(trimmed) && !trimmed.startsWith("Ans", ignoreCase = true))) {
                if (currentQuestion != null) {
                    rawQuestions.add(currentQuestion)
                }
                val qNum = if (qStartMatch != null) {
                    listOf(qStartMatch.groupValues[1], qStartMatch.groupValues[2], qStartMatch.groupValues[3], qStartMatch.groupValues[4])
                        .firstOrNull { it.isNotBlank() }?.toIntOrNull()
                } else {
                    Regex("^\\D*?(\\d{1,4})\\b").find(trimmed)?.groupValues?.get(1)?.toIntOrNull()
                }
                var inlineText = if (qStartMatch != null) (qStartMatch.groupValues[5] ?: "").trim().ifEmpty { trimmed } else trimmed
                inlineText = PyqTextNormalizer.cleanQuestionStatement(inlineText)
                var detectedAns: String? = null

                val ansInQMatch = inlineAnsRegex.find(inlineText)
                if (ansInQMatch != null) {
                    detectedAns = normalizeKey(ansInQMatch.groupValues[1])
                    inlineText = inlineText.removeRange(ansInQMatch.range).trim()
                }

                currentQuestion = RawQuestion(
                    qNum = qNum,
                    questionText = inlineText,
                    answerLetter = detectedAns,
                    subject = currentSubject
                )
                isCollectingQuestion = true
                isCollectingExplanation = false
                continue
            }

            // 5. Check for inline answer tag inside line: e.g. "[Ans: (b)]" or "(Ans: 2)"
            val inlineAnsMatch = inlineAnsRegex.find(trimmed)
            if (inlineAnsMatch != null && currentQuestion != null) {
                currentQuestion.answerLetter = normalizeKey(inlineAnsMatch.groupValues[1])
                // Remove answer tag from text line
                trimmed = trimmed.removeRange(inlineAnsMatch.range).trim()
                if (trimmed.isEmpty()) continue
            }

            // 6. Option Detection: Supports inline options (a)..(d) on single or multi-line
            val extractedOpts = extractOptionsFromLine(trimmed)
            if (extractedOpts.isNotEmpty() && currentQuestion != null) {
                isCollectingQuestion = false
                isCollectingExplanation = false
                for ((key, textVal) in extractedOpts) {
                    currentQuestion.options[key] = textVal
                    lastOptionKey = key
                }
                continue
            }

            // 7. Answer detection on separate line: "Ans: (a)", "Ans. (2)", "Answer: C", "Ans - B", "Correct Option: 3"
            val ansLineMatch = Regex("(?i)^(?:Ans(?:wer)?|Correct(?:\\s*(?:Option|Answer))?|Right\\s*Answer|Key)\\s*[:.\\-=]?\\s*\\(?([a-e1-5]|i{1,3}|iv|v)\\)?(?:\\s*(.*))?$")
                .find(trimmed)
            if (ansLineMatch != null && currentQuestion != null) {
                currentQuestion.answerLetter = normalizeKey(ansLineMatch.groupValues[1])
                isCollectingQuestion = false
                isCollectingExplanation = true
                val remaining = ansLineMatch.groupValues[2].trim()
                if (remaining.isNotEmpty()) {
                    currentQuestion.explanation += " " + remaining
                }
                continue
            }

            // 8. Explanation Header line: "Expl: ...", "Explanation: ..."
            val explMatch = Regex("(?i)^Expl(?:anation)?\\s*[:-]+\\s*(.*)").find(trimmed)
            if (explMatch != null && currentQuestion != null) {
                isCollectingQuestion = false
                isCollectingExplanation = true
                currentQuestion.explanation += " " + explMatch.groupValues[1].trim()
                continue
            }

            // 9. Continuation lines
            if (currentQuestion != null) {
                if (isCollectingExplanation) {
                    currentQuestion.explanation += " " + trimmed
                } else if (isCollectingQuestion) {
                    // Check if line looks like an answer or note
                    if (trimmed.startsWith("Ans", ignoreCase = true) || trimmed.startsWith("Answer", ignoreCase = true)) {
                        val ansPart = trimmed.replace(Regex("(?i)^Ans(?:wer)?\\s*[:.\\-=]?\\s*"), "").trim()
                        if (ansPart.isNotEmpty()) {
                            currentQuestion.answerLetter = ansPart
                            isCollectingQuestion = false
                            isCollectingExplanation = true
                        }
                    } else {
                        currentQuestion.questionText += " " + trimmed
                    }
                } else if (currentQuestion.options.containsKey(lastOptionKey)) {
                    // Multi-line option continuation (only if not a new note/header)
                    currentQuestion.options[lastOptionKey] = (currentQuestion.options[lastOptionKey] ?: "") + " " + trimmed
                }
            }
        }

        if (currentQuestion != null) {
            rawQuestions.add(currentQuestion)
        }

        // Reconcile and build CardEntities
        val result = mutableListOf<CardEntity>()

        for (q in rawQuestions) {
            val rawStatement = q.questionText.trim()
            if (rawStatement.isBlank()) continue

            // Filter out general prose / book notes that accidentally got treated as questions
            if (PyqTextNormalizer.isIgnorableNoteOrBoilerplate(rawStatement)) continue
            // If statement is a huge long paragraph (>600 chars) with 0 options and no answer, it's theory notes -> ignore
            if (q.options.isEmpty() && q.answerLetter == null && rawStatement.length > 350) continue

            val qStatement = PyqTextNormalizer.cleanQuestionStatement(rawStatement).trim()
            if (qStatement.isBlank()) continue

            // Reconcile answer letter from Answer Key if not present inline
            val resolvedAnsLetter = q.answerLetter
                ?: (if (q.qNum != null) (externalAnswerKeyMap[q.qNum] ?: answerKeyMap[q.qNum]) else null)
                ?: "A"

            val extExpl = if (q.qNum != null) externalExplanationMap[q.qNum] else null
            val inlineExpl = PyqTextNormalizer.normalizeText(q.explanation).trim()
            val safeExpl = when {
                inlineExpl.isNotEmpty() && inlineExpl != "NA" && !extExpl.isNullOrBlank() -> "$inlineExpl\n$extExpl"
                !extExpl.isNullOrBlank() -> extExpl.trim()
                inlineExpl.isNotEmpty() && inlineExpl != "NA" -> inlineExpl
                else -> ""
            }
            val cardId = (System.currentTimeMillis() + result.size) and 0x7FFFFFFF

            if (q.options.size >= 2) {
                // MCQ Card format
                val optA = PyqTextNormalizer.cleanOptionText(q.options["A"] ?: "").ifEmpty { "Option A" }
                val optB = PyqTextNormalizer.cleanOptionText(q.options["B"] ?: "").ifEmpty { "Option B" }
                val optC = PyqTextNormalizer.cleanOptionText(q.options["C"] ?: "").ifEmpty { "Option C" }
                val optD = PyqTextNormalizer.cleanOptionText(q.options["D"] ?: "").ifEmpty { "Option D" }

                val targetAnswerText = when (resolvedAnsLetter.uppercase()) {
                    "A", "1" -> optA
                    "B", "2" -> optB
                    "C", "3" -> optC
                    "D", "4" -> optD
                    "E", "5" -> PyqTextNormalizer.cleanOptionText(q.options["E"] ?: "").ifEmpty { "Option E" }
                    else -> {
                        val matchingOpt = listOf(optA, optB, optC, optD).firstOrNull {
                            it.equals(resolvedAnsLetter, ignoreCase = true)
                        }
                        matchingOpt ?: optA
                    }
                }

                val optionsList = listOfNotNull(
                    optA, optB, optC, optD,
                    q.options["E"]?.let { PyqTextNormalizer.cleanOptionText(it) }
                )
                val distractorList = optionsList.filter { it != targetAnswerText }

                val backContent = buildString {
                    append(targetAnswerText)
                    append(" | ")
                    append(distractorList.joinToString(" | "))
                    if (safeExpl.isNotEmpty() && safeExpl != "NA") {
                        append(" {explain} ")
                        append(safeExpl)
                    }
                }

                val (finalFront, finalBack) = when (languageFilter) {
                    PdfLanguageFilter.ENGLISH_ONLY -> {
                        // Extract only the English portion
                        val englishFront = extractScriptText(qStatement, preferDevanagari = false)
                        val englishBack = extractScriptText(backContent, preferDevanagari = false)
                        englishFront to englishBack
                    }
                    PdfLanguageFilter.HINDI_ONLY -> {
                        // Extract only the Hindi (Devanagari) portion
                        val hindiFront = extractScriptText(qStatement, preferDevanagari = true)
                        val hindiBack = extractScriptText(backContent, preferDevanagari = true)
                        hindiFront to hindiBack
                    }
                    PdfLanguageFilter.BOTH -> {
                        // If statement has both English and Hindi lines, format with bilingual delimiter
                        val devanagariCount = qStatement.count { it in '\u0900'..'\u097F' }
                        val latinCount = qStatement.count { it in 'a'..'z' || it in 'A'..'Z' }
                        if (devanagariCount >= 5 && latinCount >= 5 && !qStatement.contains(" ||| ")) {
                            // Split statement into English and Hindi parts
                            val enPart = extractScriptText(qStatement, preferDevanagari = false)
                            val hiPart = extractScriptText(qStatement, preferDevanagari = true)
                            if (enPart.isNotBlank() && hiPart.isNotBlank() && enPart != hiPart) {
                                "$enPart ||| $hiPart" to backContent
                            } else {
                                qStatement to backContent
                            }
                        } else {
                            qStatement to backContent
                        }
                    }
                }

                result.add(
                    CardEntity(
                        id = cardId,
                        noteId = cardId,
                        deckId = deckId,
                        front = finalFront,
                        back = finalBack,
                        tags = q.subject,
                        deckHierarchy = deckName
                    )
                )
            } else {
                // One-liner / Direct Q&A flashcard:
                // Check if the statement itself contains delimiters (e.g. " - ", " : ", " = ", " -> ", or "Ans: ")
                var frontText = qStatement
                var answerContent = q.options.values.firstOrNull() ?: q.answerLetter ?: ""

                if (answerContent.isBlank()) {
                    // Try splitting one-liner on standard answer delimiters
                    val delimiters = listOf(" - ", " : ", " — ", " – ", " = ", " -> ", " : - ")
                    var foundIdx = -1
                    var delimLen = 0

                    for (delim in delimiters) {
                        val idx = frontText.indexOf(delim)
                        if (idx > 3 && idx < frontText.length - 2) {
                            foundIdx = idx
                            delimLen = delim.length
                            break
                        }
                    }

                    if (foundIdx != -1) {
                        val part1 = frontText.substring(0, foundIdx).trim()
                        val part2 = frontText.substring(foundIdx + delimLen).trim()
                        if (part1.isNotBlank() && part2.isNotBlank()) {
                            frontText = PyqTextNormalizer.cleanQuestionStatement(part1)
                            answerContent = part2
                        }
                    }
                }

                if (answerContent.isBlank()) {
                    // If no answer could be resolved, check if it's a valid question ending with '?' or fill in blanks
                    val isGenuineQuestion = rawStatement.endsWith("?") ||
                            Regex("(?i)^(?:Who|What|Where|When|Why|Which|How|Name|Define|State|Identify)\\b").containsMatchIn(rawStatement) ||
                            Regex("_{3,}|\\.{4,}").containsMatchIn(rawStatement)
                    if (!isGenuineQuestion) {
                        continue
                    }
                    answerContent = "Answer"
                }

                val backContent = buildString {
                    append(answerContent)
                    if (safeExpl.isNotEmpty() && safeExpl != "NA") {
                        append(" {explain} ")
                        append(safeExpl)
                    }
                }

                result.add(
                    CardEntity(
                        id = cardId,
                        noteId = cardId,
                        deckId = deckId,
                        front = frontText,
                        back = backContent,
                        tags = q.subject,
                        deckHierarchy = deckName
                    )
                )
            }
        }

        return result
    }

    /**
     * Splits or filters a bilingual text string, retaining either Devanagari (Hindi) or Latin (English) portions.
     */
    fun extractScriptText(text: String, preferDevanagari: Boolean): String {
        val trimmed = text.trim()
        if (trimmed.isEmpty()) return ""

        // Check if there is a known bilingual delimiter: " ||| " or " / " or "\n"
        val candidates = when {
            trimmed.contains(" ||| ") -> trimmed.split(" ||| ")
            trimmed.contains("\n") -> trimmed.split("\n")
            trimmed.contains(" / ") -> trimmed.split(" / ")
            else -> listOf(trimmed)
        }

        if (candidates.size > 1) {
            val matching = candidates.firstOrNull { part ->
                val devanagariCount = part.count { it in '\u0900'..'\u097F' }
                val latinCount = part.count { it in 'a'..'z' || it in 'A'..'Z' }
                if (preferDevanagari) devanagariCount >= latinCount else latinCount >= devanagariCount
            }
            if (matching != null && matching.isNotBlank()) {
                return matching.trim()
            }
        }

        // If no clean split, filter line-by-line
        val lines = trimmed.split("\n")
        val filteredLines = lines.filter { line ->
            val devanagariCount = line.count { it in '\u0900'..'\u097F' }
            val latinCount = line.count { it in 'a'..'z' || it in 'A'..'Z' }
            if (preferDevanagari) {
                devanagariCount > 0 || latinCount == 0
            } else {
                latinCount > 0 || devanagariCount == 0
            }
        }

        return if (filteredLines.isNotEmpty()) {
            filteredLines.joinToString("\n").trim()
        } else {
            trimmed
        }
    }
}
