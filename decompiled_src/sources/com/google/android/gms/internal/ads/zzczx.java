package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzczx implements zzdcl, zzdbs {
    private final Context zza;
    private final zzfgm zzb;
    private final zzbwy zzc;

    public zzczx(Context context, zzfgm zzfgmVar, zzbwy zzbwyVar) {
        this.zza = context;
        this.zzb = zzfgmVar;
        this.zzc = zzbwyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final void zzbs(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final void zzbu(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final void zzbv(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzdcl
    public final void zzr() {
        zzbwz zzbwzVar = this.zzb.zzae;
        if (zzbwzVar == null || !zzbwzVar.zza) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.zzb.zzae.zzb.isEmpty()) {
            return;
        }
        arrayList.add(this.zzb.zzae.zzb);
    }
}
