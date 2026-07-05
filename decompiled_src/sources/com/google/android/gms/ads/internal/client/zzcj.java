package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayg;
import com.google.android.gms.internal.ads.zzayi;
import com.google.android.gms.internal.ads.zzbsu;
import com.google.android.gms.internal.ads.zzbsv;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcj extends zzayg implements zzcl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }

    @Override // com.google.android.gms.ads.internal.client.zzcl
    public final zzbsv getAdapterCreator() throws RemoteException {
        Parcel zzbl = zzbl(2, zza());
        zzbsv zzf = zzbsu.zzf(zzbl.readStrongBinder());
        zzbl.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcl
    public final zzen getLiteSdkVersion() throws RemoteException {
        Parcel zzbl = zzbl(1, zza());
        zzen zzenVar = (zzen) zzayi.zza(zzbl, zzen.CREATOR);
        zzbl.recycle();
        return zzenVar;
    }
}
