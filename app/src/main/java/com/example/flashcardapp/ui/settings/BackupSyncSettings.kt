package com.example.flashcardapp.ui.settings

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import androidx.documentfile.provider.DocumentFile
import com.example.flashcardapp.data.SettingsRepository
import com.example.flashcardapp.data.backup.BackupRestoreUtils
import com.example.flashcardapp.data.backup.BackupScheduler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun BackupSyncCategoryScreen(
    onNavigateToSubCategory: (SettingsSubCategory) -> Unit,
    onOpenLocalWifiSync: () -> Unit
) {
    val context = LocalContext.current
    val repository = remember { SettingsRepository.getInstance(context) }
    val backupFolderConfigured = repository.backupSafUri != null

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        SettingSubheadingCard(
            subCategory = SettingsSubCategory.AUTO_BACKUP_SAF,
            badgeText = if (backupFolderConfigured) "Configured" else "Not Set",
            onClick = { onNavigateToSubCategory(SettingsSubCategory.AUTO_BACKUP_SAF) }
        )

        SettingSubheadingCard(
            subCategory = SettingsSubCategory.MANUAL_BACKUP_RESTORE,
            badgeText = "ZIP Snapshot",
            onClick = { onNavigateToSubCategory(SettingsSubCategory.MANUAL_BACKUP_RESTORE) }
        )

        SettingSubheadingCard(
            subCategory = SettingsSubCategory.ANKIDROID_SYNC,
            badgeText = "Local Sync",
            onClick = { onNavigateToSubCategory(SettingsSubCategory.ANKIDROID_SYNC) }
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            SettingActionItem(
                title = "Local Wi-Fi Sync Portal",
                description = "Synchronize cards and decks across devices on the same Wi-Fi network",
                icon = Icons.Outlined.Wifi,
                onClick = onOpenLocalWifiSync,
                trailingText = "Open"
            )
        }
    }
}

@Composable
fun BackupSyncSubCategoryScreen(
    subCategory: SettingsSubCategory,
    onSyncNow: () -> Unit
) {
    val context = LocalContext.current
    val repository = remember { SettingsRepository.getInstance(context) }
    val coroutineScope = rememberCoroutineScope()
    var backupSafUri by remember { mutableStateOf(repository.backupSafUri) }
    var backupInterval by remember { mutableStateOf(repository.backupInterval) }

    val backupDirPickerLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.OpenDocumentTree()
    ) { uri ->
        uri?.let {
            val flags = Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
            context.contentResolver.takePersistableUriPermission(it, flags)
            repository.backupSafUri = it.toString()
            backupSafUri = it.toString()
            BackupScheduler.updateSchedule(context)
            Toast.makeText(context, "Backup folder set successfully!", Toast.LENGTH_SHORT).show()
        }
    }

    val restoreFileLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.OpenDocument()
    ) { uri ->
        uri?.let {
            coroutineScope.launch {
                val success = withContext(Dispatchers.IO) {
                    try {
                        context.contentResolver.openInputStream(it)?.use { input ->
                            BackupRestoreUtils.importBackup(context, input)
                        } ?: false
                    } catch (e: Exception) {
                        false
                    }
                }
                if (success) {
                    Toast.makeText(context, "Database restored! Restarting app...", Toast.LENGTH_LONG).show()
                    kotlinx.coroutines.delay(1500)
                    val intent = context.packageManager.getLaunchIntentForPackage(context.packageName)
                    if (intent != null) {
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        context.startActivity(intent)
                    }
                    android.os.Process.killProcess(android.os.Process.myPid())
                    System.exit(0)
                } else {
                    Toast.makeText(context, "Failed to restore backup snapshot", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    when (subCategory) {
        SettingsSubCategory.AUTO_BACKUP_SAF -> {
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
                            text = "Storage Access Framework (SAF)",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        val folderName = if (backupSafUri != null) {
                            try {
                                Uri.parse(backupSafUri).lastPathSegment ?: "Folder Selected"
                            } catch (e: Exception) {
                                "Folder Selected"
                            }
                        } else "No folder selected"

                        Text(
                            text = "Active backup location: $folderName",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Button(
                            onClick = { backupDirPickerLauncher.launch(null) },
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Icon(Icons.Outlined.FolderOpen, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(Modifier.width(8.dp))
                            Text(if (backupSafUri == null) "Select Backup Folder" else "Change Folder")
                        }

                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f))

                        SettingToggleItem(
                            title = "Daily Auto-Backup",
                            description = "Exports a complete SQLite and media snapshot every night at 00:00",
                            checked = backupInterval == "DAILY",
                            onCheckedChange = { isChecked ->
                                val newInterval = if (isChecked) "DAILY" else "NONE"
                                repository.backupInterval = newInterval
                                backupInterval = newInterval
                                BackupScheduler.updateSchedule(context)
                                if (isChecked && backupSafUri == null) {
                                    Toast.makeText(context, "Please choose a backup folder first!", Toast.LENGTH_LONG).show()
                                }
                            },
                            icon = Icons.Outlined.Schedule
                        )
                    }
                }
            }
        }

        SettingsSubCategory.MANUAL_BACKUP_RESTORE -> {
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
                            text = "Instant Backup & Restore",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Create an on-demand full database snapshot or restore from an existing backup ZIP.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Button(
                                onClick = {
                                    val uriStr = backupSafUri
                                    if (uriStr != null) {
                                        coroutineScope.launch(Dispatchers.IO) {
                                            try {
                                                val treeUri = Uri.parse(uriStr)
                                                val docDir = DocumentFile.fromTreeUri(context, treeUri)
                                                val ts = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
                                                val file = docDir?.createFile("application/zip", "ankiprep_backup_$ts.zip")
                                                file?.let { f ->
                                                    context.contentResolver.openOutputStream(f.uri)?.use { out ->
                                                        BackupRestoreUtils.exportBackup(context, out)
                                                    }
                                                }
                                                withContext(Dispatchers.Main) {
                                                    Toast.makeText(context, "Backup saved to folder!", Toast.LENGTH_LONG).show()
                                                }
                                            } catch (e: Exception) {
                                                withContext(Dispatchers.Main) {
                                                    Toast.makeText(context, "Backup failed: ${e.message}", Toast.LENGTH_SHORT).show()
                                                }
                                            }
                                        }
                                    } else {
                                        Toast.makeText(context, "Select a backup folder in Automated SAF first!", Toast.LENGTH_SHORT).show()
                                    }
                                },
                                modifier = Modifier.weight(1f),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Icon(Icons.Outlined.CloudUpload, contentDescription = null, modifier = Modifier.size(18.dp))
                                Spacer(Modifier.width(6.dp))
                                Text("Backup Now")
                            }

                            OutlinedButton(
                                onClick = { restoreFileLauncher.launch(arrayOf("application/zip", "*/*")) },
                                modifier = Modifier.weight(1f),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Icon(Icons.Outlined.CloudDownload, contentDescription = null, modifier = Modifier.size(18.dp))
                                Spacer(Modifier.width(6.dp))
                                Text("Restore")
                            }
                        }
                    }
                }
            }
        }

        SettingsSubCategory.ANKIDROID_SYNC -> {
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
                            text = "AnkiDroid Flashcard Sync",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Import and sync cards directly with the AnkiDroid application installed on this device.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Button(
                            onClick = onSyncNow,
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Icon(Icons.Outlined.Sync, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(Modifier.width(8.dp))
                            Text("Sync With AnkiDroid Now")
                        }
                    }
                }
            }
        }

        else -> {}
    }
}
