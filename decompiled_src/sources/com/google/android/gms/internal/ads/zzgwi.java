package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgwi extends zzgzu implements zzhbf {
    private static final zzgwi zzb;
    private int zzd;

    static {
        zzgwi zzgwiVar = new zzgwi();
        zzb = zzgwiVar;
        zzgzu.zzaU(zzgwi.class, zzgwiVar);
    }

    private zzgwi() {
    }

    public static zzgwi zzd() {
        return zzb;
    }

    public static zzgwi zze(zzgyl zzgylVar, zzgzf zzgzfVar) throws zzhag {
        return (zzgwi) zzgzu.zzaG(zzb, zzgylVar, zzgzfVar);
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzd"});
        }
        if (i2 == 3) {
            return new zzgwi();
        }
        if (i2 == 4) {
            return new zzgwh(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
