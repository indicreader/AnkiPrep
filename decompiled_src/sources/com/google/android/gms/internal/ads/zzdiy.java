package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdiy {
    private final List zza;
    private final zzfny zzb;
    private boolean zzc;

    public zzdiy(zzfgm zzfgmVar, zzfny zzfnyVar) {
        this.zza = zzfgmVar.zzq;
        this.zzb = zzfnyVar;
    }

    public final void zza() {
        if (this.zzc) {
            return;
        }
        this.zzb.zzd(this.zza);
        this.zzc = true;
    }
}
