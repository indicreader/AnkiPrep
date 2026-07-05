package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzchh {
    private long zza;

    public final long zza(ByteBuffer byteBuffer) {
        zzarp zzarpVar;
        zzaro zzaroVar;
        long j = this.zza;
        if (j > 0) {
            return j;
        }
        try {
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.flip();
            Iterator it = new zzark(new zzchg(duplicate), zzchj.zzb).zze().iterator();
            while (true) {
                zzarpVar = null;
                if (!it.hasNext()) {
                    zzaroVar = null;
                    break;
                }
                zzarm zzarmVar = (zzarm) it.next();
                if (zzarmVar instanceof zzaro) {
                    zzaroVar = (zzaro) zzarmVar;
                    break;
                }
            }
            Iterator it2 = zzaroVar.zze().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                zzarm zzarmVar2 = (zzarm) it2.next();
                if (zzarmVar2 instanceof zzarp) {
                    zzarpVar = (zzarp) zzarmVar2;
                    break;
                }
            }
            long zzd = (zzarpVar.zzd() * 1000) / zzarpVar.zze();
            this.zza = zzd;
            return zzd;
        } catch (IOException | RuntimeException unused) {
            return 0L;
        }
    }
}
