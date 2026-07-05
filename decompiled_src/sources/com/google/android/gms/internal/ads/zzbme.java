package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class zzbme implements zzbng {
    public final /* synthetic */ zzdiu zza;
    public final /* synthetic */ zzcse zzb;

    public /* synthetic */ zzbme(zzdiu zzdiuVar, zzcse zzcseVar) {
        this.zza = zzdiuVar;
        this.zzb = zzcseVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final void zza(Object obj, Map map) {
        zzcjk zzcjkVar = (zzcjk) obj;
        zzbnf.zzc(map, this.zza);
        final String str = (String) map.get("u");
        if (str == null) {
            zzcec.zzj("URL missing from click GMSG.");
        } else {
            final zzcse zzcseVar = this.zzb;
            zzgen.zzr(zzgen.zzn(zzgee.zzu(zzbnf.zza(zzcjkVar, str)), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzbmg
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final ListenableFuture zza(Object obj2) {
                    zzcse zzcseVar2;
                    String str2 = (String) obj2;
                    zzbng zzbngVar = zzbnf.zza;
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjL)).booleanValue() || (zzcseVar2 = zzcse.this) == null || !zzcse.zzh(str)) {
                        return zzgen.zzh(str2);
                    }
                    return zzcseVar2.zzb(str2, com.google.android.gms.ads.internal.client.zzay.zze());
                }
            }, zzcep.zza), new zzbmu(zzcjkVar), zzcep.zza);
        }
    }
}
