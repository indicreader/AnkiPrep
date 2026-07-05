package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdqi {
    private final Executor zza;
    private final zzdqd zzb;

    public zzdqi(Executor executor, zzdqd zzdqdVar) {
        this.zza = executor;
        this.zzb = zzdqdVar;
    }

    public final ListenableFuture zza(JSONObject jSONObject, String str) {
        ListenableFuture zzh;
        JSONArray optJSONArray = jSONObject.optJSONArray("custom_assets");
        if (optJSONArray == null) {
            return zzgen.zzh(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                zzh = zzgen.zzh(null);
            } else {
                final String optString = optJSONObject.optString("name");
                if (optString == null) {
                    zzh = zzgen.zzh(null);
                } else {
                    String optString2 = optJSONObject.optString("type");
                    if ("string".equals(optString2)) {
                        zzh = zzgen.zzh(new zzdqh(optString, optJSONObject.optString("string_value")));
                    } else if ("image".equals(optString2)) {
                        zzh = zzgen.zzm(this.zzb.zze(optJSONObject, "image_value"), new zzfws() { // from class: com.google.android.gms.internal.ads.zzdqf
                            @Override // com.google.android.gms.internal.ads.zzfws
                            public final Object apply(Object obj) {
                                return new zzdqh(optString, (zzbiz) obj);
                            }
                        }, this.zza);
                    } else {
                        zzh = zzgen.zzh(null);
                    }
                }
            }
            arrayList.add(zzh);
        }
        return zzgen.zzm(zzgen.zzd(arrayList), new zzfws() { // from class: com.google.android.gms.internal.ads.zzdqg
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                ArrayList arrayList2 = new ArrayList();
                for (zzdqh zzdqhVar : (List) obj) {
                    if (zzdqhVar != null) {
                        arrayList2.add(zzdqhVar);
                    }
                }
                return arrayList2;
            }
        }, this.zza);
    }
}
