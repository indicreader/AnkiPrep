package com.example.flashcardapp.receiver

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import com.example.flashcardapp.data.SettingsRepository
import java.util.Calendar

object ReminderScheduler {
    private const val ALARM_REQ_CODE = 4567

    fun scheduleNextReminder(context: Context) {
        val settings = SettingsRepository.getInstance(context)
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val intent = Intent(context, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            ALARM_REQ_CODE,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        // Cancel existing alarm
        alarmManager.cancel(pendingIntent)

        if (!settings.reminderEnabled) {
            Log.d("ReminderScheduler", "Reminders disabled. Alarm canceled.")
            return
        }

        val targetHour = settings.reminderHour
        val targetMinute = settings.reminderMinute
        val chosenDays = settings.reminderDays

        if (chosenDays.isEmpty()) {
            Log.d("ReminderScheduler", "No days selected for reminder.")
            return
        }

        val calendar = Calendar.getInstance()
        var foundNext = false

        // Look at today and the next 7 days
        for (i in 0..7) {
            val checkCal = Calendar.getInstance().apply {
                add(Calendar.DAY_OF_YEAR, i)
            }
            val checkDayStr = when (checkCal.get(Calendar.DAY_OF_WEEK)) {
                Calendar.SUNDAY -> "Sun"
                Calendar.MONDAY -> "Mon"
                Calendar.TUESDAY -> "Tue"
                Calendar.WEDNESDAY -> "Wed"
                Calendar.THURSDAY -> "Thu"
                Calendar.FRIDAY -> "Fri"
                Calendar.SATURDAY -> "Sat"
                else -> ""
            }

            if (chosenDays.contains(checkDayStr)) {
                checkCal.set(Calendar.HOUR_OF_DAY, targetHour)
                checkCal.set(Calendar.MINUTE, targetMinute)
                checkCal.set(Calendar.SECOND, 0)
                checkCal.set(Calendar.MILLISECOND, 0)

                if (checkCal.timeInMillis > System.currentTimeMillis()) {
                    calendar.timeInMillis = checkCal.timeInMillis
                    foundNext = true
                    break
                }
            }
        }

        if (!foundNext) {
            // Fallback: schedule for tomorrow
            calendar.add(Calendar.DAY_OF_YEAR, 1)
            calendar.set(Calendar.HOUR_OF_DAY, targetHour)
            calendar.set(Calendar.MINUTE, targetMinute)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)
        }

        Log.d("ReminderScheduler", "Scheduling alarm for: ${calendar.time}")

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    calendar.timeInMillis,
                    pendingIntent
                )
            } else {
                alarmManager.setExact(
                    AlarmManager.RTC_WAKEUP,
                    calendar.timeInMillis,
                    pendingIntent
                )
            }
        } catch (e: SecurityException) {
            // Fallback to inexact alarm if exact permission is denied
            alarmManager.set(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                pendingIntent
            )
        }
    }
}
