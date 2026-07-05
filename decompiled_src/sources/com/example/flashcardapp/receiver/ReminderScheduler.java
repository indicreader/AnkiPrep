package com.example.flashcardapp.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.example.flashcardapp.data.SettingsRepository;
import java.util.Calendar;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReminderScheduler.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/example/flashcardapp/receiver/ReminderScheduler;", "", "()V", "ALARM_REQ_CODE", "", "scheduleNextReminder", "", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ReminderScheduler {
    public static final int $stable = 0;
    private static final int ALARM_REQ_CODE = 4567;
    public static final ReminderScheduler INSTANCE = new ReminderScheduler();

    private ReminderScheduler() {
    }

    public final void scheduleNextReminder(Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        SettingsRepository companion = SettingsRepository.INSTANCE.getInstance(context);
        Object systemService = context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager alarmManager = (AlarmManager) systemService;
        PendingIntent broadcast = PendingIntent.getBroadcast(context, ALARM_REQ_CODE, new Intent(context, (Class<?>) AlarmReceiver.class), 201326592);
        alarmManager.cancel(broadcast);
        if (!companion.getReminderEnabled()) {
            Log.d("ReminderScheduler", "Reminders disabled. Alarm canceled.");
            return;
        }
        int reminderHour = companion.getReminderHour();
        int reminderMinute = companion.getReminderMinute();
        Set<String> reminderDays = companion.getReminderDays();
        if (reminderDays.isEmpty()) {
            Log.d("ReminderScheduler", "No days selected for reminder.");
            return;
        }
        Calendar calendar = Calendar.getInstance();
        int i = 0;
        while (true) {
            if (i < 8) {
                Calendar calendar2 = Calendar.getInstance();
                calendar2.add(6, i);
                switch (calendar2.get(7)) {
                    case 1:
                        str = "Sun";
                        break;
                    case 2:
                        str = "Mon";
                        break;
                    case 3:
                        str = "Tue";
                        break;
                    case 4:
                        str = "Wed";
                        break;
                    case 5:
                        str = "Thu";
                        break;
                    case 6:
                        str = "Fri";
                        break;
                    case 7:
                        str = "Sat";
                        break;
                    default:
                        str = "";
                        break;
                }
                if (reminderDays.contains(str)) {
                    calendar2.set(11, reminderHour);
                    calendar2.set(12, reminderMinute);
                    calendar2.set(13, 0);
                    calendar2.set(14, 0);
                    if (calendar2.getTimeInMillis() > System.currentTimeMillis()) {
                        calendar.setTimeInMillis(calendar2.getTimeInMillis());
                    }
                }
                i++;
            } else {
                calendar.add(6, 1);
                calendar.set(11, reminderHour);
                calendar.set(12, reminderMinute);
                calendar.set(13, 0);
                calendar.set(14, 0);
            }
        }
        Log.d("ReminderScheduler", "Scheduling alarm for: " + calendar.getTime());
        try {
            alarmManager.setExactAndAllowWhileIdle(0, calendar.getTimeInMillis(), broadcast);
        } catch (SecurityException unused) {
            alarmManager.set(0, calendar.getTimeInMillis(), broadcast);
        }
    }
}
