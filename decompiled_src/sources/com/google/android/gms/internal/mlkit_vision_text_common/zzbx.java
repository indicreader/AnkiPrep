package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes3.dex */
public final class zzbx {
    public static List zza(List list, zzu zzuVar) {
        if (list instanceof RandomAccess) {
            return new zzbu(list, zzuVar);
        }
        return new zzbw(list, zzuVar);
    }
}
