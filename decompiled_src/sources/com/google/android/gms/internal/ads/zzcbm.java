package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzcbm implements zzgej {
    final /* synthetic */ ListenableFuture zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcbm(zzcbn zzcbnVar, ListenableFuture listenableFuture) {
        this.zza = listenableFuture;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        List list;
        list = zzcbn.zzc;
        list.remove(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List list;
        list = zzcbn.zzc;
        list.remove(this.zza);
    }
}
