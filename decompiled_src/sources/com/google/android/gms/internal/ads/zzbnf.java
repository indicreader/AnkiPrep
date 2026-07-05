package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import coil.disk.DiskLruCache;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbnf {
    public static final zzbng zza = new zzbng() { // from class: com.google.android.gms.internal.ads.zzbmd
        @Override // com.google.android.gms.internal.ads.zzbng
        public final void zza(Object obj, Map map) {
            zzckn zzcknVar = (zzckn) obj;
            zzbng zzbngVar = zzbnf.zza;
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                zzcec.zzj("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            HashMap hashMap = new HashMap();
            PackageManager packageManager = zzcknVar.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                boolean z = true;
                if (packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) == null) {
                    z = false;
                }
                Boolean valueOf = Boolean.valueOf(z);
                hashMap.put(str2, valueOf);
                com.google.android.gms.ads.internal.util.zze.zza("/canOpenURLs;" + str2 + ";" + valueOf);
            }
            ((zzbqa) zzcknVar).zzd("openableURLs", hashMap);
        }
    };
    public static final zzbng zzb = new zzbng() { // from class: com.google.android.gms.internal.ads.zzbmf
        @Override // com.google.android.gms.internal.ads.zzbng
        public final void zza(Object obj, Map map) {
            zzckn zzcknVar = (zzckn) obj;
            zzbng zzbngVar = zzbnf.zza;
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzid)).booleanValue()) {
                zzcec.zzj("canOpenAppGmsgHandler disabled.");
                return;
            }
            String str = (String) map.get("package_name");
            if (TextUtils.isEmpty(str)) {
                zzcec.zzj("Package name missing in canOpenApp GMSG.");
                return;
            }
            HashMap hashMap = new HashMap();
            Boolean valueOf = Boolean.valueOf(zzcknVar.getContext().getPackageManager().getLaunchIntentForPackage(str) != null);
            hashMap.put(str, valueOf);
            com.google.android.gms.ads.internal.util.zze.zza("/canOpenApp;" + str + ";" + valueOf);
            ((zzbqa) zzcknVar).zzd("openableApp", hashMap);
        }
    };
    public static final zzbng zzc = new zzbng() { // from class: com.google.android.gms.internal.ads.zzbmi
        @Override // com.google.android.gms.internal.ads.zzbng
        public final void zza(Object obj, Map map) {
            zzbnf.zzb((zzckn) obj, map);
        }
    };
    public static final zzbng zzd = new zzbmx();
    public static final zzbng zze = new zzbmy();
    public static final zzbng zzf = new zzbng() { // from class: com.google.android.gms.internal.ads.zzbmj
        @Override // com.google.android.gms.internal.ads.zzbng
        public final void zza(Object obj, Map map) {
            zzckn zzcknVar = (zzckn) obj;
            zzbng zzbngVar = zzbnf.zza;
            String str = (String) map.get("u");
            if (str == null) {
                zzcec.zzj("URL missing from httpTrack GMSG.");
            } else {
                new com.google.android.gms.ads.internal.util.zzca(zzcknVar.getContext(), ((zzcku) zzcknVar).zzn().zza, str).zzb();
            }
        }
    };
    public static final zzbng zzg = new zzbmz();
    public static final zzbng zzh = new zzbna();
    public static final zzbng zzi = new zzbng() { // from class: com.google.android.gms.internal.ads.zzbmh
        @Override // com.google.android.gms.internal.ads.zzbng
        public final void zza(Object obj, Map map) {
            zzckt zzcktVar = (zzckt) obj;
            zzbng zzbngVar = zzbnf.zza;
            String str = (String) map.get("tx");
            String str2 = (String) map.get("ty");
            String str3 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt(str);
                int parseInt2 = Integer.parseInt(str2);
                int parseInt3 = Integer.parseInt(str3);
                zzavi zzI = zzcktVar.zzI();
                if (zzI != null) {
                    zzI.zzc().zzl(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException unused) {
                zzcec.zzj("Could not parse touch parameters from gmsg.");
            }
        }
    };
    public static final zzbng zzj = new zzbnb();
    public static final zzbng zzk = new zzbnc();
    public static final zzbng zzl = new zzchk();
    public static final zzbng zzm = new zzchl();
    public static final zzbng zzn = new zzblz();
    public static final zzbnv zzo = new zzbnv();
    public static final zzbng zzp = new zzbnd();
    public static final zzbng zzq = new zzbne();
    public static final zzbng zzr = new zzbmk();
    public static final zzbng zzs = new zzbml();
    public static final zzbng zzt = new zzbmm();
    public static final zzbng zzu = new zzbmn();
    public static final zzbng zzv = new zzbmo();
    public static final zzbng zzw = new zzbmp();
    public static final zzbng zzx = new zzbmq();
    public static final zzbng zzy = new zzbmr();
    public static final zzbng zzz = new zzbms();
    public static final zzbng zzA = new zzbmt();
    public static final zzbng zzB = new zzbmv();
    public static final zzbng zzC = new zzbmw();

    public static ListenableFuture zza(zzcjk zzcjkVar, String str) {
        Uri parse = Uri.parse(str);
        try {
            zzavi zzI = zzcjkVar.zzI();
            zzfhl zzQ = zzcjkVar.zzQ();
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlr)).booleanValue() || zzQ == null) {
                if (zzI != null && zzI.zzf(parse)) {
                    parse = zzI.zza(parse, zzcjkVar.getContext(), zzcjkVar.zzF(), zzcjkVar.zzi());
                }
            } else if (zzI != null && zzI.zzf(parse)) {
                parse = zzQ.zza(parse, zzcjkVar.getContext(), zzcjkVar.zzF(), zzcjkVar.zzi());
            }
        } catch (zzavj unused) {
            zzcec.zzj("Unable to append parameter to URL: ".concat(str));
        }
        final String zzb2 = zzccj.zzb(parse, zzcjkVar.getContext());
        long longValue = ((Long) zzbhz.zze.zze()).longValue();
        if (longValue <= 0 || longValue > 240304702) {
            return zzgen.zzh(zzb2);
        }
        return zzgen.zze(zzgen.zzm(zzgen.zze(zzgee.zzu(zzcjkVar.zzS()), Throwable.class, new zzfws() { // from class: com.google.android.gms.internal.ads.zzbma
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                Throwable th = (Throwable) obj;
                zzbng zzbngVar = zzbnf.zza;
                if (!((Boolean) zzbhz.zzk.zze()).booleanValue()) {
                    return "failure_click_attok";
                }
                com.google.android.gms.ads.internal.zzt.zzo().zzw(th, "prepareClickUrl.attestation1");
                return "failure_click_attok";
            }
        }, zzcep.zzf), new zzfws() { // from class: com.google.android.gms.internal.ads.zzbmb
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                String str2 = (String) obj;
                zzbng zzbngVar = zzbnf.zza;
                String str3 = zzb2;
                if (str2 != null) {
                    if (((Boolean) zzbhz.zzf.zze()).booleanValue()) {
                        String[] strArr = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
                        String host = Uri.parse(str3).getHost();
                        for (int i = 0; i < 3; i++) {
                            if (!host.endsWith(strArr[i])) {
                            }
                        }
                    }
                    String str4 = (String) zzbhz.zza.zze();
                    String str5 = (String) zzbhz.zzb.zze();
                    if (!TextUtils.isEmpty(str4)) {
                        str3 = str3.replace(str4, str2);
                    }
                    if (!TextUtils.isEmpty(str5)) {
                        Uri parse2 = Uri.parse(str3);
                        if (TextUtils.isEmpty(parse2.getQueryParameter(str5))) {
                            return parse2.buildUpon().appendQueryParameter(str5, str2).toString();
                        }
                    }
                }
                return str3;
            }
        }, zzcep.zzf), Throwable.class, new zzfws() { // from class: com.google.android.gms.internal.ads.zzbmc
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                Throwable th = (Throwable) obj;
                zzbng zzbngVar = zzbnf.zza;
                if (((Boolean) zzbhz.zzk.zze()).booleanValue()) {
                    com.google.android.gms.ads.internal.zzt.zzo().zzw(th, "prepareClickUrl.attestation2");
                }
                return zzb2;
            }
        }, zzcep.zzf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(16:10|11|12|(12:50|51|15|(10:17|(1:19)|20|(1:22)|23|(1:25)|26|(1:28)|29|(2:31|(1:33)))|34|35|36|(1:38)|39|40|42|43)|14|15|(0)|34|35|36|(0)|39|40|42|43|8) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00df, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e0, code lost:
    
        com.google.android.gms.internal.ads.zzcec.zzh("Error constructing openable urls response.", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ca, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00cb, code lost:
    
        com.google.android.gms.ads.internal.zzt.zzo().zzw(r0, r8.toString());
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void zzb(com.google.android.gms.internal.ads.zzckn r16, java.util.Map r17) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbnf.zzb(com.google.android.gms.internal.ads.zzckn, java.util.Map):void");
    }

    public static void zzc(Map map, zzdiu zzdiuVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkl)).booleanValue() && map.containsKey("sc") && ((String) map.get("sc")).equals(DiskLruCache.VERSION) && zzdiuVar != null) {
            zzdiuVar.zzs();
        }
    }
}
