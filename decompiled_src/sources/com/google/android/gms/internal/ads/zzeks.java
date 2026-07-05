package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzeks implements zzdkw {
    private final zzfgm zza;
    private final zzbus zzb;
    private final AdFormat zzc;
    private zzdbp zzd = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeks(zzfgm zzfgmVar, zzbus zzbusVar, AdFormat adFormat) {
        this.zza = zzfgmVar;
        this.zzb = zzbusVar;
        this.zzc = adFormat;
    }

    @Override // com.google.android.gms.internal.ads.zzdkw
    public final void zza(boolean z, Context context, zzdbk zzdbkVar) throws zzdkv {
        boolean zzs;
        try {
            AdFormat adFormat = AdFormat.BANNER;
            int ordinal = this.zzc.ordinal();
            if (ordinal == 1) {
                zzs = this.zzb.zzs(ObjectWrapper.wrap(context));
            } else if (ordinal == 2) {
                zzs = this.zzb.zzt(ObjectWrapper.wrap(context));
            } else {
                if (ordinal == 5) {
                    zzs = this.zzb.zzr(ObjectWrapper.wrap(context));
                }
                throw new zzdkv("Adapter failed to show.");
            }
            if (zzs) {
                if (this.zzd == null) {
                    return;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbw)).booleanValue() || this.zza.zzZ != 2) {
                    return;
                }
                this.zzd.zza();
                return;
            }
            throw new zzdkv("Adapter failed to show.");
        } catch (Throwable th) {
            throw new zzdkv(th);
        }
    }

    public final void zzb(zzdbp zzdbpVar) {
        this.zzd = zzdbpVar;
    }
}
