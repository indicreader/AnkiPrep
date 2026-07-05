package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzapu extends Thread {
    private final BlockingQueue zza;
    private final zzapt zzb;
    private final zzapk zzc;
    private volatile boolean zzd = false;
    private final zzapr zze;

    public zzapu(BlockingQueue blockingQueue, zzapt zzaptVar, zzapk zzapkVar, zzapr zzaprVar) {
        this.zza = blockingQueue;
        this.zzb = zzaptVar;
        this.zzc = zzapkVar;
        this.zze = zzaprVar;
    }

    private void zzb() throws InterruptedException {
        zzaqa zzaqaVar = (zzaqa) this.zza.take();
        SystemClock.elapsedRealtime();
        zzaqaVar.zzt(3);
        try {
            try {
                zzaqaVar.zzm("network-queue-take");
                zzaqaVar.zzw();
                TrafficStats.setThreadStatsTag(zzaqaVar.zzc());
                zzapw zza = this.zzb.zza(zzaqaVar);
                zzaqaVar.zzm("network-http-complete");
                if (!zza.zze || !zzaqaVar.zzv()) {
                    zzaqg zzh = zzaqaVar.zzh(zza);
                    zzaqaVar.zzm("network-parse-complete");
                    if (zzh.zzb != null) {
                        this.zzc.zzd(zzaqaVar.zzj(), zzh.zzb);
                        zzaqaVar.zzm("network-cache-written");
                    }
                    zzaqaVar.zzq();
                    this.zze.zzb(zzaqaVar, zzh, null);
                    zzaqaVar.zzs(zzh);
                } else {
                    zzaqaVar.zzp("not-modified");
                    zzaqaVar.zzr();
                }
            } catch (zzaqj e) {
                SystemClock.elapsedRealtime();
                this.zze.zza(zzaqaVar, e);
                zzaqaVar.zzr();
            } catch (Exception e2) {
                zzaqm.zzc(e2, "Unhandled exception %s", e2.toString());
                zzaqj zzaqjVar = new zzaqj(e2);
                SystemClock.elapsedRealtime();
                this.zze.zza(zzaqaVar, zzaqjVar);
                zzaqaVar.zzr();
            }
        } finally {
            zzaqaVar.zzt(4);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                zzb();
            } catch (InterruptedException unused) {
                if (!this.zzd) {
                    zzaqm.zzb("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
                } else {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

    public final void zza() {
        this.zzd = true;
        interrupt();
    }
}
