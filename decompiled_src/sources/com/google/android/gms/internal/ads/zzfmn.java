package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class zzfmn {
    public static zzfmo zza(Context context, int i) {
        boolean booleanValue;
        if (zzfnc.zza()) {
            int i2 = i - 2;
            if (i2 == 20 || i2 == 21) {
                booleanValue = ((Boolean) zzbht.zze.zze()).booleanValue();
            } else {
                switch (i2) {
                    case 2:
                    case 3:
                    case 6:
                    case 7:
                    case 8:
                        booleanValue = ((Boolean) zzbht.zzc.zze()).booleanValue();
                        break;
                    case 4:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        booleanValue = ((Boolean) zzbht.zzd.zze()).booleanValue();
                        break;
                    case 5:
                        booleanValue = ((Boolean) zzbht.zzb.zze()).booleanValue();
                        break;
                }
            }
            if (booleanValue) {
                return new zzfmq(context, i);
            }
        }
        return new zzfnl();
    }

    public static zzfmo zzb(Context context, int i, int i2, com.google.android.gms.ads.internal.client.zzl zzlVar) {
        zzfmo zza = zza(context, i);
        if (zza instanceof zzfmq) {
            zza.zzh();
            zza.zzm(i2);
            if (zzfmy.zze(zzlVar.zzp)) {
                zza.zze(zzlVar.zzp);
            }
        }
        return zza;
    }
}
