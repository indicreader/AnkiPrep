package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbew extends zzgzu implements zzhbf {
    private static final zzbew zzb;
    private int zzd;
    private int zze;

    static {
        zzbew zzbewVar = new zzbew();
        zzb = zzbewVar;
        zzgzu.zzaU(zzbew.class, zzbewVar);
    }

    private zzbew() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzbev.zza});
        }
        if (i2 == 3) {
            return new zzbew();
        }
        zzbbw zzbbwVar = null;
        if (i2 == 4) {
            return new zzbeu(zzbbwVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
