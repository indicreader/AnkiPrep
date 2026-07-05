package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdob implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;
    private final zzhhu zzc;
    private final zzhhu zzd;
    private final zzhhu zze;
    private final zzhhu zzf;
    private final zzhhu zzg;
    private final zzhhu zzh;
    private final zzhhu zzi;

    public zzdob(zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3, zzhhu zzhhuVar4, zzhhu zzhhuVar5, zzhhu zzhhuVar6, zzhhu zzhhuVar7, zzhhu zzhhuVar8, zzhhu zzhhuVar9) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
        this.zzc = zzhhuVar3;
        this.zzd = zzhhuVar4;
        this.zze = zzhhuVar5;
        this.zzf = zzhhuVar6;
        this.zzg = zzhhuVar7;
        this.zzh = zzhhuVar8;
        this.zzi = zzhhuVar9;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdoa zzb() {
        com.google.android.gms.ads.internal.util.zzg zzb = ((zzclk) this.zza).zzb();
        zzfhh zza = ((zzdao) this.zzb).zza();
        zzdnf zzdnfVar = (zzdnf) this.zzc.zzb();
        zzdna zza2 = ((zzdnt) this.zzd).zza();
        zzdom zzdomVar = (zzdom) this.zze.zzb();
        zzdou zzdouVar = (zzdou) this.zzf.zzb();
        Executor executor = (Executor) this.zzg.zzb();
        zzgey zzgeyVar = zzcep.zza;
        zzhhl.zzb(zzgeyVar);
        return new zzdoa(zzb, zza, zzdnfVar, zza2, zzdomVar, zzdouVar, executor, zzgeyVar, (zzdmx) this.zzi.zzb());
    }
}
