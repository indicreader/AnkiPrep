package com.example.flashcardapp.data.ca

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.work.Constraints
import androidx.work.CoroutineWorker
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.example.flashcardapp.R
import com.example.flashcardapp.data.AppDatabase
import com.example.flashcardapp.data.entities.QuestionEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit

/**
 * Background WorkManager worker responsible for automatically fetching user-selected
 * Current Affairs RSS/Atom feeds, synthesizing MCQs, appending rows to `current_affairs_<YEAR>.csv`,
 * and synchronizing entries into Room DB.
 */
class DailyCurrentAffairsWorker(
    private val context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            val database = AppDatabase.getInstance(context)
            val activeSources = database.currentAffairsSourceDao().getActiveSourcesSync()

            if (activeSources.isEmpty()) {
                Log.i(TAG, "No active Current Affairs feed sources configured.")
                return@withContext Result.success()
            }

            val existingKeys = CurrentAffairsDeckAppender.getExistingQuestionKeys(context).toMutableSet()
            val allNewQuestions = mutableListOf<QuestionEntity>()

            // Limit to maximum 5 active sources safety check
            val sourcesToProcess = activeSources.take(5)

            for (source in sourcesToProcess) {
                val result = CurrentAffairsEngine.fetchAndSynthesizeMCQs(source, existingKeys)
                result.onSuccess { synthesizedList ->
                    for (q in synthesizedList) {
                        allNewQuestions.add(q)
                        // Add normalized title key to local set to avoid duplicate items across feeds in same run
                        val extractTitle = q.questionText.substringAfter("headline: '").substringBefore("'. Which")
                        val normKey = extractTitle.lowercase().replace(Regex("[^a-z0-9]"), "")
                        if (normKey.isNotBlank()) {
                            existingKeys.add(normKey)
                        }
                    }
                }.onFailure { error ->
                    Log.e(TAG, "Error processing feed '${source.title}': ${error.message}", error)
                }
            }

            if (allNewQuestions.isNotEmpty()) {
                CurrentAffairsDeckAppender.appendQuestionsAndSyncDb(context, allNewQuestions)
                showNotification(
                    title = "Daily Current Affairs Updated",
                    message = "Added ${allNewQuestions.size} new exam-oriented MCQs to Current Affairs deck."
                )
                Log.i(TAG, "Successfully processed and appended ${allNewQuestions.size} new MCQs.")
            } else {
                Log.i(TAG, "Current Affairs sync completed. No new items found.")
            }

            Result.success()
        } catch (e: Exception) {
            Log.e(TAG, "DailyCurrentAffairsWorker failed execution", e)
            Result.failure()
        }
    }

    private fun showNotification(title: String, message: String) {
        val channelId = "current_affairs_sync_channel"
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Daily Current Affairs Sync",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Notifications for Daily Current Affairs background feed processing"
            }
            notificationManager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(android.R.drawable.stat_notify_sync)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(NOTIFICATION_ID, notification)
    }

    companion object {
        private const val TAG = "DailyCAWorker"
        const val PERIODIC_WORK_NAME = "DailyCurrentAffairsSyncWork"
        const val IMMEDIATE_WORK_NAME = "DailyCurrentAffairsImmediateWork"
        private const val NOTIFICATION_ID = 9081

        /**
         * Schedules a periodic 24-hour background synchronization with network connectivity constraints.
         */
        fun schedulePeriodicSync(context: Context) {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            val periodicRequest = PeriodicWorkRequestBuilder<DailyCurrentAffairsWorker>(24, TimeUnit.HOURS)
                .setConstraints(constraints)
                .build()

            WorkManager.getInstance(context).enqueueUniquePeriodicWork(
                PERIODIC_WORK_NAME,
                ExistingPeriodicWorkPolicy.KEEP,
                periodicRequest
            )
        }

        /**
         * Triggers an immediate manual background synchronization pass.
         */
        fun triggerImmediateSync(context: Context) {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            val immediateRequest = OneTimeWorkRequestBuilder<DailyCurrentAffairsWorker>()
                .setConstraints(constraints)
                .build()

            WorkManager.getInstance(context).enqueueUniqueWork(
                IMMEDIATE_WORK_NAME,
                ExistingWorkPolicy.REPLACE,
                immediateRequest
            )
        }
    }
}
