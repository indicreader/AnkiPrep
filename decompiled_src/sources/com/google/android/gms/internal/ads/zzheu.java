package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzheu extends zzgzu implements zzhbf {
    private static final zzheu zzb;
    private int zzd;
    private int zze;
    private zzgyl zzf = zzgyl.zzb;
    private zzgyl zzg = zzgyl.zzb;

    static {
        zzheu zzheuVar = new zzheu();
        zzb = zzheuVar;
        zzgzu.zzaU(zzheu.class, zzheuVar);
    }

    private zzheu() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzheu();
        }
        if (i2 == 4) {
            return new zzhet(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
