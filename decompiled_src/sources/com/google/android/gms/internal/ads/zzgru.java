package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgru {
    private HashMap zza = new HashMap();

    public final zzgrw zza() {
        if (this.zza == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        zzgrw zzgrwVar = new zzgrw(Collections.unmodifiableMap(this.zza), null);
        this.zza = null;
        return zzgrwVar;
    }
}
