package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbda extends zzgzu implements zzhbf {
    private static final zzbda zzb;
    private int zzd;
    private int zze;
    private zzbep zzf;
    private String zzg = "";
    private String zzh = "";

    static {
        zzbda zzbdaVar = new zzbda();
        zzb = zzbdaVar;
        zzgzu.zzaU(zzbda.class, zzbdaVar);
    }

    private zzbda() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0004\u0000\u0001\u0005\b\u0004\u0000\u0000\u0000\u0005᠌\u0000\u0006ဉ\u0001\u0007ဈ\u0002\bဈ\u0003", new Object[]{"zzd", "zze", zzbcz.zza, "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzbda();
        }
        if (i2 == 4) {
            return new zzbcy(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
