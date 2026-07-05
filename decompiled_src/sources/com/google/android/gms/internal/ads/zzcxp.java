package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcxp {
    private final zzebl zza;
    private final zzfhh zzb;
    private final zzflm zzc;
    private final zzcqt zzd;
    private final zzemo zze;
    private final zzdgc zzf;
    private zzfgy zzg;
    private final zzecq zzh;
    private final zzdab zzi;
    private final Executor zzj;
    private final zzecc zzk;
    private final zzeis zzl;
    private final zzedg zzm;
    private final zzedn zzn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcxp(zzebl zzeblVar, zzfhh zzfhhVar, zzflm zzflmVar, zzcqt zzcqtVar, zzemo zzemoVar, zzdgc zzdgcVar, zzfgy zzfgyVar, zzecq zzecqVar, zzdab zzdabVar, Executor executor, zzecc zzeccVar, zzeis zzeisVar, zzedg zzedgVar, zzedn zzednVar) {
        this.zza = zzeblVar;
        this.zzb = zzfhhVar;
        this.zzc = zzflmVar;
        this.zzd = zzcqtVar;
        this.zze = zzemoVar;
        this.zzf = zzdgcVar;
        this.zzg = zzfgyVar;
        this.zzh = zzecqVar;
        this.zzi = zzdabVar;
        this.zzj = executor;
        this.zzk = zzeccVar;
        this.zzl = zzeisVar;
        this.zzm = zzedgVar;
        this.zzn = zzednVar;
    }

    public final com.google.android.gms.ads.internal.client.zze zza(Throwable th) {
        return zzfij.zzb(th, this.zzl);
    }

    public final zzdgc zzc() {
        return this.zzf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfgy zzd(zzfgy zzfgyVar) throws Exception {
        this.zzd.zza(zzfgyVar);
        return zzfgyVar;
    }

    public final ListenableFuture zze(final zzfjc zzfjcVar) {
        zzfkr zza = this.zzc.zzb(zzflg.GET_CACHE_KEY, this.zzi.zzc()).zzf(new zzgdu() { // from class: com.google.android.gms.internal.ads.zzcxl
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzcxp.this.zzf(zzfjcVar, (zzbze) obj);
            }
        }).zza();
        zzgen.zzr(zza, new zzcxn(this), this.zzj);
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzf(zzfjc zzfjcVar, zzbze zzbzeVar) throws Exception {
        zzbzeVar.zzi = zzfjcVar;
        return this.zzh.zza(zzbzeVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ ListenableFuture zzg(ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ListenableFuture listenableFuture3) throws Exception {
        return this.zzn.zzc((zzbze) listenableFuture.get(), (JSONObject) listenableFuture2.get(), (zzbzh) listenableFuture3.get());
    }

    public final ListenableFuture zzh(zzbze zzbzeVar) {
        zzfkr zza = this.zzc.zzb(zzflg.NOTIFY_CACHE_HIT, this.zzh.zzg(zzbzeVar)).zza();
        zzgen.zzr(zza, new zzcxo(this), this.zzj);
        return zza;
    }

    public final ListenableFuture zzi(ListenableFuture listenableFuture) {
        zzfld zzf = this.zzc.zzb(zzflg.RENDERER, listenableFuture).zze(new zzfkp() { // from class: com.google.android.gms.internal.ads.zzcxg
            @Override // com.google.android.gms.internal.ads.zzfkp
            public final Object zza(Object obj) {
                zzfgy zzfgyVar = (zzfgy) obj;
                zzcxp.this.zzd(zzfgyVar);
                return zzfgyVar;
            }
        }).zzf(this.zze);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfv)).booleanValue()) {
            zzf = zzf.zzi(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfx)).intValue(), TimeUnit.SECONDS);
        }
        return zzf.zza();
    }

    public final ListenableFuture zzj() {
        com.google.android.gms.ads.internal.client.zzl zzlVar = this.zzb.zzd;
        if (zzlVar.zzx != null || zzlVar.zzs != null) {
            zzflm zzflmVar = this.zzc;
            zzebl zzeblVar = this.zza;
            return zzfkw.zzc(zzeblVar.zza(), zzflg.PRELOADED_LOADER, zzflmVar).zza();
        }
        return zzk(this.zzi.zzc());
    }

    public final ListenableFuture zzk(final ListenableFuture listenableFuture) {
        if (this.zzg != null) {
            return zzfkw.zzc(zzgen.zzh(this.zzg), zzflg.SERVER_TRANSACTION, this.zzc).zza();
        }
        com.google.android.gms.ads.internal.zzt.zzc().zzj();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkV)).booleanValue() || ((Boolean) zzbig.zzc.zze()).booleanValue()) {
            zzfld zzb = this.zzc.zzb(zzflg.SERVER_TRANSACTION, listenableFuture);
            final zzecc zzeccVar = this.zzk;
            Objects.requireNonNull(zzeccVar);
            return zzb.zzf(new zzgdu() { // from class: com.google.android.gms.internal.ads.zzcxm
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final ListenableFuture zza(Object obj) {
                    return zzecc.this.zzb((zzbze) obj);
                }
            }).zza();
        }
        final zzedg zzedgVar = this.zzm;
        Objects.requireNonNull(zzedgVar);
        final ListenableFuture zzn = zzgen.zzn(listenableFuture, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzcxh
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzedg.this.zza((zzbze) obj);
            }
        }, this.zzj);
        zzfld zzb2 = this.zzc.zzb(zzflg.BUILD_URL, zzn);
        final zzecq zzecqVar = this.zzh;
        Objects.requireNonNull(zzecqVar);
        final zzfkr zza = zzb2.zzf(new zzgdu() { // from class: com.google.android.gms.internal.ads.zzcxi
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzecq.this.zzb((JSONObject) obj);
            }
        }).zza();
        return this.zzc.zza(zzflg.SERVER_TRANSACTION, listenableFuture, zzn, zza).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzcxj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzcxp.this.zzg(listenableFuture, zzn, zza);
            }
        }).zzf(new zzgdu() { // from class: com.google.android.gms.internal.ads.zzcxk
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return (ListenableFuture) obj;
            }
        }).zza();
    }

    public final void zzl(zzfgy zzfgyVar) {
        this.zzg = zzfgyVar;
    }
}
