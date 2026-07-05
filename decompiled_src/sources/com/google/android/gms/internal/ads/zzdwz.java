package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdwz implements zzhhd {
    private final zzdwt zza;
    private final zzhhu zzb;
    private final zzhhu zzc;

    public zzdwz(zzdwt zzdwtVar, zzhhu zzhhuVar, zzhhu zzhhuVar2) {
        this.zza = zzdwtVar;
        this.zzb = zzhhuVar;
        this.zzc = zzhhuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdxd zzdxdVar = (zzdxd) this.zzb.zzb();
        zzgey zzgeyVar = zzcep.zza;
        zzhhl.zzb(zzgeyVar);
        Set zzf = zzdwt.zzf(zzdxdVar, zzgeyVar);
        zzhhl.zzb(zzf);
        return zzf;
    }
}
