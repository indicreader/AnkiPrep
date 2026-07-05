package com.google.android.gms.internal.ads;

import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public class zzgbv extends zzfyy implements Set {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgbv(Set set, zzfxf zzfxfVar) {
        super(set, zzfxfVar);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        return zzgca.zzd(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return zzgca.zza(this);
    }
}
