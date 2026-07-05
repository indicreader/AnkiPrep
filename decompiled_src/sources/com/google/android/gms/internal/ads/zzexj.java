package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzexj implements zzexq {
    private final boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzexj(zzfeh zzfehVar) {
        this.zza = zzfehVar != null;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 36;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        return zzgen.zzh(this.zza ? new zzexp() { // from class: com.google.android.gms.internal.ads.zzexi
            @Override // com.google.android.gms.internal.ads.zzexp
            public final void zzj(Object obj) {
                ((Bundle) obj).putBoolean("sdk_prefetch", true);
            }
        } : null);
    }
}
