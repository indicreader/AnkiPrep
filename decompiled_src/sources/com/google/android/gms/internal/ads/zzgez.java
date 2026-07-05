package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgez implements Executor {
    final /* synthetic */ Executor zza;
    final /* synthetic */ zzgdb zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgez(Executor executor, zzgdb zzgdbVar) {
        this.zza = executor;
        this.zzb = zzgdbVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        try {
            this.zza.execute(runnable);
        } catch (RejectedExecutionException e) {
            this.zzb.zzd(e);
        }
    }
}
