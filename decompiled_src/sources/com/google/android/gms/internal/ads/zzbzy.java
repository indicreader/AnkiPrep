package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbzy extends zzayg implements zzcaa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbzy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzcaa
    public final void zze(zzbzu zzbzuVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, zzbzuVar);
        zzbm(5, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcaa
    public final void zzf() throws RemoteException {
        zzbm(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzcaa
    public final void zzg(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzbm(7, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcaa
    public final void zzh() throws RemoteException {
        zzbm(6, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzcaa
    public final void zzi() throws RemoteException {
        zzbm(1, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzcaa
    public final void zzj() throws RemoteException {
        zzbm(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzcaa
    public final void zzk() throws RemoteException {
        zzbm(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzcaa
    public final void zzl() throws RemoteException {
        zzbm(3, zza());
    }
}
