package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzdvj implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;
    private final zzhhu zzc;
    private final zzhhu zzd;

    public zzdvj(zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3, zzhhu zzhhuVar4) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
        this.zzc = zzhhuVar3;
        this.zzd = zzhhuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set emptySet;
        final String str = (String) this.zza.zzb();
        Context zza = ((zzclm) this.zzb).zza();
        zzgey zzgeyVar = zzcep.zza;
        zzhhl.zzb(zzgeyVar);
        Map zzb = ((zzhhh) this.zzd).zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeO)).booleanValue()) {
            zzbbp zzbbpVar = new zzbbp(new zzbbv(zza));
            zzbbpVar.zzb(new zzbbo() { // from class: com.google.android.gms.internal.ads.zzdvk
                @Override // com.google.android.gms.internal.ads.zzbbo
                public final void zza(zzbde zzbdeVar) {
                    zzbdeVar.zzh(str);
                }
            });
            emptySet = Collections.singleton(new zzdim(new zzdvm(zzbbpVar, zzb), zzgeyVar));
        } else {
            emptySet = Collections.emptySet();
        }
        zzhhl.zzb(emptySet);
        return emptySet;
    }
}
