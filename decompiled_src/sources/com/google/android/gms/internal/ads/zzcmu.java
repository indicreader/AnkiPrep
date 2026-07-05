package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzcmu extends zzezd {
    private final zzfak zza;
    private final zzcnc zzb;
    private final zzcmu zzc = this;
    private final zzhhm zzd;
    private final zzhhm zze;
    private final zzhhm zzf;
    private final zzhhm zzg;
    private final zzhhm zzh;
    private final zzhhm zzi;
    private final zzhhm zzj;
    private final zzhhm zzk;
    private final zzhhm zzl;
    private final zzhhm zzm;
    private final zzhhm zzn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcmu(zzcnc zzcncVar, zzfak zzfakVar, zzcmt zzcmtVar) {
        zzhhm zzhhmVar;
        zzhhm zzhhmVar2;
        zzhhm zzhhmVar3;
        this.zzb = zzcncVar;
        this.zza = zzfakVar;
        zzfam zzfamVar = new zzfam(zzfakVar);
        this.zzd = zzfamVar;
        zzhhm zzc = zzhhc.zzc(zzdve.zza());
        this.zze = zzc;
        zzhhm zzc2 = zzhhc.zzc(zzdvc.zza());
        this.zzf = zzc2;
        zzhhm zzc3 = zzhhc.zzc(zzdvg.zza());
        this.zzg = zzc3;
        zzhhm zzc4 = zzhhc.zzc(zzdvi.zza());
        this.zzh = zzc4;
        zzhhg zzc5 = zzhhh.zzc(4);
        zzc5.zzb(zzflg.GMS_SIGNALS, zzc);
        zzc5.zzb(zzflg.BUILD_URL, zzc2);
        zzc5.zzb(zzflg.HTTP, zzc3);
        zzc5.zzb(zzflg.PRE_PROCESS, zzc4);
        zzhhh zzc6 = zzc5.zzc();
        this.zzi = zzc6;
        zzhhmVar = zzcncVar.zzg;
        zzhhm zzc7 = zzhhc.zzc(new zzdvj(zzfamVar, zzhhmVar, zzfkh.zza(), zzc6));
        this.zzj = zzc7;
        zzhhq zza = zzhhr.zza(0, 1);
        zza.zza(zzc7);
        zzhhr zzc8 = zza.zzc();
        this.zzk = zzc8;
        zzflp zzflpVar = new zzflp(zzc8);
        this.zzl = zzflpVar;
        zzfkh zza2 = zzfkh.zza();
        zzhhmVar2 = zzcncVar.zzm;
        this.zzm = zzhhc.zzc(new zzflo(zza2, zzhhmVar2, zzflpVar));
        zzhhmVar3 = zzcncVar.zzG;
        this.zzn = zzhhc.zzc(new zzfna(zzhhmVar3));
    }

    @Override // com.google.android.gms.internal.ads.zzezd
    public final zzext zza() {
        zzclj zzcljVar;
        zzhhm zzhhmVar;
        zzhhm zzhhmVar2;
        zzcljVar = this.zzb.zza;
        Context zza = zzcljVar.zza();
        zzhhl.zzb(zza);
        zzccz zzcczVar = new zzccz();
        zzgey zzgeyVar = zzcep.zza;
        zzhhl.zzb(zzgeyVar);
        zzfae zzfaeVar = new zzfae(zzcczVar, zzgeyVar, zzfal.zza(this.zza));
        zzgey zzgeyVar2 = zzcep.zza;
        zzhhl.zzb(zzgeyVar2);
        zzhhmVar = this.zzb.zzm;
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) zzhhmVar.zzb();
        zzfmz zzfmzVar = (zzfmz) this.zzn.zzb();
        zzhhmVar2 = this.zzb.zzZ;
        zzdwf zzdwfVar = (zzdwf) zzhhmVar2.zzb();
        HashSet hashSet = new HashSet();
        hashSet.add(new zzevy(zzfaeVar, 0L, scheduledExecutorService));
        return new zzext(zza, zzgeyVar2, hashSet, zzfmzVar, zzdwfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzezd
    public final zzflm zzb() {
        return (zzflm) this.zzm.zzb();
    }
}
