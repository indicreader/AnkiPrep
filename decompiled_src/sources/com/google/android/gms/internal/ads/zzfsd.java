package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfsd extends zzayg implements IInterface {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfsd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzfsb zze(zzfrz zzfrzVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzd(zza, zzfrzVar);
        Parcel zzbl = zzbl(1, zza);
        zzfsb zzfsbVar = (zzfsb) zzayi.zza(zzbl, zzfsb.CREATOR);
        zzbl.recycle();
        return zzfsbVar;
    }

    public final zzfsk zzf(zzfsi zzfsiVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzd(zza, zzfsiVar);
        Parcel zzbl = zzbl(3, zza);
        zzfsk zzfskVar = (zzfsk) zzayi.zza(zzbl, zzfsk.CREATOR);
        zzbl.recycle();
        return zzfskVar;
    }

    public final void zzg(zzfrw zzfrwVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzd(zza, zzfrwVar);
        zzbm(2, zza);
    }
}
