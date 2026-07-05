package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhel extends zzgzu implements zzhbf {
    private static final zzhel zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private boolean zzg;
    private long zzh;

    static {
        zzhel zzhelVar = new zzhel();
        zzb = zzhelVar;
        zzgzu.zzaU(zzhel.class, zzhelVar);
    }

    private zzhel() {
    }

    public static /* synthetic */ zzhel zza() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004ဂ\u0003", new Object[]{"zzd", "zze", zzhek.zza, "zzf", zzhei.zza, "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzhel();
        }
        if (i2 == 4) {
            return new zzhej(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
