package com.google.mlkit.vision.text.internal;

import com.google.android.gms.dynamite.DynamiteModule;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes4.dex */
public final class TextRecognizerOptionsUtils {
    private TextRecognizerOptionsUtils() {
    }

    public static boolean isThickClient(AtomicReference<Boolean> atomicReference, String str) {
        if (atomicReference.get() != null) {
            return atomicReference.get().booleanValue();
        }
        boolean z = DynamiteModule.getLocalVersion(MlKitContext.getInstance().getApplicationContext(), str) > 0;
        atomicReference.set(Boolean.valueOf(z));
        return z;
    }
}
