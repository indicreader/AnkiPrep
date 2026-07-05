package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzace {
    public static final zzace zza = new zzace(-3, -9223372036854775807L, -1);
    private final int zzb;
    private final long zzc;
    private final long zzd;

    private zzace(int i, long j, long j2) {
        this.zzb = i;
        this.zzc = j;
        this.zzd = j2;
    }

    public static zzace zzd(long j, long j2) {
        return new zzace(-1, j, j2);
    }

    public static zzace zze(long j) {
        return new zzace(0, -9223372036854775807L, j);
    }

    public static zzace zzf(long j, long j2) {
        return new zzace(-2, j, j2);
    }
}
