package com.google.android.gms.internal.ads;

import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzaly {
    private static final Pattern zza = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private static final Pattern zzb = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    private final zzfp zzc = new zzfp();
    private final StringBuilder zzd = new StringBuilder();

    static String zza(zzfp zzfpVar, StringBuilder sb) {
        zzc(zzfpVar);
        if (zzfpVar.zzb() == 0) {
            return null;
        }
        String zzd = zzd(zzfpVar, sb);
        if (!"".equals(zzd)) {
            return zzd;
        }
        char zzm = (char) zzfpVar.zzm();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(zzm);
        return sb2.toString();
    }

    static void zzc(zzfp zzfpVar) {
        while (true) {
            for (boolean z = true; zzfpVar.zzb() > 0 && z; z = false) {
                char c = (char) zzfpVar.zzM()[zzfpVar.zzd()];
                if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
                    zzfpVar.zzL(1);
                } else {
                    int zzd = zzfpVar.zzd();
                    int zze = zzfpVar.zze();
                    byte[] zzM = zzfpVar.zzM();
                    if (zzd + 2 <= zze) {
                        int i = zzd + 1;
                        if (zzM[zzd] == 47) {
                            int i2 = zzd + 2;
                            if (zzM[i] == 42) {
                                while (true) {
                                    int i3 = i2 + 1;
                                    if (i3 >= zze) {
                                        break;
                                    }
                                    if (((char) zzM[i2]) == '*' && ((char) zzM[i3]) == '/') {
                                        zze = i2 + 2;
                                        i2 = zze;
                                    } else {
                                        i2 = i3;
                                    }
                                }
                                zzfpVar.zzL(zze - zzfpVar.zzd());
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return;
        }
    }

    private static String zzd(zzfp zzfpVar, StringBuilder sb) {
        sb.setLength(0);
        int zzd = zzfpVar.zzd();
        int zze = zzfpVar.zze();
        loop0: while (true) {
            for (boolean z = false; zzd < zze && !z; z = true) {
                char c = (char) zzfpVar.zzM()[zzd];
                if ((c >= 'A' && c <= 'Z') || ((c >= 'a' && c <= 'z') || ((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_'))) {
                    sb.append(c);
                    zzd++;
                }
            }
        }
        zzfpVar.zzL(zzd - zzfpVar.zzd());
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:171:0x0317, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x00b0, code lost:
    
        if (")".equals(zza(r3, r4)) == false) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List zzb(com.google.android.gms.internal.ads.zzfp r18) {
        /*
            Method dump skipped, instructions count: 792
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaly.zzb(com.google.android.gms.internal.ads.zzfp):java.util.List");
    }
}
