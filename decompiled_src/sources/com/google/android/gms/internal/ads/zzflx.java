package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzflx implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;
    private final zzhhu zzc;

    public zzflx(zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
        this.zzc = zzhhuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        Object obj;
        zzhgx zza = zzhhc.zza(zzhho.zza(this.zza));
        zzhgx zza2 = zzhhc.zza(zzhho.zza(this.zzb));
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzc.zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziA)).booleanValue()) {
            obj = new zzflz((zzflw) zza.zzb(), scheduledExecutorService);
        } else {
            obj = (zzflw) zza2.zzb();
        }
        zzhhl.zzb(obj);
        return obj;
    }
}
