package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzejs implements zzeit {
    private final Context zza;
    private final zzcvc zzb;
    private final Executor zzc;

    public zzejs(Context context, zzcvc zzcvcVar, Executor executor) {
        this.zza = context;
        this.zzb = zzcvcVar;
        this.zzc = executor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzeit
    public final /* bridge */ /* synthetic */ Object zza(zzfgy zzfgyVar, final zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzfho, zzeml {
        final View zza;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhI)).booleanValue() || !zzfgmVar.zzah) {
            zza = ((zzfif) zzeiqVar.zzb).zza();
        } else {
            zzbte zzc = ((zzfif) zzeiqVar.zzb).zzc();
            if (zzc == null) {
                zzcec.zzg("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad.");
                throw new zzfho(new Exception("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad."));
            }
            try {
                zza = (View) ObjectWrapper.unwrap(zzc.zze());
                boolean zzf = zzc.zzf();
                if (zza == null) {
                    throw new zzfho(new Exception("BannerAdapterWrapper interscrollerView should not be null"));
                }
                if (zzf) {
                    try {
                        zza = (View) zzgen.zzn(zzgen.zzh(null), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzejq
                            @Override // com.google.android.gms.internal.ads.zzgdu
                            public final ListenableFuture zza(Object obj) {
                                return zzejs.this.zzc(zza, zzfgmVar, obj);
                            }
                        }, zzcep.zze).get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new zzfho(e);
                    }
                }
            } catch (RemoteException e2) {
                throw new zzfho(e2);
            }
        }
        zzcvc zzcvcVar = this.zzb;
        zzcwx zzcwxVar = new zzcwx(zzfgyVar, zzfgmVar, zzeiqVar.zza);
        final zzfif zzfifVar = (zzfif) zzeiqVar.zzb;
        Objects.requireNonNull(zzfifVar);
        zzcug zza2 = zzcvcVar.zza(zzcwxVar, new zzcum(zza, null, new zzcwf() { // from class: com.google.android.gms.internal.ads.zzejr
            @Override // com.google.android.gms.internal.ads.zzcwf
            public final com.google.android.gms.ads.internal.client.zzdq zza() {
                return zzfif.this.zzb();
            }
        }, (zzfgn) zzfgmVar.zzv.get(0)));
        zza2.zzg().zza(zza);
        zza2.zzd().zzo(new zzcrv((zzfif) zzeiqVar.zzb), this.zzc);
        ((zzekj) zzeiqVar.zzc).zzc(zza2.zzj());
        return zza2.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final void zzb(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzfho {
        com.google.android.gms.ads.internal.client.zzq zza;
        com.google.android.gms.ads.internal.client.zzq zzqVar = zzfgyVar.zza.zza.zze;
        if (zzqVar.zzn) {
            zza = new com.google.android.gms.ads.internal.client.zzq(this.zza, com.google.android.gms.ads.zzb.zzd(zzqVar.zze, zzqVar.zzb));
        } else {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhI)).booleanValue() || !zzfgmVar.zzah) {
                zza = zzfhn.zza(this.zza, zzfgmVar.zzv);
            } else {
                zza = new com.google.android.gms.ads.internal.client.zzq(this.zza, com.google.android.gms.ads.zzb.zze(zzqVar.zze, zzqVar.zzb));
            }
        }
        com.google.android.gms.ads.internal.client.zzq zzqVar2 = zza;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhI)).booleanValue() || !zzfgmVar.zzah) {
            Object obj = zzeiqVar.zzb;
            Context context = this.zza;
            zzfhh zzfhhVar = zzfgyVar.zza.zza;
            ((zzfif) obj).zzm(context, zzqVar2, zzfhhVar.zzd, zzfgmVar.zzw.toString(), com.google.android.gms.ads.internal.util.zzbw.zzl(zzfgmVar.zzt), (zzbtb) zzeiqVar.zzc);
            return;
        }
        Object obj2 = zzeiqVar.zzb;
        Context context2 = this.zza;
        zzfhh zzfhhVar2 = zzfgyVar.zza.zza;
        ((zzfif) obj2).zzn(context2, zzqVar2, zzfhhVar2.zzd, zzfgmVar.zzw.toString(), com.google.android.gms.ads.internal.util.zzbw.zzl(zzfgmVar.zzt), (zzbtb) zzeiqVar.zzc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(View view, zzfgm zzfgmVar, Object obj) throws Exception {
        return zzgen.zzh(zzcvt.zza(this.zza, view, zzfgmVar));
    }
}
