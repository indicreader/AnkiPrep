package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbjo extends zzayg implements zzbjq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbjo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzbjq
    public final IObjectWrapper zzb(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzbl = zzbl(2, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbl.readStrongBinder());
        zzbl.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbjq
    public final void zzbE(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzayi.zzf(zza, iObjectWrapper);
        zzbm(1, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbjq
    public final void zzbF(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, iObjectWrapper);
        zzbm(6, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbjq
    public final void zzbG(zzbjj zzbjjVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, zzbjjVar);
        zzbm(8, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbjq
    public final void zzbH(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, iObjectWrapper);
        zzbm(9, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbjq
    public final void zzbI(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, iObjectWrapper);
        zzbm(3, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbjq
    public final void zzc() throws RemoteException {
        zzbm(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbjq
    public final void zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, iObjectWrapper);
        zzbm(7, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbjq
    public final void zze(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, iObjectWrapper);
        zza.writeInt(i);
        zzbm(5, zza);
    }
}
