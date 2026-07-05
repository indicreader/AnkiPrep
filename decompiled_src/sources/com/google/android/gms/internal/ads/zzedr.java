package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzedr implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;

    public zzedr(zzhhu zzhhuVar, zzhhu zzhhuVar2) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzedq zzb() {
        return new zzedq(((zzclm) this.zza).zza(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
