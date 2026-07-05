package com.google.android.gms.internal.ads;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzfwz implements Serializable {
    public static zzfwz zzc() {
        return zzfwi.zza;
    }

    public static zzfwz zzd(@CheckForNull Object obj) {
        return obj == null ? zzfwi.zza : new zzfxj(obj);
    }

    public abstract zzfwz zza(zzfws zzfwsVar);

    public abstract Object zzb(Object obj);
}
