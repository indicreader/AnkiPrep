package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbey extends zzgzu implements zzhbf {
    private static final zzbey zzb;
    private int zzd;
    private zzbep zze;
    private int zzf = 1000;
    private zzbew zzg;
    private zzben zzh;

    static {
        zzbey zzbeyVar = new zzbey();
        zzb = zzbeyVar;
        zzgzu.zzaU(zzbey.class, zzbeyVar);
    }

    private zzbey() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002᠌\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzd", "zze", "zzf", zzbdc.zza, "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzbey();
        }
        if (i2 == 4) {
            return new zzbex(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
