package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzghk implements zzgfs {
    private final zzggx zza;
    private final zzgrx zzb;
    private final zzgrx zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzghk(zzggx zzggxVar, zzghj zzghjVar) {
        zzgrx zzgrxVar;
        this.zza = zzggxVar;
        if (zzggxVar.zzf()) {
            zzgry zzb = zzgnz.zza().zzb();
            zzgsd zza = zzgns.zza(zzggxVar);
            this.zzb = zzb.zza(zza, "aead", "encrypt");
            zzgrxVar = zzb.zza(zza, "aead", "decrypt");
        } else {
            zzgrxVar = zzgns.zza;
            this.zzb = zzgrxVar;
        }
        this.zzc = zzgrxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgfs
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length > 5) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, length);
            for (zzggt zzggtVar : this.zza.zze(copyOf)) {
                try {
                    byte[] zza = ((zzgfs) zzggtVar.zze()).zza(copyOfRange, bArr2);
                    zzggtVar.zza();
                    int length2 = copyOfRange.length;
                    return zza;
                } catch (GeneralSecurityException unused) {
                }
            }
        }
        for (zzggt zzggtVar2 : this.zza.zze(zzgfx.zza)) {
            try {
                byte[] zza2 = ((zzgfs) zzggtVar2.zze()).zza(bArr, bArr2);
                zzggtVar2.zza();
                int length3 = bArr.length;
                return zza2;
            } catch (GeneralSecurityException unused2) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }
}
