package com.google.android.gms.internal.ads;

import androidx.browser.customtabs.CustomTabsSession;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbhg extends QueryInfoGenerationCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbhh zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbhg(zzbhh zzbhhVar, String str) {
        this.zza = str;
        this.zzb = zzbhhVar;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        CustomTabsSession customTabsSession;
        zzcec.zzj("Failed to generate query info for Custom Tab error: ".concat(String.valueOf(str)));
        try {
            zzbhh zzbhhVar = this.zzb;
            customTabsSession = zzbhhVar.zzd;
            customTabsSession.postMessage(zzbhhVar.zzc(this.zza, str).toString(), null);
        } catch (JSONException e) {
            zzcec.zzh("Error creating PACT Error Response JSON: ", e);
        }
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        CustomTabsSession customTabsSession;
        String query = queryInfo.getQuery();
        try {
            zzbhh zzbhhVar = this.zzb;
            customTabsSession = zzbhhVar.zzd;
            customTabsSession.postMessage(zzbhhVar.zzd(this.zza, query).toString(), null);
        } catch (JSONException e) {
            zzcec.zzh("Error creating PACT Signal Response JSON: ", e);
        }
    }
}
