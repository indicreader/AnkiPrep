package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfgp {
    public final List zza;
    public final String zzb;
    public final int zzc;
    public final String zzd;
    public final int zze;
    public final long zzf;
    public final boolean zzg;
    public final String zzh;
    public final zzfgo zzi;
    public final Bundle zzj;
    public final String zzk;
    public final String zzl;
    public final String zzm;
    public final JSONObject zzn;
    public final String zzo;
    public final int zzp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfgp(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        List emptyList = Collections.emptyList();
        Bundle bundle = new Bundle();
        JSONObject jSONObject = new JSONObject();
        jsonReader.beginObject();
        String str = "";
        String str2 = "";
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        zzfgo zzfgoVar = null;
        long j = 0;
        int i3 = 1;
        String str6 = str5;
        String str7 = str6;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            String str8 = str5;
            if ("nofill_urls".equals(nextName)) {
                emptyList = com.google.android.gms.ads.internal.util.zzbw.zzd(jsonReader);
            } else if ("refresh_interval".equals(nextName)) {
                i = jsonReader.nextInt();
            } else if ("gws_query_id".equals(nextName)) {
                str = jsonReader.nextString();
            } else if ("analytics_query_ad_event_id".equals(nextName)) {
                str6 = jsonReader.nextString();
            } else if ("is_idless".equals(nextName)) {
                z = jsonReader.nextBoolean();
            } else if ("response_code".equals(nextName)) {
                i2 = jsonReader.nextInt();
            } else if ("latency".equals(nextName)) {
                j = jsonReader.nextLong();
            } else {
                JSONObject jSONObject2 = jSONObject;
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzig)).booleanValue() || !"public_error".equals(nextName) || jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
                    if ("bidding_data".equals(nextName)) {
                        str7 = jsonReader.nextString();
                    } else {
                        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjU)).booleanValue() || !Objects.equals(nextName, "topics_should_record_observation")) {
                            if ("adapter_response_replacement_key".equals(nextName)) {
                                str5 = jsonReader.nextString();
                                jSONObject = jSONObject2;
                            } else if ("response_info_extras".equals(nextName)) {
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgQ)).booleanValue()) {
                                    try {
                                        Bundle zza = com.google.android.gms.ads.internal.util.zzbw.zza(com.google.android.gms.ads.internal.util.zzbw.zzh(jsonReader));
                                        if (zza != null) {
                                            bundle = zza;
                                        }
                                    } catch (IOException | JSONException unused) {
                                    } catch (IllegalStateException unused2) {
                                        jsonReader.skipValue();
                                    }
                                } else {
                                    jsonReader.skipValue();
                                }
                            } else if ("adRequestPostBody".equals(nextName)) {
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjg)).booleanValue()) {
                                    str3 = jsonReader.nextString();
                                } else {
                                    jsonReader.skipValue();
                                }
                            } else if ("adRequestUrl".equals(nextName)) {
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjg)).booleanValue()) {
                                    str2 = jsonReader.nextString();
                                } else {
                                    jsonReader.skipValue();
                                }
                            } else {
                                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjh)).booleanValue() || !Objects.equals(nextName, "adResponseBody")) {
                                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjh)).booleanValue() || !Objects.equals(nextName, "adResponseHeaders")) {
                                        if (Objects.equals(nextName, "max_parallel_renderers")) {
                                            i3 = Math.max(1, jsonReader.nextInt());
                                        } else {
                                            jsonReader.skipValue();
                                        }
                                        str5 = str8;
                                        jSONObject = jSONObject2;
                                    } else {
                                        jSONObject = com.google.android.gms.ads.internal.util.zzbw.zzh(jsonReader);
                                    }
                                } else {
                                    str4 = jsonReader.nextString();
                                }
                            }
                        } else {
                            jsonReader.nextBoolean();
                        }
                        str5 = str8;
                        jSONObject = jSONObject2;
                    }
                } else {
                    zzfgoVar = new zzfgo(jsonReader);
                }
                str5 = str8;
                jSONObject = jSONObject2;
            }
            str5 = str8;
        }
        jsonReader.endObject();
        this.zza = emptyList;
        this.zzc = i;
        this.zzb = str;
        this.zzd = str6;
        this.zze = i2;
        this.zzf = j;
        this.zzi = zzfgoVar;
        this.zzg = z;
        this.zzh = str7;
        this.zzj = bundle;
        this.zzk = str2;
        this.zzl = str3;
        this.zzm = str4;
        this.zzn = jSONObject;
        this.zzo = str5;
        this.zzp = ((Long) zzbif.zza.zze()).longValue() > 0 ? ((Long) zzbif.zza.zze()).intValue() : i3;
    }
}
