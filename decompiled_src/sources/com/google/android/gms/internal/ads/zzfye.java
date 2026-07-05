package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzfye extends zzgar {
    final /* synthetic */ zzfyg zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfye(zzfyg zzfygVar) {
        this.zza = zzfygVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgar, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        return zzfyz.zza(this.zza.zza.entrySet(), obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzfyf(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzgar, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@CheckForNull Object obj) {
        if (!contains(obj)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) Objects.requireNonNull((Map.Entry) obj);
        zzfyg zzfygVar = this.zza;
        zzfyt.zzo(zzfygVar.zzb, entry.getKey());
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgar
    final Map zza() {
        return this.zza;
    }
}
