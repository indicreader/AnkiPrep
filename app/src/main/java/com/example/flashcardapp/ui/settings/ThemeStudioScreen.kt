package com.example.flashcardapp.ui.settings

import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Palette
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
import com.example.flashcardapp.ui.theme.ExamThemeManager
import com.example.flashcardapp.ui.theme.ExamThemeTokens
import com.example.flashcardapp.ui.theme.LocalExamThemeTokens

/**
 * Interactive Theme Studio Screen:
 * 1. Live preview card simulating an authentic exam question & answer palette.
 * 2. Official Exam Simulation presets (TCS iON, NTA Console, Tactical Dark, Cyber Mint).
 * 3. Color swatch customizer to tweak and persist custom user themes.
 */
@Composable
fun ThemeStudioScreen() {
    val context = LocalContext.current
    var activeTokens by remember { mutableStateOf(ExamThemeManager.currentTokens) }
    var customThemes by remember { mutableStateOf(ExamThemeManager.getCustomThemes(context)) }

    var isCreatingCustom by remember { mutableStateOf(false) }
    var customName by remember { mutableStateOf("My Custom Theme") }

    // Color customization draft
    var draftAnswered by remember(activeTokens) { mutableStateOf(activeTokens.colorAnswered) }
    var draftNotAnswered by remember(activeTokens) { mutableStateOf(activeTokens.colorNotAnswered) }
    var draftMarked by remember(activeTokens) { mutableStateOf(activeTokens.colorMarkedForReview) }
    var draftNotVisited by remember(activeTokens) { mutableStateOf(activeTokens.colorNotVisited) }
    var draftSurface by remember(activeTokens) { mutableStateOf(activeTokens.surfaceColor) }
    var draftRadius by remember(activeTokens) { mutableIntStateOf(activeTokens.buttonCornerRadiusDp) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // ── 1. Live Interactive Exam Preview Card ──
        item {
            Text(
                text = "Live Exam Simulation Preview",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(Modifier.height(8.dp))

            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color(activeTokens.windowBackground),
                border = BorderStroke(1.dp, Color(activeTokens.borderColor)),
                shadowElevation = 3.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    // Header Bar
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = activeTokens.displayName,
                            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                            color = Color(activeTokens.primaryText)
                        )
                        Surface(
                            shape = RoundedCornerShape(activeTokens.buttonCornerRadiusDp.dp),
                            color = Color(activeTokens.colorAnswered),
                            modifier = Modifier.padding(2.dp)
                        ) {
                            Text(
                                text = "Answered",
                                color = Color.White,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }

                    Spacer(Modifier.height(12.dp))

                    // Question Card Sample
                    Surface(
                        shape = RoundedCornerShape(activeTokens.buttonCornerRadiusDp.dp),
                        color = Color(activeTokens.surfaceColor),
                        border = BorderStroke(1.dp, Color(activeTokens.borderColor).copy(alpha = 0.5f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(
                                text = "Q.1) What is the value of 2^31 mod 5 in quantitative aptitude?",
                                color = Color(activeTokens.primaryText),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(Modifier.height(6.dp))
                            Text(
                                text = "Section: Quantitative Aptitude | Positive: +2.0",
                                color = Color(activeTokens.secondaryText),
                                fontSize = 11.sp
                            )
                        }
                    }

                    Spacer(Modifier.height(14.dp))

                    // Question Palette Buttons Sample
                    Text(
                        text = "Question Palette State Grid:",
                        color = Color(activeTokens.secondaryText),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(Modifier.height(6.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        PaletteSampleItem(number = "1", bg = Color(activeTokens.colorAnswered), radius = activeTokens.buttonCornerRadiusDp)
                        PaletteSampleItem(number = "2", bg = Color(activeTokens.colorNotAnswered), radius = activeTokens.buttonCornerRadiusDp)
                        PaletteSampleItem(number = "3", bg = Color(activeTokens.colorMarkedForReview), radius = activeTokens.buttonCornerRadiusDp)
                        PaletteSampleItem(number = "4", bg = Color(activeTokens.colorAnsweredAndReview), radius = activeTokens.buttonCornerRadiusDp)
                        PaletteSampleItem(number = "5", bg = Color(activeTokens.colorNotVisited), radius = activeTokens.buttonCornerRadiusDp)
                    }
                }
            }
        }

        // ── 2. Official Simulation Presets ──
        item {
            Text(
                text = "Official Exam Presets",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(Modifier.height(6.dp))

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                ExamThemeManager.ALL_PRESETS.forEach { preset ->
                    val isSelected = activeTokens.key == preset.key
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                        border = BorderStroke(1.dp, if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                activeTokens = preset
                                ExamThemeManager.selectTheme(context, preset.key)
                                Toast.makeText(context, "Theme set: ${preset.displayName}", Toast.LENGTH_SHORT).show()
                            }
                    ) {
                        Row(
                            modifier = Modifier.padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(
                                    text = preset.displayName,
                                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = if (preset.isDark) "Dark / Contrast Mode" else "Authentic Light Exam Console",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            if (isSelected) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Selected",
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }
                }
            }
        }

        // ── 3. Custom Themes List ──
        if (customThemes.isNotEmpty()) {
            item {
                Text(
                    text = "My Custom Themes",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(Modifier.height(6.dp))

                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    customThemes.forEach { custom ->
                        val isSelected = activeTokens.key == custom.key
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                            border = BorderStroke(1.dp, if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    activeTokens = custom
                                    ExamThemeManager.selectTheme(context, custom.key)
                                }
                        ) {
                            Row(
                                modifier = Modifier.padding(14.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = custom.displayName,
                                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    if (isSelected) {
                                        Icon(
                                            imageVector = Icons.Default.Check,
                                            contentDescription = "Selected",
                                            tint = MaterialTheme.colorScheme.primary,
                                            modifier = Modifier.padding(end = 8.dp)
                                        )
                                    }
                                    IconButton(
                                        onClick = {
                                            ExamThemeManager.deleteCustomTheme(context, custom.key)
                                            customThemes = ExamThemeManager.getCustomThemes(context)
                                            activeTokens = ExamThemeManager.currentTokens
                                        },
                                        modifier = Modifier.size(24.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Delete,
                                            contentDescription = "Delete",
                                            tint = MaterialTheme.colorScheme.error,
                                            modifier = Modifier.size(18.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // ── 4. Create New Custom Theme ──
        item {
            if (!isCreatingCustom) {
                OutlinedButton(
                    onClick = { isCreatingCustom = true },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth().height(48.dp)
                ) {
                    Icon(Icons.Default.Add, contentDescription = null, modifier = Modifier.size(18.dp))
                    Spacer(Modifier.width(8.dp))
                    Text("Build Custom Palette", fontWeight = FontWeight.Bold)
                }
            } else {
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Text(
                            text = "Custom Palette Studio",
                            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.primary
                        )

                        OutlinedTextField(
                            value = customName,
                            onValueChange = { customName = it },
                            label = { Text("Theme Name") },
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true
                        )

                        Text("Corner Radius: ${draftRadius}dp", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Slider(
                            value = draftRadius.toFloat(),
                            onValueChange = { draftRadius = it.toInt() },
                            valueRange = 0f..20f,
                            steps = 19
                        )

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Button(
                                onClick = {
                                    val newKey = "CUSTOM_" + System.currentTimeMillis()
                                    val newTheme = ExamThemeTokens(
                                        key = newKey,
                                        displayName = customName.ifBlank { "Custom Theme" },
                                        isCustom = true,
                                        isDark = activeTokens.isDark,
                                        windowBackground = activeTokens.windowBackground,
                                        surfaceColor = draftSurface,
                                        borderColor = activeTokens.borderColor,
                                        primaryText = activeTokens.primaryText,
                                        secondaryText = activeTokens.secondaryText,
                                        colorAnswered = draftAnswered,
                                        colorNotAnswered = draftNotAnswered,
                                        colorMarkedForReview = draftMarked,
                                        colorAnsweredAndReview = activeTokens.colorAnsweredAndReview,
                                        colorNotVisited = draftNotVisited,
                                        buttonCornerRadiusDp = draftRadius,
                                        buttonElevationDp = activeTokens.buttonElevationDp
                                    )
                                    ExamThemeManager.saveCustomTheme(context, newTheme)
                                    ExamThemeManager.selectTheme(context, newKey)
                                    customThemes = ExamThemeManager.getCustomThemes(context)
                                    activeTokens = newTheme
                                    isCreatingCustom = false
                                    Toast.makeText(context, "Saved & Applied!", Toast.LENGTH_SHORT).show()
                                },
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("Save & Apply")
                            }

                            OutlinedButton(
                                onClick = { isCreatingCustom = false },
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Text("Cancel")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PaletteSampleItem(number: String, bg: Color, radius: Int) {
    Surface(
        shape = RoundedCornerShape(radius.dp),
        color = bg,
        modifier = Modifier.size(34.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = number,
                color = Color.White,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

