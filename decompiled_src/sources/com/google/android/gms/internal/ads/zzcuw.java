package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcuw implements zzhhd {
    private final zzcum zza;
    private final zzhhu zzb;

    public zzcuw(zzcum zzcumVar, zzhhu zzhhuVar) {
        this.zza = zzcumVar;
        this.zzb = zzhhuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set singleton = Collections.singleton(new zzdim((zzcvw) this.zzb.zzb(), zzcep.zzf));
        zzhhl.zzb(singleton);
        return singleton;
    }
}
