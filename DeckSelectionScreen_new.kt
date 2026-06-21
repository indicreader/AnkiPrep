package com.example.flashcardapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import com.example.flashcardapp.data.AnkiDeck
import com.example.flashcardapp.data.entities.SessionRecordEntity
import com.example.flashcardapp.session.McqSessionMode
import com.example.flashcardapp.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeckSelectionScreen(
    decks: List<AnkiDeck>,
    cardCount: Int,
    sessionRecords: List<SessionRecordEntity>,
    isAnkiInstalled: Boolean,
    hasPermission: Boolean,
    currentMode: McqSessionMode,
    onRequestPermission: () -> Unit,
    onRefresh: () -> Unit,
    onSettingsClicked: () -> Unit,
    onImportApkgClicked: () -> Unit,
    onImportCsvClicked: () -> Unit,
    onImportEpubClicked: () -> Unit,
    onSelectDeck: (AnkiDeck) -> Unit,
    onProfileClicked: () -> Unit,
    onDeleteDeck: (AnkiDeck) -> Unit = {},
    onRenameDeck: (AnkiDeck, String) -> Unit = { _, _ -> },
    onMergeDecks: (AnkiDeck, AnkiDeck) -> Unit = { _, _ -> },
    onClearDeckProgress: (AnkiDeck) -> Unit = {},
    onCreateDeck: (String) -> Unit = {},
    onAddCardToDeck: (AnkiDeck, String, String, String, String?, String?, String?, String?) -> Unit = { _, _, _, _, _, _, _, _ -> },
    onExportDeck: (AnkiDeck) -> Unit = {},
    isDarkMode: Boolean = false,
    onDarkModeToggle: (Boolean) -> Unit = {}
) {
    var activeTab by remember { mutableStateOf("Dashboard") }

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface,
                tonalElevation = 8.dp,
                modifier = Modifier.height(80.dp)
            ) {
                NavigationBarItem(
                    selected = activeTab == "Dashboard",
                    onClick = { activeTab = "Dashboard" },
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home", fontWeight = FontWeight.Bold, fontSize = 12.sp) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        indicatorColor = MaterialTheme.colorScheme.primaryContainer
                    )
                )
                NavigationBarItem(
                    selected = activeTab == "Review",
                    onClick = { activeTab = "Review" },
                    icon = { Icon(Icons.Default.List, contentDescription = "Review") },
                    label = { Text("Review", fontWeight = FontWeight.Bold, fontSize = 12.sp) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        indicatorColor = MaterialTheme.colorScheme.primaryContainer
                    )
                )
                NavigationBarItem(
                    selected = activeTab == "Analytics",
                    onClick = { activeTab = "Analytics" },
                    icon = { Icon(Icons.Default.Star, contentDescription = "Analytics") },
                    label = { Text("Analytics", fontWeight = FontWeight.Bold, fontSize = 12.sp) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        indicatorColor = MaterialTheme.colorScheme.primaryContainer
                    )
                )
                NavigationBarItem(
                    selected = activeTab == "Settings",
                    onClick = { activeTab = "Settings" },
                    icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
                    label = { Text("Settings", fontWeight = FontWeight.Bold, fontSize = 12.sp) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        indicatorColor = MaterialTheme.colorScheme.primaryContainer
                    )
                )
            }
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            when (activeTab) {
                "Dashboard" -> DashboardTab(
                    decks = decks,
                    cardCount = cardCount,
                    onSelectDeck = onSelectDeck,
                    onProfileClicked = onProfileClicked,
                    onSettingsClicked = { activeTab = "Settings" },
                    onImportApkgClicked = onImportApkgClicked,
                    onImportCsvClicked = onImportCsvClicked,
                    onImportEpubClicked = onImportEpubClicked,
                    onCreateDeck = onCreateDeck
                )
                "Review" -> ReviewTab(
                    isAnkiInstalled = isAnkiInstalled,
                    hasPermission = hasPermission,
                    decks = decks,
                    currentMode = currentMode,
                    onRequestPermission = onRequestPermission,
                    onRefresh = onRefresh,
                    onImportApkgClicked = onImportApkgClicked,
                    onImportCsvClicked = onImportCsvClicked,
                    onImportEpubClicked = onImportEpubClicked,
                    onSelectDeck = onSelectDeck,
                    onDeleteDeck = onDeleteDeck,
                    onRenameDeck = onRenameDeck,
                    onClearDeckProgress = onClearDeckProgress,
                    onCreateDeck = onCreateDeck,
                    onAddCardToDeck = onAddCardToDeck,
                    onExportDeck = onExportDeck,
                    onMenuClicked = {}
                )
                "Analytics" -> AnalyticsTab(
                    cardCount = cardCount,
                    sessionRecords = sessionRecords,
                    onMenuClicked = {}
                )
                "Settings" -> {
                    // Temporarily triggering settings click since we don't have a tab yet
                    LaunchedEffect(Unit) {
                        onSettingsClicked()
                        activeTab = "Dashboard"
                    }
                }
            }
        }
    }
}



