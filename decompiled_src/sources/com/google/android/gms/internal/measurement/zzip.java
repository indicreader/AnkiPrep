package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
/* loaded from: classes3.dex */
public final class zzip {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i, zzio zzioVar) throws zzkm {
        int zzj = zzj(bArr, i, zzioVar);
        int i2 = zzioVar.zza;
        if (i2 < 0) {
            throw zzkm.zzd();
        }
        if (i2 > bArr.length - zzj) {
            throw zzkm.zzf();
        }
        if (i2 == 0) {
            zzioVar.zzc = zzjb.zzb;
            return zzj;
        }
        zzioVar.zzc = zzjb.zzl(bArr, zzj, i2);
        return zzj + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(zzlu zzluVar, byte[] bArr, int i, int i2, int i3, zzio zzioVar) throws IOException {
        zzlm zzlmVar = (zzlm) zzluVar;
        Object zze = zzlmVar.zze();
        int zzc = zzlmVar.zzc(zze, bArr, i, i2, i3, zzioVar);
        zzlmVar.zzf(zze);
        zzioVar.zzc = zze;
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(zzlu zzluVar, byte[] bArr, int i, int i2, zzio zzioVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zzk(i4, bArr, i3, zzioVar);
            i4 = zzioVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw zzkm.zzf();
        }
        Object zze = zzluVar.zze();
        int i6 = i4 + i5;
        zzluVar.zzh(zze, bArr, i5, i6, zzioVar);
        zzluVar.zzf(zze);
        zzioVar.zzc = zze;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(zzlu zzluVar, int i, byte[] bArr, int i2, int i3, zzkj zzkjVar, zzio zzioVar) throws IOException {
        int zzd = zzd(zzluVar, bArr, i2, i3, zzioVar);
        zzkjVar.add(zzioVar.zzc);
        while (zzd < i3) {
            int zzj = zzj(bArr, zzd, zzioVar);
            if (i != zzioVar.zza) {
                break;
            }
            zzd = zzd(zzluVar, bArr, zzj, i3, zzioVar);
            zzkjVar.add(zzioVar.zzc);
        }
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i, zzkj zzkjVar, zzio zzioVar) throws IOException {
        zzkd zzkdVar = (zzkd) zzkjVar;
        int zzj = zzj(bArr, i, zzioVar);
        int i2 = zzioVar.zza + zzj;
        while (zzj < i2) {
            zzj = zzj(bArr, zzj, zzioVar);
            zzkdVar.zzh(zzioVar.zza);
        }
        if (zzj == i2) {
            return zzj;
        }
        throw zzkm.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(byte[] bArr, int i, zzio zzioVar) throws zzkm {
        int zzj = zzj(bArr, i, zzioVar);
        int i2 = zzioVar.zza;
        if (i2 < 0) {
            throw zzkm.zzd();
        }
        if (i2 == 0) {
            zzioVar.zzc = "";
            return zzj;
        }
        zzioVar.zzc = new String(bArr, zzj, i2, zzkk.zzb);
        return zzj + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(byte[] bArr, int i, zzio zzioVar) throws zzkm {
        int zzj = zzj(bArr, i, zzioVar);
        int i2 = zzioVar.zza;
        if (i2 < 0) {
            throw zzkm.zzd();
        }
        if (i2 == 0) {
            zzioVar.zzc = "";
            return zzj;
        }
        zzioVar.zzc = zzna.zzd(bArr, zzj, i2);
        return zzj + i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i, byte[] bArr, int i2, int i3, zzmm zzmmVar, zzio zzioVar) throws zzkm {
        if ((i >>> 3) == 0) {
            throw zzkm.zzb();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int zzm = zzm(bArr, i2, zzioVar);
            zzmmVar.zzh(i, Long.valueOf(zzioVar.zzb));
            return zzm;
        }
        if (i4 == 1) {
            zzmmVar.zzh(i, Long.valueOf(zzn(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int zzj = zzj(bArr, i2, zzioVar);
            int i5 = zzioVar.zza;
            if (i5 < 0) {
                throw zzkm.zzd();
            }
            if (i5 > bArr.length - zzj) {
                throw zzkm.zzf();
            }
            if (i5 == 0) {
                zzmmVar.zzh(i, zzjb.zzb);
            } else {
                zzmmVar.zzh(i, zzjb.zzl(bArr, zzj, i5));
            }
            return zzj + i5;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                zzmmVar.zzh(i, Integer.valueOf(zzb(bArr, i2)));
                return i2 + 4;
            }
            throw zzkm.zzb();
        }
        int i6 = (i & (-8)) | 4;
        zzmm zze = zzmm.zze();
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int zzj2 = zzj(bArr, i2, zzioVar);
            int i8 = zzioVar.zza;
            if (i8 == i6) {
                i7 = i8;
                i2 = zzj2;
                break;
            }
            i7 = i8;
            i2 = zzi(i8, bArr, zzj2, i3, zze, zzioVar);
        }
        if (i2 > i3 || i7 != i6) {
            throw zzkm.zze();
        }
        zzmmVar.zzh(i, zze);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(byte[] bArr, int i, zzio zzioVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zzioVar);
        }
        zzioVar.zza = b;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(int i, byte[] bArr, int i2, zzio zzioVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzioVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzioVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzioVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzioVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzioVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(int i, byte[] bArr, int i2, int i3, zzkj zzkjVar, zzio zzioVar) {
        zzkd zzkdVar = (zzkd) zzkjVar;
        int zzj = zzj(bArr, i2, zzioVar);
        zzkdVar.zzh(zzioVar.zza);
        while (zzj < i3) {
            int zzj2 = zzj(bArr, zzj, zzioVar);
            if (i != zzioVar.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzioVar);
            zzkdVar.zzh(zzioVar.zza);
        }
        return zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(byte[] bArr, int i, zzio zzioVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzioVar.zzb = j;
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
        zzioVar.zzb = j2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzn(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }
}
