package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbfa extends zzgzu implements zzhbf {
    private static final zzbfa zzb;
    private int zzd;
    private int zze = 1000;
    private zzbew zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    static {
        zzbfa zzbfaVar = new zzbfa();
        zzb = zzbfaVar;
        zzgzu.zzaU(zzbfa.class, zzbfaVar);
    }

    private zzbfa() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004", new Object[]{"zzd", "zze", zzbdc.zza, "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzbfa();
        }
        if (i2 == 4) {
            return new zzbez(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
