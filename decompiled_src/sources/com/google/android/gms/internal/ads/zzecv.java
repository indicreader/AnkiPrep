package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzecv {
    private final zzgey zza;
    private final zzgey zzb;
    private final zzedq zzc;
    private final zzhgx zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzecv(zzgey zzgeyVar, zzgey zzgeyVar2, zzedq zzedqVar, zzhgx zzhgxVar) {
        this.zza = zzgeyVar;
        this.zzb = zzgeyVar2;
        this.zzc = zzedqVar;
        this.zzd = zzhgxVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zza(zzbym zzbymVar) throws Exception {
        return this.zzc.zza(zzbymVar, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkX)).longValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzb(zzbym zzbymVar, int i, zzecf zzecfVar) throws Exception {
        return ((zzeew) this.zzd.zzb()).zzb(zzbymVar, i);
    }

    public final ListenableFuture zzc(final zzbym zzbymVar) {
        ListenableFuture zzf;
        String str = zzbymVar.zzf;
        com.google.android.gms.ads.internal.zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzB(str)) {
            zzf = zzgen.zzg(new zzecf(1, "Ads service proxy force local"));
        } else {
            zzf = zzgen.zzf(zzgen.zzk(new zzgdt() { // from class: com.google.android.gms.internal.ads.zzecs
                @Override // com.google.android.gms.internal.ads.zzgdt
                public final ListenableFuture zza() {
                    return zzecv.this.zza(zzbymVar);
                }
            }, this.zza), ExecutionException.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzect
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final ListenableFuture zza(Object obj) {
                    ExecutionException executionException = (ExecutionException) obj;
                    Throwable cause = executionException.getCause();
                    Throwable th = executionException;
                    if (cause != null) {
                        th = executionException.getCause();
                    }
                    return zzgen.zzg(th);
                }
            }, this.zzb);
        }
        final int callingUid = Binder.getCallingUid();
        return zzgen.zzf(zzf, zzecf.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzecu
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzecv.this.zzb(zzbymVar, callingUid, (zzecf) obj);
            }
        }, this.zzb);
    }
}
