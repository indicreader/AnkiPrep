package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhed extends zzgzu implements zzhbf {
    private static final zzhed zzb;
    private int zzd;
    private String zze = "";

    static {
        zzhed zzhedVar = new zzhed();
        zzb = zzhedVar;
        zzgzu.zzaU(zzhed.class, zzhedVar);
    }

    private zzhed() {
    }

    public static zzhec zza() {
        return (zzhec) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzhed zzhedVar, String str) {
        zzhedVar.zzd |= 1;
        zzhedVar.zze = str;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzhed();
        }
        if (i2 == 4) {
            return new zzhec(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
