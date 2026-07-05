package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeuz implements zzexq {
    private final zzgey zza;
    private final zzdzd zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeuz(zzgey zzgeyVar, zzdzd zzdzdVar) {
        this.zza = zzgeyVar;
        this.zzb = zzdzdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 23;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeuy
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeuz.this.zzc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzeva zzc() throws Exception {
        zzdzd zzdzdVar = this.zzb;
        String zzc = zzdzdVar.zzc();
        boolean zzq = zzdzdVar.zzq();
        boolean zzl = com.google.android.gms.ads.internal.zzt.zzs().zzl();
        zzdzd zzdzdVar2 = this.zzb;
        return new zzeva(zzc, zzq, zzl, zzdzdVar2.zzo(), zzdzdVar2.zzr());
    }
}
