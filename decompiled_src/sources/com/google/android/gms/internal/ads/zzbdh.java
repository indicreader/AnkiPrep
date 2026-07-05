package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbdh extends zzgzu implements zzhbf {
    private static final zzbdh zzb;
    private int zzd;
    private int zzf;
    private zzben zzh;
    private String zze = "";
    private zzgzz zzg = zzaJ();

    static {
        zzbdh zzbdhVar = new zzbdh();
        zzb = zzbdhVar;
        zzgzu.zzaU(zzbdh.class, zzbdhVar);
    }

    private zzbdh() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003\u0016\u0004ဉ\u0002", new Object[]{"zzd", "zze", "zzf", zzbdc.zza, "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzbdh();
        }
        if (i2 == 4) {
            return new zzbdg(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
