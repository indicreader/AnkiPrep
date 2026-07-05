package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzcnw implements zzfdb {
    private final Context zza;
    private final com.google.android.gms.ads.internal.client.zzq zzb;
    private final String zzc;
    private final zzcnc zzd;
    private final zzcnw zze = this;
    private final zzhhm zzf;
    private final zzhhm zzg;
    private final zzhhm zzh;
    private final zzhhm zzi;
    private final zzhhm zzj;
    private final zzhhm zzk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcnw(zzcnc zzcncVar, Context context, String str, com.google.android.gms.ads.internal.client.zzq zzqVar, zzcnv zzcnvVar) {
        zzhhm zzhhmVar;
        zzhhm zzhhmVar2;
        zzhhm zzhhmVar3;
        this.zzd = zzcncVar;
        this.zza = context;
        this.zzb = zzqVar;
        this.zzc = str;
        zzhhd zza = zzhhe.zza(context);
        this.zzf = zza;
        zzhhd zza2 = zzhhe.zza(zzqVar);
        this.zzg = zza2;
        zzhhmVar = zzcncVar.zzn;
        zzhhm zzc = zzhhc.zzc(new zzeqf(zzhhmVar));
        this.zzh = zzc;
        zzhhm zzc2 = zzhhc.zzc(zzeqk.zza());
        this.zzi = zzc2;
        zzhhm zzc3 = zzhhc.zzc(zzdfv.zza());
        this.zzj = zzc3;
        zzhhmVar2 = zzcncVar.zzo;
        zzhhmVar3 = zzcncVar.zzU;
        this.zzk = zzhhc.zzc(new zzfcz(zza, zzhhmVar2, zza2, zzhhmVar3, zzc, zzc2, zzfhj.zza(), zzc3));
    }

    @Override // com.google.android.gms.internal.ads.zzfdb
    public final zzepk zza() {
        zzclj zzcljVar;
        zzhhm zzhhmVar;
        zzfcy zzfcyVar = (zzfcy) this.zzk.zzb();
        zzeqe zzeqeVar = (zzeqe) this.zzh.zzb();
        zzcljVar = this.zzd.zza;
        zzcei zzd = zzcljVar.zzd();
        zzhhl.zzb(zzd);
        zzhhmVar = this.zzd.zzZ;
        return new zzepk(this.zza, this.zzb, this.zzc, zzfcyVar, zzeqeVar, zzd, (zzdwf) zzhhmVar.zzb());
    }
}
