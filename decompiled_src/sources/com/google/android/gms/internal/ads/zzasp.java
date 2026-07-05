package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzasp extends zzgzu implements zzhbf {
    private static final zzasp zzb;
    private int zzd;
    private long zze = -1;
    private int zzf = 1000;
    private int zzg = 1000;

    static {
        zzasp zzaspVar = new zzasp();
        zzb = zzaspVar;
        zzgzu.zzaU(zzasp.class, zzaspVar);
    }

    private zzasp() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzgzy zzgzyVar = zzatj.zza;
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", "zzf", zzgzyVar, "zzg", zzgzyVar});
        }
        if (i2 == 3) {
            return new zzasp();
        }
        zzasf zzasfVar = null;
        if (i2 == 4) {
            return new zzaso(zzasfVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
