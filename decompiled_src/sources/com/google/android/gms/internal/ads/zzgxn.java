package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgxn implements zzggp {
    private static final byte[] zza = {0};
    private final zzgse zzb;
    private final int zzc;
    private final byte[] zzd;
    private final byte[] zze;

    private zzgxn(zzgpq zzgpqVar) throws GeneralSecurityException {
        this.zzb = new zzgxk(zzgpqVar.zzd().zzd(zzggb.zza()));
        this.zzc = zzgpqVar.zza().zzb();
        this.zzd = zzgpqVar.zzc().zzc();
        if (zzgpqVar.zza().zze().equals(zzgpx.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public static zzggp zza(zzgpq zzgpqVar) throws GeneralSecurityException {
        return new zzgxn(zzgpqVar);
    }

    public static zzggp zzb(zzgqm zzgqmVar) throws GeneralSecurityException {
        return new zzgxn(zzgqmVar);
    }

    public final byte[] zzc(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2 = this.zze;
        return bArr2.length > 0 ? zzgwp.zzb(this.zzd, this.zzb.zza(zzgwp.zzb(bArr, bArr2), this.zzc)) : zzgwp.zzb(this.zzd, this.zzb.zza(bArr, this.zzc));
    }

    private zzgxn(zzgqm zzgqmVar) throws GeneralSecurityException {
        String valueOf = String.valueOf(String.valueOf(zzgqmVar.zzd().zzf()));
        this.zzb = new zzgxm("HMAC".concat(valueOf), new SecretKeySpec(zzgqmVar.zze().zzd(zzggb.zza()), "HMAC"));
        this.zzc = zzgqmVar.zzd().zzb();
        this.zzd = zzgqmVar.zzc().zzc();
        if (zzgqmVar.zzd().zzg().equals(zzgqv.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public zzgxn(zzgse zzgseVar, int i) throws GeneralSecurityException {
        this.zzb = zzgseVar;
        this.zzc = i;
        this.zzd = new byte[0];
        this.zze = new byte[0];
        zzgseVar.zza(new byte[0], i);
    }
}
