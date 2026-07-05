package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzenc implements zzeip {
    private final Map zza = new HashMap();
    private final zzdua zzb;

    public zzenc(zzdua zzduaVar) {
        this.zzb = zzduaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final zzeiq zza(String str, JSONObject jSONObject) throws zzfho {
        zzeiq zzeiqVar;
        synchronized (this) {
            zzeiqVar = (zzeiq) this.zza.get(str);
            if (zzeiqVar == null) {
                zzeiqVar = new zzeiq(this.zzb.zzc(str, jSONObject), new zzekk(), str);
                this.zza.put(str, zzeiqVar);
            }
        }
        return zzeiqVar;
    }
}
