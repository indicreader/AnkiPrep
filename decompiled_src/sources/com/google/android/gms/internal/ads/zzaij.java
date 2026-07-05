package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import java.math.RoundingMode;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzaij implements zzaii {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final long zzd;

    private zzaij(long[] jArr, long[] jArr2, long j, long j2) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j;
        this.zzd = j2;
    }

    public static zzaij zzb(long j, long j2, zzado zzadoVar, zzfp zzfpVar) {
        int zzm;
        zzfpVar.zzL(10);
        int zzg = zzfpVar.zzg();
        if (zzg <= 0) {
            return null;
        }
        int i = zzadoVar.zzd;
        long zzs = zzfy.zzs(zzg, (i >= 32000 ? 1152 : 576) * AnimationKt.MillisToNanos, i, RoundingMode.FLOOR);
        int zzq = zzfpVar.zzq();
        int zzq2 = zzfpVar.zzq();
        int zzq3 = zzfpVar.zzq();
        zzfpVar.zzL(2);
        long j3 = j2 + zzadoVar.zzc;
        long[] jArr = new long[zzq];
        long[] jArr2 = new long[zzq];
        int i2 = 0;
        long j4 = j2;
        while (i2 < zzq) {
            long j5 = j3;
            long j6 = zzs;
            jArr[i2] = (i2 * zzs) / zzq;
            jArr2[i2] = Math.max(j4, j5);
            if (zzq3 == 1) {
                zzm = zzfpVar.zzm();
            } else if (zzq3 == 2) {
                zzm = zzfpVar.zzq();
            } else if (zzq3 == 3) {
                zzm = zzfpVar.zzo();
            } else {
                if (zzq3 != 4) {
                    return null;
                }
                zzm = zzfpVar.zzp();
            }
            j4 += zzm * zzq2;
            i2++;
            j3 = j5;
            zzq = zzq;
            zzs = j6;
        }
        long j7 = zzs;
        if (j != -1 && j != j4) {
            zzff.zzf("VbriSeeker", "VBRI data size mismatch: " + j + ", " + j4);
        }
        return new zzaij(jArr, jArr2, j7, j4);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final long zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final long zzd(long j) {
        return this.zza[zzfy.zzc(this.zzb, j, true, true)];
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j) {
        long[] jArr = this.zza;
        int zzc = zzfy.zzc(jArr, j, true, true);
        zzadv zzadvVar = new zzadv(jArr[zzc], this.zzb[zzc]);
        if (zzadvVar.zzb < j) {
            long[] jArr2 = this.zza;
            if (zzc != jArr2.length - 1) {
                int i = zzc + 1;
                return new zzads(zzadvVar, new zzadv(jArr2[i], this.zzb[i]));
            }
        }
        return new zzads(zzadvVar, zzadvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return true;
    }
}
