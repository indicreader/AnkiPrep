package com.example.flashcardapp.ui

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.flashcardapp.data.CsvImporter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CsvMappingDialog(
    uri: Uri,
    onDismiss: () -> Unit,
    onConfirm: (Map<Int, String>) -> Unit
) {
    val context = LocalContext.current
    var previewRows by remember { mutableStateOf<List<List<String>>>(emptyList()) }
    var headers by remember { mutableStateOf<List<String>>(emptyList()) }
    var columnCount by remember { mutableStateOf(0) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    // Map column index to mapping tag: "FRONT", "BACK", "EXPLANATION", "TAGS", "OPTION", "NONE"
    val columnMappings = remember { mutableStateMapOf<Int, String>() }

    // Delimiter tracking
    var detectedDelimiter by remember { mutableStateOf(',') }

    LaunchedEffect(uri) {
        try {
            val result = withContext(Dispatchers.IO) {
                val inputStream = context.contentResolver.openInputStream(uri)
                    ?: throw IllegalArgumentException("Cannot open file")

                val lines = mutableListOf<String>()
                BufferedReader(InputStreamReader(inputStream, Charsets.UTF_8)).use { reader ->
                    var line: String?
                    var count = 0
                    while (reader.readLine().also { line = it } != null && count < 6) {
                        val trimmed = line!!.trim()
                        if (trimmed.isNotEmpty()) {
                            lines.add(trimmed)
                            count++
                        }
                    }
                }

                if (lines.isEmpty()) {
                    throw IllegalStateException("File is empty")
                }

                // Detect delimiter using first line
                val firstLine = lines.first()
                val counts = mapOf(
                    ',' to firstLine.count { it == ',' },
                    ';' to firstLine.count { it == ';' },
                    '\t' to firstLine.count { it == '\t' }
                )
                val delim = counts.maxByOrNull { it.value }?.takeIf { it.value > 0 }?.key ?: ','

                // Parse rows helper
                val parsed = lines.map { CsvImporterJavaHelper.splitCsvLine(it, delim) }
                Triple(delim, parsed, lines)
            }

            detectedDelimiter = result.first
            val rows = result.second
            if (rows.isNotEmpty()) {
                val maxCols = rows.maxOf { it.size }
                columnCount = maxCols

                // Heuristic: check if first line is headers
                val headersList = mutableListOf<String>()
                val isHeader = CsvImporterJavaHelper.looksLikeHeader(result.third.first(), detectedDelimiter)
                
                if (isHeader) {
                    headers = rows.first()
                    previewRows = rows.drop(1)
                } else {
                    headers = (1..maxCols).map { "Column $it" }
                    previewRows = rows
                }

                // Initialize default mappings dynamically
                val headerRow = if (isHeader) rows.first().map { it.lowercase().trim().removeSurrounding("\"") } else emptyList()
                
                for (colIndex in 0 until maxCols) {
                    val headerName = headerRow.getOrNull(colIndex) ?: ""
                    columnMappings[colIndex] = when {
                        // 1. Heuristic based on header names:
                        headerName.contains("question") || headerName.contains("front") || headerName == "q" || headerName == "term" -> "FRONT"
                        headerName.contains("answer") || headerName.contains("back") || headerName == "a" || headerName == "definition" -> "BACK"
                        headerName.contains("explain") || headerName.contains("exp") || headerName == "notes" || headerName == "details" -> "EXPLANATION"
                        headerName.contains("tag") -> "TAGS"
                        headerName.contains("option") -> "OPTION"
                        
                        // 2. Count-based fallback if no header match:
                        else -> when (maxCols) {
                            3 -> when (colIndex) {
                                0 -> "FRONT"
                                1 -> "BACK"
                                2 -> "EXPLANATION"
                                else -> "NONE"
                            }
                            2 -> when (colIndex) {
                                0 -> "FRONT"
                                1 -> "BACK"
                                else -> "NONE"
                            }
                            else -> when (colIndex) {
                                0 -> "FRONT"
                                1 -> "BACK"
                                2 -> "TAGS"
                                3 -> "EXPLANATION"
                                else -> "NONE"
                            }
                        }
                    }
                }
            }
            isLoading = false
        } catch (e: Exception) {
            errorMessage = e.message ?: "Failed to read CSV preview"
            isLoading = false
        }
    }

    val isValid = columnMappings.values.contains("FRONT") && columnMappings.values.contains("BACK")

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .fillMaxHeight(0.85f),
            shape = RoundedCornerShape(28.dp),
            color = MaterialTheme.colorScheme.background,
            tonalElevation = 6.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Header
                Text(
                    text = "CSV Column Mapping Wizard",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )

                if (isLoading) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
                    }
                } else if (errorMessage != null) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = errorMessage ?: "",
                            color = MaterialTheme.colorScheme.error,
                            textAlign = TextAlign.Center
                        )
                    }
                } else {
                    Text(
                        text = "Map the columns of your CSV file to Ankiprep flashcard properties. Question and Answer mappings are required.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    // Error indicator if invalid
                    if (!isValid) {
                        Surface(
                            color = MaterialTheme.colorScheme.errorContainer,
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(Icons.Outlined.Info, contentDescription = null, tint = MaterialTheme.colorScheme.error)
                                Text(
                                    text = "Please map exactly one column to Question (Front) and at least one to Answer (Back).",
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onErrorContainer
                                )
                            }
                        }
                    }

                    // Column mapping grid container
                    val scrollState = rememberScrollState()

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .border(1.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(16.dp))
                            .clip(RoundedCornerShape(16.dp))
                            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f))
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .horizontalScroll(scrollState)
                        ) {
                            // Headers with dropdown selectors
                            Row(
                                modifier = Modifier
                                    .background(MaterialTheme.colorScheme.surfaceVariant)
                                    .padding(vertical = 12.dp)
                            ) {
                                for (colIndex in 0 until columnCount) {
                                    Column(
                                        modifier = Modifier
                                            .width(180.dp)
                                            .padding(horizontal = 8.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = headers.getOrNull(colIndex) ?: "Column ${colIndex + 1}",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 13.sp,
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )

                                        Spacer(Modifier.height(6.dp))

                                        // Selection Dropdown Trigger
                                        var dropdownExpanded by remember { mutableStateOf(false) }
                                        val currentMap = columnMappings[colIndex] ?: "NONE"
                                        val dropdownLabel = when (currentMap) {
                                            "FRONT" -> "Map: Question"
                                            "BACK" -> "Map: Answer"
                                            "EXPLANATION" -> "Map: Rationale"
                                            "TAGS" -> "Map: Tags"
                                            "OPTION" -> "Map: Option"
                                            else -> "Ignore Column"
                                        }

                                        Box {
                                            Surface(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .clickable { dropdownExpanded = true },
                                                shape = RoundedCornerShape(8.dp),
                                                color = when (currentMap) {
                                                    "FRONT", "BACK" -> MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)
                                                    "NONE" -> MaterialTheme.colorScheme.outline.copy(alpha = 0.1f)
                                                    else -> MaterialTheme.colorScheme.secondary.copy(alpha = 0.12f)
                                                },
                                                border = borderStrokeForMap(currentMap)
                                            ) {
                                                Row(
                                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                                                    horizontalArrangement = Arrangement.SpaceBetween,
                                                    verticalAlignment = Alignment.CenterVertically
                                                ) {
                                                    Text(
                                                        text = dropdownLabel,
                                                        fontSize = 11.sp,
                                                        fontWeight = FontWeight.Bold,
                                                        color = when (currentMap) {
                                                            "FRONT", "BACK" -> MaterialTheme.colorScheme.primary
                                                            "NONE" -> MaterialTheme.colorScheme.onSurfaceVariant
                                                            else -> MaterialTheme.colorScheme.secondary
                                                        }
                                                    )
                                                    Icon(
                                                        Icons.Outlined.ArrowDropDown,
                                                        contentDescription = null,
                                                        modifier = Modifier.size(16.dp)
                                                    )
                                                }
                                            }

                                            DropdownMenu(
                                                expanded = dropdownExpanded,
                                                onDismissRequest = { dropdownExpanded = false }
                                            ) {
                                                DropdownMenuItem(
                                                    text = { Text("Map to Question Content") },
                                                    onClick = {
                                                        // Ensure uniqueness of Question
                                                        columnMappings.forEach { (k, v) -> if (v == "FRONT") columnMappings[k] = "NONE" }
                                                        columnMappings[colIndex] = "FRONT"
                                                        dropdownExpanded = false
                                                    }
                                                )
                                                DropdownMenuItem(
                                                    text = { Text("Map to Option / Answer") },
                                                    onClick = {
                                                        columnMappings[colIndex] = "BACK"
                                                        dropdownExpanded = false
                                                    }
                                                )
                                                DropdownMenuItem(
                                                    text = { Text("Map to Option Distractor") },
                                                    onClick = {
                                                        columnMappings[colIndex] = "OPTION"
                                                        dropdownExpanded = false
                                                    }
                                                )
                                                DropdownMenuItem(
                                                    text = { Text("Map to Rationale/Explanations") },
                                                    onClick = {
                                                        columnMappings[colIndex] = "EXPLANATION"
                                                        dropdownExpanded = false
                                                    }
                                                )
                                                DropdownMenuItem(
                                                    text = { Text("Map to Tags") },
                                                    onClick = {
                                                        columnMappings[colIndex] = "TAGS"
                                                        dropdownExpanded = false
                                                    }
                                                )
                                                DropdownMenuItem(
                                                    text = { Text("Ignore Column") },
                                                    onClick = {
                                                        columnMappings[colIndex] = "NONE"
                                                        dropdownExpanded = false
                                                    }
                                                )
                                            }
                                        }
                                    }
                                }
                            }

                            // Preview Data Rows
                            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                                items(previewRows) { row ->
                                    Row(
                                        modifier = Modifier
                                            .border(width = 0.5.dp, color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
                                            .padding(vertical = 8.dp)
                                    ) {
                                        for (colIndex in 0 until columnCount) {
                                            val cellVal = row.getOrNull(colIndex) ?: ""
                                            Box(
                                                modifier = Modifier
                                                    .width(180.dp)
                                                    .padding(horizontal = 12.dp)
                                            ) {
                                                Text(
                                                    text = cellVal,
                                                    fontSize = 12.sp,
                                                    maxLines = 2,
                                                    overflow = TextOverflow.Ellipsis,
                                                    color = MaterialTheme.colorScheme.onSurface
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                // Footer Controls
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }

                    Spacer(Modifier.width(8.dp))

                    Button(
                        onClick = {
                            val finalMap = columnMappings.toMap().filter { it.value != "NONE" }
                            onConfirm(finalMap)
                        },
                        enabled = isValid && !isLoading,
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Confirm Mappings")
                    }
                }
            }
        }
    }
}

@Composable
private fun borderStrokeForMap(mapping: String): androidx.compose.foundation.BorderStroke? {
    return when (mapping) {
        "FRONT", "BACK" -> androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
        "NONE" -> null
        else -> androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.secondary)
    }
}

object CsvImporterJavaHelper {
    fun splitCsvLine(line: String, delimiter: Char): List<String> {
        val result = mutableListOf<String>()
        val current = StringBuilder()
        var inQuotes = false
        var i = 0
        while (i < line.length) {
            val c = line[i]
            when {
                c == '"' && !inQuotes -> inQuotes = true
                c == '"' && inQuotes && i + 1 < line.length && line[i + 1] == '"' -> {
                    current.append('"'); i++
                }
                c == '"' && inQuotes -> inQuotes = false
                c == delimiter && !inQuotes -> {
                    result.add(current.toString())
                    current.clear()
                }
                else -> current.append(c)
            }
            i++
        }
        result.add(current.toString())
        return result
    }

    fun looksLikeHeader(firstLine: String, delimiter: Char): Boolean {
        val parts = splitCsvLine(firstLine, delimiter)
        val headers = setOf("front", "back", "question", "answer", "term", "definition", "q", "a", "tags")
        val first = parts.getOrNull(0)?.trim()?.trimQuotes()?.lowercase() ?: return false
        return first in headers
    }

    private fun String.trimQuotes(): String {
        return if (length >= 2 && startsWith('"') && endsWith('"')) {
            substring(1, length - 1)
        } else this
    }
}
