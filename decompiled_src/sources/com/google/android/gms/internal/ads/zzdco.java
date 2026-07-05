package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdco implements zzhhd {
    private final zzhhu zza;

    public zzdco(zzhhu zzhhuVar) {
        this.zza = zzhhuVar;
    }

    public static zzdcn zzc(Set set) {
        return new zzdcn(set);
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdcn zzb() {
        return new zzdcn(((zzhhr) this.zza).zzb());
    }
}
