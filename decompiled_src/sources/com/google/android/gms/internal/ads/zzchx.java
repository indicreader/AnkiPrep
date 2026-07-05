package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzchx implements zzbng {
    private static final Integer zzb(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt((String) map.get(str)));
        } catch (NumberFormatException unused) {
            zzcec.zzj("Precache invalid numeric parameter '" + str + "': " + ((String) map.get(str)));
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzchw zzchwVar;
        zzcgl zzcglVar = (zzcgl) obj;
        if (com.google.android.gms.ads.internal.util.zze.zzm(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            zzcec.zze("Precache GMSG: ".concat(jSONObject.toString()));
        }
        zzchp zzy = com.google.android.gms.ads.internal.zzt.zzy();
        if (map.containsKey("abort")) {
            if (zzy.zzd(zzcglVar)) {
                return;
            }
            zzcec.zzj("Precache abort but no precache task running.");
            return;
        }
        String str = (String) map.get("src");
        Integer zzb = zzb(map, "periodicReportIntervalMs");
        Integer zzb2 = zzb(map, "exoPlayerRenderingIntervalMs");
        Integer zzb3 = zzb(map, "exoPlayerIdleIntervalMs");
        zzcgk zzcgkVar = new zzcgk((String) map.get("flags"));
        boolean z = zzcgkVar.zzl;
        if (str != null) {
            String[] strArr = {str};
            String str2 = (String) map.get("demuxed");
            zzcho zzchoVar = null;
            if (str2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str2);
                    String[] strArr2 = new String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr2[i] = jSONArray.getString(i);
                    }
                    strArr = strArr2;
                } catch (JSONException unused) {
                    zzcec.zzj("Malformed demuxed URL list for precache: ".concat(str2));
                    strArr = null;
                }
            }
            if (strArr == null) {
                strArr = new String[]{str};
            }
            if (z) {
                Iterator it = zzy.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    zzcho zzchoVar2 = (zzcho) it.next();
                    if (zzchoVar2.zza == zzcglVar && str.equals(zzchoVar2.zze())) {
                        zzchoVar = zzchoVar2;
                        break;
                    }
                }
            } else {
                zzchoVar = zzy.zza(zzcglVar);
            }
            if (zzchoVar != null) {
                zzcec.zzj("Precache task is already running.");
                return;
            }
            if (zzcglVar.zzj() == null) {
                zzcec.zzj("Precache requires a dependency provider.");
                return;
            }
            Integer zzb4 = zzb(map, "player");
            if (zzb4 == null) {
                zzb4 = 0;
            }
            if (zzb != null) {
                zzcglVar.zzA(zzb.intValue());
            }
            if (zzb2 != null) {
                zzcglVar.zzy(zzb2.intValue());
            }
            if (zzb3 != null) {
                zzcglVar.zzx(zzb3.intValue());
            }
            int intValue = zzb4.intValue();
            zzchi zzchiVar = zzcglVar.zzj().zzb;
            if (intValue > 0) {
                int i2 = zzcgkVar.zzh;
                int zzu = zzcgc.zzu();
                if (zzu < i2) {
                    zzchwVar = new zzcif(zzcglVar, zzcgkVar);
                } else if (zzu < zzcgkVar.zzb) {
                    zzchwVar = new zzcic(zzcglVar, zzcgkVar);
                } else {
                    zzchwVar = new zzcia(zzcglVar);
                }
            } else {
                zzchwVar = new zzchz(zzcglVar);
            }
            new zzcho(zzcglVar, zzchwVar, str, strArr).zzb();
        } else {
            zzcho zza = zzy.zza(zzcglVar);
            if (zza == null) {
                zzcec.zzj("Precache must specify a source.");
                return;
            }
            zzchwVar = zza.zzb;
        }
        Integer zzb5 = zzb(map, "minBufferMs");
        if (zzb5 != null) {
            zzchwVar.zzs(zzb5.intValue());
        }
        Integer zzb6 = zzb(map, "maxBufferMs");
        if (zzb6 != null) {
            zzchwVar.zzr(zzb6.intValue());
        }
        Integer zzb7 = zzb(map, "bufferForPlaybackMs");
        if (zzb7 != null) {
            zzchwVar.zzp(zzb7.intValue());
        }
        Integer zzb8 = zzb(map, "bufferForPlaybackAfterRebufferMs");
        if (zzb8 != null) {
            zzchwVar.zzq(zzb8.intValue());
        }
    }
}
