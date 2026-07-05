package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbij {
    public static final zzbhm zza = zzbhm.zzb("gads:dynamite_load:fail:sample_rate", WorkRequest.MIN_BACKOFF_MILLIS);
    public static final zzbhm zzb = zzbhm.zzd("gads:report_dynamite_crash_in_background_thread", false);
    public static final zzbhm zzc = zzbhm.zzc("gads:public_beta:traffic_multiplier", "1.0");
    public static final zzbhm zzd = zzbhm.zzc("gads:sdk_crash_report_class_prefix", "com.google.");
    public static final zzbhm zze = zzbhm.zzd("gads:sdk_crash_report_enabled", false);
    public static final zzbhm zzf = zzbhm.zzd("gads:sdk_crash_report_full_stacktrace", false);
    public static final zzbhm zzg = zzbhm.zza("gads:trapped_exception_sample_rate", 0.01d);
}
