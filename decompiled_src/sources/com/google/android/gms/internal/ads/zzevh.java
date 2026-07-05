package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzevh implements zzexp {
    public final zzfgl zza;

    public zzevh(zzfgl zzfglVar) {
        this.zza = zzfglVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexp
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.zza != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzln)).booleanValue()) {
                return;
            }
            bundle.putBoolean("render_in_browser", this.zza.zzd());
            bundle.putBoolean("disable_ml", this.zza.zzc());
        }
    }
}
