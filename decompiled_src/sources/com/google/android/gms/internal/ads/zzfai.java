package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfai implements zzexq {
    final zzgey zza;
    final List zzb;
    final zzbfn zzc;

    public zzfai(zzbfn zzbfnVar, zzgey zzgeyVar, List list) {
        this.zzc = zzbfnVar;
        this.zza = zzgeyVar;
        this.zzb = list;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 48;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzfah
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzfaj(zzfai.this.zzb);
            }
        });
    }
}
