package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzefi implements zzdds, zzdcl, zzdba {
    private final zzflv zza;
    private final zzflw zzb;
    private final zzcdp zzc;

    public zzefi(zzflv zzflvVar, zzflw zzflwVar, zzcdp zzcdpVar) {
        this.zza = zzflvVar;
        this.zzb = zzflwVar;
        this.zzc = zzcdpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdba
    public final void zzbK(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzflv zzflvVar = this.zza;
        zzflvVar.zza("action", "ftl");
        zzflvVar.zza("ftl", String.valueOf(zzeVar.zza));
        zzflvVar.zza("ed", zzeVar.zzc);
        this.zzb.zzb(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzdds
    public final void zzbw(zzbze zzbzeVar) {
        this.zza.zzi(zzbzeVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzdds
    public final void zzbx(zzfgy zzfgyVar) {
        this.zza.zzh(zzfgyVar, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzdcl
    public final void zzr() {
        zzflv zzflvVar = this.zza;
        zzflvVar.zza("action", "loaded");
        this.zzb.zzb(zzflvVar);
    }
}
