package com.google.android.gms.internal.consent_sdk;

import android.os.Build;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.2.0 */
/* loaded from: classes3.dex */
public final class zzct {
    public static boolean zza(boolean z) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Build.FINGERPRINT.contains("generic") || Build.FINGERPRINT.contains("emulator") || Build.HARDWARE.contains("ranchu");
        }
        return Build.DEVICE.startsWith("generic");
    }
}
