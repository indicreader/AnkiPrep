package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbrz implements zzcew {
    final /* synthetic */ zzceu zza;
    final /* synthetic */ zzbrd zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbrz(zzbsb zzbsbVar, zzceu zzceuVar, zzbrd zzbrdVar) {
        this.zza = zzceuVar;
        this.zzb = zzbrdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcew
    public final void zza() {
        com.google.android.gms.ads.internal.util.zze.zza("callJs > getEngine: Promise rejected");
        this.zza.zzd(new zzbrm("Unable to obtain a JavascriptEngine."));
        this.zzb.zzb();
    }
}
