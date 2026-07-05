package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.internal.ads.zzbhw;
import com.google.android.gms.internal.ads.zzceb;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzces;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzd {
    public static void zza(Context context) {
        int i = zzceb.zza;
        if (((Boolean) zzbhw.zza.zze()).booleanValue()) {
            try {
                if (Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) == 0 || zzceb.zzl()) {
                    return;
                }
                ListenableFuture zzb = new zzc(context).zzb();
                zzcec.zzi("Updating ad debug logging enablement.");
                zzces.zza(zzb, "AdDebugLogUpdater.updateEnablement");
            } catch (Exception e) {
                zzcec.zzk("Fail to determine debug setting.", e);
            }
        }
    }
}
