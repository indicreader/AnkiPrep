package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhfv extends zzgzu implements zzhbf {
    private static final zzhfv zzb;
    private int zzd;
    private String zze = "";
    private zzgyl zzf = zzgyl.zzb;

    static {
        zzhfv zzhfvVar = new zzhfv();
        zzb = zzhfvVar;
        zzgzu.zzaU(zzhfv.class, zzhfvVar);
    }

    private zzhfv() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ည\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzhfv();
        }
        if (i2 == 4) {
            return new zzhfu(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
