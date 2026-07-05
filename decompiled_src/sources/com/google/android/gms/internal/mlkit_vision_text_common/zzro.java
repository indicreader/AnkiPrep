package com.google.android.gms.internal.mlkit_vision_text_common;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes3.dex */
public final class zzro {
    private static zzrn zza;

    public static synchronized zzrd zza(zzqv zzqvVar) {
        zzrd zzrdVar;
        synchronized (zzro.class) {
            if (zza == null) {
                zza = new zzrn(null);
            }
            zzrdVar = (zzrd) zza.get(zzqvVar);
        }
        return zzrdVar;
    }

    public static synchronized zzrd zzb(String str) {
        zzrd zza2;
        synchronized (zzro.class) {
            zza2 = zza(zzqv.zzd(str).zzd());
        }
        return zza2;
    }
}
