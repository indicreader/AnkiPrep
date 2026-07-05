package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeql implements zzeqt {
    final /* synthetic */ zzeqm zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeql(zzeqm zzeqmVar) {
        this.zza = zzeqmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzj = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdjn zzdjnVar;
        zzdjn zzdjnVar2 = (zzdjn) obj;
        synchronized (this.zza) {
            this.zza.zzj = zzdjnVar2;
            zzdjnVar = this.zza.zzj;
            zzdjnVar.zzj();
        }
    }
}
