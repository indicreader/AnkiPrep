package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzeot implements com.google.android.gms.ads.internal.zzf {
    final /* synthetic */ zzdjo zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeot(zzeou zzeouVar, zzdjo zzdjoVar) {
        this.zza = zzdjoVar;
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zza(View view) {
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzb() {
        this.zza.zzb().onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzc() {
        this.zza.zzc().zza();
        this.zza.zzf().zza();
    }
}
