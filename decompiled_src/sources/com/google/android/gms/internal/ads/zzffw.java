package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzffw implements zzgej {
    final /* synthetic */ zzeqt zza;
    final /* synthetic */ zzfmz zzb;
    final /* synthetic */ zzfmo zzc;
    final /* synthetic */ zzffy zzd;
    final /* synthetic */ zzffz zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzffw(zzffz zzffzVar, zzeqt zzeqtVar, zzfmz zzfmzVar, zzfmo zzfmoVar, zzffy zzffyVar) {
        this.zza = zzeqtVar;
        this.zzb = zzfmzVar;
        this.zzc = zzfmoVar;
        this.zzd = zzffyVar;
        this.zze = zzffzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        zzfed zzfedVar;
        final com.google.android.gms.ads.internal.client.zze zza;
        zzffp zzffpVar;
        zzdss zzk;
        zzfnc zzfncVar;
        zzfmz zzfmzVar;
        Executor executor;
        zzfedVar = this.zze.zze;
        zzdst zzdstVar = (zzdst) zzfedVar.zzd();
        if (zzdstVar == null) {
            zza = zzfij.zzb(th, null);
        } else {
            zza = zzdstVar.zzb().zza(th);
        }
        synchronized (this.zze) {
            if (zzdstVar != null) {
                zzdstVar.zza().zzbK(zza);
                executor = this.zze.zzb;
                executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzffu
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzffp zzffpVar2;
                        zzffpVar2 = zzffw.this.zze.zzd;
                        zzffpVar2.zzbK(zza);
                    }
                });
            } else {
                zzffpVar = this.zze.zzd;
                zzffpVar.zzbK(zza);
                zzk = this.zze.zzk(this.zzd);
                zzk.zzh().zzb().zzc().zzh();
            }
            zzfie.zzb(zza.zza, th, "RewardedAdLoader.onFailure");
            this.zza.zza();
            if (((Boolean) zzbht.zzc.zze()).booleanValue() && (zzfmzVar = this.zzb) != null) {
                zzfmzVar.zzc(zza);
                zzfmo zzfmoVar = this.zzc;
                zzfmoVar.zzg(th);
                zzfmoVar.zzf(false);
                zzfmzVar.zza(zzfmoVar);
                zzfmzVar.zzg();
            } else {
                zzfncVar = this.zze.zzg;
                zzfmo zzfmoVar2 = this.zzc;
                zzfmoVar2.zza(zza);
                zzfmoVar2.zzg(th);
                zzfmoVar2.zzf(false);
                zzfncVar.zzb(zzfmoVar2.zzl());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzffp zzffpVar;
        Executor executor;
        final zzffp zzffpVar2;
        zzffp zzffpVar3;
        zzfnc zzfncVar;
        zzfmz zzfmzVar;
        zzdso zzdsoVar = (zzdso) obj;
        synchronized (this.zze) {
            zzdfc zzn = zzdsoVar.zzn();
            zzffpVar = this.zze.zzd;
            zzn.zzd(zzffpVar);
            this.zza.zzb(zzdsoVar);
            zzffz zzffzVar = this.zze;
            executor = zzffzVar.zzb;
            zzffpVar2 = zzffzVar.zzd;
            Objects.requireNonNull(zzffpVar2);
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzffv
                @Override // java.lang.Runnable
                public final void run() {
                    zzffp.this.zzr();
                }
            });
            zzffpVar3 = this.zze.zzd;
            zzffpVar3.onAdMetadataChanged();
            if (((Boolean) zzbht.zzc.zze()).booleanValue() && (zzfmzVar = this.zzb) != null) {
                zzfmzVar.zzf(zzdsoVar.zzp().zzb);
                zzfmzVar.zze(zzdsoVar.zzl().zzg());
                zzfmo zzfmoVar = this.zzc;
                zzfmoVar.zzf(true);
                zzfmzVar.zza(zzfmoVar);
                zzfmzVar.zzg();
            } else {
                zzfncVar = this.zze.zzg;
                zzfmo zzfmoVar2 = this.zzc;
                zzfmoVar2.zzb(zzdsoVar.zzp().zzb);
                zzfmoVar2.zzd(zzdsoVar.zzl().zzg());
                zzfmoVar2.zzf(true);
                zzfncVar.zzb(zzfmoVar2.zzl());
            }
        }
    }
}
