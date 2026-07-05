package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgsq extends zzgzu implements zzhbf {
    private static final zzgsq zzb;
    private static volatile zzhbl zzd;
    private int zze;
    private int zzf;
    private zzgsw zzg;
    private zzgui zzh;

    static {
        zzgsq zzgsqVar = new zzgsq();
        zzb = zzgsqVar;
        zzgzu.zzaU(zzgsq.class, zzgsqVar);
    }

    private zzgsq() {
    }

    public static zzgsp zzc() {
        return (zzgsp) zzb.zzaA();
    }

    public static zzgsq zze(zzgyl zzgylVar, zzgzf zzgzfVar) throws zzhag {
        return (zzgsq) zzgzu.zzaG(zzb, zzgylVar, zzgzfVar);
    }

    public static zzhbl zzh() {
        return (zzhbl) zzb.zzb(7, null, null);
    }

    public static /* synthetic */ void zzi(zzgsq zzgsqVar, zzgsw zzgswVar) {
        zzgswVar.getClass();
        zzgsqVar.zzg = zzgswVar;
        zzgsqVar.zze |= 1;
    }

    public static /* synthetic */ void zzj(zzgsq zzgsqVar, zzgui zzguiVar) {
        zzguiVar.getClass();
        zzgsqVar.zzh = zzguiVar;
        zzgsqVar.zze |= 2;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzgsw zzf() {
        zzgsw zzgswVar = this.zzg;
        return zzgswVar == null ? zzgsw.zze() : zzgswVar;
    }

    public final zzgui zzg() {
        zzgui zzguiVar = this.zzh;
        return zzguiVar == null ? zzgui.zze() : zzguiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzgsq();
        }
        if (i2 == 4) {
            return new zzgsp(null);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzhbl zzhblVar = zzd;
        if (zzhblVar == null) {
            synchronized (zzgsq.class) {
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
