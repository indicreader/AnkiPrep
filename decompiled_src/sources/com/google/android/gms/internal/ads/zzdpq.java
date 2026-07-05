package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdpq {
    private final zzgey zza;
    private final zzdqd zzb;
    private final zzdqi zzc;

    public zzdpq(zzgey zzgeyVar, zzdqd zzdqdVar, zzdqi zzdqiVar) {
        this.zza = zzgeyVar;
        this.zzb = zzdqdVar;
        this.zzc = zzdqiVar;
    }

    public final ListenableFuture zza(final zzfgy zzfgyVar, final zzfgm zzfgmVar, final JSONObject jSONObject) {
        ListenableFuture zzn;
        final ListenableFuture zzb = this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdpo
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdna zzdnaVar = new zzdna();
                JSONObject jSONObject2 = jSONObject;
                zzdnaVar.zzaa(jSONObject2.optInt("template_id", -1));
                zzdnaVar.zzK(jSONObject2.optString("custom_template_id"));
                JSONObject optJSONObject = jSONObject2.optJSONObject("omid_settings");
                String optString = optJSONObject != null ? optJSONObject.optString("omid_partner_name") : null;
                zzfgy zzfgyVar2 = zzfgyVar;
                zzdnaVar.zzV(optString);
                zzfhh zzfhhVar = zzfgyVar2.zza.zza;
                if (zzfhhVar.zzg.contains(Integer.toString(zzdnaVar.zzc()))) {
                    if (zzdnaVar.zzc() == 3) {
                        if (zzdnaVar.zzA() == null) {
                            throw new zzeml(1, "No custom template id for custom template ad response.");
                        }
                        if (!zzfhhVar.zzh.contains(zzdnaVar.zzA())) {
                            throw new zzeml(1, "Unexpected custom template id in the response.");
                        }
                    }
                    zzfgm zzfgmVar2 = zzfgmVar;
                    zzdnaVar.zzY(jSONObject2.optDouble("rating", -1.0d));
                    String optString2 = jSONObject2.optString("headline", null);
                    if (zzfgmVar2.zzN) {
                        com.google.android.gms.ads.internal.zzt.zzp();
                        optString2 = com.google.android.gms.ads.internal.util.zzt.zzx() + " : " + optString2;
                    }
                    zzdnaVar.zzZ("headline", optString2);
                    zzdnaVar.zzZ("body", jSONObject2.optString("body", null));
                    zzdnaVar.zzZ("call_to_action", jSONObject2.optString("call_to_action", null));
                    zzdnaVar.zzZ("store", jSONObject2.optString("store", null));
                    zzdnaVar.zzZ("price", jSONObject2.optString("price", null));
                    zzdnaVar.zzZ("advertiser", jSONObject2.optString("advertiser", null));
                    return zzdnaVar;
                }
                throw new zzeml(1, "Invalid template ID: " + zzdnaVar.zzc());
            }
        });
        final ListenableFuture zzf = this.zzb.zzf(jSONObject, "images");
        zzfgp zzfgpVar = zzfgyVar.zzb.zzb;
        zzdqd zzdqdVar = this.zzb;
        final ListenableFuture zzg = zzdqdVar.zzg(jSONObject, "images", zzfgmVar, zzfgpVar);
        final ListenableFuture zze = zzdqdVar.zze(jSONObject, "secondary_image");
        final ListenableFuture zze2 = zzdqdVar.zze(jSONObject, "app_icon");
        final ListenableFuture zzd = zzdqdVar.zzd(jSONObject, "attribution");
        final ListenableFuture zzh = this.zzb.zzh(jSONObject, zzfgmVar, zzfgyVar.zzb.zzb);
        final ListenableFuture zza = this.zzc.zza(jSONObject, "custom_assets");
        if (!jSONObject.optBoolean("enable_omid")) {
            zzn = zzgen.zzh(null);
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
            if (optJSONObject == null) {
                zzn = zzgen.zzh(null);
            } else {
                final String optString = optJSONObject.optString("omid_html");
                if (TextUtils.isEmpty(optString)) {
                    zzn = zzgen.zzh(null);
                } else {
                    final zzdqd zzdqdVar2 = this.zzb;
                    zzn = zzgen.zzn(zzgen.zzh(null), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzdps
                        @Override // com.google.android.gms.internal.ads.zzgdu
                        public final ListenableFuture zza(Object obj) {
                            return zzdqd.this.zzc(optString, obj);
                        }
                    }, zzcep.zze);
                }
            }
        }
        final ListenableFuture listenableFuture = zzn;
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzb);
        arrayList.add(zzf);
        arrayList.add(zzg);
        arrayList.add(zze);
        arrayList.add(zze2);
        arrayList.add(zzd);
        arrayList.add(zzh);
        arrayList.add(zza);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfa)).booleanValue()) {
            arrayList.add(listenableFuture);
        }
        return zzgen.zza(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdpp
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdna zzdnaVar = (zzdna) zzb.get();
                zzdnaVar.zzP((List) zzf.get());
                zzdnaVar.zzM((zzbjm) zze2.get());
                zzdnaVar.zzQ((zzbjm) zze.get());
                zzdnaVar.zzJ((zzbjf) zzd.get());
                JSONObject jSONObject2 = jSONObject;
                zzdnaVar.zzS(zzdqd.zzj(jSONObject2));
                zzdnaVar.zzL(zzdqd.zzi(jSONObject2));
                zzcjk zzcjkVar = (zzcjk) zzh.get();
                if (zzcjkVar != null) {
                    zzdnaVar.zzad(zzcjkVar);
                    zzdnaVar.zzac(zzcjkVar.zzF());
                    zzdnaVar.zzab(zzcjkVar.zzq());
                }
                zzcjk zzcjkVar2 = (zzcjk) zzg.get();
                if (zzcjkVar2 != null) {
                    zzdnaVar.zzO(zzcjkVar2);
                    zzdnaVar.zzae(zzcjkVar2.zzF());
                }
                ListenableFuture listenableFuture2 = listenableFuture;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfa)).booleanValue()) {
                    zzdnaVar.zzU(listenableFuture2);
                    zzdnaVar.zzX(new zzceu());
                } else {
                    zzcjk zzcjkVar3 = (zzcjk) listenableFuture2.get();
                    if (zzcjkVar3 != null) {
                        zzdnaVar.zzT(zzcjkVar3);
                    }
                }
                for (zzdqh zzdqhVar : (List) zza.get()) {
                    if (zzdqhVar.zza != 1) {
                        zzdnaVar.zzN(zzdqhVar.zzb, zzdqhVar.zzd);
                    } else {
                        zzdnaVar.zzZ(zzdqhVar.zzb, zzdqhVar.zzc);
                    }
                }
                return zzdnaVar;
            }
        }, this.zza);
    }
}
