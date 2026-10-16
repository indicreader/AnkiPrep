package com.example.flashcardapp.ui

import android.content.Context
import android.net.Uri
import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.flashcardapp.data.AnkiDeck
import com.example.flashcardapp.data.AppLanguage
import com.example.flashcardapp.data.SettingsRepository
import com.example.flashcardapp.data.TranslationManager
import com.example.flashcardapp.ui.settings.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsTab(
    isDarkMode: Boolean,
    onDarkModeToggle: (Boolean) -> Unit,
    useOledBlack: Boolean = false,
    onUseOledBlackToggle: (Boolean) -> Unit = {},
    fontScaleFactor: Float = 1.0f,
    onFontScaleFactorChange: (Float) -> Unit = {},
    themePreset: String,
    onThemePresetChange: (String) -> Unit,
    fontFamilyType: String,
    onFontFamilyTypeChange: (String) -> Unit,
    onNavigateToProfile: () -> Unit,
    decks: List<AnkiDeck> = emptyList(),
    onImportApkgClicked: () -> Unit = {},
    onImportCsvClicked: () -> Unit = {},
    onImportEpubClicked: () -> Unit = {},
    onImportPdfClicked: () -> Unit = {},
    onExportDeck: (AnkiDeck) -> Unit = {},
    onOpenPlugins: () -> Unit = {},
    onOpenCurrentAffairs: () -> Unit = {}
) {
    val context = LocalContext.current
    val repository = remember { SettingsRepository.getInstance(context) }
    val sharedPrefs = remember { context.getSharedPreferences("AnkiPrepProfile", Context.MODE_PRIVATE) }
    var avatarUriStr by remember { mutableStateOf(sharedPrefs.getString("avatar_uri", null)) }

    DisposableEffect(sharedPrefs) {
        val listener = android.content.SharedPreferences.OnSharedPreferenceChangeListener { prefs, key ->
            if (key == "avatar_uri") {
                avatarUriStr = prefs.getString("avatar_uri", null)
            }
        }
        sharedPrefs.registerOnSharedPreferenceChangeListener(listener)
        onDispose {
            sharedPrefs.unregisterOnSharedPreferenceChangeListener(listener)
        }
    }
    val avatarUri = remember(avatarUriStr) { avatarUriStr?.let { Uri.parse(it) } }

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
        is SettingsRoute.Root -> "AnkiPrep"
        is SettingsRoute.Category -> route.category.title
        is SettingsRoute.SubCategory -> route.subCategory.title
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = 680.dp)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(Modifier.height(16.dp))

            // ── Top Header ─────────────────────────────────────────────
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    if (backStack.size > 1) {
                        IconButton(onClick = { popBack() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    } else {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.15f))
                                .clickable { onNavigateToProfile() },
                            contentAlignment = Alignment.Center
                        ) {
                            if (avatarUri != null) {
                                AsyncImage(
                                    model = avatarUri,
                                    contentDescription = "Profile",
                                    modifier = Modifier.fillMaxSize().clip(CircleShape),
                                    contentScale = ContentScale.Crop
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = "Profile",
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                    }

                    Text(
                        text = screenTitle,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            // ── Content Router ─────────────────────────────────────────
            when (val route = currentRoute) {
                is SettingsRoute.Root -> {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        SettingsCategory.values().forEach { category ->
                            SettingCategoryCard(
                                category = category,
                                onClick = { navigateTo(SettingsRoute.Category(category)) }
                            )
                        }
                        Spacer(Modifier.height(32.dp))
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
                                currentMode = repository.studyMode,
                                questionLimit = repository.questionLimit,
                                timeLimitSeconds = repository.timeLimitSeconds
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
                            val currentLang = AppLanguage.values().firstOrNull { it.code == repository.appLanguage } ?: AppLanguage.EN
                            LanguageCategoryScreen(
                                onNavigateToSubCategory = { subCat ->
                                    navigateTo(SettingsRoute.SubCategory(route.category, subCat))
                                },
                                currentLanguage = currentLang,
                                vibrationEnabled = repository.vibrationEnabled
                            )
                        }

                        SettingsCategory.STORAGE -> {
                            StorageCategoryScreen(
                                onNavigateToSubCategory = { subCat ->
                                    navigateTo(SettingsRoute.SubCategory(route.category, subCat))
                                },
                                deckCount = decks.size,
                                cardCount = 0
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
                            InstructionsSection()
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
                                useDynamicWallpaper = repository.useDynamicWallpaperTheme,
                                onUseDynamicWallpaperToggle = { repository.useDynamicWallpaperTheme = it },
                                fontFamilyType = fontFamilyType,
                                onFontFamilyTypeChange = onFontFamilyTypeChange
                            )
                        }

                        SettingsCategory.STUDY_PREFERENCES -> {
                            var currentMode by remember { mutableStateOf(repository.studyMode) }
                            var numberOfOptions by remember { mutableStateOf(repository.numberOfOptions) }
                            var questionLimit by remember { mutableStateOf(repository.questionLimit) }
                            var shuffleQuestions by remember { mutableStateOf(repository.shuffleQuestions) }
                            var showExplanations by remember { mutableStateOf(repository.showExplanations) }
                            var timeLimitSeconds by remember { mutableStateOf(repository.timeLimitSeconds) }

                            StudyPreferencesSubCategoryScreen(
                                subCategory = route.subCategory,
                                currentMode = currentMode,
                                onModeChange = {
                                    currentMode = it
                                    repository.studyMode = it
                                },
                                numberOfOptions = numberOfOptions,
                                onNumberOfOptionsChange = {
                                    numberOfOptions = it
                                    repository.numberOfOptions = it
                                },
                                questionLimit = questionLimit,
                                onQuestionLimitChange = {
                                    questionLimit = it
                                    repository.questionLimit = it
                                },
                                shuffleQuestions = shuffleQuestions,
                                onShuffleQuestionsToggle = {
                                    shuffleQuestions = it
                                    repository.shuffleQuestions = it
                                },
                                showExplanations = showExplanations,
                                onShowExplanationsToggle = {
                                    showExplanations = it
                                    repository.showExplanations = it
                                },
                                timeLimitSeconds = timeLimitSeconds,
                                onTimeLimitSecondsChange = {
                                    timeLimitSeconds = it
                                    repository.timeLimitSeconds = it
                                }
                            )
                        }

                        SettingsCategory.BACKUP_SYNC -> {
                            BackupSyncSubCategoryScreen(
                                subCategory = route.subCategory,
                                onSyncNow = {}
                            )
                        }

                        SettingsCategory.LANGUAGE_TRANSLATIONS -> {
                            val currentLang = AppLanguage.values().firstOrNull { it.code == repository.appLanguage } ?: AppLanguage.EN
                            var vibrationEnabled by remember { mutableStateOf(repository.vibrationEnabled) }

                            LanguageSubCategoryScreen(
                                subCategory = route.subCategory,
                                currentLanguage = currentLang,
                                onLanguageChange = {
                                    TranslationManager.setLanguage(it)
                                    repository.appLanguage = it.code
                                },
                                vibrationEnabled = vibrationEnabled,
                                onVibrationToggle = {
                                    vibrationEnabled = it
                                    repository.vibrationEnabled = it
                                }
                            )
                        }

                        SettingsCategory.STORAGE -> {
                            StorageSubCategoryScreen(
                                subCategory = route.subCategory,
                                deckCount = decks.size,
                                cardCount = 0,
                                onSyncNow = {},
                                onClearCache = {},
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
                            InstructionsSection()
                        }
                    }
                }
            }
        }
    }
}
