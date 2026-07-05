package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcqt {
    private final Map zza;
    private final Map zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcqt(Map map, Map map2) {
        this.zza = map;
        this.zzb = map2;
    }

    public final void zza(zzfgy zzfgyVar) throws Exception {
        for (zzfgw zzfgwVar : zzfgyVar.zzb.zzc) {
            if (this.zza.containsKey(zzfgwVar.zza)) {
                ((zzcqw) this.zza.get(zzfgwVar.zza)).zza(zzfgwVar.zzb);
            } else if (this.zzb.containsKey(zzfgwVar.zza)) {
                zzcqv zzcqvVar = (zzcqv) this.zzb.get(zzfgwVar.zza);
                JSONObject jSONObject = zzfgwVar.zzb;
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString = jSONObject.optString(next);
                    if (optString != null) {
                        hashMap.put(next, optString);
                    }
                }
                zzcqvVar.zza(hashMap);
            }
        }
    }
}
