package com.example.flashcardapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isSpecified
import androidx.compose.ui.unit.sp

/**
 * High-performance 100% Native LaTeX & Math Equation Renderer.
 *
 * Replaces heavy WebViews with a native offline LaTeX engine (JLatexMath) and
 * in-memory LRU bitmap caching for instant, zero-jank mathematical expression rendering.
 *
 * Supports:
 * - Pure text with instant Unicode symbol fallback
 * - Inline LaTeX enclosed in `$ ... $` or `\( ... \)`
 * - Block multiline/display LaTeX enclosed in `$$ ... $$` or `\[ ... \]`
 * - Dynamic theme-aware color adaptation
 */
@Composable
fun MathView(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    color: Color = MaterialTheme.colorScheme.onSurface,
    forceWebView: Boolean = false // Kept for backward compatibility; ignored in native mode
) {
    if (text.isBlank()) {
        Text(text = "", modifier = modifier, style = style, color = color)
        return
    }

    val density = LocalDensity.current
    val fontSizeSp = style.fontSize.takeIf { it.isSpecified }?.value ?: 16f
    val textSizePx = with(density) { fontSizeSp.sp.toPx() }
    val colorArgb = color.toArgb()

    // Inspect whether text contains mathematical delimiters or LaTeX commands
    val hasLatexSyntax = remember(text) {
        text.contains("$$") || text.contains("$") ||
                text.contains("\\[") || text.contains("\\(") ||
                text.contains("\\frac") || text.contains("\\sqrt") ||
                text.contains("\\sum") || text.contains("\\int") ||
                text.contains("\\matrix") || text.contains("\\begin") ||
                text.contains("\\times") || text.contains("\\pm")
    }

    if (!hasLatexSyntax) {
        // Fast path: standard text without LaTeX formulas
        Text(
            text = text,
            modifier = modifier,
            style = style,
            color = color
        )
        return
    }

    // Check if entire string is a single block equation: $$...$$ or \[...\]
    val trimmed = text.trim()
    val isPureBlockFormula = remember(trimmed) {
        (trimmed.startsWith("$$") && trimmed.endsWith("$$") && trimmed.length > 4) ||
                (trimmed.startsWith("\\[") && trimmed.endsWith("\\]") && trimmed.length > 4)
    }

    if (isPureBlockFormula) {
        val formula = if (trimmed.startsWith("$$")) {
            trimmed.substring(2, trimmed.length - 2).trim()
        } else {
            trimmed.substring(2, trimmed.length - 2).trim()
        }

        val renderedBitmap = remember(formula, colorArgb, textSizePx) {
            LateXRenderingCache.render(formula, colorArgb, textSizePx * 1.15f)
        }

        if (renderedBitmap != null) {
            Box(
                modifier = modifier.fillMaxWidth().padding(vertical = 4.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    bitmap = renderedBitmap,
                    contentDescription = formula,
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
            }
            return
        }
    }

    // Mixed mode: Parse text segments and embedded inline math tokens
    val parsedSegments = remember(text) {
        parseMathSegments(text)
    }

    val inlineContentMap = mutableMapOf<String, InlineTextContent>()
    val annotatedText = buildAnnotatedString {
        parsedSegments.forEachIndexed { index, segment ->
            if (segment.isMath) {
                val inlineTag = "latex_inline_$index"
                val bitmap = LateXRenderingCache.render(segment.content, colorArgb, textSizePx)
                if (bitmap != null) {
                    appendInlineContent(inlineTag, "[math]")
                    val widthDp = with(density) { bitmap.width.toDp() }
                    val heightDp = with(density) { bitmap.height.toDp() }

                    inlineContentMap[inlineTag] = InlineTextContent(
                        placeholder = Placeholder(
                            width = widthDp.value.sp,
                            height = heightDp.value.sp,
                            placeholderVerticalAlign = PlaceholderVerticalAlign.Center
                        )
                    ) {
                        Image(
                            bitmap = bitmap,
                            contentDescription = segment.content,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                } else {
                    // Fallback to unicode normalized text if parser fails
                    append(normalizeLatexToUnicode(segment.content))
                }
            } else {
                append(segment.content)
            }
        }
    }

    Text(
        text = annotatedText,
        inlineContent = inlineContentMap,
        modifier = modifier,
        style = style,
        color = color
    )
}

/**
 * Segment data model for mixed plain text and math formulas.
 */
data class TextMathSegment(
    val content: String,
    val isMath: Boolean
)

/**
 * Fast scanner separating plain text from LaTeX expressions delimited by:
 * - `$$...$$` (block/display math)
 * - `$ ... $` (inline math)
 * - `\(...\)` (LaTeX standard inline)
 * - `\[...\]` (LaTeX standard display)
 */
fun parseMathSegments(raw: String): List<TextMathSegment> {
    val segments = mutableListOf<TextMathSegment>()
    var currentIndex = 0
    val length = raw.length

    while (currentIndex < length) {
        // Find next delimiter
        val dollarBlock = raw.indexOf("$$", currentIndex)
        val bracketBlock = raw.indexOf("\\[", currentIndex)
        val parenInline = raw.indexOf("\\(", currentIndex)
        val singleDollar = raw.indexOf("$", currentIndex)

        // Find the earliest starting delimiter
        val candidateStarts = listOfNotNull(
            if (dollarBlock != -1) Pair(dollarBlock, "$$") else null,
            if (bracketBlock != -1) Pair(bracketBlock, "\\[") else null,
            if (parenInline != -1) Pair(parenInline, "\\(") else null,
            if (singleDollar != -1 && singleDollar != dollarBlock) Pair(singleDollar, "$") else null
        ).sortedBy { it.first }

        if (candidateStarts.isEmpty()) {
            // No more math tokens, add remaining text
            if (currentIndex < length) {
                segments.add(TextMathSegment(raw.substring(currentIndex), isMath = false))
            }
            break
        }

        val (startIndex, delimiter) = candidateStarts.first()

        // Append text preceding the delimiter
        if (startIndex > currentIndex) {
            segments.add(TextMathSegment(raw.substring(currentIndex, startIndex), isMath = false))
        }

        val closingDelimiter = when (delimiter) {
            "$$" -> "$$"
            "\\[" -> "\\]"
            "\\(" -> "\\)"
            "$" -> "$"
            else -> "$"
        }

        val formulaStart = startIndex + delimiter.length
        val formulaEnd = raw.indexOf(closingDelimiter, formulaStart)

        if (formulaEnd != -1) {
            val formula = raw.substring(formulaStart, formulaEnd)
            if (formula.isNotBlank()) {
                segments.add(TextMathSegment(formula, isMath = true))
            }
            currentIndex = formulaEnd + closingDelimiter.length
        } else {
            // Unmatched delimiter; treat as regular text
            segments.add(TextMathSegment(raw.substring(startIndex), isMath = false))
            break
        }
    }

    return segments
}

/**
 * Converts standard LaTeX tokens to clean Unicode representations for instant native fallback.
 */
fun normalizeLatexToUnicode(raw: String): String {
    var s = raw

    // Remove $ and $$ delimiters
    s = s.replace("$$", "").replace("$", "")

    // Fractions: \frac{a}{b} -> (a/b)
    s = s.replace(Regex("\\\\frac\\{([^}]+)\\}\\{([^}]+)\\}")) { mr ->
        "(${mr.groupValues[1]} / ${mr.groupValues[2]})"
    }

    // Square roots: \sqrt{x} -> √(x)
    s = s.replace(Regex("\\\\sqrt\\{([^}]+)\\}")) { mr ->
        "√(${mr.groupValues[1]})"
    }
    s = s.replace("\\sqrt", "√")

    // Common math symbols
    s = s.replace("\\pm", "±")
    s = s.replace("\\times", "×")
    s = s.replace("\\div", "÷")
    s = s.replace("\\neq", "≠")
    s = s.replace("\\leq", "≤")
    s = s.replace("\\geq", "≥")
    s = s.replace("\\approx", "≈")
    s = s.replace("\\infty", "∞")
    s = s.replace("\\sum", "∑")
    s = s.replace("\\int", "∫")
    s = s.replace("\\cdot", "•")

    // Arrows
    s = s.replace("\\rightarrow", "→")
    s = s.replace("\\leftarrow", "←")
    s = s.replace("\\leftrightarrow", "↔")
    s = s.replace("->", "→")

    // Greek symbols
    s = s.replace("\\alpha", "α")
    s = s.replace("\\beta", "β")
    s = s.replace("\\gamma", "γ")
    s = s.replace("\\delta", "δ")
    s = s.replace("\\Delta", "Δ")
    s = s.replace("\\epsilon", "ε")
    s = s.replace("\\theta", "θ")
    s = s.replace("\\lambda", "λ")
    s = s.replace("\\mu", "μ")
    s = s.replace("\\pi", "π")
    s = s.replace("\\sigma", "σ")
    s = s.replace("\\omega", "ω")
    s = s.replace("\\Omega", "Ω")

    // Superscripts
    s = s.replace("^0", "⁰").replace("^1", "¹").replace("^2", "²").replace("^3", "³")
        .replace("^4", "⁴").replace("^5", "⁵").replace("^6", "⁶").replace("^7", "⁷")
        .replace("^8", "⁸").replace("^9", "⁹").replace("^+", "⁺").replace("^-", "⁻")

    // Subscripts
    s = s.replace("_0", "₀").replace("_1", "₁").replace("_2", "₂").replace("_3", "₃")
        .replace("_4", "₄").replace("_5", "₅").replace("_6", "₆").replace("_7", "₇")
        .replace("_8", "₈").replace("_9", "₉").replace("_+", "₊").replace("_-", "₋")

    // Common chemical elements subscripts (H2O, CO2, H2SO4)
    s = s.replace("H2O", "H₂O")
    s = s.replace("CO2", "CO₂")
    s = s.replace("H2SO4", "H₂SO₄")
    s = s.replace("O2", "O₂")
    s = s.replace("N2", "N₂")

    return s
}
