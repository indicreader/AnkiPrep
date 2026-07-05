package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdaf {
    private Context zza;
    private zzfhh zzb;
    private Bundle zzc;
    private zzfgz zzd;
    private zzczz zze;
    private zzeis zzf;

    public final zzdaf zzd(zzeis zzeisVar) {
        this.zzf = zzeisVar;
        return this;
    }

    public final zzdaf zze(Context context) {
        this.zza = context;
        return this;
    }

    public final zzdaf zzf(Bundle bundle) {
        this.zzc = bundle;
        return this;
    }

    public final zzdaf zzg(zzczz zzczzVar) {
        this.zze = zzczzVar;
        return this;
    }

    public final zzdaf zzh(zzfgz zzfgzVar) {
        this.zzd = zzfgzVar;
        return this;
    }

    public final zzdaf zzi(zzfhh zzfhhVar) {
        this.zzb = zzfhhVar;
        return this;
    }

    public final zzdah zzj() {
        return new zzdah(this, null);
    }
}
