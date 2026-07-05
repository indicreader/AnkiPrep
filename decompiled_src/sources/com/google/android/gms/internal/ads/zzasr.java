package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzasr extends zzgzu implements zzhbf {
    private static final zzasr zzb;
    private int zzd;
    private long zze = -1;

    static {
        zzasr zzasrVar = new zzasr();
        zzb = zzasrVar;
        zzgzu.zzaU(zzasr.class, zzasrVar);
    }

    private zzasr() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဂ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzasr();
        }
        zzasf zzasfVar = null;
        if (i2 == 4) {
            return new zzasq(zzasfVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
