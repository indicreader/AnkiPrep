package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes3.dex */
public final class zzqc {
    private static zzqb zza;

    public static synchronized zzpr zza(zzpl zzplVar) {
        zzpr zzprVar;
        synchronized (zzqc.class) {
            if (zza == null) {
                zza = new zzqb(null);
            }
            zzprVar = (zzpr) zza.get(zzplVar);
        }
        return zzprVar;
    }

    public static synchronized zzpr zzb(String str) {
        zzpr zza2;
        synchronized (zzqc.class) {
            zza2 = zza(zzpl.zzd("common").zzd());
        }
        return zza2;
    }
}
