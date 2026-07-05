package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzccr extends zzayg implements zzcct {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzccr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, iObjectWrapper);
        zzayi.zzf(zza, iObjectWrapper2);
        zza.writeString(str);
        zzayi.zzf(zza, iObjectWrapper3);
        Parcel zzbl = zzbl(11, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbl.readStrongBinder());
        zzbl.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzf(IObjectWrapper iObjectWrapper, zzccx zzccxVar, zzccq zzccqVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, iObjectWrapper);
        zzayi.zzd(zza, zzccxVar);
        zzayi.zzf(zza, zzccqVar);
        zzbm(1, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzg(zzbxr zzbxrVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzd(zza, zzbxrVar);
        zzbm(7, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbxi zzbxiVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzayi.zzf(zza, iObjectWrapper);
        zzayi.zzf(zza, zzbxiVar);
        zzbm(10, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzi(List list, IObjectWrapper iObjectWrapper, zzbxi zzbxiVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzayi.zzf(zza, iObjectWrapper);
        zzayi.zzf(zza, zzbxiVar);
        zzbm(9, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, iObjectWrapper);
        zzbm(8, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, iObjectWrapper);
        zzbm(2, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbxi zzbxiVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzayi.zzf(zza, iObjectWrapper);
        zzayi.zzf(zza, zzbxiVar);
        zzbm(6, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzm(List list, IObjectWrapper iObjectWrapper, zzbxi zzbxiVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzayi.zzf(zza, iObjectWrapper);
        zzayi.zzf(zza, zzbxiVar);
        zzbm(5, zza);
    }
}
