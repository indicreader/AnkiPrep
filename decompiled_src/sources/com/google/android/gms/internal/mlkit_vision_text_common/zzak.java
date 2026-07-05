package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes3.dex */
class zzak implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzal zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzak(zzal zzalVar) {
        Iterator it;
        this.zzc = zzalVar;
        this.zzb = zzalVar.zzb;
        Collection collection = zzalVar.zzb;
        if (collection instanceof List) {
            it = ((List) collection).listIterator();
        } else {
            it = collection.iterator();
        }
        this.zza = it;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzak(zzal zzalVar, Iterator it) {
        this.zzc = zzalVar;
        this.zzb = zzalVar.zzb;
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
        zzao zzaoVar = this.zzc.zze;
        i = zzaoVar.zzb;
        zzaoVar.zzb = i - 1;
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
