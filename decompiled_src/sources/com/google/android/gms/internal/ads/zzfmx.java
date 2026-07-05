package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfmx implements zzgej {
    final /* synthetic */ zzfmz zza;
    final /* synthetic */ zzfmo zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfmx(zzfmz zzfmzVar, zzfmo zzfmoVar) {
        this.zza = zzfmzVar;
        this.zzb = zzfmoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        zzfmo zzfmoVar = this.zzb;
        zzfmoVar.zzg(th);
        zzfmoVar.zzf(false);
        this.zza.zza(zzfmoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zzb(Object obj) {
    }
}
