package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbct extends zzgzu implements zzhbf {
    private static final zzbct zzb;
    private int zzd;
    private String zze = "";
    private zzhad zzf = zzaN();
    private int zzg = 1000;
    private int zzh = 1000;
    private int zzi = 1000;

    static {
        zzbct zzbctVar = new zzbct();
        zzb = zzbctVar;
        zzgzu.zzaU(zzbct.class, zzbctVar);
    }

    private zzbct() {
    }

    public static zzbct zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzd(zzbct zzbctVar, String str) {
        str.getClass();
        zzbctVar.zzd |= 1;
        zzbctVar.zze = str;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzgzy zzgzyVar = zzbdc.zza;
            return zzaR(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003᠌\u0001\u0004᠌\u0002\u0005᠌\u0003", new Object[]{"zzd", "zze", "zzf", zzbcp.class, "zzg", zzgzyVar, "zzh", zzgzyVar, "zzi", zzgzyVar});
        }
        if (i2 == 3) {
            return new zzbct();
        }
        if (i2 == 4) {
            return new zzbcs(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
