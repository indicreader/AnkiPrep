package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzatc extends zzgzu implements zzhbf {
    private static final zzatc zzb;
    private int zzd;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private long zzk = -1;
    private long zzl = -1;

    static {
        zzatc zzatcVar = new zzatc();
        zzb = zzatcVar;
        zzgzu.zzaU(zzatc.class, zzatcVar);
    }

    private zzatc() {
    }

    public static zzatb zza() {
        return (zzatb) zzb.zzaA();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzd(zzatc zzatcVar, long j) {
        zzatcVar.zzd |= 1;
        zzatcVar.zze = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zze(zzatc zzatcVar, long j) {
        zzatcVar.zzd |= 4;
        zzatcVar.zzg = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzf(zzatc zzatcVar, long j) {
        zzatcVar.zzd |= 8;
        zzatcVar.zzh = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(zzatc zzatcVar, long j) {
        zzatcVar.zzd |= 16;
        zzatcVar.zzi = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzatc zzatcVar, long j) {
        zzatcVar.zzd |= 32;
        zzatcVar.zzj = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        if (i2 == 3) {
            return new zzatc();
        }
        zzasf zzasfVar = null;
        if (i2 == 4) {
            return new zzatb(zzasfVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
