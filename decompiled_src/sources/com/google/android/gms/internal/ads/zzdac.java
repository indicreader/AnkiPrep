package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdac implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;
    private final zzhhu zzc;
    private final zzhhu zzd;
    private final zzhhu zze;
    private final zzhhu zzf;
    private final zzhhu zzg;
    private final zzhhu zzh;
    private final zzhhu zzi;
    private final zzhhu zzj;
    private final zzhhu zzk;
    private final zzhhu zzl;

    public zzdac(zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3, zzhhu zzhhuVar4, zzhhu zzhhuVar5, zzhhu zzhhuVar6, zzhhu zzhhuVar7, zzhhu zzhhuVar8, zzhhu zzhhuVar9, zzhhu zzhhuVar10, zzhhu zzhhuVar11, zzhhu zzhhuVar12) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
        this.zzc = zzhhuVar3;
        this.zzd = zzhhuVar4;
        this.zze = zzhhuVar5;
        this.zzf = zzhhuVar6;
        this.zzg = zzhhuVar7;
        this.zzh = zzhhuVar8;
        this.zzi = zzhhuVar9;
        this.zzj = zzhhuVar10;
        this.zzk = zzhhuVar11;
        this.zzl = zzhhuVar12;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdab zzb() {
        zzflm zzflmVar = (zzflm) this.zza.zzb();
        zzcei zza = ((zzcly) this.zzb).zza();
        ApplicationInfo zzb = ((zzeap) this.zzc).zzb();
        String zzb2 = ((zzeau) this.zzd).zzb();
        zzbfu zzbfuVar = zzbgc.zza;
        return new zzdab(zzflmVar, zza, zzb, zzb2, com.google.android.gms.ads.internal.client.zzba.zza().zza(), (PackageInfo) this.zzf.zzb(), zzhhc.zza(zzhho.zza(this.zzg)), ((zzclk) this.zzh).zzb(), (String) this.zzi.zzb(), ((zzexu) this.zzj).zzb(), ((zzdao) this.zzk).zza(), (zzdgg) this.zzl.zzb());
    }
}
