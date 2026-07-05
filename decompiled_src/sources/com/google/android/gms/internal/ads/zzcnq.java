package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzcnq implements zzcvb {
    private final zzcnc zza;
    private zzfeh zzb;
    private zzfdk zzc;
    private zzdgo zzd;
    private zzdah zze;
    private zzeon zzf;
    private zzcvz zzg;
    private zzemq zzh;
    private zzcuc zzi;
    private zzdlf zzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcnq(zzcnc zzcncVar, zzcnp zzcnpVar) {
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

    @Override // com.google.android.gms.internal.ads.zzcvb
    public final /* synthetic */ zzcvb zzc(zzcuc zzcucVar) {
        this.zzi = zzcucVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcvb
    public final /* synthetic */ zzcvb zzd(zzdlf zzdlfVar) {
        this.zzj = zzdlfVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcvb
    public final /* synthetic */ zzcvb zze(zzeon zzeonVar) {
        this.zzf = zzeonVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcvb
    public final /* synthetic */ zzcvb zzf(zzdgo zzdgoVar) {
        this.zzd = zzdgoVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcvb
    public final /* synthetic */ zzcvb zzg(zzcvz zzcvzVar) {
        this.zzg = zzcvzVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcvb
    public final /* synthetic */ zzcvb zzi(zzdah zzdahVar) {
        this.zze = zzdahVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcvb
    public final /* synthetic */ zzcvb zzj(zzemq zzemqVar) {
        this.zzh = zzemqVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdad
    /* renamed from: zzk, reason: merged with bridge method [inline-methods] */
    public final zzcvc zzh() {
        zzhhl.zzc(this.zzd, zzdgo.class);
        zzhhl.zzc(this.zze, zzdah.class);
        zzhhl.zzc(this.zzf, zzeon.class);
        zzhhl.zzc(this.zzg, zzcvz.class);
        if (this.zzh == null) {
            this.zzh = zzems.zza();
        }
        zzhhl.zzc(this.zzi, zzcuc.class);
        zzhhl.zzc(this.zzj, zzdlf.class);
        return new zzcns(this.zza, this.zzi, this.zzj, new zzcxr(), new zzfin(), new zzczn(), new zzdwt(), this.zzd, this.zze, this.zzh, this.zzf, this.zzg, null, this.zzb, this.zzc, null);
    }
}
