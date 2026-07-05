package com.google.android.gms.internal.mlkit_vision_text_common;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes3.dex */
public final class zzem {
    private zzep zza;
    private Integer zzb;
    private zzmb zzc;

    public final zzem zza(Integer num) {
        this.zzb = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzem zzb(zzmb zzmbVar) {
        this.zzc = zzmbVar;
        return this;
    }

    public final zzem zzc(zzep zzepVar) {
        this.zza = zzepVar;
        return this;
    }

    public final zzer zze() {
        return new zzer(this, null);
    }
}
