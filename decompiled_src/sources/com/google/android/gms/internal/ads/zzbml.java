package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzbml implements zzbng {
    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject zza;
        zzcjk zzcjkVar = (zzcjk) obj;
        zzbja zzK = zzcjkVar.zzK();
        if (zzK == null || (zza = zzK.zza()) == null) {
            zzcjkVar.zze("nativeAdViewSignalsReady", new JSONObject());
        } else {
            zzcjkVar.zze("nativeAdViewSignalsReady", zza);
        }
    }
}
