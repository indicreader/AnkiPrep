package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgtx extends zzgzu implements zzhbf {
    private static final zzgtx zzb;
    private int zzd;
    private int zze;

    static {
        zzgtx zzgtxVar = new zzgtx();
        zzb = zzgtxVar;
        zzgzu.zzaU(zzgtx.class, zzgtxVar);
    }

    private zzgtx() {
    }

    public static zzgtw zzd() {
        return (zzgtw) zzb.zzaA();
    }

    public static zzgtx zzf(zzgyl zzgylVar, zzgzf zzgzfVar) throws zzhag {
        return (zzgtx) zzgzu.zzaG(zzb, zzgylVar, zzgzfVar);
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
            return zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zze", "zzd"});
        }
        if (i2 == 3) {
            return new zzgtx();
        }
        if (i2 == 4) {
            return new zzgtw(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final int zzc() {
        return this.zze;
    }
}
