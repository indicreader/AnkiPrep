package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgdi extends zzgdj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgdi(ListenableFuture listenableFuture, zzfws zzfwsVar) {
        super(listenableFuture, zzfwsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    final /* synthetic */ Object zze(Object obj, Object obj2) throws Exception {
        return ((zzfws) obj).apply(obj2);
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    final void zzf(Object obj) {
        zzc(obj);
    }
}
