package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes3.dex */
abstract class zzaz implements Iterator {
    int zzb;
    int zzc;
    int zzd;
    final /* synthetic */ zzbd zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzaz(zzbd zzbdVar, zzay zzayVar) {
        int i;
        this.zze = zzbdVar;
        i = zzbdVar.zzf;
        this.zzb = i;
        this.zzc = zzbdVar.zze();
        this.zzd = -1;
    }

    private final void zzb() {
        int i;
        i = this.zze.zzf;
        if (i != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzc >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        zzb();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.zzc;
        this.zzd = i;
        Object zza = zza(i);
        this.zzc = this.zze.zzf(this.zzc);
        return zza;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzb();
        zzaa.zzd(this.zzd >= 0, "no calls to next() since the last call to remove()");
        this.zzb += 32;
        zzbd zzbdVar = this.zze;
        int i = this.zzd;
        Object[] objArr = zzbdVar.zzb;
        objArr.getClass();
        zzbdVar.remove(objArr[i]);
        this.zzc--;
        this.zzd = -1;
    }

    abstract Object zza(int i);
}
