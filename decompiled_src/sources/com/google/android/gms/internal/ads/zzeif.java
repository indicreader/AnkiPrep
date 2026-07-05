package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeif implements zzeig {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzfod zzc(String str, String str2, String str3, zzeih zzeihVar, String str4, WebView webView, String str5, String str6, zzeii zzeiiVar) {
        zzfon zza = zzfon.zza("Google", str2);
        zzfom zzm = zzm("javascript");
        zzfoi zzk = zzk(zzeihVar.toString());
        if (zzm == zzfom.NONE) {
            zzcec.zzj("Omid html session error; Unable to parse impression owner: javascript");
            return null;
        }
        if (zzk == null) {
            zzcec.zzj("Omid html session error; Unable to parse creative type: ".concat(String.valueOf(String.valueOf(zzeihVar))));
            return null;
        }
        zzfom zzm2 = zzm(str4);
        if (zzk != zzfoi.VIDEO || zzm2 != zzfom.NONE) {
            return zzfod.zza(zzfoe.zza(zzk, zzl(zzeiiVar.toString()), zzm, zzm2, true), zzfof.zzb(zza, webView, str5, ""));
        }
        zzcec.zzj("Omid html session error; Video events owner unknown for video creative: ".concat(String.valueOf(str4)));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzfod zzd(String str, String str2, String str3, String str4, zzeih zzeihVar, WebView webView, String str5, String str6, zzeii zzeiiVar) {
        zzfon zza = zzfon.zza(str, str2);
        zzfom zzm = zzm("javascript");
        zzfom zzm2 = zzm(str4);
        zzfoi zzk = zzk(zzeihVar.toString());
        if (zzm == zzfom.NONE) {
            zzcec.zzj("Omid js session error; Unable to parse impression owner: javascript");
            return null;
        }
        if (zzk == null) {
            zzcec.zzj("Omid js session error; Unable to parse creative type: ".concat(String.valueOf(String.valueOf(zzeihVar))));
            return null;
        }
        if (zzk != zzfoi.VIDEO || zzm2 != zzfom.NONE) {
            return zzfod.zza(zzfoe.zza(zzk, zzl(zzeiiVar.toString()), zzm, zzm2, true), zzfof.zzc(zza, webView, str5, ""));
        }
        zzcec.zzj("Omid js session error; Video events owner unknown for video creative: ".concat(String.valueOf(str4)));
        return null;
    }

    private static zzfoi zzk(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == -382745961) {
            if (str.equals("htmlDisplay")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != 112202875) {
            if (hashCode == 714893483 && str.equals("nativeDisplay")) {
                c = 1;
            }
            c = 65535;
        } else {
            if (str.equals("video")) {
                c = 2;
            }
            c = 65535;
        }
        if (c == 0) {
            return zzfoi.HTML_DISPLAY;
        }
        if (c == 1) {
            return zzfoi.NATIVE_DISPLAY;
        }
        if (c != 2) {
            return null;
        }
        return zzfoi.VIDEO;
    }

    private static zzfol zzl(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == -1104128070) {
            if (str.equals("beginToRender")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != 1318088141) {
            if (hashCode == 1988248512 && str.equals("onePixel")) {
                c = 2;
            }
            c = 65535;
        } else {
            if (str.equals("definedByJavascript")) {
                c = 1;
            }
            c = 65535;
        }
        if (c == 0) {
            return zzfol.BEGIN_TO_RENDER;
        }
        if (c == 1) {
            return zzfol.DEFINED_BY_JAVASCRIPT;
        }
        if (c == 2) {
            return zzfol.ONE_PIXEL;
        }
        return zzfol.UNSPECIFIED;
    }

    private static zzfom zzm(String str) {
        if ("native".equals(str)) {
            return zzfom.NATIVE;
        }
        if ("javascript".equals(str)) {
            return zzfom.JAVASCRIPT;
        }
        return zzfom.NONE;
    }

    private static final Object zzn(zzeie zzeieVar) {
        try {
            return zzeieVar.zza();
        } catch (RuntimeException e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzv(e, "omid exception");
            return null;
        }
    }

    private static final void zzo(Runnable runnable) {
        try {
            runnable.run();
        } catch (RuntimeException e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzv(e, "omid exception");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeig
    public final zzfod zza(final String str, final WebView webView, String str2, String str3, final String str4, final zzeii zzeiiVar, final zzeih zzeihVar, final String str5) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeU)).booleanValue() || !zzfob.zzb()) {
            return null;
        }
        final String str6 = "";
        final String str7 = "javascript";
        final String str8 = "Google";
        return (zzfod) zzn(new zzeie(str8, str, str7, zzeihVar, str4, webView, str5, str6, zzeiiVar) { // from class: com.google.android.gms.internal.ads.zzeib
            public final /* synthetic */ String zzb;
            public final /* synthetic */ zzeih zzd;
            public final /* synthetic */ String zze;
            public final /* synthetic */ WebView zzf;
            public final /* synthetic */ String zzg;
            public final /* synthetic */ zzeii zzi;
            public final /* synthetic */ String zza = "Google";
            public final /* synthetic */ String zzc = "javascript";
            public final /* synthetic */ String zzh = "";

            {
                this.zzb = str;
                this.zzd = zzeihVar;
                this.zze = str4;
                this.zzf = webView;
                this.zzg = str5;
                this.zzi = zzeiiVar;
            }

            @Override // com.google.android.gms.internal.ads.zzeie
            public final Object zza() {
                return zzeif.zzc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeig
    public final zzfod zzb(final String str, final WebView webView, String str2, String str3, final String str4, final String str5, final zzeii zzeiiVar, final zzeih zzeihVar, final String str6) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeU)).booleanValue() || !zzfob.zzb()) {
            return null;
        }
        final String str7 = "";
        final String str8 = "javascript";
        return (zzfod) zzn(new zzeie(str5, str, str8, str4, zzeihVar, webView, str6, str7, zzeiiVar) { // from class: com.google.android.gms.internal.ads.zzehy
            public final /* synthetic */ String zza;
            public final /* synthetic */ String zzb;
            public final /* synthetic */ String zzd;
            public final /* synthetic */ zzeih zze;
            public final /* synthetic */ WebView zzf;
            public final /* synthetic */ String zzg;
            public final /* synthetic */ zzeii zzi;
            public final /* synthetic */ String zzc = "javascript";
            public final /* synthetic */ String zzh = "";

            {
                this.zzd = str4;
                this.zze = zzeihVar;
                this.zzf = webView;
                this.zzg = str6;
                this.zzi = zzeiiVar;
            }

            @Override // com.google.android.gms.internal.ads.zzeie
            public final Object zza() {
                return zzeif.zzd(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeig
    public final String zze(Context context) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeU)).booleanValue()) {
            return (String) zzn(new zzeie() { // from class: com.google.android.gms.internal.ads.zzeic
                @Override // com.google.android.gms.internal.ads.zzeie
                public final Object zza() {
                    return "a.1.4.8-google_20230803";
                }
            });
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzeig
    public final void zzf(final zzfod zzfodVar, final View view) {
        zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzehw
            @Override // java.lang.Runnable
            public final void run() {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeU)).booleanValue() && zzfob.zzb()) {
                    zzfod.this.zzb(view, zzfok.NOT_VISIBLE, "Ad overlay");
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeig
    public final void zzg(final zzfod zzfodVar) {
        zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeid
            @Override // java.lang.Runnable
            public final void run() {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeU)).booleanValue() && zzfob.zzb()) {
                    zzfod.this.zzc();
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeig
    public final void zzh(final zzfod zzfodVar, final View view) {
        zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzehx
            @Override // java.lang.Runnable
            public final void run() {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeU)).booleanValue() && zzfob.zzb()) {
                    zzfod.this.zzd(view);
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeig
    public final void zzi(final zzfod zzfodVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeU)).booleanValue() && zzfob.zzb()) {
            Objects.requireNonNull(zzfodVar);
            zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzehz
                @Override // java.lang.Runnable
                public final void run() {
                    zzfod.this.zze();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeig
    public final boolean zzj(final Context context) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeU)).booleanValue()) {
            zzcec.zzj("Omid flag is disabled");
            return false;
        }
        Boolean bool = (Boolean) zzn(new zzeie() { // from class: com.google.android.gms.internal.ads.zzeia
            @Override // com.google.android.gms.internal.ads.zzeie
            public final Object zza() {
                if (zzfob.zzb()) {
                    return true;
                }
                zzfob.zza(context);
                return Boolean.valueOf(zzfob.zzb());
            }
        });
        return bool != null && bool.booleanValue();
    }
}
