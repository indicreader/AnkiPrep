package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhdm extends zzgzu implements zzhbf {
    private static final zzhdm zzb;
    private int zzd;
    private long zze;
    private long zzf;

    static {
        zzhdm zzhdmVar = new zzhdm();
        zzb = zzhdmVar;
        zzgzu.zzaU(zzhdm.class, zzhdmVar);
    }

    private zzhdm() {
    }

    public static zzhdl zza() {
        return (zzhdl) zzb.zzaA();
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003\u0002", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzhdm();
        }
        if (i2 == 4) {
            return new zzhdl(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
