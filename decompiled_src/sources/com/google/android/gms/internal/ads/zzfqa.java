package com.google.android.gms.internal.ads;

import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzfqa implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Handler handler2;
        Runnable runnable;
        Handler handler3;
        Runnable runnable2;
        handler = zzfqd.zzc;
        if (handler != null) {
            handler2 = zzfqd.zzc;
            runnable = zzfqd.zzd;
            handler2.post(runnable);
            handler3 = zzfqd.zzc;
            runnable2 = zzfqd.zze;
            handler3.postDelayed(runnable2, 200L);
        }
    }
}
