package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgvu extends zzgzu implements zzhbf {
    private static final zzgvu zzb;
    private static volatile zzhbl zzd;
    private int zze;
    private int zzf;
    private zzgvx zzg;

    static {
        zzgvu zzgvuVar = new zzgvu();
        zzb = zzgvuVar;
        zzgzu.zzaU(zzgvu.class, zzgvuVar);
    }

    private zzgvu() {
    }

    public static zzgvt zzc() {
        return (zzgvt) zzb.zzaA();
    }

    public static zzgvu zze(zzgyl zzgylVar, zzgzf zzgzfVar) throws zzhag {
        return (zzgvu) zzgzu.zzaG(zzb, zzgylVar, zzgzfVar);
    }

    public static zzhbl zzg() {
        return (zzhbl) zzb.zzb(7, null, null);
    }

    public static /* synthetic */ void zzh(zzgvu zzgvuVar, zzgvx zzgvxVar) {
        zzgvxVar.getClass();
        zzgvuVar.zzg = zzgvxVar;
        zzgvuVar.zze |= 1;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzgvx zzf() {
        zzgvx zzgvxVar = this.zzg;
        return zzgvxVar == null ? zzgvx.zze() : zzgvxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzgvu();
        }
        if (i2 == 4) {
            return new zzgvt(null);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzhbl zzhblVar = zzd;
        if (zzhblVar == null) {
            synchronized (zzgvu.class) {
                zzhblVar = zzd;
                if (zzhblVar == null) {
                    zzhblVar = new zzgzq(zzb);
                    zzd = zzhblVar;
                }
            }
        }
        return zzhblVar;
    }
}
