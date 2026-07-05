package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzfqr;
import com.google.android.gms.internal.ads.zzfru;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzh implements zzfru {
    final /* synthetic */ zzi zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzh(zzi zziVar) {
        this.zza = zziVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfru
    public final void zza(int i, long j) {
        zzfqr zzfqrVar;
        zzfqrVar = this.zza.zzi;
        zzfqrVar.zzd(i, System.currentTimeMillis() - j);
    }

    @Override // com.google.android.gms.internal.ads.zzfru
    public final void zzb(int i, long j, String str) {
        zzfqr zzfqrVar;
        zzfqrVar = this.zza.zzi;
        zzfqrVar.zze(i, System.currentTimeMillis() - j, str);
    }
}
