package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzbyt extends zzayh implements zzbyu {
    public zzbyt() {
        super("com.google.android.gms.ads.internal.request.IAdsService");
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    protected final boolean zzbO(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbyx zzbyxVar = null;
        if (i == 1) {
            zzbyi zzbyiVar = (zzbyi) zzayi.zza(parcel, zzbyi.CREATOR);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                zzbyxVar = queryLocalInterface instanceof zzbyx ? (zzbyx) queryLocalInterface : new zzbyv(readStrongBinder);
            }
            zzayi.zzc(parcel);
            zzf(zzbyiVar, zzbyxVar);
        } else if (i == 2) {
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            if (readStrongBinder2 != null) {
                IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                if (queryLocalInterface2 instanceof zzbyx) {
                }
            }
            zzayi.zzc(parcel);
        } else {
            if (i != 3) {
                return false;
            }
            zzbym zzbymVar = (zzbym) zzayi.zza(parcel, zzbym.CREATOR);
            IBinder readStrongBinder3 = parcel.readStrongBinder();
            if (readStrongBinder3 != null) {
                IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                zzbyxVar = queryLocalInterface3 instanceof zzbyx ? (zzbyx) queryLocalInterface3 : new zzbyv(readStrongBinder3);
            }
            zzayi.zzc(parcel);
            zze(zzbymVar, zzbyxVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
