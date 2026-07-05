package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
/* loaded from: classes3.dex */
public final class zzjo {
    static final zzjo zza = new zzjo(true);
    private static volatile boolean zzb = false;
    private static volatile zzjo zzc;
    private static volatile zzjo zzd;
    private final Map zze;

    zzjo() {
        this.zze = new HashMap();
    }

    public static zzjo zza() {
        zzjo zzjoVar = zzc;
        if (zzjoVar == null) {
            synchronized (zzjo.class) {
                zzjoVar = zzc;
                if (zzjoVar == null) {
                    zzjoVar = zza;
                    zzc = zzjoVar;
                }
            }
        }
        return zzjoVar;
    }

    public final zzka zzc(zzlj zzljVar, int i) {
        return (zzka) this.zze.get(new zzjn(zzljVar, i));
    }

    zzjo(boolean z) {
        this.zze = Collections.emptyMap();
    }

    public static zzjo zzb() {
        zzjo zzjoVar = zzd;
        if (zzjoVar != null) {
            return zzjoVar;
        }
        synchronized (zzjo.class) {
            zzjo zzjoVar2 = zzd;
            if (zzjoVar2 != null) {
                return zzjoVar2;
            }
            zzjo zzb2 = zzjw.zzb(zzjo.class);
            zzd = zzb2;
            return zzb2;
        }
    }
}
