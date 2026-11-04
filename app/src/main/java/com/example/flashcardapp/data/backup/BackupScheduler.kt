package com.example.flashcardapp.data.backup

import android.content.Context
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.flashcardapp.data.SettingsRepository
import java.util.Calendar
import java.util.concurrent.TimeUnit

object BackupScheduler {
    private const val WORK_NAME = "ankiprep_daily_backup"

    /**
     * Calculates delay in milliseconds until the next occurrence of targetHour:targetMinute (e.g. 2:00 AM).
     */
    fun calculateInitialDelayMillis(targetHour: Int, targetMinute: Int = 0): Long {
        val now = Calendar.getInstance()
        val target = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, targetHour)
            set(Calendar.MINUTE, targetMinute)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
            if (before(now)) {
                add(Calendar.DAY_OF_YEAR, 1)
            }
        }
        return target.timeInMillis - now.timeInMillis
    }

    fun updateSchedule(context: Context) {
        val workManager = WorkManager.getInstance(context)
        val settingsRepo = SettingsRepository.getInstance(context)
        val interval = settingsRepo.backupInterval
        val safUri = settingsRepo.backupSafUri

        if (interval == "DAILY" && safUri != null) {
            val initialDelay = calculateInitialDelayMillis(
                settingsRepo.backupScheduledHour,
                settingsRepo.backupScheduledMinute
            )

            val constraints = Constraints.Builder()
                .setRequiresBatteryNotLow(true)
                .build()

            val request = PeriodicWorkRequestBuilder<BackupWorker>(24, TimeUnit.HOURS)
                .setInitialDelay(initialDelay, TimeUnit.MILLISECONDS)
                .setConstraints(constraints)
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

    /**
     * Trigger a one-time immediate backup.
     */
    fun triggerImmediateBackup(context: Context) {
        val workManager = WorkManager.getInstance(context)
        val request = OneTimeWorkRequestBuilder<BackupWorker>().build()
        workManager.enqueue(request)
    }
}
