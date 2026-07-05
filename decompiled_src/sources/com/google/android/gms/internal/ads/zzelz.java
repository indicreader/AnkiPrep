package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzelz extends zzelw {
    private final zzclg zza;
    private final zzdaf zzb;
    private final zzeon zzc;
    private final zzdgo zzd;
    private final zzdlf zze;
    private final zzddm zzf;
    private final ViewGroup zzg;
    private final zzdft zzh;
    private final zzemh zzi;
    private final zzeis zzj;

    public zzelz(zzclg zzclgVar, zzdaf zzdafVar, zzeon zzeonVar, zzdgo zzdgoVar, zzdlf zzdlfVar, zzddm zzddmVar, ViewGroup viewGroup, zzdft zzdftVar, zzemh zzemhVar, zzeis zzeisVar) {
        this.zza = zzclgVar;
        this.zzb = zzdafVar;
        this.zzc = zzeonVar;
        this.zzd = zzdgoVar;
        this.zze = zzdlfVar;
        this.zzf = zzddmVar;
        this.zzg = viewGroup;
        this.zzh = zzdftVar;
        this.zzi = zzemhVar;
        this.zzj = zzeisVar;
    }

    @Override // com.google.android.gms.internal.ads.zzelw
    protected final ListenableFuture zzc(zzfhh zzfhhVar, Bundle bundle, zzfgm zzfgmVar, zzfgy zzfgyVar) {
        zzdaf zzdafVar = this.zzb;
        zzdafVar.zzi(zzfhhVar);
        zzdafVar.zzf(bundle);
        zzdafVar.zzg(new zzczz(zzfgyVar, zzfgmVar, this.zzi));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzds)).booleanValue()) {
            this.zzb.zzd(this.zzj);
        }
        zzclg zzclgVar = this.zza;
        zzdaf zzdafVar2 = this.zzb;
        zzcvb zze = zzclgVar.zze();
        zze.zzi(zzdafVar2.zzj());
        zze.zzf(this.zzd);
        zze.zze(this.zzc);
        zze.zzd(this.zze);
        zze.zzg(new zzcvz(this.zzf, this.zzh));
        zze.zzc(new zzcuc(this.zzg));
        zzcxp zzd = zze.zzk().zzd();
        return zzd.zzi(zzd.zzj());
    }
}
