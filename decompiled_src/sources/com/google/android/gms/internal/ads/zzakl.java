package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzakl {
    public static void zza(zzakm zzakmVar, zzakq zzakqVar, zzep zzepVar) {
        for (int i = 0; i < zzakmVar.zza(); i++) {
            long zzb = zzakmVar.zzb(i);
            List zzc = zzakmVar.zzc(zzb);
            if (!zzc.isEmpty()) {
                if (i != zzakmVar.zza() - 1) {
                    zzepVar.zza(new zzakj(zzc, zzb, zzakmVar.zzb(i + 1) - zzakmVar.zzb(i)));
                } else {
                    throw new IllegalStateException();
                }
            }
        }
    }
}
