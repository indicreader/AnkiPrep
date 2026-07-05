package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
class zzfyp implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzfyq zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfyp(zzfyq zzfyqVar) {
        Iterator it;
        this.zzc = zzfyqVar;
        this.zzb = zzfyqVar.zzb;
        Collection collection = zzfyqVar.zzb;
        if (collection instanceof List) {
            it = ((List) collection).listIterator();
        } else {
            it = collection.iterator();
        }
        this.zza = it;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfyp(zzfyq zzfyqVar, Iterator it) {
        this.zzc = zzfyqVar;
        this.zzb = zzfyqVar.zzb;
        this.zza = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        zza();
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i;
        this.zza.remove();
        zzfyt zzfytVar = this.zzc.zze;
        i = zzfytVar.zzb;
        zzfytVar.zzb = i - 1;
        this.zzc.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        this.zzc.zzb();
        if (this.zzc.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }
}
