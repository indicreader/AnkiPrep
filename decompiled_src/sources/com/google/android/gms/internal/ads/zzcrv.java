package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcrv implements zzdbs {
    private final zzfif zza;

    public zzcrv(zzfif zzfifVar) {
        this.zza = zzfifVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final void zzbs(Context context) {
        try {
            this.zza.zzg();
        } catch (zzfho e) {
            zzcec.zzk("Cannot invoke onDestroy for the mediation adapter.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final void zzbu(Context context) {
        try {
            this.zza.zzt();
        } catch (zzfho e) {
            zzcec.zzk("Cannot invoke onPause for the mediation adapter.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final void zzbv(Context context) {
        try {
            this.zza.zzu();
            if (context != null) {
                this.zza.zzs(context);
            }
        } catch (zzfho e) {
            zzcec.zzk("Cannot invoke onResume for the mediation adapter.", e);
        }
    }
}
