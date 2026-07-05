package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgtf extends zzgzu implements zzhbf {
    private static final zzgtf zzb;
    private static volatile zzhbl zzd;
    private int zze;
    private int zzf;
    private zzgtl zzg;
    private zzgyl zzh = zzgyl.zzb;

    static {
        zzgtf zzgtfVar = new zzgtf();
        zzb = zzgtfVar;
        zzgzu.zzaU(zzgtf.class, zzgtfVar);
    }

    private zzgtf() {
    }

    public static zzgte zzc() {
        return (zzgte) zzb.zzaA();
    }

    public static zzgtf zze(zzgyl zzgylVar, zzgzf zzgzfVar) throws zzhag {
        return (zzgtf) zzgzu.zzaG(zzb, zzgylVar, zzgzfVar);
    }

    public static zzhbl zzh() {
        return (zzhbl) zzb.zzb(7, null, null);
    }

    public static /* synthetic */ void zzi(zzgtf zzgtfVar, zzgtl zzgtlVar) {
        zzgtlVar.getClass();
        zzgtfVar.zzg = zzgtlVar;
        zzgtfVar.zze |= 1;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzgtl zzf() {
        zzgtl zzgtlVar = this.zzg;
        return zzgtlVar == null ? zzgtl.zze() : zzgtlVar;
    }

    public final zzgyl zzg() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzgtf();
        }
        if (i2 == 4) {
            return new zzgte(null);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzhbl zzhblVar = zzd;
        if (zzhblVar == null) {
            synchronized (zzgtf.class) {
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
