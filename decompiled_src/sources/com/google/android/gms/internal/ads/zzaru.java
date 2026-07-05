package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzaru extends zzgzu implements zzhbf {
    private static final zzaru zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzaru zzaruVar = new zzaru();
        zzb = zzaruVar;
        zzgzu.zzaU(zzaru.class, zzaruVar);
    }

    private zzaru() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzaru();
        }
        zzarr zzarrVar = null;
        if (i2 == 4) {
            return new zzart(zzarrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
