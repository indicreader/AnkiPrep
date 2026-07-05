package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzapm extends Thread {
    private static final boolean zza = zzaqm.zzb;
    private final BlockingQueue zzb;
    private final BlockingQueue zzc;
    private final zzapk zzd;
    private volatile boolean zze = false;
    private final zzaqn zzf;
    private final zzapr zzg;

    public zzapm(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, zzapk zzapkVar, zzapr zzaprVar) {
        this.zzb = blockingQueue;
        this.zzc = blockingQueue2;
        this.zzd = zzapkVar;
        this.zzg = zzaprVar;
        this.zzf = new zzaqn(this, blockingQueue2, zzaprVar);
    }

    private void zzc() throws InterruptedException {
        zzaqa zzaqaVar = (zzaqa) this.zzb.take();
        zzaqaVar.zzm("cache-queue-take");
        zzaqaVar.zzt(1);
        try {
            zzaqaVar.zzw();
            zzapj zza2 = this.zzd.zza(zzaqaVar.zzj());
            if (zza2 == null) {
                zzaqaVar.zzm("cache-miss");
                if (!this.zzf.zzc(zzaqaVar)) {
                    this.zzc.put(zzaqaVar);
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                if (zza2.zza(currentTimeMillis)) {
                    zzaqaVar.zzm("cache-hit-expired");
                    zzaqaVar.zze(zza2);
                    if (!this.zzf.zzc(zzaqaVar)) {
                        this.zzc.put(zzaqaVar);
                    }
                } else {
                    zzaqaVar.zzm("cache-hit");
                    zzaqg zzh = zzaqaVar.zzh(new zzapw(zza2.zza, zza2.zzg));
                    zzaqaVar.zzm("cache-hit-parsed");
                    if (!zzh.zzc()) {
                        zzaqaVar.zzm("cache-parsing-failed");
                        this.zzd.zzc(zzaqaVar.zzj(), true);
                        zzaqaVar.zze(null);
                        if (!this.zzf.zzc(zzaqaVar)) {
                            this.zzc.put(zzaqaVar);
                        }
                    } else if (zza2.zzf < currentTimeMillis) {
                        zzaqaVar.zzm("cache-hit-refresh-needed");
                        zzaqaVar.zze(zza2);
                        zzh.zzd = true;
                        if (!this.zzf.zzc(zzaqaVar)) {
                            this.zzg.zzb(zzaqaVar, zzh, new zzapl(this, zzaqaVar));
                        } else {
                            this.zzg.zzb(zzaqaVar, zzh, null);
                        }
                    } else {
                        this.zzg.zzb(zzaqaVar, zzh, null);
                    }
                }
            }
        } finally {
            zzaqaVar.zzt(2);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (zza) {
            zzaqm.zzd("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzd.zzb();
        while (true) {
            try {
                zzc();
            } catch (InterruptedException unused) {
                if (!this.zze) {
                    zzaqm.zzb("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
                } else {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

    public final void zzb() {
        this.zze = true;
        interrupt();
    }
}
