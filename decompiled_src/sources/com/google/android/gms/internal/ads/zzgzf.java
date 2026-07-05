package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgzf {
    static final zzgzf zza = new zzgzf(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzgzf zzd;
    private final Map zze;

    zzgzf() {
        this.zze = new HashMap();
    }

    public static zzgzf zza() {
        return zza;
    }

    public final zzgzs zzc(zzhbe zzhbeVar, int i) {
        return (zzgzs) this.zze.get(new zzgze(zzhbeVar, i));
    }

    zzgzf(boolean z) {
        this.zze = Collections.emptyMap();
    }

    public static zzgzf zzb() {
        zzgzf zzgzfVar = zzd;
        if (zzgzfVar != null) {
            return zzgzfVar;
        }
        synchronized (zzgzf.class) {
            zzgzf zzgzfVar2 = zzd;
            if (zzgzfVar2 != null) {
                return zzgzfVar2;
            }
            zzgzf zzb2 = zzgzn.zzb(zzgzf.class);
            zzd = zzb2;
            return zzb2;
        }
    }
}
