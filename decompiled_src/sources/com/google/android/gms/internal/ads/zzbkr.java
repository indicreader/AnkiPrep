package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbkr extends zzayg implements zzbkt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbkr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbkt
    public final void zze(zzbkg zzbkgVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzf(zza, zzbkgVar);
        zzbm(1, zza);
    }
}
