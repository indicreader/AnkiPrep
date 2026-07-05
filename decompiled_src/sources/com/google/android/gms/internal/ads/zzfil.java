package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfil implements zzhhd {
    private final zzfik zza;

    public zzfil(zzfik zzfikVar) {
        this.zza = zzfikVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* synthetic */ Object zzb() {
        Clock defaultClock = DefaultClock.getInstance();
        zzhhl.zzb(defaultClock);
        return defaultClock;
    }
}
