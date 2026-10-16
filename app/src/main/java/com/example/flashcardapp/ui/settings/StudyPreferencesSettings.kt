package com.example.flashcardapp.ui.settings

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.data.SettingsRepository
import com.example.flashcardapp.data.TranslationManager
import com.example.flashcardapp.session.McqSessionMode

@Composable
fun StudyPreferencesCategoryScreen(
    onNavigateToSubCategory: (SettingsSubCategory) -> Unit,
    currentMode: McqSessionMode,
    questionLimit: Int,
    timeLimitSeconds: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        SettingSubheadingCard(
            subCategory = SettingsSubCategory.SESSION_RULES,
            badgeText = currentMode.name.capitalize(),
            onClick = { onNavigateToSubCategory(SettingsSubCategory.SESSION_RULES) }
        )

        val timeText = if (timeLimitSeconds == 0) "Unlimited" else "${timeLimitSeconds / 60}m"
        val qText = if (questionLimit == 0) "All" else "${questionLimit} Qs"
        SettingSubheadingCard(
            subCategory = SettingsSubCategory.SCORING_TIMERS,
            badgeText = "$qText • $timeText",
            onClick = { onNavigateToSubCategory(SettingsSubCategory.SCORING_TIMERS) }
        )

        SettingSubheadingCard(
            subCategory = SettingsSubCategory.ALGORITHM_SCHEDULING,
            badgeText = "FSRS-4.5",
            onClick = { onNavigateToSubCategory(SettingsSubCategory.ALGORITHM_SCHEDULING) }
        )
    }
}

@Composable
fun StudyPreferencesSubCategoryScreen(
    subCategory: SettingsSubCategory,
    currentMode: McqSessionMode,
    onModeChange: (McqSessionMode) -> Unit,
    numberOfOptions: Int,
    onNumberOfOptionsChange: (Int) -> Unit,
    questionLimit: Int,
    onQuestionLimitChange: (Int) -> Unit,
    shuffleQuestions: Boolean,
    onShuffleQuestionsToggle: (Boolean) -> Unit,
    showExplanations: Boolean,
    onShowExplanationsToggle: (Boolean) -> Unit,
    timeLimitSeconds: Int,
    onTimeLimitSecondsChange: (Int) -> Unit
) {
    val context = LocalContext.current
    val repository = remember { SettingsRepository.getInstance(context) }

    when (subCategory) {
        SettingsSubCategory.SESSION_RULES -> {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Text(
                            text = TranslationManager.getString("study_mode"),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        StudyModeCard(
                            title = TranslationManager.getString("practice_mode"),
                            description = TranslationManager.getString("practice_mode_desc"),
                            isSelected = currentMode == McqSessionMode.PRACTICE,
                            onClick = { onModeChange(McqSessionMode.PRACTICE) }
                        )

                        StudyModeCard(
                            title = TranslationManager.getString("test_mode"),
                            description = TranslationManager.getString("test_mode_desc"),
                            isSelected = currentMode == McqSessionMode.TEST,
                            onClick = { onModeChange(McqSessionMode.TEST) }
                        )

                        StudyModeCard(
                            title = TranslationManager.getString("revision_mode"),
                            description = TranslationManager.getString("revision_mode_desc"),
                            isSelected = currentMode == McqSessionMode.REVISION,
                            onClick = { onModeChange(McqSessionMode.REVISION) }
                        )
                    }
                }

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Text(
                            text = TranslationManager.getString("options_count"),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = TranslationManager.getString("options_count_desc"),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        SegmentedSelector(
                            options = listOf(2, 3, 4, 5),
                            selectedOption = numberOfOptions,
                            onOptionSelected = onNumberOfOptionsChange,
                            labelProvider = { TranslationManager.getString("options_format").format(it) }
                        )

                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f))

                        SettingToggleItem(
                            title = TranslationManager.getString("shuffle_questions"),
                            description = TranslationManager.getString("shuffle_questions_desc"),
                            checked = shuffleQuestions,
                            onCheckedChange = onShuffleQuestionsToggle,
                            icon = Icons.Outlined.Shuffle
                        )

                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f))

                        var keepScreenAwake by remember { mutableStateOf(repository.keepScreenAwakeDuringQuiz) }
                        SettingToggleItem(
                            title = "Keep Screen Awake",
                            description = "Prevents display from sleeping during active quiz and practice sessions",
                            checked = keepScreenAwake,
                            onCheckedChange = {
                                keepScreenAwake = it
                                repository.keepScreenAwakeDuringQuiz = it
                            },
                            icon = Icons.Outlined.ScreenLockPortrait
                        )
                    }
                }
            }
        }

        SettingsSubCategory.SCORING_TIMERS -> {
            var questionLimitDropdownExpanded by remember { mutableStateOf(false) }
            var timeLimitDropdownExpanded by remember { mutableStateOf(false) }
            val timeLimitMinutes = timeLimitSeconds / 60

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Text(
                            text = TranslationManager.getString("question_limit"),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = TranslationManager.getString("question_limit_desc"),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
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
                                    shape = RoundedCornerShape(12.dp)
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
                                modifier = Modifier.weight(1f),
                                singleLine = true,
                                shape = RoundedCornerShape(12.dp)
                            )
                        }

                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f))

                        Text(
                            text = TranslationManager.getString("time_limit"),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = TranslationManager.getString("time_limit_desc"),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
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
                                    shape = RoundedCornerShape(12.dp)
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
                                modifier = Modifier.weight(1f),
                                singleLine = true,
                                shape = RoundedCornerShape(12.dp)
                            )
                        }

                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f))

                        SettingToggleItem(
                            title = TranslationManager.getString("show_explanations"),
                            description = TranslationManager.getString("show_explanations_desc"),
                            checked = showExplanations,
                            onCheckedChange = onShowExplanationsToggle,
                            icon = Icons.Outlined.Lightbulb
                        )
                    }
                }
            }
        }

        SettingsSubCategory.ALGORITHM_SCHEDULING -> {
            var algorithm by remember { mutableStateOf(repository.defaultAlgorithm) }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Text(
                            text = "Spaced Repetition Engine",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Select the scheduling math used to calculate your revision intervals.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        StudyModeCard(
                            title = "FSRS-4.5 (Recommended)",
                            description = "Free Spaced Repetition Scheduler based on machine-learned forgetting curves. 30% fewer reviews with equal retention.",
                            isSelected = algorithm == "FSRS",
                            onClick = {
                                algorithm = "FSRS"
                                repository.defaultAlgorithm = "FSRS"
                            }
                        )

                        StudyModeCard(
                            title = "Anki SM-2 (Classic)",
                            description = "Traditional SuperMemo-2 algorithm based on ease factors (130%-250%) and standard interval multipliers.",
                            isSelected = algorithm == "SM-2",
                            onClick = {
                                algorithm = "SM-2"
                                repository.defaultAlgorithm = "SM-2"
                            }
                        )
                    }
                }
            }
        }

        else -> {}
    }
}

@Composable
private fun StudyModeCard(
    title: String,
    description: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        color = if (isSelected) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
        border = BorderStroke(
            1.5.dp,
            if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            if (isSelected) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}
