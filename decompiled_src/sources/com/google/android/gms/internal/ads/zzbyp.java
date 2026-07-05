package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzbyp extends zzayh implements zzbyq {
    public zzbyp() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    protected final boolean zzbO(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbza zzbzaVar = null;
        if (i == 1) {
            zzayi.zzc(parcel);
            parcel2.writeNoException();
            zzayi.zze(parcel2, null);
        } else if (i == 2) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                if (queryLocalInterface instanceof zzbyr) {
                }
            }
            zzayi.zzc(parcel);
            parcel2.writeNoException();
        } else if (i == 4) {
            zzbze zzbzeVar = (zzbze) zzayi.zza(parcel, zzbze.CREATOR);
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            if (readStrongBinder2 != null) {
                IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                zzbzaVar = queryLocalInterface2 instanceof zzbza ? (zzbza) queryLocalInterface2 : new zzbyy(readStrongBinder2);
            }
            zzayi.zzc(parcel);
            zzg(zzbzeVar, zzbzaVar);
            parcel2.writeNoException();
        } else if (i == 5) {
            zzbze zzbzeVar2 = (zzbze) zzayi.zza(parcel, zzbze.CREATOR);
            IBinder readStrongBinder3 = parcel.readStrongBinder();
            if (readStrongBinder3 != null) {
                IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                zzbzaVar = queryLocalInterface3 instanceof zzbza ? (zzbza) queryLocalInterface3 : new zzbyy(readStrongBinder3);
            }
            zzayi.zzc(parcel);
            zzf(zzbzeVar2, zzbzaVar);
            parcel2.writeNoException();
        } else if (i == 6) {
            zzbze zzbzeVar3 = (zzbze) zzayi.zza(parcel, zzbze.CREATOR);
            IBinder readStrongBinder4 = parcel.readStrongBinder();
            if (readStrongBinder4 != null) {
                IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                zzbzaVar = queryLocalInterface4 instanceof zzbza ? (zzbza) queryLocalInterface4 : new zzbyy(readStrongBinder4);
            }
            zzayi.zzc(parcel);
            zze(zzbzeVar3, zzbzaVar);
            parcel2.writeNoException();
        } else {
            if (i != 7) {
                return false;
            }
            String readString = parcel.readString();
            IBinder readStrongBinder5 = parcel.readStrongBinder();
            if (readStrongBinder5 != null) {
                IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                zzbzaVar = queryLocalInterface5 instanceof zzbza ? (zzbza) queryLocalInterface5 : new zzbyy(readStrongBinder5);
            }
            zzayi.zzc(parcel);
            zzh(readString, zzbzaVar);
            parcel2.writeNoException();
        }
        return true;
    }
}
