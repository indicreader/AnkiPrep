package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcia extends zzchw {
    public zzcia(zzcgl zzcglVar) {
        super(zzcglVar);
    }

    @Override // com.google.android.gms.internal.ads.zzchw
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzchw
    public final boolean zzt(String str) {
        String zze = zzcdv.zze(str);
        zzcgl zzcglVar = (zzcgl) this.zzc.get();
        if (zzcglVar != null && zze != null) {
            zzcglVar.zzt(zze, this);
        }
        zzcec.zzj("VideoStreamNoopCache is doing nothing.");
        zzg(str, zze, "noop", "Noop cache is a noop.");
        return false;
    }
}
