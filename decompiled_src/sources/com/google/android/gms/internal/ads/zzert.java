package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzert implements zzexq {
    private final ListenableFuture zza;
    private final Executor zzb;

    public zzert(ListenableFuture listenableFuture, Executor executor) {
        this.zza = listenableFuture;
        this.zzb = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 6;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        return zzgen.zzn(this.zza, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzers
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                final String str = (String) obj;
                return zzgen.zzh(new zzexp() { // from class: com.google.android.gms.internal.ads.zzerr
                    @Override // com.google.android.gms.internal.ads.zzexp
                    public final void zzj(Object obj2) {
                        ((Bundle) obj2).putString("ms", str);
                    }
                });
            }
        }, this.zzb);
    }
}
