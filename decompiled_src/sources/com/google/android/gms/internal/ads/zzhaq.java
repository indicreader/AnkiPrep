package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzhaq extends zzhas {
    private zzhaq() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzhaq(zzhap zzhapVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzhas
    public final List zza(Object obj, long j) {
        zzhad zzhadVar = (zzhad) zzhcz.zzh(obj, j);
        if (zzhadVar.zzc()) {
            return zzhadVar;
        }
        int size = zzhadVar.size();
        zzhad zzd = zzhadVar.zzd(size == 0 ? 10 : size + size);
        zzhcz.zzv(obj, j, zzd);
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzhas
    public final void zzb(Object obj, long j) {
        ((zzhad) zzhcz.zzh(obj, j)).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzhas
    public final void zzc(Object obj, Object obj2, long j) {
        zzhad zzhadVar = (zzhad) zzhcz.zzh(obj, j);
        zzhad zzhadVar2 = (zzhad) zzhcz.zzh(obj2, j);
        int size = zzhadVar.size();
        int size2 = zzhadVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzhadVar.zzc()) {
                zzhadVar = zzhadVar.zzd(size2 + size);
            }
            zzhadVar.addAll(zzhadVar2);
        }
        if (size > 0) {
            zzhadVar2 = zzhadVar;
        }
        zzhcz.zzv(obj, j, zzhadVar2);
    }
}
