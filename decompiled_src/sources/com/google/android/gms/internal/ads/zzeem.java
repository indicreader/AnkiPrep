package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeem extends zzbyp {
    private final Context zza;
    private final zzgey zzb;
    private final zzefe zzc;
    private final zzcqs zzd;
    private final ArrayDeque zze;
    private final zzfnc zzf;
    private final zzbzq zzg;
    private final zzefb zzh;

    public zzeem(Context context, zzgey zzgeyVar, zzbzq zzbzqVar, zzcqs zzcqsVar, zzefe zzefeVar, ArrayDeque arrayDeque, zzefb zzefbVar, zzfnc zzfncVar) {
        zzbgc.zza(context);
        this.zza = context;
        this.zzb = zzgeyVar;
        this.zzg = zzbzqVar;
        this.zzc = zzefeVar;
        this.zzd = zzcqsVar;
        this.zze = arrayDeque;
        this.zzh = zzefbVar;
        this.zzf = zzfncVar;
    }

    private final synchronized zzeej zzk(String str) {
        Iterator it = this.zze.iterator();
        while (it.hasNext()) {
            zzeej zzeejVar = (zzeej) it.next();
            if (zzeejVar.zzc.equals(str)) {
                it.remove();
                return zzeejVar;
            }
        }
        return null;
    }

    private static ListenableFuture zzl(ListenableFuture listenableFuture, zzflm zzflmVar, zzbrx zzbrxVar, zzfmz zzfmzVar, zzfmo zzfmoVar) {
        zzbrn zza = zzbrxVar.zza("AFMA_getAdDictionary", zzbru.zza, new zzbrp() { // from class: com.google.android.gms.internal.ads.zzeef
            @Override // com.google.android.gms.internal.ads.zzbrp
            public final Object zza(JSONObject jSONObject) {
                return new zzbzh(jSONObject);
            }
        });
        zzfmy.zzd(listenableFuture, zzfmoVar);
        zzfkr zza2 = zzflmVar.zzb(zzflg.BUILD_URL, listenableFuture).zzf(zza).zza();
        zzfmy.zzc(zza2, zzfmzVar, zzfmoVar);
        return zza2;
    }

    private static ListenableFuture zzm(zzbze zzbzeVar, zzflm zzflmVar, final zzeyo zzeyoVar) {
        zzgdu zzgduVar = new zzgdu() { // from class: com.google.android.gms.internal.ads.zzedz
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzeyo.this.zzb().zza(com.google.android.gms.ads.internal.client.zzay.zzb().zzh((Bundle) obj));
            }
        };
        return zzflmVar.zzb(zzflg.GMS_SIGNALS, zzgen.zzh(zzbzeVar.zza)).zzf(zzgduVar).zze(new zzfkp() { // from class: com.google.android.gms.internal.ads.zzeea
            @Override // com.google.android.gms.internal.ads.zzfkp
            public final Object zza(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                com.google.android.gms.ads.internal.util.zze.zza("Ad request signals:");
                com.google.android.gms.ads.internal.util.zze.zza(jSONObject.toString(2));
                return jSONObject;
            }
        }).zza();
    }

    private final synchronized void zzn(zzeej zzeejVar) {
        zzo();
        this.zze.addLast(zzeejVar);
    }

    private final synchronized void zzo() {
        int intValue = ((Long) zzbih.zzc.zze()).intValue();
        while (this.zze.size() >= intValue) {
            this.zze.removeFirst();
        }
    }

    private final void zzp(ListenableFuture listenableFuture, zzbza zzbzaVar) {
        zzgen.zzr(zzgen.zzn(listenableFuture, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzedx
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzgen.zzh(zzfii.zza((InputStream) obj));
            }
        }, zzcep.zza), new zzeei(this, zzbzaVar), zzcep.zzf);
    }

    public final ListenableFuture zzb(final zzbze zzbzeVar, int i) {
        if (!((Boolean) zzbih.zza.zze()).booleanValue()) {
            return zzgen.zzg(new Exception("Split request is disabled."));
        }
        zzfjc zzfjcVar = zzbzeVar.zzi;
        if (zzfjcVar == null) {
            return zzgen.zzg(new Exception("Pool configuration missing from request."));
        }
        if (zzfjcVar.zzc == 0 || zzfjcVar.zzd == 0) {
            return zzgen.zzg(new Exception("Caching is disabled."));
        }
        zzbrx zzb = com.google.android.gms.ads.internal.zzt.zzf().zzb(this.zza, zzcei.zza(), this.zzf);
        zzeyo zzq = this.zzd.zzq(zzbzeVar, i);
        zzflm zzc = zzq.zzc();
        final ListenableFuture zzm = zzm(zzbzeVar, zzc, zzq);
        zzfmz zzd = zzq.zzd();
        final zzfmo zza = zzfmn.zza(this.zza, 9);
        final ListenableFuture zzl = zzl(zzm, zzc, zzb, zzd, zza);
        return zzc.zza(zzflg.GET_URL_AND_CACHE_KEY, zzm, zzl).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeed
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeem.this.zzj(zzl, zzm, zzbzeVar, zza);
            }
        }).zza();
    }

    public final ListenableFuture zzc(zzbze zzbzeVar, int i) {
        zzeej zzk;
        zzfmo zzfmoVar;
        zzfkr zza;
        zzbrx zzb = com.google.android.gms.ads.internal.zzt.zzf().zzb(this.zza, zzcei.zza(), this.zzf);
        zzeyo zzq = this.zzd.zzq(zzbzeVar, i);
        zzbrn zza2 = zzb.zza("google.afma.response.normalize", zzeel.zza, zzbru.zzb);
        if (!((Boolean) zzbih.zza.zze()).booleanValue()) {
            String str = zzbzeVar.zzj;
            zzk = null;
            if (str != null && !str.isEmpty()) {
                com.google.android.gms.ads.internal.util.zze.zza("Request contained a PoolKey but split request is disabled.");
            }
        } else {
            zzk = zzk(zzbzeVar.zzh);
            if (zzk == null) {
                com.google.android.gms.ads.internal.util.zze.zza("Request contained a PoolKey but no matching parameters were found.");
            }
        }
        if (zzk == null) {
            zzfmoVar = zzfmn.zza(this.zza, 9);
        } else {
            zzfmoVar = zzk.zze;
        }
        zzfmz zzd = zzq.zzd();
        zzd.zzd(zzbzeVar.zza.getStringArrayList("ad_types"));
        zzefd zzefdVar = new zzefd(zzbzeVar.zzg, zzd, zzfmoVar);
        zzefa zzefaVar = new zzefa(this.zza, zzbzeVar.zzb.zza, this.zzg, i);
        zzflm zzc = zzq.zzc();
        zzfmo zza3 = zzfmn.zza(this.zza, 11);
        if (zzk == null) {
            final ListenableFuture zzm = zzm(zzbzeVar, zzc, zzq);
            final ListenableFuture zzl = zzl(zzm, zzc, zzb, zzd, zzfmoVar);
            zzfmo zza4 = zzfmn.zza(this.zza, 10);
            final zzfkr zza5 = zzc.zza(zzflg.HTTP, zzl, zzm).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeeb
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new zzefc((JSONObject) ListenableFuture.this.get(), (zzbzh) zzl.get());
                }
            }).zze(zzefdVar).zze(new zzfmu(zza4)).zze(zzefaVar).zza();
            zzfmy.zza(zza5, zzd, zza4);
            zzfmy.zzd(zza5, zza3);
            zza = zzc.zza(zzflg.PRE_PROCESS, zzm, zzl, zza5).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeec
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new zzeel((zzeez) ListenableFuture.this.get(), (JSONObject) zzm.get(), (zzbzh) zzl.get());
                }
            }).zzf(zza2).zza();
        } else {
            zzefc zzefcVar = new zzefc(zzk.zzb, zzk.zza);
            zzfmo zza6 = zzfmn.zza(this.zza, 10);
            final zzfkr zza7 = zzc.zzb(zzflg.HTTP, zzgen.zzh(zzefcVar)).zze(zzefdVar).zze(new zzfmu(zza6)).zze(zzefaVar).zza();
            zzfmy.zza(zza7, zzd, zza6);
            final ListenableFuture zzh = zzgen.zzh(zzk);
            zzfmy.zzd(zza7, zza3);
            zza = zzc.zza(zzflg.PRE_PROCESS, zza7, zzh).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzedy
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzeez zzeezVar = (zzeez) ListenableFuture.this.get();
                    ListenableFuture listenableFuture = zzh;
                    return new zzeel(zzeezVar, ((zzeej) listenableFuture.get()).zzb, ((zzeej) listenableFuture.get()).zza);
                }
            }).zzf(zza2).zza();
        }
        zzfmy.zza(zza, zzd, zza3);
        return zza;
    }

    public final ListenableFuture zzd(zzbze zzbzeVar, int i) {
        zzbrx zzb = com.google.android.gms.ads.internal.zzt.zzf().zzb(this.zza, zzcei.zza(), this.zzf);
        if (!((Boolean) zzbim.zza.zze()).booleanValue()) {
            return zzgen.zzg(new Exception("Signal collection disabled."));
        }
        zzeyo zzq = this.zzd.zzq(zzbzeVar, i);
        final zzext zza = zzq.zza();
        zzbrn zza2 = zzb.zza("google.afma.request.getSignals", zzbru.zza, zzbru.zzb);
        zzfmo zza3 = zzfmn.zza(this.zza, 22);
        zzfkr zza4 = zzq.zzc().zzb(zzflg.GET_SIGNALS, zzgen.zzh(zzbzeVar.zza)).zze(new zzfmu(zza3)).zzf(new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeeg
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzext.this.zza(com.google.android.gms.ads.internal.client.zzay.zzb().zzh((Bundle) obj));
            }
        }).zzb(zzflg.JS_SIGNALS).zzf(zza2).zza();
        zzfmz zzd = zzq.zzd();
        zzd.zzd(zzbzeVar.zza.getStringArrayList("ad_types"));
        zzfmy.zzb(zza4, zzd, zza3);
        if (((Boolean) zzbia.zze.zze()).booleanValue()) {
            zzefe zzefeVar = this.zzc;
            Objects.requireNonNull(zzefeVar);
            zza4.addListener(new zzeee(zzefeVar), this.zzb);
        }
        return zza4;
    }

    @Override // com.google.android.gms.internal.ads.zzbyq
    public final void zze(zzbze zzbzeVar, zzbza zzbzaVar) {
        zzp(zzb(zzbzeVar, Binder.getCallingUid()), zzbzaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbyq
    public final void zzf(zzbze zzbzeVar, zzbza zzbzaVar) {
        zzp(zzd(zzbzeVar, Binder.getCallingUid()), zzbzaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbyq
    public final void zzg(zzbze zzbzeVar, zzbza zzbzaVar) {
        ListenableFuture zzc = zzc(zzbzeVar, Binder.getCallingUid());
        zzp(zzc, zzbzaVar);
        if (((Boolean) zzbia.zzc.zze()).booleanValue()) {
            zzefe zzefeVar = this.zzc;
            Objects.requireNonNull(zzefeVar);
            zzc.addListener(new zzeee(zzefeVar), this.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbyq
    public final void zzh(String str, zzbza zzbzaVar) {
        zzp(zzi(str), zzbzaVar);
    }

    public final ListenableFuture zzi(String str) {
        if (!((Boolean) zzbih.zza.zze()).booleanValue()) {
            return zzgen.zzg(new Exception("Split request is disabled."));
        }
        zzeeh zzeehVar = new zzeeh(this);
        if (zzk(str) == null) {
            return zzgen.zzg(new Exception("URL to be removed not found for cache key: ".concat(String.valueOf(str))));
        }
        return zzgen.zzh(zzeehVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ InputStream zzj(ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzbze zzbzeVar, zzfmo zzfmoVar) throws Exception {
        String zzc = ((zzbzh) listenableFuture.get()).zzc();
        zzn(new zzeej((zzbzh) listenableFuture.get(), (JSONObject) listenableFuture2.get(), zzbzeVar.zzh, zzc, zzfmoVar));
        return new ByteArrayInputStream(zzc.getBytes(zzfwq.zzc));
    }
}
