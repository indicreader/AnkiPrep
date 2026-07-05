package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzqn {
    public static void zza(AudioTrack audioTrack, zzqp zzqpVar) {
        audioTrack.setPreferredDevice(zzqpVar == null ? null : zzqpVar.zza);
    }
}
