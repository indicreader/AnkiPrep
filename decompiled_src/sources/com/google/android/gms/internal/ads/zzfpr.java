package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.IntentFilter;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfpr {
    private static int zza = 2;

    public static void zza(Context context) {
        context.registerReceiver(new zzfpq(), new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
    }

    public static int zzb() {
        if (zzfpn.zza() != zzfoj.CTV) {
            return 2;
        }
        return zza;
    }
}
