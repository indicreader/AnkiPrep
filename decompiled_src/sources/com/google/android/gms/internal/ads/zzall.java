package com.google.android.gms.internal.ads;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzall implements zzakr {
    private static final Pattern zza = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
    private static final Pattern zzb = Pattern.compile("\\{\\\\.*?\\}");
    private final StringBuilder zzc = new StringBuilder();
    private final ArrayList zzd = new ArrayList();
    private final zzfp zze = new zzfp();

    public static float zzb(int i) {
        if (i == 0) {
            return 0.08f;
        }
        if (i == 1) {
            return 0.5f;
        }
        if (i == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    private static long zzc(Matcher matcher, int i) {
        String group = matcher.group(i + 1);
        long parseLong = group != null ? Long.parseLong(group) * 3600000 : 0L;
        String group2 = matcher.group(i + 2);
        group2.getClass();
        long parseLong2 = parseLong + (Long.parseLong(group2) * 60000);
        String group3 = matcher.group(i + 3);
        group3.getClass();
        long parseLong3 = parseLong2 + (Long.parseLong(group3) * 1000);
        String group4 = matcher.group(i + 4);
        if (group4 != null) {
            parseLong3 += Long.parseLong(group4);
        }
        return parseLong3 * 1000;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:44:0x0105. Please report as an issue. */
    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(byte[] bArr, int i, int i2, zzakq zzakqVar, zzep zzepVar) {
        String str;
        char c;
        char c2;
        int i3;
        zzec zzp;
        zzall zzallVar = this;
        zzallVar.zze.zzI(bArr, i + i2);
        zzallVar.zze.zzK(i);
        Charset zzB = zzallVar.zze.zzB();
        if (zzB == null) {
            zzB = zzfwq.zzc;
        }
        while (true) {
            String zzy = zzallVar.zze.zzy(zzB);
            if (zzy == null) {
                return;
            }
            if (zzy.length() != 0) {
                try {
                    Integer.parseInt(zzy);
                    String zzy2 = zzallVar.zze.zzy(zzB);
                    if (zzy2 != null) {
                        Matcher matcher = zza.matcher(zzy2);
                        if (matcher.matches()) {
                            long zzc = zzc(matcher, 1);
                            long zzc2 = zzc(matcher, 6);
                            int i4 = 0;
                            zzallVar.zzc.setLength(0);
                            zzallVar.zzd.clear();
                            String zzy3 = zzallVar.zze.zzy(zzB);
                            while (!TextUtils.isEmpty(zzy3)) {
                                if (zzallVar.zzc.length() > 0) {
                                    zzallVar.zzc.append("<br>");
                                }
                                StringBuilder sb = zzallVar.zzc;
                                ArrayList arrayList = zzallVar.zzd;
                                String trim = zzy3.trim();
                                StringBuilder sb2 = new StringBuilder(trim);
                                Matcher matcher2 = zzb.matcher(trim);
                                int i5 = i4;
                                while (matcher2.find()) {
                                    String group = matcher2.group();
                                    arrayList.add(group);
                                    int start = matcher2.start() - i5;
                                    int length = group.length();
                                    sb2.replace(start, start + length, "");
                                    i5 += length;
                                }
                                sb.append(sb2.toString());
                                zzy3 = zzallVar.zze.zzy(zzB);
                                i4 = 0;
                            }
                            Spanned fromHtml = Html.fromHtml(zzallVar.zzc.toString());
                            int i6 = 0;
                            while (true) {
                                if (i6 < zzallVar.zzd.size()) {
                                    str = (String) zzallVar.zzd.get(i6);
                                    if (!str.matches("\\{\\\\an[1-9]\\}")) {
                                        i6++;
                                    }
                                } else {
                                    str = null;
                                }
                            }
                            zzea zzeaVar = new zzea();
                            zzeaVar.zzl(fromHtml);
                            if (str == null) {
                                zzp = zzeaVar.zzp();
                            } else {
                                switch (str.hashCode()) {
                                    case -685620710:
                                        if (str.equals("{\\an1}")) {
                                            c = 0;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -685620648:
                                        if (str.equals("{\\an3}")) {
                                            c = 3;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -685620617:
                                        if (str.equals("{\\an4}")) {
                                            c = 1;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -685620555:
                                        if (str.equals("{\\an6}")) {
                                            c = 4;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -685620524:
                                        if (str.equals("{\\an7}")) {
                                            c = 2;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -685620462:
                                        if (str.equals("{\\an9}")) {
                                            c = 5;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    default:
                                        c = 65535;
                                        break;
                                }
                                if (c == 0 || c == 1 || c == 2) {
                                    zzeaVar.zzi(0);
                                } else if (c == 3 || c == 4 || c == 5) {
                                    zzeaVar.zzi(2);
                                } else {
                                    zzeaVar.zzi(1);
                                }
                                switch (str.hashCode()) {
                                    case -685620710:
                                        if (str.equals("{\\an1}")) {
                                            c2 = 0;
                                            break;
                                        }
                                        break;
                                    case -685620679:
                                        if (str.equals("{\\an2}")) {
                                            c2 = 1;
                                            break;
                                        }
                                        break;
                                    case -685620648:
                                        if (str.equals("{\\an3}")) {
                                            c2 = 2;
                                            break;
                                        }
                                        break;
                                    case -685620524:
                                        if (str.equals("{\\an7}")) {
                                            c2 = 3;
                                            break;
                                        }
                                        break;
                                    case -685620493:
                                        if (str.equals("{\\an8}")) {
                                            c2 = 4;
                                            break;
                                        }
                                        break;
                                    case -685620462:
                                        if (str.equals("{\\an9}")) {
                                            c2 = 5;
                                            break;
                                        }
                                        break;
                                }
                                c2 = 65535;
                                if (c2 == 0 || c2 == 1) {
                                    i3 = 2;
                                } else if (c2 != 2) {
                                    if (c2 == 3 || c2 == 4 || c2 == 5) {
                                        zzeaVar.zzf(0);
                                    } else {
                                        zzeaVar.zzf(1);
                                    }
                                    zzeaVar.zzh(zzb(zzeaVar.zzb()));
                                    zzeaVar.zze(zzb(zzeaVar.zza()), 0);
                                    zzp = zzeaVar.zzp();
                                } else {
                                    i3 = 2;
                                }
                                zzeaVar.zzf(i3);
                                zzeaVar.zzh(zzb(zzeaVar.zzb()));
                                zzeaVar.zze(zzb(zzeaVar.zza()), 0);
                                zzp = zzeaVar.zzp();
                            }
                            zzepVar.zza(new zzakj(zzgaa.zzm(zzp), zzc, zzc2 - zzc));
                        } else {
                            zzff.zzf("SubripParser", "Skipping invalid timing: ".concat(zzy2));
                        }
                    } else {
                        zzff.zzf("SubripParser", "Unexpected end");
                        return;
                    }
                } catch (NumberFormatException unused) {
                    zzff.zzf("SubripParser", "Skipping invalid index: ".concat(zzy));
                }
            }
            zzallVar = this;
        }
    }
}
