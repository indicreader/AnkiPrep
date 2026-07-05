package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbcj extends zzgzu implements zzhbf {
    private static final zzbcj zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    static {
        zzbcj zzbcjVar = new zzbcj();
        zzb = zzbcjVar;
        zzgzu.zzaU(zzbcj.class, zzbcjVar);
    }

    private zzbcj() {
    }

    public static zzbci zza() {
        return (zzbci) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzbcj zzbcjVar, boolean z) {
        zzbcjVar.zzd |= 1;
        zzbcjVar.zze = z;
    }

    public static /* synthetic */ void zze(zzbcj zzbcjVar, boolean z) {
        zzbcjVar.zzd |= 2;
        zzbcjVar.zzf = z;
    }

    public static /* synthetic */ void zzf(zzbcj zzbcjVar, int i) {
        zzbcjVar.zzd |= 4;
        zzbcjVar.zzg = i;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဋ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbcj();
        }
        if (i2 == 4) {
            return new zzbci(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
