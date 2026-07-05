package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzqj {
    private Boolean zza;

    public zzqj() {
    }

    public zzqj(Context context) {
    }

    public final zzpg zza(zzam zzamVar, zzk zzkVar) {
        zzamVar.getClass();
        zzkVar.getClass();
        if (zzfy.zza < 29 || zzamVar.zzA == -1) {
            return zzpg.zza;
        }
        Boolean bool = this.zza;
        if (bool != null) {
            bool.booleanValue();
        } else {
            Boolean bool2 = false;
            this.zza = bool2;
            bool2.booleanValue();
        }
        String str = zzamVar.zzm;
        str.getClass();
        int zza = zzcb.zza(str, zzamVar.zzj);
        if (zza == 0 || zzfy.zza < zzfy.zzf(zza)) {
            return zzpg.zza;
        }
        int zzg = zzfy.zzg(zzamVar.zzz);
        if (zzg == 0) {
            return zzpg.zza;
        }
        try {
            AudioFormat zzv = zzfy.zzv(zzamVar.zzA, zzg, zza);
            if (zzfy.zza >= 31) {
                return zzqi.zza(zzv, zzkVar.zza().zza, false);
            }
            return zzqh.zza(zzv, zzkVar.zza().zza, false);
        } catch (IllegalArgumentException unused) {
            return zzpg.zza;
        }
    }
}
