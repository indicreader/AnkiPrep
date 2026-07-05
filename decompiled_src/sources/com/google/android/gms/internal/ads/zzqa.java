package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzqa extends Exception {
    public final int zza;
    public final boolean zzb;
    public final zzam zzc;

    public zzqa(int i, zzam zzamVar, boolean z) {
        super("AudioTrack write failed: " + i);
        this.zzb = z;
        this.zza = i;
        this.zzc = zzamVar;
    }
}
