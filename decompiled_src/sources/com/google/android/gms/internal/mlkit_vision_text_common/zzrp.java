package com.google.android.gms.internal.mlkit_vision_text_common;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes3.dex */
public final class zzrp {
    private static zzrp zza;

    private zzrp() {
    }

    public static synchronized zzrp zza() {
        zzrp zzrpVar;
        synchronized (zzrp.class) {
            if (zza == null) {
                zza = new zzrp();
            }
            zzrpVar = zza;
        }
        return zzrpVar;
    }
}
