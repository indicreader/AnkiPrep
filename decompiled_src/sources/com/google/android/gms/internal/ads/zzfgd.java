package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfgd extends zzcam {
    private final zzffz zza;
    private final zzffp zzb;
    private final String zzc;
    private final zzfgz zzd;
    private final Context zze;
    private final zzcei zzf;
    private final zzavi zzg;
    private final zzdwf zzh;
    private zzdso zzi;
    private boolean zzj = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaD)).booleanValue();

    public zzfgd(String str, zzffz zzffzVar, Context context, zzffp zzffpVar, zzfgz zzfgzVar, zzcei zzceiVar, zzavi zzaviVar, zzdwf zzdwfVar) {
        this.zzc = str;
        this.zza = zzffzVar;
        this.zzb = zzffpVar;
        this.zzd = zzfgzVar;
        this.zze = context;
        this.zzf = zzceiVar;
        this.zzg = zzaviVar;
        this.zzh = zzdwfVar;
    }

    private final synchronized void zzu(com.google.android.gms.ads.internal.client.zzl zzlVar, zzcau zzcauVar, int i) throws RemoteException {
        boolean z = false;
        if (((Boolean) zzbhy.zzl.zze()).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkG)).booleanValue()) {
                z = true;
            }
        }
        if (this.zzf.zzc < ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkH)).intValue() || !z) {
            Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        }
        this.zzb.zzk(zzcauVar);
        com.google.android.gms.ads.internal.zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzG(this.zze) && zzlVar.zzs == null) {
            zzcec.zzg("Failed to load the ad because app ID is missing.");
            this.zzb.zzbK(zzfij.zzd(4, null, null));
            return;
        }
        if (this.zzi != null) {
            return;
        }
        zzffr zzffrVar = new zzffr(null);
        this.zza.zzj(i);
        this.zza.zzb(zzlVar, this.zzc, zzffrVar, new zzfgc(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final Bundle zzb() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdso zzdsoVar = this.zzi;
        return zzdsoVar != null ? zzdsoVar.zza() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final com.google.android.gms.ads.internal.client.zzdn zzc() {
        zzdso zzdsoVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgN)).booleanValue() && (zzdsoVar = this.zzi) != null) {
            return zzdsoVar.zzl();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final zzcak zzd() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdso zzdsoVar = this.zzi;
        if (zzdsoVar != null) {
            return zzdsoVar.zzc();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final synchronized String zze() throws RemoteException {
        zzdso zzdsoVar = this.zzi;
        if (zzdsoVar == null || zzdsoVar.zzl() == null) {
            return null;
        }
        return zzdsoVar.zzl().zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final synchronized void zzf(com.google.android.gms.ads.internal.client.zzl zzlVar, zzcau zzcauVar) throws RemoteException {
        zzu(zzlVar, zzcauVar, 2);
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final synchronized void zzg(com.google.android.gms.ads.internal.client.zzl zzlVar, zzcau zzcauVar) throws RemoteException {
        zzu(zzlVar, zzcauVar, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final synchronized void zzh(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzj = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzi(com.google.android.gms.ads.internal.client.zzdd zzddVar) {
        if (zzddVar == null) {
            this.zzb.zzg(null);
        } else {
            this.zzb.zzg(new zzfgb(this, zzddVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzj(com.google.android.gms.ads.internal.client.zzdg zzdgVar) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        try {
            if (!zzdgVar.zzf()) {
                this.zzh.zze();
            }
        } catch (RemoteException e) {
            zzcec.zzf("Error in making CSI ping for reporting paid event callback", e);
        }
        this.zzb.zzi(zzdgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzk(zzcaq zzcaqVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzj(zzcaqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final synchronized void zzl(zzcbb zzcbbVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzfgz zzfgzVar = this.zzd;
        zzfgzVar.zza = zzcbbVar.zza;
        zzfgzVar.zzb = zzcbbVar.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final synchronized void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzn(iObjectWrapper, this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final synchronized void zzn(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzi == null) {
            zzcec.zzj("Rewarded can not be shown before loaded");
            this.zzb.zzp(zzfij.zzd(9, null, null));
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcz)).booleanValue()) {
            this.zzg.zzc().zzn(new Throwable().getStackTrace());
        }
        this.zzi.zzh(z, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final boolean zzo() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdso zzdsoVar = this.zzi;
        return (zzdsoVar == null || zzdsoVar.zzf()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzp(zzcav zzcavVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzo(zzcavVar);
    }
}
