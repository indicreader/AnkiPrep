package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfmw implements zzgej {
    final /* synthetic */ zzfmz zza;
    final /* synthetic */ zzfmo zzb;
    final /* synthetic */ boolean zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfmw(zzfmz zzfmzVar, zzfmo zzfmoVar, boolean z) {
        this.zza = zzfmzVar;
        this.zzb = zzfmoVar;
        this.zzc = z;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        zzfmo zzfmoVar = this.zzb;
        if (zzfmoVar.zzj()) {
            zzfmz zzfmzVar = this.zza;
            zzfmoVar.zzg(th);
            zzfmoVar.zzf(false);
            zzfmzVar.zza(zzfmoVar);
            if (this.zzc) {
                this.zza.zzg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zzb(Object obj) {
        zzfmo zzfmoVar = this.zzb;
        zzfmoVar.zzf(true);
        this.zza.zza(zzfmoVar);
        if (this.zzc) {
            this.zza.zzg();
        }
    }
}
