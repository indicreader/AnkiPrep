package com.google.android.gms.internal.ads;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzdv {
    private final int zza;
    private final int zzb;
    private final float zzc;
    private final float zzd;
    private final float zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final short[] zzi;
    private short[] zzj;
    private int zzk;
    private short[] zzl;
    private int zzm;
    private short[] zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private int zzv;

    public zzdv(int i, int i2, float f, float f2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = f;
        this.zzd = f2;
        this.zze = i / i3;
        this.zzf = i / 400;
        int i4 = i / 65;
        this.zzg = i4;
        int i5 = i4 + i4;
        this.zzh = i5;
        this.zzi = new short[i5];
        int i6 = i5 * i2;
        this.zzj = new short[i6];
        this.zzl = new short[i6];
        this.zzn = new short[i6];
    }

    private final int zzg(short[] sArr, int i, int i2, int i3) {
        int i4 = 1;
        int i5 = 255;
        int i6 = 0;
        int i7 = 0;
        while (i2 <= i3) {
            int i8 = 0;
            for (int i9 = 0; i9 < i2; i9++) {
                int i10 = this.zzb * i;
                i8 += Math.abs(sArr[i10 + i9] - sArr[(i10 + i2) + i9]);
            }
            int i11 = i8 * i6;
            int i12 = i4 * i2;
            if (i11 < i12) {
                i4 = i8;
            }
            if (i11 < i12) {
                i6 = i2;
            }
            int i13 = i8 * i5;
            int i14 = i7 * i2;
            if (i13 > i14) {
                i7 = i8;
            }
            if (i13 > i14) {
                i5 = i2;
            }
            i2++;
        }
        this.zzu = i4 / i6;
        this.zzv = i7 / i5;
        return i6;
    }

    private final void zzh(short[] sArr, int i, int i2) {
        short[] zzl = zzl(this.zzl, this.zzm, i2);
        this.zzl = zzl;
        int i3 = this.zzm;
        int i4 = this.zzb;
        System.arraycopy(sArr, i * i4, zzl, i3 * i4, i2 * i4);
        this.zzm += i2;
    }

    private final void zzi(short[] sArr, int i, int i2) {
        int i3;
        for (int i4 = 0; i4 < this.zzh / i2; i4++) {
            int i5 = 0;
            int i6 = 0;
            while (true) {
                int i7 = this.zzb;
                i3 = i7 * i2;
                if (i5 < i3) {
                    i6 += sArr[(i7 * i) + (i3 * i4) + i5];
                    i5++;
                }
            }
            this.zzi[i4] = (short) (i6 / i3);
        }
    }

    private static void zzj(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i4 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i3 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i9] = (short) (((sArr2[i7] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i9 += i2;
                i7 += i2;
                i8 += i2;
            }
        }
    }

    private final short[] zzl(short[] sArr, int i, int i2) {
        int length = sArr.length;
        int i3 = this.zzb;
        int i4 = length / i3;
        return i + i2 <= i4 ? sArr : Arrays.copyOf(sArr, (((i4 * 3) / 2) + i2) * i3);
    }

    public final int zza() {
        int i = this.zzm * this.zzb;
        return i + i;
    }

    public final int zzb() {
        int i = this.zzk * this.zzb;
        return i + i;
    }

    public final void zzc() {
        this.zzk = 0;
        this.zzm = 0;
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzt = 0;
        this.zzu = 0;
        this.zzv = 0;
    }

    public final void zzd(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.zzb, this.zzm);
        shortBuffer.put(this.zzl, 0, this.zzb * min);
        int i = this.zzm - min;
        this.zzm = i;
        int i2 = this.zzb;
        short[] sArr = this.zzl;
        System.arraycopy(sArr, min * i2, sArr, 0, i * i2);
    }

    public final void zze() {
        int i;
        int i2 = this.zzk;
        int i3 = this.zzm;
        float f = this.zzo;
        float f2 = this.zzc;
        float f3 = this.zze;
        float f4 = this.zzd;
        int i4 = i3 + ((int) ((((i2 / (f2 / f4)) + f) / (f3 * f4)) + 0.5f));
        int i5 = this.zzh;
        this.zzj = zzl(this.zzj, i2, i5 + i5 + i2);
        int i6 = 0;
        while (true) {
            int i7 = this.zzh;
            int i8 = this.zzb;
            i = i7 + i7;
            if (i6 >= i * i8) {
                break;
            }
            this.zzj[(i8 * i2) + i6] = 0;
            i6++;
        }
        this.zzk += i;
        zzk();
        if (this.zzm > i4) {
            this.zzm = i4;
        }
        this.zzk = 0;
        this.zzr = 0;
        this.zzo = 0;
    }

    public final void zzf(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.zzb;
        int i2 = remaining / i;
        int i3 = i * i2;
        short[] zzl = zzl(this.zzj, this.zzk, i2);
        this.zzj = zzl;
        shortBuffer.get(zzl, this.zzk * this.zzb, (i3 + i3) / 2);
        this.zzk += i2;
        zzk();
    }

    private final void zzk() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        float f = this.zzc / this.zzd;
        double d = f;
        int i9 = this.zzm;
        if (d > 1.00001d || d < 0.99999d) {
            int i10 = this.zzk;
            if (i10 >= this.zzh) {
                int i11 = 0;
                do {
                    int i12 = this.zzr;
                    if (i12 > 0) {
                        int min = Math.min(this.zzh, i12);
                        zzh(this.zzj, i11, min);
                        this.zzr -= min;
                        i11 += min;
                    } else {
                        short[] sArr = this.zzj;
                        int i13 = this.zza;
                        int i14 = i13 > 4000 ? i13 / 4000 : 1;
                        if (this.zzb != 1 || i14 != 1) {
                            zzi(sArr, i11, i14);
                            int zzg = zzg(this.zzi, 0, this.zzf / i14, this.zzg / i14);
                            if (i14 != 1) {
                                int i15 = zzg * i14;
                                int i16 = i14 * 4;
                                int i17 = this.zzf;
                                int i18 = i15 - i16;
                                if (i18 >= i17) {
                                    i17 = i18;
                                }
                                int i19 = i15 + i16;
                                int i20 = this.zzg;
                                if (i19 > i20) {
                                    i19 = i20;
                                }
                                if (this.zzb == 1) {
                                    i = zzg(sArr, i11, i17, i19);
                                } else {
                                    zzi(sArr, i11, 1);
                                    i = zzg(this.zzi, 0, i17, i19);
                                }
                            } else {
                                i = zzg;
                            }
                        } else {
                            i = zzg(sArr, i11, this.zzf, this.zzg);
                        }
                        int i21 = this.zzu;
                        int i22 = (i21 == 0 || (i4 = this.zzs) == 0 || this.zzv > i21 * 3 || i21 + i21 <= this.zzt * 3) ? i : i4;
                        int i23 = i11 + i22;
                        this.zzt = i21;
                        this.zzs = i;
                        float f2 = i22;
                        if (d > 1.0d) {
                            short[] sArr2 = this.zzj;
                            float f3 = (-1.0f) + f;
                            if (f >= 2.0f) {
                                i3 = (int) (f2 / f3);
                            } else {
                                this.zzr = (int) ((f2 * (2.0f - f)) / f3);
                                i3 = i22;
                            }
                            short[] zzl = zzl(this.zzl, this.zzm, i3);
                            this.zzl = zzl;
                            int i24 = i3;
                            zzj(i3, this.zzb, zzl, this.zzm, sArr2, i11, sArr2, i23);
                            this.zzm += i24;
                            i11 += i22 + i24;
                        } else {
                            int i25 = i22;
                            short[] sArr3 = this.zzj;
                            float f4 = 1.0f - f;
                            if (f < 0.5f) {
                                i2 = (int) ((f2 * f) / f4);
                            } else {
                                this.zzr = (int) ((f2 * ((f + f) - 1.0f)) / f4);
                                i2 = i25;
                            }
                            int i26 = i25 + i2;
                            short[] zzl2 = zzl(this.zzl, this.zzm, i26);
                            this.zzl = zzl2;
                            int i27 = this.zzb;
                            System.arraycopy(sArr3, i11 * i27, zzl2, this.zzm * i27, i27 * i25);
                            zzj(i2, this.zzb, this.zzl, this.zzm + i25, sArr3, i23, sArr3, i11);
                            this.zzm += i26;
                            i11 += i2;
                        }
                    }
                } while (this.zzh + i11 <= i10);
                int i28 = this.zzk - i11;
                short[] sArr4 = this.zzj;
                int i29 = this.zzb;
                System.arraycopy(sArr4, i11 * i29, sArr4, 0, i29 * i28);
                this.zzk = i28;
            }
        } else {
            zzh(this.zzj, 0, this.zzk);
            this.zzk = 0;
        }
        float f5 = this.zze * this.zzd;
        if (f5 == 1.0f || this.zzm == i9) {
            return;
        }
        int i30 = this.zza;
        int i31 = (int) (i30 / f5);
        while (true) {
            if (i31 <= 16384 && i30 <= 16384) {
                break;
            }
            i31 /= 2;
            i30 /= 2;
        }
        int i32 = this.zzm - i9;
        short[] zzl3 = zzl(this.zzn, this.zzo, i32);
        this.zzn = zzl3;
        short[] sArr5 = this.zzl;
        int i33 = this.zzb;
        System.arraycopy(sArr5, i9 * i33, zzl3, this.zzo * i33, i33 * i32);
        this.zzm = i9;
        this.zzo += i32;
        int i34 = 0;
        while (true) {
            i5 = this.zzo;
            i6 = i5 - 1;
            if (i34 >= i6) {
                break;
            }
            while (true) {
                i7 = this.zzp + 1;
                int i35 = i7 * i31;
                i8 = this.zzq;
                if (i35 <= i8 * i30) {
                    break;
                }
                this.zzl = zzl(this.zzl, this.zzm, 1);
                int i36 = 0;
                while (true) {
                    int i37 = this.zzb;
                    if (i36 < i37) {
                        short[] sArr6 = this.zzl;
                        int i38 = this.zzm * i37;
                        short[] sArr7 = this.zzn;
                        int i39 = (i34 * i37) + i36;
                        short s = sArr7[i39];
                        short s2 = sArr7[i39 + i37];
                        int i40 = this.zzq * i30;
                        int i41 = this.zzp;
                        int i42 = i41 * i31;
                        int i43 = (i41 + 1) * i31;
                        int i44 = i43 - i40;
                        int i45 = i43 - i42;
                        sArr6[i38 + i36] = (short) (((s * i44) + ((i45 - i44) * s2)) / i45);
                        i36++;
                    }
                }
                this.zzq++;
                this.zzm++;
            }
            this.zzp = i7;
            if (i7 == i30) {
                this.zzp = 0;
                zzek.zzf(i8 == i31);
                this.zzq = 0;
            }
            i34++;
        }
        if (i6 != 0) {
            short[] sArr8 = this.zzn;
            int i46 = this.zzb;
            System.arraycopy(sArr8, i6 * i46, sArr8, 0, (i5 - i6) * i46);
            this.zzo -= i6;
        }
    }
}
