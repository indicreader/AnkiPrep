package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfrc {
    private final Context zza;
    private final Looper zzb;

    public zzfrc(Context context, Looper looper) {
        this.zza = context;
        this.zzb = looper;
    }

    public final void zza(String str) {
        zzfrq zza = zzfrs.zza();
        zza.zza(this.zza.getPackageName());
        zza.zzc(2);
        zzfrn zza2 = zzfro.zza();
        zza2.zza(str);
        zza2.zzb(2);
        zza.zzb(zza2);
        new zzfrd(this.zza, this.zzb, (zzfrs) zza.zzal()).zza();
    }
}
