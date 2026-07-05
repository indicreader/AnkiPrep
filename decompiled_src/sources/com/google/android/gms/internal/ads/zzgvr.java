package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgvr extends zzgzu implements zzhbf {
    private static final zzgvr zzb;
    private String zzd = "";

    static {
        zzgvr zzgvrVar = new zzgvr();
        zzb = zzgvrVar;
        zzgzu.zzaU(zzgvr.class, zzgvrVar);
    }

    private zzgvr() {
    }

    public static zzgvq zza() {
        return (zzgvq) zzb.zzaA();
    }

    public static zzgvr zzd() {
        return zzb;
    }

    public static zzgvr zze(zzgyl zzgylVar, zzgzf zzgzfVar) throws zzhag {
        return (zzgvr) zzgzu.zzaG(zzb, zzgylVar, zzgzfVar);
    }

    public static /* synthetic */ void zzg(zzgvr zzgvrVar, String str) {
        str.getClass();
        zzgvrVar.zzd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzd"});
        }
        if (i2 == 3) {
            return new zzgvr();
        }
        if (i2 == 4) {
            return new zzgvq(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final String zzf() {
        return this.zzd;
    }
}
