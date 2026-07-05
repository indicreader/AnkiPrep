package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbfu;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbrn;
import com.google.android.gms.internal.ads.zzbru;
import com.google.android.gms.internal.ads.zzcdf;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzcei;
import com.google.android.gms.internal.ads.zzcep;
import com.google.android.gms.internal.ads.zzces;
import com.google.android.gms.internal.ads.zzfmn;
import com.google.android.gms.internal.ads.zzfmo;
import com.google.android.gms.internal.ads.zzfnc;
import com.google.android.gms.internal.ads.zzgdu;
import com.google.android.gms.internal.ads.zzgen;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes3.dex */
public final class zze {
    private Context zza;
    private long zzb = 0;

    public final void zza(Context context, zzcei zzceiVar, String str, Runnable runnable, zzfnc zzfncVar) {
        zzb(context, zzceiVar, true, null, str, null, runnable, zzfncVar);
    }

    final void zzb(Context context, zzcei zzceiVar, boolean z, zzcdf zzcdfVar, String str, String str2, Runnable runnable, final zzfnc zzfncVar) {
        PackageInfo packageInfo;
        if (zzt.zzB().elapsedRealtime() - this.zzb < CoroutineLiveDataKt.DEFAULT_TIMEOUT) {
            zzcec.zzj("Not retrying to fetch app settings");
            return;
        }
        this.zzb = zzt.zzB().elapsedRealtime();
        if (zzcdfVar != null && !TextUtils.isEmpty(zzcdfVar.zzc())) {
            if (zzt.zzB().currentTimeMillis() - zzcdfVar.zza() <= ((Long) zzba.zzc().zza(zzbgc.zzdY)).longValue() && zzcdfVar.zzi()) {
                return;
            }
        }
        if (context == null) {
            zzcec.zzj("Context not provided to fetch application settings");
            return;
        }
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            this.zza = applicationContext;
            final zzfmo zza = zzfmn.zza(context, 4);
            zza.zzh();
            zzbrn zza2 = zzt.zzf().zza(this.zza, zzceiVar, zzfncVar).zza("google.afma.config.fetchAppSettings", zzbru.zza, zzbru.zza);
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("app_id", str);
                } else if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("ad_unit_id", str2);
                }
                jSONObject.put("is_init", z);
                jSONObject.put("pn", context.getPackageName());
                zzbfu zzbfuVar = zzbgc.zza;
                jSONObject.put("experiment_ids", TextUtils.join(",", zzba.zza().zza()));
                jSONObject.put("js", zzceiVar.zza);
                try {
                    ApplicationInfo applicationInfo = this.zza.getApplicationInfo();
                    if (applicationInfo != null && (packageInfo = Wrappers.packageManager(context).getPackageInfo(applicationInfo.packageName, 0)) != null) {
                        jSONObject.put("version", packageInfo.versionCode);
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    com.google.android.gms.ads.internal.util.zze.zza("Error fetching PackageInfo.");
                }
                ListenableFuture zzb = zza2.zzb(jSONObject);
                ListenableFuture zzn = zzgen.zzn(zzb, new zzgdu() { // from class: com.google.android.gms.ads.internal.zzd
                    @Override // com.google.android.gms.internal.ads.zzgdu
                    public final ListenableFuture zza(Object obj) {
                        JSONObject jSONObject2 = (JSONObject) obj;
                        boolean optBoolean = jSONObject2.optBoolean("isSuccessful", false);
                        if (optBoolean) {
                            zzt.zzo().zzi().zzu(jSONObject2.getString("appSettingsJson"));
                        }
                        zzfmo zzfmoVar = zza;
                        zzfnc zzfncVar2 = zzfnc.this;
                        zzfmoVar.zzf(optBoolean);
                        zzfncVar2.zzb(zzfmoVar.zzl());
                        return zzgen.zzh(null);
                    }
                }, zzcep.zzf);
                if (runnable != null) {
                    zzb.addListener(runnable, zzcep.zzf);
                }
                zzces.zza(zzn, "ConfigLoader.maybeFetchNewAppSettings");
                return;
            } catch (Exception e) {
                zzcec.zzh("Error requesting application settings", e);
                zza.zzg(e);
                zza.zzf(false);
                zzfncVar.zzb(zza.zzl());
                return;
            }
        }
        zzcec.zzj("App settings could not be fetched. Required parameters missing");
    }

    public final void zzc(Context context, zzcei zzceiVar, String str, zzcdf zzcdfVar, zzfnc zzfncVar) {
        zzb(context, zzceiVar, false, zzcdfVar, zzcdfVar != null ? zzcdfVar.zzb() : null, str, null, zzfncVar);
    }
}
