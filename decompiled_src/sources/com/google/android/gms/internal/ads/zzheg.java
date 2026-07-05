package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzheg extends zzgzu implements zzhbf {
    private static final zzheg zzb;
    private int zzd;
    private zzgyl zze = zzgyl.zzb;

    static {
        zzheg zzhegVar = new zzheg();
        zzb = zzhegVar;
        zzgzu.zzaU(zzheg.class, zzhegVar);
    }

    private zzheg() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ည\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzheg();
        }
        if (i2 == 4) {
            return new zzhef(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
