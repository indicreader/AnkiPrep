package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzelm extends zzbul {
    final /* synthetic */ zzeln zza;
    private final zzeiq zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzelm(zzeln zzelnVar, zzeiq zzeiqVar, zzell zzellVar) {
        this.zza = zzelnVar;
        this.zzb = zzeiqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbum
    public final void zze(String str) throws RemoteException {
        ((zzekj) this.zzb.zzc).zzi(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbum
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        ((zzekj) this.zzb.zzc).zzh(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbum
    public final void zzg(zzbtk zzbtkVar) throws RemoteException {
        zzeln.zzc(this.zza, zzbtkVar);
        ((zzekj) this.zzb.zzc).zzo();
    }
}
