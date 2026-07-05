package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.IInterface;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfvy extends zzfvu {
    final /* synthetic */ zzfwe zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfvy(zzfwe zzfweVar) {
        this.zza = zzfweVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvu
    public final void zza() {
        Object obj;
        AtomicInteger atomicInteger;
        IInterface iInterface;
        zzfvt zzfvtVar;
        Context context;
        ServiceConnection serviceConnection;
        AtomicInteger atomicInteger2;
        zzfvt zzfvtVar2;
        obj = this.zza.zzg;
        synchronized (obj) {
            atomicInteger = this.zza.zzl;
            if (atomicInteger.get() > 0) {
                atomicInteger2 = this.zza.zzl;
                if (atomicInteger2.decrementAndGet() > 0) {
                    zzfvtVar2 = this.zza.zzc;
                    zzfvtVar2.zzc("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
            }
            zzfwe zzfweVar = this.zza;
            iInterface = zzfweVar.zzn;
            if (iInterface != null) {
                zzfvtVar = zzfweVar.zzc;
                zzfvtVar.zzc("Unbind from service.", new Object[0]);
                zzfwe zzfweVar2 = this.zza;
                context = zzfweVar2.zzb;
                serviceConnection = zzfweVar2.zzm;
                context.unbindService(serviceConnection);
                this.zza.zzh = false;
                this.zza.zzn = null;
                this.zza.zzm = null;
            }
            this.zza.zzw();
        }
    }
}
