package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzade {
    public static zzadg zzb(zzfp zzfpVar) {
        zzfpVar.zzL(1);
        int zzo = zzfpVar.zzo();
        long zzd = zzfpVar.zzd();
        long j = zzo;
        int i = zzo / 18;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            long zzt = zzfpVar.zzt();
            if (zzt != -1) {
                jArr[i2] = zzt;
                jArr2[i2] = zzfpVar.zzt();
                zzfpVar.zzL(2);
                i2++;
            } else {
                jArr = Arrays.copyOf(jArr, i2);
                jArr2 = Arrays.copyOf(jArr2, i2);
                break;
            }
        }
        zzfpVar.zzL((int) ((zzd + j) - zzfpVar.zzd()));
        return new zzadg(jArr, jArr2);
    }

    public static zzby zza(zzacv zzacvVar, boolean z) throws IOException {
        zzby zza = new zzadm().zza(zzacvVar, z ? null : zzagq.zza);
        if (zza == null || zza.zza() == 0) {
            return null;
        }
        return zza;
    }
}
