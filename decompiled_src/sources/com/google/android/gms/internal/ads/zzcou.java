package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzcou implements zzfes {
    private final zzcnc zza;
    private final zzcou zzb = this;
    private final zzhhm zzc;
    private final zzhhm zzd;
    private final zzhhm zze;
    private final zzhhm zzf;
    private final zzhhm zzg;
    private final zzhhm zzh;
    private final zzhhm zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcou(zzcnc zzcncVar, Context context, String str, com.google.android.gms.ads.internal.client.zzq zzqVar, zzcot zzcotVar) {
        zzhhm zzhhmVar;
        zzhhm zzhhmVar2;
        zzhhm zzhhmVar3;
        zzhhm zzhhmVar4;
        zzhhm zzhhmVar5;
        zzhhm zzhhmVar6;
        zzhhm zzhhmVar7;
        this.zza = zzcncVar;
        zzhhd zza = zzhhe.zza(context);
        this.zzc = zza;
        zzhhd zza2 = zzhhe.zza(zzqVar);
        this.zzd = zza2;
        zzhhd zza3 = zzhhe.zza(str);
        this.zze = zza3;
        zzhhmVar = zzcncVar.zzn;
        zzhhm zzc = zzhhc.zzc(new zzeqf(zzhhmVar));
        this.zzf = zzc;
        zzhhmVar2 = zzcncVar.zzaI;
        zzhhm zzc2 = zzhhc.zzc(new zzffq(zzhhmVar2));
        this.zzg = zzc2;
        zzhhmVar3 = zzcncVar.zzo;
        zzhhmVar4 = zzcncVar.zzU;
        zzhhm zzc3 = zzhhc.zzc(new zzfeq(zza, zzhhmVar3, zzhhmVar4, zzc, zzc2, zzfhj.zza()));
        this.zzh = zzc3;
        zzhhmVar5 = zzcncVar.zzh;
        zzhhmVar6 = zzcncVar.zzV;
        zzhhmVar7 = zzcncVar.zzZ;
        this.zzi = zzhhc.zzc(new zzeqn(zza, zza2, zza3, zzc3, zzc, zzc2, zzhhmVar5, zzhhmVar6, zzhhmVar7));
    }

    @Override // com.google.android.gms.internal.ads.zzfes
    public final zzeqm zza() {
        return (zzeqm) this.zzi.zzb();
    }
}
