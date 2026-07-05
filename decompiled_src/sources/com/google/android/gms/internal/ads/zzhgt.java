package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzhgt implements Iterator {
    int zza = 0;
    final /* synthetic */ zzhgu zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhgt(zzhgu zzhguVar) {
        this.zzb = zzhguVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza < this.zzb.zza.size() || this.zzb.zzb.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.zza < this.zzb.zza.size()) {
            zzhgu zzhguVar = this.zzb;
            int i = this.zza;
            this.zza = i + 1;
            return zzhguVar.zza.get(i);
        }
        zzhgu zzhguVar2 = this.zzb;
        zzhguVar2.zza.add(zzhguVar2.zzb.next());
        return next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
