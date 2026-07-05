package com.google.android.gms.internal.ads;

import android.media.AudioManager;
import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzin implements AudioManager.OnAudioFocusChangeListener {
    final /* synthetic */ zzip zza;
    private final Handler zzb;

    public zzin(zzip zzipVar, Handler handler) {
        this.zza = zzipVar;
        this.zzb = handler;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(final int i) {
        this.zzb.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzim
            @Override // java.lang.Runnable
            public final void run() {
                zzip.zzc(zzin.this.zza, i);
            }
        });
    }
}
