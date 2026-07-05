package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeou {
    private final zzdko zza;

    public zzeou(zzdko zzdkoVar) {
        this.zza = zzdkoVar;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfgy zzfgyVar, zzfgm zzfgmVar, View view, zzeoq zzeoqVar) {
        zzeos zzeosVar = new zzeos(this, new zzdkw() { // from class: com.google.android.gms.internal.ads.zzeor
            @Override // com.google.android.gms.internal.ads.zzdkw
            public final void zza(boolean z, Context context, zzdbk zzdbkVar) {
            }
        });
        zzdjo zze = this.zza.zze(new zzcwx(zzfgyVar, zzfgmVar, null), zzeosVar);
        zzeoqVar.zzd(new zzeot(this, zze));
        return zze.zzg();
    }
}
