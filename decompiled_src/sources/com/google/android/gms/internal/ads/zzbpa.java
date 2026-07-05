package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbpa implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzceu zza;
    final /* synthetic */ zzbpc zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbpa(zzbpc zzbpcVar, zzceu zzceuVar) {
        this.zza = zzceuVar;
        this.zzb = zzbpcVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzbop zzbopVar;
        try {
            zzceu zzceuVar = this.zza;
            zzbopVar = this.zzb.zza;
            zzceuVar.zzc(zzbopVar.zzp());
        } catch (DeadObjectException e) {
            this.zza.zzd(e);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        this.zza.zzd(new RuntimeException("onConnectionSuspended: " + i));
    }
}
