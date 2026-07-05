package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgos {
    private final Map zza;
    private final Map zzb;

    private zzgos() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public final zzgos zza(zzgoq zzgoqVar) throws GeneralSecurityException {
        if (zzgoqVar != null) {
            zzgou zzgouVar = new zzgou(zzgoqVar.zzc(), zzgoqVar.zzd(), null);
            if (this.zza.containsKey(zzgouVar)) {
                zzgoq zzgoqVar2 = (zzgoq) this.zza.get(zzgouVar);
                if (!zzgoqVar2.equals(zzgoqVar) || !zzgoqVar.equals(zzgoqVar2)) {
                    throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: ".concat(zzgouVar.toString()));
                }
            } else {
                this.zza.put(zzgouVar, zzgoqVar);
            }
            return this;
        }
        throw new NullPointerException("primitive constructor must be non-null");
    }

    public final zzgos zzb(zzggy zzggyVar) throws GeneralSecurityException {
        Map map = this.zzb;
        Class zzb = zzggyVar.zzb();
        if (map.containsKey(zzb)) {
            zzggy zzggyVar2 = (zzggy) this.zzb.get(zzb);
            if (!zzggyVar2.equals(zzggyVar) || !zzggyVar.equals(zzggyVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type".concat(zzb.toString()));
            }
        } else {
            this.zzb.put(zzb, zzggyVar);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgos(zzgor zzgorVar) {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgos(zzgow zzgowVar, zzgor zzgorVar) {
        this.zza = new HashMap(zzgow.zzd(zzgowVar));
        this.zzb = new HashMap(zzgow.zze(zzgowVar));
    }
}
