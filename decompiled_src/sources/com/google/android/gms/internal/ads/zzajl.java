package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzajl {
    private static final int[] zza = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean zza(zzacv zzacvVar) throws IOException {
        return zzc(zzacvVar, true, false);
    }

    public static boolean zzb(zzacv zzacvVar, boolean z) throws IOException {
        return zzc(zzacvVar, false, z);
    }

    private static boolean zzc(zzacv zzacvVar, boolean z, boolean z2) throws IOException {
        boolean z3;
        long j;
        int i;
        zzfp zzfpVar;
        boolean z4;
        long zzd = zzacvVar.zzd();
        long j2 = -1;
        long j3 = 4096;
        if (zzd != -1 && zzd <= 4096) {
            j3 = zzd;
        }
        zzfp zzfpVar2 = new zzfp(64);
        int i2 = (int) j3;
        boolean z5 = false;
        int i3 = 0;
        boolean z6 = false;
        while (i3 < i2) {
            zzfpVar2.zzH(8);
            if (!zzacvVar.zzm(zzfpVar2.zzM(), z5 ? 1 : 0, 8, true)) {
                z3 = z5 ? 1 : 0;
                break;
            }
            long zzu = zzfpVar2.zzu();
            int zzg = zzfpVar2.zzg();
            if (zzu == 1) {
                zzacvVar.zzh(zzfpVar2.zzM(), 8, 8);
                i = 16;
                zzfpVar2.zzJ(16);
                j = zzfpVar2.zzt();
            } else {
                if (zzu == 0) {
                    long zzd2 = zzacvVar.zzd();
                    if (zzd2 != j2) {
                        zzu = (zzd2 - zzacvVar.zze()) + 8;
                    }
                }
                j = zzu;
                i = 8;
            }
            long j4 = i;
            if (j < j4) {
                return z5;
            }
            i3 += i;
            if (zzg == 1836019574) {
                i2 += (int) j;
                if (zzd != -1 && i2 > zzd) {
                    i2 = (int) zzd;
                }
                j2 = -1;
            } else {
                if (zzg == 1836019558 || zzg == 1836475768) {
                    z3 = true;
                    break;
                }
                z6 = (!(zzg == 1835295092 ? z5 ? 1 : 0 : true)) | z6;
                zzfp zzfpVar3 = zzfpVar2;
                if ((i3 + j) - j4 >= i2) {
                    break;
                }
                int i4 = (int) (j - j4);
                i3 += i4;
                if (zzg != 1718909296) {
                    zzfpVar = zzfpVar3;
                    if (i4 != 0) {
                        zzacvVar.zzg(i4);
                    }
                } else {
                    if (i4 < 8) {
                        return false;
                    }
                    zzfpVar = zzfpVar3;
                    zzfpVar.zzH(i4);
                    zzacvVar.zzh(zzfpVar.zzM(), 0, i4);
                    int i5 = i4 >> 2;
                    for (int i6 = 0; i6 < i5; i6++) {
                        if (i6 == 1) {
                            zzfpVar.zzL(4);
                        } else {
                            int zzg2 = zzfpVar.zzg();
                            if ((zzg2 >>> 8) != 3368816) {
                                if (zzg2 == 1751476579) {
                                    if (!z2) {
                                        zzg2 = 1751476579;
                                    }
                                }
                                int[] iArr = zza;
                                for (int i7 = 0; i7 < 29; i7++) {
                                    if (iArr[i7] != zzg2) {
                                    }
                                }
                            }
                            z4 = true;
                            break;
                        }
                    }
                    z4 = z6;
                    if (!z4) {
                        return false;
                    }
                    z6 = z4;
                }
                zzfpVar2 = zzfpVar;
                j2 = -1;
                z5 = false;
            }
        }
        z3 = false;
        return z6 && z == z3;
    }
}
