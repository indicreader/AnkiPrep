package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.PlatformVersion;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzelh implements zzelb {
    private final zzdlk zza;
    private final zzgey zzb;
    private final zzdpq zzc;
    private final zzfig zzd;
    private final zzdsf zze;

    public zzelh(zzdlk zzdlkVar, zzgey zzgeyVar, zzdpq zzdpqVar, zzfig zzfigVar, zzdsf zzdsfVar) {
        this.zza = zzdlkVar;
        this.zzb = zzgeyVar;
        this.zzc = zzdpqVar;
        this.zzd = zzfigVar;
        this.zze = zzdsfVar;
    }

    private final ListenableFuture zzg(final zzfgy zzfgyVar, final zzfgm zzfgmVar, final JSONObject jSONObject) {
        zzdpq zzdpqVar = this.zzc;
        final ListenableFuture zza = this.zzd.zza();
        final ListenableFuture zza2 = zzdpqVar.zza(zzfgyVar, zzfgmVar, jSONObject);
        return zzgen.zzc(zza, zza2).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzelc
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzelh.this.zzc(zza2, zza, zzfgyVar, zzfgmVar, jSONObject);
            }
        }, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final ListenableFuture zza(final zzfgy zzfgyVar, final zzfgm zzfgmVar) {
        return zzgen.zzn(zzgen.zzn(this.zzd.zza(), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzele
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzelh.this.zze(zzfgmVar, (zzdrz) obj);
            }
        }, this.zzb), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzelf
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzelh.this.zzf(zzfgyVar, zzfgmVar, (JSONArray) obj);
            }
        }, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final boolean zzb(zzfgy zzfgyVar, zzfgm zzfgmVar) {
        zzfgr zzfgrVar = zzfgmVar.zzt;
        return (zzfgrVar == null || zzfgrVar.zzc == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ zzdmv zzc(ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzfgy zzfgyVar, zzfgm zzfgmVar, JSONObject jSONObject) throws Exception {
        zzdna zzdnaVar = (zzdna) listenableFuture.get();
        zzdrz zzdrzVar = (zzdrz) listenableFuture2.get();
        zzdnb zzd = this.zza.zzd(new zzcwx(zzfgyVar, zzfgmVar, null), new zzdnm(zzdnaVar), new zzdlz(jSONObject, zzdrzVar));
        zzd.zzh().zzb();
        zzd.zzk().zza(zzdrzVar);
        zzd.zzg().zza(zzdnaVar.zzs());
        zzd.zzl().zza(this.zze);
        return zzd.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzd(zzdrz zzdrzVar, JSONObject jSONObject) throws Exception {
        this.zzd.zzb(zzgen.zzh(zzdrzVar));
        if (!jSONObject.optBoolean("success")) {
            throw new zzbrm("process json failed");
        }
        return zzgen.zzh(jSONObject.getJSONObject("json").getJSONArray("ads"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zze(zzfgm zzfgmVar, final zzdrz zzdrzVar) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isNonagon", true);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziw)).booleanValue() && PlatformVersion.isAtLeastR()) {
            jSONObject.put("skipDeepLinkValidation", true);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("response", zzfgmVar.zzt.zzc);
        jSONObject2.put("sdk_params", jSONObject);
        return zzgen.zzn(zzdrzVar.zzd("google.afma.nativeAds.preProcessJson", jSONObject2), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeld
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzelh.this.zzd(zzdrzVar, (JSONObject) obj);
            }
        }, this.zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzf(zzfgy zzfgyVar, zzfgm zzfgmVar, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzgen.zzg(new zzead(3));
        }
        if (zzfgyVar.zza.zza.zzk > 1) {
            int length = jSONArray.length();
            this.zzd.zzc(Math.min(length, zzfgyVar.zza.zza.zzk));
            ArrayList arrayList = new ArrayList(zzfgyVar.zza.zza.zzk);
            for (int i = 0; i < zzfgyVar.zza.zza.zzk; i++) {
                if (i < length) {
                    arrayList.add(zzg(zzfgyVar, zzfgmVar, jSONArray.getJSONObject(i)));
                } else {
                    arrayList.add(zzgen.zzg(new zzead(3)));
                }
            }
            return zzgen.zzh(arrayList);
        }
        return zzgen.zzm(zzg(zzfgyVar, zzfgmVar, jSONArray.getJSONObject(0)), new zzfws() { // from class: com.google.android.gms.internal.ads.zzelg
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                return Collections.singletonList(zzgen.zzh((zzdmv) obj));
            }
        }, this.zzb);
    }
}
