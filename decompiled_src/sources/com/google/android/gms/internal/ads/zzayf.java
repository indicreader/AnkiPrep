package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzayf extends zzgzu implements zzhbf {
    private static final zzayf zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private long zzh;
    private long zzi;

    static {
        zzayf zzayfVar = new zzayf();
        zzb = zzayfVar;
        zzgzu.zzaU(zzayf.class, zzayfVar);
    }

    private zzayf() {
    }

    public static zzaye zze() {
        return (zzaye) zzb.zzaA();
    }

    public static zzayf zzg() {
        return zzb;
    }

    public static zzayf zzh(zzgyl zzgylVar) throws zzhag {
        return (zzayf) zzgzu.zzaE(zzb, zzgylVar);
    }

    public static zzayf zzi(zzgyl zzgylVar, zzgzf zzgzfVar) throws zzhag {
        return (zzayf) zzgzu.zzaG(zzb, zzgylVar, zzgzfVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzl(zzayf zzayfVar, String str) {
        str.getClass();
        zzayfVar.zzd |= 1;
        zzayfVar.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzm(zzayf zzayfVar, long j) {
        zzayfVar.zzd |= 16;
        zzayfVar.zzi = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzn(zzayf zzayfVar, String str) {
        str.getClass();
        zzayfVar.zzd |= 2;
        zzayfVar.zzf = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzo(zzayf zzayfVar, long j) {
        zzayfVar.zzd |= 4;
        zzayfVar.zzg = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzp(zzayf zzayfVar, long j) {
        zzayfVar.zzd |= 8;
        zzayfVar.zzh = j;
    }

    public final long zza() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzayf();
        }
        zzayd zzaydVar = null;
        if (i2 == 4) {
            return new zzaye(zzaydVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final long zzc() {
        return this.zzg;
    }

    public final long zzd() {
        return this.zzi;
    }

    public final String zzj() {
        return this.zzf;
    }

    public final String zzk() {
        return this.zze;
    }
}
