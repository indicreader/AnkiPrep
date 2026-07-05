package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfnk extends zzgzu implements zzhbf {
    private static final zzfnk zzb;
    private zzhad zzd = zzaN();

    static {
        zzfnk zzfnkVar = new zzfnk();
        zzb = zzfnkVar;
        zzgzu.zzaU(zzfnk.class, zzfnkVar);
    }

    private zzfnk() {
    }

    public static zzfnh zzc() {
        return (zzfnh) zzb.zzaA();
    }

    public static /* synthetic */ zzfnk zzd() {
        return zzb;
    }

    public static /* synthetic */ void zze(zzfnk zzfnkVar) {
        zzfnkVar.zzd = zzaN();
    }

    public static /* synthetic */ void zzf(zzfnk zzfnkVar, zzfnj zzfnjVar) {
        zzfnjVar.getClass();
        zzhad zzhadVar = zzfnkVar.zzd;
        if (!zzhadVar.zzc()) {
            zzfnkVar.zzd = zzgzu.zzaO(zzhadVar);
        }
        zzfnkVar.zzd.add(zzfnjVar);
    }

    public final int zza() {
        return this.zzd.size();
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzfnj.class});
        }
        if (i2 == 3) {
            return new zzfnk();
        }
        zzfng zzfngVar = null;
        if (i2 == 4) {
            return new zzfnh(zzfngVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
