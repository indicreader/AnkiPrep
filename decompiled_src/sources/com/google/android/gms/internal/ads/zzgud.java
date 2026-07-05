package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgud extends zzgzu implements zzhbf {
    private static final zzgud zzb;

    static {
        zzgud zzgudVar = new zzgud();
        zzb = zzgudVar;
        zzgzu.zzaU(zzgud.class, zzgudVar);
    }

    private zzgud() {
    }

    public static zzgud zzc() {
        return zzb;
    }

    public static zzgud zzd(zzgyl zzgylVar, zzgzf zzgzfVar) throws zzhag {
        return (zzgud) zzgzu.zzaG(zzb, zzgylVar, zzgzfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0000", null);
        }
        if (i2 == 3) {
            return new zzgud();
        }
        if (i2 == 4) {
            return new zzguc(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
