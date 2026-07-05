package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public class zzst extends zzif {
    public final zzsv zza;
    public final String zzb;

    public zzst(Throwable th, zzsv zzsvVar) {
        super("Decoder failed: ".concat(String.valueOf(zzsvVar == null ? null : zzsvVar.zza)), th);
        this.zza = zzsvVar;
        int i = zzfy.zza;
        this.zzb = th instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) th).getDiagnosticInfo() : null;
    }
}
