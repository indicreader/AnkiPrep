package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgow {
    private final Map zza;
    private final Map zzb;

    public /* synthetic */ zzgow(zzgos zzgosVar, zzgov zzgovVar) {
        Map map;
        Map map2;
        map = zzgosVar.zza;
        this.zza = new HashMap(map);
        map2 = zzgosVar.zzb;
        this.zzb = new HashMap(map2);
    }

    public final Class zza(Class cls) throws GeneralSecurityException {
        if (!this.zzb.containsKey(cls)) {
            throw new GeneralSecurityException("No input primitive class for " + cls.toString() + " available");
        }
        return ((zzggy) this.zzb.get(cls)).zza();
    }

    public final Object zzb(zzggc zzggcVar, Class cls) throws GeneralSecurityException {
        zzgou zzgouVar = new zzgou(zzggcVar.getClass(), cls, null);
        if (!this.zza.containsKey(zzgouVar)) {
            throw new GeneralSecurityException("No PrimitiveConstructor for " + zzgouVar.toString() + " available");
        }
        return ((zzgoq) this.zza.get(zzgouVar)).zza(zzggcVar);
    }

    public final Object zzc(zzggx zzggxVar, Class cls) throws GeneralSecurityException {
        if (!this.zzb.containsKey(cls)) {
            throw new GeneralSecurityException("No wrapper found for ".concat(cls.toString()));
        }
        zzggy zzggyVar = (zzggy) this.zzb.get(cls);
        if (!zzggxVar.zzc().equals(zzggyVar.zza()) || !zzggyVar.zza().equals(zzggxVar.zzc())) {
            throw new GeneralSecurityException("Input primitive type of the wrapper doesn't match the type of primitives in the provided PrimitiveSet");
        }
        return zzggyVar.zzc(zzggxVar);
    }
}
