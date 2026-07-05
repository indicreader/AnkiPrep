package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfro extends zzgzu implements zzhbf {
    private static final zzhaa zzb = new zzfrl();
    private static final zzfro zzd;
    private int zze;
    private zzgzz zzf = zzaJ();
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";

    static {
        zzfro zzfroVar = new zzfro();
        zzd = zzfroVar;
        zzgzu.zzaU(zzfro.class, zzfroVar);
    }

    private zzfro() {
    }

    public static zzfrn zza() {
        return (zzfrn) zzd.zzaA();
    }

    public static /* synthetic */ void zzd(zzfro zzfroVar, String str) {
        str.getClass();
        zzfroVar.zze |= 1;
        zzfroVar.zzg = str;
    }

    public static /* synthetic */ void zze(zzfro zzfroVar, int i) {
        zzgzz zzgzzVar = zzfroVar.zzf;
        if (!zzgzzVar.zzc()) {
            zzfroVar.zzf = zzgzu.zzaK(zzgzzVar);
        }
        zzfroVar.zzf.zzh(2);
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzd, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ࠞ\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zze", "zzf", zzfrm.zza, "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzfro();
        }
        if (i2 == 4) {
            return new zzfrn(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzd;
    }
}
