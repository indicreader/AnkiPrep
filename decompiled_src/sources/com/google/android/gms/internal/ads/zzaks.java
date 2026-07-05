package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzaks implements zzacx {
    private final zzacx zzb;
    private final zzakp zzc;
    private final SparseArray zzd = new SparseArray();

    public zzaks(zzacx zzacxVar, zzakp zzakpVar) {
        this.zzb = zzacxVar;
        this.zzc = zzakpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacx
    public final void zzD() {
        this.zzb.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzacx
    public final void zzO(zzadu zzaduVar) {
        this.zzb.zzO(zzaduVar);
    }

    @Override // com.google.android.gms.internal.ads.zzacx
    public final zzaea zzw(int i, int i2) {
        if (i2 != 3) {
            return this.zzb.zzw(i, i2);
        }
        zzaku zzakuVar = (zzaku) this.zzd.get(i);
        if (zzakuVar != null) {
            return zzakuVar;
        }
        zzaku zzakuVar2 = new zzaku(this.zzb.zzw(i, 3), this.zzc);
        this.zzd.put(i, zzakuVar2);
        return zzakuVar2;
    }
}
