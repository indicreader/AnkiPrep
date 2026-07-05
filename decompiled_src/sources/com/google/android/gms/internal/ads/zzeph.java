package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeph extends com.google.android.gms.ads.internal.client.zzbp {
    final zzfhf zza;
    final zzdnj zzb;
    private final Context zzc;
    private final zzclg zzd;
    private com.google.android.gms.ads.internal.client.zzbh zze;

    public zzeph(zzclg zzclgVar, Context context, String str) {
        zzfhf zzfhfVar = new zzfhf();
        this.zza = zzfhfVar;
        this.zzb = new zzdnj();
        this.zzd = zzclgVar;
        zzfhfVar.zzs(str);
        this.zzc = context;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final com.google.android.gms.ads.internal.client.zzbn zze() {
        zzdnl zzg = this.zzb.zzg();
        this.zza.zzB(zzg.zzi());
        this.zza.zzC(zzg.zzh());
        zzfhf zzfhfVar = this.zza;
        if (zzfhfVar.zzg() == null) {
            zzfhfVar.zzr(com.google.android.gms.ads.internal.client.zzq.zzc());
        }
        return new zzepi(this.zzc, this.zzd, this.zza, zzg, this.zze);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzf(zzbkk zzbkkVar) {
        this.zzb.zza(zzbkkVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzg(zzbkn zzbknVar) {
        this.zzb.zzb(zzbknVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzh(String str, zzbkt zzbktVar, zzbkq zzbkqVar) {
        this.zzb.zzc(str, zzbktVar, zzbkqVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzi(zzbpy zzbpyVar) {
        this.zzb.zzd(zzbpyVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzj(zzbkx zzbkxVar, com.google.android.gms.ads.internal.client.zzq zzqVar) {
        this.zzb.zze(zzbkxVar);
        this.zza.zzr(zzqVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzk(zzbla zzblaVar) {
        this.zzb.zzf(zzblaVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzl(com.google.android.gms.ads.internal.client.zzbh zzbhVar) {
        this.zze = zzbhVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzm(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zza.zzq(adManagerAdViewOptions);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzn(zzbpp zzbppVar) {
        this.zza.zzv(zzbppVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzo(zzbjb zzbjbVar) {
        this.zza.zzA(zzbjbVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzp(PublisherAdViewOptions publisherAdViewOptions) {
        this.zza.zzD(publisherAdViewOptions);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzq(com.google.android.gms.ads.internal.client.zzcf zzcfVar) {
        this.zza.zzQ(zzcfVar);
    }
}
