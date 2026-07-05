package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzcsx implements zzbrq {
    private final Context zza;
    private final zzaym zzb;
    private final PowerManager zzc;

    public zzcsx(Context context, zzaym zzaymVar) {
        this.zza = context;
        this.zzb = zzaymVar;
        this.zzc = (PowerManager) context.getSystemService("power");
    }

    @Override // com.google.android.gms.internal.ads.zzbrq
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final JSONObject zzb(zzcta zzctaVar) throws JSONException {
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        zzayp zzaypVar = zzctaVar.zzf;
        if (zzaypVar == null) {
            jSONObject = new JSONObject();
        } else if (this.zzb.zzd() != null) {
            boolean z = zzaypVar.zza;
            JSONObject jSONObject3 = new JSONObject();
            JSONObject put = jSONObject3.put("afmaVersion", this.zzb.zzb()).put("activeViewJSON", this.zzb.zzd()).put("timestamp", zzctaVar.zzd).put("adFormat", this.zzb.zza()).put("hashCode", this.zzb.zzc()).put("isMraid", false);
            boolean z2 = zzctaVar.zzc;
            put.put("isStopped", false).put("isPaused", zzctaVar.zzb).put("isNative", this.zzb.zze()).put("isScreenOn", this.zzc.isInteractive()).put("appMuted", com.google.android.gms.ads.internal.zzt.zzr().zze()).put("appVolume", com.google.android.gms.ads.internal.zzt.zzr().zza()).put("deviceVolume", com.google.android.gms.ads.internal.util.zzac.zzb(this.zza.getApplicationContext()));
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfI)).booleanValue()) {
                AudioManager audioManager = (AudioManager) this.zza.getApplicationContext().getSystemService("audio");
                Integer valueOf = audioManager == null ? null : Integer.valueOf(audioManager.getMode());
                if (valueOf != null) {
                    jSONObject3.put("audioMode", valueOf);
                }
            }
            Rect rect = new Rect();
            Display defaultDisplay = ((WindowManager) this.zza.getSystemService("window")).getDefaultDisplay();
            rect.right = defaultDisplay.getWidth();
            rect.bottom = defaultDisplay.getHeight();
            jSONObject3.put("windowVisibility", zzaypVar.zzb).put("isAttachedToWindow", z).put("viewBox", new JSONObject().put("top", zzaypVar.zzc.top).put("bottom", zzaypVar.zzc.bottom).put("left", zzaypVar.zzc.left).put("right", zzaypVar.zzc.right)).put("adBox", new JSONObject().put("top", zzaypVar.zzd.top).put("bottom", zzaypVar.zzd.bottom).put("left", zzaypVar.zzd.left).put("right", zzaypVar.zzd.right)).put("globalVisibleBox", new JSONObject().put("top", zzaypVar.zze.top).put("bottom", zzaypVar.zze.bottom).put("left", zzaypVar.zze.left).put("right", zzaypVar.zze.right)).put("globalVisibleBoxVisible", zzaypVar.zzf).put("localVisibleBox", new JSONObject().put("top", zzaypVar.zzg.top).put("bottom", zzaypVar.zzg.bottom).put("left", zzaypVar.zzg.left).put("right", zzaypVar.zzg.right)).put("localVisibleBoxVisible", zzaypVar.zzh).put("hitBox", new JSONObject().put("top", zzaypVar.zzi.top).put("bottom", zzaypVar.zzi.bottom).put("left", zzaypVar.zzi.left).put("right", zzaypVar.zzi.right)).put("screenDensity", this.zza.getResources().getDisplayMetrics().density);
            jSONObject3.put("isVisible", zzctaVar.zza);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbp)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                List<Rect> list = zzaypVar.zzk;
                if (list != null) {
                    for (Rect rect2 : list) {
                        jSONArray2.put(new JSONObject().put("top", rect2.top).put("bottom", rect2.bottom).put("left", rect2.left).put("right", rect2.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzctaVar.zze)) {
                jSONObject3.put("doneReasonCode", "u");
            }
            jSONObject = jSONObject3;
        } else {
            throw new JSONException("Active view Info cannot be null.");
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
