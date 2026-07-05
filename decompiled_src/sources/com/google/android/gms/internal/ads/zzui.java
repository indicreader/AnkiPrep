package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzui {
    private static final AtomicLong zzd = new AtomicLong();
    public final zzhb zza;
    public final Uri zzb;
    public final Map zzc;

    public zzui(long j, zzhb zzhbVar, Uri uri, Map map, long j2, long j3, long j4) {
        this.zza = zzhbVar;
        this.zzb = uri;
        this.zzc = map;
    }

    public static long zza() {
        return zzd.getAndIncrement();
    }
}
