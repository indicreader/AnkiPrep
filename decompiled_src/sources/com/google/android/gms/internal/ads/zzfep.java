package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfep implements zzequ {
    private final Context zza;
    private final Executor zzb;
    private final zzclg zzc;
    private final zzeqe zzd;
    private final zzffp zze;
    private zzbha zzf;
    private final zzfnc zzg;
    private final zzfhf zzh;
    private ListenableFuture zzi;

    public zzfep(Context context, Executor executor, zzclg zzclgVar, zzeqe zzeqeVar, zzffp zzffpVar, zzfhf zzfhfVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzclgVar;
        this.zzd = zzeqeVar;
        this.zzh = zzfhfVar;
        this.zze = zzffpVar;
        this.zzg = zzclgVar.zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzequ
    public final boolean zza() {
        ListenableFuture listenableFuture = this.zzi;
        return (listenableFuture == null || listenableFuture.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzequ
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzeqs zzeqsVar, zzeqt zzeqtVar) {
        zzdko zzh;
        zzfmz zzfmzVar;
        if (str == null) {
            zzcec.zzg("Ad unit ID should not be null for interstitial ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfej
                @Override // java.lang.Runnable
                public final void run() {
                    zzfep.this.zzh();
                }
            });
            return false;
        }
        if (zza()) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziN)).booleanValue() && zzlVar.zzf) {
            this.zzc.zzk().zzn(true);
        }
        com.google.android.gms.ads.internal.client.zzq zzqVar = ((zzfei) zzeqsVar).zza;
        zzfhf zzfhfVar = this.zzh;
        zzfhfVar.zzs(str);
        zzfhfVar.zzr(zzqVar);
        zzfhfVar.zzE(zzlVar);
        Context context = this.zza;
        zzfhh zzG = zzfhfVar.zzG();
        zzfmo zzb = zzfmn.zzb(context, zzfmy.zzf(zzG), 4, zzlVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzib)).booleanValue()) {
            zzdkn zzg = this.zzc.zzg();
            zzdaf zzdafVar = new zzdaf();
            zzdafVar.zze(this.zza);
            zzdafVar.zzi(zzG);
            zzg.zze(zzdafVar.zzj());
            zzdgm zzdgmVar = new zzdgm();
            zzdgmVar.zzj(this.zzd, this.zzb);
            zzdgmVar.zzk(this.zzd, this.zzb);
            zzg.zzd(zzdgmVar.zzn());
            zzg.zzc(new zzeon(this.zzf));
            zzh = zzg.zzh();
        } else {
            zzdgm zzdgmVar2 = new zzdgm();
            zzffp zzffpVar = this.zze;
            if (zzffpVar != null) {
                zzdgmVar2.zze(zzffpVar, this.zzb);
                zzdgmVar2.zzf(this.zze, this.zzb);
                zzdgmVar2.zzb(this.zze, this.zzb);
            }
            zzdkn zzg2 = this.zzc.zzg();
            zzdaf zzdafVar2 = new zzdaf();
            zzdafVar2.zze(this.zza);
            zzdafVar2.zzi(zzG);
            zzg2.zze(zzdafVar2.zzj());
            zzdgmVar2.zzj(this.zzd, this.zzb);
            zzdgmVar2.zze(this.zzd, this.zzb);
            zzdgmVar2.zzf(this.zzd, this.zzb);
            zzdgmVar2.zzb(this.zzd, this.zzb);
            zzdgmVar2.zza(this.zzd, this.zzb);
            zzdgmVar2.zzl(this.zzd, this.zzb);
            zzdgmVar2.zzk(this.zzd, this.zzb);
            zzdgmVar2.zzi(this.zzd, this.zzb);
            zzdgmVar2.zzc(this.zzd, this.zzb);
            zzg2.zzd(zzdgmVar2.zzn());
            zzg2.zzc(new zzeon(this.zzf));
            zzh = zzg2.zzh();
        }
        zzdko zzdkoVar = zzh;
        if (((Boolean) zzbht.zzc.zze()).booleanValue()) {
            zzfmz zzf = zzdkoVar.zzf();
            zzf.zzh(4);
            zzf.zzb(zzlVar.zzp);
            zzfmzVar = zzf;
        } else {
            zzfmzVar = null;
        }
        zzcxp zza = zzdkoVar.zza();
        ListenableFuture zzi = zza.zzi(zza.zzj());
        this.zzi = zzi;
        zzgen.zzr(zzi, new zzfeo(this, zzeqtVar, zzfmzVar, zzb, zzdkoVar), this.zzb);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzh() {
        this.zzd.zzbK(zzfij.zzd(6, null, null));
    }

    public final void zzi(zzbha zzbhaVar) {
        this.zzf = zzbhaVar;
    }
}
