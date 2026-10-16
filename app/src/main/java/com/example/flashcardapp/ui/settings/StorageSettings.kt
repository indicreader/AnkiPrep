package com.example.flashcardapp.ui.settings

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcardapp.data.AnkiDeck
import com.example.flashcardapp.data.SettingsRepository
import com.example.flashcardapp.data.TranslationManager

@Composable
fun StorageCategoryScreen(
    onNavigateToSubCategory: (SettingsSubCategory) -> Unit,
    deckCount: Int,
    cardCount: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        SettingSubheadingCard(
            subCategory = SettingsSubCategory.DATABASE_STATS,
            badgeText = "$deckCount Decks • $cardCount Cards",
            onClick = { onNavigateToSubCategory(SettingsSubCategory.DATABASE_STATS) }
        )

        SettingSubheadingCard(
            subCategory = SettingsSubCategory.IMPORT_EXPORT,
            badgeText = "APKG / CSV / EPUB / PDF",
            onClick = { onNavigateToSubCategory(SettingsSubCategory.IMPORT_EXPORT) }
        )

        SettingSubheadingCard(
            subCategory = SettingsSubCategory.CACHE_MANAGEMENT,
            badgeText = "Cleanup & Maintenance",
            onClick = { onNavigateToSubCategory(SettingsSubCategory.CACHE_MANAGEMENT) }
        )
    }
}

@Composable
fun StorageSubCategoryScreen(
    subCategory: SettingsSubCategory,
    deckCount: Int,
    cardCount: Int,
    onSyncNow: () -> Unit,
    onClearCache: () -> Unit,
    decks: List<AnkiDeck>,
    onImportApkgClicked: () -> Unit,
    onImportCsvClicked: () -> Unit,
    onImportEpubClicked: () -> Unit,
    onImportPdfClicked: () -> Unit,
    onExportDeck: (AnkiDeck) -> Unit
) {
    val context = LocalContext.current
    val repository = remember { SettingsRepository.getInstance(context) }

    when (subCategory) {
        SettingsSubCategory.DATABASE_STATS -> {
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
                            text = "Storage Statistics",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(TranslationManager.getString("cached_decks"), style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            Text("$deckCount", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(TranslationManager.getString("cached_cards"), style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            Text("$cardCount", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                        }

                        Spacer(Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Button(
                                onClick = onSyncNow,
                                modifier = Modifier.weight(1f),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(18.dp))
                                Spacer(Modifier.width(6.dp))
                                Text(TranslationManager.getString("sync_now"))
                            }

                            OutlinedButton(
                                onClick = onClearCache,
                                modifier = Modifier.weight(1f),
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.error)
                            ) {
                                Icon(Icons.Default.Delete, contentDescription = null, modifier = Modifier.size(18.dp))
                                Spacer(Modifier.width(6.dp))
                                Text(TranslationManager.getString("clear"))
                            }
                        }
                    }
                }

                // Feature request card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            text = TranslationManager.getString("feature_request"),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = TranslationManager.getString("feature_request_desc"),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Button(
                            onClick = {
                                val intent = Intent(Intent.ACTION_SENDTO).apply {
                                    data = Uri.parse("mailto:")
                                    putExtra(Intent.EXTRA_EMAIL, arrayOf("iamnobodybaba@gmail.com"))
                                    putExtra(Intent.EXTRA_SUBJECT, "AnkiPrep Feedback & Request")
                                    putExtra(Intent.EXTRA_TEXT, "Hello AnkiPrep Team,\n\nI would like to suggest:\n\n")
                                }
                                try {
                                    context.startActivity(intent)
                                } catch (e: Exception) {
                                    Toast.makeText(context, "No email app found", Toast.LENGTH_SHORT).show()
                                }
                            },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(TranslationManager.getString("send_feature_request"))
                        }
                    }
                }
            }
        }

        SettingsSubCategory.IMPORT_EXPORT -> {
            var showExportDialog by remember { mutableStateOf(false) }
            var selectedExportDeck by remember { mutableStateOf<AnkiDeck?>(decks.firstOrNull()) }

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
                            text = "Import Flashcards & Quizzes",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Choose a file format to import questions into existing or new decks:",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        SettingActionItem(
                            title = "Anki Deck Package (.apkg)",
                            description = "Full Anki decks with media and tags",
                            icon = Icons.Outlined.FolderZip,
                            onClick = onImportApkgClicked
                        )

                        SettingActionItem(
                            title = "CSV Quiz Spreadsheet (.csv)",
                            description = "One-liners, 4-option MCQs, pipe delimited rows",
                            icon = Icons.Outlined.TableChart,
                            onClick = onImportCsvClicked
                        )

                        SettingActionItem(
                            title = "Epub E-Book / Text (.epub)",
                            description = "Chapter-based auto-extraction",
                            icon = Icons.Outlined.MenuBook,
                            onClick = onImportEpubClicked
                        )

                        SettingActionItem(
                            title = "Multi-Column PDF Booklet (.pdf)",
                            description = "Segmented 2-column or 3-column question papers",
                            icon = Icons.Outlined.PictureAsPdf,
                            onClick = onImportPdfClicked
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
                            text = "Export Deck (.apkg)",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Package an AnkiPrep deck for sharing with Anki or another device.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Button(
                            onClick = { showExportDialog = true },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(Icons.Outlined.Share, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(Modifier.width(8.dp))
                            Text("Export Anki Deck")
                        }
                    }
                }
            }

            if (showExportDialog) {
                AlertDialog(
                    onDismissRequest = { showExportDialog = false },
                    title = { Text("Export Deck to APKG", fontWeight = FontWeight.Bold) },
                    text = {
                        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                            Text("Select which deck you want to export:")
                            if (decks.isEmpty()) {
                                Text("No decks available.", color = MaterialTheme.colorScheme.error)
                            } else {
                                var expanded by remember { mutableStateOf(false) }
                                Box(modifier = Modifier.fillMaxWidth()) {
                                    OutlinedButton(
                                        onClick = { expanded = true },
                                        modifier = Modifier.fillMaxWidth(),
                                        shape = RoundedCornerShape(8.dp)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.fillMaxWidth()
                                        ) {
                                            Text(selectedExportDeck?.name ?: "Select Deck")
                                            Icon(Icons.Default.ArrowDropDown, null)
                                        }
                                    }
                                    DropdownMenu(
                                        expanded = expanded,
                                        onDismissRequest = { expanded = false },
                                        modifier = Modifier.fillMaxWidth(0.8f)
                                    ) {
                                        decks.forEach { d ->
                                            DropdownMenuItem(
                                                text = { Text(d.name) },
                                                onClick = {
                                                    selectedExportDeck = d
                                                    expanded = false
                                                }
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    },
                    confirmButton = {
                        Button(
                            onClick = {
                                selectedExportDeck?.let {
                                    onExportDeck(it)
                                    showExportDialog = false
                                }
                            },
                            enabled = selectedExportDeck != null && decks.isNotEmpty()
                        ) {
                            Text("Export")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { showExportDialog = false }) {
                            Text("Cancel")
                        }
                    }
                )
            }
        }

        SettingsSubCategory.CACHE_MANAGEMENT -> {
            var deleteImagesOnCardDelete by remember { mutableStateOf(repository.deleteImagesOnCardDelete) }

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
                            text = "Storage & Cleanup Rules",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        SettingToggleItem(
                            title = "Delete Images on Card Delete",
                            description = "Automatically delete associated image files from disk when a flashcard is removed",
                            checked = deleteImagesOnCardDelete,
                            onCheckedChange = {
                                deleteImagesOnCardDelete = it
                                repository.deleteImagesOnCardDelete = it
                            },
                            icon = Icons.Outlined.BrokenImage
                        )

                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f))

                        SettingActionItem(
                            title = "Purge Temporary Web Cache",
                            description = "Clear downloaded temporary HTML scraping artifacts and image preview caches",
                            icon = Icons.Outlined.CleaningServices,
                            onClick = onClearCache,
                            trailingText = "Clear"
                        )
                    }
                }
            }
        }

        else -> {}
    }
}
