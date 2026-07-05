package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzghe {
    public static zzggq zza(byte[] bArr) throws GeneralSecurityException {
        try {
            zzguy zze = zzguy.zze(bArr, zzgzf.zza());
            zzgoe zzd = zzgoe.zzd();
            zzgoy zza = zzgoy.zza(zze);
            return !zzd.zzk(zza) ? new zzgnp(zza) : zzd.zzc(zza);
        } catch (IOException e) {
            throw new GeneralSecurityException("Failed to parse proto", e);
        }
    }

    public static byte[] zzb(zzggq zzggqVar) throws GeneralSecurityException {
        return ((zzgoy) zzgoe.zzd().zzf(zzggqVar, zzgoy.class)).zzc().zzax();
    }
}
