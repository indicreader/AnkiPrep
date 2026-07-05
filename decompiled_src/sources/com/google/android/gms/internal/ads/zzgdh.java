package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgdh extends zzgdj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgdh(ListenableFuture listenableFuture, zzgdu zzgduVar) {
        super(listenableFuture, zzgduVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) throws Exception {
        zzgdu zzgduVar = (zzgdu) obj;
        ListenableFuture zza = zzgduVar.zza(obj2);
        zzfxe.zzd(zza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgduVar);
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    final /* synthetic */ void zzf(Object obj) {
        zzs((ListenableFuture) obj);
    }
}
