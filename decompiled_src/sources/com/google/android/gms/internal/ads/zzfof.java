package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfof {
    private final zzfon zza;
    private final WebView zzb;
    private final List zzc = new ArrayList();
    private final Map zzd = new HashMap();
    private final String zze = "";
    private final String zzf;
    private final zzfog zzg;

    private zzfof(zzfon zzfonVar, WebView webView, String str, List list, String str2, String str3, zzfog zzfogVar) {
        this.zza = zzfonVar;
        this.zzb = webView;
        this.zzg = zzfogVar;
        this.zzf = str2;
    }

    public static zzfof zzb(zzfon zzfonVar, WebView webView, String str, String str2) {
        return new zzfof(zzfonVar, webView, null, null, str, "", zzfog.HTML);
    }

    public static zzfof zzc(zzfon zzfonVar, WebView webView, String str, String str2) {
        return new zzfof(zzfonVar, webView, null, null, str, "", zzfog.JAVASCRIPT);
    }

    public final WebView zza() {
        return this.zzb;
    }

    public final zzfog zzd() {
        return this.zzg;
    }

    public final zzfon zze() {
        return this.zza;
    }

    public final String zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zze;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final Map zzi() {
        return Collections.unmodifiableMap(this.zzd);
    }
}
