package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbub extends zzayg implements zzbud {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbub(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IAppOpenCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbud
    public final void zze(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString("Adapter returned null.");
        zzbm(3, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbud
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzd(zza, zzeVar);
        zzbm(4, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbud
    public final void zzg() throws RemoteException {
        zzbm(2, zza());
    }
}
