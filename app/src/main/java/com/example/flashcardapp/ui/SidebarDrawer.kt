package com.example.flashcardapp.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.data.AnkiDeck
import com.example.flashcardapp.ui.theme.*

import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import android.net.Uri
import com.example.flashcardapp.data.SettingsRepository
import java.io.File

// ─────────────────────────────────────────────────────────────────────────────
// Data model — reuses DeckNode from DeckSelectionScreen.kt
// ─────────────────────────────────────────────────────────────────────────────

/**
 * The full sidebar drawer content.
 *
 * @param decks           Flat list of all decks.
 * @param onSelectDeck    Called when ▶ Play is tapped for a deck/parent-node.
 * @param onDeckSettings  Called when ⚙ Settings is tapped for a deck/parent-node.
 * @param onClose         Close the drawer.
 */
@Composable
fun SidebarDrawerContent(
    decks: List<AnkiDeck>,
    onSelectDeck: (AnkiDeck) -> Unit,
    onDeckSettings: (AnkiDeck) -> Unit,
    onGlobalSettings: () -> Unit,
    onProfileClicked: () -> Unit,
    onClose: () -> Unit
) {
    val context = LocalContext.current
    val settingsRepo = remember { SettingsRepository.getInstance(context) }
    val userName = settingsRepo.userName
    val imagePath = settingsRepo.userProfileImageUri

    val bitmap = remember(imagePath) {
        if (imagePath.isNotEmpty()) {
            try {
                val file = File(imagePath)
                if (file.exists()) {
                    android.graphics.BitmapFactory.decodeFile(file.absolutePath)?.asImageBitmap()
                } else {
                    val uri = Uri.parse(imagePath)
                    context.contentResolver.openInputStream(uri)?.use { inputStream ->
                        android.graphics.BitmapFactory.decodeStream(inputStream)?.asImageBitmap()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        } else {
            null
        }
    }

    // Build tree once per deck-list change
    val tree = remember(decks) { buildDeckTree(decks) }

    // Expansion state map — persists inside the drawer's composition
    val expandedNodes = remember { mutableStateMapOf<String, Boolean>() }

    // Flatten for LazyColumn
    val visibleNodes = remember(tree, expandedNodes.toMap()) {
        val result = mutableListOf<Pair<DeckNode, Int>>()
        fun traverse(nodes: List<DeckNode>, depth: Int) {
            for (node in nodes) {
                result.add(node to depth)
                if (expandedNodes[node.fullPath] == true && node.children.isNotEmpty()) {
                    traverse(node.children, depth + 1)
                }
            }
        }
        traverse(tree, 0)
        result
    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(300.dp)
            .background(Color.White)
    ) {
        // ── Header ─────────────────────────────────────────────────────────
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFF6A3DE8), Color(0xFF9B59B6))
                    )
                )
                .clickable { onProfileClicked(); onClose() }
                .padding(top = 48.dp, bottom = 20.dp, start = 20.dp, end = 16.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        // User Avatar
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                                .background(Color.White.copy(alpha = 0.2f))
                                .border(1.5.dp, Color.White, CircleShape)
                        ) {
                            if (bitmap != null) {
                                Image(
                                    bitmap = bitmap,
                                    contentDescription = "Profile Photo",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Outlined.Person,
                                    contentDescription = "Profile",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(28.dp)
                                        .align(Alignment.Center)
                                )
                            }
                        }
                        
                        Column {
                            Text(
                                text = if (userName.isNotEmpty()) userName else "User Profile",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = "View Settings & Info",
                                fontSize = 12.sp,
                                color = Color.White.copy(alpha = 0.8f)
                            )
                        }
                    }
                    IconButton(onClick = onClose) {
                        Icon(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = "Close Sidebar",
                            tint = Color.White
                        )
                    }
                }
                Text(
                    text = "${decks.size} deck${if (decks.size != 1) "s" else ""} loaded",
                    fontSize = 13.sp,
                    color = Color.White.copy(alpha = 0.75f)
                )
            }
        }

        HorizontalDivider(color = Color(0xFFEBE3FA))

        // ── Deck label ─────────────────────────────────────────────────────
        Text(
            text = "DECKS",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = TextSecondaryGray,
            letterSpacing = 1.5.sp,
            modifier = Modifier.padding(start = 20.dp, top = 12.dp, bottom = 6.dp)
        )

        // ── Deck tree ──────────────────────────────────────────────────────
        if (decks.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        Icons.Outlined.Info,
                        contentDescription = null,
                        tint = TextSecondaryGray,
                        modifier = Modifier.size(36.dp)
                    )
                    Text(
                        "No decks yet.\nImport an APKG or CSV.",
                        color = TextSecondaryGray,
                        fontSize = 13.sp
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(visibleNodes, key = { it.first.fullPath }) { (node, depth) ->
                    SidebarDeckRow(
                        node = node,
                        depth = depth,
                        isExpanded = expandedNodes[node.fullPath] == true,
                        onToggleExpand = {
                            expandedNodes[node.fullPath] = !(expandedNodes[node.fullPath] ?: false)
                        },
                        onPlay = { deck ->
                            onSelectDeck(deck)
                            onClose()
                        },
                        onSettings = { deck ->
                            onDeckSettings(deck)
                            onClose()
                        }
                    )
                }
            }
        }

        HorizontalDivider(color = Color(0xFFEBE3FA))

        // ── User Profile footer ─────────────────────────────────────────────
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onProfileClicked(); onClose() }
                .padding(horizontal = 20.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(Icons.Outlined.Person, contentDescription = "Profile", tint = PrimaryPurple)
            Text("User Profile", fontSize = 14.sp, color = TextPrimaryDeep, fontWeight = FontWeight.Medium)
        }

        // ── Global Settings footer ─────────────────────────────────────────
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onGlobalSettings(); onClose() }
                .padding(horizontal = 20.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(Icons.Outlined.Settings, contentDescription = "Settings", tint = PrimaryPurple)
            Text("Global Settings", fontSize = 14.sp, color = TextPrimaryDeep, fontWeight = FontWeight.Medium)
        }
    }
}

// ─────────────────────────────────────────────────────────────────────────────
// Individual deck row inside the sidebar
// ─────────────────────────────────────────────────────────────────────────────
@Composable
private fun SidebarDeckRow(
    node: DeckNode,
    depth: Int,
    isExpanded: Boolean,
    onToggleExpand: () -> Unit,
    onPlay: (AnkiDeck) -> Unit,
    onSettings: (AnkiDeck) -> Unit
) {
    val hasChildren = node.children.isNotEmpty()
    val playableDeck = node.deck ?: AnkiDeck(id = -1L, name = node.fullPath)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = (depth * 14).dp)
            .clip(RoundedCornerShape(12.dp))
            .background(if (depth == 0) Color(0xFFF9F6FE) else Color.Transparent)
            .border(
                width = if (depth == 0) 1.dp else 0.dp,
                color = Color(0xFFEBE3FA),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(vertical = 8.dp, horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Expand/collapse chevron
        if (hasChildren) {
            Icon(
                imageVector = if (isExpanded) Icons.Outlined.KeyboardArrowDown else Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Toggle",
                tint = PrimaryPurple,
                modifier = Modifier
                    .size(20.dp)
                    .clickable { onToggleExpand() }
            )
            Spacer(modifier = Modifier.width(4.dp))
        } else {
            Spacer(modifier = Modifier.width(24.dp))
        }

        // Deck icon badge
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(if (hasChildren) LightPurpleAccent else Color(0xFFE3F2FD)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = if (hasChildren) Icons.Outlined.Menu else Icons.AutoMirrored.Filled.List,
                contentDescription = null,
                tint = if (hasChildren) PrimaryPurple else Color(0xFF1565C0),
                modifier = Modifier.size(16.dp)
            )
        }
        Spacer(modifier = Modifier.width(10.dp))

        // Deck name
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = node.shortName,
                fontSize = 13.sp,
                fontWeight = if (depth == 0) FontWeight.Bold else FontWeight.Medium,
                color = TextPrimaryDeep,
                maxLines = 1
            )
            if (hasChildren) {
                Text(
                    text = "${node.children.size} subdeck${if (node.children.size != 1) "s" else ""}",
                    fontSize = 10.sp,
                    color = TextSecondaryGray
                )
            }
        }

        // ▶ Play button
        Box(
            modifier = Modifier
                .size(28.dp)
                .clip(CircleShape)
                .background(PrimaryPurple)
                .clickable { onPlay(playableDeck) },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                Icons.Outlined.PlayArrow,
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
        Spacer(modifier = Modifier.width(6.dp))
        // ⚙ Settings button
        Box(
            modifier = Modifier
                .size(28.dp)
                .clip(CircleShape)
                .background(LightPurpleAccent)
                .clickable { onSettings(playableDeck) },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                Icons.Outlined.Settings,
                contentDescription = "Deck Settings",
                tint = PrimaryPurple,
                modifier = Modifier.size(14.dp)
            )
        }
    }
}
