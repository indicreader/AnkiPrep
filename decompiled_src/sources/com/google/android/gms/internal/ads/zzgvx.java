package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgvx extends zzgzu implements zzhbf {
    private static final zzgvx zzb;
    private int zzd;
    private String zze = "";
    private zzguy zzf;

    static {
        zzgvx zzgvxVar = new zzgvx();
        zzb = zzgvxVar;
        zzgzu.zzaU(zzgvx.class, zzgvxVar);
    }

    private zzgvx() {
    }

    public static zzgvw zzc() {
        return (zzgvw) zzb.zzaA();
    }

    public static zzgvx zze() {
        return zzb;
    }

    public static zzgvx zzf(zzgyl zzgylVar, zzgzf zzgzfVar) throws zzhag {
        return (zzgvx) zzgzu.zzaG(zzb, zzgylVar, zzgzfVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzgvx zzgvxVar, String str) {
        str.getClass();
        zzgvxVar.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzgvx zzgvxVar, zzguy zzguyVar) {
        zzguyVar.getClass();
        zzgvxVar.zzf = zzguyVar;
        zzgvxVar.zzd |= 1;
    }

    public final zzguy zza() {
        zzguy zzguyVar = this.zzf;
        return zzguyVar == null ? zzguy.zzd() : zzguyVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzgvx();
        }
        zzgvv zzgvvVar = null;
        if (i2 == 4) {
            return new zzgvw(zzgvvVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final String zzg() {
        return this.zze;
    }
}
