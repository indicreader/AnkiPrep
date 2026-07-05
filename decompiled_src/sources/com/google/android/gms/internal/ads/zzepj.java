package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzepj implements zzeqt {
    final /* synthetic */ zzepk zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzepj(zzepk zzepkVar) {
        this.zza = zzepkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzi = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcuf zzcufVar;
        zzcuf zzcufVar2;
        zzcuf zzcufVar3;
        zzcuf zzcufVar4 = (zzcuf) obj;
        synchronized (this.zza) {
            zzepk zzepkVar = this.zza;
            zzcufVar = zzepkVar.zzi;
            if (zzcufVar != null) {
                zzcufVar3 = zzepkVar.zzi;
                zzcufVar3.zzb();
            }
            this.zza.zzi = zzcufVar4;
            zzcufVar2 = this.zza.zzi;
            zzcufVar2.zzj();
        }
    }
}
