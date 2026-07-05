package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbcb extends zzgzu implements zzhbf {
    private static final zzbcb zzb;
    private int zzd;
    private int zze;
    private zzbcr zzg;
    private zzbct zzh;
    private zzbcv zzj;
    private zzbef zzk;
    private zzbdv zzl;
    private zzbdj zzm;
    private zzbdl zzn;
    private int zzf = 1000;
    private zzhad zzi = zzaN();
    private zzhad zzo = zzaN();

    static {
        zzbcb zzbcbVar = new zzbcb();
        zzb = zzbcbVar;
        zzgzu.zzaU(zzbcb.class, zzbcbVar);
    }

    private zzbcb() {
    }

    public static zzbcb zzc() {
        return zzb;
    }

    public static /* synthetic */ void zze(zzbcb zzbcbVar, zzbbz zzbbzVar) {
        zzbcbVar.zze = zzbbzVar.zza();
        zzbcbVar.zzd |= 1;
    }

    public static /* synthetic */ void zzf(zzbcb zzbcbVar, zzbct zzbctVar) {
        zzbctVar.getClass();
        zzbcbVar.zzh = zzbctVar;
        zzbcbVar.zzd |= 8;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u000b\u0000\u0001\u0007\u0011\u000b\u0000\u0002\u0000\u0007᠌\u0000\b᠌\u0001\tဉ\u0002\nဉ\u0003\u000b\u001b\fဉ\u0004\rဉ\u0005\u000eဉ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011\u001b", new Object[]{"zzd", "zze", zzbby.zza, "zzf", zzbdc.zza, "zzg", "zzh", "zzi", zzbcp.class, "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", zzber.class});
        }
        if (i2 == 3) {
            return new zzbcb();
        }
        if (i2 == 4) {
            return new zzbca(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzbct zzd() {
        zzbct zzbctVar = this.zzh;
        return zzbctVar == null ? zzbct.zzc() : zzbctVar;
    }
}
