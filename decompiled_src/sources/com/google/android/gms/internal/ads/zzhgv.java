package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzhgv {
    public static zzhgv zzb(Class cls) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
            return new zzhgq(cls.getSimpleName());
        }
        return new zzhgs(cls.getSimpleName());
    }

    public abstract void zza(String str);
}
