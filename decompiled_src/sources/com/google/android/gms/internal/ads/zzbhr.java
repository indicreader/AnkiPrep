package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbhr {
    public static final zzbhm zza = zzbhn.zzf("gads:consent:gmscore:dsid:enabled", true);
    public static final zzbhm zzb = zzbhn.zzf("gads:consent:gmscore:lat:enabled", true);
    public static final zzbhm zzc = new zzbhn("gads:consent:gmscore:backend_url", "https://adservice.google.com/getconfig/pubvendors", 4);
    public static final zzbhm zzd = new zzbhn("gads:consent:gmscore:time_out", Long.valueOf(WorkRequest.MIN_BACKOFF_MILLIS), 2);
    public static final zzbhm zze = zzbhn.zzf("gads:consent:gmscore:enabled", true);
}
