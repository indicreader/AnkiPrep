package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcok implements zzdxp {
    private final Context zza;
    private final zzboe zzb;
    private final zzcnc zzc;
    private final zzcok zzd = this;
    private final zzhhm zze;
    private final zzhhm zzf;
    private final zzhhm zzg;
    private final zzhhm zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcok(zzcnc zzcncVar, Context context, zzboe zzboeVar, zzcoj zzcojVar) {
        this.zzc = zzcncVar;
        this.zza = context;
        this.zzb = zzboeVar;
        zzhhd zza = zzhhe.zza(this);
        this.zze = zza;
        zzhhd zza2 = zzhhe.zza(zzboeVar);
        this.zzf = zza2;
        zzdxl zzdxlVar = new zzdxl(zza2);
        this.zzg = zzdxlVar;
        this.zzh = zzhhc.zzc(new zzdxn(zza, zzdxlVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final zzdxg zzb() {
        return new zzcoe(this.zzc, this.zzd, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final zzdxm zzd() {
        return (zzdxm) this.zzh.zzb();
    }
}
