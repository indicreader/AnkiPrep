package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public class zzead extends Exception {
    private final int zza;

    public zzead(int i) {
        this.zza = i;
    }

    public final int zza() {
        return this.zza;
    }

    public zzead(int i, String str) {
        super(str);
        this.zza = i;
    }

    public zzead(int i, String str, Throwable th) {
        super(str, th);
        this.zza = 1;
    }
}
