package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzbvs implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbvt zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbvs(zzbvt zzbvtVar) {
        this.zza = zzbvtVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzh("User canceled the download.");
    }
}
