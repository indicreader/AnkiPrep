package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfrs extends zzgzu implements zzhbf {
    private static final zzfrs zzb;
    private int zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private zzfro zzh;

    static {
        zzfrs zzfrsVar = new zzfrs();
        zzb = zzfrsVar;
        zzgzu.zzaU(zzfrs.class, zzfrsVar);
    }

    private zzfrs() {
    }

    public static zzfrq zza() {
        return (zzfrq) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzfrs zzfrsVar, String str) {
        str.getClass();
        zzfrsVar.zzd |= 2;
        zzfrsVar.zzf = str;
    }

    public static /* synthetic */ void zze(zzfrs zzfrsVar, zzfro zzfroVar) {
        zzfroVar.getClass();
        zzfrsVar.zzh = zzfroVar;
        zzfrsVar.zzd |= 8;
    }

    public static /* synthetic */ void zzf(zzfrs zzfrsVar, int i) {
        zzfrsVar.zze = 1;
        zzfrsVar.zzd = 1 | zzfrsVar.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zzd", "zze", zzfrr.zza, "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzfrs();
        }
        if (i2 == 4) {
            return new zzfrq(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
