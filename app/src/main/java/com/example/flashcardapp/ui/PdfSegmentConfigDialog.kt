package com.example.flashcardapp.ui

import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.flashcardapp.data.AnkiDataRepository
import com.example.flashcardapp.data.AnkiDeck
import com.example.flashcardapp.data.PdfColumnMode
import com.example.flashcardapp.data.PdfLanguageFilter
import com.example.flashcardapp.data.PdfPreviewInfo
import com.example.flashcardapp.data.PdfSegmentConfig
import com.example.flashcardapp.data.PdfSegmentRole
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Interactive Dialog enabling students to configure PDF extraction parameters:
 * 1. Auto-detect / Full PDF vs. Segmented Mode.
 * 2. Question pages, Answer Key pages, and Explanation pages.
 * 3. Deck creation or merge destination with duplicate strategy.
 * 4. Column layout (Auto, 1-Col, 2-Col, 3-Col).
 * 5. Real-time background extraction progress indicator.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PdfSegmentConfigDialog(
    uri: Uri,
    decks: List<AnkiDeck>,
    onDismiss: () -> Unit,
    onSuccess: (deckName: String, cardCount: Int) -> Unit
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val repo = remember { AnkiDataRepository.getInstance(context) }
    val fileName = remember { repo.getFileName(uri) }

    // Fast preview scan state
    var isScanningPreview by remember { mutableStateOf(true) }
    var previewInfo by remember { mutableStateOf<PdfPreviewInfo?>(null) }
    var totalPages by remember { mutableStateOf(1) }

    // Mode: "AUTO" (all-in-one on same pages) vs "SEGMENTED" (questions, answers, exp on separate pages)
    var isSegmentedMode by remember { mutableStateOf(true) }

    // Page Range State
    var qStartStr by remember { mutableStateOf("1") }
    var qEndStr by remember { mutableStateOf("") }

    var hasAnswerKey by remember { mutableStateOf(false) }
    var keyStartStr by remember { mutableStateOf("") }
    var keyEndStr by remember { mutableStateOf("") }

    var hasExplanation by remember { mutableStateOf(false) }
    var expStartStr by remember { mutableStateOf("") }
    var expEndStr by remember { mutableStateOf("") }

    // Column Mode
    var selectedColumnMode by remember { mutableStateOf(PdfColumnMode.AUTO) }

    // Deck Destination State
    var importMode by remember { mutableStateOf("NEW") } // "NEW" or "MERGE"
    val defaultDeckName = remember {
        fileName.removeSuffix(".pdf").removeSuffix(".PDF").trim().ifEmpty { "Imported PDF" }
    }
    var customDeckName by remember { mutableStateOf(defaultDeckName) }
    var selectedDeck by remember { mutableStateOf<AnkiDeck?>(decks.firstOrNull()) }
    var deckDropdownExpanded by remember { mutableStateOf(false) }

    // Duplicate handling
    var duplicateStrategy by remember { mutableStateOf("UPDATE") } // "SKIP", "IMPORT", "UPDATE"
    var dupDropdownExpanded by remember { mutableStateOf(false) }

    // Bilingual Language Filter
    var selectedLanguageFilter by remember { mutableStateOf(PdfLanguageFilter.BOTH) }

    // Extraction in-progress state
    var isExtracting by remember { mutableStateOf(false) }
    var progressCurrent by remember { mutableStateOf(0) }
    var progressTotal by remember { mutableStateOf(1) }
    var progressStatus by remember { mutableStateOf("Initializing extraction...") }
    var extractionError by remember { mutableStateOf<String?>(null) }

    // Run preview scan on open
    LaunchedEffect(uri) {
        try {
            isScanningPreview = true
            val info = withContext(Dispatchers.IO) {
                repo.scanPdfPreview(uri)
            }
            previewInfo = info
            totalPages = info.pageCount.coerceAtLeast(1)
            qEndStr = info.pageCount.toString()
        } catch (e: Exception) {
            totalPages = 1
            qEndStr = "1"
        } finally {
            isScanningPreview = false
        }
    }

    Dialog(
        onDismissRequest = {
            if (!isExtracting) onDismiss()
        },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 6.dp,
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .fillMaxHeight(0.92f)
                .padding(vertical = 12.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                // Header Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "PDF Question Extraction",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = fileName,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    if (!isExtracting) {
                        IconButton(onClick = onDismiss) {
                            Icon(Icons.Default.Close, contentDescription = "Close")
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Scrollable Content
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    // Document Stats Banner
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Icon(
                                    Icons.Outlined.Info,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(20.dp)
                                )
                                Text(
                                    text = if (isScanningPreview) "Analyzing PDF structure..." else "Total Pages: $totalPages",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            if (isScanningPreview) {
                                CircularProgressIndicator(modifier = Modifier.size(16.dp), strokeWidth = 2.dp)
                            }
                        }
                    }

                    // Chapter hints if detected
                    if (previewInfo?.chapters?.isNotEmpty() == true) {
                        Text(
                            text = "Detected Chapters (tap to start here):",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            previewInfo?.chapters?.forEach { ch ->
                                SuggestionChip(
                                    onClick = {
                                        qStartStr = ch.pageNumber.toString()
                                        if (ch.title.isNotBlank()) {
                                            customDeckName = ch.title.take(30)
                                        }
                                    },
                                    label = { Text("P.${ch.pageNumber}: ${ch.title.take(20)}") }
                                )
                            }
                        }
                    }

                    // Extraction Mode Selector
                    Text(
                        text = "PDF Format Layout",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        FilterChip(
                            selected = isSegmentedMode,
                            onClick = { isSegmentedMode = true },
                            label = { Text("Separate Sections", fontSize = 12.sp) },
                            leadingIcon = { if (isSegmentedMode) Icon(Icons.Default.Check, null, Modifier.size(14.dp)) },
                            modifier = Modifier.weight(1f)
                        )
                        FilterChip(
                            selected = !isSegmentedMode,
                            onClick = { isSegmentedMode = false },
                            label = { Text("All-in-one Pages", fontSize = 12.sp) },
                            leadingIcon = { if (!isSegmentedMode) Icon(Icons.Default.Check, null, Modifier.size(14.dp)) },
                            modifier = Modifier.weight(1f)
                        )
                    }

                    // Page Range Inputs
                    if (isSegmentedMode) {
                        // Section 1: Questions Range
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f))
                        ) {
                            Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                Text(
                                    text = "📝 Question Pages (Required)",
                                    style = MaterialTheme.typography.labelLarge,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    OutlinedTextField(
                                        value = qStartStr,
                                        onValueChange = { qStartStr = it.filter { c -> c.isDigit() } },
                                        label = { Text("Start Page") },
                                        singleLine = true,
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                        modifier = Modifier.weight(1f)
                                    )
                                    OutlinedTextField(
                                        value = qEndStr,
                                        onValueChange = { qEndStr = it.filter { c -> c.isDigit() } },
                                        label = { Text("End Page") },
                                        singleLine = true,
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                        modifier = Modifier.weight(1f)
                                    )
                                }
                            }
                        }

                        // Section 2: Answer Key Pages (Optional)
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f))
                        ) {
                            Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "🔑 Answer Key Pages",
                                        style = MaterialTheme.typography.labelLarge,
                                        fontWeight = FontWeight.Bold,
                                        color = if (hasAnswerKey) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Switch(
                                        checked = hasAnswerKey,
                                        onCheckedChange = { hasAnswerKey = it }
                                    )
                                }
                                if (hasAnswerKey) {
                                    Text(
                                        text = "Specify page numbers containing only the answer key table (e.g. 1-B, 2-C)",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                                    ) {
                                        OutlinedTextField(
                                            value = keyStartStr,
                                            onValueChange = { keyStartStr = it.filter { c -> c.isDigit() } },
                                            label = { Text("Key Start") },
                                            singleLine = true,
                                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                            modifier = Modifier.weight(1f)
                                        )
                                        OutlinedTextField(
                                            value = keyEndStr,
                                            onValueChange = { keyEndStr = it.filter { c -> c.isDigit() } },
                                            label = { Text("Key End") },
                                            singleLine = true,
                                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                            modifier = Modifier.weight(1f)
                                        )
                                    }
                                }
                            }
                        }

                        // Section 3: Explanation Pages (Optional)
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f))
                        ) {
                            Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "💡 Explanation / Solution Pages",
                                        style = MaterialTheme.typography.labelLarge,
                                        fontWeight = FontWeight.Bold,
                                        color = if (hasExplanation) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Switch(
                                        checked = hasExplanation,
                                        onCheckedChange = { hasExplanation = it }
                                    )
                                }
                                if (hasExplanation) {
                                    Text(
                                        text = "Specify page numbers containing solution explanations keyed by Q-number",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                                    ) {
                                        OutlinedTextField(
                                            value = expStartStr,
                                            onValueChange = { expStartStr = it.filter { c -> c.isDigit() } },
                                            label = { Text("Exp Start") },
                                            singleLine = true,
                                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                            modifier = Modifier.weight(1f)
                                        )
                                        OutlinedTextField(
                                            value = expEndStr,
                                            onValueChange = { expEndStr = it.filter { c -> c.isDigit() } },
                                            label = { Text("Exp End") },
                                            singleLine = true,
                                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                            modifier = Modifier.weight(1f)
                                        )
                                    }
                                }
                            }
                        }
                    }

                    // Multi-Column Layout Selector
                    Text(
                        text = "Page Columns",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        listOf(
                            PdfColumnMode.AUTO to "Auto",
                            PdfColumnMode.SINGLE to "1 Column",
                            PdfColumnMode.TWO_COLUMN to "2 Columns",
                            PdfColumnMode.THREE_COLUMN to "3 Columns"
                        ).forEach { (mode, label) ->
                            FilterChip(
                                selected = selectedColumnMode == mode,
                                onClick = { selectedColumnMode = mode },
                                label = { Text(label, fontSize = 11.sp) },
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }

                    // Destination Deck Configuration
                    Text(
                        text = "Destination Deck",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        FilterChip(
                            selected = importMode == "NEW",
                            onClick = { importMode = "NEW" },
                            label = { Text("Create New Deck") },
                            modifier = Modifier.weight(1f)
                        )
                        FilterChip(
                            selected = importMode == "MERGE",
                            onClick = { importMode = "MERGE" },
                            label = { Text("Merge into Deck") },
                            modifier = Modifier.weight(1f),
                            enabled = decks.isNotEmpty()
                        )
                    }

                    if (importMode == "NEW") {
                        OutlinedTextField(
                            value = customDeckName,
                            onValueChange = { customDeckName = it },
                            label = { Text("Deck Name") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )
                    } else {
                        Box(modifier = Modifier.fillMaxWidth()) {
                            OutlinedButton(
                                onClick = { deckDropdownExpanded = true },
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        text = selectedDeck?.name ?: "Select Deck",
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                                }
                            }
                            DropdownMenu(
                                expanded = deckDropdownExpanded,
                                onDismissRequest = { deckDropdownExpanded = false }
                            ) {
                                decks.forEach { deck ->
                                    DropdownMenuItem(
                                        text = { Text(deck.name) },
                                        onClick = {
                                            selectedDeck = deck
                                            deckDropdownExpanded = false
                                        }
                                    )
                                }
                            }
                        }
                    }

                    // Duplicate Strategy
                    Text(
                        text = "Duplicate Handling",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                    Box(modifier = Modifier.fillMaxWidth()) {
                        OutlinedButton(
                            onClick = { dupDropdownExpanded = true },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = when (duplicateStrategy) {
                                        "SKIP" -> "Skip Existing Cards"
                                        "UPDATE" -> "Update Existing Cards"
                                        else -> "Import Duplicate Cards"
                                    },
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                            }
                        }
                        DropdownMenu(
                            expanded = dupDropdownExpanded,
                            onDismissRequest = { dupDropdownExpanded = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Update Existing Cards") },
                                onClick = { duplicateStrategy = "UPDATE"; dupDropdownExpanded = false }
                            )
                            DropdownMenuItem(
                                text = { Text("Skip Existing Cards") },
                                onClick = { duplicateStrategy = "SKIP"; dupDropdownExpanded = false }
                            )
                            DropdownMenuItem(
                                text = { Text("Import Duplicate Cards") },
                                onClick = { duplicateStrategy = "IMPORT"; dupDropdownExpanded = false }
                            )
                        }
                    }

                    // Question Language (Bilingual Books)
                    Text(
                        text = "Question Language (Bilingual PDFs)",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        PdfLanguageFilter.values().forEach { filter ->
                            FilterChip(
                                selected = selectedLanguageFilter == filter,
                                onClick = { selectedLanguageFilter = filter },
                                label = {
                                    Text(
                                        when (filter) {
                                            PdfLanguageFilter.BOTH -> "Both (Default)"
                                            PdfLanguageFilter.ENGLISH_ONLY -> "English"
                                            PdfLanguageFilter.HINDI_ONLY -> "Hindi"
                                        },
                                        style = MaterialTheme.typography.labelMedium
                                    )
                                },
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }

                    // Extraction Error Message if any
                    if (extractionError != null) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.errorContainer,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = extractionError ?: "",
                                color = MaterialTheme.colorScheme.onErrorContainer,
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                    }

                    // In-progress extraction status
                    if (isExtracting) {
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                        ) {
                            Column(
                                modifier = Modifier.padding(14.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text(
                                    text = progressStatus,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                                LinearProgressIndicator(
                                    progress = {
                                        if (progressTotal > 0) (progressCurrent.toFloat() / progressTotal).coerceIn(0f, 1f) else 0f
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(8.dp)
                                        .clip(RoundedCornerShape(4.dp))
                                )
                                Text(
                                    text = "$progressCurrent / $progressTotal pages processed",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Bottom Action Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    OutlinedButton(
                        onClick = onDismiss,
                        enabled = !isExtracting,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Cancel")
                    }

                    Button(
                        onClick = {
                            val qStart = qStartStr.toIntOrNull() ?: 1
                            val qEnd = qEndStr.toIntOrNull() ?: totalPages

                            if (isSegmentedMode && qStart > qEnd) {
                                extractionError = "Question Start page ($qStart) cannot exceed End page ($qEnd)."
                                return@Button
                            }

                            // Build segment list
                            val segments = mutableListOf<PdfSegmentConfig>()

                            if (isSegmentedMode) {
                                segments.add(
                                    PdfSegmentConfig(
                                        label = "Questions",
                                        pageStart = qStart.coerceAtLeast(1),
                                        pageEnd = qEnd.coerceAtLeast(qStart),
                                        role = PdfSegmentRole.QUESTIONS
                                    )
                                )
                                if (hasAnswerKey) {
                                    val kStart = keyStartStr.toIntOrNull() ?: qEnd
                                    val kEnd = keyEndStr.toIntOrNull() ?: kStart
                                    segments.add(
                                        PdfSegmentConfig(
                                            label = "Answer Key",
                                            pageStart = kStart.coerceAtLeast(1),
                                            pageEnd = kEnd.coerceAtLeast(kStart),
                                            role = PdfSegmentRole.ANSWER_KEY
                                        )
                                    )
                                }
                                if (hasExplanation) {
                                    val eStart = expStartStr.toIntOrNull() ?: qEnd
                                    val eEnd = expEndStr.toIntOrNull() ?: eStart
                                    segments.add(
                                        PdfSegmentConfig(
                                            label = "Explanations",
                                            pageStart = eStart.coerceAtLeast(1),
                                            pageEnd = eEnd.coerceAtLeast(eStart),
                                            role = PdfSegmentRole.EXPLANATION
                                        )
                                    )
                                }
                            } else {
                                segments.add(
                                    PdfSegmentConfig(
                                        label = "All Pages",
                                        pageStart = 1,
                                        pageEnd = totalPages,
                                        role = PdfSegmentRole.AUTO
                                    )
                                )
                            }

                            val targetId = if (importMode == "MERGE") selectedDeck?.id else null
                            val targetName = if (importMode == "MERGE") selectedDeck?.name else customDeckName.ifEmpty { defaultDeckName }

                            isExtracting = true
                            extractionError = null

                            coroutineScope.launch {
                                val result = repo.importPdfSegmented(
                                    uri = uri,
                                    segments = segments,
                                    duplicateStrategy = duplicateStrategy,
                                    targetDeckId = targetId,
                                    targetDeckName = targetName,
                                    columnMode = selectedColumnMode,
                                    languageFilter = selectedLanguageFilter,
                                    onProgress = { current, total, status ->
                                        progressCurrent = current
                                        progressTotal = total
                                        progressStatus = status
                                    }
                                )

                                isExtracting = false

                                if (result.success) {
                                    Toast.makeText(
                                        context,
                                        "Extracted ${result.totalCards} cards successfully!",
                                        Toast.LENGTH_LONG
                                    ).show()
                                    onSuccess(targetName ?: defaultDeckName, result.totalCards)
                                } else {
                                    extractionError = result.error ?: "Extraction failed."
                                }
                            }
                        },
                        enabled = !isExtracting,
                        modifier = Modifier.weight(1.5f)
                    ) {
                        Text(if (isExtracting) "Extracting..." else "Start Extraction")
                    }
                }
            }
        }
    }
}
