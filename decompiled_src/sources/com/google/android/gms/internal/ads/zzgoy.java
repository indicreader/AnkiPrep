package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgoy implements zzgpc {
    private final zzgxq zza;
    private final zzguy zzb;

    private zzgoy(zzguy zzguyVar, zzgxq zzgxqVar) {
        this.zzb = zzguyVar;
        this.zza = zzgxqVar;
    }

    public static zzgoy zza(zzguy zzguyVar) throws GeneralSecurityException {
        String zzh = zzguyVar.zzh();
        Charset charset = zzgpm.zza;
        byte[] bArr = new byte[zzh.length()];
        for (int i = 0; i < zzh.length(); i++) {
            char charAt = zzh.charAt(i);
            if (charAt < '!' || charAt > '~') {
                throw new GeneralSecurityException("Not a printable ASCII character: " + charAt);
            }
            bArr[i] = (byte) charAt;
        }
        return new zzgoy(zzguyVar, zzgxq.zzb(bArr));
    }

    public static zzgoy zzb(zzguy zzguyVar) {
        return new zzgoy(zzguyVar, zzgpm.zza(zzguyVar.zzh()));
    }

    public final zzguy zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgpc
    public final zzgxq zzd() {
        return this.zza;
    }
}
