package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
/* loaded from: classes3.dex */
public final class zzlr {
    private static final zzlr zza = new zzlr();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzlv zzb = new zzlb();

    private zzlr() {
    }

    public static zzlr zza() {
        return zza;
    }

    public final zzlu zzb(Class cls) {
        zzkk.zzf(cls, "messageType");
        zzlu zzluVar = (zzlu) this.zzc.get(cls);
        if (zzluVar == null) {
            zzluVar = this.zzb.zza(cls);
            zzkk.zzf(cls, "messageType");
            zzkk.zzf(zzluVar, "schema");
            zzlu zzluVar2 = (zzlu) this.zzc.putIfAbsent(cls, zzluVar);
            if (zzluVar2 != null) {
                return zzluVar2;
            }
        }
        return zzluVar;
    }
}
