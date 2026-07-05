package com.google.android.gms.internal.ads;

import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzfpk extends WebViewClient {
    final String zza = "OMID NativeBridge WebViewClient";
    final /* synthetic */ zzfpm zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfpk(zzfpm zzfpmVar) {
        this.zzb = zzfpmVar;
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        Log.w(this.zza, "WebView renderer gone: ".concat(String.valueOf(renderProcessGoneDetail.toString())));
        if (this.zzb.zza() == webView) {
            Log.w(this.zza, "Deallocating the Native bridge as it is unusable. No further events will be generated for this session.");
            this.zzb.zzj(null);
            webView.destroy();
            return true;
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }
}
