package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes3.dex */
public final class zzep {
    private final zzmv zza;
    private final Boolean zzb;
    private final Boolean zzc;
    private final zzmi zzd;
    private final zzpk zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzep(zzen zzenVar, zzeo zzeoVar) {
        zzmv zzmvVar;
        Boolean bool;
        zzpk zzpkVar;
        zzmvVar = zzenVar.zza;
        this.zza = zzmvVar;
        this.zzb = null;
        bool = zzenVar.zzb;
        this.zzc = bool;
        this.zzd = null;
        zzpkVar = zzenVar.zzc;
        this.zze = zzpkVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzep)) {
            return false;
        }
        zzep zzepVar = (zzep) obj;
        if (Objects.equal(this.zza, zzepVar.zza)) {
            Boolean bool = zzepVar.zzb;
            if (Objects.equal(null, null) && Objects.equal(this.zzc, zzepVar.zzc)) {
                zzmi zzmiVar = zzepVar.zzd;
                if (Objects.equal(null, null) && Objects.equal(this.zze, zzepVar.zze)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, this.zzc, null, this.zze);
    }

    public final zzmv zza() {
        return this.zza;
    }

    public final zzpk zzb() {
        return this.zze;
    }

    public final Boolean zzc() {
        return this.zzc;
    }
}
