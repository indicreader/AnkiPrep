package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzflz implements zzflw {
    private final zzflw zza;
    private final Queue zzb = new LinkedBlockingQueue();
    private final int zzc = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziC)).intValue();
    private final AtomicBoolean zzd = new AtomicBoolean(false);

    public zzflz(zzflw zzflwVar, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzflwVar;
        long intValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziB)).intValue();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlk)).booleanValue()) {
            scheduledExecutorService.scheduleWithFixedDelay(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfly
                @Override // java.lang.Runnable
                public final void run() {
                    zzflz.zzc(zzflz.this);
                }
            }, intValue, intValue, TimeUnit.MILLISECONDS);
        } else {
            scheduledExecutorService.scheduleAtFixedRate(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfly
                @Override // java.lang.Runnable
                public final void run() {
                    zzflz.zzc(zzflz.this);
                }
            }, intValue, intValue, TimeUnit.MILLISECONDS);
        }
    }

    public static /* synthetic */ void zzc(zzflz zzflzVar) {
        while (!zzflzVar.zzb.isEmpty()) {
            zzflzVar.zza.zzb((zzflv) zzflzVar.zzb.remove());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzflw
    public final String zza(zzflv zzflvVar) {
        return this.zza.zza(zzflvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzflw
    public final void zzb(zzflv zzflvVar) {
        if (this.zzb.size() >= this.zzc) {
            if (this.zzd.getAndSet(true)) {
                return;
            }
            Queue queue = this.zzb;
            zzflv zzb = zzflv.zzb("dropped_event");
            Map zzj = zzflvVar.zzj();
            if (zzj.containsKey("action")) {
                zzb.zza("dropped_action", (String) zzj.get("action"));
            }
            queue.offer(zzb);
            return;
        }
        this.zzb.offer(zzflvVar);
    }
}
