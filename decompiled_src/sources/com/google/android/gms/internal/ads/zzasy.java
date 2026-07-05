package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzasy extends zzgzu implements zzhbf {
    private static final zzasy zzb;
    private int zzd;
    private long zze = -1;
    private int zzf = 1000;

    static {
        zzasy zzasyVar = new zzasy();
        zzb = zzasyVar;
        zzgzu.zzaU(zzasy.class, zzasyVar);
    }

    private zzasy() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002᠌\u0001", new Object[]{"zzd", "zze", "zzf", zzatj.zza});
        }
        if (i2 == 3) {
            return new zzasy();
        }
        zzasf zzasfVar = null;
        if (i2 == 4) {
            return new zzasx(zzasfVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
