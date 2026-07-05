package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.AbstractMap;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes3.dex */
final class zzci extends zzbn {
    final /* synthetic */ zzcj zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzci(zzcj zzcjVar) {
        this.zza = zzcjVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        int i2;
        Object[] objArr;
        Object[] objArr2;
        i2 = this.zza.zzc;
        zzaa.zza(i, i2, "index");
        zzcj zzcjVar = this.zza;
        objArr = zzcjVar.zzb;
        int i3 = i + i;
        Object obj = objArr[i3];
        obj.getClass();
        objArr2 = zzcjVar.zzb;
        Object obj2 = objArr2[i3 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i;
        i = this.zza.zzc;
        return i;
    }
}
