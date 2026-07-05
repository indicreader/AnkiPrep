package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzeew extends zzbyt {
    private final Context zza;
    private final zzeze zzb;
    private final zzezc zzc;
    private final zzefe zzd;
    private final zzgey zze;
    private final zzefb zzf;
    private final zzbzq zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeew(Context context, zzeze zzezeVar, zzezc zzezcVar, zzefb zzefbVar, zzefe zzefeVar, zzgey zzgeyVar, zzbzq zzbzqVar) {
        this.zza = context;
        this.zzb = zzezeVar;
        this.zzc = zzezcVar;
        this.zzf = zzefbVar;
        this.zzd = zzefeVar;
        this.zze = zzgeyVar;
        this.zzg = zzbzqVar;
    }

    private final void zzc(ListenableFuture listenableFuture, zzbyx zzbyxVar) {
        zzgen.zzr(zzgen.zzn(zzgee.zzu(listenableFuture), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeet
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzgen.zzh(zzfii.zza((InputStream) obj));
            }
        }, zzcep.zza), new zzeev(this, zzbyxVar), zzcep.zzf);
    }

    public final ListenableFuture zzb(zzbym zzbymVar, int i) {
        ListenableFuture zzh;
        HashMap hashMap = new HashMap();
        Bundle bundle = zzbymVar.zzc;
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                String string = bundle.getString(str);
                if (string != null) {
                    hashMap.put(str, string);
                }
            }
        }
        final zzeey zzeeyVar = new zzeey(zzbymVar.zza, zzbymVar.zzb, hashMap, zzbymVar.zzd, "", zzbymVar.zze);
        zzezc zzezcVar = this.zzc;
        zzezcVar.zza(new zzfak(zzbymVar));
        boolean z = zzeeyVar.zzf;
        zzezd zzb = zzezcVar.zzb();
        if (z) {
            String str2 = zzbymVar.zza;
            String str3 = (String) zzbih.zzb.zze();
            if (!TextUtils.isEmpty(str3)) {
                String host = Uri.parse(str2).getHost();
                if (!TextUtils.isEmpty(host)) {
                    Iterator it = zzfxr.zzc(zzfwp.zzc(';')).zzd(str3).iterator();
                    while (it.hasNext()) {
                        if (host.endsWith((String) it.next())) {
                            zzh = zzgen.zzm(zzb.zza().zza(new JSONObject()), new zzfws() { // from class: com.google.android.gms.internal.ads.zzeeo
                                @Override // com.google.android.gms.internal.ads.zzfws
                                public final Object apply(Object obj) {
                                    zzeey zzeeyVar2 = zzeey.this;
                                    zzefe.zza(zzeeyVar2.zzc, (JSONObject) obj);
                                    return zzeeyVar2;
                                }
                            }, this.zze);
                            break;
                        }
                    }
                }
            }
        }
        zzh = zzgen.zzh(zzeeyVar);
        zzflm zzb2 = zzb.zzb();
        return zzgen.zzn(zzb2.zzb(zzflg.HTTP, zzh).zze(new zzefa(this.zza, "", this.zzg, i)).zza(), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeep
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                zzeez zzeezVar = (zzeez) obj;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("response", zzeezVar.zza);
                    JSONObject jSONObject2 = new JSONObject();
                    for (String str4 : zzeezVar.zzb.keySet()) {
                        if (str4 != null) {
                            List<String> list = (List) zzeezVar.zzb.get(str4);
                            JSONArray jSONArray = new JSONArray();
                            for (String str5 : list) {
                                if (str5 != null) {
                                    jSONArray.put(str5);
                                }
                            }
                            jSONObject2.put(str4, jSONArray);
                        }
                    }
                    jSONObject.put("headers", jSONObject2);
                    Object obj2 = zzeezVar.zzc;
                    if (obj2 != null) {
                        jSONObject.put("body", obj2);
                    }
                    jSONObject.put("latency", zzeezVar.zzd);
                    return zzgen.zzh(new ByteArrayInputStream(jSONObject.toString().getBytes(StandardCharsets.UTF_8)));
                } catch (JSONException e) {
                    zzcec.zzj("Error converting response to JSONObject: ".concat(String.valueOf(e.getMessage())));
                    throw new JSONException("Parsing HTTP Response: ".concat(String.valueOf(String.valueOf(e.getCause()))));
                }
            }
        }, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzbyu
    public final void zze(zzbym zzbymVar, zzbyx zzbyxVar) {
        zzc(zzb(zzbymVar, Binder.getCallingUid()), zzbyxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbyu
    public final void zzf(zzbyi zzbyiVar, zzbyx zzbyxVar) {
        zzeyt zzeytVar = new zzeyt(zzbyiVar, Binder.getCallingUid());
        zzeze zzezeVar = this.zzb;
        zzezeVar.zza(zzeytVar);
        final zzezf zzb = zzezeVar.zzb();
        zzflm zzb2 = zzb.zzb();
        zzfkr zza = zzb2.zzb(zzflg.GMS_SIGNALS, zzgen.zzi()).zzf(new zzgdu() { // from class: com.google.android.gms.internal.ads.zzees
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzezf.this.zza().zza(new JSONObject());
            }
        }).zze(new zzfkp() { // from class: com.google.android.gms.internal.ads.zzeer
            @Override // com.google.android.gms.internal.ads.zzfkp
            public final Object zza(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                com.google.android.gms.ads.internal.util.zze.zza("GMS AdRequest Signals: ");
                com.google.android.gms.ads.internal.util.zze.zza(jSONObject.toString(2));
                return jSONObject;
            }
        }).zzf(new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeeq
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzgen.zzh(new ByteArrayInputStream(((JSONObject) obj).toString().getBytes(StandardCharsets.UTF_8)));
            }
        }).zza();
        zzc(zza, zzbyxVar);
        if (((Boolean) zzbia.zzd.zze()).booleanValue()) {
            final zzefe zzefeVar = this.zzd;
            Objects.requireNonNull(zzefeVar);
            zza.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeeu
                @Override // java.lang.Runnable
                public final void run() {
                    zzefe.this.zzb();
                }
            }, this.zze);
        }
    }
}
