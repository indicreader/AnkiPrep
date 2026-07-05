package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzgdy extends zzgdz {
    final /* synthetic */ zzgea zza;
    private final Callable zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgdy(zzgea zzgeaVar, Callable callable, Executor executor) {
        super(zzgeaVar, executor);
        this.zza = zzgeaVar;
        this.zzc = callable;
    }

    @Override // com.google.android.gms.internal.ads.zzgew
    final Object zza() throws Exception {
        return this.zzc.call();
    }

    @Override // com.google.android.gms.internal.ads.zzgew
    final String zzb() {
        return this.zzc.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgdz
    final void zzc(Object obj) {
        this.zza.zzc(obj);
    }
}
