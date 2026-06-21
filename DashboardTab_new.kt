package com.example.flashcardapp.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.data.AnkiDeck
import com.example.flashcardapp.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardTab(
    decks: List<AnkiDeck>,
    cardCount: Int,
    onSelectDeck: (AnkiDeck) -> Unit,
    onProfileClicked: () -> Unit,
    onSettingsClicked: () -> Unit,
    onImportApkgClicked: () -> Unit,
    onImportCsvClicked: () -> Unit,
    onImportEpubClicked: () -> Unit,
    onCreateDeck: (String) -> Unit
) {
    var showImportMenu by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .border(2.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.2f), CircleShape)
                                .background(MaterialTheme.colorScheme.surfaceVariant)
                                .clickable { onProfileClicked() },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Outlined.Person, contentDescription = "Profile", tint = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "StudyMastery",
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary,
                                letterSpacing = (-0.5).sp
                            )
                        )
                    }
                },
                actions = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.primaryContainer, CircleShape)
                            .padding(horizontal = 12.dp, vertical = 4.dp)
                    ) {
                        Text(text = "🔥", fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "12",
                            color = Color(0xFFE67E22), // Streak fire color
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(onClick = { /* Notifications */ }) {
                        Icon(Icons.Outlined.Notifications, contentDescription = "Notifications", tint = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f)
                )
            )
        },
        floatingActionButton = {
            Box {
                FloatingActionButton(
                    onClick = { showImportMenu = !showImportMenu },
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    shape = CircleShape
                ) {
                    Icon(Icons.Outlined.Add, contentDescription = "Add")
                }
                
                DropdownMenu(
                    expanded = showImportMenu,
                    onDismissRequest = { showImportMenu = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Import CSV File") },
                        onClick = { showImportMenu = false; onImportCsvClicked() },
                        leadingIcon = { Icon(Icons.Outlined.Description, contentDescription = null) }
                    )
                    DropdownMenuItem(
                        text = { Text("Import APKG File") },
                        onClick = { showImportMenu = false; onImportApkgClicked() },
                        leadingIcon = { Icon(Icons.Outlined.Inventory2, contentDescription = null) }
                    )
                    DropdownMenuItem(
                        text = { Text("Import EPUB File") },
                        onClick = { showImportMenu = false; onImportEpubClicked() },
                        leadingIcon = { Icon(Icons.Outlined.Book, contentDescription = null) }
                    )
                    DropdownMenuItem(
                        text = { Text("Create Deck") },
                        onClick = { showImportMenu = false; onCreateDeck("New Deck") },
                        leadingIcon = { Icon(Icons.Outlined.Create, contentDescription = null) }
                    )
                }
            }
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Your Bookshelf",
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Stay focused. One card at a time.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            
            // Grid of decks (bookshelf)
            item {
                val columns = 2
                val rows = (decks.size + columns - 1) / columns
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    for (i in 0 until rows) {
                        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                            for (j in 0 until columns) {
                                val index = i * columns + j
                                if (index < decks.size) {
                                    val deck = decks[index]
                                    BookCard(deck = deck, modifier = Modifier.weight(1f), onSelectDeck = onSelectDeck)
                                } else {
                                    Spacer(modifier = Modifier.weight(1f))
                                }
                            }
                        }
                    }
                    if (decks.isEmpty()) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .border(1.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(12.dp))
                                .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(12.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(Icons.Outlined.LibraryBooks, contentDescription = null, modifier = Modifier.size(48.dp), tint = MaterialTheme.colorScheme.outline)
                                Spacer(modifier = Modifier.height(8.dp))
                                Text("No decks found.", color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        }
                    }
                }
            }

            // Insights Section
            item {
                Text(
                    text = "Insights Section",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    // Weekly Activity Chart
                    Card(
                        modifier = Modifier.weight(2f),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        border = borderStroke(),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                Text("Weekly Activity", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold))
                                Box(
                                    modifier = Modifier
                                        .background(MaterialTheme.colorScheme.primaryContainer, CircleShape)
                                        .padding(horizontal = 8.dp, vertical = 2.dp)
                                ) {
                                    Text("High: 94%", color = MaterialTheme.colorScheme.primary, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            
                            // Bar chart mockup
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.Bottom
                            ) {
                                val heights = listOf(0.4f, 0.65f, 0.8f, 0.55f, 0.95f, 0.7f, 1.0f)
                                heights.forEachIndexed { index, h ->
                                    val isToday = index == heights.lastIndex
                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .fillMaxHeight(h)
                                            .padding(horizontal = 4.dp)
                                            .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                                            .background(if (isToday) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primaryContainer)
                                    )
                                }
                            }
                            
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                val days = listOf("M", "T", "W", "T", "F", "S", "S")
                                days.forEach {
                                    Text(text = it, fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }

                    // Daily Goal
                    Card(
                        modifier = Modifier.weight(1f),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(
                                    "Daily Goal",
                                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    "42 / 50 Cards",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                                )
                            }
                            
                            Column(modifier = Modifier.padding(top = 16.dp)) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(8.dp)
                                        .clip(CircleShape)
                                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.2f))
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .fillMaxWidth(0.84f)
                                            .background(MaterialTheme.colorScheme.primary)
                                    )
                                }
                                Spacer(modifier = Modifier.height(12.dp))
                                Button(
                                    onClick = { },
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                                    shape = RoundedCornerShape(8.dp),
                                    contentPadding = PaddingValues(vertical = 4.dp)
                                ) {
                                    Text("Claim XP", fontSize = 10.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                }
            }
            
            item { Spacer(modifier = Modifier.height(80.dp)) } // Bottom nav padding
        }
    }
}

@Composable
fun borderStroke() = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)

@Composable
fun BookCard(deck: AnkiDeck, modifier: Modifier = Modifier, onSelectDeck: (AnkiDeck) -> Unit) {
    var showMenu by remember { mutableStateOf(false) }
    
    // Theme colors mapping
    val spineColor = MaterialTheme.colorScheme.primary
    val ringColor = MaterialTheme.colorScheme.primary
    val trackColor = MaterialTheme.colorScheme.surfaceVariant

    Card(
        modifier = modifier
            .height(220.dp)
            .clickable { onSelectDeck(deck) },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = borderStroke(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            // Spine
            Box(
                modifier = Modifier
                    .width(32.dp)
                    .fillMaxHeight()
                    .background(spineColor),
                contentAlignment = Alignment.Center
            ) {
                // Spine Text
                Text(
                    text = "LEVEL 42",
                    color = Color.White.copy(alpha = 0.9f),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp,
                    modifier = Modifier.align(Alignment.Center) // Note: actual vertical rotation requires custom modifier
                )
            }
            
            // Content
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Top header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Box(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(4.dp))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = "PREMIUM",
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 8.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )
                    }
                    
                    // Circular Progress
                    Box(modifier = Modifier.size(36.dp), contentAlignment = Alignment.Center) {
                        Canvas(modifier = Modifier.fillMaxSize()) {
                            drawCircle(color = trackColor, style = Stroke(3.dp.toPx()))
                            drawArc(
                                color = ringColor,
                                startAngle = -90f,
                                sweepAngle = 360f * 0.65f,
                                useCenter = false,
                                style = Stroke(width = 3.dp.toPx(), cap = StrokeCap.Round)
                            )
                        }
                        Text("65%", fontSize = 8.sp, fontWeight = FontWeight.Bold, color = ringColor)
                    }
                }
                
                // Title and details
                Column {
                    Text(
                        text = deck.name,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 2
                    )
                    Text(
                        text = "${deck.id} Mastery Cards",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
                
                // Action row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Avatar stack mockup
                    Row(horizontalArrangement = Arrangement.spacedBy((-6).dp)) {
                        Box(modifier = Modifier.size(20.dp).clip(CircleShape).border(1.dp, MaterialTheme.colorScheme.surface, CircleShape).background(MaterialTheme.colorScheme.primaryContainer))
                        Box(modifier = Modifier.size(20.dp).clip(CircleShape).border(1.dp, MaterialTheme.colorScheme.surface, CircleShape).background(MaterialTheme.colorScheme.secondaryContainer))
                        Box(modifier = Modifier.size(20.dp).clip(CircleShape).border(1.dp, MaterialTheme.colorScheme.surface, CircleShape).background(MaterialTheme.colorScheme.surfaceVariant), contentAlignment = Alignment.Center) {
                            Text("+12k", fontSize = 6.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                    
                    Box {
                        Button(
                            onClick = { showMenu = true },
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                            shape = CircleShape,
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
                            modifier = Modifier.height(28.dp)
                        ) {
                            Text("Study", fontSize = 10.sp, fontWeight = FontWeight.Bold)
                            Icon(Icons.Outlined.ArrowDropDown, contentDescription = null, modifier = Modifier.size(16.dp))
                        }
                        
                        DropdownMenu(
                            expanded = showMenu,
                            onDismissRequest = { showMenu = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Revision Mode (FSRS)") },
                                onClick = { showMenu = false; onSelectDeck(deck) }
                            )
                            DropdownMenuItem(
                                text = { Text("Practice Mode") },
                                onClick = { showMenu = false; onSelectDeck(deck) }
                            )
                            DropdownMenuItem(
                                text = { Text("Test Mode (Timed)", color = MaterialTheme.colorScheme.error) },
                                onClick = { showMenu = false; onSelectDeck(deck) }
                            )
                        }
                    }
                }
            }
        }
    }
}
