package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfba {
    /* JADX WARN: Multi-variable type inference failed */
    public static zzexq zza(zzfae zzfaeVar, zzevq zzevqVar, ScheduledExecutorService scheduledExecutorService, int i) {
        if (i == 0) {
            zzfaeVar = zzevqVar;
        }
        return new zzevy(zzfaeVar, 0L, scheduledExecutorService);
    }

    public static zzexq zzb(zzfao zzfaoVar, ScheduledExecutorService scheduledExecutorService) {
        return new zzevy(zzfaoVar, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdZ)).longValue(), scheduledExecutorService);
    }

    public static zzexq zzc(zzfbj zzfbjVar, ScheduledExecutorService scheduledExecutorService) {
        return new zzevy(zzfbjVar, 0L, scheduledExecutorService);
    }
}
