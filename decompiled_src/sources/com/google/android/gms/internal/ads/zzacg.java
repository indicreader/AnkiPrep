package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public class zzacg {
    protected final zzaca zza;
    protected final zzacf zzb;
    protected zzacc zzc;
    private final int zzd;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzacg(zzacd zzacdVar, zzacf zzacfVar, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.zzb = zzacfVar;
        this.zzd = i;
        this.zza = new zzaca(zzacdVar, j, 0L, j3, j4, j5, j6);
    }

    protected static final int zzf(zzacv zzacvVar, long j, zzadr zzadrVar) {
        if (j == zzacvVar.zzf()) {
            return 0;
        }
        zzadrVar.zza = j;
        return 1;
    }

    protected static final boolean zzg(zzacv zzacvVar, long j) throws IOException {
        long zzf = j - zzacvVar.zzf();
        if (zzf < 0 || zzf > 262144) {
            return false;
        }
        ((zzack) zzacvVar).zzo((int) zzf, false);
        return true;
    }

    public final int zza(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        int i;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        while (true) {
            zzacc zzaccVar = this.zzc;
            zzek.zzb(zzaccVar);
            j = zzaccVar.zzf;
            j2 = zzaccVar.zzg;
            long j12 = j2 - j;
            int i2 = this.zzd;
            j3 = zzaccVar.zzh;
            if (j12 > i2) {
                if (zzg(zzacvVar, j3)) {
                    zzacvVar.zzj();
                    zzacf zzacfVar = this.zzb;
                    j4 = zzaccVar.zzb;
                    zzace zza = zzacfVar.zza(zzacvVar, j4);
                    i = zza.zzb;
                    if (i == -3) {
                        zzc(false, j3);
                        return zzf(zzacvVar, j3, zzadrVar);
                    }
                    if (i == -2) {
                        j10 = zza.zzc;
                        j11 = zza.zzd;
                        zzacc.zzh(zzaccVar, j10, j11);
                    } else if (i == -1) {
                        j8 = zza.zzc;
                        j9 = zza.zzd;
                        zzacc.zzg(zzaccVar, j8, j9);
                    } else {
                        j5 = zza.zzd;
                        zzg(zzacvVar, j5);
                        j6 = zza.zzd;
                        zzc(true, j6);
                        j7 = zza.zzd;
                        return zzf(zzacvVar, j7, zzadrVar);
                    }
                } else {
                    return zzf(zzacvVar, j3, zzadrVar);
                }
            } else {
                zzc(false, j);
                return zzf(zzacvVar, j, zzadrVar);
            }
        }
    }

    public final zzadu zzb() {
        return this.zza;
    }

    protected final void zzc(boolean z, long j) {
        this.zzc = null;
        this.zzb.zzb();
    }

    public final void zzd(long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        zzacc zzaccVar = this.zzc;
        if (zzaccVar != null) {
            j6 = zzaccVar.zza;
            if (j6 == j) {
                return;
            }
        }
        zzaca zzacaVar = this.zza;
        long zzf = zzacaVar.zzf(j);
        j2 = zzacaVar.zzc;
        j3 = zzacaVar.zzd;
        j4 = zzacaVar.zze;
        j5 = zzacaVar.zzf;
        this.zzc = new zzacc(j, zzf, 0L, j2, j3, j4, j5);
    }

    public final boolean zze() {
        return this.zzc != null;
    }
}
