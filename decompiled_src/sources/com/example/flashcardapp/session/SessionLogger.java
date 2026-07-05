package com.example.flashcardapp.session;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionLogger.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\"\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nJ\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\r"}, d2 = {"Lcom/example/flashcardapp/session/SessionLogger;", "", "()V", "d", "", "tag", "", NotificationCompat.CATEGORY_MESSAGE, "e", "tr", "", "i", "w", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class SessionLogger {
    public static final int $stable = 0;
    public static final SessionLogger INSTANCE = new SessionLogger();

    private SessionLogger() {
    }

    public final void i(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        try {
            Log.i(tag, msg);
        } catch (RuntimeException unused) {
            System.out.println((Object) ("[" + tag + "] INFO: " + msg));
        }
    }

    public final void d(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        try {
            Log.d(tag, msg);
        } catch (RuntimeException unused) {
            System.out.println((Object) ("[" + tag + "] DEBUG: " + msg));
        }
    }

    public final void w(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        try {
            Log.w(tag, msg);
        } catch (RuntimeException unused) {
            System.out.println((Object) ("[" + tag + "] WARN: " + msg));
        }
    }

    public static /* synthetic */ void e$default(SessionLogger sessionLogger, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        sessionLogger.e(str, str2, th);
    }

    public final void e(String tag, String msg, Throwable tr) {
        String str;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        try {
            Log.e(tag, msg, tr);
        } catch (RuntimeException unused) {
            if (tr == null || (str = tr.getMessage()) == null) {
                str = "";
            }
            System.out.println((Object) ("[" + tag + "] ERROR: " + msg + " " + str));
            if (tr != null) {
                tr.printStackTrace();
            }
        }
    }
}
