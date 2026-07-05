package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhdv extends zzgzu implements zzhbf {
    private static final zzhdv zzb;
    private int zzd;
    private int zze;
    private long zzf;
    private zzgyl zzg = zzgyl.zzb;

    static {
        zzhdv zzhdvVar = new zzhdv();
        zzb = zzhdvVar;
        zzgzu.zzaU(zzhdv.class, zzhdvVar);
    }

    private zzhdv() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003ည\u0002", new Object[]{"zzd", "zze", zzhdu.zza, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzhdv();
        }
        if (i2 == 4) {
            return new zzhdt(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
