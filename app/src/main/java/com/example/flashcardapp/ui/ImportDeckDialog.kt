package com.example.flashcardapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.flashcardapp.data.AnkiDeck

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImportDeckDialog(
    fileType: String,
    decks: List<AnkiDeck>,
    onDismiss: () -> Unit,
    onNewDeck: (customName: String, duplicateStrategy: String) -> Unit,
    onMergeIntoDeck: (targetId: Long, targetName: String, duplicateStrategy: String) -> Unit
) {
    var importMode by remember { mutableStateOf("NEW") } // "NEW" or "MERGE"
    var customDeckName by remember { mutableStateOf("") }
    var selectedDeck by remember { mutableStateOf<AnkiDeck?>(decks.firstOrNull()) }
    var duplicateStrategy by remember { mutableStateOf("UPDATE") } // "SKIP", "IMPORT", "UPDATE"
    var deckDropdownExpanded by remember { mutableStateOf(false) }
    var dupDropdownExpanded by remember { mutableStateOf(false) }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(28.dp),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 6.dp,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Import $fileType",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onSurface
                )

                // Import Mode selection
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
                        label = { Text("Merge into Existing") },
                        modifier = Modifier.weight(1f),
                        enabled = decks.isNotEmpty()
                    )
                }

                if (importMode == "NEW") {
                    OutlinedTextField(
                        value = customDeckName,
                        onValueChange = { customDeckName = it },
                        label = { Text("Deck Name (optional)") },
                        placeholder = { Text("Leave blank for file name") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                } else {
                    // Dropdown to select existing deck
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
                            decks.forEach { d ->
                                DropdownMenuItem(
                                    text = { Text(d.name) },
                                    onClick = {
                                        selectedDeck = d
                                        deckDropdownExpanded = false
                                    }
                                )
                            }
                        }
                    }
                }

                // Duplicate Handling Strategy Selection
                Text(
                    text = "Duplicate Handling",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
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
                            val strategyLabel = when (duplicateStrategy) {
                                "SKIP" -> "Skip Duplicates"
                                "IMPORT" -> "Import Duplicates"
                                else -> "Update Existing (Overwrite)"
                            }
                            Text(text = strategyLabel, color = MaterialTheme.colorScheme.onSurface)
                            Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                        }
                    }
                    DropdownMenu(
                        expanded = dupDropdownExpanded,
                        onDismissRequest = { dupDropdownExpanded = false }
                    ) {
                        listOf(
                            "UPDATE" to "Update Existing (Overwrite)",
                            "SKIP" to "Skip Duplicates",
                            "IMPORT" to "Import Duplicates"
                        ).forEach { (value, label) ->
                            DropdownMenuItem(
                                text = { Text(label) },
                                onClick = {
                                    duplicateStrategy = value
                                    dupDropdownExpanded = false
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Actions
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            if (importMode == "NEW") {
                                onNewDeck(customDeckName.trim(), duplicateStrategy)
                            } else {
                                selectedDeck?.let {
                                    onMergeIntoDeck(it.id, it.name, duplicateStrategy)
                                }
                            }
                        }
                    ) {
                        Text("Import")
                    }
                }
            }
        }
    }
}
