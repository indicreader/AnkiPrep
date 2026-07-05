package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcmh implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;

    public zzcmh(zzhhu zzhhuVar, zzhhu zzhhuVar2) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzbzp zzb() {
        Context zza = ((zzclm) this.zza).zza();
        zzfnc zzfncVar = (zzfnc) this.zzb.zzb();
        com.google.android.gms.ads.internal.zzt.zzf().zzb(zza, zzcei.zza(), zzfncVar).zza("google.afma.request.getAdDictionary", zzbru.zza, zzbru.zza);
        zzbrx zzb = com.google.android.gms.ads.internal.zzt.zzf().zzb(zza, zzcei.zza(), zzfncVar);
        zzbrr zzbrrVar = zzbru.zza;
        return new zzbzo(zza, zzb.zza("google.afma.sdkConstants.getSdkConstants", zzbrrVar, zzbrrVar));
    }
}
