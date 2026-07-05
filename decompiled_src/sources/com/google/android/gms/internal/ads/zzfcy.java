package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfcy implements zzequ {
    private final Context zza;
    private final Executor zzb;
    private final zzclg zzc;
    private final zzeqe zzd;
    private final zzeqi zze;
    private final ViewGroup zzf;
    private zzbha zzg;
    private final zzddm zzh;
    private final zzfnc zzi;
    private final zzdft zzj;
    private final zzfhf zzk;
    private ListenableFuture zzl;

    public zzfcy(Context context, Executor executor, com.google.android.gms.ads.internal.client.zzq zzqVar, zzclg zzclgVar, zzeqe zzeqeVar, zzeqi zzeqiVar, zzfhf zzfhfVar, zzdft zzdftVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzclgVar;
        this.zzd = zzeqeVar;
        this.zze = zzeqiVar;
        this.zzk = zzfhfVar;
        this.zzh = zzclgVar.zzf();
        this.zzi = zzclgVar.zzz();
        this.zzf = new FrameLayout(context);
        this.zzj = zzdftVar;
        zzfhfVar.zzr(zzqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzequ
    public final boolean zza() {
        ListenableFuture listenableFuture = this.zzl;
        return (listenableFuture == null || listenableFuture.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzequ
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzeqs zzeqsVar, zzeqt zzeqtVar) throws RemoteException {
        zzcvc zzh;
        zzfmz zzfmzVar;
        if (str == null) {
            zzcec.zzg("Ad unit ID should not be null for banner ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfcu
                @Override // java.lang.Runnable
                public final void run() {
                    zzfcy.this.zzm();
                }
            });
            return false;
        }
        if (!zza()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziN)).booleanValue() && zzlVar.zzf) {
                this.zzc.zzk().zzn(true);
            }
            zzfhf zzfhfVar = this.zzk;
            zzfhfVar.zzs(str);
            zzfhfVar.zzE(zzlVar);
            Context context = this.zza;
            zzfhh zzG = zzfhfVar.zzG();
            zzfmo zzb = zzfmn.zzb(context, zzfmy.zzf(zzG), 3, zzlVar);
            if (!((Boolean) zzbig.zze.zze()).booleanValue() || !this.zzk.zzg().zzk) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhZ)).booleanValue()) {
                    zzcvb zze = this.zzc.zze();
                    zzdaf zzdafVar = new zzdaf();
                    zzdafVar.zze(this.zza);
                    zzdafVar.zzi(zzG);
                    zze.zzi(zzdafVar.zzj());
                    zzdgm zzdgmVar = new zzdgm();
                    zzdgmVar.zzj(this.zzd, this.zzb);
                    zzdgmVar.zzk(this.zzd, this.zzb);
                    zze.zzf(zzdgmVar.zzn());
                    zze.zze(new zzeon(this.zzg));
                    zze.zzd(new zzdlf(zzdnl.zza, null));
                    zze.zzg(new zzcvz(this.zzh, this.zzj));
                    zze.zzc(new zzcuc(this.zzf));
                    zzh = zze.zzh();
                } else {
                    zzcvb zze2 = this.zzc.zze();
                    zzdaf zzdafVar2 = new zzdaf();
                    zzdafVar2.zze(this.zza);
                    zzdafVar2.zzi(zzG);
                    zze2.zzi(zzdafVar2.zzj());
                    zzdgm zzdgmVar2 = new zzdgm();
                    zzdgmVar2.zzj(this.zzd, this.zzb);
                    zzdgmVar2.zza(this.zzd, this.zzb);
                    zzdgmVar2.zza(this.zze, this.zzb);
                    zzdgmVar2.zzl(this.zzd, this.zzb);
                    zzdgmVar2.zzd(this.zzd, this.zzb);
                    zzdgmVar2.zze(this.zzd, this.zzb);
                    zzdgmVar2.zzf(this.zzd, this.zzb);
                    zzdgmVar2.zzb(this.zzd, this.zzb);
                    zzdgmVar2.zzk(this.zzd, this.zzb);
                    zzdgmVar2.zzi(this.zzd, this.zzb);
                    zze2.zzf(zzdgmVar2.zzn());
                    zze2.zze(new zzeon(this.zzg));
                    zze2.zzd(new zzdlf(zzdnl.zza, null));
                    zze2.zzg(new zzcvz(this.zzh, this.zzj));
                    zze2.zzc(new zzcuc(this.zzf));
                    zzh = zze2.zzh();
                }
                zzcvc zzcvcVar = zzh;
                if (((Boolean) zzbht.zzc.zze()).booleanValue()) {
                    zzfmz zzj = zzcvcVar.zzj();
                    zzj.zzh(3);
                    zzj.zzb(zzlVar.zzp);
                    zzfmzVar = zzj;
                } else {
                    zzfmzVar = null;
                }
                zzcxp zzd = zzcvcVar.zzd();
                ListenableFuture zzi = zzd.zzi(zzd.zzj());
                this.zzl = zzi;
                zzgen.zzr(zzi, new zzfcx(this, zzeqtVar, zzfmzVar, zzb, zzcvcVar), this.zzb);
                return true;
            }
            zzeqe zzeqeVar = this.zzd;
            if (zzeqeVar != null) {
                zzeqeVar.zzbK(zzfij.zzd(7, null, null));
            }
        }
        return false;
    }

    public final ViewGroup zzd() {
        return this.zzf;
    }

    public final zzfhf zzi() {
        return this.zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzm() {
        this.zzd.zzbK(zzfij.zzd(6, null, null));
    }

    public final void zzn() {
        this.zzh.zzd(this.zzj.zzc());
    }

    public final void zzo(com.google.android.gms.ads.internal.client.zzbe zzbeVar) {
        this.zze.zza(zzbeVar);
    }

    public final void zzp(zzddn zzddnVar) {
        this.zzh.zzo(zzddnVar, this.zzb);
    }

    public final void zzq(zzbha zzbhaVar) {
        this.zzg = zzbhaVar;
    }

    public final boolean zzr() {
        Object parent = this.zzf.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        com.google.android.gms.ads.internal.zzt.zzp();
        return com.google.android.gms.ads.internal.util.zzt.zzV(view, view.getContext());
    }
}
