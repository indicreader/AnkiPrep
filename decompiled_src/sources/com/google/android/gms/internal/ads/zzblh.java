package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzblh extends zzayg implements zzblj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzblh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final void zzA() throws RemoteException {
        zzbm(28, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final void zzB(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzd(zza, bundle);
        zzbm(17, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final void zzC() throws RemoteException {
        zzbm(27, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final void zzD(com.google.android.gms.ads.internal.client.zzcs zzcsVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, zzcsVar);
        zzbm(26, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final void zzE(com.google.android.gms.ads.internal.client.zzdg zzdgVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, zzdgVar);
        zzbm(32, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final void zzF(zzblg zzblgVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, zzblgVar);
        zzbm(21, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final boolean zzG() throws RemoteException {
        Parcel zzbl = zzbl(30, zza());
        boolean zzg = zzayi.zzg(zzbl);
        zzbl.recycle();
        return zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final boolean zzH() throws RemoteException {
        Parcel zzbl = zzbl(24, zza());
        boolean zzg = zzayi.zzg(zzbl);
        zzbl.recycle();
        return zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final boolean zzI(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzd(zza, bundle);
        Parcel zzbl = zzbl(16, zza);
        boolean zzg = zzayi.zzg(zzbl);
        zzbl.recycle();
        return zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final double zze() throws RemoteException {
        Parcel zzbl = zzbl(8, zza());
        double readDouble = zzbl.readDouble();
        zzbl.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final Bundle zzf() throws RemoteException {
        Parcel zzbl = zzbl(20, zza());
        Bundle bundle = (Bundle) zzayi.zza(zzbl, Bundle.CREATOR);
        zzbl.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final com.google.android.gms.ads.internal.client.zzdn zzg() throws RemoteException {
        Parcel zzbl = zzbl(31, zza());
        com.google.android.gms.ads.internal.client.zzdn zzb = com.google.android.gms.ads.internal.client.zzdm.zzb(zzbl.readStrongBinder());
        zzbl.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final com.google.android.gms.ads.internal.client.zzdq zzh() throws RemoteException {
        Parcel zzbl = zzbl(11, zza());
        com.google.android.gms.ads.internal.client.zzdq zzb = com.google.android.gms.ads.internal.client.zzdp.zzb(zzbl.readStrongBinder());
        zzbl.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final zzbjf zzi() throws RemoteException {
        zzbjf zzbjdVar;
        Parcel zzbl = zzbl(14, zza());
        IBinder readStrongBinder = zzbl.readStrongBinder();
        if (readStrongBinder == null) {
            zzbjdVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            zzbjdVar = queryLocalInterface instanceof zzbjf ? (zzbjf) queryLocalInterface : new zzbjd(readStrongBinder);
        }
        zzbl.recycle();
        return zzbjdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final zzbjj zzj() throws RemoteException {
        zzbjj zzbjhVar;
        Parcel zzbl = zzbl(29, zza());
        IBinder readStrongBinder = zzbl.readStrongBinder();
        if (readStrongBinder == null) {
            zzbjhVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
            zzbjhVar = queryLocalInterface instanceof zzbjj ? (zzbjj) queryLocalInterface : new zzbjh(readStrongBinder);
        }
        zzbl.recycle();
        return zzbjhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final zzbjm zzk() throws RemoteException {
        zzbjm zzbjkVar;
        Parcel zzbl = zzbl(5, zza());
        IBinder readStrongBinder = zzbl.readStrongBinder();
        if (readStrongBinder == null) {
            zzbjkVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            zzbjkVar = queryLocalInterface instanceof zzbjm ? (zzbjm) queryLocalInterface : new zzbjk(readStrongBinder);
        }
        zzbl.recycle();
        return zzbjkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final IObjectWrapper zzl() throws RemoteException {
        Parcel zzbl = zzbl(19, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbl.readStrongBinder());
        zzbl.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final IObjectWrapper zzm() throws RemoteException {
        Parcel zzbl = zzbl(18, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbl.readStrongBinder());
        zzbl.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final String zzn() throws RemoteException {
        Parcel zzbl = zzbl(7, zza());
        String readString = zzbl.readString();
        zzbl.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final String zzo() throws RemoteException {
        Parcel zzbl = zzbl(4, zza());
        String readString = zzbl.readString();
        zzbl.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final String zzp() throws RemoteException {
        Parcel zzbl = zzbl(6, zza());
        String readString = zzbl.readString();
        zzbl.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final String zzq() throws RemoteException {
        Parcel zzbl = zzbl(2, zza());
        String readString = zzbl.readString();
        zzbl.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final String zzr() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final String zzs() throws RemoteException {
        Parcel zzbl = zzbl(10, zza());
        String readString = zzbl.readString();
        zzbl.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final String zzt() throws RemoteException {
        Parcel zzbl = zzbl(9, zza());
        String readString = zzbl.readString();
        zzbl.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final List zzu() throws RemoteException {
        Parcel zzbl = zzbl(3, zza());
        ArrayList zzb = zzayi.zzb(zzbl);
        zzbl.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final List zzv() throws RemoteException {
        Parcel zzbl = zzbl(23, zza());
        ArrayList zzb = zzayi.zzb(zzbl);
        zzbl.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final void zzw() throws RemoteException {
        zzbm(22, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final void zzx() throws RemoteException {
        zzbm(13, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final void zzy(com.google.android.gms.ads.internal.client.zzcw zzcwVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, zzcwVar);
        zzbm(25, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final void zzz(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzd(zza, bundle);
        zzbm(15, zza);
    }
}
