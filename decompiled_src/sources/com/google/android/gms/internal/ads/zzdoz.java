package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdoz implements zzdbr {
    private final zzdna zza;
    private final zzdnf zzb;
    private final Executor zzc;
    private final Executor zzd;

    public zzdoz(zzdna zzdnaVar, zzdnf zzdnfVar, Executor executor, Executor executor2) {
        this.zza = zzdnaVar;
        this.zzb = zzdnfVar;
        this.zzc = executor;
        this.zzd = executor2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(final zzcjk zzcjkVar) {
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdox
            @Override // java.lang.Runnable
            public final void run() {
                zzcjk.this.zzd("onSdkImpression", new ArrayMap());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdbr
    public final void zzq() {
        if (this.zzb.zzd()) {
            zzdna zzdnaVar = this.zza;
            zzfod zzu = zzdnaVar.zzu();
            if (zzu == null && zzdnaVar.zzw() != null && ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfa)).booleanValue()) {
                zzdna zzdnaVar2 = this.zza;
                ListenableFuture zzw = zzdnaVar2.zzw();
                zzceu zzp = zzdnaVar2.zzp();
                if (zzw == null || zzp == null) {
                    return;
                }
                zzgen.zzr(zzgen.zzl(zzw, zzp), new zzdoy(this), this.zzd);
                return;
            }
            if (zzu != null) {
                zzdna zzdnaVar3 = this.zza;
                zzcjk zzr = zzdnaVar3.zzr();
                zzcjk zzs = zzdnaVar3.zzs();
                if (zzr == null) {
                    zzr = zzs != null ? zzs : null;
                }
                if (zzr != null) {
                    zzb(zzr);
                }
            }
        }
    }
}
