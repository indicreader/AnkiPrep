package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbbd extends zzayg implements IInterface {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbbd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final long zze(zzbbb zzbbbVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzd(zza, zzbbbVar);
        Parcel zzbl = zzbl(3, zza);
        long readLong = zzbl.readLong();
        zzbl.recycle();
        return readLong;
    }

    public final zzbay zzf(zzbbb zzbbbVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzd(zza, zzbbbVar);
        Parcel zzbl = zzbl(1, zza);
        zzbay zzbayVar = (zzbay) zzayi.zza(zzbl, zzbay.CREATOR);
        zzbl.recycle();
        return zzbayVar;
    }

    public final zzbay zzg(zzbbb zzbbbVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzd(zza, zzbbbVar);
        Parcel zzbl = zzbl(2, zza);
        zzbay zzbayVar = (zzbay) zzayi.zza(zzbl, zzbay.CREATOR);
        zzbl.recycle();
        return zzbayVar;
    }
}
