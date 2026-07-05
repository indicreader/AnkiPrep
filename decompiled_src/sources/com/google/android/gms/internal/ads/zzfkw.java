package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfkw {
    public static final zzfld zza(Callable callable, Object obj, zzfle zzfleVar) {
        zzgey zzgeyVar;
        zzgeyVar = zzfleVar.zzb;
        return zzb(callable, zzgeyVar, obj, zzfleVar);
    }

    public static final zzfld zzb(Callable callable, zzgey zzgeyVar, Object obj, zzfle zzfleVar) {
        ListenableFuture listenableFuture;
        listenableFuture = zzfle.zza;
        return new zzfld(zzfleVar, obj, listenableFuture, Collections.emptyList(), zzgeyVar.zzb(callable));
    }

    public static final zzfld zzc(ListenableFuture listenableFuture, Object obj, zzfle zzfleVar) {
        ListenableFuture listenableFuture2;
        listenableFuture2 = zzfle.zza;
        return new zzfld(zzfleVar, obj, listenableFuture2, Collections.emptyList(), listenableFuture);
    }

    public static final zzfld zzd(final zzfkq zzfkqVar, zzgey zzgeyVar, Object obj, zzfle zzfleVar) {
        return zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzfkv
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzfkq.this.zza();
                return null;
            }
        }, zzgeyVar, obj, zzfleVar);
    }
}
