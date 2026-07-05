package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzctm implements zzhhd {
    private final zzhhu zza;

    public zzctm(zzhhu zzhhuVar) {
        this.zza = zzhhuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return new JSONObject(((zzcwy) this.zza).zza().zzA);
        } catch (JSONException unused) {
            return null;
        }
    }
}
