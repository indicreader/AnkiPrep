package com.example.flashcardapp.ui.settings

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.data.SettingsRepository
import com.example.flashcardapp.data.TranslationManager
import com.example.flashcardapp.ui.theme.MorphismThemeRegistry
import java.io.File
import java.io.FileOutputStream

@Composable
fun AppearanceCategoryScreen(
    onNavigateToSubCategory: (SettingsSubCategory) -> Unit,
    themePreset: String,
    isDarkMode: Boolean,
    fontFamilyType: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        SettingSubheadingCard(
            subCategory = SettingsSubCategory.THEME_SELECTION,
            badgeText = themePreset.replace("_", " ").capitalize(),
            onClick = { onNavigateToSubCategory(SettingsSubCategory.THEME_SELECTION) }
        )

        SettingSubheadingCard(
            subCategory = SettingsSubCategory.DARK_MODE,
            badgeText = if (isDarkMode) "Dark" else "Light",
            onClick = { onNavigateToSubCategory(SettingsSubCategory.DARK_MODE) }
        )

        SettingSubheadingCard(
            subCategory = SettingsSubCategory.TYPOGRAPHY_FONTS,
            badgeText = fontFamilyType,
            onClick = { onNavigateToSubCategory(SettingsSubCategory.TYPOGRAPHY_FONTS) }
        )
    }
}

@Composable
fun AppearanceSubCategoryScreen(
    subCategory: SettingsSubCategory,
    themePreset: String,
    onThemePresetChange: (String) -> Unit,
    isDarkMode: Boolean,
    onDarkModeToggle: (Boolean) -> Unit,
    useDynamicWallpaper: Boolean,
    onUseDynamicWallpaperToggle: (Boolean) -> Unit,
    fontFamilyType: String,
    onFontFamilyTypeChange: (String) -> Unit
) {
    val context = LocalContext.current
    val repository = remember { SettingsRepository.getInstance(context) }

    when (subCategory) {
        SettingsSubCategory.THEME_SELECTION -> {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
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
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Color Palette & Styling",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)
                            ) {
                                Text(
                                    text = "${MorphismThemeRegistry.ALL_PRESETS.size} Presets",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                )
                            }
                        }

                        Text(
                            text = "Choose from tactile Neumorphism, Glassmorphism, 3D Clay, and Modern Minimalist palettes. Themes update the entire visual design instantly.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(Modifier.height(4.dp))

                        MorphismThemeSelector(
                            selectedPreset = themePreset,
                            onPresetSelected = onThemePresetChange,
                            isDarkMode = isDarkMode
                        )
                    }
                }
            }
        }

        SettingsSubCategory.DARK_MODE -> {
            var useOledBlack by remember { mutableStateOf(repository.useOledBlack) }

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
                        SettingToggleItem(
                            title = "Dark Mode",
                            description = "Switch to high contrast Cyber Space dark palette",
                            checked = isDarkMode,
                            onCheckedChange = onDarkModeToggle,
                            icon = Icons.Outlined.DarkMode
                        )

                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f))

                        SettingToggleItem(
                            title = "OLED Pitch Black",
                            description = "True #000000 background for AMOLED battery savings",
                            checked = useOledBlack,
                            onCheckedChange = {
                                useOledBlack = it
                                repository.useOledBlack = it
                            },
                            enabled = isDarkMode,
                            icon = Icons.Outlined.Brightness2
                        )

                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f))

                        SettingToggleItem(
                            title = TranslationManager.getString("dynamic_wallpaper"),
                            description = TranslationManager.getString("dynamic_wallpaper_desc"),
                            checked = useDynamicWallpaper,
                            onCheckedChange = onUseDynamicWallpaperToggle,
                            icon = Icons.Outlined.Wallpaper
                        )
                    }
                }
            }
        }

        SettingsSubCategory.TYPOGRAPHY_FONTS -> {
            var fontScale by remember { mutableStateOf(repository.fontScaleFactor) }
            val fontsDir = remember { File(context.filesDir, "fonts").apply { mkdirs() } }
            var addedFonts by remember {
                mutableStateOf(
                    fontsDir.listFiles()
                        ?.filter { it.isFile && (it.name.endsWith(".ttf", ignoreCase = true) || it.name.endsWith(".otf", ignoreCase = true)) }
                        ?: emptyList()
                )
            }
            var customFontPath by remember { mutableStateOf(repository.customFontPath) }

            val fontPickerLauncher = rememberLauncherForActivityResult(
                ActivityResultContracts.OpenDocument()
            ) { uri: Uri? ->
                uri?.let {
                    try {
                        val fileName = "custom_font_${System.currentTimeMillis()}.ttf"
                        val destFile = File(fontsDir, fileName)
                        context.contentResolver.openInputStream(it)?.use { input ->
                            FileOutputStream(destFile).use { output ->
                                input.copyTo(output)
                            }
                        }
                        repository.customFontPath = destFile.absolutePath
                        customFontPath = destFile.absolutePath
                        addedFonts = fontsDir.listFiles()?.filter { it.isFile } ?: emptyList()
                        Toast.makeText(context, "Font loaded successfully!", Toast.LENGTH_SHORT).show()
                    } catch (e: Exception) {
                        Toast.makeText(context, "Failed to load font: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }

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
                            text = TranslationManager.getString("font_family"),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = TranslationManager.getString("font_family_desc"),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        SegmentedSelector(
                            options = listOf("DEFAULT", "SERIF", "SAN_SERIF", "MONOSPACE"),
                            selectedOption = fontFamilyType,
                            onOptionSelected = onFontFamilyTypeChange,
                            labelProvider = {
                                when (it) {
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

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        SettingSliderItem(
                            title = "Font Scale Factor",
                            description = "Dynamically scale text size throughout flashcards and quizzes",
                            value = fontScale,
                            onValueChange = {
                                fontScale = it
                                repository.fontScaleFactor = it
                            },
                            valueRange = 0.75f..1.5f,
                            steps = 15,
                            valueLabel = String.format("%.2fx", fontScale),
                            icon = Icons.Outlined.FormatSize
                        )

                        Surface(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                        ) {
                            Text(
                                text = "Preview: The quick brown fox jumps over the lazy dog. 1234567890",
                                fontSize = (14 * fontScale).sp,
                                modifier = Modifier.padding(12.dp),
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
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
                            text = "Custom Font File (TTF / OTF)",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = if (customFontPath != null) "Active font: ${File(customFontPath!!).name}" else "Using default system / Atkinson font",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Button(
                                onClick = { fontPickerLauncher.launch(arrayOf("*/*")) },
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Icon(Icons.Outlined.FileUpload, contentDescription = null, modifier = Modifier.size(18.dp))
                                Spacer(Modifier.width(8.dp))
                                Text("Import TTF/OTF")
                            }

                            if (customFontPath != null) {
                                OutlinedButton(
                                    onClick = {
                                        repository.customFontPath = null
                                        customFontPath = null
                                    },
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    Text("Reset Font")
                                }
                            }
                        }
                    }
                }
            }
        }

        else -> {}
    }
}

@Composable
fun MorphismThemeSelector(
    selectedPreset: String,
    onPresetSelected: (String) -> Unit,
    isDarkMode: Boolean
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        MorphismThemeRegistry.ALL_PRESETS.forEach { preset ->
            val isSelected = preset.id.equals(selectedPreset, ignoreCase = true)
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .clickable { onPresetSelected(preset.id) },
                shape = RoundedCornerShape(12.dp),
                color = if (isSelected) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.25f),
                border = BorderStroke(
                    1.5.dp,
                    if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Palette Preview Swatches
                    Row(
                        horizontalArrangement = Arrangement.spacedBy((-6).dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(CircleShape)
                                .background(preset.previewPrimary)
                        )
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(CircleShape)
                                .background(preset.previewAccent)
                        )
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(CircleShape)
                                .background(preset.previewSurface)
                        )
                    }

                    Column(modifier = Modifier.weight(1f)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = preset.name,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Surface(
                                shape = CircleShape,
                                color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.6f)
                            ) {
                                Text(
                                    text = preset.category.name,
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 1.dp)
                                )
                            }
                        }
                        Text(
                            text = preset.description,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 1
                        )
                    }

                    if (isSelected) {
                        Icon(
                            imageVector = Icons.Outlined.CheckCircle,
                            contentDescription = "Selected",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}

