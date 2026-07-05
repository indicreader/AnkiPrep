package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzqi {
    public static zzpg zza(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z) {
        int playbackOffloadSupport = AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        if (playbackOffloadSupport == 0) {
            return zzpg.zza;
        }
        zzpe zzpeVar = new zzpe();
        boolean z2 = false;
        if (zzfy.zza > 32 && playbackOffloadSupport == 2) {
            z2 = true;
        }
        zzpeVar.zza(true);
        zzpeVar.zzb(z2);
        zzpeVar.zzc(z);
        return zzpeVar.zzd();
    }
}
