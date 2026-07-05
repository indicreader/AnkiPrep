package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgst extends zzgzu implements zzhbf {
    private static final zzgst zzb;
    private int zzd;
    private zzgsz zze;
    private zzgul zzf;

    static {
        zzgst zzgstVar = new zzgst();
        zzb = zzgstVar;
        zzgzu.zzaU(zzgst.class, zzgstVar);
    }

    private zzgst() {
    }

    public static zzgss zza() {
        return (zzgss) zzb.zzaA();
    }

    public static zzgst zzd(zzgyl zzgylVar, zzgzf zzgzfVar) throws zzhag {
        return (zzgst) zzgzu.zzaG(zzb, zzgylVar, zzgzfVar);
    }

    public static /* synthetic */ void zzg(zzgst zzgstVar, zzgsz zzgszVar) {
        zzgszVar.getClass();
        zzgstVar.zze = zzgszVar;
        zzgstVar.zzd |= 1;
    }

    public static /* synthetic */ void zzh(zzgst zzgstVar, zzgul zzgulVar) {
        zzgulVar.getClass();
        zzgstVar.zzf = zzgulVar;
        zzgstVar.zzd |= 2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzgst();
        }
        if (i2 == 4) {
            return new zzgss(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzgsz zze() {
        zzgsz zzgszVar = this.zze;
        return zzgszVar == null ? zzgsz.zze() : zzgszVar;
    }

    public final zzgul zzf() {
        zzgul zzgulVar = this.zzf;
        return zzgulVar == null ? zzgul.zzf() : zzgulVar;
    }
}
