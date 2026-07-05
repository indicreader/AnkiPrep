package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbel extends zzgzu implements zzhbf {
    private static final zzbel zzb;
    private int zzd;
    private String zze = "";
    private int zzf;
    private zzben zzg;

    static {
        zzbel zzbelVar = new zzbel();
        zzb = zzbelVar;
        zzgzu.zzaU(zzbel.class, zzbelVar);
    }

    private zzbel() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", zzbdc.zza, "zzg"});
        }
        if (i2 == 3) {
            return new zzbel();
        }
        if (i2 == 4) {
            return new zzbek(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
