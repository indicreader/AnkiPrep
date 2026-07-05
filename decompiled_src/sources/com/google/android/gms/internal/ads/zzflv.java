package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import coil.disk.DiskLruCache;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzflv {
    private final HashMap zza;
    private final zzfmb zzb;

    private zzflv() {
        HashMap hashMap = new HashMap();
        this.zza = hashMap;
        this.zzb = new zzfmb(com.google.android.gms.ads.internal.zzt.zzB());
        hashMap.put("new_csi", DiskLruCache.VERSION);
    }

    public static zzflv zzb(String str) {
        zzflv zzflvVar = new zzflv();
        zzflvVar.zza.put("action", str);
        return zzflvVar;
    }

    public static zzflv zzc(String str) {
        zzflv zzflvVar = new zzflv();
        zzflvVar.zza.put("request_id", str);
        return zzflvVar;
    }

    public final zzflv zza(String str, String str2) {
        this.zza.put(str, str2);
        return this;
    }

    public final zzflv zzd(String str) {
        this.zzb.zzb(str);
        return this;
    }

    public final zzflv zze(String str, String str2) {
        this.zzb.zzc(str, str2);
        return this;
    }

    public final zzflv zzf(zzfgm zzfgmVar) {
        this.zza.put("aai", zzfgmVar.zzx);
        return this;
    }

    public final zzflv zzg(zzfgp zzfgpVar) {
        if (!TextUtils.isEmpty(zzfgpVar.zzb)) {
            this.zza.put("gqi", zzfgpVar.zzb);
        }
        return this;
    }

    public final zzflv zzh(zzfgy zzfgyVar, zzcdp zzcdpVar) {
        zzfgx zzfgxVar = zzfgyVar.zzb;
        zzg(zzfgxVar.zzb);
        if (!zzfgxVar.zza.isEmpty()) {
            switch (((zzfgm) zzfgxVar.zza.get(0)).zzb) {
                case 1:
                    this.zza.put("ad_format", "banner");
                    break;
                case 2:
                    this.zza.put("ad_format", "interstitial");
                    break;
                case 3:
                    this.zza.put("ad_format", "native_express");
                    break;
                case 4:
                    this.zza.put("ad_format", "native_advanced");
                    break;
                case 5:
                    this.zza.put("ad_format", "rewarded");
                    break;
                case 6:
                    this.zza.put("ad_format", "app_open_ad");
                    if (zzcdpVar != null) {
                        this.zza.put("as", true != zzcdpVar.zzm() ? "0" : DiskLruCache.VERSION);
                        break;
                    }
                    break;
                default:
                    this.zza.put("ad_format", EnvironmentCompat.MEDIA_UNKNOWN);
                    break;
            }
        }
        return this;
    }

    public final zzflv zzi(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zza.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zza.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
        return this;
    }

    public final Map zzj() {
        HashMap hashMap = new HashMap(this.zza);
        for (zzfma zzfmaVar : this.zzb.zza()) {
            hashMap.put(zzfmaVar.zza, zzfmaVar.zzb);
        }
        return hashMap;
    }
}
