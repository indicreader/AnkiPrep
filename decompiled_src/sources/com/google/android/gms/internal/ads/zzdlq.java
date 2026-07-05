package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdlq implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;
    private final zzhhu zzc;
    private final zzhhu zzd;
    private final zzhhu zze;
    private final zzhhu zzf;

    public zzdlq(zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3, zzhhu zzhhuVar4, zzhhu zzhhuVar5, zzhhu zzhhuVar6) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
        this.zzc = zzhhuVar3;
        this.zzd = zzhhuVar4;
        this.zze = zzhhuVar5;
        this.zzf = zzhhuVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzclg zzclgVar = (zzclg) this.zza.zzb();
        zzdaf zza = ((zzdap) this.zzb).zza();
        zzdgo zza2 = ((zzdhi) this.zzc).zza();
        zzdlf zza3 = ((zzdlh) this.zzd).zza();
        zzddm zzb = ((zzcue) this.zze).zzb();
        zzemh zzemhVar = (zzemh) this.zzf.zzb();
        zzcvb zze = zzclgVar.zze();
        zze.zzi(zza.zzj());
        zze.zzf(zza2);
        zze.zzd(zza3);
        zze.zze(new zzeon(null));
        zze.zzg(new zzcvz(zzb, null));
        zze.zzc(new zzcuc(null));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdv)).booleanValue()) {
            zze.zzj(zzemq.zzb(zzemhVar));
        }
        zzcwk zzc = zze.zzh().zzc();
        zzhhl.zzb(zzc);
        return zzc;
    }
}
