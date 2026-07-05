package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzaim extends zzaio {
    public final long zza;
    public final List zzb;
    public final List zzc;

    public zzaim(int i, long j) {
        super(i);
        this.zza = j;
        this.zzb = new ArrayList();
        this.zzc = new ArrayList();
    }

    @Override // com.google.android.gms.internal.ads.zzaio
    public final String toString() {
        List list = this.zzb;
        return zzf(this.zzd) + " leaves: " + Arrays.toString(list.toArray()) + " containers: " + Arrays.toString(this.zzc.toArray());
    }

    public final zzaim zza(int i) {
        int size = this.zzc.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzaim zzaimVar = (zzaim) this.zzc.get(i2);
            if (zzaimVar.zzd == i) {
                return zzaimVar;
            }
        }
        return null;
    }

    public final zzain zzb(int i) {
        int size = this.zzb.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzain zzainVar = (zzain) this.zzb.get(i2);
            if (zzainVar.zzd == i) {
                return zzainVar;
            }
        }
        return null;
    }

    public final void zzc(zzaim zzaimVar) {
        this.zzc.add(zzaimVar);
    }

    public final void zzd(zzain zzainVar) {
        this.zzb.add(zzainVar);
    }
}
