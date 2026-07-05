package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzggf {
    public static final zzggq zza(zzggq zzggqVar) throws GeneralSecurityException {
        return zzggqVar != null ? zzggqVar : zzghe.zza(zzb(null).zzax());
    }

    static final zzguy zzb(zzggq zzggqVar) {
        try {
            return ((zzgoy) zzgoe.zzd().zzf(null, zzgoy.class)).zzc();
        } catch (GeneralSecurityException e) {
            throw new zzgpl("Parsing parameters failed in getProto(). You probably want to call some Tink register function for ".concat("null"), e);
        }
    }
}
