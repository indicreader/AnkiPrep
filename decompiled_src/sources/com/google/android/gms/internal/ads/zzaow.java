package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import java.math.RoundingMode;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzaow implements zzadu {
    private final zzaot zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;

    public zzaow(zzaot zzaotVar, int i, long j, long j2) {
        this.zza = zzaotVar;
        this.zzb = i;
        this.zzc = j;
        long j3 = (j2 - j) / zzaotVar.zzd;
        this.zzd = j3;
        this.zze = zzb(j3);
    }

    private final long zzb(long j) {
        return zzfy.zzs(j * this.zzb, AnimationKt.MillisToNanos, this.zza.zzc, RoundingMode.FLOOR);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j) {
        long max = Math.max(0L, Math.min((this.zza.zzc * j) / (this.zzb * AnimationKt.MillisToNanos), this.zzd - 1));
        long zzb = zzb(max);
        zzadv zzadvVar = new zzadv(zzb, this.zzc + (this.zza.zzd * max));
        if (zzb >= j || max == this.zzd - 1) {
            return new zzads(zzadvVar, zzadvVar);
        }
        long j2 = max + 1;
        return new zzads(zzadvVar, new zzadv(zzb(j2), this.zzc + (j2 * this.zza.zzd)));
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return true;
    }
}
