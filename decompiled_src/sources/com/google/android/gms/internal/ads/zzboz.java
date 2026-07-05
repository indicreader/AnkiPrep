package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzboz implements Runnable {
    final /* synthetic */ zzbpc zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzboz(zzbpc zzbpcVar) {
        this.zza = zzbpcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbpc.zzc(this.zza);
    }
}
