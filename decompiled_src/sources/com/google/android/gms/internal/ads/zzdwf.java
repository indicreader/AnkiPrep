package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
@Deprecated
/* loaded from: classes3.dex */
public final class zzdwf {
    private final zzdwk zza;
    private final Executor zzb;
    private final Map zzc;

    public zzdwf(zzdwk zzdwkVar, Executor executor) {
        this.zza = zzdwkVar;
        this.zzc = zzdwkVar.zza();
        this.zzb = executor;
    }

    public final zzdwe zza() {
        zzdwe zzdweVar = new zzdwe(this);
        zzdwe.zza(zzdweVar);
        return zzdweVar;
    }

    public final void zze() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlb)).booleanValue()) {
            zzdwe zza = zza();
            zza.zzb("action", "pecr");
            zza.zzg();
        }
    }
}
