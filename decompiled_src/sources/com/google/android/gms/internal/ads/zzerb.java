package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzerb implements zzequ {
    private final zzfhf zza;
    private final zzclg zzb;
    private final Context zzc;
    private final zzeqr zzd;
    private final zzfnc zze;
    private zzcww zzf;

    public zzerb(zzclg zzclgVar, Context context, zzeqr zzeqrVar, zzfhf zzfhfVar) {
        this.zzb = zzclgVar;
        this.zzc = context;
        this.zzd = zzeqrVar;
        this.zza = zzfhfVar;
        this.zze = zzclgVar.zzz();
        zzfhfVar.zzu(zzeqrVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzequ
    public final boolean zza() {
        zzcww zzcwwVar = this.zzf;
        return zzcwwVar != null && zzcwwVar.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzequ
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzeqs zzeqsVar, zzeqt zzeqtVar) throws RemoteException {
        zzfmz zzfmzVar;
        com.google.android.gms.ads.internal.zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzG(this.zzc) && zzlVar.zzs == null) {
            zzcec.zzg("Failed to load the ad because app ID is missing.");
            this.zzb.zzB().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeqw
                @Override // java.lang.Runnable
                public final void run() {
                    zzerb.this.zzf();
                }
            });
            return false;
        }
        if (str == null) {
            zzcec.zzg("Ad unit ID should not be null for NativeAdLoader.");
            this.zzb.zzB().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeqx
                @Override // java.lang.Runnable
                public final void run() {
                    zzerb.this.zzg();
                }
            });
            return false;
        }
        zzfie.zza(this.zzc, zzlVar.zzf);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziN)).booleanValue() && zzlVar.zzf) {
            this.zzb.zzk().zzn(true);
        }
        int i = ((zzeqv) zzeqsVar).zza;
        zzfhf zzfhfVar = this.zza;
        zzfhfVar.zzE(zzlVar);
        zzfhfVar.zzz(i);
        Context context = this.zzc;
        zzfhh zzG = zzfhfVar.zzG();
        zzfmo zzb = zzfmn.zzb(context, zzfmy.zzf(zzG), 8, zzlVar);
        com.google.android.gms.ads.internal.client.zzcb zzcbVar = zzG.zzn;
        if (zzcbVar != null) {
            this.zzd.zzd().zzm(zzcbVar);
        }
        zzdlj zzh = this.zzb.zzh();
        zzdaf zzdafVar = new zzdaf();
        zzdafVar.zze(this.zzc);
        zzdafVar.zzi(zzG);
        zzh.zzf(zzdafVar.zzj());
        zzdgm zzdgmVar = new zzdgm();
        zzdgmVar.zzk(this.zzd.zzd(), this.zzb.zzB());
        zzh.zze(zzdgmVar.zzn());
        zzh.zzd(this.zzd.zzc());
        zzh.zzc(new zzcuc(null));
        zzdlk zzg = zzh.zzg();
        if (((Boolean) zzbht.zzc.zze()).booleanValue()) {
            zzfmz zzf = zzg.zzf();
            zzf.zzh(8);
            zzf.zzb(zzlVar.zzp);
            zzfmzVar = zzf;
        } else {
            zzfmzVar = null;
        }
        this.zzb.zzx().zzc(1);
        zzgey zzgeyVar = zzcep.zza;
        zzhhl.zzb(zzgeyVar);
        ScheduledExecutorService zzC = this.zzb.zzC();
        zzcxp zza = zzg.zza();
        zzcww zzcwwVar = new zzcww(zzgeyVar, zzC, zza.zzi(zza.zzj()));
        this.zzf = zzcwwVar;
        zzcwwVar.zze(new zzera(this, zzeqtVar, zzfmzVar, zzb, zzg));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzf() {
        this.zzd.zza().zzbK(zzfij.zzd(4, null, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzg() {
        this.zzd.zza().zzbK(zzfij.zzd(6, null, null));
    }
}
