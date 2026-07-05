package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes3.dex */
public final class zzlv {
    private final zzlr zza;
    private final zzlt zzb;
    private final zzlt zzc;
    private final Boolean zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzlv(zzls zzlsVar, zzlu zzluVar) {
        zzlr zzlrVar;
        zzlrVar = zzlsVar.zza;
        this.zza = zzlrVar;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzlv)) {
            return false;
        }
        zzlv zzlvVar = (zzlv) obj;
        if (Objects.equal(this.zza, zzlvVar.zza)) {
            zzlt zzltVar = zzlvVar.zzb;
            if (Objects.equal(null, null)) {
                zzlt zzltVar2 = zzlvVar.zzc;
                if (Objects.equal(null, null)) {
                    Boolean bool = zzlvVar.zzd;
                    if (Objects.equal(null, null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, null, null);
    }

    public final zzlr zza() {
        return this.zza;
    }
}
