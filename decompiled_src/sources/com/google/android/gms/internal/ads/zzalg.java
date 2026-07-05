package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzalg {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;

    private zzalg(int i, int i2, int i3, int i4, int i5) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
    }

    public static zzalg zza(String str) {
        char c;
        zzek.zzd(str.startsWith("Format:"));
        String[] split = TextUtils.split(str.substring(7), ",");
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        while (true) {
            int length = split.length;
            if (i >= length) {
                if (i2 == -1 || i3 == -1 || i5 == -1) {
                    return null;
                }
                return new zzalg(i2, i3, i4, i5, length);
            }
            String zza = zzfwk.zza(split[i].trim());
            switch (zza.hashCode()) {
                case 100571:
                    if (zza.equals("end")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3556653:
                    if (zza.equals("text")) {
                        c = 3;
                        break;
                    }
                    break;
                case 109757538:
                    if (zza.equals("start")) {
                        c = 0;
                        break;
                    }
                    break;
                case 109780401:
                    if (zza.equals("style")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            c = 65535;
            if (c == 0) {
                i2 = i;
            } else if (c == 1) {
                i3 = i;
            } else if (c == 2) {
                i4 = i;
            } else if (c == 3) {
                i5 = i;
            }
            i++;
        }
    }
}
