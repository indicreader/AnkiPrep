package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzawb {
    private List zza = Collections.emptyList();

    public final List zza() {
        List list = this.zza;
        this.zza = Collections.emptyList();
        return list;
    }

    public final void zzb(List list) {
        this.zza = new ArrayList(list);
    }
}
