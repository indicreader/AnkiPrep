package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgno extends zzggc {
    private final zzgox zza;

    public zzgno(zzgox zzgoxVar, @Nullable zzghc zzghcVar) throws GeneralSecurityException {
        zzc(zzgoxVar, zzghcVar);
        this.zza = zzgoxVar;
    }

    private static void zzc(zzgox zzgoxVar, @Nullable zzghc zzghcVar) throws GeneralSecurityException {
        int i = zzgnn.zzb[zzgoxVar.zzb().ordinal()];
    }

    public final zzgox zza(@Nullable zzghc zzghcVar) throws GeneralSecurityException {
        zzc(this.zza, zzghcVar);
        return this.zza;
    }

    @Nullable
    public final Integer zzb() {
        return this.zza.zzf();
    }
}
