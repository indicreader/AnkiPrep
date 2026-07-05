package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbet extends zzgzu implements zzhbf {
    private static final zzbet zzb;
    private int zzd;
    private int zze = 1000;
    private zzbew zzf;
    private zzben zzg;

    static {
        zzbet zzbetVar = new zzbet();
        zzb = zzbetVar;
        zzgzu.zzaU(zzbet.class, zzbetVar);
    }

    private zzbet() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzbdc.zza, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbet();
        }
        if (i2 == 4) {
            return new zzbes(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
