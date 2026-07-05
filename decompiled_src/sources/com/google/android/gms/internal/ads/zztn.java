package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zztn {
    public static final /* synthetic */ int zza = 0;
    private static final Pattern zzb = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap zzc = new HashMap();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02bf A[Catch: NumberFormatException -> 0x02d0, TRY_LEAVE, TryCatch #3 {NumberFormatException -> 0x02d0, blocks: (B:122:0x0269, B:124:0x027b, B:135:0x0297, B:138:0x02bf), top: B:121:0x0269 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x060e  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x061d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x06d0  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x06e3  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0781  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x0794  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair zza(com.google.android.gms.internal.ads.zzam r19) {
        /*
            Method dump skipped, instructions count: 2488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztn.zza(com.google.android.gms.internal.ads.zzam):android.util.Pair");
    }

    public static zzsv zzb() throws zzth {
        List zze = zze("audio/raw", false, false);
        if (zze.isEmpty()) {
            return null;
        }
        return (zzsv) zze.get(0);
    }

    public static String zzc(zzam zzamVar) {
        Pair zza2;
        if ("audio/eac3-joc".equals(zzamVar.zzm)) {
            return "audio/eac3";
        }
        if (!"video/dolby-vision".equals(zzamVar.zzm) || (zza2 = zza(zzamVar)) == null) {
            return null;
        }
        int intValue = ((Integer) zza2.first).intValue();
        if (intValue == 16 || intValue == 256) {
            return "video/hevc";
        }
        if (intValue == 512) {
            return "video/avc";
        }
        return null;
    }

    public static List zzd(zztb zztbVar, zzam zzamVar, boolean z, boolean z2) throws zzth {
        String zzc2 = zzc(zzamVar);
        if (zzc2 == null) {
            return zzgaa.zzl();
        }
        return zze(zzc2, z, z2);
    }

    public static synchronized List zze(String str, boolean z, boolean z2) throws zzth {
        synchronized (zztn.class) {
            zztf zztfVar = new zztf(str, z, z2);
            HashMap hashMap = zzc;
            List list = (List) hashMap.get(zztfVar);
            if (list != null) {
                return list;
            }
            int i = zzfy.zza;
            ArrayList zzh = zzh(zztfVar, new zztl(z, z2));
            if (z && zzh.isEmpty() && zzfy.zza <= 23) {
                zzh = zzh(zztfVar, new zztk(null));
                if (!zzh.isEmpty()) {
                    zzff.zzf("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((zzsv) zzh.get(0)).zza);
                }
            }
            if ("audio/raw".equals(str)) {
                if (zzfy.zza < 26 && zzfy.zzb.equals("R9") && zzh.size() == 1 && ((zzsv) zzh.get(0)).zza.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                    zzh.add(zzsv.zzc("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
                }
                zzi(zzh, new zztm() { // from class: com.google.android.gms.internal.ads.zztd
                    @Override // com.google.android.gms.internal.ads.zztm
                    public final int zza(Object obj) {
                        int i2 = zztn.zza;
                        String str2 = ((zzsv) obj).zza;
                        if (str2.startsWith("OMX.google") || str2.startsWith("c2.android")) {
                            return 1;
                        }
                        return (zzfy.zza >= 26 || !str2.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
                    }
                });
            }
            if (zzfy.zza < 32 && zzh.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((zzsv) zzh.get(0)).zza)) {
                zzh.add((zzsv) zzh.remove(0));
            }
            zzgaa zzj = zzgaa.zzj(zzh);
            hashMap.put(zztfVar, zzj);
            return zzj;
        }
    }

    @RequiresNonNull({"#2.sampleMimeType"})
    public static List zzf(zztb zztbVar, zzam zzamVar, boolean z, boolean z2) throws zzth {
        List zze = zze(zzamVar.zzm, z, z2);
        List zzd = zzd(zztbVar, zzamVar, z, z2);
        zzfzx zzfzxVar = new zzfzx();
        zzfzxVar.zzh(zze);
        zzfzxVar.zzh(zzd);
        return zzfzxVar.zzi();
    }

    public static List zzg(List list, final zzam zzamVar) {
        ArrayList arrayList = new ArrayList(list);
        zzi(arrayList, new zztm() { // from class: com.google.android.gms.internal.ads.zzte
            @Override // com.google.android.gms.internal.ads.zztm
            public final int zza(Object obj) {
                int i = zztn.zza;
                return ((zzsv) obj).zzd(zzam.this) ? 1 : 0;
            }
        });
        return arrayList;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:64|65|(1:67)(2:129|(1:131)(1:132))|68|(1:70)(2:121|(1:128)(1:127))|(4:(2:115|116)|96|(8:99|100|101|102|103|104|105|107)|11)|74|75|76|78|11) */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01c6, code lost:
    
        if (r1.zzb == false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01e4, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0197 A[Catch: Exception -> 0x0225, TryCatch #2 {Exception -> 0x0225, blocks: (B:57:0x0145, B:61:0x015c, B:65:0x0171, B:67:0x0177, B:68:0x0188, B:70:0x0192, B:72:0x01be, B:121:0x0197, B:123:0x01a7, B:125:0x01af, B:129:0x017d), top: B:56:0x0145 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x017d A[Catch: Exception -> 0x0225, TryCatch #2 {Exception -> 0x0225, blocks: (B:57:0x0145, B:61:0x015c, B:65:0x0171, B:67:0x0177, B:68:0x0188, B:70:0x0192, B:72:0x01be, B:121:0x0197, B:123:0x01a7, B:125:0x01af, B:129:0x017d), top: B:56:0x0145 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0177 A[Catch: Exception -> 0x0225, TryCatch #2 {Exception -> 0x0225, blocks: (B:57:0x0145, B:61:0x015c, B:65:0x0171, B:67:0x0177, B:68:0x0188, B:70:0x0192, B:72:0x01be, B:121:0x0197, B:123:0x01a7, B:125:0x01af, B:129:0x017d), top: B:56:0x0145 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0192 A[Catch: Exception -> 0x0225, TryCatch #2 {Exception -> 0x0225, blocks: (B:57:0x0145, B:61:0x015c, B:65:0x0171, B:67:0x0177, B:68:0x0188, B:70:0x0192, B:72:0x01be, B:121:0x0197, B:123:0x01a7, B:125:0x01af, B:129:0x017d), top: B:56:0x0145 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0234 A[Catch: Exception -> 0x0282, TRY_ENTER, TryCatch #5 {Exception -> 0x0282, blocks: (B:3:0x0008, B:5:0x001d, B:7:0x0027, B:12:0x0034, B:16:0x0042, B:18:0x0048, B:20:0x004e, B:22:0x0056, B:24:0x005e, B:26:0x0068, B:28:0x0072, B:30:0x007c, B:32:0x0086, B:34:0x0090, B:36:0x009a, B:38:0x00a4, B:40:0x00ae, B:42:0x00b8, B:44:0x00be, B:46:0x00c6, B:48:0x00ce, B:50:0x00d7, B:82:0x022c, B:85:0x0234, B:87:0x023a, B:90:0x0254, B:91:0x0275, B:52:0x00e0, B:141:0x00e3, B:143:0x00eb, B:146:0x00f6, B:148:0x00fe, B:152:0x0109, B:154:0x0111, B:157:0x011c, B:159:0x0124, B:162:0x012f, B:164:0x0137), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0254 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.ArrayList zzh(com.google.android.gms.internal.ads.zztf r23, com.google.android.gms.internal.ads.zzti r24) throws com.google.android.gms.internal.ads.zzth {
        /*
            Method dump skipped, instructions count: 650
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztn.zzh(com.google.android.gms.internal.ads.zztf, com.google.android.gms.internal.ads.zzti):java.util.ArrayList");
    }

    private static void zzi(List list, final zztm zztmVar) {
        Collections.sort(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zztc
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int i = zztn.zza;
                zztm zztmVar2 = zztm.this;
                return zztmVar2.zza(obj2) - zztmVar2.zza(obj);
            }
        });
    }

    private static boolean zzj(MediaCodecInfo mediaCodecInfo, String str) {
        if (zzfy.zza >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (zzcb.zzg(str)) {
            return true;
        }
        String zza2 = zzfwk.zza(mediaCodecInfo.getName());
        if (zza2.startsWith("arc.")) {
            return false;
        }
        if (zza2.startsWith("omx.google.") || zza2.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((zza2.startsWith("omx.sec.") && zza2.contains(".sw.")) || zza2.equals("omx.qcom.video.decoder.hevcswvdec") || zza2.startsWith("c2.android.") || zza2.startsWith("c2.google.")) {
            return true;
        }
        return (zza2.startsWith("omx.") || zza2.startsWith("c2.")) ? false : true;
    }
}
