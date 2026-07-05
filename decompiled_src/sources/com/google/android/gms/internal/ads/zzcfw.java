package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzcfw implements Runnable {
    final /* synthetic */ zzcfz zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcfw(zzcfz zzcfzVar) {
        this.zza = zzcfzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzK("surfaceCreated", new String[0]);
    }
}
