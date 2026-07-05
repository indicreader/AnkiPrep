package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzcoo implements zzdkn {
    private final zzcnc zza;
    private zzfeh zzb;
    private zzfdk zzc;
    private zzdgo zzd;
    private zzdah zze;
    private zzeon zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcoo(zzcnc zzcncVar, zzcon zzconVar) {
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

    @Override // com.google.android.gms.internal.ads.zzdkn
    public final /* synthetic */ zzdkn zzc(zzeon zzeonVar) {
        this.zzf = zzeonVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdkn
    public final /* synthetic */ zzdkn zzd(zzdgo zzdgoVar) {
        this.zzd = zzdgoVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdkn
    public final /* synthetic */ zzdkn zze(zzdah zzdahVar) {
        this.zze = zzdahVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdad
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzdko zzh() {
        zzhhl.zzc(this.zzd, zzdgo.class);
        zzhhl.zzc(this.zze, zzdah.class);
        zzhhl.zzc(this.zzf, zzeon.class);
        return new zzcoq(this.zza, new zzcxr(), new zzfin(), new zzczn(), new zzdwt(), this.zzd, this.zze, zzems.zza(), this.zzf, null, this.zzb, this.zzc, null);
    }
}
