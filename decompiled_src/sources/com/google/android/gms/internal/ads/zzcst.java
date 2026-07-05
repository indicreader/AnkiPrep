package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcst implements zzbng {
    final /* synthetic */ zzcsw zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcst(zzcsw zzcswVar) {
        this.zza = zzcswVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final void zza(Object obj, Map map) {
        Executor executor;
        if (zzcsw.zzg(this.zza, map)) {
            executor = this.zza.zzc;
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcss
                @Override // java.lang.Runnable
                public final void run() {
                    zzctb zzctbVar;
                    zzctbVar = zzcst.this.zza.zzd;
                    zzctbVar.zzg();
                }
            });
        }
    }
}
