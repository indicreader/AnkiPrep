package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhfy extends zzgzu implements zzhbf {
    private static final zzhfy zzb;
    private int zzd;
    private int zze;
    private String zzf = "";

    static {
        zzhfy zzhfyVar = new zzhfy();
        zzb = zzhfyVar;
        zzgzu.zzaU(zzhfy.class, zzhfyVar);
    }

    private zzhfy() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", zzhfx.zza, "zzf"});
        }
        if (i2 == 3) {
            return new zzhfy();
        }
        zzhdp zzhdpVar = null;
        if (i2 == 4) {
            return new zzhfw(zzhdpVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
