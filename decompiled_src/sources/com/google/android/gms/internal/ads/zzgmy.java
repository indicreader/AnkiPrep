package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgmy {
    final Map zza = new HashMap();
    final Map zzb = new HashMap();

    private zzgmy() {
    }

    public final zzgmy zza(Enum r2, Object obj) {
        this.zza.put(r2, obj);
        this.zzb.put(obj, r2);
        return this;
    }

    public final zzgna zzb() {
        return new zzgna(Collections.unmodifiableMap(this.zza), Collections.unmodifiableMap(this.zzb), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgmy(zzgmx zzgmxVar) {
    }
}
