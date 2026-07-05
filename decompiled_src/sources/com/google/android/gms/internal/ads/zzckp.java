package com.google.android.gms.internal.ads;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzckp extends zzcko {
    public zzckp(zzcjk zzcjkVar, zzbbp zzbbpVar, boolean z, zzehs zzehsVar) {
        super(zzcjkVar, zzbbpVar, z, zzehsVar);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return null;
        }
        return zzO(webView, webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
    }
}
