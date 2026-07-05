package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdrv {
    private final zzdav zza;
    private final zzdce zzb;
    private final zzdcr zzc;
    private final zzddd zzd;
    private final zzdfr zze;
    private final zzfgm zzf;
    private final zzfgp zzg;

    public zzdrv(zzdav zzdavVar, zzdce zzdceVar, zzdcr zzdcrVar, zzddd zzdddVar, zzdfr zzdfrVar, zzfgm zzfgmVar, zzfgp zzfgpVar) {
        this.zza = zzdavVar;
        this.zzb = zzdceVar;
        this.zzc = zzdcrVar;
        this.zzd = zzdddVar;
        this.zze = zzdfrVar;
        this.zzf = zzfgmVar;
        this.zzg = zzfgpVar;
    }

    public final void zza(zzdrz zzdrzVar) {
        zzdrm zzdrmVar;
        final zzdce zzdceVar = this.zzb;
        zzdrmVar = zzdrzVar.zza;
        Objects.requireNonNull(zzdceVar);
        zzdrmVar.zzh(this.zza, this.zzc, this.zzd, this.zze, new com.google.android.gms.ads.internal.overlay.zzaa() { // from class: com.google.android.gms.internal.ads.zzdru
            @Override // com.google.android.gms.ads.internal.overlay.zzaa
            public final void zzg() {
                zzdce.this.zzb();
            }
        });
        zzdrzVar.zze(this.zzf, this.zzg);
    }
}
