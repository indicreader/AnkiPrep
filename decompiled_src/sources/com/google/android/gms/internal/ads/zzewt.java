package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzewt implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;
    private final zzhhu zzc;
    private final zzhhu zzd;
    private final zzhhu zze;
    private final zzhhu zzf;
    private final zzhhu zzg;
    private final zzhhu zzh;
    private final zzhhu zzi;

    public zzewt(zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3, zzhhu zzhhuVar4, zzhhu zzhhuVar5, zzhhu zzhhuVar6, zzhhu zzhhuVar7, zzhhu zzhhuVar8, zzhhu zzhhuVar9) {
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
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgey zzgeyVar = zzcep.zza;
        zzhhl.zzb(zzgeyVar);
        return new zzewr(zzgeyVar, (ScheduledExecutorService) this.zzb.zzb(), (String) this.zzc.zzb(), (zzepa) this.zzd.zzb(), (Context) this.zze.zzb(), ((zzdao) this.zzf).zza(), (zzeow) this.zzg.zzb(), (zzdua) this.zzh.zzb(), (zzdyk) this.zzi.zzb());
    }
}
