package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzwo implements zzwh {
    private final zzwh zza;
    private final long zzb;

    public zzwo(zzwh zzwhVar, long j) {
        this.zza = zzwhVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzwh
    public final int zza(zzlb zzlbVar, zzih zzihVar, int i) {
        int zza = this.zza.zza(zzlbVar, zzihVar, i);
        if (zza != -4) {
            return zza;
        }
        zzihVar.zze += this.zzb;
        return -4;
    }

    @Override // com.google.android.gms.internal.ads.zzwh
    public final int zzb(long j) {
        return this.zza.zzb(j - this.zzb);
    }

    public final zzwh zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzwh
    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzwh
    public final boolean zze() {
        return this.zza.zze();
    }
}
