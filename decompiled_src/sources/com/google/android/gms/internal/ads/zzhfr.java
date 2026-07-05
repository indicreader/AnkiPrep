package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhfr extends zzgzu implements zzhbf {
    private static final zzhfr zzb;
    private int zzd;
    private long zzf;
    private boolean zzg;
    private int zzh;
    private String zze = "";
    private String zzi = "";
    private String zzj = "";

    static {
        zzhfr zzhfrVar = new zzhfr();
        zzb = zzhfrVar;
        zzgzu.zzaU(zzhfr.class, zzhfrVar);
    }

    private zzhfr() {
    }

    public static zzhfq zza() {
        return (zzhfq) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzhfr zzhfrVar, String str) {
        zzhfrVar.zzd |= 1;
        zzhfrVar.zze = str;
    }

    public static /* synthetic */ void zze(zzhfr zzhfrVar, long j) {
        zzhfrVar.zzd |= 2;
        zzhfrVar.zzf = j;
    }

    public static /* synthetic */ void zzf(zzhfr zzhfrVar, boolean z) {
        zzhfrVar.zzd |= 4;
        zzhfrVar.zzg = z;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005ဈ\u0004\u0006ဈ\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zzhfs.zza, "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzhfr();
        }
        if (i2 == 4) {
            return new zzhfq(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
