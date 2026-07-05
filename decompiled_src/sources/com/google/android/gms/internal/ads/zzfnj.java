package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfnj extends zzgzu implements zzhbf {
    private static final zzfnj zzb;
    private int zzd;
    private zzfnf zze;

    static {
        zzfnj zzfnjVar = new zzfnj();
        zzb = zzfnjVar;
        zzgzu.zzaU(zzfnj.class, zzfnjVar);
    }

    private zzfnj() {
    }

    public static zzfni zza() {
        return (zzfni) zzb.zzaA();
    }

    public static /* synthetic */ zzfnj zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzd(zzfnj zzfnjVar, zzfnf zzfnfVar) {
        zzfnfVar.getClass();
        zzfnjVar.zze = zzfnfVar;
        zzfnjVar.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0001\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0000\u0006ဉ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzfnj();
        }
        zzfng zzfngVar = null;
        if (i2 == 4) {
            return new zzfni(zzfngVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
