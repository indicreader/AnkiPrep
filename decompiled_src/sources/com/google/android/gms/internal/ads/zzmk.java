package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
@Deprecated
/* loaded from: classes3.dex */
public final class zzmk {
    private final zzji zza;

    @Deprecated
    public zzmk(Context context, zzciu zzciuVar) {
        this.zza = new zzji(context, zzciuVar);
    }

    @Deprecated
    public final zzmk zza(final zzlc zzlcVar) {
        zzji zzjiVar = this.zza;
        zzek.zzf(!zzjiVar.zzq);
        zzlcVar.getClass();
        zzjiVar.zzf = new zzfxu() { // from class: com.google.android.gms.internal.ads.zzja
            @Override // com.google.android.gms.internal.ads.zzfxu
            public final Object zza() {
                return zzlc.this;
            }
        };
        return this;
    }

    @Deprecated
    public final zzmk zzb(final zzyo zzyoVar) {
        zzji zzjiVar = this.zza;
        zzek.zzf(!zzjiVar.zzq);
        zzyoVar.getClass();
        zzjiVar.zze = new zzfxu() { // from class: com.google.android.gms.internal.ads.zzjh
            @Override // com.google.android.gms.internal.ads.zzfxu
            public final Object zza() {
                return zzyo.this;
            }
        };
        return this;
    }

    @Deprecated
    public final zzml zzc() {
        zzji zzjiVar = this.zza;
        zzek.zzf(!zzjiVar.zzq);
        zzjiVar.zzq = true;
        return new zzml(zzjiVar);
    }
}
