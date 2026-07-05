package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public abstract class zzhgm extends zzhgk implements zzarm {
    private int zza;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzhgm(String str) {
        super("mvhd");
    }

    public final int zzh() {
        if (!this.zzc) {
            zzg();
        }
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long zzi(ByteBuffer byteBuffer) {
        this.zza = zzarl.zzc(byteBuffer.get());
        zzarl.zzd(byteBuffer);
        byteBuffer.get();
        return 4L;
    }
}
