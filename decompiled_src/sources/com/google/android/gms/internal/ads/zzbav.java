package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbav implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzbax zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbav(zzbax zzbaxVar) {
        this.zza = zzbaxVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        Object obj;
        Object obj2;
        zzbba zzbbaVar;
        zzbba zzbbaVar2;
        obj = this.zza.zzc;
        synchronized (obj) {
            try {
                zzbax zzbaxVar = this.zza;
                zzbbaVar = zzbaxVar.zzd;
                if (zzbbaVar != null) {
                    zzbbaVar2 = zzbaxVar.zzd;
                    zzbaxVar.zzf = zzbbaVar2.zzq();
                }
            } catch (DeadObjectException e) {
                zzcec.zzh("Unable to obtain a cache service instance.", e);
                zzbax.zzh(this.zza);
            }
            obj2 = this.zza.zzc;
            obj2.notifyAll();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        Object obj;
        Object obj2;
        obj = this.zza.zzc;
        synchronized (obj) {
            this.zza.zzf = null;
            obj2 = this.zza.zzc;
            obj2.notifyAll();
        }
    }
}
