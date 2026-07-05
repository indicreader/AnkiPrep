package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhgb extends zzgzu implements zzhbf {
    private static final zzhgb zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzhgb zzhgbVar = new zzhgb();
        zzb = zzhgbVar;
        zzgzu.zzaU(zzhgb.class, zzhgbVar);
    }

    private zzhgb() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzhgb();
        }
        zzhdp zzhdpVar = null;
        if (i2 == 4) {
            return new zzhga(zzhdpVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
