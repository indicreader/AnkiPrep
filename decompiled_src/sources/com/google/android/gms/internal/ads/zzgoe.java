package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgoe {
    private static final zzgoe zza = (zzgoe) zzgpl.zza(new zzgpk() { // from class: com.google.android.gms.internal.ads.zzgoc
        @Override // com.google.android.gms.internal.ads.zzgpk
        public final Object zza() {
            zzgoe zzgoeVar = new zzgoe();
            zzgoeVar.zzh(new zzgni(zzgno.class, zzgox.class, new zzgnj() { // from class: com.google.android.gms.internal.ads.zzgod
                @Override // com.google.android.gms.internal.ads.zzgnj
                public final zzgpc zza(zzggc zzggcVar, zzghc zzghcVar) {
                    return ((zzgno) zzggcVar).zza(zzghcVar);
                }
            }));
            return zzgoeVar;
        }
    });
    private final AtomicReference zzb = new AtomicReference(new zzgpj(new zzgpd(), null));

    public static zzgoe zzd() {
        return zza;
    }

    public final zzggc zza(zzgpc zzgpcVar, @Nullable zzghc zzghcVar) throws GeneralSecurityException {
        return ((zzgpj) this.zzb.get()).zza(zzgpcVar, zzghcVar);
    }

    public final zzggc zzb(zzgox zzgoxVar, @Nullable zzghc zzghcVar) throws GeneralSecurityException {
        if (!((zzgpj) this.zzb.get()).zzi(zzgoxVar)) {
            return new zzgno(zzgoxVar, zzghcVar);
        }
        return zza(zzgoxVar, zzghcVar);
    }

    public final zzggq zzc(zzgpc zzgpcVar) throws GeneralSecurityException {
        return ((zzgpj) this.zzb.get()).zzb(zzgpcVar);
    }

    public final zzgpc zze(zzggc zzggcVar, Class cls, @Nullable zzghc zzghcVar) throws GeneralSecurityException {
        return ((zzgpj) this.zzb.get()).zzc(zzggcVar, cls, zzghcVar);
    }

    public final zzgpc zzf(zzggq zzggqVar, Class cls) throws GeneralSecurityException {
        return ((zzgpj) this.zzb.get()).zzd(zzggqVar, cls);
    }

    public final synchronized void zzg(zzgnh zzgnhVar) throws GeneralSecurityException {
        zzgpd zzgpdVar = new zzgpd((zzgpj) this.zzb.get());
        zzgpdVar.zza(zzgnhVar);
        this.zzb.set(new zzgpj(zzgpdVar, null));
    }

    public final synchronized void zzh(zzgnl zzgnlVar) throws GeneralSecurityException {
        zzgpd zzgpdVar = new zzgpd((zzgpj) this.zzb.get());
        zzgpdVar.zzb(zzgnlVar);
        this.zzb.set(new zzgpj(zzgpdVar, null));
    }

    public final synchronized void zzi(zzgoi zzgoiVar) throws GeneralSecurityException {
        zzgpd zzgpdVar = new zzgpd((zzgpj) this.zzb.get());
        zzgpdVar.zzc(zzgoiVar);
        this.zzb.set(new zzgpj(zzgpdVar, null));
    }

    public final synchronized void zzj(zzgom zzgomVar) throws GeneralSecurityException {
        zzgpd zzgpdVar = new zzgpd((zzgpj) this.zzb.get());
        zzgpdVar.zzd(zzgomVar);
        this.zzb.set(new zzgpj(zzgpdVar, null));
    }

    public final boolean zzk(zzgpc zzgpcVar) {
        return ((zzgpj) this.zzb.get()).zzj(zzgpcVar);
    }
}
