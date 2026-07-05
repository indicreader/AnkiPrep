package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbdj extends zzgzu implements zzhbf {
    private static final zzbdj zzb;
    private int zzd;
    private int zze;
    private zzgzz zzf = zzaJ();

    static {
        zzbdj zzbdjVar = new zzbdj();
        zzb = zzbdjVar;
        zzgzu.zzaU(zzbdj.class, zzbdjVar);
    }

    private zzbdj() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u0016", new Object[]{"zzd", "zze", zzbdc.zza, "zzf"});
        }
        if (i2 == 3) {
            return new zzbdj();
        }
        if (i2 == 4) {
            return new zzbdi(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
