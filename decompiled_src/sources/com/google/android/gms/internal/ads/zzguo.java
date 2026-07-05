package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzguo extends zzgzu implements zzhbf {
    private static final zzguo zzb;
    private int zzd;
    private int zze;

    static {
        zzguo zzguoVar = new zzguo();
        zzb = zzguoVar;
        zzgzu.zzaU(zzguo.class, zzguoVar);
    }

    private zzguo() {
    }

    public static zzgun zzd() {
        return (zzgun) zzb.zzaA();
    }

    public static zzguo zzf() {
        return zzb;
    }

    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzguo();
        }
        if (i2 == 4) {
            return new zzgun(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzguf zzc() {
        int i = this.zzd;
        zzguf zzgufVar = zzguf.UNKNOWN_HASH;
        zzguf zzgufVar2 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? null : zzguf.SHA224 : zzguf.SHA512 : zzguf.SHA256 : zzguf.SHA384 : zzguf.SHA1 : zzguf.UNKNOWN_HASH;
        return zzgufVar2 == null ? zzguf.UNRECOGNIZED : zzgufVar2;
    }
}
