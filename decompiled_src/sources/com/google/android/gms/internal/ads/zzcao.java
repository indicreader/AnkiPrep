package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcao extends zzayg implements zzcaq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcao(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zze() throws RemoteException {
        zzbm(7, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzf() throws RemoteException {
        zzbm(6, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzg() throws RemoteException {
        zzbm(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzh(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzbm(4, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzi(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzd(zza, zzeVar);
        zzbm(5, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzj() throws RemoteException {
        zzbm(1, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzk(zzcak zzcakVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, zzcakVar);
        zzbm(3, zza);
    }
}
