package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzeok implements com.google.android.gms.ads.internal.zzf {
    final /* synthetic */ zzceu zza;
    final /* synthetic */ zzfgy zzb;
    final /* synthetic */ zzfgm zzc;
    final /* synthetic */ zzeoq zzd;
    final /* synthetic */ zzeol zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeok(zzeol zzeolVar, zzceu zzceuVar, zzfgy zzfgyVar, zzfgm zzfgmVar, zzeoq zzeoqVar) {
        this.zza = zzceuVar;
        this.zzb = zzfgyVar;
        this.zzc = zzfgmVar;
        this.zzd = zzeoqVar;
        this.zze = zzeolVar;
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zza(View view) {
        zzeou zzeouVar;
        zzeoq zzeoqVar = this.zzd;
        zzeouVar = this.zze.zzd;
        this.zza.zzc(zzeouVar.zza(this.zzb, this.zzc, view, zzeoqVar));
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzb() {
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzc() {
    }
}
