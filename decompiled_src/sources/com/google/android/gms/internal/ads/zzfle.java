package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzfle {
    private static final ListenableFuture zza = zzgen.zzh(null);
    private final zzgey zzb;
    private final ScheduledExecutorService zzc;
    private final zzflf zzd;

    public zzfle(zzgey zzgeyVar, ScheduledExecutorService scheduledExecutorService, zzflf zzflfVar) {
        this.zzb = zzgeyVar;
        this.zzc = scheduledExecutorService;
        this.zzd = zzflfVar;
    }

    public final zzfku zza(Object obj, ListenableFuture... listenableFutureArr) {
        return new zzfku(this, obj, Arrays.asList(listenableFutureArr), null);
    }

    public final zzfld zzb(Object obj, ListenableFuture listenableFuture) {
        return new zzfld(this, obj, listenableFuture, Collections.singletonList(listenableFuture), listenableFuture);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String zzf(Object obj);
}
