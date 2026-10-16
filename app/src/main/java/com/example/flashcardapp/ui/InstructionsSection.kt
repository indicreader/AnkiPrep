package com.example.flashcardapp.ui

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
enum class InstructionFormat(val title: String, val icon: String) {
    CSV("CSV Sheets", "📄"),
    EPUB("EPUB Books", "📖"),
    PDF("PDF Booklets", "📑"),
    ZIP("ZIP Archives", "📦"),
    APKG("APKG Decks", "🗂️")
}

@Composable
fun InstructionsSection() {
    val context = LocalContext.current
    var selectedFormat by remember { mutableStateOf(InstructionFormat.CSV) }
    val isDark = MaterialTheme.colorScheme.surface.let { (it.red * 0.299f + it.green * 0.587f + it.blue * 0.114f) < 0.5f }

    val cardBg = MaterialTheme.colorScheme.surface
    val cardBorder = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
    val textPrimary = MaterialTheme.colorScheme.onSurface
    val textMuted = MaterialTheme.colorScheme.onSurfaceVariant
    val codeBg = MaterialTheme.colorScheme.surfaceVariant
    val primaryAccent = MaterialTheme.colorScheme.primary

    fun copyToClipboard(label: String, text: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText(label, text)
        clipboard.setPrimaryClip(clip)
        Toast.makeText(context, "$label copied to clipboard!", Toast.LENGTH_SHORT).show()
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Hero Header Banner
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            color = primaryAccent.copy(alpha = if (isDark) 0.12f else 0.08f),
            border = androidx.compose.foundation.BorderStroke(1.dp, primaryAccent.copy(alpha = 0.25f))
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = primaryAccent.copy(alpha = 0.2f),
                    modifier = Modifier.size(44.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(selectedFormat.icon, fontSize = 22.sp)
                    }
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Import Format Specifications",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = textPrimary
                    )
                    Text(
                        text = "AnkiPrep natively supports CSV, EPUB, multi-column PDF, ZIP books, and Anki APKG files.",
                        fontSize = 12.sp,
                        color = textMuted,
                        lineHeight = 16.sp
                    )
                }
            }
        }

        // Format Selection Chips
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            InstructionFormat.values().forEach { format ->
                val isSelected = format == selectedFormat
                Surface(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .clickable { selectedFormat = format },
                    shape = RoundedCornerShape(12.dp),
                    color = if (isSelected) primaryAccent else cardBg,
                    border = androidx.compose.foundation.BorderStroke(
                        1.dp,
                        if (isSelected) primaryAccent else cardBorder
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(format.icon, fontSize = 13.sp)
                        Text(
                            text = format.title,
                            fontSize = 12.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            color = if (isSelected) Color.White else textPrimary
                        )
                    }
                }
            }
        }

        // Active Format Content
        when (selectedFormat) {
            InstructionFormat.CSV -> {
                CsvInstructions(
                    cardBg = cardBg,
                    cardBorder = cardBorder,
                    textPrimary = textPrimary,
                    textMuted = textMuted,
                    codeBg = codeBg,
                    primaryAccent = primaryAccent,
                    onCopy = ::copyToClipboard
                )
            }
            InstructionFormat.EPUB -> {
                EpubInstructions(
                    cardBg = cardBg,
                    cardBorder = cardBorder,
                    textPrimary = textPrimary,
                    textMuted = textMuted,
                    codeBg = codeBg,
                    primaryAccent = primaryAccent,
                    onCopy = ::copyToClipboard
                )
            }
            InstructionFormat.PDF -> {
                PdfInstructions(
                    cardBg = cardBg,
                    cardBorder = cardBorder,
                    textPrimary = textPrimary,
                    textMuted = textMuted,
                    codeBg = codeBg,
                    primaryAccent = primaryAccent
                )
            }
            InstructionFormat.ZIP -> {
                ZipInstructions(
                    cardBg = cardBg,
                    cardBorder = cardBorder,
                    textPrimary = textPrimary,
                    textMuted = textMuted,
                    codeBg = codeBg,
                    primaryAccent = primaryAccent,
                    onCopy = ::copyToClipboard
                )
            }
            InstructionFormat.APKG -> {
                ApkgInstructions(
                    cardBg = cardBg,
                    cardBorder = cardBorder,
                    textPrimary = textPrimary,
                    textMuted = textMuted,
                    primaryAccent = primaryAccent
                )
            }
        }

        // Sample Files Ready Card
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            color = Color(0xFF10B981).copy(alpha = if (isDark) 0.12f else 0.08f),
            border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.3f))
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("📁", fontSize = 18.sp)
                    Text(
                        text = "Sample Files Included in Repository",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = if (isDark) Color(0xFF34D399) else Color(0xFF047857)
                    )
                }
                Text(
                    text = "Ready-to-use sample files are stored in the project's 'sample_import_files/' directory for testing:",
                    fontSize = 12.sp,
                    color = textMuted
                )
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    val files = listOf(
                        "📄 sample_5col_history.csv (5-column topic/subtopic)",
                        "📄 sample_mcq.csv (4-column with choices)",
                        "📄 sample_oneliner.csv (3-column fact sheet)",
                        "📖 sample_book.epub (Full formatted e-book)",
                        "📑 sample_exam.pdf (Single & multi-column exam paper)",
                        "📦 sample_book.zip (Multi-chapter nested deck archive)"
                    )
                    files.forEach { file ->
                        Text(
                            text = "• $file",
                            fontSize = 11.sp,
                            fontFamily = FontFamily.Monospace,
                            color = textPrimary
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CsvInstructions(
    cardBg: Color,
    cardBorder: Color,
    textPrimary: Color,
    textMuted: Color,
    codeBg: Color,
    primaryAccent: Color,
    onCopy: (String, String) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        // 5-Column Format
        InstructionCard(
            title = "1. 5-Column Topic & Subtopic Mode (Recommended)",
            badge = "5 Columns",
            badgeColor = Color(0xFF8B5CF6),
            description = "Topic and subtopic are stored as hidden metadata tags for hierarchical distractor prioritization. Sibling options are picked first from the same Subtopic, then Topic, then Deck.",
            cardBg = cardBg,
            cardBorder = cardBorder,
            textPrimary = textPrimary,
            textMuted = textMuted
        ) {
            val sample5Col = """topic, subtopic, question, answer, explaination
History, Medieval, what was the range of mesolithi period between?, 10,000 to 6000 bce, Mesolithic was transitional stone age period.
History, Ancient, Capital of Maurya Empire under Ashoka, Pataliputra, Modern Patna served as seat."""

            CodeBlock(
                code = sample5Col,
                codeBg = codeBg,
                textPrimary = textPrimary,
                primaryAccent = primaryAccent,
                onCopy = { onCopy("5-Column CSV", sample5Col) }
            )

            RuleBullet("Numeric Comma Protection: Numbers containing commas like 10,000 to 6000 bce are auto-protected without splitting columns.", textMuted)
            RuleBullet("Questions do not require a question mark '?'. The boundaries are recognized automatically.", textMuted)
            RuleBullet("Topic and Subtopic remain hidden during quiz view and serve solely as anchors for intelligent distractor generation.", textMuted)
        }

        // 4-Column MCQ Format
        InstructionCard(
            title = "2. 4-Column Standard MCQ Mode",
            badge = "4 Columns",
            badgeColor = Color(0xFF06B6D4),
            description = "Explicit MCQ with pipe-separated options. The CORRECT answer MUST always be the first item in the options column.",
            cardBg = cardBg,
            cardBorder = cardBorder,
            textPrimary = textPrimary,
            textMuted = textMuted
        ) {
            val sample4Col = """"Polity, Rights", "Which Article guarantees Right to Constitutional Remedies?", "Article 32 | Article 21 | Article 19 | Article 14", "Article 32 is the heart and soul of constitution."
"Biology", "Which cell organelle is the powerhouse?", "Mitochondria | Ribosome | Nucleus | Golgi apparatus", "Generates cellular ATP."""

            CodeBlock(
                code = sample4Col,
                codeBg = codeBg,
                textPrimary = textPrimary,
                primaryAccent = primaryAccent,
                onCopy = { onCopy("4-Column CSV", sample4Col) }
            )

            RuleBullet("Col 1: Subject / Topic Tags (e.g. 'Polity, Rights').", textMuted)
            RuleBullet("Col 2: Question statement.", textMuted)
            RuleBullet("Col 3: Options separated by '|'. Correct answer is always first; the app shuffles choices for students.", textMuted)
            RuleBullet("Col 4: Rationale / Explanation shown after attempt.", textMuted)
        }

        // 3-Column One-Liner Format
        InstructionCard(
            title = "3. 3-Column One-Liner Fact Sheet",
            badge = "3 Columns",
            badgeColor = Color(0xFF10B981),
            description = "High-speed question and answer pairs. The app dynamically generates intelligent distractors from other answers in the deck.",
            cardBg = cardBg,
            cardBorder = cardBorder,
            textPrimary = textPrimary,
            textMuted = textMuted
        ) {
            val sample3Col = """question, answer, explaination
Who wrote the National Anthem of India?, Rabindranath Tagore, Composed as Bharoto Bhagyo Bidhata.
What is the SI unit of electric current?, Ampere, Discovered electromagnetism."""

            CodeBlock(
                code = sample3Col,
                codeBg = codeBg,
                textPrimary = textPrimary,
                primaryAccent = primaryAccent,
                onCopy = { onCopy("3-Column CSV", sample3Col) }
            )
        }
    }
}

@Composable
private fun EpubInstructions(
    cardBg: Color,
    cardBorder: Color,
    textPrimary: Color,
    textMuted: Color,
    codeBg: Color,
    primaryAccent: Color,
    onCopy: (String, String) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        InstructionCard(
            title = "EPUB Study Book Architecture",
            badge = "E-Book",
            badgeColor = Color(0xFF8B5CF6),
            description = "AnkiPrep parses standard EPUB files into organized subdecks and flashcards. Perfect for study guides created in Calibre or word processors.",
            cardBg = cardBg,
            cardBorder = cardBorder,
            textPrimary = textPrimary,
            textMuted = textMuted
        ) {
            RuleBullet("<h1> or <h2> Headings: Automatically generate subdecks (e.g. 'Book::Ancient History').", textMuted)
            RuleBullet("<h3> Headings: Set the subtopic for subsequent questions ('subtopic:Mesolithic').", textMuted)
            RuleBullet("Horizontal Rule (<hr/> or ---): Separates individual question blocks cleanly.", textMuted)

            val epubSnippet = """<h1>Chapter: Ancient History</h1>
<h3>Indus Valley Civilization</h3>

<p>**Q1.** Which is the largest Indian site of Indus Valley?</p>
<p>A) Lothal</p>
<p>B) Rakhigarhi</p>
<p>C) Kalibangan</p>
<p>D) Banawali</p>
<p>**Answer:** B) Rakhigarhi</p>
<p>**Explanation:** Rakhigarhi in Haryana is the largest Indian site.</p>
<hr/>"""

            CodeBlock(
                code = epubSnippet,
                codeBg = codeBg,
                textPrimary = textPrimary,
                primaryAccent = primaryAccent,
                onCopy = { onCopy("EPUB Template", epubSnippet) }
            )

            RuleBullet("Options must use standard prefixes: A), B), C), D) or (A), (B), (C), (D).", textMuted)
            RuleBullet("Answer line must specify letter or text: '**Answer:** B) Rakhigarhi'.", textMuted)
        }
    }
}

@Composable
private fun PdfInstructions(
    cardBg: Color,
    cardBorder: Color,
    textPrimary: Color,
    textMuted: Color,
    codeBg: Color,
    primaryAccent: Color
) {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        InstructionCard(
            title = "100% Offline Multi-Column PDF Extraction",
            badge = "PDF Booklet",
            badgeColor = Color(0xFF06B6D4),
            description = "Runs on-device ML Kit OCR with spatial histogram segmentation. Extracts exam booklets without cloud servers.",
            cardBg = cardBg,
            cardBorder = cardBorder,
            textPrimary = textPrimary,
            textMuted = textMuted
        ) {
            RuleBullet("Column Modes: Supports 1-Column full width, 2-Column booklets, 3-Column dense exam sheets, or Auto-Detect.", textMuted)
            RuleBullet("Question Markers: '1.', 'Q1.', 'Q.1', 'Question 1:', '1) ...' are auto-detected.", textMuted)
            RuleBullet("Option Markers: '(A) (B) (C) (D)', 'A. B. C. D.', '(1) (2) (3) (4)', or Roman '(i) (ii) (iii) (iv)'.", textMuted)
            RuleBullet("Answer Key Modes: Supports inline answers ('Ans: (C) 35 years') or end-of-document Answer Key tables ('1. C  2. A  3. D').", textMuted)
            RuleBullet("Bilingual Extraction: For exams with dual Hindi & English questions, choose 'Both' during import to enable the mid-quiz 🌐 translation switch.", textMuted)
        }
    }
}

@Composable
private fun ZipInstructions(
    cardBg: Color,
    cardBorder: Color,
    textPrimary: Color,
    textMuted: Color,
    codeBg: Color,
    primaryAccent: Color,
    onCopy: (String, String) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        InstructionCard(
            title = "ZIP Multi-Chapter Book & Media Archives",
            badge = "ZIP Archive",
            badgeColor = Color(0xFFF59E0B),
            description = "Package entire books containing multiple CSV chapter files and diagram images in a single ZIP archive.",
            cardBg = cardBg,
            cardBorder = cardBorder,
            textPrimary = textPrimary,
            textMuted = textMuted
        ) {
            RuleBullet("Subdeck Generation: Each .csv inside the ZIP becomes a subdeck: 'Book::ChapterName'.", textMuted)
            RuleBullet("Nested Folders: Subfolders become nested subdecks: 'Book::Unit 1::Chapter 2'.", textMuted)
            RuleBullet("Automatic Media Unpacking: Any images (PNG, JPG, WebP) in 'media/' or within the ZIP are copied to app storage for flashcard graphics.", textMuted)

            val zipTree = """History_Complete.zip/
├── 01_Ancient_History.csv
├── 02_Medieval_History.csv
├── 03_Modern_History.csv
└── media/
    ├── indus_map.png
    └── mauryan_pillars.jpg"""

            CodeBlock(
                code = zipTree,
                codeBg = codeBg,
                textPrimary = textPrimary,
                primaryAccent = primaryAccent,
                onCopy = { onCopy("ZIP Tree", zipTree) }
            )
        }
    }
}

@Composable
private fun ApkgInstructions(
    cardBg: Color,
    cardBorder: Color,
    textPrimary: Color,
    textMuted: Color,
    primaryAccent: Color
) {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        InstructionCard(
            title = "Anki .APKG Package Compatibility",
            badge = "Anki APKG",
            badgeColor = Color(0xFF10B981),
            description = "Directly import existing decks from AnkiDroid or Anki Desktop (.apkg files).",
            cardBg = cardBg,
            cardBorder = cardBorder,
            textPrimary = textPrimary,
            textMuted = textMuted
        ) {
            RuleBullet("SQLite2 & SQLite21: Supports standard and modern Anki package database schemas.", textMuted)
            RuleBullet("Deck Hierarchy: Automatically preserves nested deck folders defined with '::'.", textMuted)
            RuleBullet("Media Extraction: Extracts audio recordings, mathematical SVGs, and diagram images directly into the local card cache.", textMuted)
            RuleBullet("Anki Tags: Preserves existing tags and maps them to AnkiPrep category tags.", textMuted)
        }
    }
}

@Composable
private fun InstructionCard(
    title: String,
    badge: String,
    badgeColor: Color,
    description: String,
    cardBg: Color,
    cardBorder: Color,
    textPrimary: Color,
    textMuted: Color,
    content: @Composable ColumnScope.() -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        color = cardBg,
        border = androidx.compose.foundation.BorderStroke(1.dp, cardBorder)
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = textPrimary,
                    modifier = Modifier.weight(1f)
                )
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = badgeColor.copy(alpha = 0.15f),
                    border = androidx.compose.foundation.BorderStroke(1.dp, badgeColor.copy(alpha = 0.35f))
                ) {
                    Text(
                        text = badge,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = badgeColor,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Text(
                text = description,
                fontSize = 12.sp,
                color = textMuted,
                lineHeight = 16.sp
            )

            content()
        }
    }
}

@Composable
private fun RuleBullet(text: String, textMuted: Color) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.Top,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(top = 6.dp)
                .size(5.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
        )
        Text(
            text = text,
            fontSize = 12.sp,
            color = textMuted,
            lineHeight = 16.sp
        )
    }
}

@Composable
private fun CodeBlock(
    code: String,
    codeBg: Color,
    textPrimary: Color,
    primaryAccent: Color,
    onCopy: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(codeBg)
            .border(1.dp, Color.White.copy(alpha = 0.08f), RoundedCornerShape(12.dp))
            .padding(12.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "SYNTAX TEMPLATE",
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = primaryAccent,
                    letterSpacing = 1.sp
                )
                IconButton(
                    onClick = onCopy,
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ContentCopy,
                        contentDescription = "Copy code",
                        tint = textPrimary.copy(alpha = 0.7f),
                        modifier = Modifier.size(14.dp)
                    )
                }
            }
            Text(
                text = code,
                fontSize = 11.sp,
                fontFamily = FontFamily.Monospace,
                color = textPrimary.copy(alpha = 0.9f),
                lineHeight = 16.sp
            )
        }
    }
}
