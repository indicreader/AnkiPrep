package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.PowerManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzmn {
    private final PowerManager zza;

    public zzmn(Context context) {
        this.zza = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}
