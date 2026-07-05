package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzip {
    private final AudioManager zza;
    private final zzin zzb;
    private zzio zzc;
    private int zzd;
    private float zze = 1.0f;

    public zzip(Context context, Handler handler, zzio zzioVar) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
        audioManager.getClass();
        this.zza = audioManager;
        this.zzc = zzioVar;
        this.zzb = new zzin(this, handler);
        this.zzd = 0;
    }

    private final void zze() {
        if (this.zzd == 0) {
            return;
        }
        if (zzfy.zza < 26) {
            this.zza.abandonAudioFocus(this.zzb);
        }
        zzg(0);
    }

    private final void zzf(int i) {
        int zzX;
        zzio zzioVar = this.zzc;
        if (zzioVar != null) {
            zzkk zzkkVar = (zzkk) zzioVar;
            boolean zzv = zzkkVar.zza.zzv();
            zzX = zzko.zzX(zzv, i);
            zzkkVar.zza.zzak(zzv, i, zzX);
        }
    }

    private final void zzg(int i) {
        if (this.zzd == i) {
            return;
        }
        this.zzd = i;
        float f = i == 3 ? 0.2f : 1.0f;
        if (this.zze != f) {
            this.zze = f;
            zzio zzioVar = this.zzc;
            if (zzioVar != null) {
                ((zzkk) zzioVar).zza.zzah();
            }
        }
    }

    public final float zza() {
        return this.zze;
    }

    public final int zzb(boolean z, int i) {
        zze();
        return z ? 1 : -1;
    }

    public final void zzd() {
        this.zzc = null;
        zze();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzc(zzip zzipVar, int i) {
        if (i == -3 || i == -2) {
            if (i == -2) {
                zzipVar.zzf(0);
                zzipVar.zzg(2);
                return;
            } else {
                zzipVar.zzg(3);
                return;
            }
        }
        if (i == -1) {
            zzipVar.zzf(-1);
            zzipVar.zze();
        } else if (i == 1) {
            zzipVar.zzg(1);
            zzipVar.zzf(1);
        } else {
            zzff.zzf("AudioFocusManager", "Unknown focus change type: " + i);
        }
    }
}
