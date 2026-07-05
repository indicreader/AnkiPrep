package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzemr implements zzhhd {
    private final zzemq zza;
    private final zzhhu zzb;
    private final zzhhu zzc;
    private final zzhhu zzd;
    private final zzhhu zze;

    public zzemr(zzemq zzemqVar, zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3, zzhhu zzhhuVar4) {
        this.zza = zzemqVar;
        this.zzb = zzhhuVar;
        this.zzc = zzhhuVar2;
        this.zzd = zzhhuVar3;
        this.zze = zzhhuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* synthetic */ Object zzb() {
        return this.zza.zza((Clock) this.zzb.zzb(), ((zzemk) this.zzc).zzb(), (zzeis) this.zzd.zzb(), (zzfny) this.zze.zzb());
    }
}
