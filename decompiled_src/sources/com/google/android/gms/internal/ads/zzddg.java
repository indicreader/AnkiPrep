package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzddg extends zzdgl implements zzdbr, zzdcw {
    private final zzfgm zzb;
    private final AtomicBoolean zzc;

    public zzddg(Set set, zzfgm zzfgmVar) {
        super(set);
        this.zzc = new AtomicBoolean();
        this.zzb = zzfgmVar;
    }

    private final void zzb() {
        com.google.android.gms.ads.internal.client.zzs zzsVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhH)).booleanValue() && this.zzc.compareAndSet(false, true) && (zzsVar = this.zzb.zzaf) != null && zzsVar.zza == 3) {
            zzu(new zzdgk() { // from class: com.google.android.gms.internal.ads.zzddf
                @Override // com.google.android.gms.internal.ads.zzdgk
                public final void zza(Object obj) {
                    zzddg.this.zza((zzddi) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzddi zzddiVar) throws Exception {
        zzddiVar.zzh(this.zzb.zzaf);
    }

    @Override // com.google.android.gms.internal.ads.zzdcw
    public final void zzg() {
        if (this.zzb.zzb == 1) {
            zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbr
    public final void zzq() {
        int i = this.zzb.zzb;
        if (i == 2 || i == 5 || i == 4 || i == 6 || i == 7) {
            zzb();
        }
    }
}
