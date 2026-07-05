package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.mediation.MediationInterstitialListener;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzbvi implements com.google.android.gms.ads.internal.overlay.zzp {
    final /* synthetic */ zzbvk zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbvi(zzbvk zzbvkVar) {
        this.zza = zzbvkVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbA() {
        MediationInterstitialListener mediationInterstitialListener;
        zzcec.zze("Opening AdMobCustomTabsAdapter overlay.");
        zzbvk zzbvkVar = this.zza;
        mediationInterstitialListener = zzbvkVar.zzb;
        mediationInterstitialListener.onAdOpened(zzbvkVar);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbC() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbD(int i) {
        MediationInterstitialListener mediationInterstitialListener;
        zzcec.zze("AdMobCustomTabsAdapter overlay is closed.");
        zzbvk zzbvkVar = this.zza;
        mediationInterstitialListener = zzbvkVar.zzb;
        mediationInterstitialListener.onAdClosed(zzbvkVar);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbP() {
        zzcec.zze("AdMobCustomTabsAdapter overlay is resumed.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbt() {
        zzcec.zze("AdMobCustomTabsAdapter overlay is paused.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbz() {
        zzcec.zze("Delay close AdMobCustomTabsAdapter overlay.");
    }
}
