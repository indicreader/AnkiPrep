package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzlt implements zzvb, zzrt {
    final /* synthetic */ zzlx zza;
    private final zzlv zzb;

    public zzlt(zzlx zzlxVar, zzlv zzlvVar) {
        this.zza = zzlxVar;
        this.zzb = zzlvVar;
    }

    private final Pair zzf(int i, zzur zzurVar) {
        zzur zzurVar2;
        zzur zzurVar3 = null;
        if (zzurVar != null) {
            zzlv zzlvVar = this.zzb;
            int i2 = 0;
            while (true) {
                if (i2 >= zzlvVar.zzc.size()) {
                    zzurVar2 = null;
                    break;
                }
                if (((zzur) zzlvVar.zzc.get(i2)).zzd == zzurVar.zzd) {
                    zzurVar2 = zzurVar.zza(Pair.create(zzlvVar.zzb, zzurVar.zza));
                    break;
                }
                i2++;
            }
            if (zzurVar2 == null) {
                return null;
            }
            zzurVar3 = zzurVar2;
        }
        return Pair.create(Integer.valueOf(this.zzb.zzd), zzurVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final void zzae(int i, zzur zzurVar, final zzun zzunVar) {
        zzew zzewVar;
        final Pair zzf = zzf(0, zzurVar);
        if (zzf != null) {
            zzewVar = this.zza.zzi;
            zzewVar.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlr
                @Override // java.lang.Runnable
                public final void run() {
                    zzmp zzmpVar;
                    Pair pair = zzf;
                    zzmpVar = zzlt.this.zza.zzh;
                    zzmpVar.zzae(((Integer) pair.first).intValue(), (zzur) pair.second, zzunVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final void zzaf(int i, zzur zzurVar, final zzui zzuiVar, final zzun zzunVar) {
        zzew zzewVar;
        final Pair zzf = zzf(0, zzurVar);
        if (zzf != null) {
            zzewVar = this.zza.zzi;
            zzewVar.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlp
                @Override // java.lang.Runnable
                public final void run() {
                    zzmp zzmpVar;
                    Pair pair = zzf;
                    zzmpVar = zzlt.this.zza.zzh;
                    zzmpVar.zzaf(((Integer) pair.first).intValue(), (zzur) pair.second, zzuiVar, zzunVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final void zzag(int i, zzur zzurVar, final zzui zzuiVar, final zzun zzunVar) {
        zzew zzewVar;
        final Pair zzf = zzf(0, zzurVar);
        if (zzf != null) {
            zzewVar = this.zza.zzi;
            zzewVar.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzls
                @Override // java.lang.Runnable
                public final void run() {
                    zzmp zzmpVar;
                    Pair pair = zzf;
                    zzmpVar = zzlt.this.zza.zzh;
                    zzmpVar.zzag(((Integer) pair.first).intValue(), (zzur) pair.second, zzuiVar, zzunVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final void zzah(int i, zzur zzurVar, final zzui zzuiVar, final zzun zzunVar, final IOException iOException, final boolean z) {
        zzew zzewVar;
        final Pair zzf = zzf(0, zzurVar);
        if (zzf != null) {
            zzewVar = this.zza.zzi;
            zzewVar.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlo
                @Override // java.lang.Runnable
                public final void run() {
                    zzmp zzmpVar;
                    Pair pair = zzf;
                    zzmpVar = zzlt.this.zza.zzh;
                    zzmpVar.zzah(((Integer) pair.first).intValue(), (zzur) pair.second, zzuiVar, zzunVar, iOException, z);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final void zzai(int i, zzur zzurVar, final zzui zzuiVar, final zzun zzunVar) {
        zzew zzewVar;
        final Pair zzf = zzf(0, zzurVar);
        if (zzf != null) {
            zzewVar = this.zza.zzi;
            zzewVar.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlq
                @Override // java.lang.Runnable
                public final void run() {
                    zzmp zzmpVar;
                    Pair pair = zzf;
                    zzmpVar = zzlt.this.zza.zzh;
                    zzmpVar.zzai(((Integer) pair.first).intValue(), (zzur) pair.second, zzuiVar, zzunVar);
                }
            });
        }
    }
}
