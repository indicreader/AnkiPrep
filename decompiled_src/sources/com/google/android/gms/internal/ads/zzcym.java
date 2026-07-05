package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcym implements zzdgi, zzdcl {
    private final Clock zza;
    private final zzcyo zzb;
    private final zzfhh zzc;
    private final String zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcym(Clock clock, zzcyo zzcyoVar, zzfhh zzfhhVar, String str) {
        this.zza = clock;
        this.zzb = zzcyoVar;
        this.zzc = zzfhhVar;
        this.zzd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdgi
    public final void zza() {
        this.zzb.zze(this.zzd, this.zza.elapsedRealtime());
    }

    @Override // com.google.android.gms.internal.ads.zzdcl
    public final void zzr() {
        zzfhh zzfhhVar = this.zzc;
        this.zzb.zzd(zzfhhVar.zzf, this.zzd, this.zza.elapsedRealtime());
    }
}
