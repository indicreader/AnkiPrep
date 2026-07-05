package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgxy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i, zzgxx zzgxxVar) throws zzhag {
        int zzh = zzh(bArr, i, zzgxxVar);
        int i2 = zzgxxVar.zza;
        if (i2 < 0) {
            throw zzhag.zzf();
        }
        if (i2 > bArr.length - zzh) {
            throw zzhag.zzj();
        }
        if (i2 == 0) {
            zzgxxVar.zzc = zzgyl.zzb;
            return zzh;
        }
        zzgxxVar.zzc = zzgyl.zzv(bArr, zzh, i2);
        return zzh + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(zzhby zzhbyVar, byte[] bArr, int i, int i2, int i3, zzgxx zzgxxVar) throws IOException {
        Object zze = zzhbyVar.zze();
        int zzl = zzl(zze, zzhbyVar, bArr, i, i2, i3, zzgxxVar);
        zzhbyVar.zzf(zze);
        zzgxxVar.zzc = zze;
        return zzl;
    }

    static int zzd(zzhby zzhbyVar, byte[] bArr, int i, int i2, zzgxx zzgxxVar) throws IOException {
        Object zze = zzhbyVar.zze();
        int zzm = zzm(zze, zzhbyVar, bArr, i, i2, zzgxxVar);
        zzhbyVar.zzf(zze);
        zzgxxVar.zzc = zze;
        return zzm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(zzhby zzhbyVar, int i, byte[] bArr, int i2, int i3, zzhad zzhadVar, zzgxx zzgxxVar) throws IOException {
        int zzd = zzd(zzhbyVar, bArr, i2, i3, zzgxxVar);
        zzhadVar.add(zzgxxVar.zzc);
        while (zzd < i3) {
            int zzh = zzh(bArr, zzd, zzgxxVar);
            if (i != zzgxxVar.zza) {
                break;
            }
            zzd = zzd(zzhbyVar, bArr, zzh, i3, zzgxxVar);
            zzhadVar.add(zzgxxVar.zzc);
        }
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i, zzhad zzhadVar, zzgxx zzgxxVar) throws IOException {
        zzgzv zzgzvVar = (zzgzv) zzhadVar;
        int zzh = zzh(bArr, i, zzgxxVar);
        int i2 = zzgxxVar.zza + zzh;
        while (zzh < i2) {
            zzh = zzh(bArr, zzh, zzgxxVar);
            zzgzvVar.zzh(zzgxxVar.zza);
        }
        if (zzh == i2) {
            return zzh;
        }
        throw zzhag.zzj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(int i, byte[] bArr, int i2, int i3, zzhcq zzhcqVar, zzgxx zzgxxVar) throws zzhag {
        if ((i >>> 3) == 0) {
            throw zzhag.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int zzk = zzk(bArr, i2, zzgxxVar);
            zzhcqVar.zzj(i, Long.valueOf(zzgxxVar.zzb));
            return zzk;
        }
        if (i4 == 1) {
            zzhcqVar.zzj(i, Long.valueOf(zzn(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int zzh = zzh(bArr, i2, zzgxxVar);
            int i5 = zzgxxVar.zza;
            if (i5 < 0) {
                throw zzhag.zzf();
            }
            if (i5 > bArr.length - zzh) {
                throw zzhag.zzj();
            }
            if (i5 == 0) {
                zzhcqVar.zzj(i, zzgyl.zzb);
            } else {
                zzhcqVar.zzj(i, zzgyl.zzv(bArr, zzh, i5));
            }
            return zzh + i5;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                zzhcqVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
                return i2 + 4;
            }
            throw zzhag.zzc();
        }
        int i6 = (i & (-8)) | 4;
        zzhcq zzf = zzhcq.zzf();
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int zzh2 = zzh(bArr, i2, zzgxxVar);
            int i8 = zzgxxVar.zza;
            i7 = i8;
            if (i8 == i6) {
                i2 = zzh2;
                break;
            }
            int zzg = zzg(i7, bArr, zzh2, i3, zzf, zzgxxVar);
            i7 = i8;
            i2 = zzg;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzhag.zzg();
        }
        zzhcqVar.zzj(i, zzf);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(byte[] bArr, int i, zzgxx zzgxxVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzi(b, bArr, i2, zzgxxVar);
        }
        zzgxxVar.zza = b;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i, byte[] bArr, int i2, zzgxx zzgxxVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzgxxVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzgxxVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzgxxVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzgxxVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzgxxVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i, byte[] bArr, int i2, int i3, zzhad zzhadVar, zzgxx zzgxxVar) {
        zzgzv zzgzvVar = (zzgzv) zzhadVar;
        int zzh = zzh(bArr, i2, zzgxxVar);
        zzgzvVar.zzh(zzgxxVar.zza);
        while (zzh < i3) {
            int zzh2 = zzh(bArr, zzh, zzgxxVar);
            if (i != zzgxxVar.zza) {
                break;
            }
            zzh = zzh(bArr, zzh2, zzgxxVar);
            zzgzvVar.zzh(zzgxxVar.zza);
        }
        return zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(byte[] bArr, int i, zzgxx zzgxxVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzgxxVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & Byte.MAX_VALUE) << i4;
            b = bArr[i3];
            i3 = i5;
        }
        zzgxxVar.zzb = j2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(Object obj, zzhby zzhbyVar, byte[] bArr, int i, int i2, int i3, zzgxx zzgxxVar) throws IOException {
        int zzc = ((zzhbh) zzhbyVar).zzc(obj, bArr, i, i2, i3, zzgxxVar);
        zzgxxVar.zzc = obj;
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(Object obj, zzhby zzhbyVar, byte[] bArr, int i, int i2, zzgxx zzgxxVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zzi(i4, bArr, i3, zzgxxVar);
            i4 = zzgxxVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw zzhag.zzj();
        }
        int i6 = i4 + i5;
        zzhbyVar.zzi(obj, bArr, i5, i6, zzgxxVar);
        zzgxxVar.zzc = obj;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzn(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }
}
