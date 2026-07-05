package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcav extends zzayg implements IInterface {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcav(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
    }

    public final void zze(zzcak zzcakVar, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, zzcakVar);
        zza.writeString(str);
        zza.writeString(str2);
        zzbm(2, zza);
    }
}
