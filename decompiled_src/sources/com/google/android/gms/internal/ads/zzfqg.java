package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfqg {
    private final BlockingQueue zza;
    private final ThreadPoolExecutor zzb;
    private final ArrayDeque zzc = new ArrayDeque();
    private zzfqf zzd = null;

    public zzfqg() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.zza = linkedBlockingQueue;
        this.zzb = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private final void zzc() {
        zzfqf zzfqfVar = (zzfqf) this.zzc.poll();
        this.zzd = zzfqfVar;
        if (zzfqfVar != null) {
            zzfqfVar.executeOnExecutor(this.zzb, new Object[0]);
        }
    }

    public final void zza(zzfqf zzfqfVar) {
        this.zzd = null;
        zzc();
    }

    public final void zzb(zzfqf zzfqfVar) {
        zzfqfVar.zzb(this);
        this.zzc.add(zzfqfVar);
        if (this.zzd == null) {
            zzc();
        }
    }
}
