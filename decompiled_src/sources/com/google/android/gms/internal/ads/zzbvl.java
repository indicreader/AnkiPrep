package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbvl implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbvn zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbvl(zzbvn zzbvnVar) {
        this.zza = zzbvnVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        zzbvn zzbvnVar = this.zza;
        Intent zzb = zzbvnVar.zzb();
        com.google.android.gms.ads.internal.zzt.zzp();
        context = zzbvnVar.zzb;
        com.google.android.gms.ads.internal.util.zzt.zzS(context, zzb);
    }
}
