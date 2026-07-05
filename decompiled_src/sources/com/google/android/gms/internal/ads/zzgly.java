package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgly extends zzghi {
    private final zzglx zza;

    private zzgly(zzglx zzglxVar) {
        this.zza = zzglxVar;
    }

    public static zzgly zzc(zzglx zzglxVar) {
        return new zzgly(zzglxVar);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzgly) && ((zzgly) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(zzgly.class, this.zza);
    }

    public final String toString() {
        return "XChaCha20Poly1305 Parameters (variant: " + this.zza.toString() + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzggq
    public final boolean zza() {
        return this.zza != zzglx.zzc;
    }

    public final zzglx zzb() {
        return this.zza;
    }
}
