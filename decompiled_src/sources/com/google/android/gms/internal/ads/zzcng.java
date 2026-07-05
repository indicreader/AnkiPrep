package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzcng implements zzcts {
    private final zzcnc zza;
    private zzfeh zzb;
    private zzfdk zzc;
    private zzdgo zzd;
    private zzdah zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcng(zzcnc zzcncVar, zzcnf zzcnfVar) {
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

    @Override // com.google.android.gms.internal.ads.zzcts
    public final /* synthetic */ zzcts zzc(zzdgo zzdgoVar) {
        this.zzd = zzdgoVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcts
    public final /* synthetic */ zzcts zzd(zzdah zzdahVar) {
        this.zze = zzdahVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdad
    /* renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final zzctt zzh() {
        zzhhl.zzc(this.zzd, zzdgo.class);
        zzhhl.zzc(this.zze, zzdah.class);
        return new zzcni(this.zza, new zzcxr(), new zzfin(), new zzczn(), new zzdwt(), this.zzd, this.zze, zzems.zza(), null, this.zzb, this.zzc, null);
    }
}
