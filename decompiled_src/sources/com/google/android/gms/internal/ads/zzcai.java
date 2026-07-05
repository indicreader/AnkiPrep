package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcai extends zzayg implements zzcak {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcai(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    }

    @Override // com.google.android.gms.internal.ads.zzcak
    public final int zze() throws RemoteException {
        Parcel zzbl = zzbl(2, zza());
        int readInt = zzbl.readInt();
        zzbl.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.ads.zzcak
    public final String zzf() throws RemoteException {
        Parcel zzbl = zzbl(1, zza());
        String readString = zzbl.readString();
        zzbl.recycle();
        return readString;
    }
}
