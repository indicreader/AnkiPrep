package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzach {
    public static void zza(long j, zzfp zzfpVar, zzaea[] zzaeaVarArr) {
        int i;
        while (true) {
            if (zzfpVar.zzb() <= 1) {
                return;
            }
            int zzc = zzc(zzfpVar);
            int zzc2 = zzc(zzfpVar);
            int zzd = zzfpVar.zzd() + zzc2;
            if (zzc2 == -1 || zzc2 > zzfpVar.zzb()) {
                zzff.zzf("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                zzd = zzfpVar.zze();
            } else if (zzc == 4 && zzc2 >= 8) {
                int zzm = zzfpVar.zzm();
                int zzq = zzfpVar.zzq();
                if (zzq == 49) {
                    i = zzfpVar.zzg();
                    zzq = 49;
                } else {
                    i = 0;
                }
                int zzm2 = zzfpVar.zzm();
                if (zzq == 47) {
                    zzfpVar.zzL(1);
                    zzq = 47;
                }
                boolean z = zzm == 181 && (zzq == 49 || zzq == 47) && zzm2 == 3;
                if (zzq == 49) {
                    z &= i == 1195456820;
                }
                if (z) {
                    zzb(j, zzfpVar, zzaeaVarArr);
                }
            }
            zzfpVar.zzK(zzd);
        }
    }

    public static void zzb(long j, zzfp zzfpVar, zzaea[] zzaeaVarArr) {
        int zzm = zzfpVar.zzm();
        if ((zzm & 64) != 0) {
            int i = zzm & 31;
            zzfpVar.zzL(1);
            int zzd = zzfpVar.zzd();
            for (zzaea zzaeaVar : zzaeaVarArr) {
                int i2 = i * 3;
                zzfpVar.zzK(zzd);
                zzaeaVar.zzr(zzfpVar, i2);
                zzek.zzf(j != -9223372036854775807L);
                zzaeaVar.zzt(j, 1, i2, 0, null);
            }
        }
    }

    private static int zzc(zzfp zzfpVar) {
        int i = 0;
        while (zzfpVar.zzb() != 0) {
            int zzm = zzfpVar.zzm();
            i += zzm;
            if (zzm != 255) {
                return i;
            }
        }
        return -1;
    }
}
