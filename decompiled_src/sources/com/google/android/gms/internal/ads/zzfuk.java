package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfuk extends zzayg implements zzfum {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfuk(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.lmd.protocol.ILmdOverlayService");
    }

    @Override // com.google.android.gms.internal.ads.zzfum
    public final void zze(Bundle bundle, zzfuo zzfuoVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzd(zza, bundle);
        zzayi.zzf(zza, zzfuoVar);
        zzbn(2, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfum
    public final void zzf(String str, Bundle bundle, zzfuo zzfuoVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzayi.zzd(zza, bundle);
        zzayi.zzf(zza, zzfuoVar);
        zzbn(1, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfum
    public final void zzg(Bundle bundle, zzfuo zzfuoVar) throws RemoteException {
        Parcel zza = zza();
        zzayi.zzd(zza, bundle);
        zzayi.zzf(zza, zzfuoVar);
        zzbn(3, zza);
    }
}
