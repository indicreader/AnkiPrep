package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdmt implements zzgej {
    final /* synthetic */ String zza = "Google";
    final /* synthetic */ zzdmv zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdmt(zzdmv zzdmvVar, String str, boolean z) {
        this.zzb = zzdmvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfb)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzo().zzv(th, "omid native display exp");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdna zzdnaVar;
        zzdna zzdnaVar2;
        zzdnaVar = this.zzb.zze;
        zzdnaVar.zzT((zzcjk) obj);
        zzdmv zzdmvVar = this.zzb;
        zzdnaVar2 = zzdmvVar.zze;
        zzceu zzp = zzdnaVar2.zzp();
        zzfod zzf = zzdmvVar.zzf(this.zza, true);
        if (zzf != null && zzp != null) {
            zzp.zzc(zzf);
        } else if (zzp != null) {
            zzp.cancel(false);
        }
    }
}
