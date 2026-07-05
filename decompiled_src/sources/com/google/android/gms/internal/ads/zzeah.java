package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeah {
    private final zzgey zza;
    private final zzgey zzb;
    private final zzebo zzc;
    private final zzhgx zzd;

    public zzeah(zzgey zzgeyVar, zzgey zzgeyVar2, zzebo zzeboVar, zzhgx zzhgxVar) {
        this.zza = zzgeyVar;
        this.zzb = zzgeyVar2;
        this.zzc = zzeboVar;
        this.zzd = zzhgxVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zza(zzbze zzbzeVar, int i, zzecf zzecfVar) throws Exception {
        return ((zzeem) this.zzd.zzb()).zzc(zzbzeVar, i);
    }

    public final ListenableFuture zzb(final zzbze zzbzeVar) {
        ListenableFuture zzf;
        String str = zzbzeVar.zzd;
        com.google.android.gms.ads.internal.zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzB(str)) {
            zzf = zzgen.zzg(new zzecf(1));
        } else {
            zzf = zzgen.zzf(this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeae
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return zzeah.this.zzc(zzbzeVar);
                }
            }), ExecutionException.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeaf
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final ListenableFuture zza(Object obj) {
                    return zzgen.zzg(((ExecutionException) obj).getCause());
                }
            }, this.zzb);
        }
        final int callingUid = Binder.getCallingUid();
        return zzgen.zzf(zzf, zzecf.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeag
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzeah.this.zza(zzbzeVar, callingUid, (zzecf) obj);
            }
        }, this.zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ InputStream zzc(zzbze zzbzeVar) throws Exception {
        zzceu zzceuVar;
        final zzebo zzeboVar = this.zzc;
        synchronized (zzeboVar.zzb) {
            if (zzeboVar.zzc) {
                zzceuVar = zzeboVar.zza;
            } else {
                zzeboVar.zzc = true;
                zzeboVar.zze = zzbzeVar;
                zzeboVar.zzf.checkAvailabilityAndConnect();
                zzeboVar.zza.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzebn
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzebo.this.zza();
                    }
                }, zzcep.zzf);
                zzceuVar = zzeboVar.zza;
            }
        }
        return (InputStream) zzceuVar.get(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfx)).intValue(), TimeUnit.SECONDS);
    }
}
