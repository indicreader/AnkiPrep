package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzaik {
    public final zzado zza;
    public final long zzb;
    public final long zzc;
    public final int zzd;
    public final int zze;
    public final long[] zzf;

    private zzaik(zzado zzadoVar, long j, long j2, long[] jArr, int i, int i2) {
        this.zza = zzadoVar;
        this.zzb = j;
        this.zzc = j2;
        this.zzf = jArr;
        this.zzd = i;
        this.zze = i2;
    }

    public static zzaik zza(zzado zzadoVar, zzfp zzfpVar) {
        long[] jArr;
        int i;
        int i2;
        int zzg = zzfpVar.zzg();
        int zzp = (zzg & 1) != 0 ? zzfpVar.zzp() : -1;
        long zzu = (zzg & 2) != 0 ? zzfpVar.zzu() : -1L;
        if ((zzg & 4) == 4) {
            long[] jArr2 = new long[100];
            for (int i3 = 0; i3 < 100; i3++) {
                jArr2[i3] = zzfpVar.zzm();
            }
            jArr = jArr2;
        } else {
            jArr = null;
        }
        if ((zzg & 8) != 0) {
            zzfpVar.zzL(4);
        }
        if (zzfpVar.zzb() >= 24) {
            zzfpVar.zzL(21);
            int zzo = zzfpVar.zzo();
            i2 = zzo & 4095;
            i = zzo >> 12;
        } else {
            i = -1;
            i2 = -1;
        }
        return new zzaik(zzadoVar, zzp, zzu, jArr, i, i2);
    }
}
