package com.google.android.gms.internal.ads;

import coil.disk.DiskLruCache;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzbmy implements zzbng {
    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        ((zzcjk) obj).zzam(DiskLruCache.VERSION.equals(map.get("custom_close")));
    }
}
