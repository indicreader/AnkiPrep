package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgac {
    Object[] zza;
    int zzb;
    zzgab zzc;

    public zzgac() {
        this(4);
    }

    private final void zzd(int i) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            this.zza = Arrays.copyOf(objArr, zzfzu.zze(length, i2));
        }
    }

    public final zzgac zza(Object obj, Object obj2) {
        zzd(this.zzb + 1);
        zzfyx.zzb(obj, obj2);
        Object[] objArr = this.zza;
        int i = this.zzb;
        int i2 = i + i;
        objArr[i2] = obj;
        objArr[i2 + 1] = obj2;
        this.zzb = i + 1;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzgac zzb(Iterable iterable) {
        if (iterable instanceof Collection) {
            zzd(this.zzb + iterable.size());
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zza(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public final zzgad zzc() {
        zzgab zzgabVar = this.zzc;
        if (zzgabVar == null) {
            zzgbp zzj = zzgbp.zzj(this.zzb, this.zza, this);
            zzgab zzgabVar2 = this.zzc;
            if (zzgabVar2 == null) {
                return zzj;
            }
            throw zzgabVar2.zza();
        }
        throw zzgabVar.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgac(int i) {
        this.zza = new Object[i + i];
        this.zzb = 0;
    }
}
