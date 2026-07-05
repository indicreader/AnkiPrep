package com.google.android.gms.internal.ads;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.File;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public class zzcko extends zzcjs {
    public zzcko(zzcjk zzcjkVar, zzbbp zzbbpVar, boolean z, zzehs zzehsVar) {
        super(zzcjkVar, zzbbpVar, z, new zzbvv(zzcjkVar, zzcjkVar.zzE(), new zzbfm(zzcjkVar.getContext())), null, zzehsVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public final WebResourceResponse zzO(WebView webView, String str, Map map) {
        String str2;
        if (!(webView instanceof zzcjk)) {
            zzcec.zzj("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzcjk zzcjkVar = (zzcjk) webView;
        zzcbs zzcbsVar = this.zza;
        if (zzcbsVar != null) {
            zzcbsVar.zzd(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzc(str, map);
        }
        if (zzcjkVar.zzN() != null) {
            zzcjkVar.zzN().zzF();
        }
        if (zzcjkVar.zzO().zzi()) {
            str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzO);
        } else if (zzcjkVar.zzaC()) {
            str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzN);
        } else {
            str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzM);
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        return com.google.android.gms.ads.internal.util.zzt.zzw(zzcjkVar.getContext(), zzcjkVar.zzn().zza, str2);
    }
}
