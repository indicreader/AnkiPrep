package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbgy extends zzayg implements zzbha {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbgy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zze(zzbgx zzbgxVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, zzbgxVar);
        zzbm(1, zza);
    }
}
