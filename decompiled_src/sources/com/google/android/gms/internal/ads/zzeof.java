package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeof implements com.google.android.gms.ads.internal.zzf {
    final AtomicBoolean zza = new AtomicBoolean(false);
    private final zzdav zzb;
    private final zzdbp zzc;
    private final zzdiw zzd;
    private final zzdio zze;
    private final zzctb zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeof(zzdav zzdavVar, zzdbp zzdbpVar, zzdiw zzdiwVar, zzdio zzdioVar, zzctb zzctbVar) {
        this.zzb = zzdavVar;
        this.zzc = zzdbpVar;
        this.zzd = zzdiwVar;
        this.zze = zzdioVar;
        this.zzf = zzctbVar;
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final synchronized void zza(View view) {
        if (this.zza.compareAndSet(false, true)) {
            this.zzf.zzq();
            this.zze.zza(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzb() {
        if (this.zza.get()) {
            this.zzb.onAdClicked();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzc() {
        if (this.zza.get()) {
            this.zzc.zza();
            this.zzd.zza();
        }
    }
}
