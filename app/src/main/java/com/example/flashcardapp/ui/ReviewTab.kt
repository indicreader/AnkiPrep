package com.example.flashcardapp.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar
import com.example.flashcardapp.data.AnkiDeck
import com.example.flashcardapp.data.entities.SessionRecordEntity
import com.example.flashcardapp.session.McqSessionMode
import com.example.flashcardapp.data.SettingsRepository
import androidx.compose.ui.platform.LocalContext
import com.example.flashcardapp.ui.theme.PrimaryPurple
import com.example.flashcardapp.ui.theme.TextSecondaryGray

// ── Data models & tree helpers ────────────────────────────────────────────────

data class DeckNode(
    val deck: AnkiDeck?,
    val shortName: String,
    val fullPath: String,
    val children: MutableList<DeckNode> = mutableListOf()
)

fun buildDeckTree(decks: List<AnkiDeck>): List<DeckNode> {
    val rootNodes = mutableListOf<DeckNode>()
    val nodeMap = mutableMapOf<String, DeckNode>()
    for (deck in decks.sortedBy { it.name }) {
        val parts = deck.name.split("::")
        var currentPath = ""
        var parentNode: DeckNode? = null
        for (i in parts.indices) {
            val part = parts[i]
            currentPath = if (currentPath.isEmpty()) part else "$currentPath::$part"
            var node = nodeMap[currentPath]
            if (node == null) {
                node = DeckNode(deck = if (i == parts.lastIndex) deck else null, shortName = part, fullPath = currentPath)
                nodeMap[currentPath] = node
                if (parentNode == null) rootNodes.add(node) else parentNode.children.add(node)
            } else if (i == parts.lastIndex && node.deck == null) {
                val updated = DeckNode(deck = deck, shortName = node.shortName, fullPath = node.fullPath, children = node.children)
                nodeMap[currentPath] = updated
                if (parentNode == null) {
                    val idx = rootNodes.indexOfFirst { it.fullPath == currentPath }
                    if (idx != -1) rootNodes[idx] = updated
                } else {
                    val idx = parentNode.children.indexOfFirst { it.fullPath == currentPath }
                    if (idx != -1) parentNode.children[idx] = updated
                }
                node = updated
            }
            parentNode = node
        }
    }
    return rootNodes
}

fun filterDeckTree(nodes: List<DeckNode>, query: String): List<DeckNode> {
    if (query.isBlank()) return nodes
    return nodes.mapNotNull { node ->
        val filteredChildren = filterDeckTree(node.children, query)
        val matches = node.shortName.contains(query, true) || node.fullPath.contains(query, true)
        if (matches || filteredChildren.isNotEmpty())
            DeckNode(deck = node.deck, shortName = node.shortName, fullPath = node.fullPath, children = filteredChildren.toMutableList())
        else null
    }
}

// ── Deck options dropdown ─────────────────────────────────────────────────────

@Composable
fun DeckOptionsMenu(
    node: DeckNode,
    expanded: Boolean,
    onDismiss: () -> Unit,
    onStudy: () -> Unit,
    onAddCard: () -> Unit,
    onEditCards: () -> Unit,
    onRename: () -> Unit,
    onClearProgress: () -> Unit,
    onDelete: () -> Unit,
    onExport: () -> Unit
) {
    DropdownMenu(
        expanded = expanded, 
        onDismissRequest = onDismiss,
        modifier = Modifier.background(MaterialTheme.colorScheme.surface)
    ) {
        DropdownMenuItem(
            text = { Text("Study Now", fontWeight = FontWeight.SemiBold) },
            leadingIcon = { Icon(Icons.Default.PlayArrow, null, tint = MaterialTheme.colorScheme.primary) },
            onClick = { onDismiss(); onStudy() }
        )
        DropdownMenuItem(
            text = { Text("Add Card") },
            leadingIcon = { Icon(Icons.Default.Add, null, tint = MaterialTheme.colorScheme.secondary) },
            onClick = { onDismiss(); onAddCard() }
        )
        DropdownMenuItem(
            text = { Text("Edit Cards") },
            leadingIcon = { Icon(Icons.Default.Edit, null, tint = MaterialTheme.colorScheme.secondary) },
            onClick = { onDismiss(); onEditCards() }
        )
        DropdownMenuItem(
            text = { Text("Rename Deck") },
            leadingIcon = { Icon(Icons.Default.Edit, null, tint = MaterialTheme.colorScheme.secondary) },
            onClick = { onDismiss(); onRename() }
        )
        DropdownMenuItem(
            text = { Text("Clear Progress") },
            leadingIcon = { Icon(Icons.Default.Refresh, null, tint = MaterialTheme.colorScheme.tertiary) },
            onClick = { onDismiss(); onClearProgress() }
        )
        DropdownMenuItem(
            text = { Text("Export Deck") },
            leadingIcon = { Icon(Icons.Default.Share, null, tint = MaterialTheme.colorScheme.primary) },
            onClick = { onDismiss(); onExport() }
        )
        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
        DropdownMenuItem(
            text = { Text("Delete Deck", color = MaterialTheme.colorScheme.error) },
            leadingIcon = { Icon(Icons.Default.Delete, null, tint = MaterialTheme.colorScheme.error) },
            onClick = { onDismiss(); onDelete() }
        )
    }
}

// ── Dialogs ───────────────────────────────────────────────────────────────────

@Composable
fun RenameDialog(currentName: String, onConfirm: (String) -> Unit, onDismiss: () -> Unit) {
    var text by remember { mutableStateOf(currentName) }
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Rename Deck", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold) },
        text = {
            OutlinedTextField(
                value = text, onValueChange = { text = it },
                label = { Text("Deck name") }, singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    focusedLabelColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        confirmButton = {
            Button(
                onClick = { if (text.isNotBlank()) onConfirm(text.trim()) },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) { Text("Rename") }
        },
        dismissButton = { 
            TextButton(onClick = onDismiss) { Text("Cancel", color = MaterialTheme.colorScheme.primary) } 
        }
    )
}

@Composable
fun ConfirmDialog(title: String, body: String, confirmLabel: String, danger: Boolean = false, onConfirm: () -> Unit, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold) },
        text = { Text(body, color = MaterialTheme.colorScheme.onSurfaceVariant) },
        confirmButton = {
            Button(
                onClick = onConfirm,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (danger) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
                )
            ) {
                Text(confirmLabel, color = if (danger) MaterialTheme.colorScheme.onError else MaterialTheme.colorScheme.onPrimary)
            }
        },
        dismissButton = { 
            TextButton(onClick = onDismiss) { Text("Cancel", color = MaterialTheme.colorScheme.primary) } 
        }
    )
}

@Composable
fun CreateDeckDialog(onConfirm: (String) -> Unit, onDismiss: () -> Unit) {
    var text by remember { mutableStateOf("") }
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Create Deck", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold) },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Use '::' to nest decks. Example: Physics::Mechanics", color = MaterialTheme.colorScheme.onSurfaceVariant, style = MaterialTheme.typography.bodySmall)
                OutlinedTextField(
                    value = text, onValueChange = { text = it }, label = { Text("Deck name") }, singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        focusedLabelColor = MaterialTheme.colorScheme.primary
                    )
                )
            }
        },
        confirmButton = {
            Button(
                onClick = { if (text.isNotBlank()) onConfirm(text.trim()) },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) { Text("Create") }
        },
        dismissButton = { 
            TextButton(onClick = onDismiss) { Text("Cancel", color = MaterialTheme.colorScheme.primary) } 
        }
    )
}

@Composable
fun DeckSettingsDialog(
    deck: AnkiDeck,
    currentMode: McqSessionMode?,
    onModeChanged: (McqSessionMode?) -> Unit,
    onDismiss: () -> Unit
) {
    var selectedMode by remember { mutableStateOf(currentMode) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Deck Settings: ${deck.name}", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold) },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Text("Select Default Study Mode for this deck:", color = MaterialTheme.colorScheme.onSurfaceVariant)
                
                val modes = listOf(
                    null to "Global Default",
                    McqSessionMode.PRACTICE to "Practice Mode",
                    McqSessionMode.REVISION to "Revision Mode",
                    McqSessionMode.TEST to "Test Mode"
                )
                
                modes.forEach { (mode, label) ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { selectedMode = mode }
                            .padding(vertical = 8.dp)
                    ) {
                        RadioButton(
                            selected = (selectedMode == mode),
                            onClick = { selectedMode = mode },
                            colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colorScheme.primary)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(label, style = MaterialTheme.typography.bodyLarge)
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = { 
                    onModeChanged(selectedMode)
                    onDismiss()
                },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) { Text("Save") }
        },
        dismissButton = { 
            TextButton(onClick = onDismiss) { Text("Cancel", color = MaterialTheme.colorScheme.primary) } 
        }
    )
}

// ── Merge-CSV Dialog ─────────────────────────────────────────────────────────

/**
 * Dialog shown after the user picks a CSV file — lets them choose
 * "New Deck" (default) or "Merge into: [existing deck]".
 *
 * @param decks             Existing decks the CSV can be merged into.
 * @param onNewDeck         User wants to create a brand-new deck from the CSV.
 * @param onMergeIntoDeck   User chose a target deck; callback receives (deckId, deckName).
 * @param onDismiss         User cancelled without importing.
 */
@Composable
fun MergeCsvDialog(
    decks: List<AnkiDeck>,
    onNewDeck: () -> Unit,
    onMergeIntoDeck: (Long, String) -> Unit,
    onDismiss: () -> Unit
) {
    // null = "New Deck" selected; non-null = user picked a target for merging
    var selectedDeck by remember { mutableStateOf<AnkiDeck?>(null) }
    // false = create new deck, true = merge into existing
    var mergeMode by remember { mutableStateOf(false) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Icon(Icons.Default.Share, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                Text("Import CSV", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            }
        },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(
                    "Choose how to import the selected CSV file:",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                // ── Option A: New Deck ───────────────────────────────────────
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { mergeMode = false; selectedDeck = null },
                    colors = CardDefaults.cardColors(
                        containerColor = if (!mergeMode)
                            MaterialTheme.colorScheme.primaryContainer
                        else
                            MaterialTheme.colorScheme.surface
                    ),
                    border = BorderStroke(
                        if (!mergeMode) 2.dp else 1.dp,
                        if (!mergeMode) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.outlineVariant
                    ),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        RadioButton(
                            selected = !mergeMode,
                            onClick = { mergeMode = false; selectedDeck = null },
                            colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colorScheme.primary)
                        )
                        Column {
                            Text("Create New Deck", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.SemiBold)
                            Text("Deck name is taken from the filename", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                }

                // ── Option B: Merge ──────────────────────────────────────────
                if (decks.isNotEmpty()) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { mergeMode = true },
                        colors = CardDefaults.cardColors(
                            containerColor = if (mergeMode)
                                MaterialTheme.colorScheme.primaryContainer
                            else
                                MaterialTheme.colorScheme.surface
                        ),
                        border = BorderStroke(
                            if (mergeMode) 2.dp else 1.dp,
                            if (mergeMode) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.outlineVariant
                        ),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                RadioButton(
                                    selected = mergeMode,
                                    onClick = { mergeMode = true },
                                    colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colorScheme.primary)
                                )
                                Column {
                                    Text("Merge into Existing Deck", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.SemiBold)
                                    Text("Append cards to a deck you already have", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                }
                            }

                            if (mergeMode) {
                                // Deck picker — scrollable list
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 44.dp),
                                    verticalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Text(
                                        "Select target deck:",
                                        style = MaterialTheme.typography.labelMedium,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    decks.take(8).forEach { deck ->
                                        val isSelected = selectedDeck?.id == deck.id
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .clip(MaterialTheme.shapes.small)
                                                .background(
                                                    if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
                                                    else Color.Transparent
                                                )
                                                .clickable { selectedDeck = deck }
                                                .padding(horizontal = 8.dp, vertical = 6.dp),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                                        ) {
                                            Icon(
                                                imageVector = if (isSelected) Icons.Default.Check else Icons.AutoMirrored.Filled.List,
                                                contentDescription = null,
                                                tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
                                                modifier = Modifier.size(16.dp)
                                            )
                                            Text(
                                                text = deck.name.split("::").last(),
                                                style = MaterialTheme.typography.bodyMedium,
                                                color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                                                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
                                            )
                                        }
                                    }
                                    if (decks.size > 8) {
                                        Text(
                                            "+ ${decks.size - 8} more decks (search to filter)",
                                            style = MaterialTheme.typography.bodySmall,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                                            modifier = Modifier.padding(start = 24.dp, top = 2.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (mergeMode) {
                        val target = selectedDeck
                        if (target != null) {
                            onMergeIntoDeck(target.id, target.name)
                        }
                        // else: require deck selection — button stays disabled below
                    } else {
                        onNewDeck()
                    }
                },
                enabled = !mergeMode || selectedDeck != null,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text(if (mergeMode) "Merge" else "Import")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel", color = MaterialTheme.colorScheme.primary)
            }
        },
        shape = MaterialTheme.shapes.large
    )
}

// ── ReviewTab ─────────────────────────────────────────────────────────────────

@Composable
fun ReviewTab(
    isAnkiInstalled: Boolean,
    hasPermission: Boolean,
    decks: List<AnkiDeck>,
    currentMode: McqSessionMode,
    onRequestPermission: () -> Unit,
    onRefresh: () -> Unit,
    onImportApkgClicked: () -> Unit,
    /** Opens the native file-picker for a CSV; shows the MergeCsvDialog for import mode choice. */
    onImportCsvClicked: () -> Unit,
    onImportEpubClicked: () -> Unit = {},
    /** Called when user confirmed "Merge into existing deck"; provides (targetDeckId, targetDeckName). */
    onImportCsvMergeClicked: (Long, String) -> Unit = { _, _ -> },
    onSelectDeck: (AnkiDeck) -> Unit,
    onDeleteDeck: (AnkiDeck) -> Unit = {},
    onRenameDeck: (AnkiDeck, String) -> Unit = { _, _ -> },
    onClearDeckProgress: (AnkiDeck) -> Unit = {},
    onCreateDeck: (String) -> Unit = {},
    onAddCardToDeck: (AnkiDeck, String, String, String, String?, String?, String?, String?) -> Unit = { _, _, _, _, _, _, _, _ -> },
    onExportDeck: (AnkiDeck) -> Unit = {},
    onMenuClicked: () -> Unit
) {
    val currentLanguage by com.example.flashcardapp.data.TranslationManager.currentLanguage.collectAsState()
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    var isFabVisible by remember { mutableStateOf(true) }
    var lastScrollOffset by remember { mutableStateOf(0) }
    var lastScrollIndex by remember { mutableStateOf(0) }

    LaunchedEffect(listState.firstVisibleItemIndex, listState.firstVisibleItemScrollOffset) {
        val currentIndex = listState.firstVisibleItemIndex
        val currentOffset = listState.firstVisibleItemScrollOffset
        if (currentIndex > lastScrollIndex || (currentIndex == lastScrollIndex && currentOffset > lastScrollOffset)) {
            isFabVisible = false
        } else if (currentIndex < lastScrollIndex || (currentIndex == lastScrollIndex && currentOffset < lastScrollOffset)) {
            isFabVisible = true
        }
        lastScrollIndex = currentIndex
        lastScrollOffset = currentOffset
    }

    val fabOffsetY by animateDpAsState(
        targetValue = if (isFabVisible) 0.dp else 100.dp,
        animationSpec = tween(durationMillis = 300),
        label = "fabOffset"
    )
    var showFabMenu by remember { mutableStateOf(false) }

    val tree = remember(decks) { buildDeckTree(decks) }
    val filteredTree = remember(tree, searchQuery) { filterDeckTree(tree, searchQuery) }
    var expandedNodes by remember { mutableStateOf(setOf<String>()) }

    // Dialog state
    var renameNode by remember { mutableStateOf<DeckNode?>(null) }
    var deleteNode by remember { mutableStateOf<DeckNode?>(null) }
    var clearNode by remember { mutableStateOf<DeckNode?>(null) }
    var addCardNode by remember { mutableStateOf<DeckNode?>(null) }
    var settingsNode by remember { mutableStateOf<DeckNode?>(null) }
    var showCreateDialog by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val settingsRepo = remember { SettingsRepository.getInstance(context) }
    
    // Store preferred modes for UI reactivity
    var deckModes by remember { mutableStateOf(decks.associate { it.id to settingsRepo.getPreferredModeForDeck(it.id) }) }
    LaunchedEffect(decks) {
        deckModes = decks.associate { it.id to settingsRepo.getPreferredModeForDeck(it.id) }
    }

    val visibleNodes by remember(filteredTree, searchQuery, expandedNodes) {
        derivedStateOf {
            val result = mutableListOf<Pair<DeckNode, Int>>()
            fun traverse(nodes: List<DeckNode>, depth: Int) {
                for (node in nodes) {
                    result.add(node to depth)
                    val expanded = if (searchQuery.isNotBlank()) true else node.fullPath in expandedNodes
                    if (expanded && node.children.isNotEmpty()) traverse(node.children, depth + 1)
                }
            }
            traverse(filteredTree, 0)
            result
        }
    }

    // Dialogs
    renameNode?.let { node ->
        RenameDialog(currentName = node.shortName,
            onConfirm = { newName -> node.deck?.let { onRenameDeck(it, newName) }; renameNode = null },
            onDismiss = { renameNode = null })
    }
    deleteNode?.let { node ->
        ConfirmDialog(title = "Delete Deck", body = "Delete '${node.shortName}' and all its cards? This cannot be undone.",
            confirmLabel = "Delete", danger = true,
            onConfirm = { node.deck?.let { onDeleteDeck(it) }; deleteNode = null },
            onDismiss = { deleteNode = null })
    }
    clearNode?.let { node ->
        ConfirmDialog(title = "Clear Progress", body = "Reset study progress for '${node.shortName}'? Cards are kept.",
            confirmLabel = "Clear",
            onConfirm = { node.deck?.let { onClearDeckProgress(it) }; clearNode = null },
            onDismiss = { clearNode = null })
    }
    if (showCreateDialog) {
        CreateDeckDialog(
            onConfirm = { name -> onCreateDeck(name); showCreateDialog = false },
            onDismiss = { showCreateDialog = false })
    }

    addCardNode?.let { node ->
        McqEditorDialog(
            title = "Add Card to ${node.shortName}",
            onDismiss = { addCardNode = null },
            onSave = { front, back, tagsJson, frontImage, backImage, explanationImage, optionImagesJson ->
                node.deck?.let { onAddCardToDeck(it, front, back, tagsJson, frontImage, backImage, explanationImage, optionImagesJson) }
                addCardNode = null
            }
        )
    }

    settingsNode?.let { node ->
        node.deck?.let { d ->
            DeckSettingsDialog(
                deck = d,
                currentMode = deckModes[d.id],
                onModeChanged = { mode ->
                    settingsRepo.setPreferredModeForDeck(d.id, mode)
                    deckModes = deckModes.toMutableMap().apply { put(d.id, mode) }
                },
                onDismiss = { settingsNode = null }
            )
        }
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Column(
            modifier = Modifier.fillMaxSize().widthIn(max = 840.dp).padding(horizontal = 20.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onMenuClicked) { Icon(Icons.Default.Menu, null, tint = MaterialTheme.colorScheme.onBackground) }
                    Spacer(Modifier.width(8.dp))
                    Column {
                        Text(com.example.flashcardapp.data.TranslationManager.getString("manage_decks"), style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
                        Text("${decks.size} deck${if (decks.size == 1) "" else "s"}", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
                Row {
                    IconButton(onClick = onImportApkgClicked) { Icon(Icons.Default.Add, "Import APKG", tint = MaterialTheme.colorScheme.primary) }
                    IconButton(onClick = onImportCsvClicked) { Icon(Icons.Default.Share, "Import CSV", tint = MaterialTheme.colorScheme.primary) }
                    if (isAnkiInstalled && hasPermission) {
                        IconButton(onClick = onRefresh) { Icon(Icons.Default.Refresh, "Refresh", tint = MaterialTheme.colorScheme.primary) }
                    }
                }
            }

            // Search bar
            OutlinedTextField(
                value = searchQuery, onValueChange = { searchQuery = it },
                placeholder = { Text(com.example.flashcardapp.data.TranslationManager.getString("search_decks"), color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)) },
                modifier = Modifier.fillMaxWidth(), shape = MaterialTheme.shapes.medium, singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface
                ),
                leadingIcon = { Icon(Icons.Default.Search, null, tint = MaterialTheme.colorScheme.onSurfaceVariant) }
            )

            if (visibleNodes.isEmpty()) {
                // Empty state
                Box(modifier = Modifier.fillMaxWidth().weight(1f), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.padding(24.dp)) {
                        Box(modifier = Modifier.size(64.dp).clip(CircleShape).background(MaterialTheme.colorScheme.primaryContainer), contentAlignment = Alignment.Center) {
                            Icon(Icons.Default.Info, null, tint = MaterialTheme.colorScheme.onPrimaryContainer, modifier = Modifier.size(32.dp))
                        }
                        Text(com.example.flashcardapp.data.TranslationManager.getString("no_decks_available"), style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
                        Text(com.example.flashcardapp.data.TranslationManager.getString("import_apkg_or_connect"), style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant, textAlign = TextAlign.Center)
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Button(
                                onClick = onImportApkgClicked, 
                                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                                shape = MaterialTheme.shapes.large
                            ) {
                                Icon(Icons.Default.Add, null, tint = MaterialTheme.colorScheme.onPrimary)
                                Spacer(Modifier.width(6.dp))
                                Text("Import APKG", color = MaterialTheme.colorScheme.onPrimary)
                            }
                            Button(
                                onClick = onImportCsvClicked, 
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                                ), 
                                shape = MaterialTheme.shapes.large
                            ) {
                                Icon(Icons.Default.Share, null, tint = MaterialTheme.colorScheme.onSecondaryContainer)
                                Spacer(Modifier.width(6.dp))
                                Text("Import CSV", color = MaterialTheme.colorScheme.onSecondaryContainer)
                            }
                        }
                        if (isAnkiInstalled) {
                            Button(
                                onClick = if (hasPermission) onRefresh else onRequestPermission, 
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                                ), 
                                shape = MaterialTheme.shapes.large
                            ) {
                                Icon(Icons.Default.Refresh, null, tint = MaterialTheme.colorScheme.onSecondaryContainer)
                                Spacer(Modifier.width(6.dp))
                                Text(if (hasPermission) "Sync AnkiDroid" else "Request Permission")
                            }
                        }
                    }
                }
            } else {
                LazyColumn(
                    state = listState,
                    modifier = Modifier.weight(1f),
                    contentPadding = PaddingValues(bottom = 80.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(visibleNodes, key = { it.first.fullPath }) { (node, depth) ->
                        val isExpanded = if (searchQuery.isNotBlank()) true else node.fullPath in expandedNodes
                        val hasChildren = node.children.isNotEmpty()
                        var menuExpanded by remember { mutableStateOf(false) }
                        val playableDeck = node.deck ?: AnkiDeck(id = -1L, name = node.fullPath)

                        // Angle animation for keyboard arrow rotation
                        val rotationAngle by animateFloatAsState(
                            targetValue = if (isExpanded) 90f else 0f,
                            label = "arrowRotation"
                        )

                        val currentDeckMode = playableDeck.let { deckModes[it.id] }
                        val cardContainerColor = when {
                            currentDeckMode == McqSessionMode.PRACTICE -> MaterialTheme.colorScheme.primaryContainer.copy(alpha = if (depth > 0) 0.5f else 0.8f)
                            currentDeckMode == McqSessionMode.REVISION -> MaterialTheme.colorScheme.secondaryContainer.copy(alpha = if (depth > 0) 0.5f else 0.8f)
                            currentDeckMode == McqSessionMode.TEST -> MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = if (depth > 0) 0.5f else 0.8f)
                            depth > 0 -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                            else -> MaterialTheme.colorScheme.surface
                        }

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = (depth * 16).dp),
                            shape = MaterialTheme.shapes.medium,
                            colors = CardDefaults.cardColors(
                                containerColor = cardContainerColor
                            ),
                            border = BorderStroke(
                                1.dp, 
                                if (depth > 0) MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f) 
                                else MaterialTheme.colorScheme.outlineVariant
                            )
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(IntrinsicSize.Min),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Nested hierarchy indicator line
                                if (depth > 0) {
                                    Box(
                                        modifier = Modifier
                                            .width(4.dp)
                                            .fillMaxHeight()
                                            .background(
                                                if (hasChildren) MaterialTheme.colorScheme.secondary
                                                else MaterialTheme.colorScheme.tertiary
                                            )
                                    )
                                }

                                Row(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(vertical = 12.dp, horizontal = 16.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    // Left: toggle + icon + name
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .weight(1f)
                                            .clickable {
                                                if (hasChildren && searchQuery.isBlank()) {
                                                    expandedNodes = if (isExpanded) expandedNodes - node.fullPath else expandedNodes + node.fullPath
                                                }
                                            }
                                    ) {
                                        if (hasChildren) {
                                            Icon(
                                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                                contentDescription = "Toggle", 
                                                tint = MaterialTheme.colorScheme.primary, 
                                                modifier = Modifier
                                                    .size(24.dp)
                                                    .rotate(rotationAngle)
                                            )
                                            Spacer(Modifier.width(4.dp))
                                        } else {
                                            Spacer(Modifier.width(28.dp))
                                        }
                                        Box(
                                            modifier = Modifier
                                                .size(36.dp)
                                                .clip(MaterialTheme.shapes.small)
                                                .background(
                                                    if (hasChildren) MaterialTheme.colorScheme.primaryContainer 
                                                    else MaterialTheme.colorScheme.secondaryContainer
                                                ),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Icon(
                                                imageVector = if (hasChildren) Icons.Default.Menu else Icons.AutoMirrored.Filled.List,
                                                contentDescription = null,
                                                tint = if (hasChildren) MaterialTheme.colorScheme.onPrimaryContainer 
                                                       else MaterialTheme.colorScheme.onSecondaryContainer,
                                                modifier = Modifier.size(18.dp)
                                            )
                                        }
                                        Spacer(Modifier.width(12.dp))
                                        Column {
                                            Text(node.shortName, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                                            Text(
                                                if (node.deck != null) "Leaf Deck • ID: ${node.deck.id}"
                                                else "${node.children.size} sub-decks",
                                                style = MaterialTheme.typography.labelSmall, 
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                    }

                                    // Right: play + more options
                                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                        IconButton(
                                            onClick = { onSelectDeck(playableDeck) },
                                            modifier = Modifier.size(32.dp)
                                        ) {
                                            Icon(Icons.Default.PlayArrow, "Study", tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(18.dp))
                                        }
                                        IconButton(
                                            onClick = { settingsNode = node },
                                            modifier = Modifier.size(32.dp)
                                        ) {
                                            Icon(Icons.Default.Settings, "Settings", tint = MaterialTheme.colorScheme.secondary, modifier = Modifier.size(16.dp))
                                        }
                                        Box {
                                            IconButton(
                                                onClick = { menuExpanded = true },
                                                modifier = Modifier.size(32.dp)
                                            ) {
                                                Icon(Icons.Default.MoreVert, "Options", tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(16.dp))
                                            }
                                            DeckOptionsMenu(
                                                node = node, expanded = menuExpanded,
                                                onDismiss = { menuExpanded = false },
                                                onStudy = { onSelectDeck(playableDeck) },
                                                onAddCard = { addCardNode = node },
                                                onEditCards = { onSelectDeck(playableDeck) },
                                                onRename = { renameNode = node },
                                                onClearProgress = { clearNode = node },
                                                onDelete = { deleteNode = node },
                                                onExport = { onExportDeck(playableDeck) }
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // Animate FAB vertical translation on scroll
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 24.dp, bottom = 24.dp)
                .offset(y = fabOffsetY)
        ) {
            FloatingActionButton(
                onClick = { showFabMenu = true },
                containerColor = MaterialTheme.colorScheme.primary, 
                contentColor = MaterialTheme.colorScheme.onPrimary, 
                shape = MaterialTheme.shapes.large
            ) {
                Icon(Icons.Default.Add, "Actions")
            }
            DropdownMenu(
                expanded = showFabMenu,
                onDismissRequest = { showFabMenu = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Import CSV") },
                    leadingIcon = { Icon(Icons.Default.Share, null, tint = MaterialTheme.colorScheme.primary) },
                    onClick = { showFabMenu = false; onImportCsvClicked() }
                )
                DropdownMenuItem(
                    text = { Text("Import APKG") },
                    leadingIcon = { Icon(Icons.Default.Add, null, tint = MaterialTheme.colorScheme.primary) },
                    onClick = { showFabMenu = false; onImportApkgClicked() }
                )
                DropdownMenuItem(
                    text = { Text("Import EPUB") },
                    leadingIcon = { Icon(Icons.Default.Book, null, tint = MaterialTheme.colorScheme.primary) },
                    onClick = { showFabMenu = false; onImportEpubClicked() }
                )
                DropdownMenuItem(
                    text = { Text("Create New Deck") },
                    leadingIcon = { Icon(Icons.Default.CreateNewFolder, null, tint = MaterialTheme.colorScheme.primary) },
                    onClick = { showFabMenu = false; showCreateDialog = true }
                )
            }
        }
    }
}

// ── AnalyticsTab ──────────────────────────────────────────────────────────────

@Composable
fun CalendarDialog(
    sessionRecords: List<SessionRecordEntity>,
    onDismissRequest: () -> Unit
) {
    var displayMonth by remember { mutableStateOf(Calendar.getInstance()) }
    
    val activeDays = remember(sessionRecords, displayMonth) {
        val days = mutableSetOf<Int>()
        val cal = Calendar.getInstance()
        sessionRecords.forEach { record ->
            cal.timeInMillis = record.timestamp
            if (cal.get(Calendar.YEAR) == displayMonth.get(Calendar.YEAR) &&
                cal.get(Calendar.MONTH) == displayMonth.get(Calendar.MONTH)) {
                days.add(cal.get(Calendar.DAY_OF_MONTH))
            }
        }
        days
    }
    
    AlertDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = {
            TextButton(onClick = onDismissRequest) {
                Text("Close", color = PrimaryPurple)
            }
        },
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    val next = displayMonth.clone() as Calendar
                    next.add(Calendar.MONTH, -1)
                    displayMonth = next
                }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Previous Month")
                }
                
                val monthName = remember(displayMonth) {
                    val sdf = java.text.SimpleDateFormat("MMMM yyyy", java.util.Locale.getDefault())
                    sdf.format(displayMonth.time)
                }
                Text(monthName, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                
                IconButton(onClick = {
                    val next = displayMonth.clone() as Calendar
                    next.add(Calendar.MONTH, 1)
                    displayMonth = next
                }) {
                    Icon(Icons.Default.ArrowForward, contentDescription = "Next Month")
                }
            }
        },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    listOf("S", "M", "T", "W", "T", "F", "S").forEach { day ->
                        Text(
                            text = day,
                            modifier = Modifier.weight(1f),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.Bold,
                            color = TextSecondaryGray
                        )
                    }
                }
                
                val daysInMonth = displayMonth.getActualMaximum(Calendar.DAY_OF_MONTH)
                val firstDayOfWeek = remember(displayMonth) {
                    val first = displayMonth.clone() as Calendar
                    first.set(Calendar.DAY_OF_MONTH, 1)
                    first.get(Calendar.DAY_OF_WEEK)
                }
                
                val days = mutableListOf<Int?>()
                for (i in 1 until firstDayOfWeek) {
                    days.add(null)
                }
                for (i in 1..daysInMonth) {
                    days.add(i)
                }
                while (days.size % 7 != 0) {
                    days.add(null)
                }
                
                val rows = days.chunked(7)
                rows.forEach { week ->
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        week.forEach { dayNum ->
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .aspectRatio(1f),
                                contentAlignment = Alignment.Center
                            ) {
                                if (dayNum != null) {
                                    val hasSession = activeDays.contains(dayNum)
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Text(
                                            text = dayNum.toString(),
                                            style = MaterialTheme.typography.bodyMedium,
                                            fontWeight = if (hasSession) FontWeight.Bold else FontWeight.Normal,
                                            color = if (hasSession) PrimaryPurple else MaterialTheme.colorScheme.onSurface
                                        )
                                        if (hasSession) {
                                            Box(
                                                modifier = Modifier
                                                    .size(4.dp)
                                                    .clip(CircleShape)
                                                    .background(PrimaryPurple)
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
        shape = RoundedCornerShape(20.dp),
        containerColor = Color.White
    )
}

@Composable
fun QuizzesRunDialog(
    sessionRecords: List<SessionRecordEntity>,
    onDismissRequest: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = {
            TextButton(onClick = onDismissRequest) {
                Text("Close", color = PrimaryPurple)
            }
        },
        title = {
            Text("Quiz History", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        },
        text = {
            if (sessionRecords.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxWidth().height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No quiz records found.", color = TextSecondaryGray)
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth().heightIn(max = 400.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(sessionRecords.sortedByDescending { it.timestamp }) { record ->
                        val dateString = remember(record.timestamp) {
                            val sdf = java.text.SimpleDateFormat("MMM dd, yyyy HH:mm", java.util.Locale.getDefault())
                            sdf.format(java.util.Date(record.timestamp))
                        }
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(
                                    text = record.deckName,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "Mode: ${record.mode}",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = TextSecondaryGray
                                    )
                                    Text(
                                        text = "Score: ${record.score}/${record.totalQuestions}",
                                        style = MaterialTheme.typography.bodySmall,
                                        fontWeight = FontWeight.Bold,
                                        color = PrimaryPurple
                                    )
                                }
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = dateString,
                                    style = MaterialTheme.typography.labelSmall,
                                    color = TextSecondaryGray
                                )
                            }
                        }
                    }
                }
            }
        },
        shape = RoundedCornerShape(20.dp),
        containerColor = Color.White
    )
}

@Composable
fun LegacyAnalyticsTab(cardCount: Int, sessionRecords: List<SessionRecordEntity>, onMenuClicked: () -> Unit) {
    val colorScheme = MaterialTheme.colorScheme
    val scrollState = rememberScrollState()
    val totalQuestions = sessionRecords.sumOf { it.totalQuestions }
    val totalCorrect = sessionRecords.sumOf { it.score }
    val retentionRate = if (totalQuestions > 0) (totalCorrect.toFloat() / totalQuestions * 100) else 0f
    val cardsMasteredPct = if (cardCount > 0) minOf(100, (totalCorrect * 100 / cardCount.coerceAtLeast(1))) else 0

    // Weekly bar chart data
    val weekCounts = remember(sessionRecords) {
        val arr = LongArray(7)
        val cal = Calendar.getInstance()
        sessionRecords.forEach { r ->
            cal.timeInMillis = r.timestamp
            val idx = when (cal.get(Calendar.DAY_OF_WEEK)) {
                Calendar.MONDAY -> 0; Calendar.TUESDAY -> 1; Calendar.WEDNESDAY -> 2
                Calendar.THURSDAY -> 3; Calendar.FRIDAY -> 4; Calendar.SATURDAY -> 5; else -> 6
            }
            arr[idx] += r.totalQuestions.toLong()
        }
        arr
    }
    val maxBar = weekCounts.maxOrNull()?.coerceAtLeast(1L) ?: 1L

    // Knowledge gaps: lowest-performing decks
    val knowledgeGaps = remember(sessionRecords) {
        sessionRecords.groupBy { it.deckName }
            .map { (name, recs) ->
                val q = recs.sumOf { it.totalQuestions }
                val c = recs.sumOf { it.score }
                val acc = if (q > 0) (c * 100 / q) else 50
                name to acc
            }
            .sortedBy { it.second }
            .take(5)
    }

    var showCalendarDialog by remember { mutableStateOf(false) }
    var showQuizzesDialog by remember { mutableStateOf(false) }
    if (showCalendarDialog) CalendarDialog(sessionRecords = sessionRecords, onDismissRequest = { showCalendarDialog = false })
    if (showQuizzesDialog) QuizzesRunDialog(sessionRecords = sessionRecords, onDismissRequest = { showQuizzesDialog = false })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 20.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // ── Header ──────────────────────────────────────────────────────────
        Text(
            text = "Learning Analytics",
            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
            color = colorScheme.onBackground
        )
        Text(
            text = "A comprehensive breakdown of your cognitive retention and knowledge stability. Data-driven insights to optimize your study sessions.",
            style = MaterialTheme.typography.bodyMedium,
            color = colorScheme.onSurfaceVariant,
            lineHeight = 20.sp
        )

        // ── Cards Mastered ───────────────────────────────────────────────────
        Card(
            modifier = Modifier.fillMaxWidth().clickable { showQuizzesDialog = true },
            shape = MaterialTheme.shapes.large,
            colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceVariant.copy(alpha = 0.6f)),
            border = BorderStroke(1.dp, colorScheme.outlineVariant)
        ) {
            Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "CARDS MASTERED",
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                    color = colorScheme.onSurfaceVariant,
                    letterSpacing = 1.5.sp
                )
                Row(verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "$cardsMasteredPct%",
                        style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
                        color = colorScheme.onSurface
                    )
                    Text(
                        text = "of deck",
                        style = MaterialTheme.typography.bodyMedium,
                        color = colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(bottom = 6.dp)
                    )
                }
                val animatedPct by animateFloatAsState(
                    targetValue = cardsMasteredPct / 100f,
                    animationSpec = tween(1200),
                    label = "masteredAnim"
                )
                LinearProgressIndicator(
                    progress = animatedPct,
                    modifier = Modifier.fillMaxWidth().height(8.dp).clip(RoundedCornerShape(50)),
                    color = colorScheme.primary,
                    trackColor = colorScheme.surfaceVariant
                )
            }
        }

        // ── Retention Rate ────────────────────────────────────────────────────
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.large,
            colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceVariant.copy(alpha = 0.6f)),
            border = BorderStroke(1.dp, colorScheme.outlineVariant)
        ) {
            Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = "RETENTION RATE",
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                    color = colorScheme.onSurfaceVariant,
                    letterSpacing = 1.5.sp
                )
                Text(
                    text = "${retentionRate.toInt()}.${"${(retentionRate * 10).toInt() % 10}"}%",
                    style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
                    color = colorScheme.onSurface
                )
                Text(
                    text = "+2.4% from last week",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF4CAF50)
                )
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Color(0xFF4CAF50), modifier = Modifier.size(14.dp))
                    Text(
                        text = "Exceptional Consistency",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(0xFF4CAF50)
                    )
                }
            }
        }

        // ── Learning Stability Bar Chart ──────────────────────────────────────
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.large,
            colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceVariant.copy(alpha = 0.5f)),
            border = BorderStroke(1.dp, colorScheme.outlineVariant)
        ) {
            Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("Learning Stability", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold), color = colorScheme.onSurface)
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = Color(0xFF1A3A2A)
                    ) {
                        Text(
                            text = "FSRS Optimized",
                            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                            color = Color(0xFF4CAF50),
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }
                Text(
                    text = "Estimated knowledge duration across active sub-decks",
                    style = MaterialTheme.typography.bodySmall,
                    color = colorScheme.onSurfaceVariant
                )
                // Bar chart
                val days = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
                Row(
                    modifier = Modifier.fillMaxWidth().height(120.dp).padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    days.forEachIndexed { idx, day ->
                        val q = weekCounts[idx]
                        val frac = if (q > 0) maxOf(0.08f, q.toFloat() / maxBar) else 0.05f
                        val animatedFrac by animateFloatAsState(
                            targetValue = frac,
                            animationSpec = tween(1000, delayMillis = idx * 80),
                            label = "bar$idx"
                        )
                        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Box(
                                modifier = Modifier
                                    .width(28.dp)
                                    .fillMaxHeight(animatedFrac)
                                    .clip(RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp))
                                    .background(
                                        Brush.verticalGradient(
                                            colors = listOf(colorScheme.primary, colorScheme.primary.copy(alpha = 0.4f))
                                        )
                                    )
                            )
                            Text(day, style = MaterialTheme.typography.labelSmall, color = colorScheme.onSurfaceVariant)
                        }
                    }
                }
            }
        }

        // ── Knowledge Gaps ─────────────────────────────────────────────────────
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.large,
            colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceVariant.copy(alpha = 0.5f)),
            border = BorderStroke(1.dp, colorScheme.outlineVariant)
        ) {
            Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                Text("Knowledge Gaps", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold), color = colorScheme.onSurface)
                Text("Topics requiring reinforcement based on review failures.", style = MaterialTheme.typography.bodySmall, color = colorScheme.onSurfaceVariant)

                // Generate Smart Review CTA
                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth().height(48.dp),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1565C0),
                        contentColor = Color.White
                    )
                ) {
                    Icon(Icons.Default.AutoAwesome, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(8.dp))
                    Text("Generate Smart Review", style = MaterialTheme.typography.labelLarge)
                }

                // Gap pills
                if (knowledgeGaps.isEmpty()) {
                    Text("Complete more sessions to see gaps.", style = MaterialTheme.typography.bodySmall, color = colorScheme.onSurfaceVariant)
                } else {
                    knowledgeGaps.forEach { (name, acc) ->
                        val pillColor = when {
                            acc < 40 -> Color(0xFF8B2020)
                            acc < 60 -> Color(0xFF8B6520)
                            acc < 75 -> Color(0xFF4A7A4A)
                            else -> Color(0xFF1565C0)
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = name.substringAfterLast("::").take(24),
                                style = MaterialTheme.typography.bodyMedium,
                                color = colorScheme.onSurface,
                                modifier = Modifier.weight(1f)
                            )
                            Surface(
                                shape = RoundedCornerShape(50),
                                color = pillColor.copy(alpha = 0.2f)
                            ) {
                                Text(
                                    text = "$acc%",
                                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                                    color = pillColor.copy(alpha = 1f),
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        // ── Optimal Review Time ────────────────────────────────────────────────
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.large,
            colors = CardDefaults.cardColors(
                containerColor = colorScheme.secondaryContainer.copy(alpha = 0.4f)
            ),
            border = BorderStroke(1.dp, colorScheme.outlineVariant)
        ) {
            Row(
                modifier = Modifier.padding(20.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.Top
            ) {
                Box(
                    modifier = Modifier.size(48.dp).clip(CircleShape).background(colorScheme.secondaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.WbSunny, contentDescription = null, tint = colorScheme.onSecondaryContainer, modifier = Modifier.size(28.dp))
                }
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text("Optimal Review Time", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold), color = colorScheme.onSurface)
                    Text(
                        text = "Your focus peaks between 06:00 and 10:00 AM. Completing your pending cards during this window can increase retention by up to 12%.",
                        style = MaterialTheme.typography.bodySmall,
                        color = colorScheme.onSurfaceVariant,
                        lineHeight = 18.sp
                    )
                }
            }
        }

        // ── Knowledge Sync ─────────────────────────────────────────────────────
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.large,
            colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceVariant.copy(alpha = 0.6f)),
            border = BorderStroke(1.dp, colorScheme.outlineVariant)
        ) {
            Row(
                modifier = Modifier.padding(20.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.size(48.dp).clip(RoundedCornerShape(12.dp)).background(colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.Sync, contentDescription = null, tint = colorScheme.onPrimaryContainer, modifier = Modifier.size(28.dp))
                }
                Column(verticalArrangement = Arrangement.spacedBy(2.dp), modifier = Modifier.weight(1f)) {
                    Text("Knowledge Sync", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold), color = colorScheme.onSurface)
                    Text(
                        text = "Last sync: ${if (sessionRecords.isEmpty()) "Never" else "a few minutes ago"}",
                        style = MaterialTheme.typography.bodySmall,
                        color = colorScheme.onSurfaceVariant
                    )
                }
                Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null, tint = colorScheme.onSurfaceVariant)
            }
        }

        Spacer(Modifier.height(16.dp))
    }
}

@Composable
private fun StatCard(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    Card(
        modifier = if (onClick != null) modifier.clickable(onClick = onClick) else modifier, 
        shape = MaterialTheme.shapes.medium, 
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)), 
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(label, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
            Spacer(Modifier.height(4.dp))
            Text(value, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        }
    }
}

