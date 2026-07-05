package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgut extends zzgzu implements zzhbf {
    private static final zzgut zzb;
    private String zzd = "";
    private zzgyl zze = zzgyl.zzb;
    private int zzf;

    static {
        zzgut zzgutVar = new zzgut();
        zzb = zzgutVar;
        zzgzu.zzaU(zzgut.class, zzgutVar);
    }

    private zzgut() {
    }

    public static zzguq zza() {
        return (zzguq) zzb.zzaA();
    }

    public static zzgut zze() {
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzgut zzgutVar, String str) {
        str.getClass();
        zzgutVar.zzd = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzgut zzgutVar, zzgyl zzgylVar) {
        zzgylVar.getClass();
        zzgutVar.zze = zzgylVar;
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
            return new zzgut();
        }
        zzgup zzgupVar = null;
        if (i2 == 4) {
            return new zzguq(zzgupVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzgus zzc() {
        int i = this.zzf;
        zzgus zzgusVar = zzgus.UNKNOWN_KEYMATERIAL;
        zzgus zzgusVar2 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? null : zzgus.REMOTE : zzgus.ASYMMETRIC_PUBLIC : zzgus.ASYMMETRIC_PRIVATE : zzgus.SYMMETRIC : zzgus.UNKNOWN_KEYMATERIAL;
        return zzgusVar2 == null ? zzgus.UNRECOGNIZED : zzgusVar2;
    }

    public final zzgyl zzf() {
        return this.zze;
    }

    public final String zzg() {
        return this.zzd;
    }
}
