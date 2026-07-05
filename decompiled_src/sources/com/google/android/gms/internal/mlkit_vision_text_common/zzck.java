package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes3.dex */
final class zzck extends zzbq {
    private final transient zzbp zza;
    private final transient zzbn zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzck(zzbp zzbpVar, zzbn zzbnVar) {
        this.zza = zzbpVar;
        this.zzb = zzbnVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzbi, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzbq, com.google.android.gms.internal.mlkit_vision_text_common.zzbi, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzbi
    public final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzbq, com.google.android.gms.internal.mlkit_vision_text_common.zzbi
    /* renamed from: zzd */
    public final zzcr iterator() {
        return this.zzb.listIterator(0);
    }
}
