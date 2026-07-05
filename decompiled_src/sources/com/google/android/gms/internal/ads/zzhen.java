package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhen extends zzgzu implements zzhbf {
    private static final zzhen zzb;
    private int zzd;
    private byte zzg = 2;
    private zzgyl zze = zzgyl.zzb;
    private zzgyl zzf = zzgyl.zzb;

    static {
        zzhen zzhenVar = new zzhen();
        zzb = zzhenVar;
        zzgzu.zzaU(zzhen.class, zzhenVar);
    }

    private zzhen() {
    }

    public static zzhem zza() {
        return (zzhem) zzb.zzaA();
    }

    public static /* synthetic */ zzhen zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzd(zzhen zzhenVar, zzgyl zzgylVar) {
        zzhenVar.zzd |= 1;
        zzhenVar.zze = zzgylVar;
    }

    public static /* synthetic */ void zze(zzhen zzhenVar, zzgyl zzgylVar) {
        zzhenVar.zzd |= 2;
        zzhenVar.zzf = zzgylVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzhen();
        }
        zzhdp zzhdpVar = null;
        if (i2 == 4) {
            return new zzhem(zzhdpVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
