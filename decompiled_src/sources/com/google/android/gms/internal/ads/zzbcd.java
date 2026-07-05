package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbcd extends zzgzu implements zzhbf {
    private static final zzbcd zzb;
    private int zzd;
    private int zze;
    private zzbch zzf;
    private zzbcj zzg;

    static {
        zzbcd zzbcdVar = new zzbcd();
        zzb = zzbcdVar;
        zzgzu.zzaU(zzbcd.class, zzbcdVar);
    }

    private zzbcd() {
    }

    public static zzbcc zza() {
        return (zzbcc) zzb.zzaA();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzd(zzbcd zzbcdVar, zzbch zzbchVar) {
        zzbchVar.getClass();
        zzbcdVar.zzf = zzbchVar;
        zzbcdVar.zzd |= 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zze(zzbcd zzbcdVar, zzbcj zzbcjVar) {
        zzbcjVar.getClass();
        zzbcdVar.zzg = zzbcjVar;
        zzbcdVar.zzd |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzf(zzbcd zzbcdVar, int i) {
        zzbcdVar.zze = 1;
        zzbcdVar.zzd = 1 | zzbcdVar.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzbcf.zza, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbcd();
        }
        zzbbw zzbbwVar = null;
        if (i2 == 4) {
            return new zzbcc(zzbbwVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
