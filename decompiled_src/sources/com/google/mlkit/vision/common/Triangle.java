package com.google.mlkit.vision.common;

import com.google.android.gms.internal.mlkit_vision_common.zzp;
import java.util.List;

/* compiled from: com.google.mlkit:vision-common@@17.3.0 */
/* loaded from: classes4.dex */
public class Triangle<T> {
    private final zzp zza;

    public Triangle(T t, T t2, T t3) {
        this.zza = zzp.zzj(t, t2, t3);
    }

    public List<T> getAllPoints() {
        return this.zza;
    }
}
