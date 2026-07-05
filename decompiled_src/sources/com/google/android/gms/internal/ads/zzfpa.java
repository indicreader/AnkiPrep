package com.google.android.gms.internal.ads;

import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzfpa implements Runnable {
    final /* synthetic */ WebView zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzfpb zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfpa(zzfpb zzfpbVar, WebView webView, String str) {
        this.zza = webView;
        this.zzb = str;
        this.zzc = zzfpbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfpb.zzi(this.zza, this.zzb);
    }
}
