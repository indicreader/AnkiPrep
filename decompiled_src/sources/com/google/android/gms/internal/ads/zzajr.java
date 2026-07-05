package com.google.android.gms.internal.ads;

import java.math.BigInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzajr implements zzadu {
    final /* synthetic */ zzajs zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzajr(zzajs zzajsVar, zzajq zzajqVar) {
        this.zza = zzajsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        zzake zzakeVar;
        long j;
        zzajs zzajsVar = this.zza;
        zzakeVar = zzajsVar.zzd;
        j = zzajsVar.zzf;
        return zzakeVar.zzf(j);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j) {
        zzake zzakeVar;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        zzajs zzajsVar = this.zza;
        zzakeVar = zzajsVar.zzd;
        long zzg = zzakeVar.zzg(j);
        j2 = zzajsVar.zzb;
        BigInteger valueOf = BigInteger.valueOf(zzg);
        zzajs zzajsVar2 = this.zza;
        j3 = zzajsVar2.zzc;
        j4 = zzajsVar2.zzb;
        BigInteger multiply = valueOf.multiply(BigInteger.valueOf(j3 - j4));
        j5 = this.zza.zzf;
        long longValue = j2 + multiply.divide(BigInteger.valueOf(j5)).longValue();
        zzajs zzajsVar3 = this.zza;
        j6 = zzajsVar3.zzb;
        j7 = zzajsVar3.zzc;
        zzadv zzadvVar = new zzadv(j, Math.max(j6, Math.min(longValue - 30000, j7 - 1)));
        return new zzads(zzadvVar, zzadvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return true;
    }
}
