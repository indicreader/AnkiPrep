package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfmy {
    public static void zza(ListenableFuture listenableFuture, zzfmz zzfmzVar, zzfmo zzfmoVar) {
        zzg(listenableFuture, zzfmzVar, zzfmoVar, false);
    }

    public static void zzb(ListenableFuture listenableFuture, zzfmz zzfmzVar, zzfmo zzfmoVar) {
        zzg(listenableFuture, zzfmzVar, zzfmoVar, true);
    }

    public static void zzc(ListenableFuture listenableFuture, zzfmz zzfmzVar, zzfmo zzfmoVar) {
        if (((Boolean) zzbht.zzc.zze()).booleanValue()) {
            zzgen.zzr(zzgee.zzu(listenableFuture), new zzfmx(zzfmzVar, zzfmoVar), zzcep.zzf);
        }
    }

    public static void zzd(ListenableFuture listenableFuture, zzfmo zzfmoVar) {
        if (((Boolean) zzbht.zzc.zze()).booleanValue()) {
            zzgen.zzr(zzgee.zzu(listenableFuture), new zzfmv(zzfmoVar), zzcep.zzf);
        }
    }

    public static boolean zze(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziH), str);
    }

    public static int zzf(zzfhh zzfhhVar) {
        int zze = com.google.android.gms.ads.nonagon.signalgeneration.zzf.zze(zzfhhVar) - 1;
        return (zze == 0 || zze == 1) ? 7 : 23;
    }

    private static void zzg(ListenableFuture listenableFuture, zzfmz zzfmzVar, zzfmo zzfmoVar, boolean z) {
        if (((Boolean) zzbht.zzc.zze()).booleanValue()) {
            zzgen.zzr(zzgee.zzu(listenableFuture), new zzfmw(zzfmzVar, zzfmoVar, z), zzcep.zzf);
        }
    }
}
