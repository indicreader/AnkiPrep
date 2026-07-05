package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzbmu implements zzgej {
    final /* synthetic */ zzcjk zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbmu(zzcjk zzcjkVar) {
        this.zza = zzcjkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.zzt.zzo().zzw(th, "DefaultGmsgHandlers.attributionReportingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcjk zzcjkVar = this.zza;
        new com.google.android.gms.ads.internal.util.zzca(zzcjkVar.getContext(), zzcjkVar.zzn().zza, (String) obj).zzb();
    }
}
