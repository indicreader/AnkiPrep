package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzemx extends zzbuo {
    private final zzeiq zza;

    @Override // com.google.android.gms.internal.ads.zzbup
    public final void zze(String str) throws RemoteException {
        ((zzekj) this.zza.zzc).zzi(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbup
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        ((zzekj) this.zza.zzc).zzh(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbup
    public final void zzg() throws RemoteException {
        ((zzekj) this.zza.zzc).zzo();
    }
}
