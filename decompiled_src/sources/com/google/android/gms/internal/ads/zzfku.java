package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfku {
    final /* synthetic */ zzfle zza;
    private final Object zzb;
    private final List zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfku(zzfle zzfleVar, Object obj, List list, zzfkt zzfktVar) {
        this.zza = zzfleVar;
        this.zzb = obj;
        this.zzc = list;
    }

    public final zzfld zza(Callable callable) {
        zzgey zzgeyVar;
        zzgem zzb = zzgen.zzb(this.zzc);
        ListenableFuture zza = zzb.zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzfks
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return null;
            }
        }, zzcep.zzf);
        zzgeyVar = this.zza.zzb;
        ListenableFuture zza2 = zzb.zza(callable, zzgeyVar);
        return new zzfld(this.zza, this.zzb, zza, this.zzc, zza2);
    }
}
