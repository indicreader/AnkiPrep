package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzaqe;
import com.google.android.gms.internal.ads.zzaqj;
import com.google.android.gms.internal.ads.zzcec;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbj implements zzaqe {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbn zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbj(zzbq zzbqVar, String str, zzbn zzbnVar) {
        this.zza = str;
        this.zzb = zzbnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaqe
    public final void zza(zzaqj zzaqjVar) {
        zzcec.zzj("Failed to load URL: " + this.zza + "\n" + zzaqjVar.toString());
        this.zzb.zza((Object) null);
    }
}
