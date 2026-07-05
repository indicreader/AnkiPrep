package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbck extends zzgzu implements zzhbf {
    private static final zzbck zzb;
    private zzhad zzd = zzaN();

    static {
        zzbck zzbckVar = new zzbck();
        zzb = zzbckVar;
        zzgzu.zzaU(zzbck.class, zzbckVar);
    }

    private zzbck() {
    }

    public static zzbce zza() {
        return (zzbce) zzb.zzaA();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzd(zzbck zzbckVar, zzbcd zzbcdVar) {
        zzbcdVar.getClass();
        zzhad zzhadVar = zzbckVar.zzd;
        if (!zzhadVar.zzc()) {
            zzbckVar.zzd = zzgzu.zzaO(zzhadVar);
        }
        zzbckVar.zzd.add(zzbcdVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzbcd.class});
        }
        if (i2 == 3) {
            return new zzbck();
        }
        zzbbw zzbbwVar = null;
        if (i2 == 4) {
            return new zzbce(zzbbwVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
