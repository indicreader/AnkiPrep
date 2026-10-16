package com.example.flashcardapp.data

/**
 * Role assigned to a page-range segment within a PDF during import.
 *
 * - QUESTIONS    → pages contain numbered questions + answer options
 * - ANSWER_KEY   → pages contain only the correct option letter per question number (e.g. answer key appendix)
 * - EXPLANATION  → pages contain solution explanations keyed by question number
 * - AUTO         → no specific role; use the universal inline parser (same as legacy behaviour)
 */
enum class PdfSegmentRole(val displayName: String) {
    QUESTIONS("Questions"),
    ANSWER_KEY("Answer Key"),
    EXPLANATION("Explanations"),
    AUTO("Auto-Detect")
}

/**
 * A single named slice of a PDF document with a designated content role.
 *
 * @param label      Optional user-provided label (e.g. "Economy Chapter")
 * @param pageStart  First page of the segment, 1-indexed, inclusive
 * @param pageEnd    Last page of the segment, 1-indexed, inclusive
 * @param role       How the parser should interpret content on these pages
 */
data class PdfSegmentConfig(
    val label: String = "",
    val pageStart: Int,
    val pageEnd: Int,
    val role: PdfSegmentRole = PdfSegmentRole.AUTO
) {
    /** Zero-indexed page range for use with [android.graphics.pdf.PdfRenderer]. */
    val pageStartIndex: Int get() = (pageStart - 1).coerceAtLeast(0)

    /** Zero-indexed end index (inclusive) for PdfRenderer. */
    fun pageEndIndex(pageCount: Int): Int = (pageEnd - 1).coerceIn(0, pageCount - 1)
}

/**
 * A chapter or section heading detected during the fast preview scan.
 *
 * @param pageNumber 1-indexed page where the heading was found
 * @param title      Extracted heading text
 */
data class DetectedChapter(
    val pageNumber: Int,
    val title: String
)

/**
 * Summary of a PDF's structure, returned by [PdfImporter.scanPdfPreview].
 *
 * @param pageCount Total number of pages in the document
 * @param chapters  List of auto-detected chapter / section headings with their page numbers
 */
data class PdfPreviewInfo(
    val pageCount: Int,
    val chapters: List<DetectedChapter>
)
