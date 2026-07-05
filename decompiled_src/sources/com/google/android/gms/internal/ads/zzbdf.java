package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbdf extends zzgzu implements zzhbf {
    private static final zzbdf zzb;
    private int zzd;
    private int zze;
    private int zzg;
    private zzbep zzi;
    private zzbcx zzk;
    private zzbda zzl;
    private zzbdt zzm;
    private zzbcb zzn;
    private zzbed zzo;
    private zzbfk zzp;
    private zzbck zzq;
    private String zzf = "";
    private int zzh = 1000;
    private zzhac zzj = zzaL();

    static {
        zzbdf zzbdfVar = new zzbdf();
        zzb = zzbdfVar;
        zzgzu.zzaU(zzbdf.class, zzbdfVar);
    }

    private zzbdf() {
    }

    public static zzbde zzd() {
        return (zzbde) zzb.zzaA();
    }

    public static /* synthetic */ void zzg(zzbdf zzbdfVar, String str) {
        str.getClass();
        zzbdfVar.zzd |= 2;
        zzbdfVar.zzf = str;
    }

    public static /* synthetic */ void zzh(zzbdf zzbdfVar, Iterable iterable) {
        zzhac zzhacVar = zzbdfVar.zzj;
        if (!zzhacVar.zzc()) {
            zzbdfVar.zzj = zzgzu.zzaM(zzhacVar);
        }
        zzgxt.zzav(iterable, zzbdfVar.zzj);
    }

    public static /* synthetic */ void zzj(zzbdf zzbdfVar, zzbcx zzbcxVar) {
        zzbcxVar.getClass();
        zzbdfVar.zzk = zzbcxVar;
        zzbdfVar.zzd |= 32;
    }

    public static /* synthetic */ void zzk(zzbdf zzbdfVar, zzbcb zzbcbVar) {
        zzbcbVar.getClass();
        zzbdfVar.zzn = zzbcbVar;
        zzbdfVar.zzd |= 256;
    }

    public static /* synthetic */ void zzl(zzbdf zzbdfVar, zzbed zzbedVar) {
        zzbedVar.getClass();
        zzbdfVar.zzo = zzbedVar;
        zzbdfVar.zzd |= 512;
    }

    public static /* synthetic */ void zzm(zzbdf zzbdfVar, zzbfk zzbfkVar) {
        zzbfkVar.getClass();
        zzbdfVar.zzp = zzbfkVar;
        zzbdfVar.zzd |= 1024;
    }

    public static /* synthetic */ void zzn(zzbdf zzbdfVar, zzbck zzbckVar) {
        zzbckVar.getClass();
        zzbdfVar.zzq = zzbckVar;
        zzbdfVar.zzd |= 2048;
    }

    public final zzbcb zza() {
        zzbcb zzbcbVar = this.zzn;
        return zzbcbVar == null ? zzbcb.zzc() : zzbcbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\r\u0000\u0001\t\u0015\r\u0000\u0001\u0000\tင\u0000\nဈ\u0001\u000bဋ\u0002\f᠌\u0003\rဉ\u0004\u000e\u0015\u000fဉ\u0005\u0010ဉ\u0006\u0011ဉ\u0007\u0012ဉ\b\u0013ဉ\t\u0014ဉ\n\u0015ဉ\u000b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zzbdc.zza, "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq"});
        }
        if (i2 == 3) {
            return new zzbdf();
        }
        if (i2 == 4) {
            return new zzbde(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzbcx zzc() {
        zzbcx zzbcxVar = this.zzk;
        return zzbcxVar == null ? zzbcx.zzc() : zzbcxVar;
    }

    public final String zzf() {
        return this.zzf;
    }
}
