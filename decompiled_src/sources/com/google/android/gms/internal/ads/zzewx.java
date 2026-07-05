package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzewx implements zzexq {
    private final String zza;
    private final zzgey zzb;
    private final ScheduledExecutorService zzc;
    private final Context zzd;
    private final zzfhh zze;
    private final zzclg zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzewx(zzgey zzgeyVar, ScheduledExecutorService scheduledExecutorService, String str, Context context, zzfhh zzfhhVar, zzclg zzclgVar) {
        this.zzb = zzgeyVar;
        this.zzc = scheduledExecutorService;
        this.zza = str;
        this.zzd = context;
        this.zze = zzfhhVar;
        this.zzf = zzclgVar;
    }

    public static /* synthetic */ ListenableFuture zzc(zzewx zzewxVar) {
        com.google.android.gms.ads.nonagon.signalgeneration.zzg zzo = zzewxVar.zzf.zzo();
        zzdaf zzdafVar = new zzdaf();
        zzdafVar.zze(zzewxVar.zzd);
        zzfhf zzfhfVar = new zzfhf();
        zzfhfVar.zzs("adUnitId");
        zzfhfVar.zzE(zzewxVar.zze.zzd);
        zzfhfVar.zzr(new com.google.android.gms.ads.internal.client.zzq());
        zzfhfVar.zzx(true);
        zzdafVar.zzi(zzfhfVar.zzG());
        zzo.zza(zzdafVar.zzj());
        com.google.android.gms.ads.nonagon.signalgeneration.zzac zzacVar = new com.google.android.gms.ads.nonagon.signalgeneration.zzac();
        zzacVar.zza(zzewxVar.zza);
        zzo.zzb(zzacVar.zzb());
        new zzdgm();
        return zzgen.zze(zzgen.zzm((zzgee) zzgen.zzo(zzgee.zzu(zzo.zzc().zzc()), ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhg)).longValue(), TimeUnit.MILLISECONDS, zzewxVar.zzc), new zzfws() { // from class: com.google.android.gms.internal.ads.zzewu
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                com.google.android.gms.ads.nonagon.signalgeneration.zzam zzamVar = (com.google.android.gms.ads.nonagon.signalgeneration.zzam) obj;
                return zzamVar != null ? new zzewy(zzamVar.zza) : new zzewy(null);
            }
        }, zzewxVar.zzb), Exception.class, new zzfws() { // from class: com.google.android.gms.internal.ads.zzewv
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                zzcec.zzh("", (Exception) obj);
                return new zzewy(null);
            }
        }, zzewxVar.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 33;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhf)).booleanValue() || this.zze.zzq) {
            return zzgen.zzh(new zzewy(null));
        }
        return zzgen.zzk(new zzgdt() { // from class: com.google.android.gms.internal.ads.zzeww
            @Override // com.google.android.gms.internal.ads.zzgdt
            public final ListenableFuture zza() {
                return zzewx.zzc(zzewx.this);
            }
        }, this.zzb);
    }
}
