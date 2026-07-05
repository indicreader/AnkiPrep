package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzqh {
    public static zzpg zza(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z) {
        if (!AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return zzpg.zza;
        }
        zzpe zzpeVar = new zzpe();
        zzpeVar.zza(true);
        zzpeVar.zzc(z);
        return zzpeVar.zzd();
    }
}
