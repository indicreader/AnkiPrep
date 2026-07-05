package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgfe {
    public static zzgey zza(ExecutorService executorService) {
        zzgey zzgfaVar;
        if (executorService instanceof zzgey) {
            return (zzgey) executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            zzgfaVar = new zzgfd((ScheduledExecutorService) executorService);
        } else {
            zzgfaVar = new zzgfa(executorService);
        }
        return zzgfaVar;
    }

    public static Executor zzb() {
        return zzgeb.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor zzc(Executor executor, zzgdb zzgdbVar) {
        executor.getClass();
        return executor == zzgeb.INSTANCE ? executor : new zzgez(executor, zzgdbVar);
    }
}
