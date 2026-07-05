package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzekg implements zzgej {
    final /* synthetic */ zzekh zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzekg(zzekh zzekhVar) {
        this.zza = zzekhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        zzcvc zzcvcVar;
        zzdaz zzdazVar;
        zzcvcVar = this.zza.zza;
        com.google.android.gms.ads.internal.client.zze zza = zzcvcVar.zzd().zza(th);
        zzdazVar = this.zza.zzd;
        zzdazVar.zzbK(zza);
        zzfie.zzb(zza.zza, th, "DelayedBannerAd.onFailure");
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* synthetic */ void zzb(Object obj) {
        ((zzcuf) obj).zzj();
    }
}
