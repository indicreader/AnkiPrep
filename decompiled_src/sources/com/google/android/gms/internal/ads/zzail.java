package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzail implements zzaii {
    private final long zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    private final long[] zzf;

    private zzail(long j, int i, long j2, long j3, long[] jArr) {
        this.zza = j;
        this.zzb = i;
        this.zzc = j2;
        this.zzf = jArr;
        this.zzd = j3;
        this.zze = j3 != -1 ? j + j3 : -1L;
    }

    public static zzail zzb(long j, zzaik zzaikVar, long j2) {
        long j3 = zzaikVar.zzb;
        if (j3 == -1) {
            j3 = -1;
        }
        long zzr = zzfy.zzr((j3 * r7.zzg) - 1, zzaikVar.zza.zzd);
        long j4 = zzaikVar.zzc;
        if (j4 == -1 || zzaikVar.zzf == null) {
            return new zzail(j2, zzaikVar.zza.zzc, zzr, -1L, null);
        }
        if (j != -1) {
            long j5 = j2 + j4;
            if (j != j5) {
                zzff.zzf("XingSeeker", "XING data size mismatch: " + j + ", " + j5);
            }
        }
        return new zzail(j2, zzaikVar.zza.zzc, zzr, zzaikVar.zzc, zzaikVar.zzf);
    }

    private final long zze(int i) {
        return (this.zzc * i) / 100;
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final long zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final long zzd(long j) {
        if (!zzh()) {
            return 0L;
        }
        long j2 = j - this.zza;
        if (j2 <= this.zzb) {
            return 0L;
        }
        long[] jArr = this.zzf;
        zzek.zzb(jArr);
        double d = (j2 * 256.0d) / this.zzd;
        int zzc = zzfy.zzc(jArr, (long) d, true, true);
        long zze = zze(zzc);
        long j3 = jArr[zzc];
        int i = zzc + 1;
        long zze2 = zze(i);
        return zze + Math.round((j3 == (zzc == 99 ? 256L : jArr[i]) ? 0.0d : (d - j3) / (r0 - j3)) * (zze2 - zze));
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j) {
        if (!zzh()) {
            zzadv zzadvVar = new zzadv(0L, this.zza + this.zzb);
            return new zzads(zzadvVar, zzadvVar);
        }
        long max = Math.max(0L, Math.min(j, this.zzc));
        double d = (max * 100.0d) / this.zzc;
        double d2 = 0.0d;
        if (d > 0.0d) {
            if (d >= 100.0d) {
                d2 = 256.0d;
            } else {
                int i = (int) d;
                long[] jArr = this.zzf;
                zzek.zzb(jArr);
                double d3 = jArr[i];
                d2 = d3 + ((d - i) * ((i == 99 ? 256.0d : jArr[i + 1]) - d3));
            }
        }
        long j2 = this.zzd;
        zzadv zzadvVar2 = new zzadv(max, this.zza + Math.max(this.zzb, Math.min(Math.round((d2 / 256.0d) * j2), j2 - 1)));
        return new zzads(zzadvVar2, zzadvVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return this.zzf != null;
    }
}
