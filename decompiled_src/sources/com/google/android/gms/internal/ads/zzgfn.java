package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgfn extends zzged implements RunnableFuture {

    @CheckForNull
    private volatile zzgew zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgfn(zzgdt zzgdtVar) {
        this.zza = new zzgfl(this, zzgdtVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgfn zze(Runnable runnable, Object obj) {
        return new zzgfn(Executors.callable(runnable, obj));
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzgew zzgewVar = this.zza;
        if (zzgewVar != null) {
            zzgewVar.run();
        }
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgdb
    @CheckForNull
    protected final String zza() {
        zzgew zzgewVar = this.zza;
        if (zzgewVar != null) {
            return "task=[" + zzgewVar.toString() + "]";
        }
        return super.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgdb
    protected final void zzb() {
        zzgew zzgewVar;
        if (zzt() && (zzgewVar = this.zza) != null) {
            zzgewVar.zzh();
        }
        this.zza = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgfn(Callable callable) {
        this.zza = new zzgfm(this, callable);
    }
}
