package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzawo implements Runnable {
    final /* synthetic */ zzawq zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawo(zzawq zzawqVar) {
        this.zza = zzawqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzf();
    }
}
