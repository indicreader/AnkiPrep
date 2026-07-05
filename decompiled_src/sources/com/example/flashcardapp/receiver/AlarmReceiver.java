package com.example.flashcardapp.receiver;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.example.flashcardapp.MainActivity;
import com.example.flashcardapp.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AlarmReceiver.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/example/flashcardapp/receiver/AlarmReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class AlarmReceiver extends BroadcastReceiver {
    public static final int $stable = 0;
    private static final String CHANNEL_ID = "anki_prep_reminders";
    private static final int NOTIFICATION_ID = 1001;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "Daily Study Reminders", 3);
        notificationChannel.setDescription("Reminds you to practice your flashcards everyday or on chosen days");
        notificationManager.createNotificationChannel(notificationChannel);
        Intent intent2 = new Intent(context, (Class<?>) MainActivity.class);
        intent2.setFlags(268468224);
        Notification build = new NotificationCompat.Builder(context, CHANNEL_ID).setSmallIcon(R.drawable.app_logo).setContentTitle("Time to Practice!").setContentText("Keep your learning streak going! Review your decks now.").setPriority(0).setContentIntent(PendingIntent.getActivity(context, 0, intent2, 201326592)).setAutoCancel(true).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        notificationManager.notify(1001, build);
        ReminderScheduler.INSTANCE.scheduleNextReminder(context);
    }
}
