package com.example.flashcardapp.ui.components

import android.graphics.Typeface
import android.text.Html
import android.text.Spanned
import android.text.style.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.core.text.HtmlCompat

/**
 * Universal Rich Text Parser for AnkiPrep.
 * Converts mixed HTML, Markdown, and Anki Cloze syntax into Jetpack Compose AnnotatedString.
 *
 * Supported formatting:
 * - Bold / Dark text: <b>, <strong>, **text**, __text__
 * - Italics: <i>, <em>, *text*, _text_
 * - Underline: <u>
 * - Strikethrough: <s>, <del>, <strike>, ~~text~~
 * - Highlights: <mark>, ==text==, <span style="background-color: ...">
 * - Anki Clozes: {{c1::answer::hint}} -> styled highlighted bold chip
 * - Text colors: <font color="...">, <span style="color: ...">
 * - Inline Code: <code>, `code`
 */
object RichTextParser {

    /**
     * Converts raw text containing HTML, Markdown, or Cloze tags into an AnnotatedString.
     */
    fun parse(
        raw: String,
        isDarkMode: Boolean = false,
        highlightColor: Color = if (isDarkMode) Color(0xFFD97706).copy(alpha = 0.35f) else Color(0xFFFEF08A),
        highlightTextColor: Color = if (isDarkMode) Color(0xFFFDE68A) else Color(0xFF854D0E)
    ): AnnotatedString {
        if (raw.isBlank()) return AnnotatedString("")

        // 1. Fast path: If string contains no formatting indicators, return simple AnnotatedString
        if (!hasFormattingTags(raw)) {
            return AnnotatedString(raw)
        }

        // 2. Preprocess Markdown and Cloze tokens into HTML equivalents
        var html = preprocessTokens(raw)

        // 3. Mark background highlight placeholder tags for custom span handling
        html = extractAndReplaceMarks(html)

        // 4. Parse using Android's HtmlCompat
        val spanned: Spanned = try {
            HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT)
        } catch (e: Exception) {
            return AnnotatedString(raw)
        }

        // 5. Convert Spanned -> Compose AnnotatedString
        return spannedToAnnotatedString(
            spanned = spanned,
            isDarkMode = isDarkMode,
            highlightColor = highlightColor,
            highlightTextColor = highlightTextColor
        )
    }

    private fun hasFormattingTags(text: String): Boolean {
        return text.contains("<") ||
                text.contains("**") ||
                text.contains("==") ||
                text.contains("~~") ||
                text.contains("{{c") ||
                text.contains("`") ||
                text.contains("&")
    }

    private fun preprocessTokens(raw: String): String {
        var text = raw

        // Cloze deletions: {{c1::answer::hint}} or {{c1::answer}} -> <mark><b>answer</b></mark>
        text = text.replace(Regex("""\{\{c\d+::(.*?)(?:::.*?)?\}\}""")) { match ->
            val ans = match.groupValues[1]
            "<mark><b>$ans</b></mark>"
        }

        // Markdown highlight: ==highlight== -> <mark>highlight</mark>
        text = text.replace(Regex("""==([^=\n\r]+)==""")) { match ->
            "<mark>${match.groupValues[1]}</mark>"
        }

        // Markdown bold: **bold** or __bold__ -> <b>bold</b>
        text = text.replace(Regex("""\*\*([^*\n\r]+)\*\*""")) { match ->
            "<b>${match.groupValues[1]}</b>"
        }
        text = text.replace(Regex("""__([^_\n\r]+)__""")) { match ->
            "<b>${match.groupValues[1]}</b>"
        }

        // Markdown strikethrough: ~~strike~~ -> <s>strike</s>
        text = text.replace(Regex("""~~([^~\n\r]+)~~""")) { match ->
            "<s>${match.groupValues[1]}</s>"
        }

        // Markdown inline code: `code` -> <code>code</code>
        text = text.replace(Regex("""`([^`\n\r]+)`""")) { match ->
            "<code>${match.groupValues[1]}</code>"
        }

        // Preserve single newlines as <br/> if text does not already contain HTML block tags
        if (!text.contains("<br", ignoreCase = true) && !text.contains("<p", ignoreCase = true)) {
            text = text.replace("\n", "<br/>")
        }

        return text
    }

    /**
     * Replaces <mark>...</mark> with a styled font color / background marker that HtmlCompat retains.
     */
    private fun extractAndReplaceMarks(html: String): String {
        return html.replace(Regex("""(?i)<mark>(.*?)</mark>""")) { match ->
            """<span style="background-color: #FEF08A;">${match.groupValues[1]}</span>"""
        }
    }

    private fun spannedToAnnotatedString(
        spanned: Spanned,
        isDarkMode: Boolean,
        highlightColor: Color,
        highlightTextColor: Color
    ): AnnotatedString {
        val text = spanned.toString()
        val builder = AnnotatedString.Builder(text)

        // Read all spans
        val spans = spanned.getSpans(0, spanned.length, Any::class.java)
        for (span in spans) {
            val start = spanned.getSpanStart(span)
            val end = spanned.getSpanEnd(span)
            if (start >= end || start < 0 || end > text.length) continue

            when (span) {
                is StyleSpan -> {
                    when (span.style) {
                        Typeface.BOLD -> {
                            builder.addStyle(SpanStyle(fontWeight = FontWeight.Bold), start, end)
                        }
                        Typeface.ITALIC -> {
                            builder.addStyle(SpanStyle(fontStyle = FontStyle.Italic), start, end)
                        }
                        Typeface.BOLD_ITALIC -> {
                            builder.addStyle(
                                SpanStyle(fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic),
                                start,
                                end
                            )
                        }
                    }
                }
                is UnderlineSpan -> {
                    builder.addStyle(SpanStyle(textDecoration = TextDecoration.Underline), start, end)
                }
                is StrikethroughSpan -> {
                    builder.addStyle(SpanStyle(textDecoration = TextDecoration.LineThrough), start, end)
                }
                is ForegroundColorSpan -> {
                    val colorArgb = span.foregroundColor
                    var color = Color(colorArgb)
                    // If in dark mode and text color is too dark, lighten it for contrast
                    if (isDarkMode) {
                        val luminance = (0.299 * android.graphics.Color.red(colorArgb) +
                                0.587 * android.graphics.Color.green(colorArgb) +
                                0.114 * android.graphics.Color.blue(colorArgb)) / 255.0
                        if (luminance < 0.25) {
                            color = Color(0xFFE2E8F0) // Legible light gray on dark backgrounds
                        }
                    }
                    builder.addStyle(SpanStyle(color = color), start, end)
                }
                is BackgroundColorSpan -> {
                    builder.addStyle(
                        SpanStyle(
                            background = highlightColor,
                            color = highlightTextColor,
                            fontWeight = FontWeight.SemiBold
                        ),
                        start,
                        end
                    )
                }
                is TypefaceSpan -> {
                    if (span.family?.equals("monospace", ignoreCase = true) == true) {
                        builder.addStyle(
                            SpanStyle(
                                fontFamily = FontFamily.Monospace,
                                background = if (isDarkMode) Color(0xFF334155) else Color(0xFFF1F5F9)
                            ),
                            start,
                            end
                        )
                    }
                }
            }
        }

        return builder.toAnnotatedString()
    }
}
