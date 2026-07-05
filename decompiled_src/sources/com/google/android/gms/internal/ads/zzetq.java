package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzetq implements zzexq {
    private final AtomicReference zza = new AtomicReference();
    private final Clock zzb;
    private final zzexq zzc;
    private final long zzd;

    public zzetq(zzexq zzexqVar, long j, Clock clock) {
        this.zzb = clock;
        this.zzc = zzexqVar;
        this.zzd = j;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 16;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        zzetp zzetpVar = (zzetp) this.zza.get();
        if (zzetpVar == null || zzetpVar.zza()) {
            zzexq zzexqVar = this.zzc;
            zzetp zzetpVar2 = new zzetp(zzexqVar.zzb(), this.zzd, this.zzb);
            this.zza.set(zzetpVar2);
            zzetpVar = zzetpVar2;
        }
        return zzetpVar.zza;
    }
}
