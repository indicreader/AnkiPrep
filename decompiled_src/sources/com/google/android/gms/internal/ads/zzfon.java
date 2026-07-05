package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfon {
    private final String zza;
    private final String zzb;

    private zzfon(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public static zzfon zza(String str, String str2) {
        zzfpt.zza(str, "Name is null or empty");
        zzfpt.zza(str2, "Version is null or empty");
        return new zzfon(str, str2);
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }
}
