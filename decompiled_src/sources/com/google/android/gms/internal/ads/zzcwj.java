package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcwj implements zzcwk {
    private final Map zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcwj(Map map) {
        this.zza = map;
    }

    @Override // com.google.android.gms.internal.ads.zzcwk
    public final zzein zza(int i, String str) {
        return (zzein) this.zza.get(str);
    }
}
