package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzduu implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;

    public zzduu(zzhhu zzhhuVar, zzhhu zzhhuVar2) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set emptySet;
        zzgey zzgeyVar = zzcep.zza;
        zzhhl.zzb(zzgeyVar);
        zzdvm zzb = ((zzdvn) this.zzb).zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeO)).booleanValue()) {
            emptySet = Collections.singleton(new zzdim(zzb, zzgeyVar));
        } else {
            emptySet = Collections.emptySet();
        }
        zzhhl.zzb(emptySet);
        return emptySet;
    }
}
