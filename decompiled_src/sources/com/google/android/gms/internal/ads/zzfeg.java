package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfeg implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;
    private final zzhhu zzc;

    public zzfeg(zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
        this.zzc = zzhhuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfed zzb() {
        zzcdf zzi;
        Context context = (Context) this.zza.zzb();
        zzfir zzfirVar = (zzfir) this.zzb.zzb();
        zzfjj zzfjjVar = (zzfjj) this.zzc.zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgr)).booleanValue()) {
            zzi = com.google.android.gms.ads.internal.zzt.zzo().zzi().zzh();
        } else {
            zzi = com.google.android.gms.ads.internal.zzt.zzo().zzi().zzi();
        }
        boolean z = false;
        if (zzi != null && zzi.zzh()) {
            z = true;
        }
        if (((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgt)).intValue() > 0) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgq)).booleanValue() || z) {
                zzfji zza = zzfjjVar.zza(zzfiz.Rewarded, context, zzfirVar, new zzfdh(new zzfde()));
                return new zzfdj(new zzfdt(new zzfds()), new zzfdp(zza.zza, zzcep.zza), zza.zzb, zza.zza.zza().zzf, zzcep.zza);
            }
        }
        return new zzfds();
    }
}
