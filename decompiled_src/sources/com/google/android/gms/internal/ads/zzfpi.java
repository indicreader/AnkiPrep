package com.google.android.gms.internal.ads;

import android.os.Build;
import android.webkit.WebView;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public class zzfpi {
    private zzfql zza;
    private long zzb;
    private int zzc;

    public zzfpi() {
        zzb();
        this.zza = new zzfql(null);
    }

    public final WebView zza() {
        return (WebView) this.zza.get();
    }

    public final void zzb() {
        this.zzb = System.nanoTime();
        this.zzc = 1;
    }

    public void zzc() {
        this.zza.clear();
    }

    public final void zzd(String str, long j) {
        if (j < this.zzb || this.zzc == 3) {
            return;
        }
        this.zzc = 3;
        zzfpb.zza().zzg(zza(), str);
    }

    public final void zze(Date date) {
        if (date == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        zzfpo.zze(jSONObject, "timestamp", Long.valueOf(date.getTime()));
        zzfpb.zza().zzf(zza(), jSONObject);
    }

    public final void zzf(String str, long j) {
        if (j >= this.zzb) {
            this.zzc = 2;
            zzfpb.zza().zzg(zza(), str);
        }
    }

    public void zzg(zzfoh zzfohVar, zzfof zzfofVar) {
        zzh(zzfohVar, zzfofVar, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzh(zzfoh zzfohVar, zzfof zzfofVar, JSONObject jSONObject) {
        String zzh = zzfohVar.zzh();
        JSONObject jSONObject2 = new JSONObject();
        zzfpo.zze(jSONObject2, "environment", "app");
        zzfpo.zze(jSONObject2, "adSessionType", zzfofVar.zzd());
        JSONObject jSONObject3 = new JSONObject();
        zzfpo.zze(jSONObject3, "deviceType", Build.MANUFACTURER + "; " + Build.MODEL);
        zzfpo.zze(jSONObject3, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        zzfpo.zze(jSONObject3, "os", "Android");
        zzfpo.zze(jSONObject2, "deviceInfo", jSONObject3);
        zzfpo.zze(jSONObject2, "deviceCategory", zzfpn.zza().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        zzfpo.zze(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        zzfpo.zze(jSONObject4, "partnerName", zzfofVar.zze().zzb());
        zzfpo.zze(jSONObject4, "partnerVersion", zzfofVar.zze().zzc());
        zzfpo.zze(jSONObject2, "omidNativeInfo", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        zzfpo.zze(jSONObject5, "libraryVersion", "1.4.8-google_20230803");
        zzfpo.zze(jSONObject5, "appId", zzfoz.zzb().zza().getApplicationContext().getPackageName());
        zzfpo.zze(jSONObject2, "app", jSONObject5);
        if (zzfofVar.zzf() != null) {
            zzfpo.zze(jSONObject2, "contentUrl", zzfofVar.zzf());
        }
        zzfpo.zze(jSONObject2, "customReferenceData", zzfofVar.zzg());
        JSONObject jSONObject6 = new JSONObject();
        Iterator it = zzfofVar.zzh().iterator();
        if (it.hasNext()) {
            throw null;
        }
        zzfpb.zza().zzh(zza(), zzh, jSONObject2, jSONObject6, jSONObject);
    }

    public final void zzi(float f) {
        zzfpb.zza().zze(zza(), f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(WebView webView) {
        this.zza = new zzfql(webView);
    }

    public void zzk() {
    }

    public final boolean zzl() {
        return this.zza.get() != null;
    }
}
