package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzatq extends zzgzu implements zzhbf {
    private static final zzatq zzb;
    private int zzd;
    private zzhad zze = zzaN();
    private zzgyl zzf = zzgyl.zzb;
    private int zzg = 1;
    private int zzh = 1;

    static {
        zzatq zzatqVar = new zzatq();
        zzb = zzatqVar;
        zzgzu.zzaU(zzatq.class, zzatqVar);
    }

    private zzatq() {
    }

    public static zzatp zza() {
        return (zzatp) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzatq zzatqVar, zzgyl zzgylVar) {
        zzhad zzhadVar = zzatqVar.zze;
        if (!zzhadVar.zzc()) {
            zzatqVar.zze = zzgzu.zzaO(zzhadVar);
        }
        zzatqVar.zze.add(zzgylVar);
    }

    public static /* synthetic */ void zze(zzatq zzatqVar, zzgyl zzgylVar) {
        zzatqVar.zzd |= 1;
        zzatqVar.zzf = zzgylVar;
    }

    public static /* synthetic */ void zzf(zzatq zzatqVar, int i) {
        zzatqVar.zzh = 4;
        zzatqVar.zzd = 4 | zzatqVar.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003᠌\u0001\u0004᠌\u0002", new Object[]{"zzd", "zze", "zzf", "zzg", zzatk.zza, "zzh", zzati.zza});
        }
        if (i2 == 3) {
            return new zzatq();
        }
        if (i2 == 4) {
            return new zzatp(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
