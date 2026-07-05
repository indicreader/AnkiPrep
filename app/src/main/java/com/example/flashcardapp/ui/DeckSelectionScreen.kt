package com.example.flashcardapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.border
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
    isAnkiInstalled: Boolean,
    hasPermission: Boolean,
    isDarkMode: Boolean = false,
    onDarkModeToggle: (Boolean) -> Unit = {},
    themePreset: String = "EMERALD",
    onThemePresetChange: (String) -> Unit = {},
    fontFamilyType: String = "DEFAULT",
    onFontFamilyTypeChange: (String) -> Unit = {},
    decks: List<AnkiDeck>,
    currentMode: McqSessionMode,
    cardCount: Int,
    sessionRecords: List<SessionRecordEntity>,
    attemptsToday: List<com.example.flashcardapp.data.entities.CardAttemptEntity> = emptyList(),
    onRequestPermission: () -> Unit,
    onRefresh: () -> Unit,
    onSettingsClicked: () -> Unit,
    onImportApkgClicked: () -> Unit,
    onImportCsvClicked: () -> Unit,
    onImportEpubClicked: () -> Unit = {},
    onSelectDeck: (AnkiDeck) -> Unit,
    onProfileClicked: () -> Unit,
    onDeleteDeck: (AnkiDeck) -> Unit = {},
    onRenameDeck: (AnkiDeck, String) -> Unit = { _, _ -> },
    onClearDeckProgress: (AnkiDeck) -> Unit = {},
    onCreateDeck: (String) -> Unit = {},
    onMergeDecks: (AnkiDeck, AnkiDeck) -> Unit = { _, _ -> },
    onAddCardToDeck: (AnkiDeck, String, String, String, String?, String?, String?, String?) -> Unit = { _, _, _, _, _, _, _, _ -> },
    onExportDeck: (AnkiDeck) -> Unit = {},
    onDeckOrderChanged: () -> Unit = {},
    repo: com.example.flashcardapp.data.AnkiDataRepository,
    onStartRevisionSession: (List<Long>, Boolean, McqSessionMode) -> Unit = { _, _, _ -> }
) {
    val currentLanguage by com.example.flashcardapp.data.TranslationManager.currentLanguage.collectAsState()
    var activeTab by remember { mutableStateOf("Dashboard") }

    Scaffold(
        bottomBar = {
            // ── Pill-style bottom navigation ─────────────────────────────────
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .navigationBarsPadding()
                    .padding(horizontal = 16.dp, vertical = 6.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                        .clip(RoundedCornerShape(26.dp))
                        .background(MaterialTheme.colorScheme.surface)
                        .border(0.5.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.2f), RoundedCornerShape(26.dp)),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val tabs = listOf(
                        Triple("Dashboard", Icons.Filled.Home, Icons.Outlined.Home),
                        Triple("Review",    Icons.Filled.Quiz, Icons.Outlined.Quiz),
                        Triple("Revise",    Icons.Filled.Star, Icons.Outlined.Star),
                        Triple("Analytics", Icons.Filled.Analytics, Icons.Outlined.Analytics),
                        Triple("Settings",  Icons.Filled.Settings, Icons.Outlined.Settings)
                    )
                    val tabLabels = listOf(
                        com.example.flashcardapp.data.TranslationManager.getString("tab_home"),
                        com.example.flashcardapp.data.TranslationManager.getString("tab_library"),
                        com.example.flashcardapp.data.TranslationManager.getString("tab_revise"),
                        com.example.flashcardapp.data.TranslationManager.getString("tab_analytics"),
                        com.example.flashcardapp.data.TranslationManager.getString("tab_settings")
                    )
                    tabs.forEachIndexed { idx, (key, filledIcon, outlineIcon) ->
                        val selected = activeTab == key
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .padding(4.dp)
                                .clip(RoundedCornerShape(24.dp))
                                .background(
                                    if (selected) MaterialTheme.colorScheme.primary
                                    else Color.Transparent
                                  )
                                .clickable { activeTab = key },
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp),
                                modifier = Modifier.padding(horizontal = 8.dp)
                            ) {
                                Icon(
                                    imageVector = if (selected) filledIcon else outlineIcon,
                                    contentDescription = tabLabels[idx],
                                    tint = if (selected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.size(22.dp)
                                )
                                if (selected) {
                                    Text(
                                        text = tabLabels[idx],
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 11.sp,
                                        color = Color.White
                                    )
                                }
                            }
                        }
                    }
                }
            }
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (activeTab) {
                "Dashboard" -> DashboardTab(
                    decks = decks,
                    cardCount = cardCount,
                    sessionRecords = sessionRecords,
                    onSelectDeck = onSelectDeck,
                    onManageDeckClicked = { activeTab = "Review" },
                    onSettingsClicked = { activeTab = "Settings" },
                    onProfileClicked = onProfileClicked,
                    onAnalyticsClicked = { activeTab = "Analytics" },
                    isDarkMode = isDarkMode,
                    onDarkModeToggle = onDarkModeToggle
                )
                "Review" -> ReviewTab(
                    isAnkiInstalled = isAnkiInstalled,
                    hasPermission = hasPermission,
                    decks = decks,
                    attemptsToday = attemptsToday,
                    currentMode = currentMode,
                    isDarkMode = isDarkMode,
                    onDarkModeToggle = onDarkModeToggle,
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
                    onMenuClicked = {},
                    onDeckOrderChanged = onDeckOrderChanged
                )
                "Revise" -> ReviseTab(
                    repo = repo,
                    onStartSession = onStartRevisionSession,
                    isDarkMode = isDarkMode,
                    onDarkModeToggle = { onDarkModeToggle(!isDarkMode) }
                )
                "Analytics" -> AnalyticsTab(
                    cardCount = cardCount,
                    sessionRecords = sessionRecords,
                    onMenuClicked = {}
                )
                "Settings" -> SettingsTab(
                    isDarkMode = isDarkMode,
                    onDarkModeToggle = onDarkModeToggle,
                    themePreset = themePreset,
                    onThemePresetChange = onThemePresetChange,
                    fontFamilyType = fontFamilyType,
                    onFontFamilyTypeChange = onFontFamilyTypeChange,
                    onNavigateToProfile = onProfileClicked
                )
            }
        }
    }
}
