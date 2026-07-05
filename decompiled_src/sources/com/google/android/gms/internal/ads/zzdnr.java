package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdnr implements zzhhd {
    private final zzdnm zza;
    private final zzhhu zzb;
    private final zzhhu zzc;

    public zzdnr(zzdnm zzdnmVar, zzhhu zzhhuVar, zzhhu zzhhuVar2) {
        this.zza = zzdnmVar;
        this.zzb = zzhhuVar;
        this.zzc = zzhhuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzccd zzb() {
        return new zzccd(((zzclm) this.zzb).zza(), ((zzdao) this.zzc).zza().zzf);
    }
}
