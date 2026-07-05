package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzcnm implements zzfbn {
    private final zzcnc zza;
    private final zzcnm zzb = this;
    private final zzhhm zzc;
    private final zzhhm zzd;
    private final zzhhm zze;
    private final zzhhm zzf;
    private final zzhhm zzg;
    private final zzhhm zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcnm(zzcnc zzcncVar, Context context, String str, zzcnl zzcnlVar) {
        zzhhm zzhhmVar;
        zzhhm zzhhmVar2;
        zzhhm zzhhmVar3;
        zzhhm zzhhmVar4;
        zzhhm zzhhmVar5;
        zzhhm zzhhmVar6;
        zzhhm zzhhmVar7;
        zzhhm zzhhmVar8;
        zzhhm zzhhmVar9;
        this.zza = zzcncVar;
        zzhhd zza = zzhhe.zza(context);
        this.zzc = zza;
        zzhhd zza2 = zzhhe.zza(str);
        this.zzd = zza2;
        zzhhmVar = zzcncVar.zzaI;
        zzhhmVar2 = zzcncVar.zzaJ;
        zzfef zzfefVar = new zzfef(zza, zzhhmVar, zzhhmVar2);
        this.zze = zzfefVar;
        zzhhmVar3 = zzcncVar.zzaI;
        zzhhm zzc = zzhhc.zzc(new zzfcl(zzhhmVar3));
        this.zzf = zzc;
        zzhhmVar4 = zzcncVar.zzo;
        zzhhmVar5 = zzcncVar.zzU;
        zzfhj zza3 = zzfhj.zza();
        zzhhmVar6 = zzcncVar.zzh;
        zzhhm zzc2 = zzhhc.zzc(new zzfcn(zza, zzhhmVar4, zzhhmVar5, zzfefVar, zzc, zza3, zzhhmVar6));
        this.zzg = zzc2;
        zzhhmVar7 = zzcncVar.zzU;
        zzhhmVar8 = zzcncVar.zzh;
        zzhhmVar9 = zzcncVar.zzZ;
        this.zzh = zzhhc.zzc(new zzfct(zzhhmVar7, zza, zza2, zzc2, zzc, zzhhmVar8, zzhhmVar9));
    }

    @Override // com.google.android.gms.internal.ads.zzfbn
    public final zzfcs zza() {
        return (zzfcs) this.zzh.zzb();
    }
}
