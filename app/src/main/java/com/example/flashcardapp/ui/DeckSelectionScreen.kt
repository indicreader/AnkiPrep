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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.ui.graphics.Brush
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
    useOledBlack: Boolean = false,
    onUseOledBlackToggle: (Boolean) -> Unit = {},
    fontScaleFactor: Float = 1.0f,
    onFontScaleFactorChange: (Float) -> Unit = {},
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
    onImportPdfClicked: () -> Unit = {},
    onSelectDeck: (AnkiDeck) -> Unit,
    onProfileClicked: () -> Unit,
    onDeleteDeck: (String) -> Unit = {},
    onRenameDeck: (AnkiDeck, String) -> Unit = { _, _ -> },
    onClearDeckProgress: (AnkiDeck) -> Unit = {},
    onCreateDeck: (String) -> Unit = {},
    onMergeDecks: (AnkiDeck, AnkiDeck) -> Unit = { _, _ -> },
    onAddCardToDeck: (AnkiDeck, String, String, String, String?, String?, String?, String?) -> Unit = { _, _, _, _, _, _, _, _ -> },
    onExportDeck: (AnkiDeck) -> Unit = {},
    onDeckOrderChanged: (List<Long>) -> Unit = {},
    repo: com.example.flashcardapp.data.AnkiDataRepository,
    onStartRevisionSession: (List<Long>, Boolean, McqSessionMode) -> Unit = { _, _, _ -> },
    onStartCombinedTest: (List<String>, List<String>) -> Unit = { _, _ -> },
    onStartMockExam: (AnkiDeck, com.example.flashcardapp.mock.ExamPreset) -> Unit = { _, _ -> },
    onOpenPlugins: () -> Unit = {},
    onOpenCurrentAffairs: () -> Unit = {}
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
                    .padding(horizontal = 14.dp, vertical = 6.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                val (navLight, navDark) = rememberNeumorphicColors(isDarkMode)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .neumorphicShadow(
                            isDarkMode = isDarkMode,
                            cornerRadius = 24.dp,
                            elevation = 6.dp,
                            lightShadowColor = navLight,
                            darkShadowColor = navDark
                        )
                        .clip(RoundedCornerShape(24.dp))
                        .background(MaterialTheme.colorScheme.surface)
                        .border(
                            BorderStroke(
                                1.dp,
                                Brush.linearGradient(
                                    listOf(
                                        navLight.copy(alpha = if (isDarkMode) 0.35f else 0.8f),
                                        navDark.copy(alpha = if (isDarkMode) 0.5f else 0.25f)
                                    )
                                )
                            ),
                            RoundedCornerShape(24.dp)
                        ),
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
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .clickable { activeTab = key }
                                .padding(vertical = 4.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .height(28.dp)
                                    .clip(RoundedCornerShape(14.dp))
                                    .background(
                                        if (selected) MaterialTheme.colorScheme.primaryContainer
                                        else Color.Transparent
                                    )
                                    .padding(horizontal = 12.dp, vertical = 4.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = if (selected) filledIcon else outlineIcon,
                                    contentDescription = tabLabels[idx],
                                    tint = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                            Spacer(Modifier.height(2.dp))
                            Text(
                                text = tabLabels[idx],
                                fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
                                fontSize = 10.sp,
                                color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
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
                    onImportPdfClicked = onImportPdfClicked,
                    onSelectDeck = onSelectDeck,
                    onDeleteDeck = onDeleteDeck,
                    onRenameDeck = onRenameDeck,
                    onClearDeckProgress = onClearDeckProgress,
                    onCreateDeck = onCreateDeck,
                    onAddCardToDeck = onAddCardToDeck,
                    onExportDeck = onExportDeck,
                    onMenuClicked = {},
                    onDeckOrderChanged = onDeckOrderChanged,
                    onStartCombinedTest = onStartCombinedTest,
                    onStartMockExam = onStartMockExam
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
                    useOledBlack = useOledBlack,
                    onUseOledBlackToggle = onUseOledBlackToggle,
                    fontScaleFactor = fontScaleFactor,
                    onFontScaleFactorChange = onFontScaleFactorChange,
                    themePreset = themePreset,
                    onThemePresetChange = onThemePresetChange,
                    fontFamilyType = fontFamilyType,
                    onFontFamilyTypeChange = onFontFamilyTypeChange,
                    onNavigateToProfile = onProfileClicked,
                    decks = decks,
                    onImportApkgClicked = onImportApkgClicked,
                    onImportCsvClicked = onImportCsvClicked,
                    onImportEpubClicked = onImportEpubClicked,
                    onImportPdfClicked = onImportPdfClicked,
                    onExportDeck = onExportDeck,
                    onOpenPlugins = onOpenPlugins,
                    onOpenCurrentAffairs = onOpenCurrentAffairs
                )
            }
        }
    }
}
