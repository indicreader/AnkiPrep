package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzata extends zzgzu implements zzhbf {
    private static final zzata zzb;
    private int zzd;
    private long zzt;
    private long zzu;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private int zzk = 1000;
    private long zzl = -1;
    private long zzm = -1;
    private long zzn = -1;
    private int zzo = 1000;
    private long zzp = -1;
    private long zzq = -1;
    private long zzr = -1;
    private long zzs = -1;
    private long zzv = -1;
    private long zzw = -1;
    private long zzx = -1;
    private long zzy = -1;

    static {
        zzata zzataVar = new zzata();
        zzb = zzataVar;
        zzgzu.zzaU(zzata.class, zzataVar);
    }

    private zzata() {
    }

    public static zzasz zza() {
        return (zzasz) zzb.zzaA();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzd(zzata zzataVar, long j) {
        zzataVar.zzd |= 1;
        zzataVar.zze = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zze(zzata zzataVar, long j) {
        zzataVar.zzd |= 2;
        zzataVar.zzf = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzf(zzata zzataVar, long j) {
        zzataVar.zzd |= 4;
        zzataVar.zzg = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(zzata zzataVar, long j) {
        zzataVar.zzd |= 8;
        zzataVar.zzh = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzata zzataVar) {
        zzataVar.zzd &= -9;
        zzataVar.zzh = -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzata zzataVar, long j) {
        zzataVar.zzd |= 16;
        zzataVar.zzi = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzj(zzata zzataVar, long j) {
        zzataVar.zzd |= 32;
        zzataVar.zzj = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzk(zzata zzataVar, long j) {
        zzataVar.zzd |= 128;
        zzataVar.zzl = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzl(zzata zzataVar, long j) {
        zzataVar.zzd |= 256;
        zzataVar.zzm = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzm(zzata zzataVar, long j) {
        zzataVar.zzd |= 512;
        zzataVar.zzn = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzn(zzata zzataVar, long j) {
        zzataVar.zzd |= 2048;
        zzataVar.zzp = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzo(zzata zzataVar, long j) {
        zzataVar.zzd |= 4096;
        zzataVar.zzq = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzp(zzata zzataVar, long j) {
        zzataVar.zzd |= 8192;
        zzataVar.zzr = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzq(zzata zzataVar, long j) {
        zzataVar.zzd |= 16384;
        zzataVar.zzs = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzr(zzata zzataVar, long j) {
        zzataVar.zzd |= 32768;
        zzataVar.zzt = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzs(zzata zzataVar, long j) {
        zzataVar.zzd |= 65536;
        zzataVar.zzu = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzt(zzata zzataVar, long j) {
        zzataVar.zzd |= 131072;
        zzataVar.zzv = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzu(zzata zzataVar, long j) {
        zzataVar.zzd |= 262144;
        zzataVar.zzw = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzv(zzata zzataVar, int i) {
        zzataVar.zzk = i - 1;
        zzataVar.zzd |= 64;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzw(zzata zzataVar, int i) {
        zzataVar.zzo = i - 1;
        zzataVar.zzd |= 1024;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzgzy zzgzyVar = zzatj.zza;
            return zzaR(zzb, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007᠌\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000b᠌\n\fဂ\u000b\rဂ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ\u0014", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzgzyVar, "zzl", "zzm", "zzn", "zzo", zzgzyVar, "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy"});
        }
        if (i2 == 3) {
            return new zzata();
        }
        zzasf zzasfVar = null;
        if (i2 == 4) {
            return new zzasz(zzasfVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
