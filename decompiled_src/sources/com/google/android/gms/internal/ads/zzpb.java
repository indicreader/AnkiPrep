package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzpb {
    public static final zzpb zza;
    private final zzpa zzb;

    static {
        zza = zzfy.zza < 31 ? new zzpb() : new zzpb(zzpa.zza);
    }

    public zzpb() {
        zzek.zzf(zzfy.zza < 31);
        this.zzb = null;
    }

    private zzpb(zzpa zzpaVar) {
        this.zzb = zzpaVar;
    }

    public final LogSessionId zza() {
        zzpa zzpaVar = this.zzb;
        zzpaVar.getClass();
        return zzpaVar.zzb;
    }

    public zzpb(LogSessionId logSessionId) {
        this.zzb = new zzpa(logSessionId);
    }
}
