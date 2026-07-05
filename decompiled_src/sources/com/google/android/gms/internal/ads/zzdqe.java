package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdqe implements zzhhd {
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
    private final zzhhu zzp;
    private final zzhhu zzq;
    private final zzhhu zzr;

    public zzdqe(zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3, zzhhu zzhhuVar4, zzhhu zzhhuVar5, zzhhu zzhhuVar6, zzhhu zzhhuVar7, zzhhu zzhhuVar8, zzhhu zzhhuVar9, zzhhu zzhhuVar10, zzhhu zzhhuVar11, zzhhu zzhhuVar12, zzhhu zzhhuVar13, zzhhu zzhhuVar14, zzhhu zzhhuVar15, zzhhu zzhhuVar16, zzhhu zzhhuVar17, zzhhu zzhhuVar18) {
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
        this.zzp = zzhhuVar16;
        this.zzq = zzhhuVar17;
        this.zzr = zzhhuVar18;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdqd zzb() {
        Context context = (Context) this.zza.zzb();
        zzdpm zzdpmVar = (zzdpm) this.zzb.zzb();
        zzavi zzaviVar = (zzavi) this.zzc.zzb();
        zzcei zza = ((zzcly) this.zzd).zza();
        zzhhu zzhhuVar = this.zzf;
        com.google.android.gms.ads.internal.zza zza2 = com.google.android.gms.ads.internal.zza.zza();
        zzbbp zzbbpVar = (zzbbp) zzhhuVar.zzb();
        zzgey zzgeyVar = zzcep.zza;
        zzhhl.zzb(zzgeyVar);
        return new zzdqd(context, zzdpmVar, zzaviVar, zza, zza2, zzbbpVar, zzgeyVar, ((zzdao) this.zzh).zza(), (zzdqv) this.zzi.zzb(), (zzdtk) this.zzj.zzb(), (ScheduledExecutorService) this.zzk.zzb(), (zzdwf) this.zzl.zzb(), (zzflw) this.zzm.zzb(), (zzfny) this.zzn.zzb(), (zzehh) this.zzo.zzb(), (zzdsf) this.zzp.zzb(), (zzehs) this.zzq.zzb(), (zzfhl) this.zzr.zzb());
    }
}
