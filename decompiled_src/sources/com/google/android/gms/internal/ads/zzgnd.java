package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgnd {
    private static final Logger zza = Logger.getLogger(zzgnd.class.getName());
    private static final zzgnd zzb = new zzgnd();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final ConcurrentMap zzd = new ConcurrentHashMap();

    public static zzgnd zzc() {
        return zzb;
    }

    private final synchronized zzgnc zzg(String str) throws GeneralSecurityException {
        if (!this.zzc.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type ".concat(String.valueOf(str)));
        }
        return (zzgnc) this.zzc.get(str);
    }

    private final synchronized void zzh(zzgnc zzgncVar, boolean z, boolean z2) throws GeneralSecurityException {
        String str = ((zzgnm) zzgncVar.zza).zza;
        if (this.zzd.containsKey(str) && !((Boolean) this.zzd.get(str)).booleanValue()) {
            throw new GeneralSecurityException("New keys are already disallowed for key type ".concat(str));
        }
        zzgnc zzgncVar2 = (zzgnc) this.zzc.get(str);
        if (zzgncVar2 != null && !zzgncVar2.zza().equals(zzgncVar.zza())) {
            zza.logp(Level.WARNING, "com.google.crypto.tink.internal.KeyManagerRegistry", "registerKeyManagerContainer", "Attempted overwrite of a registered key manager for key type ".concat(str));
            throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", str, zzgncVar2.zza().getName(), zzgncVar.zza().getName()));
        }
        this.zzc.putIfAbsent(str, zzgncVar);
        this.zzd.put(str, true);
    }

    public final zzggd zza(String str, Class cls) throws GeneralSecurityException {
        zzgnc zzg = zzg(str);
        if (zzg.zzb().contains(cls)) {
            if (((zzgnm) zzg.zza).zzb.equals(cls)) {
                return zzg.zza;
            }
            throw new InternalError("This should never be called, as we always first check supportedPrimitives.");
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzg.zza());
        Set<Class> zzb2 = zzg.zzb();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class cls2 : zzb2) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(cls2.getCanonicalName());
            z = false;
        }
        throw new GeneralSecurityException("Primitive type " + name + " not supported by key manager of type " + valueOf + ", supported primitives: " + sb.toString());
    }

    public final zzggd zzb(String str) throws GeneralSecurityException {
        return zzg(str).zza;
    }

    public final synchronized void zzd(zzggd zzggdVar, boolean z) throws GeneralSecurityException {
        zzf(zzggdVar, 1, true);
    }

    public final boolean zze(String str) {
        return ((Boolean) this.zzd.get(str)).booleanValue();
    }

    public final synchronized void zzf(zzggd zzggdVar, int i, boolean z) throws GeneralSecurityException {
        if (zzgmv.zza(i)) {
            zzh(new zzgnc(zzggdVar), false, true);
        } else {
            throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");
        }
    }
}
