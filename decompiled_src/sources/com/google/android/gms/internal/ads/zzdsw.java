package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdsw implements zzhhd {
    private final zzhhu zza;

    public zzdsw(zzhhu zzhhuVar) {
        this.zza = zzhhuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbbz zzbbzVar;
        if (((zzdao) this.zza).zza().zzo.zza == 3) {
            zzbbzVar = zzbbz.REWARDED_INTERSTITIAL;
        } else {
            zzbbzVar = zzbbz.REWARD_BASED_VIDEO_AD;
        }
        zzhhl.zzb(zzbbzVar);
        return zzbbzVar;
    }
}
