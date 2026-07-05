package com.google.android.gms.ads.mediation.customevent;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
@Deprecated
/* loaded from: classes3.dex */
public final class CustomEventExtras {
    private final HashMap zza = new HashMap();

    public Object getExtra(String str) {
        return this.zza.get(str);
    }

    public void setExtra(String str, Object obj) {
        this.zza.put(str, obj);
    }
}
