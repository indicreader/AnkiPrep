package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfld {
    final /* synthetic */ zzfle zza;
    private final Object zzb;
    private final String zzc;
    private final ListenableFuture zzd;
    private final List zze;
    private final ListenableFuture zzf;

    private zzfld(zzfle zzfleVar, Object obj, String str, ListenableFuture listenableFuture, List list, ListenableFuture listenableFuture2) {
        this.zza = zzfleVar;
        this.zzb = obj;
        this.zzc = str;
        this.zzd = listenableFuture;
        this.zze = list;
        this.zzf = listenableFuture2;
    }

    public final zzfkr zza() {
        zzflf zzflfVar;
        Object obj = this.zzb;
        String str = this.zzc;
        if (str == null) {
            str = this.zza.zzf(obj);
        }
        final zzfkr zzfkrVar = new zzfkr(obj, str, this.zzf);
        zzflfVar = this.zza.zzd;
        zzflfVar.zza(zzfkrVar);
        this.zzd.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfla
            @Override // java.lang.Runnable
            public final void run() {
                zzflf zzflfVar2;
                zzflfVar2 = zzfld.this.zza.zzd;
                zzflfVar2.zzc(zzfkrVar);
            }
        }, zzcep.zzf);
        zzgen.zzr(zzfkrVar, new zzflb(this, zzfkrVar), zzcep.zzf);
        return zzfkrVar;
    }

    public final zzfld zzb(Object obj) {
        return this.zza.zzb(obj, zza());
    }

    public final zzfld zzc(Class cls, zzgdu zzgduVar) {
        zzgey zzgeyVar;
        zzgeyVar = this.zza.zzb;
        return new zzfld(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzgen.zzf(this.zzf, cls, zzgduVar, zzgeyVar));
    }

    public final zzfld zzd(final ListenableFuture listenableFuture) {
        return zzg(new zzgdu() { // from class: com.google.android.gms.internal.ads.zzfkz
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return ListenableFuture.this;
            }
        }, zzcep.zzf);
    }

    public final zzfld zze(final zzfkp zzfkpVar) {
        return zzf(new zzgdu() { // from class: com.google.android.gms.internal.ads.zzfky
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzgen.zzh(zzfkp.this.zza(obj));
            }
        });
    }

    public final zzfld zzf(zzgdu zzgduVar) {
        zzgey zzgeyVar;
        zzgeyVar = this.zza.zzb;
        return zzg(zzgduVar, zzgeyVar);
    }

    public final zzfld zzg(zzgdu zzgduVar, Executor executor) {
        return new zzfld(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzgen.zzn(this.zzf, zzgduVar, executor));
    }

    public final zzfld zzh(String str) {
        return new zzfld(this.zza, this.zzb, str, this.zzd, this.zze, this.zzf);
    }

    public final zzfld zzi(long j, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService;
        scheduledExecutorService = this.zza.zzc;
        return new zzfld(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzgen.zzo(this.zzf, j, timeUnit, scheduledExecutorService));
    }
}
