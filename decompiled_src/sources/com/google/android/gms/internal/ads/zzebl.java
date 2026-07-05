package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.core.os.EnvironmentCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzebl {
    private final zzclg zza;
    private final Context zzb;
    private final zzcei zzc;
    private final zzfhh zzd;
    private final Executor zze;
    private final String zzf;
    private final zzfmz zzg;
    private final zzfhw zzh;
    private final zzdwa zzi;

    public zzebl(zzclg zzclgVar, Context context, zzcei zzceiVar, zzfhh zzfhhVar, Executor executor, String str, zzfmz zzfmzVar, zzdwa zzdwaVar) {
        this.zza = zzclgVar;
        this.zzb = context;
        this.zzc = zzceiVar;
        this.zzd = zzfhhVar;
        this.zze = executor;
        this.zzf = str;
        this.zzg = zzfmzVar;
        this.zzh = zzclgVar.zzw();
        this.zzi = zzdwaVar;
    }

    private final ListenableFuture zzc(final String str, final String str2) {
        zzfmo zza = zzfmn.zza(this.zzb, 11);
        zza.zzh();
        final zzbrn zza2 = com.google.android.gms.ads.internal.zzt.zzf().zza(this.zzb, this.zzc, this.zza.zzz()).zza("google.afma.response.normalize", zzbru.zza, zzbru.zza);
        ListenableFuture zzn = zzgen.zzn(zzgen.zzn(zzgen.zzn(zzgen.zzh(""), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzebi
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                String str3 = str;
                String str4 = str2;
                try {
                    jSONObject3.put("headers", new JSONObject());
                    jSONObject3.put("body", str3);
                    jSONObject2.put("base_url", "");
                    jSONObject2.put("signals", new JSONObject(str4));
                    jSONObject.put("request", jSONObject2);
                    jSONObject.put("response", jSONObject3);
                    jSONObject.put("flags", new JSONObject());
                    return zzgen.zzh(jSONObject);
                } catch (JSONException e) {
                    throw new JSONException("Preloaded loader: ".concat(String.valueOf(String.valueOf(e.getCause()))));
                }
            }
        }, this.zze), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzebj
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzbrn.this.zzb((JSONObject) obj);
            }
        }, this.zze), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzebk
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzebl.this.zzb((JSONObject) obj);
            }
        }, this.zze);
        zzfmy.zza(zzn, this.zzg, zza);
        return zzn;
    }

    private final String zzd(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("ad_types");
            if (jSONArray != null && EnvironmentCompat.MEDIA_UNKNOWN.equals(jSONArray.getString(0))) {
                jSONObject.put("ad_types", new JSONArray().put(this.zzf));
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            zzcec.zzj("Failed to update the ad types for rendering. ".concat(e.toString()));
            return str;
        }
    }

    private static final String zze(String str) {
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.common.util.concurrent.ListenableFuture zza() {
        /*
            Method dump skipped, instructions count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzebl.zza():com.google.common.util.concurrent.ListenableFuture");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzb(JSONObject jSONObject) throws Exception {
        return zzgen.zzh(new zzfgy(new zzfgv(this.zzd), zzfgx.zza(new StringReader(jSONObject.toString()))));
    }
}
