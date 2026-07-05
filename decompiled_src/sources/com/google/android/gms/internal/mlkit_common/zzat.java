package com.google.android.gms.internal.mlkit_common;

import java.util.Arrays;

/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes3.dex */
public final class zzat {
    Object[] zza = new Object[8];
    int zzb = 0;
    zzas zzc;

    public final zzat zza(Object obj, Object obj2) {
        int i = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            this.zza = Arrays.copyOf(objArr, zzam.zza(length, i2));
        }
        zzai.zza(obj, obj2);
        Object[] objArr2 = this.zza;
        int i3 = this.zzb;
        int i4 = i3 + i3;
        objArr2[i4] = obj;
        objArr2[i4 + 1] = obj2;
        this.zzb = i3 + 1;
        return this;
    }

    public final zzau zzb() {
        zzas zzasVar = this.zzc;
        if (zzasVar == null) {
            zzbc zzg = zzbc.zzg(this.zzb, this.zza, this);
            zzas zzasVar2 = this.zzc;
            if (zzasVar2 == null) {
                return zzg;
            }
            throw zzasVar2.zza();
        }
        throw zzasVar.zza();
    }
}
