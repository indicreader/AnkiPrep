package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzefy {
    private final zzefu zza;
    private final zzgey zzb;

    public zzefy(zzefu zzefuVar, zzgey zzgeyVar) {
        this.zza = zzefuVar;
        this.zzb = zzgeyVar;
    }

    public final void zza(zzfkp zzfkpVar) {
        final zzefu zzefuVar = this.zza;
        Objects.requireNonNull(zzefuVar);
        zzgen.zzr(this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzefw
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzefu.this.getWritableDatabase();
            }
        }), new zzefx(this, zzfkpVar), this.zzb);
    }
}
