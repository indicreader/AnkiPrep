package com.example.flashcardapp.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.Spring
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import kotlin.math.roundToInt
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.draw.scale
import androidx.compose.ui.zIndex
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.layout.onGloballyPositioned
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
import androidx.compose.ui.text.style.TextOverflow
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
import com.example.flashcardapp.ui.theme.neumorphicShadow
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// â”€â”€ Data models & tree helpers â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

data class DeckNode(
    val deck: AnkiDeck?,
    val shortName: String,
    val fullPath: String,
    val children: MutableList<DeckNode> = mutableListOf()
)

fun buildDeckTree(decks: List<AnkiDeck>): List<DeckNode> {
    val rootNodes = mutableListOf<DeckNode>()
    val nodeMap = mutableMapOf<String, DeckNode>()
    for (deck in decks) {
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

/**
 * Finds the sibling list containing [targetPath] and the index of that node.
 */
fun findSiblingsAndIndex(rootNodes: List<DeckNode>, targetPath: String): Pair<MutableList<DeckNode>, Int>? {
    val rootIdx = rootNodes.indexOfFirst { it.fullPath == targetPath }
    if (rootIdx != -1) {
        return (rootNodes as? MutableList<DeckNode> ?: rootNodes.toMutableList()) to rootIdx
    }
    fun search(nodes: List<DeckNode>): Pair<MutableList<DeckNode>, Int>? {
        for (node in nodes) {
            val childIdx = node.children.indexOfFirst { it.fullPath == targetPath }
            if (childIdx != -1) {
                return node.children to childIdx
            }
            val res = search(node.children)
            if (res != null) return res
        }
        return null
    }
    return search(rootNodes)
}

/**
 * Traverses the deck tree in order and collects all unique deck IDs.
 */
fun collectAllDeckIds(nodes: List<DeckNode>, allDecks: List<AnkiDeck> = emptyList()): List<Long> {
    val deckMap = allDecks.associateBy { it.name }
    val list = mutableListOf<Long>()
    fun walk(nList: List<DeckNode>) {
        for (n in nList) {
            val id = n.deck?.id?.takeIf { it > 0 } ?: deckMap[n.fullPath]?.id?.takeIf { it > 0 }
            if (id != null && !list.contains(id)) {
                list.add(id)
            }
            walk(n.children)
        }
    }
    walk(nodes)
    return list
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

fun getRecursiveCardCount(node: DeckNode): Int {
    var count = node.deck?.cardCount ?: 0
    for (child in node.children) {
        count += getRecursiveCardCount(child)
    }
    return count
}

fun getAllDeckIds(node: DeckNode): Set<Long> {
    val ids = mutableSetOf<Long>()
    node.deck?.let { ids.add(it.id) }
    for (child in node.children) {
        ids.addAll(getAllDeckIds(child))
    }
    return ids
}

fun getPracticedCount(node: DeckNode, attemptsToday: List<com.example.flashcardapp.data.entities.CardAttemptEntity>): Int {
    val deckIds = getAllDeckIds(node)
    return attemptsToday
        .filter { it.deckId in deckIds }
        .map { it.cardId }
        .distinct()
        .size
}

// â”€â”€ Deck options dropdown â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

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
    onExport: () -> Unit,
    onMoveUp: (() -> Unit)? = null,
    onMoveDown: (() -> Unit)? = null,
    onClubIntoAnother: (() -> Unit)? = null,
    onMockExam: (() -> Unit)? = null
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
        if (onMockExam != null) {
            DropdownMenuItem(
                text = { Text("Start Mock Exam", fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.primary) },
                leadingIcon = { Icon(Icons.Default.Timer, null, tint = MaterialTheme.colorScheme.primary) },
                onClick = { onDismiss(); onMockExam() }
            )
        }
        if (onMoveUp != null) {
            DropdownMenuItem(
                text = { Text("Move Up") },
                leadingIcon = { Icon(Icons.Default.ArrowUpward, null, tint = MaterialTheme.colorScheme.primary) },
                onClick = { onDismiss(); onMoveUp() }
            )
        }
        if (onMoveDown != null) {
            DropdownMenuItem(
                text = { Text("Move Down") },
                leadingIcon = { Icon(Icons.Default.ArrowDownward, null, tint = MaterialTheme.colorScheme.primary) },
                onClick = { onDismiss(); onMoveDown() }
            )
        }
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
            text = { Text("Club into Another Deck...") },
            leadingIcon = { Icon(Icons.Default.CallMerge, null, tint = MaterialTheme.colorScheme.secondary) },
            onClick = { onDismiss(); onClubIntoAnother?.invoke() }
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

// â”€â”€ Dialogs â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

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
fun SelectTargetDeckDialog(
    title: String,
    actionButtonText: String,
    description: String,
    decks: List<AnkiDeck>,
    excludeDeckPaths: Set<String>,
    allowCreateNew: Boolean = true,
    newDeckLabel: String = "Create New Deck",
    onConfirm: (targetDeckId: Long?, newDeckName: String?) -> Unit,
    onDismiss: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    var newDeckText by remember { mutableStateOf("") }
    var selectedDeckId by remember { mutableStateOf<Long?>(null) }
    var isCreatingNew by remember { mutableStateOf(false) }

    val availableDecks = remember(decks, excludeDeckPaths, searchQuery) {
        decks.filter { d ->
            !excludeDeckPaths.any { excluded ->
                d.name == excluded || d.name.startsWith("$excluded::")
            } && (searchQuery.isBlank() || d.name.contains(searchQuery, ignoreCase = true))
        }
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Icon(
                    imageVector = Icons.Default.FolderShared,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 440.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                if (allowCreateNew) {
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = if (isCreatingNew) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f)
                               else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
                        border = BorderStroke(
                            1.dp,
                            if (isCreatingNew) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                isCreatingNew = true
                                selectedDeckId = null
                            }
                    ) {
                        Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                RadioButton(
                                    selected = isCreatingNew,
                                    onClick = {
                                        isCreatingNew = true
                                        selectedDeckId = null
                                    },
                                    colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colorScheme.primary)
                                )
                                Text(
                                    text = newDeckLabel,
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            if (isCreatingNew) {
                                OutlinedTextField(
                                    value = newDeckText,
                                    onValueChange = { newDeckText = it },
                                    placeholder = { Text("e.g. Master Subject") },
                                    singleLine = true,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 36.dp),
                                    shape = RoundedCornerShape(8.dp)
                                )
                            }
                        }
                    }
                }

                Text(
                    text = "Or choose an existing deck:",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { Text("Search decks...") },
                    leadingIcon = { Icon(Icons.Default.Search, null, modifier = Modifier.size(16.dp)) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp)
                )

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, fill = false),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    if (availableDecks.isEmpty()) {
                        item {
                            Text(
                                text = "No matching decks found.",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(vertical = 8.dp)
                            )
                        }
                    } else {
                        items(availableDecks, key = { it.id }) { deck ->
                            val isSelected = (!isCreatingNew && selectedDeckId == deck.id)
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(
                                        if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
                                        else Color.Transparent
                                    )
                                    .clickable {
                                        selectedDeckId = deck.id
                                        isCreatingNew = false
                                    }
                                    .padding(horizontal = 8.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                RadioButton(
                                    selected = isSelected,
                                    onClick = {
                                        selectedDeckId = deck.id
                                        isCreatingNew = false
                                    },
                                    colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colorScheme.primary)
                                )
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = deck.name,
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                        color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = "${deck.cardCount} questions",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {
            val canConfirm = (isCreatingNew && newDeckText.isNotBlank()) || (!isCreatingNew && selectedDeckId != null)
            Button(
                onClick = {
                    if (isCreatingNew) {
                        onConfirm(null, newDeckText.trim())
                    } else {
                        onConfirm(selectedDeckId, null)
                    }
                },
                enabled = canConfirm,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(actionButtonText)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel", color = MaterialTheme.colorScheme.primary)
            }
        },
        shape = RoundedCornerShape(20.dp)
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

// â”€â”€ Merge-CSV Dialog â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

/**
 * Dialog shown after the user picks a CSV file â€” lets them choose
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

                // â”€â”€ Option A: New Deck â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
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

                // â”€â”€ Option B: Merge â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
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
                                // Deck picker â€” scrollable list
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
                        // else: require deck selection â€” button stays disabled below
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

// â”€â”€ ReviewTab â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ReviewTab(
    isAnkiInstalled: Boolean,
    hasPermission: Boolean,
    decks: List<AnkiDeck>,
    attemptsToday: List<com.example.flashcardapp.data.entities.CardAttemptEntity> = emptyList(),
    currentMode: McqSessionMode,
    isDarkMode: Boolean = false,
    onDarkModeToggle: (Boolean) -> Unit = {},
    onRequestPermission: () -> Unit,
    onRefresh: () -> Unit,
    onImportApkgClicked: () -> Unit,
    /** Opens the native file-picker for a CSV; shows the MergeCsvDialog for import mode choice. */
    onImportCsvClicked: () -> Unit,
    onImportEpubClicked: () -> Unit = {},
    onImportPdfClicked: () -> Unit = {},
    /** Called when user confirmed "Merge into existing deck"; provides (targetDeckId, targetDeckName). */
    onImportCsvMergeClicked: (Long, String) -> Unit = { _, _ -> },
    onSelectDeck: (AnkiDeck) -> Unit,
    onDeleteDeck: (String) -> Unit = {},
    onRenameDeck: (AnkiDeck, String) -> Unit = { _, _ -> },
    onClearDeckProgress: (AnkiDeck) -> Unit = {},
    onCreateDeck: (String) -> Unit = {},
    onAddCardToDeck: (AnkiDeck, String, String, String, String?, String?, String?, String?) -> Unit = { _, _, _, _, _, _, _, _ -> },
    onExportDeck: (AnkiDeck) -> Unit = {},
    onMenuClicked: () -> Unit,
    onDeckOrderChanged: (List<Long>) -> Unit = {},
    onStartCombinedTest: (List<String>, List<String>) -> Unit = { _, _ -> },
    onStartMockExam: (AnkiDeck, com.example.flashcardapp.mock.ExamPreset) -> Unit = { _, _ -> },
    onStartCombinedMockExam: (List<String>, List<String>) -> Unit = { _, _ -> }
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

    var localTreeVersion by remember { mutableIntStateOf(0) }
    val tree = remember(decks, localTreeVersion) { buildDeckTree(decks) }
    val filteredTree = remember(tree, searchQuery) { filterDeckTree(tree, searchQuery) }
    var expandedNodes by remember { mutableStateOf(setOf<String>()) }

    // Dialog state
    var renameNode by remember { mutableStateOf<DeckNode?>(null) }
    var deleteNode by remember { mutableStateOf<DeckNode?>(null) }
    var clearNode by remember { mutableStateOf<DeckNode?>(null) }
    var addCardNode by remember { mutableStateOf<DeckNode?>(null) }
    var settingsNode by remember { mutableStateOf<DeckNode?>(null) }
    var showCreateDialog by remember { mutableStateOf(false) }
    var showBatchDeleteDialog by remember { mutableStateOf(false) }
    var showBatchNestDialog by remember { mutableStateOf(false) }
    var showBatchClubDialog by remember { mutableStateOf(false) }
    var singleClubNode by remember { mutableStateOf<DeckNode?>(null) }
    var mockExamNode by remember { mutableStateOf<DeckNode?>(null) }
    var showSnippingDialog by remember { mutableStateOf(false) }
    var showPomodoroBar by remember { mutableStateOf(false) }
    var showBatchMockExamDialog by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    val context = LocalContext.current
    val settingsRepo = remember { SettingsRepository.getInstance(context) }
    val repo = remember { com.example.flashcardapp.data.AnkiDataRepository.getInstance(context) }
    
    val allCards by repo.observeAllCards().collectAsState(initial = emptyList())
    val availableTags = remember(allCards) {
        allCards.flatMap { repo.parseTags(it.tags) }.distinct().sorted()
    }

    var selectedNodePaths by remember { mutableStateOf(setOf<String>()) }
    var selectedFilterTags by remember { mutableStateOf(setOf<String>()) }
    var isTagFilterBarExpanded by remember { mutableStateOf(false) }

    // Store preferred modes for UI reactivity
    var deckModes by remember { mutableStateOf(decks.associate { it.id to settingsRepo.getPreferredModeForDeck(it.id) }) }
    LaunchedEffect(decks) {
        deckModes = decks.associate { it.id to settingsRepo.getPreferredModeForDeck(it.id) }
    }

    var draggingNodePath by remember { mutableStateOf<String?>(null) }
    var draggingOffset by remember { mutableFloatStateOf(0f) }
    var draggingItemHeightPx by remember { mutableFloatStateOf(80f) }
    var activeSiblingPaths by remember { mutableStateOf<List<String>>(emptyList()) }
    var activeOriginSiblingIdx by remember { mutableIntStateOf(0) }
    var activeTargetSiblingIdx by remember { mutableIntStateOf(0) }

    fun moveDeckInTree(targetNode: DeckNode, delta: Int) {
        val result = findSiblingsAndIndex(tree, targetNode.fullPath) ?: return
        val (siblings, idx) = result
        val newIdx = (idx + delta).coerceIn(siblings.indices)
        if (newIdx != idx) {
            val moved = siblings.removeAt(idx)
            siblings.add(newIdx, moved)
            localTreeVersion++

            val newOrder = collectAllDeckIds(tree, decks).toMutableList()
            decks.forEach { d ->
                if (!newOrder.contains(d.id)) {
                    newOrder.add(d.id)
                }
            }
            settingsRepo.setDeckOrderList(newOrder)
            onDeckOrderChanged(newOrder)
        }
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
            onConfirm = { newName ->
                val targetDeck = node.deck ?: AnkiDeck(id = -1L, name = node.fullPath)
                onRenameDeck(targetDeck, newName)
                renameNode = null
            },
            onDismiss = { renameNode = null })
    }
    deleteNode?.let { node ->
        ConfirmDialog(title = "Delete Deck", body = "Delete '${node.shortName}' and all its cards? This cannot be undone.",
            confirmLabel = "Delete", danger = true,
            onConfirm = { onDeleteDeck(node.fullPath); deleteNode = null },
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
        val dialogPlayableDeck = node.deck ?: AnkiDeck(id = -1L, name = node.fullPath)
        McqEditorDialog(
            title = "Add Card to ${node.shortName}",
            onDismiss = { addCardNode = null },
            onSave = { front, back, tagsJson, frontImage, backImage, explanationImage, optionImagesJson ->
                onAddCardToDeck(dialogPlayableDeck, front, back, tagsJson, frontImage, backImage, explanationImage, optionImagesJson)
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

    if (showBatchDeleteDialog) {
        val totalCardsToDelete = selectedNodePaths.sumOf { path ->
            val matchingNode = visibleNodes.firstOrNull { it.first.fullPath == path }?.first
            matchingNode?.let { getRecursiveCardCount(it) } ?: 0
        }
        ConfirmDialog(
            title = "Delete ${selectedNodePaths.size} Decks?",
            body = "This will permanently delete ${selectedNodePaths.size} deck(s) and all their cards ($totalCardsToDelete questions). This cannot be undone.",
            confirmLabel = "Delete All",
            danger = true,
            onConfirm = {
                val paths = selectedNodePaths.toList()
                coroutineScope.launch {
                    repo.deleteDecks(paths)
                    withContext(Dispatchers.Main) {
                        Toast.makeText(context, "Deleted ${paths.size} decks", Toast.LENGTH_SHORT).show()
                    }
                }
                selectedNodePaths = emptySet()
                showBatchDeleteDialog = false
            },
            onDismiss = { showBatchDeleteDialog = false }
        )
    }

    if (showBatchNestDialog) {
        SelectTargetDeckDialog(
            title = "Nest under Master Deck",
            actionButtonText = "Nest Decks",
            description = "Selected ${selectedNodePaths.size} deck(s) will become subdecks under the master deck.",
            decks = decks,
            excludeDeckPaths = selectedNodePaths,
            allowCreateNew = true,
            newDeckLabel = "Create New Master Deck",
            onConfirm = { targetDeckId, newDeckName ->
                val masterName = newDeckName ?: decks.firstOrNull { it.id == targetDeckId }?.name
                if (masterName != null) {
                    val paths = selectedNodePaths.toList()
                    coroutineScope.launch {
                        repo.nestDecksUnderMaster(paths, masterName)
                        withContext(Dispatchers.Main) {
                            Toast.makeText(context, "Nested ${paths.size} decks under '$masterName'", Toast.LENGTH_SHORT).show()
                        }
                    }
                    selectedNodePaths = emptySet()
                }
                showBatchNestDialog = false
            },
            onDismiss = { showBatchNestDialog = false }
        )
    }

    if (showBatchClubDialog) {
        SelectTargetDeckDialog(
            title = "Club Questions into Deck",
            actionButtonText = "Club Questions",
            description = "Move all questions from ${selectedNodePaths.size} selected deck(s) into target deck (duplicates will be skipped). Source deck(s) will be deleted.",
            decks = decks,
            excludeDeckPaths = selectedNodePaths,
            allowCreateNew = true,
            newDeckLabel = "Create New Target Deck",
            onConfirm = { targetDeckId, newDeckName ->
                val paths = selectedNodePaths.toList()
                coroutineScope.launch {
                    val finalTargetId = if (newDeckName != null) {
                        repo.createDeck(newDeckName)
                        repo.getAllDecks().firstOrNull { it.fullPath == newDeckName }?.id
                    } else {
                        targetDeckId
                    }
                    if (finalTargetId != null) {
                        repo.clubQuestionsIntoDeck(paths, finalTargetId, skipDuplicates = true)
                        withContext(Dispatchers.Main) {
                            Toast.makeText(context, "Questions clubbed into target deck", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                selectedNodePaths = emptySet()
                showBatchClubDialog = false
            },
            onDismiss = { showBatchClubDialog = false }
        )
    }

    singleClubNode?.let { node ->
        SelectTargetDeckDialog(
            title = "Club '${node.shortName}' Questions",
            actionButtonText = "Club Questions",
            description = "Move all questions from '${node.shortName}' into target deck (duplicates will be skipped). '${node.shortName}' will be deleted.",
            decks = decks,
            excludeDeckPaths = setOf(node.fullPath),
            allowCreateNew = true,
            newDeckLabel = "Create New Target Deck",
            onConfirm = { targetDeckId, newDeckName ->
                val sourcePath = node.fullPath
                coroutineScope.launch {
                    val finalTargetId = if (newDeckName != null) {
                        repo.createDeck(newDeckName)
                        repo.getAllDecks().firstOrNull { it.fullPath == newDeckName }?.id
                    } else {
                        targetDeckId
                    }
                    if (finalTargetId != null) {
                        repo.clubQuestionsIntoDeck(listOf(sourcePath), finalTargetId, skipDuplicates = true)
                        withContext(Dispatchers.Main) {
                            Toast.makeText(context, "Clubbed '${node.shortName}' questions into target deck", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                singleClubNode = null
            },
            onDismiss = { singleClubNode = null }
        )
    }

    mockExamNode?.let { node ->
        MockExamConfigDialog(
            deckName = node.shortName,
            cardCount = getRecursiveCardCount(node),
            onDismiss = { mockExamNode = null },
            onStartExam = { preset ->
                val d = node.deck ?: AnkiDeck(id = node.fullPath.hashCode().toLong(), name = node.shortName, cardCount = getRecursiveCardCount(node))
                onStartMockExam(d, preset)
                mockExamNode = null
            }
        )
    }

    if (showBatchMockExamDialog) {
        val paths = selectedNodePaths.toList()
        val combinedName = if (paths.size == 1) paths.first().substringAfterLast("::") else "${paths.size} Combined Decks"
        MockExamConfigDialog(
            deckName = combinedName,
            cardCount = allCards.count { it.deckHierarchy in paths },
            onDismiss = { showBatchMockExamDialog = false },
            onStartExam = { preset ->
                val d = AnkiDeck(id = 999999L, name = combinedName, cardCount = 100)
                onStartMockExam(d, preset)
                showBatchMockExamDialog = false
            }
        )
    }

    if (showSnippingDialog) {
        val defaultDeck = decks.firstOrNull()
        QuestionSnippingDialog(
            initialDeckId = defaultDeck?.id ?: 1L,
            initialDeckName = defaultDeck?.name ?: "Captured Snippets",
            onDismiss = { showSnippingDialog = false },
            onCardCreated = { onRefresh() }
        )
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Column(
            modifier = Modifier.fillMaxSize().widthIn(max = 840.dp).padding(horizontal = 20.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column {
                        Text(com.example.flashcardapp.data.TranslationManager.getString("manage_decks"), style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
                        Text("${decks.size} deck${if (decks.size == 1) "" else "s"}", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = { onDarkModeToggle(!isDarkMode) }) {
                        Icon(
                            imageVector = if (isDarkMode) Icons.Outlined.LightMode else Icons.Outlined.DarkMode,
                            contentDescription = if (isDarkMode) "Light Mode" else "Dark Mode",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    IconButton(onClick = onImportApkgClicked) { Icon(Icons.Default.Add, "Import APKG", tint = MaterialTheme.colorScheme.primary) }
                    IconButton(onClick = onImportCsvClicked) { Icon(Icons.Default.Share, "Import CSV", tint = MaterialTheme.colorScheme.primary) }
                    IconButton(onClick = { showPomodoroBar = !showPomodoroBar }) {
                        Icon(
                            imageVector = Icons.Default.HourglassTop,
                            contentDescription = "Pomodoro Timer",
                            tint = if (showPomodoroBar) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
                        )
                    }
                    if (isAnkiInstalled && hasPermission) {
                        IconButton(onClick = onRefresh) { Icon(Icons.Default.Refresh, "Refresh", tint = MaterialTheme.colorScheme.primary) }
                    }
                }
            }

            if (showPomodoroBar) {
                com.example.flashcardapp.ui.components.PomodoroBar()
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

            // Collapsible Tag Filter Bar
            if (availableTags.isNotEmpty()) {
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 8.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { isTagFilterBarExpanded = !isTagFilterBarExpanded },
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Tag,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(18.dp)
                                )
                                Text(
                                    text = if (selectedFilterTags.isEmpty()) "Filter by Tags (${availableTags.size} tags)" else "Filter by Tags (${selectedFilterTags.size} selected)",
                                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                if (selectedFilterTags.isNotEmpty()) {
                                    TextButton(onClick = { selectedFilterTags = emptySet() }) {
                                        Text("Clear", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
                                    }
                                }
                                Icon(
                                    imageVector = if (isTagFilterBarExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        if (isTagFilterBarExpanded) {
                            Spacer(Modifier.height(8.dp))
                            Column(
                                verticalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                availableTags.chunked(3).forEach { tagRow ->
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        tagRow.forEach { tag ->
                                            val isSelected = selectedFilterTags.contains(tag)
                                            FilterChip(
                                                selected = isSelected,
                                                onClick = {
                                                    selectedFilterTags = if (isSelected) selectedFilterTags - tag else selectedFilterTags + tag
                                                },
                                                label = {
                                                    Text(
                                                        text = "#$tag",
                                                        style = MaterialTheme.typography.labelSmall,
                                                        maxLines = 1
                                                    )
                                                },
                                                colors = FilterChipDefaults.filterChipColors(
                                                    selectedContainerColor = MaterialTheme.colorScheme.primary,
                                                    selectedLabelColor = MaterialTheme.colorScheme.onPrimary
                                                ),
                                                modifier = Modifier.weight(1f)
                                            )
                                        }
                                        repeat(3 - tagRow.size) {
                                            Spacer(Modifier.weight(1f))
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

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
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    userScrollEnabled = (draggingNodePath == null)
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

                        val isBeingDragged = draggingNodePath == node.fullPath
                        val isSibling = draggingNodePath != null && activeSiblingPaths.contains(node.fullPath)
                        val sibIdx = if (isSibling) activeSiblingPaths.indexOf(node.fullPath) else -1

                        val siblingTargetShift = when {
                            isBeingDragged -> 0f
                            sibIdx != -1 && activeTargetSiblingIdx > activeOriginSiblingIdx -> {
                                if (sibIdx in (activeOriginSiblingIdx + 1)..activeTargetSiblingIdx) {
                                    -draggingItemHeightPx
                                } else 0f
                            }
                            sibIdx != -1 && activeTargetSiblingIdx < activeOriginSiblingIdx -> {
                                if (sibIdx in activeTargetSiblingIdx until activeOriginSiblingIdx) {
                                    draggingItemHeightPx
                                } else 0f
                            }
                            else -> 0f
                        }

                        val animatedSiblingShift by animateFloatAsState(
                            targetValue = siblingTargetShift,
                            animationSpec = spring(stiffness = Spring.StiffnessMediumLow),
                            label = "siblingShift"
                        )

                        val translationY = if (isBeingDragged) draggingOffset else animatedSiblingShift
                        val scale by animateFloatAsState(if (isBeingDragged) 1.025f else 1.0f, label = "scale")
                        val elevation by animateDpAsState(if (isBeingDragged) 12.dp else if (depth > 0) 1.dp else 2.dp, label = "elevation")

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = (depth * 16).dp)
                                .zIndex(if (isBeingDragged) 10f else 0f)
                                .scale(scale)
                                .neumorphicShadow(
                                    isDarkMode = isDarkMode,
                                    cornerRadius = 16.dp,
                                    elevation = elevation
                                )
                                .shadow(
                                    elevation,
                                    shape = MaterialTheme.shapes.medium,
                                    ambientColor = MaterialTheme.colorScheme.primary.copy(alpha = if (isBeingDragged) 0.25f else 0.08f),
                                    spotColor = MaterialTheme.colorScheme.primary.copy(alpha = if (isBeingDragged) 0.35f else 0.15f)
                                )
                                .graphicsLayer { this.translationY = translationY }
                                .animateItemPlacement()
                                .onGloballyPositioned { coords ->
                                    if (coords.size.height > 40) {
                                        draggingItemHeightPx = coords.size.height.toFloat()
                                    }
                                },
                            shape = MaterialTheme.shapes.medium,
                            colors = CardDefaults.cardColors(
                                containerColor = if (isBeingDragged) {
                                    MaterialTheme.colorScheme.primaryContainer.copy(alpha = if (isDarkMode) 0.85f else 0.95f)
                                } else cardContainerColor
                            ),
                            border = BorderStroke(
                                if (isBeingDragged) 2.dp else 1.dp,
                                if (isBeingDragged) {
                                    SolidColor(MaterialTheme.colorScheme.primary)
                                } else {
                                    Brush.linearGradient(
                                        listOf(
                                            (if (isDarkMode) Color(0xFF2E2A3B) else Color.White).copy(alpha = if (depth > 0) 0.35f else 0.75f),
                                            MaterialTheme.colorScheme.outlineVariant.copy(alpha = if (depth > 0) 0.2f else 0.35f)
                                        )
                                    )
                                }
                            )
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 8.dp, vertical = 10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                if (depth > 0) {
                                    Box(
                                        modifier = Modifier
                                            .width(4.dp)
                                            .height(36.dp)
                                            .background(
                                                if (hasChildren) MaterialTheme.colorScheme.secondary
                                                else MaterialTheme.colorScheme.tertiary
                                            )
                                    )
                                    Spacer(Modifier.width(4.dp))
                                }

                                Box(
                                    modifier = Modifier
                                        .pointerInput(node.fullPath) {
                                            detectDragGestures(
                                                onDragStart = {
                                                    val sibResult = findSiblingsAndIndex(tree, node.fullPath)
                                                    if (sibResult != null) {
                                                        val (sibs, idx) = sibResult
                                                        activeSiblingPaths = sibs.map { it.fullPath }
                                                        activeOriginSiblingIdx = idx
                                                        activeTargetSiblingIdx = idx
                                                        draggingNodePath = node.fullPath
                                                        draggingOffset = 0f
                                                    }
                                                },
                                                onDragEnd = {
                                                    val delta = activeTargetSiblingIdx - activeOriginSiblingIdx
                                                    if (delta != 0) {
                                                        moveDeckInTree(node, delta)
                                                    }
                                                    draggingNodePath = null
                                                    draggingOffset = 0f
                                                    activeSiblingPaths = emptyList()
                                                },
                                                onDragCancel = {
                                                    draggingNodePath = null
                                                    draggingOffset = 0f
                                                    activeSiblingPaths = emptyList()
                                                },
                                                onDrag = { change, dragAmount ->
                                                    change.consume()
                                                    draggingOffset += dragAmount.y
                                                    val itemHeight = draggingItemHeightPx.coerceAtLeast(60f)
                                                    val slotDiff = kotlin.math.round(draggingOffset / itemHeight).toInt()
                                                    activeTargetSiblingIdx = (activeOriginSiblingIdx + slotDiff).coerceIn(0, activeSiblingPaths.lastIndex)
                                                }
                                            )
                                        }
                                        .padding(horizontal = 2.dp, vertical = 4.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.DragHandle,
                                        contentDescription = "Drag to Rearrange",
                                        tint = if (isBeingDragged) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                                        modifier = Modifier.size(20.dp)
                                    )
                                }

                                val isNodeSelected = selectedNodePaths.contains(node.fullPath)
                                Checkbox(
                                    checked = isNodeSelected,
                                    onCheckedChange = { checked ->
                                        val currentSelected = selectedNodePaths.toMutableSet()
                                        fun toggleRecursive(n: DeckNode, add: Boolean) {
                                            if (add) currentSelected.add(n.fullPath) else currentSelected.remove(n.fullPath)
                                            n.children.forEach { child -> toggleRecursive(child, add) }
                                        }
                                        toggleRecursive(node, checked)
                                        selectedNodePaths = currentSelected
                                    },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = MaterialTheme.colorScheme.primary,
                                        uncheckedColor = MaterialTheme.colorScheme.outline
                                    ),
                                    modifier = Modifier.padding(horizontal = 2.dp)
                                )

                                if (hasChildren) {
                                    IconButton(
                                        onClick = {
                                            if (searchQuery.isBlank()) {
                                                expandedNodes = if (isExpanded) expandedNodes - node.fullPath else expandedNodes + node.fullPath
                                            }
                                        },
                                        modifier = Modifier.size(28.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                            contentDescription = "Toggle", 
                                            tint = MaterialTheme.colorScheme.primary, 
                                            modifier = Modifier
                                                .size(20.dp)
                                                .rotate(rotationAngle)
                                        )
                                    }
                                }

                                val iconBgColor = when (currentDeckMode) {
                                    McqSessionMode.PRACTICE -> MaterialTheme.colorScheme.primaryContainer
                                    McqSessionMode.REVISION -> Color(0xFFFF9800)
                                    McqSessionMode.TEST -> Color(0xFF2196F3)
                                    else -> {
                                        if (hasChildren) MaterialTheme.colorScheme.primaryContainer 
                                        else MaterialTheme.colorScheme.secondaryContainer
                                    }
                                }
                                val iconTintColor = when (currentDeckMode) {
                                    McqSessionMode.PRACTICE -> MaterialTheme.colorScheme.onPrimaryContainer
                                    McqSessionMode.REVISION -> Color.White
                                    McqSessionMode.TEST -> Color.White
                                    else -> {
                                        if (hasChildren) MaterialTheme.colorScheme.onPrimaryContainer 
                                        else MaterialTheme.colorScheme.onSecondaryContainer
                                    }
                                }
                                Box(
                                    modifier = Modifier
                                        .size(36.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(iconBgColor),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = if (hasChildren) Icons.Default.Menu else Icons.AutoMirrored.Filled.List,
                                        contentDescription = null,
                                        tint = iconTintColor,
                                        modifier = Modifier.size(18.dp)
                                    )
                                }

                                Spacer(Modifier.width(10.dp))

                                val totalCards = getRecursiveCardCount(node)
                                val practiced = getPracticedCount(node, attemptsToday)

                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clickable {
                                            if (hasChildren && searchQuery.isBlank()) {
                                                expandedNodes = if (isExpanded) expandedNodes - node.fullPath else expandedNodes + node.fullPath
                                            }
                                        }
                                ) {
                                    Text(
                                        text = node.shortName,
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onSurface,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = if (node.deck != null) {
                                            if (practiced > 0) "$totalCards Qs • $practiced practiced today"
                                            else "$totalCards Questions"
                                        } else {
                                            "${node.children.size} sub-topics • $totalCards Qs"
                                        },
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }

                                Spacer(Modifier.width(6.dp))

                                val badgeText = if (practiced > 0) "$practiced/$totalCards Qs" else "$totalCards Qs"
                                Surface(
                                    shape = RoundedCornerShape(12.dp),
                                    color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f)
                                ) {
                                    Text(
                                        text = badgeText,
                                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                                        color = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                    )
                                }

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
                                val sibResult = findSiblingsAndIndex(tree, node.fullPath)
                                val canMoveUp = (sibResult?.second ?: 0) > 0
                                val canMoveDown = sibResult?.let { (sibs, idx) -> idx < sibs.lastIndex } ?: false

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
                                        onExport = { onExportDeck(playableDeck) },
                                        onMoveUp = if (canMoveUp) { { moveDeckInTree(node, -1) } } else null,
                                        onMoveDown = if (canMoveDown) { { moveDeckInTree(node, 1) } } else null,
                                        onClubIntoAnother = { singleClubNode = node },
                                        onMockExam = { mockExamNode = node }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        // ── Batch Action Floating Panel ─────────────────────────────────
        if (selectedNodePaths.isNotEmpty()) {
            Surface(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(start = 16.dp, end = 16.dp, bottom = 88.dp)
                    .fillMaxWidth()
                    .neumorphicShadow(isDarkMode = isDarkMode, cornerRadius = 18.dp, elevation = 6.dp),
                shape = RoundedCornerShape(18.dp),
                color = MaterialTheme.colorScheme.surface,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.35f)),
                tonalElevation = 6.dp
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Surface(
                                shape = CircleShape,
                                color = MaterialTheme.colorScheme.primaryContainer
                            ) {
                                Text(
                                    text = "${selectedNodePaths.size}",
                                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                                )
                            }
                            Text(
                                text = "deck${if (selectedNodePaths.size == 1) "" else "s"} selected",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            TextButton(
                                onClick = {
                                    selectedNodePaths = if (selectedNodePaths.size == visibleNodes.size) emptySet()
                                    else visibleNodes.map { it.first.fullPath }.toSet()
                                },
                                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = if (selectedNodePaths.size == visibleNodes.size) "Clear" else "Select All",
                                    style = MaterialTheme.typography.labelMedium,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                            IconButton(
                                onClick = { selectedNodePaths = emptySet() },
                                modifier = Modifier.size(28.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Deselect",
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        OutlinedButton(
                            onClick = { showBatchDeleteDialog = true },
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = MaterialTheme.colorScheme.error
                            ),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.error.copy(alpha = 0.6f)),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 6.dp, vertical = 4.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(Icons.Default.Delete, null, modifier = Modifier.size(15.dp))
                            Spacer(Modifier.width(3.dp))
                            Text("Delete", maxLines = 1, style = MaterialTheme.typography.labelSmall)
                        }

                        Button(
                            onClick = { showBatchNestDialog = true },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                            ),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 6.dp, vertical = 4.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(Icons.Default.FolderShared, null, modifier = Modifier.size(15.dp))
                            Spacer(Modifier.width(3.dp))
                            Text("Nest", maxLines = 1, style = MaterialTheme.typography.labelSmall)
                        }

                        Button(
                            onClick = { showBatchClubDialog = true },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                                contentColor = MaterialTheme.colorScheme.onTertiaryContainer
                            ),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 6.dp, vertical = 4.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(Icons.Default.CallMerge, null, modifier = Modifier.size(15.dp))
                            Spacer(Modifier.width(3.dp))
                            Text("Club Qs", maxLines = 1, style = MaterialTheme.typography.labelSmall)
                        }

                        Button(
                            onClick = {
                                showBatchMockExamDialog = true
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.tertiary,
                                contentColor = MaterialTheme.colorScheme.onTertiary
                            ),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 6.dp, vertical = 4.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(Icons.Default.Timer, null, modifier = Modifier.size(15.dp))
                            Spacer(Modifier.width(3.dp))
                            Text("Mock", maxLines = 1, style = MaterialTheme.typography.labelSmall)
                        }

                        Button(
                            onClick = {
                                onStartCombinedTest(selectedNodePaths.toList(), selectedFilterTags.toList())
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                contentColor = MaterialTheme.colorScheme.onPrimary
                            ),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(horizontal = 6.dp, vertical = 4.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(Icons.Default.PlayArrow, null, modifier = Modifier.size(15.dp))
                            Spacer(Modifier.width(3.dp))
                            Text("Test", maxLines = 1, style = MaterialTheme.typography.labelSmall)
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
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                if (selectedNodePaths.isEmpty() && selectedFilterTags.isNotEmpty()) {
                    ExtendedFloatingActionButton(
                        onClick = {
                            onStartCombinedTest(selectedNodePaths.toList(), selectedFilterTags.toList())
                        },
                        icon = { Icon(Icons.Default.PlayArrow, contentDescription = "Start Test") },
                        text = {
                            val tagCount = selectedFilterTags.size
                            Text("Start Tag Test ($tagCount Tags)", fontWeight = FontWeight.Bold)
                        },
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                        shape = RoundedCornerShape(50)
                    )
                }

                Box {
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
                            text = { Text("Snip Question from Photo") },
                            leadingIcon = { Icon(Icons.Default.Crop, null, tint = MaterialTheme.colorScheme.primary) },
                            onClick = { showFabMenu = false; showSnippingDialog = true }
                        )
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
                            text = { Text("Import PDF Booklet") },
                            leadingIcon = { Icon(Icons.Default.PictureAsPdf, null, tint = MaterialTheme.colorScheme.primary) },
                            onClick = { showFabMenu = false; onImportPdfClicked() }
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
    }
}

// â”€â”€ AnalyticsTab â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

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
        // â”€â”€ Header â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
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

        // â”€â”€ Cards Mastered â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
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

        // â”€â”€ Retention Rate â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
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

        // â”€â”€ Learning Stability Bar Chart â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
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

        // â”€â”€ Knowledge Gaps â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
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

        // â”€â”€ Optimal Review Time â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
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

        // â”€â”€ Knowledge Sync â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
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

