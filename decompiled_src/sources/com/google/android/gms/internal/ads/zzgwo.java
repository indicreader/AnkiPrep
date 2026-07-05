package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgwo implements zzgfs {
    private final zzgmg zza;
    private final byte[] zzb;

    private zzgwo(byte[] bArr, zzgxq zzgxqVar) throws GeneralSecurityException {
        if (!zzgmv.zza(2)) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.zza = new zzgmg(bArr, true);
        this.zzb = zzgxqVar.zzc();
    }

    public static zzgfs zzb(zzgiz zzgizVar) throws GeneralSecurityException {
        zzgizVar.zzb();
        zzgizVar.zzb();
        return new zzgwo(zzgizVar.zzd().zzd(zzggb.zza()), zzgizVar.zzc());
    }

    @Override // com.google.android.gms.internal.ads.zzgfs
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return this.zza.zza(Arrays.copyOf(bArr, 12), bArr, bArr2);
        }
        if (!zzgpm.zzb(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArr4 = this.zzb;
        byte[] copyOfRange = Arrays.copyOfRange(bArr, bArr4.length, bArr.length);
        return this.zza.zza(Arrays.copyOf(copyOfRange, 12), copyOfRange, bArr2);
    }
}
