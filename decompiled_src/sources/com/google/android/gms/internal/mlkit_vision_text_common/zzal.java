package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes3.dex */
class zzal extends AbstractCollection {
    final Object zza;
    Collection zzb;

    @CheckForNull
    final zzal zzc;

    @CheckForNull
    final Collection zzd;
    final /* synthetic */ zzao zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzal(zzao zzaoVar, Object obj, @CheckForNull Collection collection, zzal zzalVar) {
        this.zze = zzaoVar;
        this.zza = obj;
        this.zzb = collection;
        this.zzc = zzalVar;
        this.zzd = zzalVar == null ? null : zzalVar.zzb;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        zzb();
        boolean isEmpty = this.zzb.isEmpty();
        boolean add = this.zzb.add(obj);
        if (add) {
            zzao zzaoVar = this.zze;
            zzao.zzj(zzaoVar, zzao.zzd(zzaoVar) + 1);
            if (isEmpty) {
                zza();
                return true;
            }
        }
        return add;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = this.zzb.addAll(collection);
        if (!addAll) {
            return addAll;
        }
        int size2 = this.zzb.size();
        zzao zzaoVar = this.zze;
        zzao.zzj(zzaoVar, zzao.zzd(zzaoVar) + (size2 - size));
        if (size != 0) {
            return addAll;
        }
        zza();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        int size = size();
        if (size == 0) {
            return;
        }
        this.zzb.clear();
        zzao zzaoVar = this.zze;
        zzao.zzj(zzaoVar, zzao.zzd(zzaoVar) - size);
        zzc();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        zzb();
        return this.zzb.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection collection) {
        zzb();
        return this.zzb.containsAll(collection);
    }

    @Override // java.util.Collection
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        zzb();
        return this.zzb.equals(obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        zzb();
        return this.zzb.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzb();
        return new zzak(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(@CheckForNull Object obj) {
        zzb();
        boolean remove = this.zzb.remove(obj);
        if (remove) {
            zzao.zzj(this.zze, zzao.zzd(r0) - 1);
            zzc();
        }
        return remove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean removeAll = this.zzb.removeAll(collection);
        if (removeAll) {
            int size2 = this.zzb.size();
            zzao zzaoVar = this.zze;
            zzao.zzj(zzaoVar, zzao.zzd(zzaoVar) + (size2 - size));
            zzc();
        }
        return removeAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        zzb();
        return this.zzb.size();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        zzb();
        return this.zzb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        zzal zzalVar = this.zzc;
        if (zzalVar != null) {
            zzalVar.zza();
        } else {
            zzao.zzg(this.zze).put(this.zza, this.zzb);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb() {
        Collection collection;
        zzal zzalVar = this.zzc;
        if (zzalVar != null) {
            zzalVar.zzb();
            if (this.zzc.zzb != this.zzd) {
                throw new ConcurrentModificationException();
            }
        } else {
            if (!this.zzb.isEmpty() || (collection = (Collection) zzao.zzg(this.zze).get(this.zza)) == null) {
                return;
            }
            this.zzb = collection;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc() {
        zzal zzalVar = this.zzc;
        if (zzalVar != null) {
            zzalVar.zzc();
        } else if (this.zzb.isEmpty()) {
            zzao.zzg(this.zze).remove(this.zza);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        int size = size();
        boolean retainAll = this.zzb.retainAll(collection);
        if (retainAll) {
            int size2 = this.zzb.size();
            zzao zzaoVar = this.zze;
            zzao.zzj(zzaoVar, zzao.zzd(zzaoVar) + (size2 - size));
            zzc();
        }
        return retainAll;
    }
}
