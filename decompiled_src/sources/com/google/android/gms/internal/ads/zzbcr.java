package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbcr extends zzgzu implements zzhbf {
    private static final zzbcr zzb;
    private int zzd;
    private String zze = "";
    private zzhad zzf = zzaN();
    private int zzg;

    static {
        zzbcr zzbcrVar = new zzbcr();
        zzb = zzbcrVar;
        zzgzu.zzaU(zzbcr.class, zzbcrVar);
    }

    private zzbcr() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003᠌\u0001", new Object[]{"zzd", "zze", "zzf", zzbcp.class, "zzg", zzbdc.zza});
        }
        if (i2 == 3) {
            return new zzbcr();
        }
        if (i2 == 4) {
            return new zzbcq(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
