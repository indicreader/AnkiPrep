package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzaoe implements zzanx {
    final /* synthetic */ zzaog zza;
    private final zzfo zzb = new zzfo(new byte[4], 4);

    public zzaoe(zzaog zzaogVar) {
        this.zza = zzaogVar;
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final void zza(zzfp zzfpVar) {
        SparseArray sparseArray;
        SparseArray sparseArray2;
        SparseArray sparseArray3;
        int i;
        if (zzfpVar.zzm() == 0 && (zzfpVar.zzm() & 128) != 0) {
            zzfpVar.zzL(6);
            int zzb = zzfpVar.zzb() / 4;
            for (int i2 = 0; i2 < zzb; i2++) {
                zzfpVar.zzF(this.zzb, 4);
                zzfo zzfoVar = this.zzb;
                int zzd = zzfoVar.zzd(16);
                zzfoVar.zzm(3);
                if (zzd == 0) {
                    this.zzb.zzm(13);
                } else {
                    int zzd2 = this.zzb.zzd(13);
                    sparseArray2 = this.zza.zzg;
                    if (sparseArray2.get(zzd2) == null) {
                        zzaog zzaogVar = this.zza;
                        sparseArray3 = zzaogVar.zzg;
                        sparseArray3.put(zzd2, new zzany(new zzaof(zzaogVar, zzd2)));
                        zzaog zzaogVar2 = this.zza;
                        i = zzaogVar2.zzm;
                        zzaogVar2.zzm = i + 1;
                    }
                }
            }
            sparseArray = this.zza.zzg;
            sparseArray.remove(0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final void zzb(zzfw zzfwVar, zzacx zzacxVar, zzaok zzaokVar) {
    }
}
