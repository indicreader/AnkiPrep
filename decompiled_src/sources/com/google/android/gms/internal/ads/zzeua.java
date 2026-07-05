package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeua implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;

    public zzeua(zzhhu zzhhuVar, zzhhu zzhhuVar2) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzetq(((zzexy) this.zza).zzb(), ((Long) zzbhq.zza.zze()).longValue(), (Clock) this.zzb.zzb());
    }
}
