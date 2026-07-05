package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgls extends zzghh {
    private final zzgly zza;
    private final zzgxr zzb;
    private final zzgxq zzc;

    @Nullable
    private final Integer zzd;

    private zzgls(zzgly zzglyVar, zzgxr zzgxrVar, zzgxq zzgxqVar, @Nullable Integer num) {
        this.zza = zzglyVar;
        this.zzb = zzgxrVar;
        this.zzc = zzgxqVar;
        this.zzd = num;
    }

    public static zzgls zza(zzglx zzglxVar, zzgxr zzgxrVar, @Nullable Integer num) throws GeneralSecurityException {
        zzgxq zzb;
        zzglx zzglxVar2 = zzglx.zzc;
        if (zzglxVar != zzglxVar2 && num == null) {
            throw new GeneralSecurityException("For given Variant " + zzglxVar.toString() + " the value of idRequirement must be non-null");
        }
        if (zzglxVar != zzglxVar2 || num == null) {
            if (zzgxrVar.zza() == 32) {
                zzgly zzc = zzgly.zzc(zzglxVar);
                if (zzc.zzb() == zzglxVar2) {
                    zzb = zzgxq.zzb(new byte[0]);
                } else if (zzc.zzb() == zzglx.zzb) {
                    zzb = zzgxq.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
                } else if (zzc.zzb() == zzglx.zza) {
                    zzb = zzgxq.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
                } else {
                    throw new IllegalStateException("Unknown Variant: ".concat(zzc.zzb().toString()));
                }
                return new zzgls(zzc, zzgxrVar, zzb, num);
            }
            throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zzgxrVar.zza());
        }
        throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
    }

    public final zzgly zzb() {
        return this.zza;
    }

    public final zzgxq zzc() {
        return this.zzc;
    }

    public final zzgxr zzd() {
        return this.zzb;
    }

    @Nullable
    public final Integer zze() {
        return this.zzd;
    }
}
