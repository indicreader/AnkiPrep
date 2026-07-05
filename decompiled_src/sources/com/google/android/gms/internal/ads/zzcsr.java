package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcsr implements zzhhd {
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
    private final zzhhu zzm;
    private final zzhhu zzn;
    private final zzhhu zzo;

    public zzcsr(zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3, zzhhu zzhhuVar4, zzhhu zzhhuVar5, zzhhu zzhhuVar6, zzhhu zzhhuVar7, zzhhu zzhhuVar8, zzhhu zzhhuVar9, zzhhu zzhhuVar10, zzhhu zzhhuVar11, zzhhu zzhhuVar12, zzhhu zzhhuVar13, zzhhu zzhhuVar14, zzhhu zzhhuVar15) {
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
        this.zzm = zzhhuVar13;
        this.zzn = zzhhuVar14;
        this.zzo = zzhhuVar15;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* synthetic */ Object zzb() {
        Context zza = ((zzclm) this.zza).zza();
        zzgey zzgeyVar = zzcep.zza;
        zzhhl.zzb(zzgeyVar);
        return new zzcsq(zza, zzgeyVar, (Executor) this.zzc.zzb(), (ScheduledExecutorService) this.zzd.zzb(), ((zzcxb) this.zze).zza(), ((zzcwy) this.zzf).zza(), (zzfnu) this.zzg.zzb(), (zzfht) this.zzh.zzb(), (View) this.zzi.zzb(), (zzcjk) this.zzj.zzb(), (zzavi) this.zzk.zzb(), (zzbhj) this.zzl.zzb(), new zzbhl(), (zzfmz) this.zzn.zzb(), ((zzdal) this.zzo).zza());
    }
}
