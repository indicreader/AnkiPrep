package com.example.flashcardapp.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.session.McqSessionMode
import com.example.flashcardapp.ui.theme.*
import com.example.flashcardapp.data.AppLanguage
import com.example.flashcardapp.data.TranslationManager

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
    onBackPressed: () -> Unit
) {
    var questionLimitDropdownExpanded by remember { mutableStateOf(false) }
    var timeLimitDropdownExpanded by remember { mutableStateOf(false) }
    val timeLimitMinutes = timeLimitSeconds / 60
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(TranslationManager.getString("settings"), color = TextPrimaryDeep, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = PrimaryPurple)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = BackgroundLavender)
            )
        },
        containerColor = BackgroundLavender
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp, vertical = 12.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Section 1: Study Mode Selection
            Text(
                text = TranslationManager.getString("study_mode"),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryPurple
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = CardBackgroundLight),
                border = BorderStroke(1.dp, Color(0xFFE8E2EC)),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    StudyModeOption(
                        title = TranslationManager.getString("practice_mode"),
                        description = TranslationManager.getString("practice_mode_desc"),
                        isSelected = currentMode == McqSessionMode.PRACTICE,
                        onClick = { onModeChange(McqSessionMode.PRACTICE) }
                    )

                    HorizontalDivider(color = Color(0xFFEBE3FA))

                    StudyModeOption(
                        title = TranslationManager.getString("test_mode"),
                        description = TranslationManager.getString("test_mode_desc"),
                        isSelected = currentMode == McqSessionMode.TEST,
                        onClick = { onModeChange(McqSessionMode.TEST) }
                    )

                    HorizontalDivider(color = Color(0xFFEBE3FA))

                    StudyModeOption(
                        title = TranslationManager.getString("revision_mode"),
                        description = TranslationManager.getString("revision_mode_desc"),
                        isSelected = currentMode == McqSessionMode.REVISION,
                        onClick = { onModeChange(McqSessionMode.REVISION) }
                    )
                }
            }

            // Theme & Style Customization
            Text(
                text = TranslationManager.getString("visuals_theming"),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryPurple
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = CardBackgroundLight),
                border = BorderStroke(1.dp, Color(0xFFE8E2EC)),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    // Dynamic Wallpaper Switch
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = TranslationManager.getString("dynamic_wallpaper"),
                                color = TextPrimaryDeep,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = TranslationManager.getString("dynamic_wallpaper_desc"),
                                color = TextSecondaryGray,
                                fontSize = 12.sp
                            )
                        }
                        Switch(
                            checked = useDynamicWallpaper,
                            onCheckedChange = onUseDynamicWallpaperToggle,
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                checkedTrackColor = PrimaryPurple,
                                uncheckedThumbColor = TextSecondaryGray,
                                uncheckedTrackColor = Color(0xFFEBE3FA)
                            )
                        )
                    }
                // Dark Mode toggle
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Dark Mode",
                            fontWeight = FontWeight.SemiBold,
                            color = TextPrimaryDeep
                        )
                        Text(
                            text = "Deep Space Cyber aesthetic",
                            fontSize = 12.sp,
                            color = TextSecondaryGray
                        )
                    }
                    Switch(
                        checked = isDarkMode,
                        onCheckedChange = onDarkModeToggle,
                        colors = SwitchDefaults.colors(checkedThumbColor = PrimaryPurple)
                    )
                }

                    if (!useDynamicWallpaper) {
                        HorizontalDivider(color = Color(0xFFEBE3FA))

                        // Theme Presets
                        Column {
                            Text(
                                text = TranslationManager.getString("theme_preset"),
                                color = TextPrimaryDeep,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = TranslationManager.getString("theme_preset_desc"),
                                color = TextSecondaryGray,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            SegmentedSelector(
                                options = listOf("LAVENDER", "EMERALD", "OCEAN", "SUNSET"),
                                selectedOption = themePreset,
                                onOptionSelected = onThemePresetChange,
                                labelProvider = {
                                    when(it) {
                                        "LAVENDER" -> TranslationManager.getString("theme_lavender")
                                        "EMERALD" -> TranslationManager.getString("theme_emerald")
                                        "OCEAN" -> TranslationManager.getString("theme_ocean")
                                        "SUNSET" -> TranslationManager.getString("theme_sunset")
                                        else -> it
                                    }
                                }
                            )
                        }
                    }

                    HorizontalDivider(color = Color(0xFFEBE3FA))

                    // Font Selection
                    Column {
                        Text(
                            text = TranslationManager.getString("font_family"),
                            color = TextPrimaryDeep,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = TranslationManager.getString("font_family_desc"),
                            color = TextSecondaryGray,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        SegmentedSelector(
                            options = listOf("DEFAULT", "SERIF", "SAN_SERIF", "MONOSPACE"),
                            selectedOption = fontFamilyType,
                            onOptionSelected = onFontFamilyTypeChange,
                            labelProvider = {
                                when(it) {
                                    "DEFAULT" -> TranslationManager.getString("font_default")
                                    "SERIF" -> TranslationManager.getString("font_serif")
                                    "SAN_SERIF" -> TranslationManager.getString("font_sans")
                                    "MONOSPACE" -> TranslationManager.getString("font_mono")
                                    else -> it
                                }
                            }
                        )
                    }
                }
            }

            // Section 2: Quiz Generator Controls
            Text(
                text = TranslationManager.getString("quiz_preferences"),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryPurple
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = CardBackgroundLight),
                border = BorderStroke(1.dp, Color(0xFFE8E2EC)),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    // Option 1: Number of Options (2-5)
                    Column {
                        Text(
                            text = TranslationManager.getString("options_count"),
                            color = TextPrimaryDeep,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = TranslationManager.getString("options_count_desc"),
                            color = TextSecondaryGray,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        SegmentedSelector(
                            options = listOf(2, 3, 4, 5),
                            selectedOption = numberOfOptions,
                            onOptionSelected = onNumberOfOptionsChange,
                            labelProvider = { TranslationManager.getString("options_format").format(it) }
                        )
                    }

                    HorizontalDivider(color = Color(0xFFEBE3FA))

                    // Option 2: Question Limit
                    Column {
                        Text(
                            text = TranslationManager.getString("question_limit"),
                            color = TextPrimaryDeep,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = TranslationManager.getString("question_limit_desc"),
                            color = TextSecondaryGray,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(modifier = Modifier.weight(1f)) {
                                OutlinedButton(
                                    onClick = { questionLimitDropdownExpanded = true },
                                    modifier = Modifier.fillMaxWidth(),
                                    shape = RoundedCornerShape(12.dp),
                                    colors = ButtonDefaults.outlinedButtonColors(contentColor = PrimaryPurple),
                                    border = BorderStroke(1.dp, Color(0xFFE8E2EC))
                                ) {
                                    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                                        Text(text = if (questionLimit == 0) "All" else "$questionLimit Qs")
                                        Icon(Icons.Filled.ArrowDropDown, null)
                                    }
                                }
                                DropdownMenu(
                                    expanded = questionLimitDropdownExpanded,
                                    onDismissRequest = { questionLimitDropdownExpanded = false }
                                ) {
                                    listOf(20, 30, 50, 60, 80, 100, 0).forEach { limit ->
                                        DropdownMenuItem(
                                            text = { Text(if (limit == 0) "All" else "$limit Questions") },
                                            onClick = {
                                                onQuestionLimitChange(limit)
                                                questionLimitDropdownExpanded = false
                                            }
                                        )
                                    }
                                }
                            }

                            var customLimitText by remember(questionLimit) {
                                mutableStateOf(if (questionLimit > 0 && questionLimit !in listOf(20, 30, 50, 60, 80, 100)) questionLimit.toString() else "")
                            }

                            OutlinedTextField(
                                value = customLimitText,
                                onValueChange = { text ->
                                    val clean = text.filter { it.isDigit() }
                                    customLimitText = clean
                                    val num = clean.toIntOrNull() ?: 0
                                    val bounded = if (num > 500) 500 else num
                                    if (clean.isNotEmpty()) {
                                        onQuestionLimitChange(bounded)
                                    } else {
                                        onQuestionLimitChange(20)
                                    }
                                },
                                label = { Text("Manual (1-500)") },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = PrimaryPurple,
                                    focusedLabelColor = PrimaryPurple
                                ),
                                modifier = Modifier.weight(1f),
                                singleLine = true
                            )
                        }
                    }

                    HorizontalDivider(color = Color(0xFFEBE3FA))

                    // Option 3: Time Limit
                    Column {
                        Text(
                            text = TranslationManager.getString("time_limit"),
                            color = TextPrimaryDeep,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = TranslationManager.getString("time_limit_desc"),
                            color = TextSecondaryGray,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(modifier = Modifier.weight(1f)) {
                                OutlinedButton(
                                    onClick = { timeLimitDropdownExpanded = true },
                                    modifier = Modifier.fillMaxWidth(),
                                    shape = RoundedCornerShape(12.dp),
                                    colors = ButtonDefaults.outlinedButtonColors(contentColor = PrimaryPurple),
                                    border = BorderStroke(1.dp, Color(0xFFE8E2EC))
                                ) {
                                    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                                        Text(text = if (timeLimitMinutes == 0) "Unlimited" else "$timeLimitMinutes Mins")
                                        Icon(Icons.Filled.ArrowDropDown, null)
                                    }
                                }
                                DropdownMenu(
                                    expanded = timeLimitDropdownExpanded,
                                    onDismissRequest = { timeLimitDropdownExpanded = false }
                                ) {
                                    listOf(15, 30, 45, 60, 90, 120, 0).forEach { mins ->
                                        DropdownMenuItem(
                                            text = { Text(if (mins == 0) "Unlimited" else "$mins Minutes") },
                                            onClick = {
                                                onTimeLimitSecondsChange(mins * 60)
                                                timeLimitDropdownExpanded = false
                                            }
                                        )
                                    }
                                }
                            }

                            var customTimeText by remember(timeLimitMinutes) {
                                mutableStateOf(if (timeLimitMinutes > 0 && timeLimitMinutes !in listOf(15, 30, 45, 60, 90, 120)) timeLimitMinutes.toString() else "")
                            }

                            OutlinedTextField(
                                value = customTimeText,
                                onValueChange = { text ->
                                    val clean = text.filter { it.isDigit() }
                                    customTimeText = clean
                                    val num = clean.toIntOrNull() ?: 0
                                    if (clean.isNotEmpty()) {
                                        onTimeLimitSecondsChange(num * 60)
                                    } else {
                                        onTimeLimitSecondsChange(0)
                                    }
                                },
                                label = { Text("Manual Mins") },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = PrimaryPurple,
                                    focusedLabelColor = PrimaryPurple
                                ),
                                modifier = Modifier.weight(1f),
                                singleLine = true
                            )
                        }
                    }

                    HorizontalDivider(color = Color(0xFFEBE3FA))

                    // Option 4: Shuffle Questions Switch
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = TranslationManager.getString("shuffle_questions"),
                                color = TextPrimaryDeep,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = TranslationManager.getString("shuffle_questions_desc"),
                                color = TextSecondaryGray,
                                fontSize = 12.sp
                            )
                        }
                        Switch(
                            checked = shuffleQuestions,
                            onCheckedChange = onShuffleQuestionsToggle,
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                checkedTrackColor = PrimaryPurple,
                                uncheckedThumbColor = TextSecondaryGray,
                                uncheckedTrackColor = Color(0xFFEBE3FA)
                            )
                        )
                    }

                    HorizontalDivider(color = Color(0xFFEBE3FA))

                    // Option 5: Show Explanations Switch
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = TranslationManager.getString("show_explanations"),
                                color = TextPrimaryDeep,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = TranslationManager.getString("show_explanations_desc"),
                                color = TextSecondaryGray,
                                fontSize = 12.sp
                            )
                        }
                        Switch(
                            checked = showExplanations,
                            onCheckedChange = onShowExplanationsToggle,
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                checkedTrackColor = PrimaryPurple,
                                uncheckedThumbColor = TextSecondaryGray,
                                uncheckedTrackColor = Color(0xFFEBE3FA)
                            )
                        )
                    }
                }
            }

            // Section 3: Feedback Settings
            Text(
                text = TranslationManager.getString("haptic_accessibility"),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryPurple
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = CardBackgroundLight),
                border = BorderStroke(1.dp, Color(0xFFE8E2EC)),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = TranslationManager.getString("vibration_enabled"),
                            color = TextPrimaryDeep,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = TranslationManager.getString("vibration_desc"),
                            color = TextSecondaryGray,
                            fontSize = 12.sp
                        )
                    }
                    Switch(
                        checked = vibrationEnabled,
                        onCheckedChange = onVibrationToggle,
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.White,
                            checkedTrackColor = PrimaryPurple,
                            uncheckedThumbColor = TextSecondaryGray,
                            uncheckedTrackColor = Color(0xFFEBE3FA)
                        )
                    )
                }
            }

            // App Language Settings Section
            Text(
                text = TranslationManager.getString("app_language"),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryPurple
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = CardBackgroundLight),
                border = BorderStroke(1.dp, Color(0xFFE8E2EC)),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = TranslationManager.getString("select_language"),
                        color = TextPrimaryDeep,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = TranslationManager.getString("select_language_desc"),
                        color = TextSecondaryGray,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    var expanded by remember { mutableStateOf(false) }

                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = { expanded = !expanded }
                    ) {
                        OutlinedTextField(
                            value = currentLanguage.displayName,
                            onValueChange = {},
                            readOnly = true,
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                            modifier = Modifier
                                .menuAnchor()
                                .fillMaxWidth(),
                            colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
                                focusedBorderColor = PrimaryPurple,
                                unfocusedBorderColor = Color(0xFFE8E2EC),
                                focusedLabelColor = PrimaryPurple,
                                cursorColor = PrimaryPurple
                            )
                        )

                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            AppLanguage.values().forEach { language ->
                                DropdownMenuItem(
                                    text = { Text(text = language.displayName) },
                                    onClick = {
                                        onLanguageChange(language)
                                        expanded = false
                                    },
                                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                                )
                            }
                        }
                    }
                }
            }

            // Section 4: Local Database & Cache
            Text(
                text = TranslationManager.getString("data_cache_management"),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryPurple
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = CardBackgroundLight),
                border = BorderStroke(1.dp, Color(0xFFE8E2EC)),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(TranslationManager.getString("cached_decks"), color = TextSecondaryGray, fontWeight = FontWeight.Medium)
                        Text("$deckCount", color = TextPrimaryDeep, fontWeight = FontWeight.Bold)
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(TranslationManager.getString("cached_cards"), color = TextSecondaryGray, fontWeight = FontWeight.Medium)
                        Text("$cardCount", color = TextPrimaryDeep, fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Button(
                            onClick = onSyncNow,
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryPurple)
                        ) {
                            Icon(Icons.Default.Refresh, contentDescription = "Sync", tint = Color.White)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(TranslationManager.getString("sync_now"), color = Color.White, fontWeight = FontWeight.Bold)
                        }

                        Button(
                            onClick = onClearCache,
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC62828))
                        ) {
                            Icon(Icons.Default.Delete, contentDescription = "Clear Cache", tint = Color.White)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(TranslationManager.getString("clear"), color = Color.White, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            // Feature Request Section
            Text(
                text = TranslationManager.getString("support_feedback"),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryPurple
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = CardBackgroundLight),
                border = BorderStroke(1.dp, Color(0xFFE8E2EC)),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Column {
                        Text(
                            text = TranslationManager.getString("feature_request"),
                            color = TextPrimaryDeep,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = TranslationManager.getString("feature_request_desc"),
                            color = TextSecondaryGray,
                            fontSize = 12.sp
                        )
                    }

                    val context = androidx.compose.ui.platform.LocalContext.current
                    Button(
                        onClick = {
                            val intent = android.content.Intent(android.content.Intent.ACTION_SENDTO).apply {
                                data = android.net.Uri.parse("mailto:")
                                putExtra(android.content.Intent.EXTRA_EMAIL, arrayOf("iamnobodybaba@gmail.com"))
                                putExtra(android.content.Intent.EXTRA_SUBJECT, "AnkiPrep Feature Request")
                                putExtra(android.content.Intent.EXTRA_TEXT, "Hello AnkiPrep team,\n\nI would like to request the following feature:\n\n")
                            }
                            try {
                                context.startActivity(intent)
                            } catch (e: Exception) {
                                android.widget.Toast.makeText(context, "No email client found", android.widget.Toast.LENGTH_SHORT).show()
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryPurple)
                    ) {
                        Text(TranslationManager.getString("send_feature_request"), color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }
            }
            Text(
                text = "Made with ❤️ in India by Vijay Prakash",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = TextSecondaryGray,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun <T> SegmentedSelector(
    options: List<T>,
    selectedOption: T,
    onOptionSelected: (T) -> Unit,
    labelProvider: (T) -> String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF3EDF7), RoundedCornerShape(14.dp))
            .padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        options.forEach { option ->
            val isSelected = option == selectedOption
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(
                        if (isSelected) PrimaryPurple else Color.Transparent,
                        RoundedCornerShape(10.dp)
                    )
                    .clickable { onOptionSelected(option) }
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = labelProvider(option),
                    color = if (isSelected) Color.White else TextPrimaryDeep,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun StudyModeOption(
    title: String,
    description: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = isSelected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = PrimaryPurple,
                unselectedColor = TextSecondaryGray
            )
        )
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimaryDeep
            )
            Text(
                text = description,
                fontSize = 12.sp,
                color = TextSecondaryGray,
                lineHeight = 16.sp
            )
        }
    }
}
