package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgcx extends zzgcz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgcx(ListenableFuture listenableFuture, Class cls, zzgdu zzgduVar) {
        super(listenableFuture, cls, zzgduVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgcz
    final /* bridge */ /* synthetic */ Object zze(Object obj, Throwable th) throws Exception {
        zzgdu zzgduVar = (zzgdu) obj;
        ListenableFuture zza = zzgduVar.zza(th);
        zzfxe.zzd(zza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgduVar);
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgcz
    final /* synthetic */ void zzf(Object obj) {
        zzs((ListenableFuture) obj);
    }
}
