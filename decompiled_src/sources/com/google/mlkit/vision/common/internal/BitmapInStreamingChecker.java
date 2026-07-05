package com.google.mlkit.vision.common.internal;

import android.os.SystemClock;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.vision.common.InputImage;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.mlkit:vision-common@@17.3.0 */
/* loaded from: classes4.dex */
public class BitmapInStreamingChecker {
    private static final GmsLogger zza = new GmsLogger("StreamingFormatChecker", "");
    private final LinkedList zzb = new LinkedList();
    private long zzc = -1;

    public void check(InputImage inputImage) {
        if (inputImage.getFormat() != -1) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.zzb.add(Long.valueOf(elapsedRealtime));
        if (this.zzb.size() > 5) {
            this.zzb.removeFirst();
        }
        if (this.zzb.size() != 5 || elapsedRealtime - ((Long) Preconditions.checkNotNull((Long) this.zzb.peekFirst())).longValue() >= CoroutineLiveDataKt.DEFAULT_TIMEOUT) {
            return;
        }
        long j = this.zzc;
        if (j == -1 || elapsedRealtime - j >= TimeUnit.SECONDS.toMillis(5L)) {
            this.zzc = elapsedRealtime;
            zza.w("StreamingFormatChecker", "ML Kit has detected that you seem to pass camera frames to the detector as a Bitmap object. This is inefficient. Please use YUV_420_888 format for camera2 API or NV21 format for (legacy) camera API and directly pass down the byte array to ML Kit.");
        }
    }
}
