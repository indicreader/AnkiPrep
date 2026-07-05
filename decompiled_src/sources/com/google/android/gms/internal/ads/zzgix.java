package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgix {

    @Nullable
    private zzgji zza = null;

    @Nullable
    private zzgxr zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzgix() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgix(zzgiw zzgiwVar) {
    }

    public final zzgix zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgix zzb(zzgxr zzgxrVar) {
        this.zzb = zzgxrVar;
        return this;
    }

    public final zzgix zzc(zzgji zzgjiVar) {
        this.zza = zzgjiVar;
        return this;
    }

    public final zzgiz zzd() throws GeneralSecurityException {
        zzgxr zzgxrVar;
        zzgxq zzb;
        zzgji zzgjiVar = this.zza;
        if (zzgjiVar == null || (zzgxrVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgjiVar.zzb() == zzgxrVar.zza()) {
            if (!zzgjiVar.zza() || this.zzc != null) {
                if (this.zza.zza() || this.zzc == null) {
                    if (this.zza.zzd() == zzgjg.zzc) {
                        zzb = zzgxq.zzb(new byte[0]);
                    } else if (this.zza.zzd() == zzgjg.zzb) {
                        zzb = zzgxq.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
                    } else {
                        if (this.zza.zzd() != zzgjg.zza) {
                            throw new IllegalStateException("Unknown AesGcmParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzd()))));
                        }
                        zzb = zzgxq.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
                    }
                    return new zzgiz(this.zza, this.zzb, zzb, this.zzc, null);
                }
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        throw new GeneralSecurityException("Key size mismatch");
    }
}
