package com.google.android.gms.internal.ads;

import android.media.AudioFormat;
import android.media.AudioTrack;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzpc {
    public static int zza(int i, int i2, zzk zzkVar) {
        for (int i3 = 10; i3 > 0; i3--) {
            int zzg = zzfy.zzg(i3);
            if (zzg != 0 && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i).setSampleRate(i2).setChannelMask(zzg).build(), zzkVar.zza().zza)) {
                return i3;
            }
        }
        return 0;
    }

    public static zzgaa<Integer> zzb(zzk zzkVar) {
        zzgad zzgadVar;
        zzfzx zzfzxVar = new zzfzx();
        zzgadVar = zzpd.zzc;
        zzgce it = zzgadVar.keySet().iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (zzfy.zza >= zzfy.zzf(intValue) && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(intValue).setSampleRate(48000).build(), zzkVar.zza().zza)) {
                zzfzxVar.zzf(Integer.valueOf(intValue));
            }
        }
        zzfzxVar.zzf((Object) 2);
        return zzfzxVar.zzi();
    }
}
