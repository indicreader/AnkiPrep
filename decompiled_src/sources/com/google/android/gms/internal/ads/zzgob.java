package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgob {
    private static final zzgob zza = new zzgob();
    private final AtomicReference zzb = new AtomicReference(new zzgow(new zzgos(null), null));

    zzgob() {
    }

    public static zzgob zza() {
        return zza;
    }

    public final Class zzb(Class cls) throws GeneralSecurityException {
        return ((zzgow) this.zzb.get()).zza(cls);
    }

    public final Object zzc(zzggc zzggcVar, Class cls) throws GeneralSecurityException {
        return ((zzgow) this.zzb.get()).zzb(zzggcVar, cls);
    }

    public final Object zzd(zzggx zzggxVar, Class cls) throws GeneralSecurityException {
        return ((zzgow) this.zzb.get()).zzc(zzggxVar, cls);
    }

    public final synchronized void zze(zzgoq zzgoqVar) throws GeneralSecurityException {
        zzgos zzgosVar = new zzgos((zzgow) this.zzb.get(), null);
        zzgosVar.zza(zzgoqVar);
        this.zzb.set(new zzgow(zzgosVar, null));
    }

    public final synchronized void zzf(zzggy zzggyVar) throws GeneralSecurityException {
        zzgos zzgosVar = new zzgos((zzgow) this.zzb.get(), null);
        zzgosVar.zzb(zzggyVar);
        this.zzb.set(new zzgow(zzgosVar, null));
    }
}
