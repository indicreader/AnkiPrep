package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzchk implements zzbng {
    private boolean zza;

    private static int zzb(Context context, Map map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                com.google.android.gms.ads.internal.client.zzay.zzb();
                i = zzcdv.zzx(context, Integer.parseInt(str2));
            } catch (NumberFormatException unused) {
                zzcec.zzj("Could not parse " + str + " in a video GMSG: " + str2);
            }
        }
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Parse pixels for " + str + ", got string " + str2 + ", int " + i + ".");
        }
        return i;
    }

    private static void zzc(zzcfz zzcfzVar, Map map) {
        String str = (String) map.get("minBufferMs");
        String str2 = (String) map.get("maxBufferMs");
        String str3 = (String) map.get("bufferForPlaybackMs");
        String str4 = (String) map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = (String) map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzcfzVar.zzB(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                zzcec.zzj(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", str, str2));
                return;
            }
        }
        if (str2 != null) {
            zzcfzVar.zzA(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzcfzVar.zzy(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzcfzVar.zzz(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzcfzVar.zzD(Integer.parseInt(str5));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        int min;
        int min2;
        zzcgl zzcglVar = (zzcgl) obj;
        String str = (String) map.get("action");
        if (str == null) {
            zzcec.zzj("Action missing from video GMSG.");
            return;
        }
        Integer num = null;
        Integer valueOf = map.containsKey("playerId") ? Integer.valueOf(Integer.parseInt((String) map.get("playerId"))) : null;
        Integer zzb = zzcglVar.zzo() != null ? zzcglVar.zzo().zzb() : null;
        if (valueOf == null || zzb == null || valueOf.equals(zzb) || str.equals("load")) {
            if (com.google.android.gms.ads.internal.util.zze.zzm(3)) {
                JSONObject jSONObject = new JSONObject(map);
                jSONObject.remove("google.afma.Notify_dt");
                zzcec.zze("Video GMSG: " + str + " " + jSONObject.toString());
            }
            if ("background".equals(str)) {
                String str2 = (String) map.get("color");
                if (TextUtils.isEmpty(str2)) {
                    zzcec.zzj("Color parameter missing from background video GMSG.");
                    return;
                }
                try {
                    zzcglVar.setBackgroundColor(Color.parseColor(str2));
                    return;
                } catch (IllegalArgumentException unused) {
                    zzcec.zzj("Invalid color parameter in background video GMSG.");
                    return;
                }
            }
            if ("playerBackground".equals(str)) {
                String str3 = (String) map.get("color");
                if (TextUtils.isEmpty(str3)) {
                    zzcec.zzj("Color parameter missing from playerBackground video GMSG.");
                    return;
                }
                try {
                    zzcglVar.zzB(Color.parseColor(str3));
                    return;
                } catch (IllegalArgumentException unused2) {
                    zzcec.zzj("Invalid color parameter in playerBackground video GMSG.");
                    return;
                }
            }
            int i = 0;
            if ("decoderProps".equals(str)) {
                String str4 = (String) map.get("mimeTypes");
                if (str4 == null) {
                    zzcec.zzj("No MIME types specified for decoder properties inspection.");
                    HashMap hashMap = new HashMap();
                    hashMap.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
                    hashMap.put("error", "missingMimeTypes");
                    zzcglVar.zzd("onVideoEvent", hashMap);
                    return;
                }
                HashMap hashMap2 = new HashMap();
                String[] split = str4.split(",");
                int length = split.length;
                while (i < length) {
                    String str5 = split[i];
                    hashMap2.put(str5, com.google.android.gms.ads.internal.util.zzcn.zza(str5.trim()));
                    i++;
                }
                HashMap hashMap3 = new HashMap();
                hashMap3.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
                hashMap3.put("mimeTypes", hashMap2);
                zzcglVar.zzd("onVideoEvent", hashMap3);
                return;
            }
            zzcga zzo = zzcglVar.zzo();
            if (zzo == null) {
                zzcec.zzj("Could not get underlay container for a video GMSG.");
                return;
            }
            boolean equals = "new".equals(str);
            boolean equals2 = "position".equals(str);
            if (equals || equals2) {
                Context context = zzcglVar.getContext();
                int zzb2 = zzb(context, map, "x", 0);
                int zzb3 = zzb(context, map, "y", 0);
                int zzb4 = zzb(context, map, "w", -1);
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdK)).booleanValue()) {
                    if (com.google.android.gms.ads.internal.util.zze.zzc()) {
                        com.google.android.gms.ads.internal.util.zze.zza("Calculate width with original width " + zzb4 + ", videoHost.getVideoBoundingWidth() " + zzcglVar.zzh() + ", x " + zzb2 + ".");
                    }
                    min = Math.min(zzb4, zzcglVar.zzh() - zzb2);
                } else if (zzb4 == -1) {
                    min = zzcglVar.zzh();
                } else {
                    min = Math.min(zzb4, zzcglVar.zzh());
                }
                int i2 = min;
                int zzb5 = zzb(context, map, "h", -1);
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdK)).booleanValue()) {
                    if (com.google.android.gms.ads.internal.util.zze.zzc()) {
                        com.google.android.gms.ads.internal.util.zze.zza("Calculate height with original height " + zzb5 + ", videoHost.getVideoBoundingHeight() " + zzcglVar.zzg() + ", y " + zzb3 + ".");
                    }
                    min2 = Math.min(zzb5, zzcglVar.zzg() - zzb3);
                } else if (zzb5 == -1) {
                    min2 = zzcglVar.zzg();
                } else {
                    min2 = Math.min(zzb5, zzcglVar.zzg());
                }
                int i3 = min2;
                try {
                    i = Integer.parseInt((String) map.get("player"));
                } catch (NumberFormatException unused3) {
                }
                int i4 = i;
                boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
                if (!equals || zzo.zza() != null) {
                    zzo.zzc(zzb2, zzb3, i2, i3);
                    return;
                }
                zzo.zzd(zzb2, zzb3, i2, i3, i4, parseBoolean, new zzcgk((String) map.get("flags")));
                zzcfz zza = zzo.zza();
                if (zza != null) {
                    zzc(zza, map);
                    return;
                }
                return;
            }
            zzcki zzq = zzcglVar.zzq();
            if (zzq != null) {
                if ("timeupdate".equals(str)) {
                    String str6 = (String) map.get("currentTime");
                    if (str6 == null) {
                        zzcec.zzj("currentTime parameter missing from timeupdate video GMSG.");
                        return;
                    }
                    try {
                        zzq.zzt(Float.parseFloat(str6));
                        return;
                    } catch (NumberFormatException unused4) {
                        zzcec.zzj("Could not parse currentTime parameter from timeupdate video GMSG: ".concat(str6));
                        return;
                    }
                }
                if ("skip".equals(str)) {
                    zzq.zzu();
                    return;
                }
            }
            zzcfz zza2 = zzo.zza();
            if (zza2 == null) {
                HashMap hashMap4 = new HashMap();
                hashMap4.put(NotificationCompat.CATEGORY_EVENT, "no_video_view");
                zzcglVar.zzd("onVideoEvent", hashMap4);
                return;
            }
            if ("click".equals(str)) {
                Context context2 = zzcglVar.getContext();
                int zzb6 = zzb(context2, map, "x", 0);
                float zzb7 = zzb(context2, map, "y", 0);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, zzb6, zzb7, 0);
                zza2.zzx(obtain);
                obtain.recycle();
                return;
            }
            if ("currentTime".equals(str)) {
                String str7 = (String) map.get("time");
                if (str7 == null) {
                    zzcec.zzj("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try {
                    zza2.zzw((int) (Float.parseFloat(str7) * 1000.0f));
                    return;
                } catch (NumberFormatException unused5) {
                    zzcec.zzj("Could not parse time parameter from currentTime video GMSG: ".concat(str7));
                    return;
                }
            }
            if ("hide".equals(str)) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzG)).booleanValue()) {
                    zza2.setVisibility(8);
                    return;
                } else {
                    zza2.setVisibility(4);
                    return;
                }
            }
            if ("load".equals(str)) {
                zza2.zzr(valueOf);
                return;
            }
            if ("loadControl".equals(str)) {
                zzc(zza2, map);
                return;
            }
            if ("muted".equals(str)) {
                if (Boolean.parseBoolean((String) map.get("muted"))) {
                    zza2.zzs();
                    return;
                } else {
                    zza2.zzI();
                    return;
                }
            }
            if ("pause".equals(str)) {
                zza2.zzu();
                return;
            }
            if ("play".equals(str)) {
                zza2.zzv();
                return;
            }
            if ("show".equals(str)) {
                zza2.setVisibility(0);
                return;
            }
            if ("src".equals(str)) {
                String str8 = (String) map.get("src");
                if (map.containsKey("periodicReportIntervalMs")) {
                    try {
                        num = Integer.valueOf(Integer.parseInt((String) map.get("periodicReportIntervalMs")));
                    } catch (NumberFormatException unused6) {
                        zzcec.zzj("Video gmsg invalid numeric parameter 'periodicReportIntervalMs': ".concat(String.valueOf((String) map.get("periodicReportIntervalMs"))));
                    }
                }
                String[] strArr = {str8};
                String str9 = (String) map.get("demuxed");
                if (str9 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str9);
                        String[] strArr2 = new String[jSONArray.length()];
                        while (i < jSONArray.length()) {
                            strArr2[i] = jSONArray.getString(i);
                            i++;
                        }
                        strArr = strArr2;
                    } catch (JSONException unused7) {
                        zzcec.zzj("Malformed demuxed URL list for playback: ".concat(str9));
                        strArr = new String[]{str8};
                    }
                }
                if (num != null) {
                    zzcglVar.zzA(num.intValue());
                }
                zza2.zzE(str8, strArr);
                return;
            }
            if ("touchMove".equals(str)) {
                Context context3 = zzcglVar.getContext();
                zza2.zzH(zzb(context3, map, "dx", 0), zzb(context3, map, "dy", 0));
                if (this.zza) {
                    return;
                }
                zzcglVar.zzu();
                this.zza = true;
                return;
            }
            if ("volume".equals(str)) {
                String str10 = (String) map.get("volume");
                if (str10 == null) {
                    zzcec.zzj("Level parameter missing from volume video GMSG.");
                    return;
                }
                try {
                    zza2.zzG(Float.parseFloat(str10));
                    return;
                } catch (NumberFormatException unused8) {
                    zzcec.zzj("Could not parse volume parameter from volume video GMSG: ".concat(str10));
                    return;
                }
            }
            if ("watermark".equals(str)) {
                zza2.zzn();
                return;
            } else {
                zzcec.zzj("Unknown video action: ".concat(str));
                return;
            }
        }
        zzcec.zzi(String.format(Locale.US, "Event intended for player %s, but sent to player %d - event ignored", valueOf, zzb));
    }
}
