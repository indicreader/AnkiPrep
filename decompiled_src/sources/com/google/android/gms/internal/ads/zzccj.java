package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzccj {
    static Uri zza(String str, String str2, String str3) {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        if (indexOf != -1) {
            int i = indexOf + 1;
            return Uri.parse(str.substring(0, i) + str2 + "=" + str3 + "&" + str.substring(i));
        }
        return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
    }

    public static String zzb(Uri uri, Context context) {
        if (!com.google.android.gms.ads.internal.zzt.zzn().zzp(context)) {
            return uri.toString();
        }
        String zza = com.google.android.gms.ads.internal.zzt.zzn().zza(context);
        if (zza == null) {
            return uri.toString();
        }
        String str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzae);
        String uri2 = uri.toString();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzad)).booleanValue() || !uri2.contains(str)) {
            if (!TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
                return uri2;
            }
            String uri3 = zza(zzd(uri2, context), "fbs_aeid", zza).toString();
            com.google.android.gms.ads.internal.zzt.zzn().zzj(context, zza);
            return uri3;
        }
        com.google.android.gms.ads.internal.zzt.zzn().zzj(context, zza);
        return zzd(uri2, context).replace(str, zza);
    }

    public static String zzc(String str, Context context, boolean z) {
        String zza;
        if ((((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzal)).booleanValue() && !z) || !com.google.android.gms.ads.internal.zzt.zzn().zzp(context) || TextUtils.isEmpty(str) || (zza = com.google.android.gms.ads.internal.zzt.zzn().zza(context)) == null) {
            return str;
        }
        String str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzae);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzad)).booleanValue() || !str.contains(str2)) {
            if (str.contains("fbs_aeid")) {
                return str;
            }
            if (com.google.android.gms.ads.internal.zzt.zzp().zzi(str)) {
                com.google.android.gms.ads.internal.zzt.zzn().zzj(context, zza);
                return zza(zzd(str, context), "fbs_aeid", zza).toString();
            }
            if (!com.google.android.gms.ads.internal.zzt.zzp().zzj(str)) {
                return str;
            }
            com.google.android.gms.ads.internal.zzt.zzn().zzk(context, zza);
            return zza(zzd(str, context), "fbs_aeid", zza).toString();
        }
        if (com.google.android.gms.ads.internal.zzt.zzp().zzi(str)) {
            com.google.android.gms.ads.internal.zzt.zzn().zzj(context, zza);
            return zzd(str, context).replace(str2, zza);
        }
        if (!com.google.android.gms.ads.internal.zzt.zzp().zzj(str)) {
            return str;
        }
        com.google.android.gms.ads.internal.zzt.zzn().zzk(context, zza);
        return zzd(str, context).replace(str2, zza);
    }

    private static String zzd(String str, Context context) {
        String zzd = com.google.android.gms.ads.internal.zzt.zzn().zzd(context);
        String zzb = com.google.android.gms.ads.internal.zzt.zzn().zzb(context);
        if (!str.contains("gmp_app_id") && !TextUtils.isEmpty(zzd)) {
            str = zza(str, "gmp_app_id", zzd).toString();
        }
        return (str.contains("fbs_aiid") || TextUtils.isEmpty(zzb)) ? str : zza(str, "fbs_aiid", zzb).toString();
    }
}
