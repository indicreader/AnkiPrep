package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzapq implements Runnable {
    private final zzaqa zza;
    private final zzaqg zzb;
    private final Runnable zzc;

    public zzapq(zzaqa zzaqaVar, zzaqg zzaqgVar, Runnable runnable) {
        this.zza = zzaqaVar;
        this.zzb = zzaqgVar;
        this.zzc = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzw();
        zzaqg zzaqgVar = this.zzb;
        if (zzaqgVar.zzc()) {
            this.zza.zzo(zzaqgVar.zza);
        } else {
            this.zza.zzn(zzaqgVar.zzc);
        }
        if (this.zzb.zzd) {
            this.zza.zzm("intermediate-response");
        } else {
            this.zza.zzp("done");
        }
        Runnable runnable = this.zzc;
        if (runnable != null) {
            runnable.run();
        }
    }
}
