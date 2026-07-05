package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzasw extends zzgzu implements zzhbf {
    private static final zzasw zzb;
    private int zzd;
    private int zze;
    private long zzf = -1;

    static {
        zzasw zzaswVar = new zzasw();
        zzb = zzaswVar;
        zzgzu.zzaU(zzasw.class, zzaswVar);
    }

    private zzasw() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", zzasl.zza, "zzf"});
        }
        if (i2 == 3) {
            return new zzasw();
        }
        zzasf zzasfVar = null;
        if (i2 == 4) {
            return new zzasv(zzasfVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
