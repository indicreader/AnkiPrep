package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzguy extends zzgzu implements zzhbf {
    private static final zzguy zzb;
    private String zzd = "";
    private zzgyl zze = zzgyl.zzb;
    private int zzf;

    static {
        zzguy zzguyVar = new zzguy();
        zzb = zzguyVar;
        zzgzu.zzaU(zzguy.class, zzguyVar);
    }

    private zzguy() {
    }

    public static zzgux zza() {
        return (zzgux) zzb.zzaA();
    }

    public static zzguy zzd() {
        return zzb;
    }

    public static zzguy zze(byte[] bArr, zzgzf zzgzfVar) throws zzhag {
        return (zzguy) zzgzu.zzaI(zzb, bArr, zzgzfVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzguy zzguyVar, String str) {
        str.getClass();
        zzguyVar.zzd = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzj(zzguy zzguyVar, zzgyl zzgylVar) {
        zzgylVar.getClass();
        zzguyVar.zze = zzgylVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzguy();
        }
        zzguw zzguwVar = null;
        if (i2 == 4) {
            return new zzgux(zzguwVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzgvz zzf() {
        zzgvz zzb2 = zzgvz.zzb(this.zzf);
        return zzb2 == null ? zzgvz.UNRECOGNIZED : zzb2;
    }

    public final zzgyl zzg() {
        return this.zze;
    }

    public final String zzh() {
        return this.zzd;
    }
}
