package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfoe {
    private final zzfom zza;
    private final zzfom zzb;
    private final zzfoi zzc;
    private final zzfol zzd;

    private zzfoe(zzfoi zzfoiVar, zzfol zzfolVar, zzfom zzfomVar, zzfom zzfomVar2, boolean z) {
        this.zzc = zzfoiVar;
        this.zzd = zzfolVar;
        this.zza = zzfomVar;
        if (zzfomVar2 == null) {
            this.zzb = zzfom.NONE;
        } else {
            this.zzb = zzfomVar2;
        }
    }

    public static zzfoe zza(zzfoi zzfoiVar, zzfol zzfolVar, zzfom zzfomVar, zzfom zzfomVar2, boolean z) {
        zzfpt.zzb(zzfolVar, "ImpressionType is null");
        zzfpt.zzb(zzfomVar, "Impression owner is null");
        if (zzfomVar != zzfom.NONE) {
            if (zzfoiVar != zzfoi.DEFINED_BY_JAVASCRIPT || zzfomVar != zzfom.NATIVE) {
                if (zzfolVar != zzfol.DEFINED_BY_JAVASCRIPT || zzfomVar != zzfom.NATIVE) {
                    return new zzfoe(zzfoiVar, zzfolVar, zzfomVar, zzfomVar2, true);
                }
                throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
            }
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
        throw new IllegalArgumentException("Impression owner is none");
    }

    public final JSONObject zzb() {
        JSONObject jSONObject = new JSONObject();
        zzfpo.zze(jSONObject, "impressionOwner", this.zza);
        zzfpo.zze(jSONObject, "mediaEventsOwner", this.zzb);
        zzfpo.zze(jSONObject, "creativeType", this.zzc);
        zzfpo.zze(jSONObject, "impressionType", this.zzd);
        zzfpo.zze(jSONObject, "isolateVerificationScripts", true);
        return jSONObject;
    }
}
