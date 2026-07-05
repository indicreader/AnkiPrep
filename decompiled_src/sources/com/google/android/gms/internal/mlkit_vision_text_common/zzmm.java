package com.google.android.gms.internal.mlkit_vision_text_common;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes3.dex */
public final class zzmm {
    private Long zza;
    private zzmv zzb;
    private Boolean zzc;
    private Boolean zzd;
    private Boolean zze;

    public final zzmm zza(Boolean bool) {
        this.zzd = bool;
        return this;
    }

    public final zzmm zzb(Boolean bool) {
        this.zze = bool;
        return this;
    }

    public final zzmm zzc(Long l) {
        this.zza = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzmm zzd(zzmv zzmvVar) {
        this.zzb = zzmvVar;
        return this;
    }

    public final zzmm zze(Boolean bool) {
        this.zzc = bool;
        return this;
    }

    public final zzmo zzf() {
        return new zzmo(this, null);
    }
}
