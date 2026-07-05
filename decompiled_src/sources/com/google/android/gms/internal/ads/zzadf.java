package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzadf implements zzadu {
    private final zzadh zza;
    private final long zzb;

    public zzadf(zzadh zzadhVar, long j) {
        this.zza = zzadhVar;
        this.zzb = j;
    }

    private final zzadv zzb(long j, long j2) {
        return new zzadv((j * AnimationKt.MillisToNanos) / this.zza.zze, this.zzb + j2);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j) {
        zzek.zzb(this.zza.zzk);
        zzadh zzadhVar = this.zza;
        zzadg zzadgVar = zzadhVar.zzk;
        long[] jArr = zzadgVar.zza;
        long[] jArr2 = zzadgVar.zzb;
        int zzc = zzfy.zzc(jArr, zzadhVar.zzb(j), true, false);
        zzadv zzb = zzb(zzc == -1 ? 0L : jArr[zzc], zzc != -1 ? jArr2[zzc] : 0L);
        if (zzb.zzb == j || zzc == jArr.length - 1) {
            return new zzads(zzb, zzb);
        }
        int i = zzc + 1;
        return new zzads(zzb, zzb(jArr[i], jArr2[i]));
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return true;
    }
}
