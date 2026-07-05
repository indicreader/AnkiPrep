package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.HandlerThread;
import android.os.Trace;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzse implements zzsq {
    private final zzfxu zzb;
    private final zzfxu zzc;
    private boolean zzd;

    public zzse(int i) {
        zzsc zzscVar = new zzsc(i);
        zzsd zzsdVar = new zzsd(i);
        this.zzb = zzscVar;
        this.zzc = zzsdVar;
        this.zzd = true;
    }

    public static /* synthetic */ HandlerThread zza(int i) {
        String zzr;
        zzr = zzsg.zzr(i, "ExoPlayer:MediaCodecAsyncAdapter:");
        return new HandlerThread(zzr);
    }

    public static /* synthetic */ HandlerThread zzb(int i) {
        String zzr;
        zzr = zzsg.zzr(i, "ExoPlayer:MediaCodecQueueingThread:");
        return new HandlerThread(zzr);
    }

    public final zzsg zzc(zzsp zzspVar) throws IOException {
        MediaCodec mediaCodec;
        zzss zzskVar;
        int i;
        zzsg zzsgVar;
        String str = zzspVar.zza.zza;
        zzsg zzsgVar2 = null;
        try {
            int i2 = zzfy.zza;
            Trace.beginSection("createCodec:" + str);
            mediaCodec = MediaCodec.createByCodecName(str);
            try {
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            mediaCodec = null;
        }
        try {
            if (this.zzd) {
                zzam zzamVar = zzspVar.zzc;
                if (zzfy.zza >= 34 && zzcb.zzh(zzamVar.zzm)) {
                    zzskVar = new zztq(mediaCodec);
                    i = 4;
                    zzsgVar = new zzsg(mediaCodec, zza(((zzsc) this.zzb).zza), zzskVar, null);
                    Trace.endSection();
                    zzsg.zzh(zzsgVar, zzspVar.zzb, zzspVar.zzd, null, i);
                    return zzsgVar;
                }
            }
            Trace.endSection();
            zzsg.zzh(zzsgVar, zzspVar.zzb, zzspVar.zzd, null, i);
            return zzsgVar;
        } catch (Exception e3) {
            e = e3;
            zzsgVar2 = zzsgVar;
            if (zzsgVar2 != null) {
                zzsgVar2.zzl();
            } else if (mediaCodec != null) {
                mediaCodec.release();
            }
            throw e;
        }
        zzskVar = new zzsk(mediaCodec, zzb(((zzsd) this.zzc).zza));
        i = 0;
        zzsgVar = new zzsg(mediaCodec, zza(((zzsc) this.zzb).zza), zzskVar, null);
    }

    public final void zzd(boolean z) {
        this.zzd = true;
    }
}
