package com.google.android.gms.internal.consent_sdk;

import android.webkit.WebView;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.2.0 */
/* loaded from: classes3.dex */
public final class zzcs {
    private static Boolean zza;

    private zzcs() {
    }

    public static void zza(WebView webView, String str) {
        boolean booleanValue;
        synchronized (zzcs.class) {
            if (zza == null) {
                try {
                    webView.evaluateJavascript("(function(){})()", null);
                    zza = true;
                } catch (IllegalStateException unused) {
                    zza = false;
                }
            }
            booleanValue = zza.booleanValue();
        }
        if (!booleanValue) {
            webView.loadUrl("javascript:".concat(str));
        } else {
            webView.evaluateJavascript(str, null);
        }
    }
}
