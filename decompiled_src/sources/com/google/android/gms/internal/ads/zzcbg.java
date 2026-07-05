package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcbg extends zzcat {
    private final RewardedInterstitialAdLoadCallback zza;
    private final zzcbh zzb;

    public zzcbg(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzcbh zzcbhVar) {
        this.zza = rewardedInterstitialAdLoadCallback;
        this.zzb = zzcbhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcau
    public final void zze(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcau
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onAdFailedToLoad(zzeVar.zzb());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcau
    public final void zzg() {
        zzcbh zzcbhVar;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback == null || (zzcbhVar = this.zzb) == null) {
            return;
        }
        rewardedInterstitialAdLoadCallback.onAdLoaded(zzcbhVar);
    }
}
