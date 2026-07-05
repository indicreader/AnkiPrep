package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdso extends zzcwh {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzdkw zze;
    private final zzdhy zzf;
    private final zzdbk zzg;
    private final zzdcr zzh;
    private final zzcxc zzi;
    private final zzcak zzj;
    private final zzfrc zzk;
    private final zzfha zzl;
    private boolean zzm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdso(zzcwg zzcwgVar, Context context, zzcjk zzcjkVar, zzdkw zzdkwVar, zzdhy zzdhyVar, zzdbk zzdbkVar, zzdcr zzdcrVar, zzcxc zzcxcVar, zzfgm zzfgmVar, zzfrc zzfrcVar, zzfha zzfhaVar) {
        super(zzcwgVar);
        this.zzm = false;
        this.zzc = context;
        this.zze = zzdkwVar;
        this.zzd = new WeakReference(zzcjkVar);
        this.zzf = zzdhyVar;
        this.zzg = zzdbkVar;
        this.zzh = zzdcrVar;
        this.zzi = zzcxcVar;
        this.zzk = zzfrcVar;
        zzcag zzcagVar = zzfgmVar.zzm;
        this.zzj = new zzcbe(zzcagVar != null ? zzcagVar.zza : "", zzcagVar != null ? zzcagVar.zzb : 1);
        this.zzl = zzfhaVar;
    }

    public final void finalize() throws Throwable {
        try {
            final zzcjk zzcjkVar = (zzcjk) this.zzd.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgL)).booleanValue()) {
                if (!this.zzm && zzcjkVar != null) {
                    zzgey zzgeyVar = zzcep.zze;
                    Objects.requireNonNull(zzcjkVar);
                    zzgeyVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdsn
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzcjk.this.destroy();
                        }
                    });
                }
            } else if (zzcjkVar != null) {
                zzcjkVar.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final Bundle zza() {
        return this.zzh.zzb();
    }

    public final zzcak zzc() {
        return this.zzj;
    }

    public final zzfha zzd() {
        return this.zzl;
    }

    public final boolean zze() {
        return this.zzi.zzg();
    }

    public final boolean zzf() {
        return this.zzm;
    }

    public final boolean zzg() {
        zzcjk zzcjkVar = (zzcjk) this.zzd.get();
        return (zzcjkVar == null || zzcjkVar.zzaD()) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.content.Context] */
    public final boolean zzh(boolean z, Activity activity) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaB)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzp();
            if (com.google.android.gms.ads.internal.util.zzt.zzF(this.zzc)) {
                zzcec.zzj("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzg.zzb();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaC)).booleanValue()) {
                    this.zzk.zza(this.zza.zzb.zzb.zzb);
                }
                return false;
            }
        }
        if (this.zzm) {
            zzcec.zzj("The rewarded ad have been showed.");
            this.zzg.zza(zzfij.zzd(10, null, null));
            return false;
        }
        this.zzm = true;
        this.zzf.zzb();
        Activity activity2 = activity;
        if (activity == null) {
            activity2 = this.zzc;
        }
        try {
            this.zze.zza(z, activity2, this.zzg);
            this.zzf.zza();
            return true;
        } catch (zzdkv e) {
            this.zzg.zzc(e);
            return false;
        }
    }
}
