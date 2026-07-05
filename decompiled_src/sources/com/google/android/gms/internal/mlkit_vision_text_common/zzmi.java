package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes3.dex */
public final class zzmi {
    private final zzmg zza;
    private final Integer zzb;
    private final Integer zzc;
    private final Boolean zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzmi(zzmf zzmfVar, zzmh zzmhVar) {
        zzmg zzmgVar;
        Integer num;
        zzmgVar = zzmfVar.zza;
        this.zza = zzmgVar;
        num = zzmfVar.zzb;
        this.zzb = num;
        this.zzc = null;
        this.zzd = null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzmi)) {
            return false;
        }
        zzmi zzmiVar = (zzmi) obj;
        if (Objects.equal(this.zza, zzmiVar.zza) && Objects.equal(this.zzb, zzmiVar.zzb)) {
            Integer num = zzmiVar.zzc;
            if (Objects.equal(null, null)) {
                Boolean bool = zzmiVar.zzd;
                if (Objects.equal(null, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, null, null);
    }

    public final zzmg zza() {
        return this.zza;
    }

    public final Integer zzb() {
        return this.zzb;
    }
}
