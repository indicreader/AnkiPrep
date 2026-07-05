package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbch extends zzgzu implements zzhbf {
    private static final zzbch zzb;
    private int zzd;
    private boolean zze;
    private int zzf;

    static {
        zzbch zzbchVar = new zzbch();
        zzb = zzbchVar;
        zzgzu.zzaU(zzbch.class, zzbchVar);
    }

    private zzbch() {
    }

    public static zzbcg zza() {
        return (zzbcg) zzb.zzaA();
    }

    public static zzbch zzd() {
        return zzb;
    }

    public static /* synthetic */ void zze(zzbch zzbchVar, boolean z) {
        zzbchVar.zzd |= 1;
        zzbchVar.zze = z;
    }

    public static /* synthetic */ void zzf(zzbch zzbchVar, int i) {
        zzbchVar.zzd |= 2;
        zzbchVar.zzf = i;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဋ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzbch();
        }
        if (i2 == 4) {
            return new zzbcg(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
