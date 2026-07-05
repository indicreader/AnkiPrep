package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcsp implements zzgej {
    final /* synthetic */ String zza;
    final /* synthetic */ zzcsq zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcsp(zzcsq zzcsqVar, String str) {
        this.zza = str;
        this.zzb = zzcsqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        zzfht zzfhtVar;
        zzfnu zzfnuVar;
        zzfgy zzfgyVar;
        zzfgm zzfgmVar;
        zzfgm zzfgmVar2;
        zzcsq zzcsqVar = this.zzb;
        zzfhtVar = zzcsqVar.zzh;
        zzfnuVar = zzcsqVar.zzg;
        zzfgyVar = zzcsqVar.zze;
        zzfgmVar = zzcsqVar.zzf;
        zzfgmVar2 = zzcsqVar.zzf;
        zzfhtVar.zza(zzfnuVar.zzd(zzfgyVar, zzfgmVar, false, this.zza, null, zzfgmVar2.zzd));
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfht zzfhtVar;
        zzfnu zzfnuVar;
        zzfgy zzfgyVar;
        zzfgm zzfgmVar;
        zzfgm zzfgmVar2;
        zzcsq zzcsqVar = this.zzb;
        String str = (String) obj;
        zzfhtVar = zzcsqVar.zzh;
        zzfnuVar = zzcsqVar.zzg;
        zzfgyVar = zzcsqVar.zze;
        zzfgmVar = zzcsqVar.zzf;
        zzfgmVar2 = zzcsqVar.zzf;
        zzfhtVar.zza(zzfnuVar.zzd(zzfgyVar, zzfgmVar, false, this.zza, str, zzfgmVar2.zzd));
    }
}
