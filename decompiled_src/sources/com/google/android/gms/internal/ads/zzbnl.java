package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzbnl implements zzbng {
    private final Context zza;

    public zzbnl(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final void zza(Object obj, Map map) {
        char c;
        if (com.google.android.gms.ads.internal.zzt.zzn().zzp(this.zza)) {
            String str = (String) map.get("eventName");
            String str2 = (String) map.get("eventId");
            int hashCode = str.hashCode();
            if (hashCode == 94399) {
                if (str.equals("_aa")) {
                    c = 2;
                }
                c = 65535;
            } else if (hashCode != 94401) {
                if (hashCode == 94407 && str.equals("_ai")) {
                    c = 1;
                }
                c = 65535;
            } else {
                if (str.equals("_ac")) {
                    c = 0;
                }
                c = 65535;
            }
            if (c == 0) {
                com.google.android.gms.ads.internal.zzt.zzn().zzj(this.zza, str2);
            } else if (c == 1) {
                com.google.android.gms.ads.internal.zzt.zzn().zzk(this.zza, str2);
            } else if (c == 2) {
                com.google.android.gms.ads.internal.zzt.zzn().zzh(this.zza, str2);
            } else {
                zzcec.zzg("logScionEvent gmsg contained unsupported eventName");
            }
        }
    }
}
