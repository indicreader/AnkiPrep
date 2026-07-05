package com.google.android.gms.internal.ads;

import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzenp extends zzcae {
    final /* synthetic */ zzddd zza;
    final /* synthetic */ zzdav zzb;
    final /* synthetic */ zzdce zzc;
    final /* synthetic */ zzdjd zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzenp(zzenq zzenqVar, zzddd zzdddVar, zzdav zzdavVar, zzdce zzdceVar, zzdjd zzdjdVar) {
        this.zza = zzdddVar;
        this.zzb = zzdavVar;
        this.zzc = zzdceVar;
        this.zzd = zzdjdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final void zze(IObjectWrapper iObjectWrapper) {
        this.zzb.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final void zzf(IObjectWrapper iObjectWrapper) {
        this.zza.zzbD(4);
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final void zzg(IObjectWrapper iObjectWrapper, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final void zzh(IObjectWrapper iObjectWrapper) {
        this.zzc.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final void zzi(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final void zzj(IObjectWrapper iObjectWrapper) {
        this.zza.zzbA();
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final void zzk(IObjectWrapper iObjectWrapper, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final void zzl(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final void zzm(IObjectWrapper iObjectWrapper, zzcag zzcagVar) {
        this.zzd.zza(zzcagVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final void zzn(IObjectWrapper iObjectWrapper) {
        this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final void zzo(IObjectWrapper iObjectWrapper) {
        this.zzd.zzc();
    }
}
