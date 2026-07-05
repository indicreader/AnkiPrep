package com.google.android.gms.internal.ads;

import android.graphics.Color;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzalk {
    public final String zza;
    public final int zzb;
    public final Integer zzc;
    public final Integer zzd;
    public final float zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final int zzj;

    private zzalk(String str, int i, Integer num, Integer num2, float f, boolean z, boolean z2, boolean z3, boolean z4, int i2) {
        this.zza = str;
        this.zzb = i;
        this.zzc = num;
        this.zzd = num2;
        this.zze = f;
        this.zzf = z;
        this.zzg = z2;
        this.zzh = z3;
        this.zzi = z4;
        this.zzj = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0109, code lost:
    
        if (r5 != 3) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f8 A[Catch: RuntimeException -> 0x0127, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0127, blocks: (B:7:0x003c, B:9:0x004b, B:10:0x0058, B:12:0x005c, B:13:0x0069, B:15:0x006d, B:16:0x007a, B:18:0x007e, B:20:0x0084, B:22:0x00a1, B:24:0x00a6, B:27:0x00b5, B:29:0x00b9, B:32:0x00ca, B:34:0x00ce, B:37:0x00df, B:39:0x00e3, B:42:0x00f4, B:44:0x00f8, B:46:0x00fe, B:51:0x0119, B:50:0x010b, B:64:0x008c), top: B:6:0x003c, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzalk zzb(java.lang.String r20, com.google.android.gms.internal.ads.zzali r21) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalk.zzb(java.lang.String, com.google.android.gms.internal.ads.zzali):com.google.android.gms.internal.ads.zzalk");
    }

    public static Integer zzc(String str) {
        long parseLong;
        try {
            if (str.startsWith("&H")) {
                parseLong = Long.parseLong(str.substring(2), 16);
            } else {
                parseLong = Long.parseLong(str);
            }
            zzek.zzd(parseLong <= 4294967295L);
            return Integer.valueOf(Color.argb(zzgcu.zza(((parseLong >> 24) & 255) ^ 255), zzgcu.zza(parseLong & 255), zzgcu.zza((parseLong >> 8) & 255), zzgcu.zza((parseLong >> 16) & 255)));
        } catch (IllegalArgumentException e) {
            zzff.zzg("SsaStyle", "Failed to parse color expression: '" + str + "'", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzd(String str) {
        int parseInt;
        try {
            parseInt = Integer.parseInt(str.trim());
        } catch (NumberFormatException unused) {
        }
        switch (parseInt) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return parseInt;
            default:
                zzff.zzf("SsaStyle", "Ignoring unknown alignment: ".concat(String.valueOf(str)));
                return -1;
        }
    }

    private static boolean zze(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            return parseInt == 1 || parseInt == -1;
        } catch (NumberFormatException e) {
            zzff.zzg("SsaStyle", "Failed to parse boolean value: '" + str + "'", e);
            return false;
        }
    }
}
