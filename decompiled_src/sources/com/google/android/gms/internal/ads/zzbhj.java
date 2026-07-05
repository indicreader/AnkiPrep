package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.MotionEvent;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbhj {
    private MotionEvent zza = MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, 0);
    private MotionEvent zzb = MotionEvent.obtain(0, 0, 0, 0.0f, 0.0f, 0);
    private final Context zzc;
    private final ScheduledExecutorService zzd;
    private final zzfmz zze;
    private final zzbhl zzf;

    public zzbhj(Context context, ScheduledExecutorService scheduledExecutorService, zzbhl zzbhlVar, zzfmz zzfmzVar) {
        this.zzc = context;
        this.zzd = scheduledExecutorService;
        this.zzf = zzbhlVar;
        this.zze = zzfmzVar;
    }

    public final ListenableFuture zza() {
        return (zzgee) zzgen.zzo(zzgee.zzu(zzgen.zzh(null)), ((Long) zzbhz.zzc.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzd);
    }

    public final void zzb(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1 || motionEvent.getEventTime() <= this.zza.getEventTime()) {
            if (motionEvent.getAction() != 0 || motionEvent.getEventTime() <= this.zzb.getEventTime()) {
                return;
            }
            this.zzb = MotionEvent.obtain(motionEvent);
            return;
        }
        this.zza = MotionEvent.obtain(motionEvent);
    }
}
