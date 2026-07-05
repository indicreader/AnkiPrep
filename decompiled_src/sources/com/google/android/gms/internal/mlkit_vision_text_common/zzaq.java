package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes3.dex */
abstract class zzaq implements zzcf {

    @CheckForNull
    private transient Set zza;

    @CheckForNull
    private transient Map zzb;

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzcf) {
            return zzn().equals(((zzcf) obj).zzn());
        }
        return false;
    }

    public final int hashCode() {
        return zzn().hashCode();
    }

    public final String toString() {
        return zzn().toString();
    }

    abstract Map zzh();

    abstract Set zzi();

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzcf
    public boolean zzm(Object obj, Object obj2) {
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzcf
    public final Map zzn() {
        Map map = this.zzb;
        if (map != null) {
            return map;
        }
        Map zzh = zzh();
        this.zzb = zzh;
        return zzh;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzcf
    public final Set zzo() {
        Set set = this.zza;
        if (set != null) {
            return set;
        }
        Set zzi = zzi();
        this.zza = zzi;
        return zzi;
    }
}
