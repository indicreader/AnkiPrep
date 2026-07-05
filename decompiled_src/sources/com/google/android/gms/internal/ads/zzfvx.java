package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfvx extends zzfvu {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzfvu zzb;
    final /* synthetic */ zzfwe zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfvx(zzfwe zzfweVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, zzfvu zzfvuVar) {
        super(taskCompletionSource);
        this.zza = taskCompletionSource2;
        this.zzb = zzfvuVar;
        this.zzc = zzfweVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvu
    public final void zza() {
        Object obj;
        AtomicInteger atomicInteger;
        zzfvt zzfvtVar;
        obj = this.zzc.zzg;
        synchronized (obj) {
            zzfwe.zzn(this.zzc, this.zza);
            atomicInteger = this.zzc.zzl;
            if (atomicInteger.getAndIncrement() > 0) {
                zzfvtVar = this.zzc.zzc;
                zzfvtVar.zzc("Already connected to the service.", new Object[0]);
            }
            zzfwe.zzp(this.zzc, this.zzb);
        }
    }
}
