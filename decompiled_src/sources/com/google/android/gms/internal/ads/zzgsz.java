package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgsz extends zzgzu implements zzhbf {
    private static final zzgsz zzb;
    private int zzd;
    private zzgtc zze;
    private int zzf;

    static {
        zzgsz zzgszVar = new zzgsz();
        zzb = zzgszVar;
        zzgzu.zzaU(zzgsz.class, zzgszVar);
    }

    private zzgsz() {
    }

    public static zzgsy zzc() {
        return (zzgsy) zzb.zzaA();
    }

    public static zzgsz zze() {
        return zzb;
    }

    public static /* synthetic */ void zzg(zzgsz zzgszVar, zzgtc zzgtcVar) {
        zzgtcVar.getClass();
        zzgszVar.zze = zzgtcVar;
        zzgszVar.zzd |= 1;
    }

    public final int zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzgsz();
        }
        if (i2 == 4) {
            return new zzgsy(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzgtc zzf() {
        zzgtc zzgtcVar = this.zze;
        return zzgtcVar == null ? zzgtc.zze() : zzgtcVar;
    }
}
