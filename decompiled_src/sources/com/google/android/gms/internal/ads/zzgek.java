package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgek implements Runnable {
    final Future zza;
    final zzgej zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgek(Future future, zzgej zzgejVar) {
        this.zza = future;
        this.zzb = zzgejVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable zza;
        Object obj = this.zza;
        if (!(obj instanceof zzgfq) || (zza = zzgfr.zza((zzgfq) obj)) == null) {
            try {
                this.zzb.zzb(zzgen.zzp(this.zza));
                return;
            } catch (ExecutionException e) {
                this.zzb.zza(e.getCause());
                return;
            } catch (Throwable th) {
                this.zzb.zza(th);
                return;
            }
        }
        this.zzb.zza(zza);
    }

    public final String toString() {
        zzfww zza = zzfwx.zza(this);
        zza.zza(this.zzb);
        return zza.toString();
    }
}
