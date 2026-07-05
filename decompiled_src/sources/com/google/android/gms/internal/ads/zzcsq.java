package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcsq implements zzdax, zzdcl, zzdbr, com.google.android.gms.ads.internal.client.zza, zzdbn, zzdil {
    private final Context zza;
    private final Executor zzb;
    private final Executor zzc;
    private final ScheduledExecutorService zzd;
    private final zzfgy zze;
    private final zzfgm zzf;
    private final zzfnu zzg;
    private final zzfht zzh;
    private final zzavi zzi;
    private final zzbhj zzj;
    private final zzfmz zzk;
    private final WeakReference zzl;
    private final WeakReference zzm;
    private final zzczz zzn;
    private boolean zzo;
    private final AtomicBoolean zzp = new AtomicBoolean();
    private final zzbhl zzq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcsq(Context context, Executor executor, Executor executor2, ScheduledExecutorService scheduledExecutorService, zzfgy zzfgyVar, zzfgm zzfgmVar, zzfnu zzfnuVar, zzfht zzfhtVar, View view, zzcjk zzcjkVar, zzavi zzaviVar, zzbhj zzbhjVar, zzbhl zzbhlVar, zzfmz zzfmzVar, zzczz zzczzVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = executor2;
        this.zzd = scheduledExecutorService;
        this.zze = zzfgyVar;
        this.zzf = zzfgmVar;
        this.zzg = zzfnuVar;
        this.zzh = zzfhtVar;
        this.zzi = zzaviVar;
        this.zzl = new WeakReference(view);
        this.zzm = new WeakReference(zzcjkVar);
        this.zzj = zzbhjVar;
        this.zzq = zzbhlVar;
        this.zzk = zzfmzVar;
        this.zzn = zzczzVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzt() {
        String str;
        int i;
        List list;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzla)).booleanValue() && ((list = this.zzf.zzd) == null || list.isEmpty())) {
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdp)).booleanValue()) {
            str = this.zzi.zzc().zzh(this.zza, (View) this.zzl.get(), null);
        } else {
            str = null;
        }
        if ((!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzan)).booleanValue() || !this.zze.zzb.zzb.zzg) && ((Boolean) zzbhz.zzh.zze()).booleanValue()) {
            if (((Boolean) zzbhz.zzg.zze()).booleanValue() && ((i = this.zzf.zzb) == 1 || i == 2 || i == 5)) {
            }
            zzgen.zzr((zzgee) zzgen.zzo(zzgee.zzu(zzgen.zzh(null)), ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaV)).longValue(), TimeUnit.MILLISECONDS, this.zzd), new zzcsp(this, str), this.zzb);
            return;
        }
        zzfht zzfhtVar = this.zzh;
        zzfnu zzfnuVar = this.zzg;
        zzfgy zzfgyVar = this.zze;
        zzfgm zzfgmVar = this.zzf;
        zzfhtVar.zza(zzfnuVar.zzd(zzfgyVar, zzfgmVar, false, str, null, zzfgmVar.zzd));
    }

    private final void zzu(final int i, final int i2) {
        View view;
        if (i > 0 && ((view = (View) this.zzl.get()) == null || view.getHeight() == 0 || view.getWidth() == 0)) {
            this.zzd.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcsn
                @Override // java.lang.Runnable
                public final void run() {
                    zzcsq.this.zzo(i, i2);
                }
            }, i2, TimeUnit.MILLISECONDS);
        } else {
            zzt();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        if ((!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzan)).booleanValue() || !this.zze.zzb.zzb.zzg) && ((Boolean) zzbhz.zzd.zze()).booleanValue()) {
            zzgen.zzr(zzgen.zze(zzgee.zzu(this.zzj.zza()), Throwable.class, new zzfws() { // from class: com.google.android.gms.internal.ads.zzcsk
                @Override // com.google.android.gms.internal.ads.zzfws
                public final Object apply(Object obj) {
                    return "failure_click_attok";
                }
            }, zzcep.zzf), new zzcso(this), this.zzb);
            return;
        }
        zzfht zzfhtVar = this.zzh;
        zzfnu zzfnuVar = this.zzg;
        zzfgy zzfgyVar = this.zze;
        zzfgm zzfgmVar = this.zzf;
        zzfhtVar.zzc(zzfnuVar.zzc(zzfgyVar, zzfgmVar, zzfgmVar.zzc), true == com.google.android.gms.ads.internal.zzt.zzo().zzz(this.zza) ? 2 : 1);
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zza() {
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzb() {
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzbB(zzbzu zzbzuVar, String str, String str2) {
        zzfnu zzfnuVar = this.zzg;
        zzfgm zzfgmVar = this.zzf;
        this.zzh.zza(zzfnuVar.zze(zzfgmVar, zzfgmVar.zzi, zzbzuVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzc() {
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zze() {
        zzfnu zzfnuVar = this.zzg;
        zzfgy zzfgyVar = this.zze;
        zzfgm zzfgmVar = this.zzf;
        this.zzh.zza(zzfnuVar.zzc(zzfgyVar, zzfgmVar, zzfgmVar.zzj));
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzf() {
        zzfnu zzfnuVar = this.zzg;
        zzfgy zzfgyVar = this.zze;
        zzfgm zzfgmVar = this.zzf;
        this.zzh.zza(zzfnuVar.zzc(zzfgyVar, zzfgmVar, zzfgmVar.zzh));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzm() {
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcsm
            @Override // java.lang.Runnable
            public final void run() {
                zzcsq.this.zzt();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(int i, int i2) {
        zzu(i - 1, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(final int i, final int i2) {
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcsl
            @Override // java.lang.Runnable
            public final void run() {
                zzcsq.this.zzn(i, i2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdbn
    public final void zzp(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbv)).booleanValue()) {
            this.zzh.zza(this.zzg.zzc(this.zze, this.zzf, zzfnu.zzf(2, zzeVar.zza, this.zzf.zzp)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbr
    public final void zzq() {
        if (this.zzp.compareAndSet(false, true)) {
            int intValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdy)).intValue();
            if (intValue > 0) {
                zzu(intValue, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdz)).intValue());
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdx)).booleanValue()) {
                this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcsj
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcsq.this.zzm();
                    }
                });
            } else {
                zzt();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcl
    public final synchronized void zzr() {
        zzczz zzczzVar;
        if (this.zzo) {
            ArrayList arrayList = new ArrayList(this.zzf.zzd);
            arrayList.addAll(this.zzf.zzg);
            this.zzh.zza(this.zzg.zzd(this.zze, this.zzf, true, null, null, arrayList));
        } else {
            zzfht zzfhtVar = this.zzh;
            zzfnu zzfnuVar = this.zzg;
            zzfgy zzfgyVar = this.zze;
            zzfgm zzfgmVar = this.zzf;
            zzfhtVar.zza(zzfnuVar.zzc(zzfgyVar, zzfgmVar, zzfgmVar.zzn));
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdu)).booleanValue() && (zzczzVar = this.zzn) != null) {
                List zzh = zzfnu.zzh(zzfnu.zzg(zzczzVar.zzb().zzn, zzczzVar.zza().zzg()), this.zzn.zza().zza());
                zzfht zzfhtVar2 = this.zzh;
                zzfnu zzfnuVar2 = this.zzg;
                zzczz zzczzVar2 = this.zzn;
                zzfhtVar2.zza(zzfnuVar2.zzc(zzczzVar2.zzc(), zzczzVar2.zzb(), zzh));
            }
            zzfht zzfhtVar3 = this.zzh;
            zzfnu zzfnuVar3 = this.zzg;
            zzfgy zzfgyVar2 = this.zze;
            zzfgm zzfgmVar2 = this.zzf;
            zzfhtVar3.zza(zzfnuVar3.zzc(zzfgyVar2, zzfgmVar2, zzfgmVar2.zzg));
        }
        this.zzo = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdil
    public final void zzs() {
        zzfnu zzfnuVar = this.zzg;
        zzfgy zzfgyVar = this.zze;
        zzfgm zzfgmVar = this.zzf;
        this.zzh.zza(zzfnuVar.zzc(zzfgyVar, zzfgmVar, zzfgmVar.zzau));
    }
}
