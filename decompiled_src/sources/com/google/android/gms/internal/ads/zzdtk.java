package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdtk {
    private final zzcjx zza;
    private final Context zzb;
    private final zzavi zzc;
    private final zzbhj zzd;
    private final zzcei zze;
    private final com.google.android.gms.ads.internal.zza zzf;
    private final zzbbp zzg;
    private final zzddm zzh;
    private final zzehs zzi;
    private final zzfhl zzj;

    public zzdtk(zzcjx zzcjxVar, Context context, zzavi zzaviVar, zzbhj zzbhjVar, zzcei zzceiVar, com.google.android.gms.ads.internal.zza zzaVar, zzbbp zzbbpVar, zzddm zzddmVar, zzehs zzehsVar, zzfhl zzfhlVar) {
        this.zza = zzcjxVar;
        this.zzb = context;
        this.zzc = zzaviVar;
        this.zzd = zzbhjVar;
        this.zze = zzceiVar;
        this.zzf = zzaVar;
        this.zzg = zzbbpVar;
        this.zzh = zzddmVar;
        this.zzi = zzehsVar;
        this.zzj = zzfhlVar;
    }

    public final zzcjk zza(com.google.android.gms.ads.internal.client.zzq zzqVar, zzfgm zzfgmVar, zzfgp zzfgpVar) throws zzcjw {
        zzcla zzc = zzcla.zzc(zzqVar);
        String str = zzqVar.zza;
        zzdsz zzdszVar = new zzdsz(this);
        zzehs zzehsVar = this.zzi;
        zzfhl zzfhlVar = this.zzj;
        com.google.android.gms.ads.internal.zza zzaVar = this.zzf;
        zzbbp zzbbpVar = this.zzg;
        return zzcjx.zza(this.zzb, zzc, str, false, false, this.zzc, this.zzd, this.zze, null, zzdszVar, zzaVar, zzbbpVar, zzfgmVar, zzfgpVar, zzehsVar, zzfhlVar);
    }
}
