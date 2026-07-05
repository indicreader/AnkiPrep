package com.example.flashcardapp.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.LibraryBooks
import androidx.compose.material.icons.outlined.Quiz
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.data.AnkiDataRepository
import com.example.flashcardapp.data.entities.DeckEntity
import com.example.flashcardapp.session.McqSessionMode
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReviseTab(
    repo: AnkiDataRepository,
    onStartSession: (deckIds: List<Long>, isStarredOnly: Boolean, sessionMode: McqSessionMode) -> Unit,
    isDarkMode: Boolean,
    onDarkModeToggle: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    val coroutineScope = rememberCoroutineScope()

    // Load decks and user metadata
    val decks by repo.observeDecks().collectAsState(initial = emptyList())
    val userMetadata by repo.observeAllUserMetadata().collectAsState(initial = emptyList())

    // Selection Modes: "single" (One Deck), "multi" (Selected Decks), "starred" (Starred Questions)
    var selectionMode by remember { mutableStateOf("single") }

    // Single Deck Selection State
    var selectedDeck by remember { mutableStateOf<DeckEntity?>(null) }
    var singleDeckDropdownExpanded by remember { mutableStateOf(false) }

    // Multi-Deck Selection State
    val selectedDeckIds = remember { mutableStateListOf<Long>() }

    // Study Session Mode: PRACTICE, TEST, REVISION, RATED_PRIORITY
    var studyMode by remember { mutableStateOf(McqSessionMode.PRACTICE) }

    // Sync selectedDeck to first deck if null
    LaunchedEffect(decks) {
        if (selectedDeck == null && decks.isNotEmpty()) {
            selectedDeck = decks.firstOrNull()
        }
    }

    // Compute dynamic card count
    val dynamicCardCount = remember(selectionMode, selectedDeck, selectedDeckIds, decks, userMetadata) {
        when (selectionMode) {
            "single" -> selectedDeck?.cardCount ?: 0
            "multi" -> {
                decks.filter { selectedDeckIds.contains(it.id) }.sumOf { it.cardCount }
            }
            "starred" -> userMetadata.count { it.isStarred }
            else -> 0
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Revise & Review",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                        color = colorScheme.onBackground
                    )
                },
                actions = {
                    IconButton(onClick = onDarkModeToggle) {
                        Icon(
                            imageVector = if (isDarkMode) Icons.Default.Star else Icons.Outlined.StarBorder,
                            contentDescription = "Toggle Theme",
                            tint = colorScheme.onSurfaceVariant
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = colorScheme.background)
            )
        },
        containerColor = colorScheme.background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // ── Section 1: Study Filter Mode ──
            Text(
                text = "1. SELECT REVISION SCOPE",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                ),
                color = colorScheme.primary
            )

            // Scope Options (3 Cards)
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                // Option A: Single Deck
                Card(
                    onClick = { selectionMode = "single" },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (selectionMode == "single") colorScheme.primaryContainer else colorScheme.surface
                    ),
                    border = BorderStroke(
                        width = if (selectionMode == "single") 2.dp else 1.dp,
                        color = if (selectionMode == "single") colorScheme.primary else colorScheme.outlineVariant
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        RadioButton(
                            selected = selectionMode == "single",
                            onClick = { selectionMode = "single" }
                        )
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Single Deck",
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodyLarge,
                                color = if (selectionMode == "single") colorScheme.onPrimaryContainer else colorScheme.onSurface
                            )
                            Text(
                                text = "Revise cards from one chosen deck",
                                style = MaterialTheme.typography.bodySmall,
                                color = if (selectionMode == "single") colorScheme.onPrimaryContainer.copy(alpha = 0.8f) else colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }

                // Option B: Selected Decks
                Card(
                    onClick = { selectionMode = "multi" },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (selectionMode == "multi") colorScheme.primaryContainer else colorScheme.surface
                    ),
                    border = BorderStroke(
                        width = if (selectionMode == "multi") 2.dp else 1.dp,
                        color = if (selectionMode == "multi") colorScheme.primary else colorScheme.outlineVariant
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        RadioButton(
                            selected = selectionMode == "multi",
                            onClick = { selectionMode = "multi" }
                        )
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Selected Decks",
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodyLarge,
                                color = if (selectionMode == "multi") colorScheme.onPrimaryContainer else colorScheme.onSurface
                            )
                            Text(
                                text = "Pick multiple decks to merge into a single session",
                                style = MaterialTheme.typography.bodySmall,
                                color = if (selectionMode == "multi") colorScheme.onPrimaryContainer.copy(alpha = 0.8f) else colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }

                // Option C: Starred Questions
                Card(
                    onClick = { selectionMode = "starred" },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (selectionMode == "starred") colorScheme.primaryContainer else colorScheme.surface
                    ),
                    border = BorderStroke(
                        width = if (selectionMode == "starred") 2.dp else 1.dp,
                        color = if (selectionMode == "starred") colorScheme.primary else colorScheme.outlineVariant
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        RadioButton(
                            selected = selectionMode == "starred",
                            onClick = { selectionMode = "starred" }
                        )
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Starred Questions",
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodyLarge,
                                color = if (selectionMode == "starred") colorScheme.onPrimaryContainer else colorScheme.onSurface
                            )
                            Text(
                                text = "Review bookmarked items across all decks",
                                style = MaterialTheme.typography.bodySmall,
                                color = if (selectionMode == "starred") colorScheme.onPrimaryContainer.copy(alpha = 0.8f) else colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            Spacer(Modifier.height(4.dp))

            // ── Section 2: Configuration Options ──
            if (selectionMode == "single") {
                Text(
                    text = "SELECT DECK",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorScheme.primary
                )
                Box(modifier = Modifier.fillMaxWidth()) {
                    OutlinedButton(
                        onClick = { singleDeckDropdownExpanded = true },
                        modifier = Modifier.fillMaxWidth().height(56.dp),
                        shape = RoundedCornerShape(12.dp),
                        border = BorderStroke(1.dp, colorScheme.outline)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = selectedDeck?.name ?: "No Deck Selected",
                                style = MaterialTheme.typography.bodyMedium,
                                color = colorScheme.onSurface
                            )
                            Icon(Icons.Default.ArrowDropDown, contentDescription = "Dropdown")
                        }
                    }
                    DropdownMenu(
                        expanded = singleDeckDropdownExpanded,
                        onDismissRequest = { singleDeckDropdownExpanded = false },
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ) {
                        decks.forEach { deck ->
                            DropdownMenuItem(
                                text = { Text("${deck.name} (${deck.cardCount} cards)") },
                                onClick = {
                                    selectedDeck = deck
                                    singleDeckDropdownExpanded = false
                                }
                            )
                        }
                    }
                }
            } else if (selectionMode == "multi") {
                Text(
                    text = "SELECT DECK CHECKLIST",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorScheme.primary
                )
                Card(
                    modifier = Modifier.fillMaxWidth().heightIn(max = 240.dp),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, colorScheme.outlineVariant),
                    colors = CardDefaults.cardColors(containerColor = colorScheme.surface)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .verticalScroll(rememberScrollState())
                    ) {
                        if (decks.isEmpty()) {
                            Text(
                                "No decks available.",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(16.dp)
                            )
                        } else {
                            decks.forEach { deck ->
                                val isChecked = selectedDeckIds.contains(deck.id)
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable {
                                            if (isChecked) {
                                                selectedDeckIds.remove(deck.id)
                                            } else {
                                                selectedDeckIds.add(deck.id)
                                            }
                                        }
                                        .padding(horizontal = 12.dp, vertical = 10.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    Checkbox(
                                        checked = isChecked,
                                        onCheckedChange = { checked ->
                                            if (checked == true) {
                                                if (!selectedDeckIds.contains(deck.id)) selectedDeckIds.add(deck.id)
                                            } else {
                                                selectedDeckIds.remove(deck.id)
                                            }
                                        }
                                    )
                                    Column {
                                        Text(deck.name, fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.bodyMedium)
                                        Text("${deck.cardCount} cards", style = MaterialTheme.typography.bodySmall, color = colorScheme.onSurfaceVariant)
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Spacer(Modifier.height(4.dp))

            // ── Section 3: Study Mode Selector ──
            Text(
                text = "2. CHOOSE STUDY MODE",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                ),
                color = colorScheme.primary
            )

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                listOf(
                    McqSessionMode.PRACTICE to Triple("Practice Mode", "Instant answer reviews with star ratings enabled", Icons.Outlined.Quiz),
                    McqSessionMode.RATED_PRIORITY to Triple("Priority Rated Mode", "Study only rated items (higher priority ratings first)", Icons.Filled.Star),
                    McqSessionMode.TEST to Triple("Mock Test Mode", "Timed exam simulation, reviews provided at session end", Icons.Outlined.LibraryBooks),
                    McqSessionMode.REVISION to Triple("Smart Revision (FSRS)", "Follow Spaced Repetition scheduling algorithm", Icons.Outlined.LibraryBooks)
                ).forEach { (mode, info) ->
                    val (title, desc, icon) = info
                    val isSelected = studyMode == mode
                    Card(
                        onClick = { studyMode = mode },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (isSelected) colorScheme.secondaryContainer else colorScheme.surfaceVariant.copy(alpha = 0.3f)
                        ),
                        border = BorderStroke(
                            width = if (isSelected) 1.5.dp else 0.5.dp,
                            color = if (isSelected) colorScheme.secondary else colorScheme.outlineVariant.copy(alpha = 0.5f)
                        )
                    ) {
                        Row(
                            modifier = Modifier.padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Icon(icon, contentDescription = title, tint = if (isSelected) colorScheme.secondary else colorScheme.onSurfaceVariant, modifier = Modifier.size(20.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(title, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyMedium, color = colorScheme.onSurface)
                                Text(desc, style = MaterialTheme.typography.labelSmall, color = colorScheme.onSurfaceVariant)
                            }
                            if (isSelected) {
                                Icon(Icons.Default.Check, contentDescription = "Active", tint = colorScheme.secondary, modifier = Modifier.size(16.dp))
                            }
                        }
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            // ── Section 4: Action Button ──
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = colorScheme.primaryContainer),
                border = BorderStroke(0.5.dp, colorScheme.primary.copy(alpha = 0.3f))
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text("Selected Target Size", style = MaterialTheme.typography.labelSmall, color = colorScheme.onPrimaryContainer.copy(alpha = 0.8f))
                        Text("$dynamicCardCount Cards", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = colorScheme.onPrimaryContainer)
                    }
                    Button(
                        onClick = {
                            val finalDeckIds = when (selectionMode) {
                                "single" -> listOfNotNull(selectedDeck?.id)
                                "multi" -> selectedDeckIds.toList()
                                else -> emptyList() // "starred" is global
                            }
                            onStartSession(finalDeckIds, selectionMode == "starred", studyMode)
                        },
                        enabled = dynamicCardCount > 0,
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorScheme.primary,
                            contentColor = Color.White
                        )
                    ) {
                        Text("Start Session", fontWeight = FontWeight.Bold)
                    }
                }
            }

            Spacer(Modifier.height(24.dp))
        }
    }
}
