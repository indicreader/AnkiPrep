package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzazn implements Runnable {
    final ValueCallback zza;
    final /* synthetic */ zzazf zzb;
    final /* synthetic */ WebView zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzazp zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzazn(zzazp zzazpVar, final zzazf zzazfVar, final WebView webView, final boolean z) {
        this.zzb = zzazfVar;
        this.zzc = webView;
        this.zzd = z;
        this.zze = zzazpVar;
        this.zza = new ValueCallback() { // from class: com.google.android.gms.internal.ads.zzazm
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                zzazn.this.zze.zzd(zzazfVar, webView, (String) obj, z);
            }
        };
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzc.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzc.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zza);
            } catch (Throwable unused) {
                this.zza.onReceiveValue("");
            }
        }
    }
}
