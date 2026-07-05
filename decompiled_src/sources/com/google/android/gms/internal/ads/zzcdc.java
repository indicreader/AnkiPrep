package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcdc {
    public final ListenableFuture zza(Context context, int i) {
        zzceu zzceuVar = new zzceu();
        com.google.android.gms.ads.internal.client.zzay.zzb();
        if (zzcdv.zzt(context)) {
            zzcep.zza.execute(new zzcdb(this, context, zzceuVar));
        }
        return zzceuVar;
    }
}
