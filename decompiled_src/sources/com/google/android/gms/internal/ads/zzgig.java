package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgig {

    @Nullable
    private zzgiq zza = null;

    @Nullable
    private zzgxr zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzgig() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgig(zzgif zzgifVar) {
    }

    public final zzgig zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgig zzb(zzgxr zzgxrVar) {
        this.zzb = zzgxrVar;
        return this;
    }

    public final zzgig zzc(zzgiq zzgiqVar) {
        this.zza = zzgiqVar;
        return this;
    }

    public final zzgii zzd() throws GeneralSecurityException {
        zzgxr zzgxrVar;
        zzgxq zzb;
        zzgiq zzgiqVar = this.zza;
        if (zzgiqVar == null || (zzgxrVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgiqVar.zzc() == zzgxrVar.zza()) {
            if (!zzgiqVar.zza() || this.zzc != null) {
                if (this.zza.zza() || this.zzc == null) {
                    if (this.zza.zzd() == zzgio.zzc) {
                        zzb = zzgxq.zzb(new byte[0]);
                    } else if (this.zza.zzd() == zzgio.zzb) {
                        zzb = zzgxq.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
                    } else {
                        if (this.zza.zzd() != zzgio.zza) {
                            throw new IllegalStateException("Unknown AesEaxParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzd()))));
                        }
                        zzb = zzgxq.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
                    }
                    return new zzgii(this.zza, this.zzb, zzb, this.zzc, null);
                }
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        throw new GeneralSecurityException("Key size mismatch");
    }
}
