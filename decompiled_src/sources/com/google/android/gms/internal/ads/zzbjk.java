package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbjk extends zzayg implements zzbjm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbjk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final double zzb() throws RemoteException {
        Parcel zzbl = zzbl(3, zza());
        double readDouble = zzbl.readDouble();
        zzbl.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final int zzc() throws RemoteException {
        Parcel zzbl = zzbl(5, zza());
        int readInt = zzbl.readInt();
        zzbl.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final int zzd() throws RemoteException {
        Parcel zzbl = zzbl(4, zza());
        int readInt = zzbl.readInt();
        zzbl.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final Uri zze() throws RemoteException {
        Parcel zzbl = zzbl(2, zza());
        Uri uri = (Uri) zzayi.zza(zzbl, Uri.CREATOR);
        zzbl.recycle();
        return uri;
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final IObjectWrapper zzf() throws RemoteException {
        Parcel zzbl = zzbl(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbl.readStrongBinder());
        zzbl.recycle();
        return asInterface;
    }
}
