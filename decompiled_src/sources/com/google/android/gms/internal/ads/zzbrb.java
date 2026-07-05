package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbrb implements zzcey {
    final /* synthetic */ zzbrd zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbrb(zzbrd zzbrdVar) {
        this.zza = zzbrdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcey
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzbri zzbriVar;
        com.google.android.gms.ads.internal.util.zze.zza("Releasing engine reference.");
        zzbriVar = this.zza.zzb;
        zzbriVar.zzd();
    }
}
