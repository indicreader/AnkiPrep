package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfdh implements zzfjp {
    private final zzfed zza;

    public zzfdh(zzfed zzfedVar) {
        this.zza = zzfedVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfjp
    public final ListenableFuture zza(zzfjq zzfjqVar) {
        zzfdi zzfdiVar = (zzfdi) zzfjqVar;
        return ((zzfde) this.zza).zzb(zzfdiVar.zzb, zzfdiVar.zza, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfjp
    public final void zzb(zzfje zzfjeVar) {
        zzfjeVar.zza = ((zzfde) this.zza).zza();
    }
}
