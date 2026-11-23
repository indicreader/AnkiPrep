package com.example.flashcardapp.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.data.AnkiDeck
import com.example.flashcardapp.data.AnkiDroidBridge
import com.example.flashcardapp.data.AnkiDroidFieldMapping
import com.example.flashcardapp.data.DeckHierarchyUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnkiDroidImportDialog(
    existingDecks: List<AnkiDeck>,
    onImport: (deckId: Long, targetHierarchy: String, duplicateStrategy: String, mapping: AnkiDroidFieldMapping) -> Unit,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    val ankiDecks = remember { AnkiDroidBridge.getDecks(context) }
    var searchQuery by remember { mutableStateOf("") }
    var selectedAnkiDeck by remember { mutableStateOf<AnkiDeck?>(null) }

    // Destination settings
    var destinationMode by remember { mutableStateOf("NEW") } // "NEW", "NEST", "MERGE"
    var customDeckName by remember { mutableStateOf("") }
    var selectedParentDeck by remember { mutableStateOf<AnkiDeck?>(null) }
    var selectedMergeDeck by remember { mutableStateOf<AnkiDeck?>(null) }

    var duplicateStrategy by remember { mutableStateOf("UPDATE") } // "UPDATE", "SKIP", "IMPORT"
    var showDupDropdown by remember { mutableStateOf(false) }
    var showParentDropdown by remember { mutableStateOf(false) }
    var showMergeDropdown by remember { mutableStateOf(false) }

    // Field mapping
    var fieldSamples by remember { mutableStateOf<List<List<String>>>(emptyList()) }
    var questionFieldIndex by remember { mutableStateOf(0) }
    var answerFieldIndex by remember { mutableStateOf(1) }
    var explanationFieldIndex by remember { mutableStateOf<Int?>(-1) } // -1 means None
    var showMappingCustomizer by remember { mutableStateOf(false) }

    // Load samples when anki deck changes
    LaunchedEffect(selectedAnkiDeck) {
        val deck = selectedAnkiDeck
        if (deck != null) {
            customDeckName = deck.name
            val samples = AnkiDroidBridge.getNoteFieldSamples(context, deck.id, limit = 3)
            fieldSamples = samples
            if (samples.isNotEmpty()) {
                val firstSample = samples.first()
                val fieldCount = firstSample.size
                questionFieldIndex = 0
                answerFieldIndex = if (fieldCount > 1) 1 else 0
                explanationFieldIndex = if (fieldCount > 2) 2 else -1
                showMappingCustomizer = fieldCount > 2
            }
        }
    }

    val sampleNote = fieldSamples.firstOrNull()
    val fieldCount = sampleNote?.size ?: 0

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Download, null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(24.dp))
                Spacer(Modifier.width(8.dp))
                Text("Import from AnkiDroid", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)
            }
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 520.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                if (selectedAnkiDeck == null) {
                    // Step 1: Select Deck from AnkiDroid
                    Text(
                        "Select an AnkiDroid deck to import into AnkiPrep:",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("Search AnkiDroid decks...") },
                        leadingIcon = { Icon(Icons.Default.Search, null) },
                        singleLine = true,
                        shape = RoundedCornerShape(12.dp)
                    )

                    val filteredDecks = ankiDecks.filter {
                        it.name.contains(searchQuery, ignoreCase = true)
                    }

                    if (filteredDecks.isEmpty()) {
                        Box(modifier = Modifier.fillMaxWidth().padding(24.dp), contentAlignment = Alignment.Center) {
                            Text(
                                if (ankiDecks.isEmpty()) "No decks found in AnkiDroid." else "No matching decks found.",
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    } else {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f, fill = false),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            items(filteredDecks, key = { it.id }) { deck ->
                                Surface(
                                    shape = RoundedCornerShape(10.dp),
                                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { selectedAnkiDeck = deck }
                                ) {
                                    Row(
                                        modifier = Modifier.padding(12.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(Icons.Default.Folder, null, tint = MaterialTheme.colorScheme.primary)
                                        Spacer(Modifier.width(10.dp))
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(deck.name, fontWeight = FontWeight.SemiBold, maxLines = 1, overflow = TextOverflow.Ellipsis)
                                            if (deck.cardCount > 0) {
                                                Text("${deck.cardCount} cards", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                            }
                                        }
                                        Icon(Icons.Default.ChevronRight, null, tint = MaterialTheme.colorScheme.onSurfaceVariant)
                                    }
                                }
                            }
                        }
                    }
                } else {
                    // Step 2 & 3: Selected Deck Configurations
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f, fill = false),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        item {
                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.padding(10.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(Icons.Default.FolderOpen, null, tint = MaterialTheme.colorScheme.primary)
                                    Spacer(Modifier.width(8.dp))
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text("Selected AnkiDroid Deck:", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
                                        Text(selectedAnkiDeck!!.name, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
                                    }
                                    TextButton(onClick = { selectedAnkiDeck = null }) {
                                        Text("Change")
                                    }
                                }
                            }
                        }

                        // Destination Selector
                        item {
                            Text("Target Destination in AnkiPrep", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleSmall)
                            Spacer(Modifier.height(4.dp))
                            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    RadioButton(selected = destinationMode == "NEW", onClick = { destinationMode = "NEW" })
                                    Text("Create as New Deck (use '::' to nest)", modifier = Modifier.clickable { destinationMode = "NEW" })
                                }
                                if (destinationMode == "NEW") {
                                    OutlinedTextField(
                                        value = customDeckName,
                                        onValueChange = { customDeckName = it },
                                        label = { Text("Deck Name") },
                                        singleLine = true,
                                        modifier = Modifier.fillMaxWidth().padding(start = 32.dp)
                                    )
                                }

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    RadioButton(selected = destinationMode == "NEST", onClick = { destinationMode = "NEST" })
                                    Text("Nest under Existing Deck", modifier = Modifier.clickable { destinationMode = "NEST" })
                                }
                                if (destinationMode == "NEST") {
                                    Box(modifier = Modifier.fillMaxWidth().padding(start = 32.dp)) {
                                        OutlinedCard(
                                            modifier = Modifier.fillMaxWidth().clickable { showParentDropdown = true },
                                            shape = RoundedCornerShape(8.dp)
                                        ) {
                                            Text(
                                                selectedParentDeck?.name ?: "Select parent master deck...",
                                                modifier = Modifier.padding(12.dp)
                                            )
                                        }
                                        DropdownMenu(expanded = showParentDropdown, onDismissRequest = { showParentDropdown = false }) {
                                            existingDecks.forEach { deck ->
                                                DropdownMenuItem(
                                                    text = { Text(deck.name) },
                                                    onClick = {
                                                        selectedParentDeck = deck
                                                        showParentDropdown = false
                                                    }
                                                )
                                            }
                                        }
                                    }
                                }

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    RadioButton(selected = destinationMode == "MERGE", onClick = { destinationMode = "MERGE" })
                                    Text("Merge into Existing Deck", modifier = Modifier.clickable { destinationMode = "MERGE" })
                                }
                                if (destinationMode == "MERGE") {
                                    Box(modifier = Modifier.fillMaxWidth().padding(start = 32.dp)) {
                                        OutlinedCard(
                                            modifier = Modifier.fillMaxWidth().clickable { showMergeDropdown = true },
                                            shape = RoundedCornerShape(8.dp)
                                        ) {
                                            Text(
                                                selectedMergeDeck?.name ?: "Select target deck to merge into...",
                                                modifier = Modifier.padding(12.dp)
                                            )
                                        }
                                        DropdownMenu(expanded = showMergeDropdown, onDismissRequest = { showMergeDropdown = false }) {
                                            existingDecks.forEach { deck ->
                                                DropdownMenuItem(
                                                    text = { Text(deck.name) },
                                                    onClick = {
                                                        selectedMergeDeck = deck
                                                        showMergeDropdown = false
                                                    }
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        // Duplicate Handling
                        item {
                            Text("Duplicate Handling", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleSmall)
                            Box(modifier = Modifier.fillMaxWidth()) {
                                OutlinedCard(
                                    modifier = Modifier.fillMaxWidth().clickable { showDupDropdown = true },
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Text(
                                        when (duplicateStrategy) {
                                            "SKIP" -> "Skip Duplicates"
                                            "IMPORT" -> "Import Duplicates"
                                            else -> "Update Existing (Overwrite)"
                                        },
                                        modifier = Modifier.padding(12.dp)
                                    )
                                }
                                DropdownMenu(expanded = showDupDropdown, onDismissRequest = { showDupDropdown = false }) {
                                    listOf(
                                        "UPDATE" to "Update Existing (Overwrite)",
                                        "SKIP" to "Skip Duplicates",
                                        "IMPORT" to "Import Duplicates"
                                    ).forEach { (strat, label) ->
                                        DropdownMenuItem(
                                            text = { Text(label) },
                                            onClick = {
                                                duplicateStrategy = strat
                                                showDupDropdown = false
                                            }
                                        )
                                    }
                                }
                            }
                        }

                        // Field Mapping Section
                        item {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    "Field Mapping (${fieldCount} note fields)",
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.titleSmall
                                )
                                TextButton(onClick = { showMappingCustomizer = !showMappingCustomizer }) {
                                    Text(if (showMappingCustomizer) "Hide Options" else "Customize")
                                }
                            }

                            if (showMappingCustomizer && fieldCount > 0) {
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(8.dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f), RoundedCornerShape(10.dp))
                                        .padding(10.dp)
                                ) {
                                    // Question Field
                                    Text("Question Field:", style = MaterialTheme.typography.labelSmall)
                                    ScrollableFieldSelector(
                                        fieldCount = fieldCount,
                                        sampleValues = sampleNote ?: emptyList(),
                                        selectedIndex = questionFieldIndex,
                                        onSelect = { questionFieldIndex = it }
                                    )

                                    // Answer Field
                                    Text("Answer Field:", style = MaterialTheme.typography.labelSmall)
                                    ScrollableFieldSelector(
                                        fieldCount = fieldCount,
                                        sampleValues = sampleNote ?: emptyList(),
                                        selectedIndex = answerFieldIndex,
                                        onSelect = { answerFieldIndex = it }
                                    )

                                    // Explanation Field (Optional)
                                    Text("Explanation Field (Optional):", style = MaterialTheme.typography.labelSmall)
                                    ScrollableFieldSelector(
                                        fieldCount = fieldCount,
                                        sampleValues = sampleNote ?: emptyList(),
                                        selectedIndex = explanationFieldIndex ?: -1,
                                        allowNone = true,
                                        onSelect = { explanationFieldIndex = it }
                                    )
                                }
                            }
                        }

                        // Live Card Preview
                        if (sampleNote != null) {
                            item {
                                Text("Live Card Preview", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelMedium)
                                val qText = sampleNote.getOrNull(questionFieldIndex)?.take(120) ?: "Question"
                                val aText = sampleNote.getOrNull(answerFieldIndex)?.take(80) ?: "Answer"
                                val expText = explanationFieldIndex?.let { if (it >= 0) sampleNote.getOrNull(it)?.take(100) else null }

                                Surface(
                                    shape = RoundedCornerShape(10.dp),
                                    color = MaterialTheme.colorScheme.surface,
                                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                        Text(
                                            text = "❓ ${DeckHierarchyUtils.stripHtml(qText)}",
                                            fontWeight = FontWeight.SemiBold,
                                            style = MaterialTheme.typography.bodySmall,
                                            maxLines = 2,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                        Text(
                                            text = "✅ ${DeckHierarchyUtils.stripHtml(aText)}",
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.primary,
                                            style = MaterialTheme.typography.bodySmall,
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                        if (!expText.isNullOrBlank()) {
                                            Text(
                                                text = "📖 ${DeckHierarchyUtils.stripHtml(expText)}",
                                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                                style = MaterialTheme.typography.bodySmall,
                                                maxLines = 2,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {
            if (selectedAnkiDeck != null) {
                Button(
                    onClick = {
                        val deck = selectedAnkiDeck ?: return@Button
                        val targetHierarchy = when (destinationMode) {
                            "NEST" -> {
                                val parent = selectedParentDeck?.name ?: "Anki Decks"
                                "$parent::${DeckHierarchyUtils.getLeafDeckName(deck.name)}"
                            }
                            "MERGE" -> selectedMergeDeck?.name ?: deck.name
                            else -> if (customDeckName.isNotBlank()) customDeckName.trim() else deck.name
                        }

                        val mapping = AnkiDroidFieldMapping(
                            questionFieldIndex = questionFieldIndex,
                            answerFieldIndex = answerFieldIndex,
                            explanationFieldIndex = if (explanationFieldIndex != null && explanationFieldIndex!! >= 0) explanationFieldIndex else null
                        )

                        onImport(deck.id, targetHierarchy, duplicateStrategy, mapping)
                        onDismiss()
                    },
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text("Import Deck")
                }
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(if (selectedAnkiDeck != null) "Back" else "Cancel")
            }
        }
    )
}

@Composable
private fun ScrollableFieldSelector(
    fieldCount: Int,
    sampleValues: List<String>,
    selectedIndex: Int,
    allowNone: Boolean = false,
    onSelect: (Int) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        if (allowNone) {
            FilterChip(
                selected = selectedIndex == -1,
                onClick = { onSelect(-1) },
                label = { Text("None") }
            )
        }
        for (i in 0 until fieldCount) {
            val sample = sampleValues.getOrNull(i)?.take(15) ?: ""
            val label = if (sample.isNotBlank()) "Fld $i: '$sample'" else "Field $i"
            FilterChip(
                selected = selectedIndex == i,
                onClick = { onSelect(i) },
                label = { Text(label, maxLines = 1, overflow = TextOverflow.Ellipsis) }
            )
        }
    }
}
