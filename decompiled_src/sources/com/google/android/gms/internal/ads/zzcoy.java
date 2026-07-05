package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzcoy implements zzfgg {
    private final zzcnc zza;
    private final zzcoy zzb = this;
    private final zzhhm zzc;
    private final zzhhm zzd;
    private final zzhhm zze;
    private final zzhhm zzf;
    private final zzhhm zzg;
    private final zzhhm zzh;
    private final zzhhm zzi;
    private final zzhhm zzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcoy(zzcnc zzcncVar, Context context, String str, zzcox zzcoxVar) {
        zzhhm zzhhmVar;
        zzhhm zzhhmVar2;
        zzhhm zzhhmVar3;
        zzhhm zzhhmVar4;
        zzhhm zzhhmVar5;
        zzhhm zzhhmVar6;
        zzhhm zzhhmVar7;
        zzhhm zzhhmVar8;
        this.zza = zzcncVar;
        zzhhd zza = zzhhe.zza(context);
        this.zzc = zza;
        zzhhmVar = zzcncVar.zzaI;
        zzhhmVar2 = zzcncVar.zzaJ;
        zzfeg zzfegVar = new zzfeg(zza, zzhhmVar, zzhhmVar2);
        this.zzd = zzfegVar;
        zzhhmVar3 = zzcncVar.zzaI;
        zzhhm zzc = zzhhc.zzc(new zzffq(zzhhmVar3));
        this.zze = zzc;
        zzhhm zzc2 = zzhhc.zzc(zzfhe.zza());
        this.zzf = zzc2;
        zzhhmVar4 = zzcncVar.zzo;
        zzhhmVar5 = zzcncVar.zzU;
        zzhhm zzc3 = zzhhc.zzc(new zzfga(zza, zzhhmVar4, zzhhmVar5, zzfegVar, zzc, zzfhj.zza(), zzc2));
        this.zzg = zzc3;
        this.zzh = zzhhc.zzc(new zzfgk(zzc3, zzc, zzc2));
        zzhhd zzc4 = zzhhe.zzc(str);
        this.zzi = zzc4;
        zzhhmVar6 = zzcncVar.zzh;
        zzhhmVar7 = zzcncVar.zzV;
        zzhhmVar8 = zzcncVar.zzZ;
        this.zzj = zzhhc.zzc(new zzfge(zzc4, zzc3, zza, zzc, zzc2, zzhhmVar6, zzhhmVar7, zzhhmVar8));
    }

    @Override // com.google.android.gms.internal.ads.zzfgg
    public final zzfgd zza() {
        return (zzfgd) this.zzj.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzfgg
    public final zzfgj zzb() {
        return (zzfgj) this.zzh.zzb();
    }
}
