package com.example.flashcardapp.data.backup

import android.content.Context
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.flashcardapp.data.SettingsRepository
import java.util.concurrent.TimeUnit

object BackupScheduler {
    private const val WORK_NAME = "ankiprep_daily_backup"

    fun updateSchedule(context: Context) {
        val workManager = WorkManager.getInstance(context)
        val settingsRepo = SettingsRepository.getInstance(context)
        val interval = settingsRepo.backupInterval
        val safUri = settingsRepo.backupSafUri

        if (interval == "DAILY" && safUri != null) {
            val request = PeriodicWorkRequestBuilder<BackupWorker>(24, TimeUnit.HOURS)
                .build()
            workManager.enqueueUniquePeriodicWork(
                WORK_NAME,
                ExistingPeriodicWorkPolicy.UPDATE,
                request
            )
        } else {
            workManager.cancelUniqueWork(WORK_NAME)
        }
    }
}
