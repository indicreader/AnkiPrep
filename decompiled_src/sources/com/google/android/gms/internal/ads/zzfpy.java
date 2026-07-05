package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfpy implements Runnable {
    final /* synthetic */ zzfqd zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfpy(zzfqd zzfqdVar) {
        this.zza = zzfqdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfpx zzfpxVar;
        zzfpxVar = this.zza.zzl;
        zzfpxVar.zzb();
    }
}
