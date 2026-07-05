package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzawp extends BroadcastReceiver {
    final /* synthetic */ zzawq zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawp(zzawq zzawqVar) {
        this.zza = zzawqVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.zza.zzf();
    }
}
