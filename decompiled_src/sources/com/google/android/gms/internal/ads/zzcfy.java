package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzcfy implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzcfz zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcfy(zzcfz zzcfzVar, boolean z) {
        this.zza = z;
        this.zzb = zzcfzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzK("windowVisibilityChanged", "isVisible", String.valueOf(this.zza));
    }
}
