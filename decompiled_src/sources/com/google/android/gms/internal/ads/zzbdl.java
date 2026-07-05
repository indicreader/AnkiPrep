package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbdl extends zzgzu implements zzhbf {
    private static final zzbdl zzb;
    private int zzd;
    private zzbdh zze;
    private zzhad zzf = zzaN();
    private int zzg;
    private zzben zzh;

    static {
        zzbdl zzbdlVar = new zzbdl();
        zzb = zzbdlVar;
        zzgzu.zzaU(zzbdl.class, zzbdlVar);
    }

    private zzbdl() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003᠌\u0001\u0004ဉ\u0002", new Object[]{"zzd", "zze", "zzf", zzbel.class, "zzg", zzbdc.zza, "zzh"});
        }
        if (i2 == 3) {
            return new zzbdl();
        }
        if (i2 == 4) {
            return new zzbdk(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
