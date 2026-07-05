package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgm {
    public static final byte[] zza = {0, 0, 0, 1};
    public static final float[] zzb = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object zzc = new Object();
    private static int[] zzd = new int[10];

    public static int zza(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        zzek.zzf(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            zzf(zArr);
            return i - 3;
        }
        if (i3 <= 1 || !zArr[1] || bArr[i] != 1) {
            if (i3 <= 2 || !zArr[2] || bArr[i] != 0 || bArr[i + 1] != 1) {
                int i4 = i2 - 1;
                int i5 = i + 2;
                while (i5 < i4) {
                    byte b = bArr[i5];
                    if ((b & 254) == 0) {
                        int i6 = i5 - 2;
                        if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b == 1) {
                            zzf(zArr);
                            return i6;
                        }
                        i5 = i6;
                    }
                    i5 += 3;
                }
                zArr[0] = i3 <= 2 ? !(i3 != 2 ? !(zArr[1] && bArr[i4] == 1) : !(zArr[2] && bArr[i2 + (-2)] == 0 && bArr[i4] == 1)) : bArr[i2 + (-3)] == 0 && bArr[i2 + (-2)] == 0 && bArr[i4] == 1;
                zArr[1] = i3 <= 1 ? zArr[2] && bArr[i4] == 0 : bArr[i2 + (-2)] == 0 && bArr[i4] == 0;
                zArr[2] = bArr[i4] == 0;
                return i2;
            }
            zzf(zArr);
            return i - 1;
        }
        zzf(zArr);
        return i - 2;
    }

    public static zzgj zzc(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArr;
        int i10;
        int i11;
        zzgn zzgnVar = new zzgn(bArr, i, i2);
        int i12 = 4;
        zzgnVar.zze(4);
        int zza2 = zzgnVar.zza(3);
        zzgnVar.zzd();
        int zza3 = zzgnVar.zza(2);
        boolean zzf = zzgnVar.zzf();
        int zza4 = zzgnVar.zza(5);
        int i13 = 0;
        for (int i14 = 0; i14 < 32; i14++) {
            if (zzgnVar.zzf()) {
                i13 |= 1 << i14;
            }
        }
        int i15 = 6;
        int[] iArr2 = new int[6];
        for (int i16 = 0; i16 < 6; i16++) {
            iArr2[i16] = zzgnVar.zza(8);
        }
        int zza5 = zzgnVar.zza(8);
        int i17 = 0;
        for (int i18 = 0; i18 < zza2; i18++) {
            if (zzgnVar.zzf()) {
                i17 += 89;
            }
            if (zzgnVar.zzf()) {
                i17 += 8;
            }
        }
        zzgnVar.zze(i17);
        if (zza2 > 0) {
            int i19 = 8 - zza2;
            zzgnVar.zze(i19 + i19);
        }
        int zzc2 = zzgnVar.zzc();
        int zzc3 = zzgnVar.zzc();
        if (zzc3 == 3) {
            zzgnVar.zzd();
            zzc3 = 3;
        }
        int zzc4 = zzgnVar.zzc();
        int zzc5 = zzgnVar.zzc();
        if (zzgnVar.zzf()) {
            int zzc6 = zzgnVar.zzc();
            int zzc7 = zzgnVar.zzc();
            int zzc8 = zzgnVar.zzc();
            int zzc9 = zzgnVar.zzc();
            if (zzc3 == 1) {
                i11 = 2;
            } else if (zzc3 == 2) {
                zzc3 = 2;
                i11 = 2;
            } else {
                i11 = 1;
            }
            zzc4 -= i11 * (zzc6 + zzc7);
            zzc5 -= (zzc3 == 1 ? 2 : 1) * (zzc8 + zzc9);
        }
        int i20 = zzc4;
        int i21 = zzc3;
        int i22 = zzc5;
        int zzc10 = zzgnVar.zzc();
        int zzc11 = zzgnVar.zzc();
        int zzc12 = zzgnVar.zzc();
        for (int i23 = true != zzgnVar.zzf() ? zza2 : 0; i23 <= zza2; i23++) {
            zzgnVar.zzc();
            zzgnVar.zzc();
            zzgnVar.zzc();
        }
        zzgnVar.zzc();
        zzgnVar.zzc();
        zzgnVar.zzc();
        zzgnVar.zzc();
        zzgnVar.zzc();
        zzgnVar.zzc();
        if (zzgnVar.zzf() && zzgnVar.zzf()) {
            int i24 = 0;
            while (i24 < i12) {
                int i25 = 0;
                while (i25 < i15) {
                    if (!zzgnVar.zzf()) {
                        zzgnVar.zzc();
                    } else {
                        int min = Math.min(64, 1 << ((i24 + i24) + 4));
                        if (i24 > 1) {
                            zzgnVar.zzb();
                        }
                        for (int i26 = 0; i26 < min; i26++) {
                            zzgnVar.zzb();
                        }
                    }
                    i25 += i24 == 3 ? 3 : 1;
                    i15 = 6;
                }
                i24++;
                i12 = 4;
                i15 = 6;
            }
        }
        zzgnVar.zze(2);
        if (zzgnVar.zzf()) {
            zzgnVar.zze(8);
            zzgnVar.zzc();
            zzgnVar.zzc();
            zzgnVar.zzd();
        }
        int zzc13 = zzgnVar.zzc();
        int i27 = 0;
        int[] iArr3 = new int[0];
        int[] iArr4 = new int[0];
        int i28 = -1;
        int i29 = -1;
        int i30 = -1;
        while (i27 < zzc13) {
            if (i27 == 0 || !zzgnVar.zzf()) {
                i7 = zzc13;
                i8 = i13;
                i9 = i21;
                iArr = iArr2;
                int zzc14 = zzgnVar.zzc();
                int zzc15 = zzgnVar.zzc();
                int[] iArr5 = new int[zzc14];
                int i31 = 0;
                while (i31 < zzc14) {
                    iArr5[i31] = (i31 > 0 ? iArr5[i31 - 1] : 0) - (zzgnVar.zzc() + 1);
                    zzgnVar.zzd();
                    i31++;
                }
                int[] iArr6 = new int[zzc15];
                int i32 = 0;
                while (i32 < zzc15) {
                    iArr6[i32] = (i32 > 0 ? iArr6[i32 - 1] : 0) + zzgnVar.zzc() + 1;
                    zzgnVar.zzd();
                    i32++;
                }
                i30 = zzc15;
                iArr4 = iArr6;
                i29 = zzc14;
                iArr3 = iArr5;
            } else {
                int i33 = i29 + i30;
                boolean zzf2 = zzgnVar.zzf();
                int zzc16 = zzgnVar.zzc() + 1;
                int i34 = 1 - ((zzf2 ? 1 : 0) + (zzf2 ? 1 : 0));
                int i35 = i33 + 1;
                i7 = zzc13;
                boolean[] zArr = new boolean[i35];
                iArr = iArr2;
                for (int i36 = 0; i36 <= i33; i36++) {
                    if (!zzgnVar.zzf()) {
                        zArr[i36] = zzgnVar.zzf();
                    } else {
                        zArr[i36] = true;
                    }
                }
                int i37 = i30 - 1;
                int[] iArr7 = new int[i35];
                int[] iArr8 = new int[i35];
                int i38 = 0;
                while (true) {
                    i10 = i34 * zzc16;
                    if (i37 < 0) {
                        break;
                    }
                    int i39 = iArr4[i37] + i10;
                    if (i39 < 0 && zArr[i29 + i37]) {
                        iArr7[i38] = i39;
                        i38++;
                    }
                    i37--;
                }
                if (i10 < 0 && zArr[i33]) {
                    iArr7[i38] = i10;
                    i38++;
                }
                i8 = i13;
                i9 = i21;
                int i40 = i38;
                for (int i41 = 0; i41 < i29; i41++) {
                    int i42 = iArr3[i41] + i10;
                    if (i42 < 0 && zArr[i41]) {
                        iArr7[i40] = i42;
                        i40++;
                    }
                }
                int[] copyOf = Arrays.copyOf(iArr7, i40);
                int i43 = 0;
                for (int i44 = i29 - 1; i44 >= 0; i44--) {
                    int i45 = iArr3[i44] + i10;
                    if (i45 > 0 && zArr[i44]) {
                        iArr8[i43] = i45;
                        i43++;
                    }
                }
                if (i10 > 0 && zArr[i33]) {
                    iArr8[i43] = i10;
                    i43++;
                }
                int i46 = i43;
                for (int i47 = 0; i47 < i30; i47++) {
                    int i48 = iArr4[i47] + i10;
                    if (i48 > 0 && zArr[i29 + i47]) {
                        iArr8[i46] = i48;
                        i46++;
                    }
                }
                iArr4 = Arrays.copyOf(iArr8, i46);
                i30 = i46;
                iArr3 = copyOf;
                i29 = i40;
            }
            i27++;
            i21 = i9;
            i13 = i8;
            zzc13 = i7;
            iArr2 = iArr;
        }
        int i49 = i13;
        int i50 = i21;
        int[] iArr9 = iArr2;
        if (zzgnVar.zzf()) {
            int zzc17 = zzgnVar.zzc();
            for (int i51 = 0; i51 < zzc17; i51++) {
                zzgnVar.zze(zzc12 + 5);
            }
        }
        zzgnVar.zze(2);
        float f = 1.0f;
        if (zzgnVar.zzf()) {
            if (zzgnVar.zzf()) {
                int zza6 = zzgnVar.zza(8);
                if (zza6 == 255) {
                    int zza7 = zzgnVar.zza(16);
                    int zza8 = zzgnVar.zza(16);
                    if (zza7 != 0 && zza8 != 0) {
                        f = zza7 / zza8;
                    }
                } else if (zza6 < 17) {
                    f = zzb[zza6];
                } else {
                    zzff.zzf("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + zza6);
                }
            }
            if (zzgnVar.zzf()) {
                zzgnVar.zzd();
            }
            if (zzgnVar.zzf()) {
                zzgnVar.zze(3);
                int i52 = true != zzgnVar.zzf() ? 2 : 1;
                if (zzgnVar.zzf()) {
                    int zza9 = zzgnVar.zza(8);
                    int zza10 = zzgnVar.zza(8);
                    zzgnVar.zze(8);
                    int zza11 = zzt.zza(zza9);
                    i6 = zzt.zzb(zza10);
                    i4 = zza11;
                } else {
                    i4 = -1;
                    i6 = -1;
                }
                i28 = i52;
            } else {
                i4 = -1;
                i6 = -1;
            }
            if (zzgnVar.zzf()) {
                zzgnVar.zzc();
                zzgnVar.zzc();
            }
            zzgnVar.zzd();
            if (zzgnVar.zzf()) {
                i22 += i22;
            }
            i5 = i6;
            i3 = i22;
        } else {
            i3 = i22;
            i4 = -1;
            i5 = -1;
        }
        return new zzgj(zza3, zzf, zza4, i49, i50, zzc10, zzc11, iArr9, zza5, zzc2, i20, i3, f, i4, i28, i5);
    }

    public static zzgk zzd(byte[] bArr, int i, int i2) {
        zzgn zzgnVar = new zzgn(bArr, 4, i2);
        int zzc2 = zzgnVar.zzc();
        int zzc3 = zzgnVar.zzc();
        zzgnVar.zzd();
        return new zzgk(zzc2, zzc3, zzgnVar.zzf());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzgl zze(byte[] r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgm.zze(byte[], int, int):com.google.android.gms.internal.ads.zzgl");
    }

    public static void zzf(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static int zzb(byte[] bArr, int i) {
        int i2;
        synchronized (zzc) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    try {
                        if (i3 >= i - 2) {
                            i3 = i;
                            break;
                        }
                        int i5 = i3 + 1;
                        if (bArr[i3] == 0 && bArr[i5] == 0 && bArr[i3 + 2] == 3) {
                            break;
                        }
                        i3 = i5;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i3 < i) {
                    int[] iArr = zzd;
                    int length = iArr.length;
                    if (length <= i4) {
                        zzd = Arrays.copyOf(iArr, length + length);
                    }
                    zzd[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = zzd[i8] - i6;
                System.arraycopy(bArr, i6, bArr, i7, i9);
                int i10 = i7 + i9;
                int i11 = i10 + 1;
                bArr[i10] = 0;
                i7 = i10 + 2;
                bArr[i11] = 0;
                i6 += i9 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i7, i2 - i7);
        }
        return i2;
    }
}
