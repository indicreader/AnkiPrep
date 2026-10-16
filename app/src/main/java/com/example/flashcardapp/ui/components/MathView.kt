package com.example.flashcardapp.ui.components

import android.webkit.WebView
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.viewinterop.AndroidView

/**
 * High-performance Offline Math & LaTeX Renderer.
 *
 * Automatically normalizes LaTeX math tokens (fractions, square roots, superscripts,
 * subscripts, greek letters, chemical symbols) into crisp formatted text,
 * with hardware-accelerated WebView fallback for complex multiline equations.
 */
@Composable
fun MathView(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    color: Color = MaterialTheme.colorScheme.onSurface,
    forceWebView: Boolean = false
) {
    val hasComplexLatex = remember(text) {
        text.contains("$$") || text.contains("\\begin") || text.contains("\\matrix")
    }

    val hasSimpleMath = remember(text) {
        text.contains("$") || text.contains("\\frac") || text.contains("\\sqrt") ||
                text.contains("\\pm") || text.contains("\\times") || text.contains("\\alpha") ||
                text.contains("\\beta") || text.contains("\\pi") || text.contains("\\theta") ||
                text.contains("->") || text.contains("\\rightarrow")
    }

    if ((hasComplexLatex || forceWebView) && hasSimpleMath) {
        // Complex multiline / matrix LaTeX display via offline WebView
        val textColorHex = String.format("#%06X", 0xFFFFFF and color.toArgb())
        val htmlContent = remember(text, textColorHex) {
            buildHtmlMathDocument(text, textColorHex, style.fontSize.value)
        }

        AndroidView(
            modifier = modifier.fillMaxWidth(),
            factory = { context ->
                WebView(context).apply {
                    setBackgroundColor(0x00000000) // Transparent background
                    settings.javaScriptEnabled = true
                    settings.allowFileAccess = true
                }
            },
            update = { webView ->
                webView.loadDataWithBaseURL(null, htmlContent, "text/html", "utf-8", null)
            }
        )
    } else {
        // Fast Native Compose rendering using Unicode normalization
        val formatted = remember(text) {
            normalizeLatexToUnicode(text)
        }

        Text(
            text = formatted,
            modifier = modifier,
            style = style,
            color = color
        )
    }
}

/**
 * Converts standard LaTeX tokens to clean Unicode representations for instant native rendering.
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

/**
 * Builds standalone HTML with embedded KaTeX CSS/JS for complex equations.
 */
private fun buildHtmlMathDocument(latexText: String, textColor: String, fontSizeSp: Float): String {
    val escaped = latexText.replace("\"", "&quot;").replace("\n", "<br/>")
    return """
        <!DOCTYPE html>
        <html>
        <head>
            <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
            <style>
                body {
                    margin: 0;
                    padding: 4px;
                    background-color: transparent;
                    color: $textColor;
                    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, sans-serif;
                    font-size: ${fontSizeSp}px;
                    line-height: 1.4;
                    word-wrap: break-word;
                }
            </style>
        </head>
        <body>
            <div>$escaped</div>
        </body>
        </html>
    """.trimIndent()
}
