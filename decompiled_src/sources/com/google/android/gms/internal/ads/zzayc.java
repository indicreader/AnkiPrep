package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzayc extends zzgzu implements zzhbf {
    private static final zzayc zzb;
    private int zzd;
    private zzayf zze;
    private zzgyl zzf = zzgyl.zzb;
    private zzgyl zzg = zzgyl.zzb;

    static {
        zzayc zzaycVar = new zzayc();
        zzb = zzaycVar;
        zzgzu.zzaU(zzayc.class, zzaycVar);
    }

    private zzayc() {
    }

    public static zzayc zzc(zzgyl zzgylVar, zzgzf zzgzfVar) throws zzhag {
        return (zzayc) zzgzu.zzaG(zzb, zzgylVar, zzgzfVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzayc();
        }
        zzaya zzayaVar = null;
        if (i2 == 4) {
            return new zzayb(zzayaVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzayf zzd() {
        zzayf zzayfVar = this.zze;
        return zzayfVar == null ? zzayf.zzg() : zzayfVar;
    }

    public final zzgyl zze() {
        return this.zzg;
    }

    public final zzgyl zzf() {
        return this.zzf;
    }
}
