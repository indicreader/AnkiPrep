package com.example.flashcardapp.ui.settings

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
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
                title = "Wi-Fi Direct Transfer (Send & Receive)",
                description = "Fast, offline transfer of decks and study progress to another device on the same Wi-Fi",
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
    var scheduledHour by remember { mutableStateOf(repository.backupScheduledHour) }
    var showRestoreConfirmDialog by remember { mutableStateOf<Uri?>(null) }
    var isManualBackupInProgress by remember { mutableStateOf(false) }

    val backupDirPickerLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.OpenDocumentTree()
    ) { uri ->
        uri?.let {
            val flags = Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
            try {
                context.contentResolver.takePersistableUriPermission(it, flags)
            } catch (e: Exception) {
                // Continue if permission could not be persisted
            }
            repository.backupSafUri = it.toString()
            backupSafUri = it.toString()
            BackupScheduler.updateSchedule(context)
            Toast.makeText(context, "Backup folder configured with persistent permissions!", Toast.LENGTH_SHORT).show()
        }
    }

    val restoreFileLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.OpenDocument()
    ) { uri ->
        uri?.let {
            showRestoreConfirmDialog = it
        }
    }

    // Confirmation Dialog for Full Database Restore
    showRestoreConfirmDialog?.let { targetUri ->
        AlertDialog(
            onDismissRequest = { showRestoreConfirmDialog = null },
            title = { Text("Restore Full Database?", fontWeight = FontWeight.Bold) },
            text = {
                Text(
                    "Restoring from this snapshot will replace your current flashcards, review states, and decks with the data in the backup. " +
                    "The app will automatically restart after restoration is complete.\n\nDo you want to proceed?"
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        val uriToRestore = targetUri
                        showRestoreConfirmDialog = null
                        coroutineScope.launch {
                            val success = withContext(Dispatchers.IO) {
                                try {
                                    context.contentResolver.openInputStream(uriToRestore)?.use { input ->
                                        BackupRestoreUtils.importBackup(context, input)
                                    } ?: false
                                } catch (e: Exception) {
                                    false
                                }
                            }
                            if (success) {
                                Toast.makeText(context, "Database restored! Restarting app...", Toast.LENGTH_LONG).show()
                                kotlinx.coroutines.delay(1200)
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
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                ) {
                    Text("Restore & Restart")
                }
            },
            dismissButton = {
                TextButton(onClick = { showRestoreConfirmDialog = null }) {
                    Text("Cancel")
                }
            }
        )
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
                            title = "Nightly Auto-Backup (WhatsApp Style)",
                            description = "Automatically exports database and media snapshots in the background while device is idle and charging",
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

                        if (backupInterval == "DAILY") {
                            Text(
                                text = "Nightly Backup Scheduled Time",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                listOf(0 to "12:00 AM", 2 to "2:00 AM", 3 to "3:00 AM", 4 to "4:00 AM").forEach { (hour, label) ->
                                    val isSelected = scheduledHour == hour
                                    FilterChip(
                                        selected = isSelected,
                                        onClick = {
                                            scheduledHour = hour
                                            repository.backupScheduledHour = hour
                                            BackupScheduler.updateSchedule(context)
                                            Toast.makeText(context, "Scheduled for $label nightly", Toast.LENGTH_SHORT).show()
                                        },
                                        label = { Text(label, fontSize = 12.sp) }
                                    )
                                }
                            }
                        }

                        // Badges for Change-Detection & 7-Day Auto-Prune
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
                        ) {
                            Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                                    Icon(Icons.Outlined.CheckCircle, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(16.dp))
                                    Text("Smart Change Detection: Skips backups if cards or reviews haven't changed", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                }
                                Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                                    Icon(Icons.Outlined.History, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(16.dp))
                                    Text("Auto-Prune: Retains strictly the last 7 daily snapshots to protect storage", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                }
                            }
                        }
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
                            text = "Instant Backup & Full Restore",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Create an on-demand complete database snapshot or restore from a previously exported ZIP backup.",
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
                                        isManualBackupInProgress = true
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
                                                    isManualBackupInProgress = false
                                                    Toast.makeText(context, "Full backup snapshot created successfully!", Toast.LENGTH_LONG).show()
                                                }
                                            } catch (e: Exception) {
                                                withContext(Dispatchers.Main) {
                                                    isManualBackupInProgress = false
                                                    Toast.makeText(context, "Backup failed: ${e.message}", Toast.LENGTH_SHORT).show()
                                                }
                                            }
                                        }
                                    } else {
                                        Toast.makeText(context, "Please select a backup folder under Automated SAF first!", Toast.LENGTH_SHORT).show()
                                    }
                                },
                                enabled = !isManualBackupInProgress,
                                modifier = Modifier.weight(1f),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Icon(Icons.Outlined.CloudUpload, contentDescription = null, modifier = Modifier.size(18.dp))
                                Spacer(Modifier.width(6.dp))
                                Text(if (isManualBackupInProgress) "Saving..." else "Backup Now")
                            }

                            OutlinedButton(
                                onClick = { restoreFileLauncher.launch(arrayOf("application/zip", "*/*")) },
                                modifier = Modifier.weight(1f),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Icon(Icons.Outlined.CloudDownload, contentDescription = null, modifier = Modifier.size(18.dp))
                                Spacer(Modifier.width(6.dp))
                                Text("Full Restore")
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
