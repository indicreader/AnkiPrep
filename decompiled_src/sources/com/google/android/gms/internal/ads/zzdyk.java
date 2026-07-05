package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdyk implements zzdhv {
    private final Bundle zza = new Bundle();

    @Override // com.google.android.gms.internal.ads.zzdhv
    public final void zza(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdhv
    public final synchronized void zzb(String str, String str2) {
        this.zza.putInt(str, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzdhv
    public final synchronized void zzc(String str) {
        this.zza.putInt(str, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzdhv
    public final synchronized void zzd(String str) {
        this.zza.putInt(str, 2);
    }

    @Override // com.google.android.gms.internal.ads.zzdhv
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzdhv
    public final void zzf() {
    }

    public final synchronized Bundle zzg() {
        return new Bundle(this.zza);
    }
}
