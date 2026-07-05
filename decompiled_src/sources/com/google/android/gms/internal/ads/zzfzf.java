package com.google.android.gms.internal.ads;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
abstract class zzfzf implements Iterator {
    int zzb;
    int zzc;
    int zzd;
    final /* synthetic */ zzfzj zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfzf(zzfzj zzfzjVar, zzfze zzfzeVar) {
        int i;
        this.zze = zzfzjVar;
        i = zzfzjVar.zzf;
        this.zzb = i;
        this.zzc = zzfzjVar.zze();
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
        zzfxe.zzj(this.zzd >= 0, "no calls to next() since the last call to remove()");
        this.zzb += 32;
        int i = this.zzd;
        zzfzj zzfzjVar = this.zze;
        zzfzjVar.remove(zzfzj.zzg(zzfzjVar, i));
        this.zzc--;
        this.zzd = -1;
    }

    abstract Object zza(int i);
}
