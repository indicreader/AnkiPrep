package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzhhc implements zzhhm, zzhgx {
    private static final Object zza = new Object();
    private volatile zzhhm zzb;
    private volatile Object zzc = zza;

    private zzhhc(zzhhm zzhhmVar) {
        this.zzb = zzhhmVar;
    }

    public static zzhgx zza(zzhhm zzhhmVar) {
        return zzhhmVar instanceof zzhgx ? (zzhgx) zzhhmVar : new zzhhc(zzhhmVar);
    }

    public static zzhhm zzc(zzhhm zzhhmVar) {
        return zzhhmVar instanceof zzhhc ? zzhhmVar : new zzhhc(zzhhmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final Object zzb() {
        Object obj = this.zzc;
        Object obj2 = zza;
        if (obj == obj2) {
            synchronized (this) {
                obj = this.zzc;
                if (obj == obj2) {
                    obj = this.zzb.zzb();
                    Object obj3 = this.zzc;
                    if (obj3 != obj2 && obj3 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.zzc = obj;
                    this.zzb = null;
                }
            }
        }
        return obj;
    }
}
