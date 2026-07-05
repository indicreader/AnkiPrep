package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzcre implements zzcqv {
    private final zzeil zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcre(zzeil zzeilVar) {
        this.zza = zzeilVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcqv
    public final void zza(Map map) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjU)).booleanValue()) {
            zzgen.zzf(zzgee.zzu(this.zza.zza(true)), Throwable.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzcrd
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final ListenableFuture zza(Object obj) {
                    com.google.android.gms.ads.internal.zzt.zzo().zzw((Throwable) obj, "GetTopicsApiWithRecordObservationActionHandler");
                    return zzgen.zzh(new GetTopicsResponse(zzgaa.zzl()));
                }
            }, zzcep.zza);
        }
    }
}
