package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgmn {
    public static byte[] zza(byte[] bArr, byte[] bArr2) {
        long zzb = zzb(bArr, 0, 0);
        long zzb2 = zzb(bArr, 3, 2) & 67108611;
        long zzb3 = zzb(bArr, 6, 4) & 67092735;
        long zzb4 = zzb(bArr, 9, 6) & 66076671;
        long zzb5 = zzb(bArr, 12, 8) & 1048575;
        int i = 17;
        byte[] bArr3 = new byte[17];
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        while (true) {
            int length = bArr2.length;
            if (i2 < length) {
                int min = Math.min(16, length - i2);
                System.arraycopy(bArr2, i2, bArr3, 0, min);
                bArr3[min] = 1;
                if (min != 16) {
                    Arrays.fill(bArr3, min + 1, i, (byte) 0);
                }
                long j6 = zzb5 * 5;
                long j7 = zzb4 * 5;
                long j8 = zzb3 * 5;
                long zzb6 = j5 + zzb(bArr3, 0, 0);
                long zzb7 = j2 + zzb(bArr3, 3, 2);
                long zzb8 = j + zzb(bArr3, 6, 4);
                long zzb9 = j3 + zzb(bArr3, 9, 6);
                long zzb10 = j4 + (zzb(bArr3, 12, 8) | (bArr3[16] << Ascii.CAN));
                long j9 = zzb7 * zzb;
                long j10 = zzb7 * zzb2;
                long j11 = zzb7 * zzb3;
                long j12 = zzb9 * zzb;
                long j13 = zzb7 * zzb4;
                long j14 = zzb10 * zzb;
                long j15 = (zzb6 * zzb) + (zzb7 * j6) + (zzb8 * j7) + (zzb9 * j8) + (zzb2 * 5 * zzb10);
                long j16 = (zzb6 * zzb2) + j9 + (zzb8 * j6) + (zzb9 * j7) + (j8 * zzb10) + (j15 >> 26);
                long j17 = (zzb6 * zzb3) + j10 + (zzb8 * zzb) + (zzb9 * j6) + (j7 * zzb10) + (j16 >> 26);
                long j18 = (zzb6 * zzb4) + j11 + (zzb8 * zzb2) + j12 + (zzb10 * j6) + (j17 >> 26);
                long j19 = (zzb6 * zzb5) + j13 + (zzb8 * zzb3) + (zzb9 * zzb2) + j14 + (j18 >> 26);
                long j20 = (j15 & 67108863) + ((j19 >> 26) * 5);
                j2 = (j16 & 67108863) + (j20 >> 26);
                i2 += 16;
                j = j17 & 67108863;
                j3 = j18 & 67108863;
                j4 = j19 & 67108863;
                i = 17;
                j5 = j20 & 67108863;
            } else {
                long j21 = j + (j2 >> 26);
                long j22 = j21 & 67108863;
                long j23 = j3 + (j21 >> 26);
                long j24 = j23 & 67108863;
                long j25 = j4 + (j23 >> 26);
                long j26 = j25 & 67108863;
                long j27 = j5 + ((j25 >> 26) * 5);
                long j28 = j27 & 67108863;
                long j29 = j28 + 5;
                long j30 = (j2 & 67108863) + (j27 >> 26);
                long j31 = j30 + (j29 >> 26);
                long j32 = (j31 >> 26) + j22;
                long j33 = j24 + (j32 >> 26);
                long j34 = (j26 + (j33 >> 26)) - 67108864;
                long j35 = j34 >> 63;
                long j36 = ~j35;
                long j37 = (j30 & j35) | (j31 & 67108863 & j36);
                long j38 = (j22 & j35) | (j32 & 67108863 & j36);
                long j39 = (j24 & j35) | (j33 & 67108863 & j36);
                long j40 = (j26 & j35) | (j34 & j36);
                long zzc = (((j35 & j28) | (j29 & 67108863 & j36) | (j37 << 26)) & 4294967295L) + zzc(bArr, 16);
                long zzc2 = (((j37 >> 6) | (j38 << 20)) & 4294967295L) + zzc(bArr, 20);
                long zzc3 = (((j38 >> 12) | (j39 << 14)) & 4294967295L) + zzc(bArr, 24);
                long zzc4 = (((j39 >> 18) | (j40 << 8)) & 4294967295L) + zzc(bArr, 28);
                byte[] bArr4 = new byte[16];
                zzd(bArr4, zzc & 4294967295L, 0);
                long j41 = zzc2 + (zzc >> 32);
                zzd(bArr4, j41 & 4294967295L, 4);
                long j42 = zzc3 + (j41 >> 32);
                zzd(bArr4, j42 & 4294967295L, 8);
                zzd(bArr4, (zzc4 + (j42 >> 32)) & 4294967295L, 12);
                return bArr4;
            }
        }
    }

    private static long zzb(byte[] bArr, int i, int i2) {
        return (zzc(bArr, i) >> i2) & 67108863;
    }

    private static long zzc(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return (((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16)) & 4294967295L;
    }

    private static void zzd(byte[] bArr, long j, int i) {
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i + i2] = (byte) (255 & j);
            j >>= 8;
        }
    }
}
