package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzesk implements zzexq {
    private final zzgey zza;
    private final zzfhh zzb;
    private final zzcei zzc;
    private final zzcdp zzd;

    public zzesk(zzgey zzgeyVar, zzfhh zzfhhVar, zzcei zzceiVar, zzcdp zzcdpVar) {
        this.zza = zzgeyVar;
        this.zzb = zzfhhVar;
        this.zzc = zzceiVar;
        this.zzd = zzcdpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 9;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzesj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzesk.this.zzc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzesl zzc() throws Exception {
        return new zzesl(this.zzb.zzj, this.zzc, this.zzd.zzm());
    }
}
