package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzatm extends zzgzu implements zzhbf {
    private static final zzatm zzb;
    private int zzd;
    private long zze;
    private String zzf = "";
    private zzgyl zzg = zzgyl.zzb;

    static {
        zzatm zzatmVar = new zzatm();
        zzb = zzatmVar;
        zzgzu.zzaU(zzatm.class, zzatmVar);
    }

    private zzatm() {
    }

    public static zzatm zzd() {
        return zzb;
    }

    public final long zza() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzatm();
        }
        zzasf zzasfVar = null;
        if (i2 == 4) {
            return new zzatl(zzasfVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final boolean zze() {
        return (this.zzd & 1) != 0;
    }
}
