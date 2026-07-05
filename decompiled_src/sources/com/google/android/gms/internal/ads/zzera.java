package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzera implements zzgej {
    final /* synthetic */ zzeqt zza;
    final /* synthetic */ zzfmz zzb;
    final /* synthetic */ zzfmo zzc;
    final /* synthetic */ zzdlk zzd;
    final /* synthetic */ zzerb zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzera(zzerb zzerbVar, zzeqt zzeqtVar, zzfmz zzfmzVar, zzfmo zzfmoVar, zzdlk zzdlkVar) {
        this.zza = zzeqtVar;
        this.zzb = zzfmzVar;
        this.zzc = zzfmoVar;
        this.zzd = zzdlkVar;
        this.zze = zzerbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        zzclg zzclgVar;
        zzfnc zzfncVar;
        zzfmz zzfmzVar;
        final com.google.android.gms.ads.internal.client.zze zza = this.zzd.zza().zza(th);
        this.zzd.zzb().zzbK(zza);
        zzclgVar = this.zze.zzb;
        zzclgVar.zzB().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeqz
            @Override // java.lang.Runnable
            public final void run() {
                zzeqr zzeqrVar;
                zzeqrVar = zzera.this.zze.zzd;
                zzeqrVar.zza().zzbK(zza);
            }
        });
        zzfie.zzb(zza.zza, th, "NativeAdLoader.onFailure");
        this.zza.zza();
        if (!((Boolean) zzbht.zzc.zze()).booleanValue() || (zzfmzVar = this.zzb) == null) {
            zzerb zzerbVar = this.zze;
            zzfmo zzfmoVar = this.zzc;
            zzfncVar = zzerbVar.zze;
            zzfmoVar.zza(zza);
            zzfmoVar.zzg(th);
            zzfmoVar.zzf(false);
            zzfncVar.zzb(zzfmoVar.zzl());
            return;
        }
        zzfmzVar.zzc(zza);
        zzfmo zzfmoVar2 = this.zzc;
        zzfmoVar2.zzg(th);
        zzfmoVar2.zzf(false);
        zzfmzVar.zza(zzfmoVar2);
        zzfmzVar.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzeqr zzeqrVar;
        zzclg zzclgVar;
        zzfnc zzfncVar;
        zzfmz zzfmzVar;
        zzcwh zzcwhVar = (zzcwh) obj;
        synchronized (this.zze) {
            zzdfc zzn = zzcwhVar.zzn();
            zzeqrVar = this.zze.zzd;
            zzn.zza(zzeqrVar.zzd());
            this.zza.zzb(zzcwhVar);
            zzclgVar = this.zze.zzb;
            zzclgVar.zzB().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeqy
                @Override // java.lang.Runnable
                public final void run() {
                    zzeqr zzeqrVar2;
                    zzeqrVar2 = zzera.this.zze.zzd;
                    zzeqrVar2.zzb().zzr();
                }
            });
            if (((Boolean) zzbht.zzc.zze()).booleanValue() && (zzfmzVar = this.zzb) != null) {
                zzfmzVar.zzf(zzcwhVar.zzp().zzb);
                zzfmzVar.zze(zzcwhVar.zzl().zzg());
                zzfmo zzfmoVar = this.zzc;
                zzfmoVar.zzf(true);
                zzfmzVar.zza(zzfmoVar);
                zzfmzVar.zzg();
            } else {
                zzfncVar = this.zze.zze;
                zzfmo zzfmoVar2 = this.zzc;
                zzfmoVar2.zzb(zzcwhVar.zzp().zzb);
                zzfmoVar2.zzd(zzcwhVar.zzl().zzg());
                zzfmoVar2.zzf(true);
                zzfncVar.zzb(zzfmoVar2.zzl());
            }
        }
    }
}
