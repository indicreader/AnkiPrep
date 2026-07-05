package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcca {
    private Context zza;
    private Clock zzb;
    private com.google.android.gms.ads.internal.util.zzg zzc;
    private zzcch zzd;

    private zzcca() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcca(zzcbz zzcbzVar) {
    }

    public final zzcca zza(com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zzc = zzgVar;
        return this;
    }

    public final zzcca zzb(Context context) {
        context.getClass();
        this.zza = context;
        return this;
    }

    public final zzcca zzc(Clock clock) {
        clock.getClass();
        this.zzb = clock;
        return this;
    }

    public final zzcca zzd(zzcch zzcchVar) {
        this.zzd = zzcchVar;
        return this;
    }

    public final zzcci zze() {
        zzhhl.zzc(this.zza, Context.class);
        zzhhl.zzc(this.zzb, Clock.class);
        zzhhl.zzc(this.zzc, com.google.android.gms.ads.internal.util.zzg.class);
        zzhhl.zzc(this.zzd, zzcch.class);
        return new zzccc(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
