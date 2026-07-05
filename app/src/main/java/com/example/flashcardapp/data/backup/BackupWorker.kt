package com.example.flashcardapp.data.backup

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.documentfile.provider.DocumentFile
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.flashcardapp.data.SettingsRepository
import java.io.OutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class BackupWorker(private val context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {
    override suspend fun doWork(): androidx.work.ListenableWorker.Result {
        val settingsRepo = SettingsRepository.getInstance(context)
        val safUriStr = settingsRepo.backupSafUri ?: return androidx.work.ListenableWorker.Result.failure()
        
        try {
            val treeUri = Uri.parse(safUriStr)
            val docDir = DocumentFile.fromTreeUri(context, treeUri)
            if (docDir == null || !docDir.exists() || !docDir.canWrite()) {
                Log.e("BackupWorker", "Cannot write to SAF backup directory: $safUriStr")
                return androidx.work.ListenableWorker.Result.failure()
            }

            val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
            val backupFileName = "ankiprep_backup_$timestamp.zip"
            
            val newFile = docDir.createFile("application/zip", backupFileName)
                ?: return androidx.work.ListenableWorker.Result.failure()

            val contentResolver = context.contentResolver
            contentResolver.openOutputStream(newFile.uri)?.use { outputStream ->
                val success = BackupRestoreUtils.exportBackup(context, outputStream)
                if (success) {
                    Log.i("BackupWorker", "Daily backup written successfully: $backupFileName")
                    return androidx.work.ListenableWorker.Result.success()
                }
            }
        } catch (e: Exception) {
            Log.e("BackupWorker", "Failed to run scheduled backup", e)
        }
        return androidx.work.ListenableWorker.Result.failure()
    }
}
