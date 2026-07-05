package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhbn {
    private static final zzhbn zza = new zzhbn();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzhbz zzb = new zzhaw();

    private zzhbn() {
    }

    public static zzhbn zza() {
        return zza;
    }

    public final zzhby zzb(Class cls) {
        zzhae.zzc(cls, "messageType");
        zzhby zzhbyVar = (zzhby) this.zzc.get(cls);
        if (zzhbyVar == null) {
            zzhbyVar = this.zzb.zza(cls);
            zzhae.zzc(cls, "messageType");
            zzhby zzhbyVar2 = (zzhby) this.zzc.putIfAbsent(cls, zzhbyVar);
            if (zzhbyVar2 != null) {
                return zzhbyVar2;
            }
        }
        return zzhbyVar;
    }
}
