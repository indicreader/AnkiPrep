package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
@Deprecated
/* loaded from: classes3.dex */
public final class zzgwc extends zzgzu implements zzhbf {
    private static final zzgwc zzb;
    private String zzd = "";
    private zzhad zze = zzaN();

    static {
        zzgwc zzgwcVar = new zzgwc();
        zzb = zzgwcVar;
        zzgzu.zzaU(zzgwc.class, zzgwcVar);
    }

    private zzgwc() {
    }

    public static zzgwc zzc() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzd", "zze", zzgvb.class});
        }
        if (i2 == 3) {
            return new zzgwc();
        }
        if (i2 == 4) {
            return new zzgwb(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
