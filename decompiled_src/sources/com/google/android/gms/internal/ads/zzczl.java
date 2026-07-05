package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzczl implements zzdds {
    private final Context zza;
    private final zzfhh zzb;
    private final zzcei zzc;
    private final com.google.android.gms.ads.internal.util.zzg zzd;
    private final zzdyi zze;
    private final zzfnc zzf;

    public zzczl(Context context, zzfhh zzfhhVar, zzcei zzceiVar, com.google.android.gms.ads.internal.util.zzg zzgVar, zzdyi zzdyiVar, zzfnc zzfncVar) {
        this.zza = context;
        this.zzb = zzfhhVar;
        this.zzc = zzceiVar;
        this.zzd = zzgVar;
        this.zze = zzdyiVar;
        this.zzf = zzfncVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdds
    public final void zzbw(zzbze zzbzeVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdR)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzg zzgVar = this.zzd;
            Context context = this.zza;
            zzcei zzceiVar = this.zzc;
            zzfhh zzfhhVar = this.zzb;
            zzfnc zzfncVar = this.zzf;
            com.google.android.gms.ads.internal.zzt.zza().zzc(context, zzceiVar, zzfhhVar.zzf, zzgVar.zzh(), zzfncVar);
        }
        this.zze.zzr();
    }

    @Override // com.google.android.gms.internal.ads.zzdds
    public final void zzbx(zzfgy zzfgyVar) {
    }
}
