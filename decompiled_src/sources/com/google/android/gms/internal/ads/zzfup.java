package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzfup extends zzfvb {
    private String zza;
    private String zzb;

    @Override // com.google.android.gms.internal.ads.zzfvb
    public final zzfvb zza(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfvb
    public final zzfvb zzb(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfvb
    public final zzfvc zzc() {
        return new zzfur(this.zza, this.zzb, null);
    }
}
