package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import com.google.android.gms.internal.ads.zzavi;
import com.google.android.gms.internal.ads.zzbhi;
import com.google.android.gms.internal.ads.zzcep;
import com.google.android.gms.internal.ads.zzclg;
import com.google.android.gms.internal.ads.zzclm;
import com.google.android.gms.internal.ads.zzcly;
import com.google.android.gms.internal.ads.zzdwk;
import com.google.android.gms.internal.ads.zzfhl;
import com.google.android.gms.internal.ads.zzfig;
import com.google.android.gms.internal.ads.zzfny;
import com.google.android.gms.internal.ads.zzgey;
import com.google.android.gms.internal.ads.zzhhd;
import com.google.android.gms.internal.ads.zzhhl;
import com.google.android.gms.internal.ads.zzhhu;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzab implements zzhhd {
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

    public zzab(zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3, zzhhu zzhhuVar4, zzhhu zzhhuVar5, zzhhu zzhhuVar6, zzhhu zzhhuVar7, zzhhu zzhhuVar8, zzhhu zzhhuVar9, zzhhu zzhhuVar10, zzhhu zzhhuVar11) {
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
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzclg zzclgVar = (zzclg) this.zza.zzb();
        Context zza = ((zzclm) this.zzb).zza();
        zzavi zzaviVar = (zzavi) this.zzc.zzb();
        zzfig zzfigVar = (zzfig) this.zzd.zzb();
        zzgey zzgeyVar = zzcep.zza;
        zzhhl.zzb(zzgeyVar);
        return new zzaa(zzclgVar, zza, zzaviVar, zzfigVar, zzgeyVar, (ScheduledExecutorService) this.zzf.zzb(), (zzdwk) this.zzg.zzb(), (zzfny) this.zzh.zzb(), ((zzcly) this.zzi).zza(), ((zzbhi) this.zzj).zzb(), (zzfhl) this.zzk.zzb());
    }
}
