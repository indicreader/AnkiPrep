package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzcso implements zzgej {
    final /* synthetic */ zzcsq zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcso(zzcsq zzcsqVar) {
        this.zza = zzcsqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfht zzfhtVar;
        zzfnu zzfnuVar;
        zzfgy zzfgyVar;
        zzfgm zzfgmVar;
        zzfgm zzfgmVar2;
        Context context;
        zzcsq zzcsqVar = this.zza;
        String str = (String) obj;
        zzfhtVar = zzcsqVar.zzh;
        zzfnuVar = zzcsqVar.zzg;
        zzfgyVar = zzcsqVar.zze;
        zzfgmVar = zzcsqVar.zzf;
        zzfgmVar2 = zzcsqVar.zzf;
        List zzd = zzfnuVar.zzd(zzfgyVar, zzfgmVar, false, "", str, zzfgmVar2.zzc);
        zzcsq zzcsqVar2 = this.zza;
        zzcdl zzo = com.google.android.gms.ads.internal.zzt.zzo();
        context = zzcsqVar2.zza;
        zzfhtVar.zzc(zzd, true == zzo.zzz(context) ? 2 : 1);
    }
}
