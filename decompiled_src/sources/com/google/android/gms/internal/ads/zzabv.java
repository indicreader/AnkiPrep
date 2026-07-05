package com.google.android.gms.internal.ads;

import androidx.core.location.LocationRequestCompat;
import java.nio.ByteBuffer;
import okio.Utf8;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzabv {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 3, 6};
    private static final int[] zzc = {48000, 44100, 32000};
    private static final int[] zzd = {24000, 22050, 16000};
    private static final int[] zze = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzf = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] zzg = {69, 87, LocationRequestCompat.QUALITY_LOW_POWER, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int zza(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return zzb[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    public static int zzb(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            int i = bArr[2] & 7;
            int i2 = ((bArr[3] & 255) | (i << 8)) + 1;
            return i2 + i2;
        }
        byte b = bArr[4];
        return zzf((b & 192) >> 6, b & Utf8.REPLACEMENT_BYTE);
    }

    public static zzam zzc(zzfp zzfpVar, String str, String str2, zzae zzaeVar) {
        zzfo zzfoVar = new zzfo();
        zzfoVar.zzi(zzfpVar);
        int i = zzc[zzfoVar.zzd(2)];
        zzfoVar.zzm(8);
        int i2 = zze[zzfoVar.zzd(3)];
        if (zzfoVar.zzd(1) != 0) {
            i2++;
        }
        int i3 = zzf[zzfoVar.zzd(5)] * 1000;
        zzfoVar.zze();
        zzfpVar.zzK(zzfoVar.zzb());
        zzak zzakVar = new zzak();
        zzakVar.zzK(str);
        zzakVar.zzW("audio/ac3");
        zzakVar.zzy(i2);
        zzakVar.zzX(i);
        zzakVar.zzE(zzaeVar);
        zzakVar.zzN(str2);
        zzakVar.zzx(i3);
        zzakVar.zzR(i3);
        return zzakVar.zzac();
    }

    public static zzam zzd(zzfp zzfpVar, String str, String str2, zzae zzaeVar) {
        String str3;
        zzfo zzfoVar = new zzfo();
        zzfoVar.zzi(zzfpVar);
        int zzd2 = zzfoVar.zzd(13) * 1000;
        zzfoVar.zzm(3);
        int i = zzc[zzfoVar.zzd(2)];
        zzfoVar.zzm(10);
        int i2 = zze[zzfoVar.zzd(3)];
        if (zzfoVar.zzd(1) != 0) {
            i2++;
        }
        zzfoVar.zzm(3);
        int zzd3 = zzfoVar.zzd(4);
        zzfoVar.zzm(1);
        if (zzd3 > 0) {
            zzfoVar.zzm(6);
            if (zzfoVar.zzd(1) != 0) {
                i2 += 2;
            }
            zzfoVar.zzm(1);
        }
        if (zzfoVar.zza() > 7) {
            zzfoVar.zzm(7);
            if (zzfoVar.zzd(1) != 0) {
                str3 = "audio/eac3-joc";
                zzfoVar.zze();
                zzfpVar.zzK(zzfoVar.zzb());
                zzak zzakVar = new zzak();
                zzakVar.zzK(str);
                zzakVar.zzW(str3);
                zzakVar.zzy(i2);
                zzakVar.zzX(i);
                zzakVar.zzE(zzaeVar);
                zzakVar.zzN(str2);
                zzakVar.zzR(zzd2);
                return zzakVar.zzac();
            }
        }
        str3 = "audio/eac3";
        zzfoVar.zze();
        zzfpVar.zzK(zzfoVar.zzb());
        zzak zzakVar2 = new zzak();
        zzakVar2.zzK(str);
        zzakVar2.zzW(str3);
        zzakVar2.zzy(i2);
        zzakVar2.zzX(i);
        zzakVar2.zzE(zzaeVar);
        zzakVar2.zzN(str2);
        zzakVar2.zzR(zzd2);
        return zzakVar2.zzac();
    }

    public static zzabu zze(zzfo zzfoVar) {
        int i;
        int i2;
        String str;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int zzc2 = zzfoVar.zzc();
        zzfoVar.zzm(40);
        int zzd2 = zzfoVar.zzd(5);
        zzfoVar.zzk(zzc2);
        int i12 = -1;
        if (zzd2 > 10) {
            zzfoVar.zzm(16);
            int zzd3 = zzfoVar.zzd(2);
            if (zzd3 == 0) {
                i12 = 0;
            } else if (zzd3 == 1) {
                i12 = 1;
            } else if (zzd3 == 2) {
                i12 = 2;
            }
            zzfoVar.zzm(3);
            int zzd4 = zzfoVar.zzd(11) + 1;
            int zzd5 = zzfoVar.zzd(2);
            if (zzd5 == 3) {
                i8 = zzd[zzfoVar.zzd(2)];
                i9 = 6;
                i7 = 3;
            } else {
                int zzd6 = zzfoVar.zzd(2);
                int i13 = zzb[zzd6];
                i7 = zzd6;
                i8 = zzc[zzd5];
                i9 = i13;
            }
            int i14 = zzd4 + zzd4;
            int i15 = (i14 * i8) / (i9 * 32);
            int zzd7 = zzfoVar.zzd(3);
            boolean zzo = zzfoVar.zzo();
            i = zze[zzd7] + (zzo ? 1 : 0);
            zzfoVar.zzm(10);
            if (zzfoVar.zzo()) {
                zzfoVar.zzm(8);
            }
            if (zzd7 == 0) {
                zzfoVar.zzm(5);
                if (zzfoVar.zzo()) {
                    zzfoVar.zzm(8);
                }
                i10 = 0;
                zzd7 = 0;
            } else {
                i10 = zzd7;
            }
            if (i12 == 1) {
                if (zzfoVar.zzo()) {
                    zzfoVar.zzm(16);
                }
                i11 = 1;
            } else {
                i11 = i12;
            }
            if (zzfoVar.zzo()) {
                if (i10 > 2) {
                    zzfoVar.zzm(2);
                }
                if ((i10 & 1) != 0 && i10 > 2) {
                    zzfoVar.zzm(6);
                }
                if ((i10 & 4) != 0) {
                    zzfoVar.zzm(6);
                }
                if (zzo && zzfoVar.zzo()) {
                    zzfoVar.zzm(5);
                }
                if (i11 == 0) {
                    if (zzfoVar.zzo()) {
                        zzfoVar.zzm(6);
                    }
                    if (i10 == 0 && zzfoVar.zzo()) {
                        zzfoVar.zzm(6);
                    }
                    if (zzfoVar.zzo()) {
                        zzfoVar.zzm(6);
                    }
                    int zzd8 = zzfoVar.zzd(2);
                    if (zzd8 == 1) {
                        zzfoVar.zzm(5);
                    } else if (zzd8 == 2) {
                        zzfoVar.zzm(12);
                    } else if (zzd8 == 3) {
                        int zzd9 = zzfoVar.zzd(5);
                        if (zzfoVar.zzo()) {
                            zzfoVar.zzm(5);
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(4);
                            }
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(4);
                            }
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(4);
                            }
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(4);
                            }
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(4);
                            }
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(4);
                            }
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(4);
                            }
                            if (zzfoVar.zzo()) {
                                if (zzfoVar.zzo()) {
                                    zzfoVar.zzm(4);
                                }
                                if (zzfoVar.zzo()) {
                                    zzfoVar.zzm(4);
                                }
                            }
                        }
                        if (zzfoVar.zzo()) {
                            zzfoVar.zzm(5);
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(7);
                                if (zzfoVar.zzo()) {
                                    zzfoVar.zzm(8);
                                }
                            }
                        }
                        zzfoVar.zzm((zzd9 + 2) * 8);
                        zzfoVar.zze();
                    }
                    if (i10 < 2) {
                        if (zzfoVar.zzo()) {
                            zzfoVar.zzm(14);
                        }
                        if (zzd7 == 0 && zzfoVar.zzo()) {
                            zzfoVar.zzm(14);
                        }
                    }
                    if (zzfoVar.zzo()) {
                        if (i7 == 0) {
                            zzfoVar.zzm(5);
                            i11 = 0;
                            i7 = 0;
                        } else {
                            for (int i16 = 0; i16 < i9; i16++) {
                                if (zzfoVar.zzo()) {
                                    zzfoVar.zzm(5);
                                }
                            }
                        }
                    }
                    i11 = 0;
                }
            }
            if (zzfoVar.zzo()) {
                zzfoVar.zzm(5);
                if (i10 == 2) {
                    zzfoVar.zzm(4);
                    i10 = 2;
                }
                if (i10 >= 6) {
                    zzfoVar.zzm(2);
                }
                if (zzfoVar.zzo()) {
                    zzfoVar.zzm(8);
                }
                if (i10 == 0 && zzfoVar.zzo()) {
                    zzfoVar.zzm(8);
                }
                if (zzd5 < 3) {
                    zzfoVar.zzl();
                }
            }
            if (i11 == 0 && i7 != 3) {
                zzfoVar.zzl();
            }
            if (i11 == 2 && (i7 == 3 || zzfoVar.zzo())) {
                zzfoVar.zzm(6);
            }
            str = (zzfoVar.zzo() && zzfoVar.zzd(6) == 1 && zzfoVar.zzd(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i2 = i12;
            i4 = i14;
            i5 = i8;
            i6 = i9 * 256;
            i3 = i15;
        } else {
            zzfoVar.zzm(32);
            int zzd10 = zzfoVar.zzd(2);
            String str2 = zzd10 == 3 ? null : "audio/ac3";
            int zzd11 = zzfoVar.zzd(6);
            int i17 = zzf[zzd11 / 2] * 1000;
            int zzf2 = zzf(zzd10, zzd11);
            zzfoVar.zzm(8);
            int zzd12 = zzfoVar.zzd(3);
            if ((zzd12 & 1) != 0 && zzd12 != 1) {
                zzfoVar.zzm(2);
            }
            if ((zzd12 & 4) != 0) {
                zzfoVar.zzm(2);
            }
            if (zzd12 == 2) {
                zzfoVar.zzm(2);
            }
            int i18 = zzd10 < 3 ? zzc[zzd10] : -1;
            i = zze[zzd12] + (zzfoVar.zzo() ? 1 : 0);
            i2 = -1;
            str = str2;
            i3 = i17;
            i4 = zzf2;
            i5 = i18;
            i6 = 1536;
        }
        return new zzabu(str, i2, i, i5, i4, i6, i3, null);
    }

    private static int zzf(int i, int i2) {
        int i3;
        if (i < 0 || i >= 3 || i2 < 0 || (i3 = i2 >> 1) >= 19) {
            return -1;
        }
        int i4 = zzc[i];
        if (i4 == 44100) {
            int i5 = zzg[i3] + (i2 & 1);
            return i5 + i5;
        }
        int i6 = zzf[i3];
        return i4 == 32000 ? i6 * 6 : i6 * 4;
    }
}
