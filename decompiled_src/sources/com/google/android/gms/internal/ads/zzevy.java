package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzevy implements zzexq {
    private final zzexq zza;
    private final long zzb;
    private final ScheduledExecutorService zzc;

    public zzevy(zzexq zzexqVar, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzexqVar;
        this.zzb = j;
        this.zzc = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        ListenableFuture zzb = this.zza.zzb();
        long j = this.zzb;
        if (j > 0) {
            zzb = zzgen.zzo(zzb, j, TimeUnit.MILLISECONDS, this.zzc);
        }
        return zzgen.zzf(zzb, Throwable.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzevx
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzgen.zzh(null);
            }
        }, zzcep.zzf);
    }
}
