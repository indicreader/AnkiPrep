package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgdb;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzgfc extends zzgdb.zzi implements Runnable {
    private final Runnable zza;

    public zzgfc(Runnable runnable) {
        runnable.getClass();
        this.zza = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zza.run();
        } catch (Throwable th) {
            zzd(th);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgdb
    public final String zza() {
        return "task=[" + this.zza.toString() + "]";
    }
}
