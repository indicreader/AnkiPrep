package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public class zzbhm {
    private final String zza;
    private final Object zzb;
    private final int zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbhm(String str, Object obj, int i) {
        this.zza = str;
        this.zzb = obj;
        this.zzc = i;
    }

    public static zzbhm zza(String str, double d) {
        return new zzbhm(str, Double.valueOf(d), 3);
    }

    public static zzbhm zzb(String str, long j) {
        return new zzbhm(str, Long.valueOf(j), 2);
    }

    public static zzbhm zzc(String str, String str2) {
        return new zzbhm(str, str2, 4);
    }

    public static zzbhm zzd(String str, boolean z) {
        return new zzbhm(str, Boolean.valueOf(z), 1);
    }

    public final Object zze() {
        zzbiq zza = zzbis.zza();
        if (zza == null) {
            if (zzbis.zzb() != null) {
                zzbis.zzb().zza();
            }
            return this.zzb;
        }
        int i = this.zzc - 1;
        if (i == 0) {
            return zza.zza(this.zza, ((Boolean) this.zzb).booleanValue());
        }
        if (i == 1) {
            return zza.zzc(this.zza, ((Long) this.zzb).longValue());
        }
        if (i != 2) {
            return zza.zzd(this.zza, (String) this.zzb);
        }
        return zza.zzb(this.zza, ((Double) this.zzb).doubleValue());
    }
}
