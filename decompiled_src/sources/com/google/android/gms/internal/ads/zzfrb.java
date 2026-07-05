package com.google.android.gms.internal.ads;

import android.content.Context;
import coil.disk.DiskLruCache;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfrb {
    public static zzfsk zza(Context context, int i, int i2, String str, String str2, String str3, zzfqr zzfqrVar) {
        return new zzfra(context, 1, i2, str, str2, DiskLruCache.VERSION, zzfqrVar).zzb(50000);
    }
}
