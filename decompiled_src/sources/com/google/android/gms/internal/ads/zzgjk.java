package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgjk {

    @Nullable
    private zzgjv zza = null;

    @Nullable
    private zzgxr zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzgjk() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgjk(zzgjj zzgjjVar) {
    }

    public final zzgjk zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgjk zzb(zzgxr zzgxrVar) {
        this.zzb = zzgxrVar;
        return this;
    }

    public final zzgjk zzc(zzgjv zzgjvVar) {
        this.zza = zzgjvVar;
        return this;
    }

    public final zzgjm zzd() throws GeneralSecurityException {
        zzgxr zzgxrVar;
        zzgxq zzb;
        zzgjv zzgjvVar = this.zza;
        if (zzgjvVar == null || (zzgxrVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgjvVar.zzb() == zzgxrVar.zza()) {
            if (!zzgjvVar.zza() || this.zzc != null) {
                if (this.zza.zza() || this.zzc == null) {
                    if (this.zza.zzc() == zzgjt.zzc) {
                        zzb = zzgxq.zzb(new byte[0]);
                    } else if (this.zza.zzc() == zzgjt.zzb) {
                        zzb = zzgxq.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
                    } else {
                        if (this.zza.zzc() != zzgjt.zza) {
                            throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzc()))));
                        }
                        zzb = zzgxq.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
                    }
                    return new zzgjm(this.zza, this.zzb, zzb, this.zzc, null);
                }
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        throw new GeneralSecurityException("Key size mismatch");
    }
}
