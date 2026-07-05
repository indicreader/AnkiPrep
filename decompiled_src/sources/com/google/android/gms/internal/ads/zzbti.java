package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbti extends zzayg implements zzbtk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbti(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final boolean zzA() throws RemoteException {
        Parcel zzbl = zzbl(18, zza());
        boolean zzg = zzayi.zzg(zzbl);
        zzbl.recycle();
        return zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final boolean zzB() throws RemoteException {
        Parcel zzbl = zzbl(17, zza());
        boolean zzg = zzayi.zzg(zzbl);
        zzbl.recycle();
        return zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final double zze() throws RemoteException {
        Parcel zzbl = zzbl(8, zza());
        double readDouble = zzbl.readDouble();
        zzbl.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final float zzf() throws RemoteException {
        Parcel zzbl = zzbl(23, zza());
        float readFloat = zzbl.readFloat();
        zzbl.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final float zzg() throws RemoteException {
        Parcel zzbl = zzbl(25, zza());
        float readFloat = zzbl.readFloat();
        zzbl.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final float zzh() throws RemoteException {
        Parcel zzbl = zzbl(24, zza());
        float readFloat = zzbl.readFloat();
        zzbl.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final Bundle zzi() throws RemoteException {
        Parcel zzbl = zzbl(16, zza());
        Bundle bundle = (Bundle) zzayi.zza(zzbl, Bundle.CREATOR);
        zzbl.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final com.google.android.gms.ads.internal.client.zzdq zzj() throws RemoteException {
        Parcel zzbl = zzbl(11, zza());
        com.google.android.gms.ads.internal.client.zzdq zzb = com.google.android.gms.ads.internal.client.zzdp.zzb(zzbl.readStrongBinder());
        zzbl.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final zzbjf zzk() throws RemoteException {
        Parcel zzbl = zzbl(12, zza());
        zzbjf zzj = zzbje.zzj(zzbl.readStrongBinder());
        zzbl.recycle();
        return zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final zzbjm zzl() throws RemoteException {
        Parcel zzbl = zzbl(5, zza());
        zzbjm zzg = zzbjl.zzg(zzbl.readStrongBinder());
        zzbl.recycle();
        return zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final IObjectWrapper zzm() throws RemoteException {
        Parcel zzbl = zzbl(13, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbl.readStrongBinder());
        zzbl.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final IObjectWrapper zzn() throws RemoteException {
        Parcel zzbl = zzbl(14, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbl.readStrongBinder());
        zzbl.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final IObjectWrapper zzo() throws RemoteException {
        Parcel zzbl = zzbl(15, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbl.readStrongBinder());
        zzbl.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final String zzp() throws RemoteException {
        Parcel zzbl = zzbl(7, zza());
        String readString = zzbl.readString();
        zzbl.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final String zzq() throws RemoteException {
        Parcel zzbl = zzbl(4, zza());
        String readString = zzbl.readString();
        zzbl.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final String zzr() throws RemoteException {
        Parcel zzbl = zzbl(6, zza());
        String readString = zzbl.readString();
        zzbl.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final String zzs() throws RemoteException {
        Parcel zzbl = zzbl(2, zza());
        String readString = zzbl.readString();
        zzbl.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final String zzt() throws RemoteException {
        Parcel zzbl = zzbl(10, zza());
        String readString = zzbl.readString();
        zzbl.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final String zzu() throws RemoteException {
        Parcel zzbl = zzbl(9, zza());
        String readString = zzbl.readString();
        zzbl.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final List zzv() throws RemoteException {
        Parcel zzbl = zzbl(3, zza());
        ArrayList zzb = zzayi.zzb(zzbl);
        zzbl.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, iObjectWrapper);
        zzbm(20, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zzx() throws RemoteException {
        zzbm(19, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zzy(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, iObjectWrapper);
        zzayi.zzf(zza, iObjectWrapper2);
        zzayi.zzf(zza, iObjectWrapper3);
        zzbm(21, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, iObjectWrapper);
        zzbm(22, zza);
    }
}
