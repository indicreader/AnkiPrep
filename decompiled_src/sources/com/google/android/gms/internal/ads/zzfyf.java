package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzfyf implements Iterator {
    final Iterator zza;

    @CheckForNull
    Collection zzb;
    final /* synthetic */ zzfyg zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfyf(zzfyg zzfygVar) {
        this.zzc = zzfygVar;
        this.zza = zzfygVar.zza.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        this.zzb = (Collection) entry.getValue();
        return this.zzc.zza(entry);
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i;
        zzfxe.zzj(this.zzb != null, "no calls to next() since the last call to remove()");
        this.zza.remove();
        zzfyt zzfytVar = this.zzc.zzb;
        i = zzfytVar.zzb;
        zzfytVar.zzb = i - this.zzb.size();
        this.zzb.clear();
        this.zzb = null;
    }
}
