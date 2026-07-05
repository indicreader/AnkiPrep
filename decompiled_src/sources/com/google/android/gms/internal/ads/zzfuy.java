package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzfuy extends zzfvr {
    private String zza;
    private String zzb;

    @Override // com.google.android.gms.internal.ads.zzfvr
    public final zzfvr zza(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfvr
    public final zzfvr zzb(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfvr
    public final zzfvs zzc() {
        return new zzfva(this.zza, this.zzb, null);
    }
}
