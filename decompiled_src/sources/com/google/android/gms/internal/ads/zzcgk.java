package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcgk {
    public final boolean zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final String zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final boolean zzj;
    public final boolean zzk;
    public final boolean zzl;
    public final boolean zzm;
    public final long zzn;
    public final long zzo;

    public zzcgk(String str) {
        String string;
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.zza = zza(jSONObject, "aggressive_media_codec_release", zzbgc.zzJ);
        this.zzb = zzb(jSONObject, "byte_buffer_precache_limit", zzbgc.zzl);
        this.zzc = zzb(jSONObject, "exo_cache_buffer_size", zzbgc.zzw);
        this.zzd = zzb(jSONObject, "exo_connect_timeout_millis", zzbgc.zzh);
        zzbfu zzbfuVar = zzbgc.zzg;
        if (jSONObject != null) {
            try {
                string = jSONObject.getString("exo_player_version");
            } catch (JSONException unused2) {
            }
            this.zze = string;
            this.zzf = zzb(jSONObject, "exo_read_timeout_millis", zzbgc.zzi);
            this.zzg = zzb(jSONObject, "load_check_interval_bytes", zzbgc.zzj);
            this.zzh = zzb(jSONObject, "player_precache_limit", zzbgc.zzk);
            this.zzi = zzb(jSONObject, "socket_receive_buffer_size", zzbgc.zzm);
            this.zzj = zza(jSONObject, "use_cache_data_source", zzbgc.zzei);
            zzb(jSONObject, "min_retry_count", zzbgc.zzn);
            this.zzk = zza(jSONObject, "treat_load_exception_as_non_fatal", zzbgc.zzq);
            this.zzl = zza(jSONObject, "enable_multiple_video_playback", zzbgc.zzbR);
            this.zzm = zza(jSONObject, "use_range_http_data_source", zzbgc.zzbT);
            this.zzn = zzc(jSONObject, "range_http_data_source_high_water_mark", zzbgc.zzbU);
            this.zzo = zzc(jSONObject, "range_http_data_source_low_water_mark", zzbgc.zzbV);
        }
        string = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbfuVar);
        this.zze = string;
        this.zzf = zzb(jSONObject, "exo_read_timeout_millis", zzbgc.zzi);
        this.zzg = zzb(jSONObject, "load_check_interval_bytes", zzbgc.zzj);
        this.zzh = zzb(jSONObject, "player_precache_limit", zzbgc.zzk);
        this.zzi = zzb(jSONObject, "socket_receive_buffer_size", zzbgc.zzm);
        this.zzj = zza(jSONObject, "use_cache_data_source", zzbgc.zzei);
        zzb(jSONObject, "min_retry_count", zzbgc.zzn);
        this.zzk = zza(jSONObject, "treat_load_exception_as_non_fatal", zzbgc.zzq);
        this.zzl = zza(jSONObject, "enable_multiple_video_playback", zzbgc.zzbR);
        this.zzm = zza(jSONObject, "use_range_http_data_source", zzbgc.zzbT);
        this.zzn = zzc(jSONObject, "range_http_data_source_high_water_mark", zzbgc.zzbU);
        this.zzo = zzc(jSONObject, "range_http_data_source_low_water_mark", zzbgc.zzbV);
    }

    private static final boolean zza(JSONObject jSONObject, String str, zzbfu zzbfuVar) {
        boolean booleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbfuVar)).booleanValue();
        if (jSONObject == null) {
            return booleanValue;
        }
        try {
            return jSONObject.getBoolean(str);
        } catch (JSONException unused) {
            return booleanValue;
        }
    }

    private static final int zzb(JSONObject jSONObject, String str, zzbfu zzbfuVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
            }
        }
        return ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbfuVar)).intValue();
    }

    private static final long zzc(JSONObject jSONObject, String str, zzbfu zzbfuVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getLong(str);
            } catch (JSONException unused) {
            }
        }
        return ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbfuVar)).longValue();
    }
}
