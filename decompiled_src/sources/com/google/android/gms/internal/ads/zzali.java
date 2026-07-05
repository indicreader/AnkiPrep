package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzali {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final int zzk;

    private zzali(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = i6;
        this.zzg = i7;
        this.zzh = i8;
        this.zzi = i9;
        this.zzj = i10;
        this.zzk = i11;
    }

    public static zzali zza(String str) {
        char c;
        String[] split = TextUtils.split(str.substring(7), ",");
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        int i10 = -1;
        int i11 = -1;
        while (true) {
            int length = split.length;
            if (i >= length) {
                if (i2 != -1) {
                    return new zzali(i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, length);
                }
                return null;
            }
            String zza = zzfwk.zza(split[i].trim());
            switch (zza.hashCode()) {
                case -1178781136:
                    if (zza.equals("italic")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1026963764:
                    if (zza.equals("underline")) {
                        c = 7;
                        break;
                    }
                    break;
                case -192095652:
                    if (zza.equals("strikeout")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -70925746:
                    if (zza.equals("primarycolour")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3029637:
                    if (zza.equals("bold")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3373707:
                    if (zza.equals("name")) {
                        c = 0;
                        break;
                    }
                    break;
                case 366554320:
                    if (zza.equals("fontsize")) {
                        c = 4;
                        break;
                    }
                    break;
                case 767321349:
                    if (zza.equals("borderstyle")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 1767875043:
                    if (zza.equals("alignment")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1988365454:
                    if (zza.equals("outlinecolour")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            c = 65535;
            switch (c) {
                case 0:
                    i2 = i;
                    break;
                case 1:
                    i3 = i;
                    break;
                case 2:
                    i4 = i;
                    break;
                case 3:
                    i5 = i;
                    break;
                case 4:
                    i6 = i;
                    break;
                case 5:
                    i7 = i;
                    break;
                case 6:
                    i8 = i;
                    break;
                case 7:
                    i9 = i;
                    break;
                case '\b':
                    i10 = i;
                    break;
                case '\t':
                    i11 = i;
                    break;
            }
            i++;
        }
    }
}
