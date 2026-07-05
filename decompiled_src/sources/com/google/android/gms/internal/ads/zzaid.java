package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzaid implements zzaii {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;

    private zzaid(long[] jArr, long[] jArr2, long j) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j == -9223372036854775807L ? zzfy.zzq(jArr2[jArr2.length - 1]) : j;
    }

    public static zzaid zzb(long j, zzagv zzagvVar, long j2) {
        int length = zzagvVar.zzd.length;
        int i = length + 1;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        jArr[0] = j;
        long j3 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            j += zzagvVar.zzb + zzagvVar.zzd[i3];
            j3 += zzagvVar.zzc + zzagvVar.zze[i3];
            jArr[i2] = j;
            jArr2[i2] = j3;
        }
        return new zzaid(jArr, jArr2, j2);
    }

    private static Pair zze(long j, long[] jArr, long[] jArr2) {
        int zzc = zzfy.zzc(jArr, j, true, true);
        long j2 = jArr[zzc];
        long j3 = jArr2[zzc];
        int i = zzc + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) ((jArr[i] == j2 ? 0.0d : (j - j2) / (r6 - j2)) * (jArr2[i] - j3))) + j3));
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final long zzc() {
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final long zzd(long j) {
        return zzfy.zzq(((Long) zze(j, this.zza, this.zzb).second).longValue());
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j) {
        Pair zze = zze(zzfy.zzt(Math.max(0L, Math.min(j, this.zzc))), this.zzb, this.zza);
        zzadv zzadvVar = new zzadv(zzfy.zzq(((Long) zze.first).longValue()), ((Long) zze.second).longValue());
        return new zzads(zzadvVar, zzadvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return true;
    }
}
