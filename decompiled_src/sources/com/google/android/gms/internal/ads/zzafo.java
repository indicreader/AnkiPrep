package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzafo extends zzadj {
    final /* synthetic */ zzadu zza;
    final /* synthetic */ zzafp zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzafo(zzafp zzafpVar, zzadu zzaduVar, zzadu zzaduVar2) {
        super(zzaduVar);
        this.zza = zzaduVar2;
        this.zzb = zzafpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadj, com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j) {
        long j2;
        long j3;
        zzads zzg = this.zza.zzg(j);
        zzadv zzadvVar = zzg.zza;
        long j4 = zzadvVar.zzc;
        j2 = this.zzb.zzb;
        zzadv zzadvVar2 = new zzadv(zzadvVar.zzb, j4 + j2);
        zzadv zzadvVar3 = zzg.zzb;
        long j5 = zzadvVar3.zzc;
        j3 = this.zzb.zzb;
        return new zzads(zzadvVar2, new zzadv(zzadvVar3.zzb, j5 + j3));
    }
}
