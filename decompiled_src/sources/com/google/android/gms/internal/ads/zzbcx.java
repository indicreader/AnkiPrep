package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbcx extends zzgzu implements zzhbf {
    private static final zzbcx zzb;
    private int zzd;
    private zzben zzf;
    private int zzg;
    private zzbep zzh;
    private int zzi;
    private String zze = "";
    private int zzj = 1000;
    private int zzk = 1000;
    private int zzl = 1000;

    static {
        zzbcx zzbcxVar = new zzbcx();
        zzb = zzbcxVar;
        zzgzu.zzaU(zzbcx.class, zzbcxVar);
    }

    private zzbcx() {
    }

    public static zzbcx zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzd(zzbcx zzbcxVar, String str) {
        zzbcxVar.zzd |= 1;
        zzbcxVar.zze = str;
    }

    public static /* synthetic */ void zze(zzbcx zzbcxVar, zzbep zzbepVar) {
        zzbepVar.getClass();
        zzbcxVar.zzh = zzbepVar;
        zzbcxVar.zzd |= 8;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzgzy zzgzyVar = zzbdc.zza;
            return zzaR(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004ဉ\u0003\u0005င\u0004\u0006᠌\u0005\u0007᠌\u0006\b᠌\u0007", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzgzyVar, "zzk", zzgzyVar, "zzl", zzgzyVar});
        }
        if (i2 == 3) {
            return new zzbcx();
        }
        if (i2 == 4) {
            return new zzbcw(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
