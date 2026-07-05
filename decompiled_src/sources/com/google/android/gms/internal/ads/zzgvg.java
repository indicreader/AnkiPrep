package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgvg extends zzgzu implements zzhbf {
    private static final zzgvg zzb;
    private int zzd;
    private zzhad zze = zzaN();

    static {
        zzgvg zzgvgVar = new zzgvg();
        zzb = zzgvgVar;
        zzgzu.zzaU(zzgvg.class, zzgvgVar);
    }

    private zzgvg() {
    }

    public static zzgvd zzd() {
        return (zzgvd) zzb.zzaA();
    }

    public static zzgvg zzg(InputStream inputStream, zzgzf zzgzfVar) throws IOException {
        return (zzgvg) zzgzu.zzaH(zzb, inputStream, zzgzfVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzj(zzgvg zzgvgVar, zzgvf zzgvfVar) {
        zzgvfVar.getClass();
        zzhad zzhadVar = zzgvgVar.zze;
        if (!zzhadVar.zzc()) {
            zzgvgVar.zze = zzgzu.zzaO(zzhadVar);
        }
        zzgvgVar.zze.add(zzgvfVar);
    }

    public final int zza() {
        return this.zze.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaR(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzd", "zze", zzgvf.class});
        }
        if (i2 == 3) {
            return new zzgvg();
        }
        zzgvc zzgvcVar = null;
        if (i2 == 4) {
            return new zzgvd(zzgvcVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final zzgvf zze(int i) {
        return (zzgvf) this.zze.get(i);
    }

    public final List zzh() {
        return this.zze;
    }
}
