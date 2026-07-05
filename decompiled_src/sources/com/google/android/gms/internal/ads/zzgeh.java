package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public class zzgeh extends zzgei {
    private final ListenableFuture zza;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzgeh(ListenableFuture listenableFuture) {
        this.zza = listenableFuture;
    }

    @Override // com.google.android.gms.internal.ads.zzgeg, com.google.android.gms.internal.ads.zzfzr
    protected final /* synthetic */ Object zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgei, com.google.android.gms.internal.ads.zzgeg
    public final /* synthetic */ Future zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgei
    protected final ListenableFuture zzc() {
        return this.zza;
    }
}
