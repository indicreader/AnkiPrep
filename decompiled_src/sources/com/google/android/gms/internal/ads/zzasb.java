package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzasb extends zzgzu implements zzhbf {
    private static final zzasb zzb;
    private int zzd;
    private int zze = 2;

    static {
        zzasb zzasbVar = new zzasb();
        zzb = zzasbVar;
        zzgzu.zzaU(zzasb.class, zzasbVar);
    }

    private zzasb() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001b᠌\u0000", new Object[]{"zzd", "zze", zzasc.zza});
        }
        if (i2 == 3) {
            return new zzasb();
        }
        zzarx zzarxVar = null;
        if (i2 == 4) {
            return new zzasa(zzarxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
