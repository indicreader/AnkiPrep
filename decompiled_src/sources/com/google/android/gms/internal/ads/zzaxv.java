package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzaxv implements Runnable {
    final /* synthetic */ zzaxw zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaxv(zzaxw zzaxwVar) {
        this.zza = zzaxwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaxw.zzb(this.zza);
    }
}
