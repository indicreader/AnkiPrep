package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhfz extends zzgzu implements zzhbf {
    private static final zzhfz zzb;
    private zzheh zzB;
    private zzhdz zzD;
    private zzhfa zzF;
    private int zzG;
    private long zzJ;
    private zzhfy zzK;
    private int zzd;
    private int zze;
    private int zzf;
    private zzhed zzj;
    private zzhfj zzn;
    private boolean zzo;
    private boolean zzr;
    private boolean zzs;
    private zzhfr zzu;
    private boolean zzv;
    private zzhfv zzz;
    private byte zzL = 2;
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private zzhad zzk = zzaN();
    private zzhad zzl = zzaN();
    private String zzm = "";
    private zzhad zzp = zzgzu.zzaN();
    private String zzq = "";
    private zzgyl zzt = zzgyl.zzb;
    private String zzw = "";
    private zzhad zzx = zzgzu.zzaN();
    private zzhad zzy = zzgzu.zzaN();
    private zzhad zzA = zzaN();
    private String zzC = "";
    private zzhad zzE = zzaN();
    private zzhad zzH = zzaN();
    private zzhad zzI = zzaN();

    static {
        zzhfz zzhfzVar = new zzhfz();
        zzb = zzhfzVar;
        zzgzu.zzaU(zzhfz.class, zzhfzVar);
    }

    private zzhfz() {
    }

    public static zzheb zza() {
        return (zzheb) zzb.zzaA();
    }

    public static /* synthetic */ void zzg(zzhfz zzhfzVar, String str) {
        str.getClass();
        zzhfzVar.zzd |= 4;
        zzhfzVar.zzg = str;
    }

    public static /* synthetic */ void zzh(zzhfz zzhfzVar, String str) {
        str.getClass();
        zzhfzVar.zzd |= 8;
        zzhfzVar.zzh = str;
    }

    public static /* synthetic */ void zzi(zzhfz zzhfzVar, zzhed zzhedVar) {
        zzhedVar.getClass();
        zzhfzVar.zzj = zzhedVar;
        zzhfzVar.zzd |= 32;
    }

    public static /* synthetic */ void zzj(zzhfz zzhfzVar, zzhfp zzhfpVar) {
        zzhfpVar.getClass();
        zzhad zzhadVar = zzhfzVar.zzk;
        if (!zzhadVar.zzc()) {
            zzhfzVar.zzk = zzgzu.zzaO(zzhadVar);
        }
        zzhfzVar.zzk.add(zzhfpVar);
    }

    public static /* synthetic */ void zzk(zzhfz zzhfzVar, String str) {
        zzhfzVar.zzd |= 64;
        zzhfzVar.zzm = str;
    }

    public static /* synthetic */ void zzl(zzhfz zzhfzVar) {
        zzhfzVar.zzd &= -65;
        zzhfzVar.zzm = zzb.zzm;
    }

    public static /* synthetic */ void zzm(zzhfz zzhfzVar, zzhfj zzhfjVar) {
        zzhfjVar.getClass();
        zzhfzVar.zzn = zzhfjVar;
        zzhfzVar.zzd |= 128;
    }

    public static /* synthetic */ void zzn(zzhfz zzhfzVar, zzhfr zzhfrVar) {
        zzhfrVar.getClass();
        zzhfzVar.zzu = zzhfrVar;
        zzhfzVar.zzd |= 8192;
    }

    public static /* synthetic */ void zzo(zzhfz zzhfzVar, Iterable iterable) {
        zzhad zzhadVar = zzhfzVar.zzx;
        if (!zzhadVar.zzc()) {
            zzhfzVar.zzx = zzgzu.zzaO(zzhadVar);
        }
        zzgxt.zzav(iterable, zzhfzVar.zzx);
    }

    public static /* synthetic */ void zzp(zzhfz zzhfzVar, Iterable iterable) {
        zzhad zzhadVar = zzhfzVar.zzy;
        if (!zzhadVar.zzc()) {
            zzhfzVar.zzy = zzgzu.zzaO(zzhadVar);
        }
        zzgxt.zzav(iterable, zzhfzVar.zzy);
    }

    public static /* synthetic */ void zzq(zzhfz zzhfzVar, int i) {
        zzhfzVar.zze = i - 1;
        zzhfzVar.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzL);
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001!\u0000\u0001\u0001!!\u0000\t\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\n᠌\u0000\u000b᠌\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0010\u001b\u0011ဉ\r\u0012ဇ\u000e\u0013ဈ\u000f\u0014\u001a\u0015\u001a\u0016ဉ\u0010\u0017\u001b\u0018ဉ\u0011\u0019ဈ\u0012\u001aဉ\u0013\u001b\u001b\u001cဉ\u0014\u001d᠌\u0015\u001e\u001b\u001f\u001b ဂ\u0016!ဉ\u0017", new Object[]{"zzd", "zzg", "zzh", "zzi", "zzk", zzhfp.class, "zzo", "zzp", "zzq", "zzr", "zzs", "zze", zzhfk.zza, "zzf", zzhea.zza, "zzj", "zzm", "zzn", "zzt", "zzl", zzhgd.class, "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", zzhgj.class, "zzB", "zzC", "zzD", "zzE", zzhel.class, "zzF", "zzG", zzhft.zza, "zzH", zzhfd.class, "zzI", zzhfg.class, "zzJ", "zzK"});
        }
        if (i2 == 3) {
            return new zzhfz();
        }
        if (i2 == 4) {
            return new zzheb(null);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzL = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final String zzd() {
        return this.zzm;
    }

    public final String zze() {
        return this.zzg;
    }

    public final List zzf() {
        return this.zzk;
    }
}
