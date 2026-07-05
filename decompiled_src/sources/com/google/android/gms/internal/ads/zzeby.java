package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzeby implements zzdds {
    private final Context zza;
    private final zzcch zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeby(Context context, zzcch zzcchVar) {
        this.zza = context;
        this.zzb = zzcchVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdds
    public final void zzbw(zzbze zzbzeVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdds
    public final void zzbx(zzfgy zzfgyVar) {
        if (TextUtils.isEmpty(zzfgyVar.zzb.zzb.zzd)) {
            return;
        }
        this.zzb.zzm(this.zza, zzfgyVar.zza.zza.zzd);
        this.zzb.zzi(this.zza, zzfgyVar.zzb.zzb.zzd);
    }
}
