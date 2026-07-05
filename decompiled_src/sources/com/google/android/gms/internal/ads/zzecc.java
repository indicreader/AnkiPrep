package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzecc implements zzece {
    private final Map zza;
    private final zzgey zzb;
    private final zzddq zzc;

    public zzecc(Map map, zzgey zzgeyVar, zzddq zzddqVar) {
        this.zza = map;
        this.zzb = zzgeyVar;
        this.zzc = zzddqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzece
    public final ListenableFuture zzb(final zzbze zzbzeVar) {
        this.zzc.zzbw(zzbzeVar);
        ListenableFuture zzg = zzgen.zzg(new zzead(3));
        for (String str : ((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzic)).split(",")) {
            final zzhhu zzhhuVar = (zzhhu) this.zza.get(str.trim());
            if (zzhhuVar != null) {
                zzg = zzgen.zzf(zzg, zzead.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeca
                    @Override // com.google.android.gms.internal.ads.zzgdu
                    public final ListenableFuture zza(Object obj) {
                        return ((zzece) zzhhu.this.zzb()).zzb(zzbzeVar);
                    }
                }, this.zzb);
            }
        }
        zzgen.zzr(zzg, new zzecb(this), zzcep.zzf);
        return zzg;
    }
}
