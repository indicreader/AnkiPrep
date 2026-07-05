package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzazl implements Runnable {
    final /* synthetic */ View zza;
    final /* synthetic */ zzazp zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzazl(zzazp zzazpVar, View view) {
        this.zza = view;
        this.zzb = zzazpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc(this.zza);
    }
}
