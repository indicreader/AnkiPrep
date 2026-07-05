package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzbvp implements View.OnClickListener {
    final /* synthetic */ zzbvq zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbvp(zzbvq zzbvqVar) {
        this.zza = zzbvqVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zza.zza(true);
    }
}
