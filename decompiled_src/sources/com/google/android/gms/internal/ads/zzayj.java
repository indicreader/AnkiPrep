package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzayj extends zzayg implements zzayl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzayj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.clearcut.IClearcut");
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void zze(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, iObjectWrapper);
        zza.writeString("GMA_SDK");
        zzbm(2, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void zzf() throws RemoteException {
        zzbm(3, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void zzg(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzbm(7, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void zzh(int[] iArr) throws RemoteException {
        Parcel zza = zza();
        zza.writeIntArray(null);
        zzbm(4, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void zzi(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(0);
        zzbm(6, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void zzj(byte[] bArr) throws RemoteException {
        Parcel zza = zza();
        zza.writeByteArray(bArr);
        zzbm(5, zza);
    }
}
