package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhfj extends zzgzu implements zzhbf {
    private static final zzhfj zzb;
    private int zzd;
    private int zze;
    private String zzf = "";
    private zzgyl zzg = zzgyl.zzb;
    private zzgyl zzh = zzgyl.zzb;

    static {
        zzhfj zzhfjVar = new zzhfj();
        zzb = zzhfjVar;
        zzgzu.zzaU(zzhfj.class, zzhfjVar);
    }

    private zzhfj() {
    }

    public static zzhfh zza() {
        return (zzhfh) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzhfj zzhfjVar, String str) {
        zzhfjVar.zzd |= 2;
        zzhfjVar.zzf = "image/png";
    }

    public static /* synthetic */ void zze(zzhfj zzhfjVar, zzgyl zzgylVar) {
        zzgylVar.getClass();
        zzhfjVar.zzd |= 4;
        zzhfjVar.zzg = zzgylVar;
    }

    public static /* synthetic */ void zzf(zzhfj zzhfjVar, int i) {
        zzhfjVar.zze = 1;
        zzhfjVar.zzd = 1 | zzhfjVar.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzd", "zze", zzhfi.zza, "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzhfj();
        }
        if (i2 == 4) {
            return new zzhfh(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
