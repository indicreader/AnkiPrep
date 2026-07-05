package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzfso extends Exception {
    private final int zza;

    public zzfso(int i, String str) {
        super(str);
        this.zza = i;
    }

    public final int zza() {
        return this.zza;
    }

    public zzfso(int i, Throwable th) {
        super(th);
        this.zza = i;
    }
}
