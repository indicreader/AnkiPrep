package com.google.android.gms.internal.ads;

import android.os.Bundle;
import coil.disk.DiskLruCache;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzerd implements zzexp {
    private final boolean zza;

    public zzerd(boolean z) {
        this.zza = z;
    }

    @Override // com.google.android.gms.internal.ads.zzexp
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        ((Bundle) obj).putString("adid_p", true != this.zza ? "0" : DiskLruCache.VERSION);
    }
}
