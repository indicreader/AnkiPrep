package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzcmm implements zzdlj {
    private final zzcnc zza;
    private zzfeh zzb;
    private zzfdk zzc;
    private zzdgo zzd;
    private zzdah zze;
    private zzdlf zzf;
    private zzcuc zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcmm(zzcnc zzcncVar, zzcml zzcmlVar) {
        this.zza = zzcncVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdad
    public final /* synthetic */ zzdad zza(zzfdk zzfdkVar) {
        this.zzc = zzfdkVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdad
    public final /* synthetic */ zzdad zzb(zzfeh zzfehVar) {
        this.zzb = zzfehVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdlj
    public final /* synthetic */ zzdlj zzc(zzcuc zzcucVar) {
        this.zzg = zzcucVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdlj
    public final /* synthetic */ zzdlj zzd(zzdlf zzdlfVar) {
        this.zzf = zzdlfVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdlj
    public final /* synthetic */ zzdlj zze(zzdgo zzdgoVar) {
        this.zzd = zzdgoVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdlj
    public final /* synthetic */ zzdlj zzf(zzdah zzdahVar) {
        this.zze = zzdahVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdad
    /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzdlk zzh() {
        zzhhl.zzc(this.zzd, zzdgo.class);
        zzhhl.zzc(this.zze, zzdah.class);
        zzhhl.zzc(this.zzf, zzdlf.class);
        zzhhl.zzc(this.zzg, zzcuc.class);
        return new zzcmo(this.zza, this.zzg, this.zzf, new zzcxr(), new zzfin(), new zzczn(), new zzdwt(), this.zzd, this.zze, zzems.zza(), null, this.zzb, this.zzc, null);
    }
}
