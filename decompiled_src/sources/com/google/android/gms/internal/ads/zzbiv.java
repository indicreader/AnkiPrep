package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbiv extends zzayg implements IInterface {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbiv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.flags.IFlagRetrieverSupplierProxy");
    }

    public final void zze(zzbyd zzbydVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, zzbydVar);
        zzbm(1, zza);
    }
}
