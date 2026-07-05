package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcal extends zzayg implements zzcan {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcal(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final Bundle zzb() throws RemoteException {
        Parcel zzbl = zzbl(9, zza());
        Bundle bundle = (Bundle) zzayi.zza(zzbl, Bundle.CREATOR);
        zzbl.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final com.google.android.gms.ads.internal.client.zzdn zzc() throws RemoteException {
        Parcel zzbl = zzbl(12, zza());
        com.google.android.gms.ads.internal.client.zzdn zzb = com.google.android.gms.ads.internal.client.zzdm.zzb(zzbl.readStrongBinder());
        zzbl.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final zzcak zzd() throws RemoteException {
        zzcak zzcaiVar;
        Parcel zzbl = zzbl(11, zza());
        IBinder readStrongBinder = zzbl.readStrongBinder();
        if (readStrongBinder == null) {
            zzcaiVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
            zzcaiVar = queryLocalInterface instanceof zzcak ? (zzcak) queryLocalInterface : new zzcai(readStrongBinder);
        }
        zzbl.recycle();
        return zzcaiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final String zze() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzf(com.google.android.gms.ads.internal.client.zzl zzlVar, zzcau zzcauVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzd(zza, zzlVar);
        zzayi.zzf(zza, zzcauVar);
        zzbm(1, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzg(com.google.android.gms.ads.internal.client.zzl zzlVar, zzcau zzcauVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzd(zza, zzlVar);
        zzayi.zzf(zza, zzcauVar);
        zzbm(14, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzh(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzayi.zza;
        zza.writeInt(z ? 1 : 0);
        zzbm(15, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzi(com.google.android.gms.ads.internal.client.zzdd zzddVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, zzddVar);
        zzbm(8, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzj(com.google.android.gms.ads.internal.client.zzdg zzdgVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, zzdgVar);
        zzbm(13, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzk(zzcaq zzcaqVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, zzcaqVar);
        zzbm(2, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzl(zzcbb zzcbbVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzd(zza, zzcbbVar);
        zzbm(7, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, iObjectWrapper);
        zzbm(5, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzn(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final boolean zzo() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzp(zzcav zzcavVar) throws RemoteException {
        throw null;
    }
}
