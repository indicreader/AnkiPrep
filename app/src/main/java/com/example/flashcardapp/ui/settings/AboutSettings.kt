package com.example.flashcardapp.ui.settings

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.data.SettingsRepository

/**
 * Level 1 Screen for About & Legal category.
 */
@Composable
fun AboutCategoryScreen(
    onNavigateToSubCategory: (SettingsSubCategory) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        SettingSubheadingCard(
            subCategory = SettingsSubCategory.ABOUT_US,
            badgeText = "v5.8",
            onClick = { onNavigateToSubCategory(SettingsSubCategory.ABOUT_US) }
        )

        SettingSubheadingCard(
            subCategory = SettingsSubCategory.PRIVACY_POLICY,
            badgeText = "Offline",
            onClick = { onNavigateToSubCategory(SettingsSubCategory.PRIVACY_POLICY) }
        )

        SettingSubheadingCard(
            subCategory = SettingsSubCategory.LICENSE_POLICY,
            badgeText = "GPL v3",
            onClick = { onNavigateToSubCategory(SettingsSubCategory.LICENSE_POLICY) }
        )
    }
}

/**
 * Level 2 Sub-page routing for About & Legal items.
 */
@Composable
fun AboutSubCategoryScreen(
    subCategory: SettingsSubCategory
) {
    when (subCategory) {
        SettingsSubCategory.ABOUT_US -> AboutUsScreen()
        SettingsSubCategory.PRIVACY_POLICY -> PrivacyPolicyScreen()
        SettingsSubCategory.LICENSE_POLICY -> LicensePolicyScreen()
        else -> AboutUsScreen()
    }
}

/**
 * Detailed About Us screen with Developer attribution, 7-tap Easter egg,
 * and hidden developer password unlock for Premium features.
 */
@Composable
fun AboutUsScreen() {
    val context = LocalContext.current
    val repository = remember { SettingsRepository.getInstance(context) }
    var isPremium by remember { mutableStateOf(repository.isPremium) }

    var tapCount by remember { mutableStateOf(0) }
    var lastTapTime by remember { mutableStateOf(0L) }
    var showPasswordDialog by remember { mutableStateOf(false) }
    var enteredPassword by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        // App Identity Header
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(68.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.School,
                        contentDescription = "AnkiPrep Logo",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(36.dp)
                    )
                }

                Text(
                    text = "AnkiPrep",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = "Version 5.8 (Build 172)",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = "High-Density Offline Active Recall Flashcard & MCQ Engine",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }
        }

        // Mission & Purpose
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(
                modifier = Modifier.padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "MISSION",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.2.sp,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "AnkiPrep is engineered specifically for competitive exam aspirants (UPSC, SSC, State PSC, Banking) who need rapid information retrieval, deep-space focus, and adaptive spaced repetition (FSRS-4.5) without distractions, trackers, or cloud dependencies.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    lineHeight = 22.sp
                )
            }
        }

        // Premium Status Indicator (if unlocked)
        AnimatedVisibility(visible = isPremium) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f))
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.WorkspacePremium,
                        contentDescription = "Premium Unlocked",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(28.dp)
                    )
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Premium Unlocked",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        Text(
                            text = "All features, unlimited imports, and ad-free experience active.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.85f)
                        )
                    }
                    TextButton(
                        onClick = {
                            repository.isPremium = false
                            isPremium = false
                            Toast.makeText(context, "Premium status reset", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Text("Reset", color = MaterialTheme.colorScheme.error)
                    }
                }
            }
        }

        // Developer Attribution with 7-Tap Easter Egg
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .clickable {
                    val now = System.currentTimeMillis()
                    if (now - lastTapTime > 1500L) {
                        tapCount = 1
                    } else {
                        tapCount += 1
                    }
                    lastTapTime = now

                    if (tapCount in 3..6) {
                        val remaining = 7 - tapCount
                        Toast.makeText(context, "You are $remaining steps away from developer options", Toast.LENGTH_SHORT).show()
                    } else if (tapCount >= 7) {
                        tapCount = 0
                        showPasswordDialog = true
                    }
                },
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = "made with ❤️ by vijay prakash",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Tap to view developer credentials",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }

    // Hidden Developer Password Dialog
    if (showPasswordDialog) {
        AlertDialog(
            onDismissRequest = {
                showPasswordDialog = false
                enteredPassword = ""
                errorMessage = null
            },
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Key,
                        contentDescription = "Hidden Settings",
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Hidden Settings",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text(
                        text = "Enter master password to unlock all premium features and developer modes.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    OutlinedTextField(
                        value = enteredPassword,
                        onValueChange = {
                            enteredPassword = it
                            errorMessage = null
                        },
                        label = { Text("Password") },
                        singleLine = true,
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                if (verifyPassword(enteredPassword)) {
                                    repository.isPremium = true
                                    isPremium = true
                                    showPasswordDialog = false
                                    Toast.makeText(context, "🎉 All Premium Features Unlocked!", Toast.LENGTH_LONG).show()
                                } else {
                                    errorMessage = "Invalid password. Access denied."
                                }
                            }
                        ),
                        isError = errorMessage != null,
                        modifier = Modifier.fillMaxWidth()
                    )

                    errorMessage?.let { err ->
                        Text(
                            text = err,
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        if (verifyPassword(enteredPassword)) {
                            repository.isPremium = true
                            isPremium = true
                            showPasswordDialog = false
                            Toast.makeText(context, "🎉 All Premium Features Unlocked!", Toast.LENGTH_LONG).show()
                        } else {
                            errorMessage = "Invalid password. Access denied."
                        }
                    }
                ) {
                    Text("Unlock")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showPasswordDialog = false
                        enteredPassword = ""
                        errorMessage = null
                    }
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}

/**
 * Accepts "vijay", "ankiprep", or "premium" as valid developer unlock passwords.
 */
private fun verifyPassword(input: String): Boolean {
    val clean = input.trim().lowercase()
    return clean == "vijay" || clean == "ankiprep" || clean == "premium" || clean == "vijayprakash" || clean == "12345"
}

/**
 * Full Offline Privacy Policy screen.
 */
@Composable
fun PrivacyPolicyScreen() {
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
                modifier = Modifier.padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Shield,
                        contentDescription = "Privacy",
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Privacy Policy — AnkiPrep",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }

                Divider(color = MaterialTheme.colorScheme.outlineVariant)

                Text(
                    text = "1. Zero Cloud Data Collection\n" +
                            "AnkiPrep is strictly an offline-first mobile application. We do not operate user accounts, cloud sync databases, or proprietary tracking servers. All your decks, custom notes, quiz attempts, and streak records are stored exclusively in the local Room/SQLite database on your device.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    lineHeight = 22.sp
                )

                Text(
                    text = "2. Device Storage & Local Files\n" +
                            "When you import `.csv`, `.json`, `.apkg`, `.epub`, or `.pdf` study materials, Android's Storage Access Framework (SAF) is used solely to read the selected file stream into your local storage. No imported files are ever uploaded or transmitted externally.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    lineHeight = 22.sp
                )

                Text(
                    text = "3. Google AdMob & Advertisements\n" +
                            "When ads are enabled, Google AdMob may process non-sensitive device identifiers according to Google's standard advertising policies. Premium users have all advertisements disabled completely.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    lineHeight = 22.sp
                )

                Text(
                    text = "4. Inquiries & Contact\n" +
                            "For any privacy queries, contact the maintainer at: contactus.ankiprep@gmail.com",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

/**
 * Full License and Terms screen.
 */
@Composable
fun LicensePolicyScreen() {
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
                modifier = Modifier.padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Gavel,
                        contentDescription = "License",
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "GNU General Public License v3.0",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }

                Divider(color = MaterialTheme.colorScheme.outlineVariant)

                Text(
                    text = "AnkiPrep is free and open-source software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    lineHeight = 22.sp
                )

                Text(
                    text = "This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 22.sp
                )

                Text(
                    text = "Copyright © 2026 Vijay Prakash. All rights reserved.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}
