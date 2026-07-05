package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeqr {
    private final zzdnl zza;
    private final zzeqe zzb;
    private final zzdba zzc;

    public zzeqr(zzdnl zzdnlVar, zzflw zzflwVar) {
        this.zza = zzdnlVar;
        final zzeqe zzeqeVar = new zzeqe(zzflwVar);
        this.zzb = zzeqeVar;
        final zzbpy zzg = zzdnlVar.zzg();
        this.zzc = new zzdba() { // from class: com.google.android.gms.internal.ads.zzeqq
            @Override // com.google.android.gms.internal.ads.zzdba
            public final void zzbK(com.google.android.gms.ads.internal.client.zze zzeVar) {
                zzeqe.this.zzbK(zzeVar);
                zzbpy zzbpyVar = zzg;
                if (zzbpyVar != null) {
                    try {
                        zzbpyVar.zzf(zzeVar);
                    } catch (RemoteException e) {
                        zzcec.zzl("#007 Could not call remote method.", e);
                    }
                }
                if (zzbpyVar != null) {
                    try {
                        zzbpyVar.zze(zzeVar.zza);
                    } catch (RemoteException e2) {
                        zzcec.zzl("#007 Could not call remote method.", e2);
                    }
                }
            }
        };
    }

    public final zzdba zza() {
        return this.zzc;
    }

    public final zzdcl zzb() {
        return this.zzb;
    }

    public final zzdlf zzc() {
        return new zzdlf(this.zza, this.zzb.zzg());
    }

    public final zzeqe zzd() {
        return this.zzb;
    }

    public final void zze(com.google.android.gms.ads.internal.client.zzbh zzbhVar) {
        this.zzb.zzj(zzbhVar);
    }
}
