package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdqv {
    private final zzfhh zza;
    private final Executor zzb;
    private final zzdtk zzc;
    private final zzdsf zzd;
    private final Context zze;
    private final zzdwf zzf;
    private final zzflw zzg;
    private final zzfny zzh;
    private final zzehh zzi;

    public zzdqv(zzfhh zzfhhVar, Executor executor, zzdtk zzdtkVar, Context context, zzdwf zzdwfVar, zzflw zzflwVar, zzfny zzfnyVar, zzehh zzehhVar, zzdsf zzdsfVar) {
        this.zza = zzfhhVar;
        this.zzb = executor;
        this.zzc = zzdtkVar;
        this.zze = context;
        this.zzf = zzdwfVar;
        this.zzg = zzflwVar;
        this.zzh = zzfnyVar;
        this.zzi = zzehhVar;
        this.zzd = zzdsfVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzh(zzcjk zzcjkVar) {
        zzj(zzcjkVar);
        zzcjkVar.zzae("/video", zzbnf.zzl);
        zzcjkVar.zzae("/videoMeta", zzbnf.zzm);
        zzcjkVar.zzae("/precache", new zzchx());
        zzcjkVar.zzae("/delayPageLoaded", zzbnf.zzp);
        zzcjkVar.zzae("/instrument", zzbnf.zzn);
        zzcjkVar.zzae("/log", zzbnf.zzg);
        zzcjkVar.zzae("/click", new zzbme(null, 0 == true ? 1 : 0));
        if (this.zza.zzb != null) {
            zzcjkVar.zzN().zzE(true);
            zzcjkVar.zzae("/open", new zzbnr(null, null, null, null, null, null));
        } else {
            zzcjkVar.zzN().zzE(false);
        }
        if (com.google.android.gms.ads.internal.zzt.zzn().zzp(zzcjkVar.getContext())) {
            zzcjkVar.zzae("/logScionEvent", new zzbnl(zzcjkVar.getContext()));
        }
    }

    private final void zzi(zzcjk zzcjkVar, zzcet zzcetVar) {
        if (this.zza.zza != null && zzcjkVar.zzq() != null) {
            zzcjkVar.zzq().zzs(this.zza.zza);
        }
        zzcetVar.zzb();
    }

    private static final void zzj(zzcjk zzcjkVar) {
        zzcjkVar.zzae("/videoClicked", zzbnf.zzh);
        zzcjkVar.zzN().zzG(true);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdF)).booleanValue()) {
            zzcjkVar.zzae("/getNativeAdViewSignals", zzbnf.zzs);
        }
        zzcjkVar.zzae("/getNativeClickMeta", zzbnf.zzt);
    }

    public final ListenableFuture zza(final JSONObject jSONObject) {
        return zzgen.zzn(zzgen.zzn(zzgen.zzh(null), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzdqm
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzdqv.this.zze(obj);
            }
        }, this.zzb), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzdql
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzdqv.this.zzc(jSONObject, (zzcjk) obj);
            }
        }, this.zzb);
    }

    public final ListenableFuture zzb(final String str, final String str2, final zzfgm zzfgmVar, final zzfgp zzfgpVar, final com.google.android.gms.ads.internal.client.zzq zzqVar) {
        return zzgen.zzn(zzgen.zzh(null), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzdqk
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzdqv.this.zzd(zzqVar, zzfgmVar, zzfgpVar, str, str2, obj);
            }
        }, this.zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(JSONObject jSONObject, final zzcjk zzcjkVar) throws Exception {
        final zzcet zza = zzcet.zza(zzcjkVar);
        if (this.zza.zzb != null) {
            zzcjkVar.zzah(zzcla.zzd());
        } else {
            zzcjkVar.zzah(zzcla.zze());
        }
        zzcjkVar.zzN().zzB(new zzckw() { // from class: com.google.android.gms.internal.ads.zzdqn
            @Override // com.google.android.gms.internal.ads.zzckw
            public final void zza(boolean z, int i, String str, String str2) {
                zzdqv.this.zzf(zzcjkVar, zza, z, i, str, str2);
            }
        });
        zzcjkVar.zzl("google.afma.nativeAds.renderVideo", jSONObject);
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzd(com.google.android.gms.ads.internal.client.zzq zzqVar, zzfgm zzfgmVar, zzfgp zzfgpVar, String str, String str2, Object obj) throws Exception {
        final zzcjk zza = this.zzc.zza(zzqVar, zzfgmVar, zzfgpVar);
        final zzcet zza2 = zzcet.zza(zza);
        if (this.zza.zzb != null) {
            zzh(zza);
            zza.zzah(zzcla.zzd());
        } else {
            zzdsc zzb = this.zzd.zzb();
            zza.zzN().zzN(zzb, zzb, zzb, zzb, zzb, false, null, new com.google.android.gms.ads.internal.zzb(this.zze, null, null), null, null, this.zzi, this.zzh, this.zzf, this.zzg, null, zzb, null, null, null);
            zzj(zza);
        }
        zza.zzN().zzB(new zzckw() { // from class: com.google.android.gms.internal.ads.zzdqo
            @Override // com.google.android.gms.internal.ads.zzckw
            public final void zza(boolean z, int i, String str3, String str4) {
                zzdqv.this.zzg(zza, zza2, z, i, str3, str4);
            }
        });
        zza.zzac(str, str2, null);
        return zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zze(Object obj) throws Exception {
        zzcjk zza = this.zzc.zza(com.google.android.gms.ads.internal.client.zzq.zzc(), null, null);
        final zzcet zza2 = zzcet.zza(zza);
        zzh(zza);
        zza.zzN().zzH(new zzckx() { // from class: com.google.android.gms.internal.ads.zzdqp
            @Override // com.google.android.gms.internal.ads.zzckx
            public final void zza() {
                zzcet.this.zzb();
            }
        });
        zza.loadUrl((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdE));
        return zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzcjk zzcjkVar, zzcet zzcetVar, boolean z, int i, String str, String str2) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdP)).booleanValue()) {
            zzi(zzcjkVar, zzcetVar);
            return;
        }
        if (z) {
            zzi(zzcjkVar, zzcetVar);
            return;
        }
        zzcetVar.zzd(new zzeml(1, "Native Video WebView failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzcjk zzcjkVar, zzcet zzcetVar, boolean z, int i, String str, String str2) {
        if (z) {
            if (this.zza.zza != null && zzcjkVar.zzq() != null) {
                zzcjkVar.zzq().zzs(this.zza.zza);
            }
            zzcetVar.zzb();
            return;
        }
        zzcetVar.zzd(new zzeml(1, "Html video Web View failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
    }
}
