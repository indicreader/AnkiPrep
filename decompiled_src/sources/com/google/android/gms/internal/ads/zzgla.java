package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgla extends zzghh {
    private final zzglf zza;

    private zzgla(zzglf zzglfVar) {
        this.zza = zzglfVar;
    }

    public static zzgla zza(zzglf zzglfVar) throws GeneralSecurityException {
        return new zzgla(zzglfVar);
    }

    public final zzglf zzb() {
        return this.zza;
    }
}
