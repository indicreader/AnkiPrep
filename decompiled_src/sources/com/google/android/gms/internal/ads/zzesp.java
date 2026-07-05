package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzesp implements zzexq {
    private final Executor zza;
    private final zzcdl zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzesp(Executor executor, zzcdl zzcdlVar) {
        this.zza = executor;
        this.zzb = zzcdlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 10;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcB)).booleanValue()) {
            return zzgen.zzh(null);
        }
        zzcdl zzcdlVar = this.zzb;
        return zzgen.zzm(zzcdlVar.zzk(), new zzfws() { // from class: com.google.android.gms.internal.ads.zzeso
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                final ArrayList arrayList = (ArrayList) obj;
                if (arrayList.isEmpty()) {
                    return null;
                }
                return new zzexp() { // from class: com.google.android.gms.internal.ads.zzesn
                    @Override // com.google.android.gms.internal.ads.zzexp
                    public final void zzj(Object obj2) {
                        ((Bundle) obj2).putStringArrayList("android_permissions", arrayList);
                    }
                };
            }
        }, this.zza);
    }
}
