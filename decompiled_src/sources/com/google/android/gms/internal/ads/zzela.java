package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzela implements zzeip {
    private final zzdua zza;

    public zzela(zzdua zzduaVar) {
        this.zza = zzduaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final zzeiq zza(String str, JSONObject jSONObject) throws zzfho {
        return new zzeiq(this.zza.zzc(str, jSONObject), new zzekj(), str);
    }
}
