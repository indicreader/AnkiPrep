package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzchn implements Runnable {
    final /* synthetic */ zzcho zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzchn(zzcho zzchoVar) {
        this.zza = zzchoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzt.zzy().zzc(this.zza);
    }
}
