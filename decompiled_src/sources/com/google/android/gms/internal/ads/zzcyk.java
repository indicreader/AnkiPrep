package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcyk implements com.google.android.gms.ads.internal.client.zza {
    private final zzcyo zza;
    private final zzfhh zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcyk(zzcyo zzcyoVar, zzfhh zzfhhVar) {
        this.zza = zzcyoVar;
        this.zzb = zzfhhVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        this.zza.zzc(this.zzb.zzf);
    }
}
