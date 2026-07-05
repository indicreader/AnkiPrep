package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbty extends zzbta {
    private final Adapter zza;
    private final zzcaf zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbty(Adapter adapter, zzcaf zzcafVar) {
        this.zza = adapter;
        this.zzb = zzcafVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zze() throws RemoteException {
        zzcaf zzcafVar = this.zzb;
        if (zzcafVar != null) {
            zzcafVar.zze(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzf() throws RemoteException {
        zzcaf zzcafVar = this.zzb;
        if (zzcafVar != null) {
            zzcafVar.zzf(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzg(int i) throws RemoteException {
        zzcaf zzcafVar = this.zzb;
        if (zzcafVar != null) {
            zzcafVar.zzg(ObjectWrapper.wrap(this.zza), i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzh(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzi(int i, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzj(int i) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzk(com.google.android.gms.ads.internal.client.zze zzeVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzl(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzm() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzn() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzo() throws RemoteException {
        zzcaf zzcafVar = this.zzb;
        if (zzcafVar != null) {
            zzcafVar.zzi(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzp() throws RemoteException {
        zzcaf zzcafVar = this.zzb;
        if (zzcafVar != null) {
            zzcafVar.zzj(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzq(String str, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzr(zzbkg zzbkgVar, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzs(zzcag zzcagVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzt(zzcak zzcakVar) throws RemoteException {
        zzcaf zzcafVar = this.zzb;
        if (zzcafVar != null) {
            zzcafVar.zzm(ObjectWrapper.wrap(this.zza), new zzcag(zzcakVar.zzf(), zzcakVar.zze()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzu() throws RemoteException {
        zzcaf zzcafVar = this.zzb;
        if (zzcafVar != null) {
            zzcafVar.zzn(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzv() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzw() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzx() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzy() throws RemoteException {
        zzcaf zzcafVar = this.zzb;
        if (zzcafVar != null) {
            zzcafVar.zzo(ObjectWrapper.wrap(this.zza));
        }
    }
}
