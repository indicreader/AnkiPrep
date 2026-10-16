package com.example.flashcardapp.ui.settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.flashcardapp.data.AppLanguage
import com.example.flashcardapp.data.TranslationManager

@Composable
fun LanguageCategoryScreen(
    onNavigateToSubCategory: (SettingsSubCategory) -> Unit,
    currentLanguage: AppLanguage,
    vibrationEnabled: Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        SettingSubheadingCard(
            subCategory = SettingsSubCategory.APP_LANGUAGE,
            badgeText = currentLanguage.displayName,
            onClick = { onNavigateToSubCategory(SettingsSubCategory.APP_LANGUAGE) }
        )

        SettingSubheadingCard(
            subCategory = SettingsSubCategory.HAPTICS_FEEDBACK,
            badgeText = if (vibrationEnabled) "Enabled" else "Muted",
            onClick = { onNavigateToSubCategory(SettingsSubCategory.HAPTICS_FEEDBACK) }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageSubCategoryScreen(
    subCategory: SettingsSubCategory,
    currentLanguage: AppLanguage,
    onLanguageChange: (AppLanguage) -> Unit,
    vibrationEnabled: Boolean,
    onVibrationToggle: (Boolean) -> Unit
) {
    when (subCategory) {
        SettingsSubCategory.APP_LANGUAGE -> {
            var expanded by remember { mutableStateOf(false) }

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
                            text = TranslationManager.getString("language_of_app"),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = TranslationManager.getString("language_of_app_desc"),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

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
                                shape = RoundedCornerShape(12.dp)
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
            }
        }

        SettingsSubCategory.HAPTICS_FEEDBACK -> {
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
                        SettingToggleItem(
                            title = TranslationManager.getString("vibration_enabled"),
                            description = TranslationManager.getString("vibration_desc"),
                            checked = vibrationEnabled,
                            onCheckedChange = onVibrationToggle,
                            icon = Icons.Outlined.Vibration
                        )
                    }
                }
            }
        }

        else -> {}
    }
}
