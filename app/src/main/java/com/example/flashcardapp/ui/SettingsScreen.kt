package com.example.flashcardapp.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.data.AnkiDeck
import com.example.flashcardapp.data.AppLanguage
import com.example.flashcardapp.data.TranslationManager
import com.example.flashcardapp.session.McqSessionMode
import com.example.flashcardapp.ui.settings.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    currentMode: McqSessionMode,
    onModeChange: (McqSessionMode) -> Unit,
    vibrationEnabled: Boolean,
    onVibrationToggle: (Boolean) -> Unit,
    numberOfOptions: Int,
    onNumberOfOptionsChange: (Int) -> Unit,
    questionLimit: Int,
    onQuestionLimitChange: (Int) -> Unit,
    shuffleQuestions: Boolean,
    onShuffleQuestionsToggle: (Boolean) -> Unit,
    showExplanations: Boolean,
    onShowExplanationsToggle: (Boolean) -> Unit,
    timeLimitSeconds: Int,
    onTimeLimitSecondsChange: (Int) -> Unit,
    themePreset: String,
    onThemePresetChange: (String) -> Unit,
    useDynamicWallpaper: Boolean,
    onUseDynamicWallpaperToggle: (Boolean) -> Unit,
    fontFamilyType: String,
    onFontFamilyTypeChange: (String) -> Unit,
    currentLanguage: AppLanguage,
    onLanguageChange: (AppLanguage) -> Unit,
    deckCount: Int,
    cardCount: Int,
    onSyncNow: () -> Unit,
    onClearCache: () -> Unit,
    isDarkMode: Boolean = false,
    onDarkModeToggle: (Boolean) -> Unit = {},
    onBackPressed: () -> Unit,
    decks: List<AnkiDeck> = emptyList(),
    onImportApkgClicked: () -> Unit = {},
    onImportCsvClicked: () -> Unit = {},
    onImportEpubClicked: () -> Unit = {},
    onImportPdfClicked: () -> Unit = {},
    onExportDeck: (AnkiDeck) -> Unit = {},
    onOpenPlugins: () -> Unit = {},
    onOpenCurrentAffairs: () -> Unit = {}
) {
    // ── 3-Tier Back-Stack Navigation State ─────────────────────────────────────
    val backStack = remember { mutableStateListOf<SettingsRoute>(SettingsRoute.Root) }
    val currentRoute = backStack.lastOrNull() ?: SettingsRoute.Root

    fun navigateTo(route: SettingsRoute) {
        backStack.add(route)
    }

    fun popBack(): Boolean {
        if (backStack.size > 1) {
            backStack.removeAt(backStack.size - 1)
            return true
        }
        return false
    }

    // Intercept system back button: Pop inner settings back stack without quitting app
    BackHandler(enabled = backStack.size > 1) {
        popBack()
    }

    var showSyncScreen by remember { mutableStateOf(false) }
    var showWebScraper by remember { mutableStateOf(false) }

    if (showSyncScreen) {
        SyncScreen(onBack = { showSyncScreen = false })
        return
    }

    if (showWebScraper) {
        WebScrapeScreen(
            decks = decks,
            onBack = { showWebScraper = false },
            onDeckImported = { showWebScraper = false }
        )
        return
    }

    val screenTitle = when (val route = currentRoute) {
        is SettingsRoute.Root -> TranslationManager.getString("settings")
        is SettingsRoute.Category -> route.category.title
        is SettingsRoute.SubCategory -> route.subCategory.title
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = screenTitle,
                        fontWeight = FontWeight.Bold,
                        fontSize = 19.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            if (!popBack()) {
                                onBackPressed()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 680.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                when (val route = currentRoute) {
                    is SettingsRoute.Root -> {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            SettingsCategory.values().forEach { category ->
                                SettingCategoryCard(
                                    category = category,
                                    onClick = { navigateTo(SettingsRoute.Category(category)) }
                                )
                            }
                            Spacer(Modifier.height(24.dp))
                        }
                    }

                    is SettingsRoute.Category -> {
                        when (route.category) {
                            SettingsCategory.APPEARANCE -> {
                                AppearanceCategoryScreen(
                                    onNavigateToSubCategory = { subCat ->
                                        navigateTo(SettingsRoute.SubCategory(route.category, subCat))
                                    },
                                    themePreset = themePreset,
                                    isDarkMode = isDarkMode,
                                    fontFamilyType = fontFamilyType
                                )
                            }

                            SettingsCategory.STUDY_PREFERENCES -> {
                                StudyPreferencesCategoryScreen(
                                    onNavigateToSubCategory = { subCat ->
                                        navigateTo(SettingsRoute.SubCategory(route.category, subCat))
                                    },
                                    currentMode = currentMode,
                                    questionLimit = questionLimit,
                                    timeLimitSeconds = timeLimitSeconds
                                )
                            }

                            SettingsCategory.BACKUP_SYNC -> {
                                BackupSyncCategoryScreen(
                                    onNavigateToSubCategory = { subCat ->
                                        navigateTo(SettingsRoute.SubCategory(route.category, subCat))
                                    },
                                    onOpenLocalWifiSync = { showSyncScreen = true }
                                )
                            }

                            SettingsCategory.EXTENSIONS -> {
                                ExtensionsCategoryScreen(
                                    onNavigateToSubCategory = { subCat ->
                                        navigateTo(SettingsRoute.SubCategory(route.category, subCat))
                                    },
                                    onOpenPlugins = onOpenPlugins,
                                    onOpenCurrentAffairs = onOpenCurrentAffairs,
                                    onOpenWebScraper = { showWebScraper = true }
                                )
                            }

                            SettingsCategory.LANGUAGE_TRANSLATIONS -> {
                                LanguageCategoryScreen(
                                    onNavigateToSubCategory = { subCat ->
                                        navigateTo(SettingsRoute.SubCategory(route.category, subCat))
                                    },
                                    currentLanguage = currentLanguage,
                                    vibrationEnabled = vibrationEnabled
                                )
                            }

                            SettingsCategory.STORAGE -> {
                                StorageCategoryScreen(
                                    onNavigateToSubCategory = { subCat ->
                                        navigateTo(SettingsRoute.SubCategory(route.category, subCat))
                                    },
                                    deckCount = deckCount,
                                    cardCount = cardCount
                                )
                            }

                            SettingsCategory.WHITEBOARD -> {
                                WhiteboardCategoryScreen(
                                    onNavigateToSubCategory = { subCat ->
                                        navigateTo(SettingsRoute.SubCategory(route.category, subCat))
                                    }
                                )
                            }

                            SettingsCategory.PROFILE -> {
                                ProfileCategoryScreen(
                                    onNavigateToSubCategory = { subCat ->
                                        navigateTo(SettingsRoute.SubCategory(route.category, subCat))
                                    }
                                )
                            }

                            SettingsCategory.INSTRUCTIONS -> {
                                Box(modifier = Modifier.padding(16.dp)) {
                                    InstructionsSection()
                                }
                            }

                            SettingsCategory.ABOUT -> {
                                AboutCategoryScreen(
                                    onNavigateToSubCategory = { subCat ->
                                        navigateTo(SettingsRoute.SubCategory(route.category, subCat))
                                    }
                                )
                            }
                        }
                    }

                    is SettingsRoute.SubCategory -> {
                        when (route.category) {
                            SettingsCategory.APPEARANCE -> {
                                AppearanceSubCategoryScreen(
                                    subCategory = route.subCategory,
                                    themePreset = themePreset,
                                    onThemePresetChange = onThemePresetChange,
                                    isDarkMode = isDarkMode,
                                    onDarkModeToggle = onDarkModeToggle,
                                    useDynamicWallpaper = useDynamicWallpaper,
                                    onUseDynamicWallpaperToggle = onUseDynamicWallpaperToggle,
                                    fontFamilyType = fontFamilyType,
                                    onFontFamilyTypeChange = onFontFamilyTypeChange
                                )
                            }

                            SettingsCategory.STUDY_PREFERENCES -> {
                                StudyPreferencesSubCategoryScreen(
                                    subCategory = route.subCategory,
                                    currentMode = currentMode,
                                    onModeChange = onModeChange,
                                    numberOfOptions = numberOfOptions,
                                    onNumberOfOptionsChange = onNumberOfOptionsChange,
                                    questionLimit = questionLimit,
                                    onQuestionLimitChange = onQuestionLimitChange,
                                    shuffleQuestions = shuffleQuestions,
                                    onShuffleQuestionsToggle = onShuffleQuestionsToggle,
                                    showExplanations = showExplanations,
                                    onShowExplanationsToggle = onShowExplanationsToggle,
                                    timeLimitSeconds = timeLimitSeconds,
                                    onTimeLimitSecondsChange = onTimeLimitSecondsChange
                                )
                            }

                            SettingsCategory.BACKUP_SYNC -> {
                                BackupSyncSubCategoryScreen(
                                    subCategory = route.subCategory,
                                    onSyncNow = onSyncNow
                                )
                            }

                            SettingsCategory.LANGUAGE_TRANSLATIONS -> {
                                LanguageSubCategoryScreen(
                                    subCategory = route.subCategory,
                                    currentLanguage = currentLanguage,
                                    onLanguageChange = onLanguageChange,
                                    vibrationEnabled = vibrationEnabled,
                                    onVibrationToggle = onVibrationToggle
                                )
                            }

                            SettingsCategory.STORAGE -> {
                                StorageSubCategoryScreen(
                                    subCategory = route.subCategory,
                                    deckCount = deckCount,
                                    cardCount = cardCount,
                                    onSyncNow = onSyncNow,
                                    onClearCache = onClearCache,
                                    decks = decks,
                                    onImportApkgClicked = onImportApkgClicked,
                                    onImportCsvClicked = onImportCsvClicked,
                                    onImportEpubClicked = onImportEpubClicked,
                                    onImportPdfClicked = onImportPdfClicked,
                                    onExportDeck = onExportDeck
                                )
                            }

                            SettingsCategory.WHITEBOARD -> {
                                WhiteboardSubCategoryScreen(
                                    subCategory = route.subCategory
                                )
                            }

                            SettingsCategory.PROFILE -> {
                                ProfileSubCategoryScreen(
                                    subCategory = route.subCategory
                                )
                            }

                            SettingsCategory.ABOUT -> {
                                AboutSubCategoryScreen(
                                    subCategory = route.subCategory
                                )
                            }

                            else -> {
                                Box(modifier = Modifier.padding(16.dp)) {
                                    InstructionsSection()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
