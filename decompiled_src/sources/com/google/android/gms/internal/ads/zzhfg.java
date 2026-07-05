package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhfg extends zzgzu implements zzhbf {
    private static final zzhfg zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private long zzg;
    private long zzh;

    static {
        zzhfg zzhfgVar = new zzhfg();
        zzb = zzhfgVar;
        zzgzu.zzaU(zzhfg.class, zzhfgVar);
    }

    private zzhfg() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003ဂ\u0002\u0004ဂ\u0003", new Object[]{"zzd", "zze", zzhff.zza, "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzhfg();
        }
        zzhdp zzhdpVar = null;
        if (i2 == 4) {
            return new zzhfe(zzhdpVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
