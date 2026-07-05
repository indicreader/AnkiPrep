package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbfk extends zzgzu implements zzhbf {
    private static final zzbfk zzb;
    private int zzd;
    private boolean zze;
    private int zzf;

    static {
        zzbfk zzbfkVar = new zzbfk();
        zzb = zzbfkVar;
        zzgzu.zzaU(zzbfk.class, zzbfkVar);
    }

    private zzbfk() {
    }

    public static zzbfj zza() {
        return (zzbfj) zzb.zzaA();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzd(zzbfk zzbfkVar, boolean z) {
        zzbfkVar.zzd |= 1;
        zzbfkVar.zze = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zze(zzbfk zzbfkVar, int i) {
        zzbfkVar.zzd |= 2;
        zzbfkVar.zzf = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002င\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzbfk();
        }
        zzbbw zzbbwVar = null;
        if (i2 == 4) {
            return new zzbfj(zzbbwVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final boolean zzf() {
        return this.zze;
    }
}
