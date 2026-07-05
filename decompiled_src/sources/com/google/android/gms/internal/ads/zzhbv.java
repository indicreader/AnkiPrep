package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzhbv implements Iterator {
    private final ArrayDeque zza;
    private zzgyg zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzhbv(zzgyl zzgylVar, zzhbu zzhbuVar) {
        zzgyl zzgylVar2;
        if (zzgylVar instanceof zzhbx) {
            zzhbx zzhbxVar = (zzhbx) zzgylVar;
            ArrayDeque arrayDeque = new ArrayDeque(zzhbxVar.zzf());
            this.zza = arrayDeque;
            arrayDeque.push(zzhbxVar);
            zzgylVar2 = zzhbxVar.zzd;
            this.zzb = zzb(zzgylVar2);
            return;
        }
        this.zza = null;
        this.zzb = (zzgyg) zzgylVar;
    }

    private final zzgyg zzb(zzgyl zzgylVar) {
        while (zzgylVar instanceof zzhbx) {
            zzhbx zzhbxVar = (zzhbx) zzgylVar;
            this.zza.push(zzhbxVar);
            zzgylVar = zzhbxVar.zzd;
        }
        return (zzgyg) zzgylVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzgyg next() {
        zzgyg zzgygVar;
        zzgyl zzgylVar;
        zzgyg zzgygVar2 = this.zzb;
        if (zzgygVar2 == null) {
            throw new NoSuchElementException();
        }
        do {
            ArrayDeque arrayDeque = this.zza;
            zzgygVar = null;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                break;
            }
            zzgylVar = ((zzhbx) this.zza.pop()).zze;
            zzgygVar = zzb(zzgylVar);
        } while (zzgygVar.zzd() == 0);
        this.zzb = zzgygVar;
        return zzgygVar2;
    }
}
