package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
final class zzra extends AudioTrack.StreamEventCallback {
    final /* synthetic */ zzrd zza;
    final /* synthetic */ zzrb zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzra(zzrb zzrbVar, zzrd zzrdVar) {
        this.zza = zzrdVar;
        this.zzb = zzrbVar;
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onDataRequest(AudioTrack audioTrack, int i) {
        AudioTrack audioTrack2;
        zzpy zzpyVar;
        boolean z;
        zzpy zzpyVar2;
        audioTrack2 = this.zzb.zza.zzt;
        if (audioTrack.equals(audioTrack2)) {
            zzrd zzrdVar = this.zzb.zza;
            zzpyVar = zzrdVar.zzp;
            if (zzpyVar != null) {
                z = zzrdVar.zzO;
                if (z) {
                    zzpyVar2 = zzrdVar.zzp;
                    zzpyVar2.zzb();
                }
            }
        }
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onTearDown(AudioTrack audioTrack) {
        AudioTrack audioTrack2;
        zzpy zzpyVar;
        boolean z;
        zzpy zzpyVar2;
        audioTrack2 = this.zzb.zza.zzt;
        if (audioTrack.equals(audioTrack2)) {
            zzrd zzrdVar = this.zzb.zza;
            zzpyVar = zzrdVar.zzp;
            if (zzpyVar != null) {
                z = zzrdVar.zzO;
                if (z) {
                    zzpyVar2 = zzrdVar.zzp;
                    zzpyVar2.zzb();
                }
            }
        }
    }
}
