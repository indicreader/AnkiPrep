package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhez extends zzgzu implements zzhbf {
    private static final zzhez zzb;
    private int zzd;
    private int zze;
    private boolean zzf;
    private int zzg;

    static {
        zzhez zzhezVar = new zzhez();
        zzb = zzhezVar;
        zzgzu.zzaU(zzhez.class, zzhezVar);
    }

    private zzhez() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzgzy zzgzyVar = zzhex.zza;
            return zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", zzgzyVar, "zzf", "zzg", zzgzyVar});
        }
        if (i2 == 3) {
            return new zzhez();
        }
        zzhdp zzhdpVar = null;
        if (i2 == 4) {
            return new zzhey(zzhdpVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
