package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes3.dex */
public final class zzqf {
    private static zzqf zza;

    private zzqf() {
    }

    public static synchronized zzqf zza() {
        zzqf zzqfVar;
        synchronized (zzqf.class) {
            if (zza == null) {
                zza = new zzqf();
            }
            zzqfVar = zza;
        }
        return zzqfVar;
    }

    public static void zzb() {
        zzqe.zza();
    }
}
