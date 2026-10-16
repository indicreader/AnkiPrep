package com.example.flashcardapp.ui.settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.flashcardapp.data.SettingsRepository

@Composable
fun WhiteboardCategoryScreen(
    onNavigateToSubCategory: (SettingsSubCategory) -> Unit
) {
    val context = LocalContext.current
    val repository = remember { SettingsRepository.getInstance(context) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        SettingSubheadingCard(
            subCategory = SettingsSubCategory.STYLUS_ENGINE,
            badgeText = if (repository.whiteboardAutoStylusMode) "Auto Stylus" else "Standard",
            onClick = { onNavigateToSubCategory(SettingsSubCategory.STYLUS_ENGINE) }
        )

        SettingSubheadingCard(
            subCategory = SettingsSubCategory.GESTURES_TOUCH,
            badgeText = repository.whiteboardToolbarPosition,
            onClick = { onNavigateToSubCategory(SettingsSubCategory.GESTURES_TOUCH) }
        )
    }
}

@Composable
fun WhiteboardSubCategoryScreen(
    subCategory: SettingsSubCategory
) {
    val context = LocalContext.current
    val repository = remember { SettingsRepository.getInstance(context) }

    when (subCategory) {
        SettingsSubCategory.STYLUS_ENGINE -> {
            var autoStylusMode by remember { mutableStateOf(repository.whiteboardAutoStylusMode) }
            var highlighterAlpha by remember { mutableStateOf(repository.whiteboardHighlighterAlpha) }
            var defaultPenColor by remember { mutableStateOf(repository.whiteboardDefaultPenColor) }

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
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "Stylus & Inking Physics",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        SettingToggleItem(
                            title = "Auto-Stylus Detection",
                            description = "Dedicated stylus draws strokes while fingers pan & scroll without smudge",
                            checked = autoStylusMode,
                            onCheckedChange = {
                                autoStylusMode = it
                                repository.whiteboardAutoStylusMode = it
                            },
                            icon = Icons.Outlined.Edit
                        )

                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f))

                        SettingSliderItem(
                            title = "Highlighter Transparency",
                            description = "Alpha level for transparent text highlighting over question cards",
                            value = highlighterAlpha,
                            onValueChange = {
                                highlighterAlpha = it
                                repository.whiteboardHighlighterAlpha = it
                            },
                            valueRange = 0.15f..0.85f,
                            steps = 14,
                            valueLabel = "${(highlighterAlpha * 100).toInt()}%",
                            icon = Icons.Outlined.Highlight
                        )

                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f))

                        Text(
                            text = "Default Pen Color",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        SegmentedSelector(
                            options = listOf("DEFAULT", "RED", "BLUE", "GREEN", "YELLOW"),
                            selectedOption = defaultPenColor,
                            onOptionSelected = {
                                defaultPenColor = it
                                repository.whiteboardDefaultPenColor = it
                            },
                            labelProvider = { it.capitalize() }
                        )
                    }
                }
            }
        }

        SettingsSubCategory.GESTURES_TOUCH -> {
            var toolbarPosition by remember { mutableStateOf(repository.whiteboardToolbarPosition) }
            var twoFingerSingleTap by remember { mutableStateOf(repository.whiteboardTwoFingerSingleTapAction) }
            var twoFingerDoubleTap by remember { mutableStateOf(repository.whiteboardTwoFingerDoubleTapAction) }
            var threeFingerSingleTap by remember { mutableStateOf(repository.whiteboardThreeFingerSingleTapAction) }

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
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "Canvas Automation",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        var autoClearOnNext by remember { mutableStateOf(repository.whiteboardAutoClearOnNext) }
                        SettingToggleItem(
                            title = "Auto-Clear On Next Question",
                            description = "Automatically erase whiteboard drawings when advancing to the next card",
                            checked = autoClearOnNext,
                            onCheckedChange = {
                                autoClearOnNext = it
                                repository.whiteboardAutoClearOnNext = it
                            },
                            icon = Icons.Outlined.AutoFixHigh
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
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "Toolbar Docking",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Dock the floating scratchpad toolbar to your preferred screen edge:",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        SegmentedSelector(
                            options = listOf("TOP", "BOTTOM", "LEFT", "RIGHT"),
                            selectedOption = toolbarPosition,
                            onOptionSelected = {
                                toolbarPosition = it
                                repository.whiteboardToolbarPosition = it
                            },
                            labelProvider = { it.capitalize() }
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
                            text = "Multi-Touch Gestures",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Column {
                            Text("Two-Finger Single Tap", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Medium)
                            Spacer(Modifier.height(4.dp))
                            SegmentedSelector(
                                options = listOf("CLEAR", "UNDO", "TOGGLE", "NONE"),
                                selectedOption = twoFingerSingleTap,
                                onOptionSelected = {
                                    twoFingerSingleTap = it
                                    repository.whiteboardTwoFingerSingleTapAction = it
                                },
                                labelProvider = { it.capitalize() }
                            )
                        }

                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f))

                        Column {
                            Text("Two-Finger Double Tap", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Medium)
                            Spacer(Modifier.height(4.dp))
                            SegmentedSelector(
                                options = listOf("CLEAR", "UNDO", "TOGGLE", "NONE"),
                                selectedOption = twoFingerDoubleTap,
                                onOptionSelected = {
                                    twoFingerDoubleTap = it
                                    repository.whiteboardTwoFingerDoubleTapAction = it
                                },
                                labelProvider = { it.capitalize() }
                            )
                        }

                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f))

                        Column {
                            Text("Three-Finger Single Tap", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Medium)
                            Spacer(Modifier.height(4.dp))
                            SegmentedSelector(
                                options = listOf("TOGGLE", "CLEAR", "UNDO", "NONE"),
                                selectedOption = threeFingerSingleTap,
                                onOptionSelected = {
                                    threeFingerSingleTap = it
                                    repository.whiteboardThreeFingerSingleTapAction = it
                                },
                                labelProvider = { it.capitalize() }
                            )
                        }
                    }
                }
            }
        }

        else -> {}
    }
}
