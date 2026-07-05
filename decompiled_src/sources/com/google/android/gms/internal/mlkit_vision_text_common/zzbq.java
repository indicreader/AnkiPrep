package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes3.dex */
public abstract class zzbq extends zzbi implements Set {

    @CheckForNull
    private transient zzbn zza;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return zzco.zza(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzbi, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd */
    public abstract zzcr iterator();

    public final zzbn zzf() {
        zzbn zzbnVar = this.zza;
        if (zzbnVar != null) {
            return zzbnVar;
        }
        zzbn zzg = zzg();
        this.zza = zzg;
        return zzg;
    }

    zzbn zzg() {
        Object[] array = toArray();
        int i = zzbn.zzd;
        return zzbn.zzg(array, array.length);
    }
}
