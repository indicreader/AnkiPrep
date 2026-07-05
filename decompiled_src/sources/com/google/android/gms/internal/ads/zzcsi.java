package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcsi implements zzdba {
    private final zzfgp zza;
    private final zzfgy zzb;
    private final zzfnu zzc;
    private final zzfny zzd;

    public zzcsi(zzfgy zzfgyVar, zzfny zzfnyVar, zzfnu zzfnuVar) {
        this.zzb = zzfgyVar;
        this.zzd = zzfnyVar;
        this.zzc = zzfnuVar;
        this.zza = zzfgyVar.zzb.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdba
    public final void zzbK(com.google.android.gms.ads.internal.client.zze zzeVar) {
        List list = this.zza.zza;
        this.zzd.zzd(this.zzc.zzc(this.zzb, null, list));
    }
}
