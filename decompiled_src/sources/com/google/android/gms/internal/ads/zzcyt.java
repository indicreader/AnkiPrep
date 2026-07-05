package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcyt implements zzhhd {
    private final zzcys zza;
    private final zzhhu zzb;
    private final zzhhu zzc;

    public zzcyt(zzcys zzcysVar, zzhhu zzhhuVar, zzhhu zzhhuVar2) {
        this.zza = zzcysVar;
        this.zzb = zzhhuVar;
        this.zzc = zzhhuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new com.google.android.gms.ads.internal.zzb((Context) this.zzb.zzb(), (zzcbs) this.zzc.zzb(), null);
    }
}
