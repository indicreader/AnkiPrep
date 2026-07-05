package com.google.android.gms.internal.ads;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzamh {
    public static final Pattern zza = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern zzb = Pattern.compile("(\\S+?):(\\S+)");
    private static final Map zzc;
    private static final Map zzd;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        zzc = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        zzd = Collections.unmodifiableMap(hashMap2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x020b A[FALL_THROUGH, PHI: r8
  0x020b: PHI (r8v5 int) = (r8v1 int), (r8v1 int), (r8v8 int), (r8v8 int), (r8v8 int), (r8v8 int), (r8v8 int), (r8v8 int), (r8v1 int) binds: [B:125:0x0208, B:12:0x0059, B:25:0x0095, B:45:0x0128, B:58:0x0161, B:59:0x0163, B:57:0x020b, B:54:0x020b, B:7:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.text.SpannedString zza(java.lang.String r17, java.lang.String r18, java.util.List r19) {
        /*
            Method dump skipped, instructions count: 548
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamh.zza(java.lang.String, java.lang.String, java.util.List):android.text.SpannedString");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzea zzb(String str) {
        zzamg zzamgVar = new zzamg();
        zzh(str, zzamgVar);
        return zzamgVar.zza();
    }

    public static zzama zzc(zzfp zzfpVar, List list) {
        String zzy = zzfpVar.zzy(zzfwq.zzc);
        if (zzy != null) {
            Pattern pattern = zza;
            Matcher matcher = pattern.matcher(zzy);
            if (!matcher.matches()) {
                String zzy2 = zzfpVar.zzy(zzfwq.zzc);
                if (zzy2 != null) {
                    Matcher matcher2 = pattern.matcher(zzy2);
                    if (matcher2.matches()) {
                        return zze(zzy.trim(), matcher2, zzfpVar, list);
                    }
                }
            } else {
                return zze(null, matcher, zzfpVar, list);
            }
        }
        return null;
    }

    private static int zzd(List list, String str, zzame zzameVar) {
        List zzf = zzf(list, str, zzameVar);
        for (int i = 0; i < zzf.size(); i++) {
            zzalz zzalzVar = ((zzamf) zzf.get(i)).zzb;
            if (zzalzVar.zze() != -1) {
                return zzalzVar.zze();
            }
        }
        return -1;
    }

    private static zzama zze(String str, Matcher matcher, zzfp zzfpVar, List list) {
        zzamg zzamgVar = new zzamg();
        try {
            String group = matcher.group(1);
            group.getClass();
            zzamgVar.zza = zzamj.zzb(group);
            String group2 = matcher.group(2);
            group2.getClass();
            zzamgVar.zzb = zzamj.zzb(group2);
            String group3 = matcher.group(3);
            group3.getClass();
            zzh(group3, zzamgVar);
            StringBuilder sb = new StringBuilder();
            String zzy = zzfpVar.zzy(zzfwq.zzc);
            while (!TextUtils.isEmpty(zzy)) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(zzy.trim());
                zzy = zzfpVar.zzy(zzfwq.zzc);
            }
            zzamgVar.zzc = zza(str, sb.toString(), list);
            return new zzama(zzamgVar.zza().zzp(), zzamgVar.zza, zzamgVar.zzb);
        } catch (NumberFormatException unused) {
            zzff.zzf("WebvttCueParser", "Skipping cue with bad header: ".concat(String.valueOf(matcher.group())));
            return null;
        }
    }

    private static List zzf(List list, String str, zzame zzameVar) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zzalz zzalzVar = (zzalz) list.get(i);
            int zzf = zzalzVar.zzf(str, zzameVar.zza, zzameVar.zzd, zzameVar.zzc);
            if (zzf > 0) {
                arrayList.add(new zzamf(zzf, zzalzVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static void zzg(String str, zzame zzameVar, List list, SpannableStringBuilder spannableStringBuilder, List list2) {
        char c;
        Comparator comparator;
        zzame zzameVar2;
        zzame zzameVar3;
        zzame zzameVar4;
        int i;
        int i2 = zzameVar.zzb;
        int length = spannableStringBuilder.length();
        String str2 = zzameVar.zza;
        int hashCode = str2.hashCode();
        int i3 = -1;
        if (hashCode == 0) {
            if (str2.equals("")) {
                c = 7;
            }
            c = 65535;
        } else if (hashCode == 105) {
            if (str2.equals("i")) {
                c = 1;
            }
            c = 65535;
        } else if (hashCode == 3314158) {
            if (str2.equals("lang")) {
                c = 5;
            }
            c = 65535;
        } else if (hashCode == 3511770) {
            if (str2.equals("ruby")) {
                c = 2;
            }
            c = 65535;
        } else if (hashCode == 98) {
            if (str2.equals("b")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode == 99) {
            if (str2.equals("c")) {
                c = 4;
            }
            c = 65535;
        } else if (hashCode != 117) {
            if (hashCode == 118 && str2.equals("v")) {
                c = 6;
            }
            c = 65535;
        } else {
            if (str2.equals("u")) {
                c = 3;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                spannableStringBuilder.setSpan(new StyleSpan(1), i2, length, 33);
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(2), i2, length, 33);
                break;
            case 2:
                int zzd2 = zzd(list2, str, zzameVar);
                ArrayList arrayList = new ArrayList(list.size());
                arrayList.addAll(list);
                comparator = zzamd.zza;
                Collections.sort(arrayList, comparator);
                int i4 = zzameVar.zzb;
                int i5 = 0;
                int i6 = 0;
                while (i5 < arrayList.size()) {
                    zzameVar2 = ((zzamd) arrayList.get(i5)).zzb;
                    if ("rt".equals(zzameVar2.zza)) {
                        zzamd zzamdVar = (zzamd) arrayList.get(i5);
                        zzameVar3 = zzamdVar.zzb;
                        int zzd3 = zzd(list2, str, zzameVar3);
                        if (zzd3 == i3) {
                            zzd3 = zzd2 != i3 ? zzd2 : 1;
                        }
                        zzameVar4 = zzamdVar.zzb;
                        int i7 = zzameVar4.zzb - i6;
                        i = zzamdVar.zzc;
                        int i8 = i - i6;
                        CharSequence subSequence = spannableStringBuilder.subSequence(i7, i8);
                        spannableStringBuilder.delete(i7, i8);
                        spannableStringBuilder.setSpan(new zzeh(subSequence.toString(), zzd3), i4, i7, 33);
                        i6 += subSequence.length();
                        i4 = i7;
                    }
                    i5++;
                    i3 = -1;
                }
                break;
            case 3:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i2, length, 33);
                break;
            case 4:
                for (String str3 : zzameVar.zzd) {
                    Map map = zzc;
                    if (map.containsKey(str3)) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(((Integer) map.get(str3)).intValue()), i2, length, 33);
                    } else {
                        Map map2 = zzd;
                        if (map2.containsKey(str3)) {
                            spannableStringBuilder.setSpan(new BackgroundColorSpan(((Integer) map2.get(str3)).intValue()), i2, length, 33);
                        }
                    }
                }
                break;
            case 5:
            case 6:
            case 7:
                break;
            default:
                return;
        }
        List zzf = zzf(list2, str, zzameVar);
        for (int i9 = 0; i9 < zzf.size(); i9++) {
            zzalz zzalzVar = ((zzamf) zzf.get(i9)).zzb;
            if (zzalzVar != null) {
                if (zzalzVar.zzg() != -1) {
                    zzei.zza(spannableStringBuilder, new StyleSpan(zzalzVar.zzg()), i2, length, 33);
                }
                if (zzalzVar.zzz()) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i2, length, 33);
                }
                if (zzalzVar.zzy()) {
                    zzei.zza(spannableStringBuilder, new ForegroundColorSpan(zzalzVar.zzc()), i2, length, 33);
                }
                if (zzalzVar.zzx()) {
                    zzei.zza(spannableStringBuilder, new BackgroundColorSpan(zzalzVar.zzb()), i2, length, 33);
                }
                if (zzalzVar.zzr() != null) {
                    zzei.zza(spannableStringBuilder, new TypefaceSpan(zzalzVar.zzr()), i2, length, 33);
                }
                int zzd4 = zzalzVar.zzd();
                if (zzd4 == 1) {
                    zzei.zza(spannableStringBuilder, new AbsoluteSizeSpan((int) zzalzVar.zza(), true), i2, length, 33);
                } else if (zzd4 == 2) {
                    zzei.zza(spannableStringBuilder, new RelativeSizeSpan(zzalzVar.zza()), i2, length, 33);
                } else if (zzd4 == 3) {
                    zzei.zza(spannableStringBuilder, new RelativeSizeSpan(zzalzVar.zza() / 100.0f), i2, length, 33);
                }
                if (zzalzVar.zzw()) {
                    spannableStringBuilder.setSpan(new zzeg(), i2, length, 33);
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0161, code lost:
    
        if (r15 == 0) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0163, code lost:
    
        if (r15 == 1) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0165, code lost:
    
        if (r15 == 2) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0168, code lost:
    
        if (r15 == 3) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x016a, code lost:
    
        if (r15 == 4) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x016c, code lost:
    
        r3 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x016d, code lost:
    
        if (r15 == 5) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x016f, code lost:
    
        com.google.android.gms.internal.ads.zzff.zzf("WebvttCueParser", "Invalid alignment value: ".concat(r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0179, code lost:
    
        r3 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x017b, code lost:
    
        r3 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x017d, code lost:
    
        r3 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x017e, code lost:
    
        r17.zzd = r3;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0192. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:91:0x00c1. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zzh(java.lang.String r16, com.google.android.gms.internal.ads.zzamg r17) {
        /*
            Method dump skipped, instructions count: 590
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamh.zzh(java.lang.String, com.google.android.gms.internal.ads.zzamg):void");
    }
}
