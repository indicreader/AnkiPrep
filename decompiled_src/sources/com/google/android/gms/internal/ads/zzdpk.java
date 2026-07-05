package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdpk implements zzhhd {
    private final zzdpd zza;
    private final zzhhu zzb;
    private final zzhhu zzc;

    public zzdpk(zzdpd zzdpdVar, zzhhu zzhhuVar, zzhhu zzhhuVar2) {
        this.zza = zzdpdVar;
        this.zzb = zzhhuVar;
        this.zzc = zzhhuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdim(((zzdsk) this.zzb).zzb(), (Executor) this.zzc.zzb());
    }
}
