package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzij extends BroadcastReceiver implements Runnable {
    final /* synthetic */ zzil zza;
    private final zzik zzb;
    private final Handler zzc;

    public zzij(zzil zzilVar, Handler handler, zzik zzikVar) {
        this.zza = zzilVar;
        this.zzc = handler;
        this.zzb = zzikVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.zzc.post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
    }
}
