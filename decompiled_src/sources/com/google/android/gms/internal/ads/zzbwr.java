package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbwr extends zzayg implements zzbwt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbwr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final boolean zzH() throws RemoteException {
        Parcel zzbl = zzbl(11, zza());
        boolean zzg = zzayi.zzg(zzbl);
        zzbl.recycle();
        return zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzh(int i, int i2, Intent intent) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeInt(i2);
        zzayi.zzd(zza, intent);
        zzbm(12, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzi() throws RemoteException {
        zzbm(10, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, iObjectWrapper);
        zzbm(13, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzl(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzd(zza, bundle);
        zzbm(1, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzm() throws RemoteException {
        zzbm(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzo() throws RemoteException {
        zzbm(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzp(int i, String[] strArr, int[] iArr) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeStringArray(strArr);
        zza.writeIntArray(iArr);
        zzbm(15, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzq() throws RemoteException {
        zzbm(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzr() throws RemoteException {
        zzbm(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzs(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzd(zza, bundle);
        Parcel zzbl = zzbl(6, zza);
        if (zzbl.readInt() != 0) {
            bundle.readFromParcel(zzbl);
        }
        zzbl.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzt() throws RemoteException {
        zzbm(3, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzu() throws RemoteException {
        zzbm(7, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzv() throws RemoteException {
        zzbm(14, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzx() throws RemoteException {
        zzbm(9, zza());
    }
}
