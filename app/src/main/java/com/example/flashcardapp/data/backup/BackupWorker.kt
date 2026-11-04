package com.example.flashcardapp.data.backup

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.documentfile.provider.DocumentFile
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.flashcardapp.data.AppDatabase
import com.example.flashcardapp.data.SettingsRepository
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class BackupWorker(private val context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {
    companion object {
        private const val TAG = "BackupWorker"
        private const val MAX_RETAINED_SNAPSHOTS = 7
    }

    override suspend fun doWork(): androidx.work.ListenableWorker.Result {
        val settingsRepo = SettingsRepository.getInstance(context)
        val safUriStr = settingsRepo.backupSafUri ?: return androidx.work.ListenableWorker.Result.failure()

        try {
            val treeUri = Uri.parse(safUriStr)
            val docDir = DocumentFile.fromTreeUri(context, treeUri)
            if (docDir == null || !docDir.exists() || !docDir.canWrite()) {
                Log.e(TAG, "Cannot write to SAF backup directory: $safUriStr")
                return androidx.work.ListenableWorker.Result.failure()
            }

            // 1. Change Detection: Check if database has changed since last backup
            val lastBackupTime = settingsRepo.lastBackupTimestamp
            if (lastBackupTime > 0L) {
                val liveDb = AppDatabase.getInstance(context)
                val latestAttemptTime = liveDb.cardAttemptDao().getAllAttempts().maxOfOrNull { it.timestamp } ?: 0L
                val latestDeckTime = liveDb.deckDao().getAllDecksOnce().maxOfOrNull { it.lastSyncTimestamp } ?: 0L
                val latestCardTime = liveDb.cardDao().getAllCardsOnce().maxOfOrNull { it.lastSyncTimestamp } ?: 0L
                val latestChangeTime = maxOf(latestAttemptTime, latestDeckTime, latestCardTime)

                if (latestChangeTime <= lastBackupTime) {
                    Log.i(TAG, "Skipping backup: No changes detected since last backup at $lastBackupTime")
                    // Still prune older snapshots if needed
                    pruneOldSnapshots(docDir)
                    return androidx.work.ListenableWorker.Result.success()
                }
            }

            // 2. Create fresh snapshot file in SAF directory
            val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
            val backupFileName = "ankiprep_backup_$timestamp.zip"

            val newFile = docDir.createFile("application/zip", backupFileName)
                ?: return androidx.work.ListenableWorker.Result.failure()

            val contentResolver = context.contentResolver
            contentResolver.openOutputStream(newFile.uri)?.use { outputStream ->
                val success = BackupRestoreUtils.exportBackup(context, outputStream)
                if (success) {
                    settingsRepo.lastBackupTimestamp = System.currentTimeMillis()
                    Log.i(TAG, "Backup snapshot written successfully: $backupFileName")

                    // 3. Auto-prune to retain strictly the last 7 daily snapshots
                    pruneOldSnapshots(docDir)

                    return androidx.work.ListenableWorker.Result.success()
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to run scheduled backup", e)
        }
        return androidx.work.ListenableWorker.Result.failure()
    }

    private fun pruneOldSnapshots(docDir: DocumentFile) {
        try {
            val backupFiles = docDir.listFiles()
                .filter { it.isFile && (it.name?.startsWith("ankiprep_backup_") == true) && (it.name?.endsWith(".zip") == true) }
                .sortedByDescending { it.name ?: "" }

            if (backupFiles.size > MAX_RETAINED_SNAPSHOTS) {
                val filesToDelete = backupFiles.drop(MAX_RETAINED_SNAPSHOTS)
                for (oldFile in filesToDelete) {
                    val deleted = oldFile.delete()
                    Log.i(TAG, "Auto-pruned snapshot: ${oldFile.name}, deleted=$deleted")
                }
            }
        } catch (e: Exception) {
            Log.w(TAG, "Failed to prune older snapshots: ${e.message}")
        }
    }
}
