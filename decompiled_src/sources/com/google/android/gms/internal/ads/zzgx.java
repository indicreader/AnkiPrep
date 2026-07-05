package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public class zzgx extends IOException {
    public final int zza;

    public zzgx(int i) {
        this.zza = i;
    }

    public zzgx(String str, int i) {
        super(str);
        this.zza = i;
    }

    public zzgx(String str, Throwable th, int i) {
        super(str, th);
        this.zza = i;
    }

    public zzgx(Throwable th, int i) {
        super(th);
        this.zza = i;
    }
}
