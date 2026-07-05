package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes3.dex */
public final class zzpk {
    private final zzpi zza;
    private final Boolean zzb;
    private final String zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzpk(zzph zzphVar, zzpj zzpjVar) {
        zzpi zzpiVar;
        zzpiVar = zzphVar.zza;
        this.zza = zzpiVar;
        this.zzb = null;
        this.zzc = null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzpk)) {
            return false;
        }
        zzpk zzpkVar = (zzpk) obj;
        if (Objects.equal(this.zza, zzpkVar.zza)) {
            Boolean bool = zzpkVar.zzb;
            if (Objects.equal(null, null)) {
                String str = zzpkVar.zzc;
                if (Objects.equal(null, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, null);
    }

    public final zzpi zza() {
        return this.zza;
    }
}
