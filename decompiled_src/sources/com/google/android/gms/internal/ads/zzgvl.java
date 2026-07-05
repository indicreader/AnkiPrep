package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgvl extends zzgzu implements zzhbf {
    private static final zzgvl zzb;
    private int zzd;
    private zzhad zze = zzaN();

    static {
        zzgvl zzgvlVar = new zzgvl();
        zzb = zzgvlVar;
        zzgzu.zzaU(zzgvl.class, zzgvlVar);
    }

    private zzgvl() {
    }

    public static zzgvi zza() {
        return (zzgvi) zzb.zzaA();
    }

    public static /* synthetic */ void zze(zzgvl zzgvlVar, zzgvk zzgvkVar) {
        zzgvkVar.getClass();
        zzhad zzhadVar = zzgvlVar.zze;
        if (!zzhadVar.zzc()) {
            zzgvlVar.zze = zzgzu.zzaO(zzhadVar);
        }
        zzgvlVar.zze.add(zzgvkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzd", "zze", zzgvk.class});
        }
        if (i2 == 3) {
            return new zzgvl();
        }
        if (i2 == 4) {
            return new zzgvi(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
