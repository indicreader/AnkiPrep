package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbwz {
    public final boolean zza;
    public final String zzb;

    public zzbwz(boolean z, String str) {
        this.zza = z;
        this.zzb = str;
    }

    public static zzbwz zza(JSONObject jSONObject) {
        return new zzbwz(jSONObject.optBoolean("enable_prewarming", false), jSONObject.optString("prefetch_url", ""));
    }
}
