package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdts implements zzdbs {
    private final zzcjk zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdts(zzcjk zzcjkVar) {
        this.zza = zzcjkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final void zzbs(Context context) {
        zzcjk zzcjkVar = this.zza;
        if (zzcjkVar != null) {
            zzcjkVar.destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final void zzbu(Context context) {
        zzcjk zzcjkVar = this.zza;
        if (zzcjkVar != null) {
            zzcjkVar.onPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final void zzbv(Context context) {
        zzcjk zzcjkVar = this.zza;
        if (zzcjkVar != null) {
            zzcjkVar.onResume();
        }
    }
}
