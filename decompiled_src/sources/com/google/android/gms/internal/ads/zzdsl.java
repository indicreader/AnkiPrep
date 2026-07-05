package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdsl implements zzbnw {
    private final zzdce zza;
    private final zzcag zzb;
    private final String zzc;
    private final String zzd;

    public zzdsl(zzdce zzdceVar, zzfgm zzfgmVar) {
        this.zza = zzdceVar;
        this.zzb = zzfgmVar.zzm;
        this.zzc = zzfgmVar.zzk;
        this.zzd = zzfgmVar.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzbnw
    @ParametersAreNonnullByDefault
    public final void zza(zzcag zzcagVar) {
        int i;
        String str;
        zzcag zzcagVar2 = this.zzb;
        if (zzcagVar2 != null) {
            zzcagVar = zzcagVar2;
        }
        if (zzcagVar != null) {
            str = zzcagVar.zza;
            i = zzcagVar.zzb;
        } else {
            i = 1;
            str = "";
        }
        this.zza.zzd(new zzbzr(str, i), this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzbnw
    public final void zzb() {
        this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzbnw
    public final void zzc() {
        this.zza.zzf();
    }
}
