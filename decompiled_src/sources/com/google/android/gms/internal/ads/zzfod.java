package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzfod {
    public abstract void zzb(View view, zzfok zzfokVar, String str);

    public abstract void zzc();

    public abstract void zzd(View view);

    public abstract void zze();

    public static zzfod zza(zzfoe zzfoeVar, zzfof zzfofVar) {
        if (zzfob.zzb()) {
            return new zzfoh(zzfoeVar, zzfofVar);
        }
        throw new IllegalStateException("Method called before OM SDK activation");
    }
}
