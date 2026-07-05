package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeqo implements zzeqt {
    final /* synthetic */ zzeqp zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeqo(zzeqp zzeqpVar) {
        this.zza = zzeqpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final void zza() {
        synchronized (this.zza) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        synchronized (this.zza) {
            this.zza.zzc = ((zzcwh) obj).zzl();
            ((zzcwh) obj).zzj();
        }
    }
}
