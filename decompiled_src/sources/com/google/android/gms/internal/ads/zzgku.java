package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgku extends zzghi {
    private final String zza;

    private zzgku(String str) {
        this.zza = str;
    }

    public static zzgku zzb(String str) throws GeneralSecurityException {
        return new zzgku(str);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzgku) {
            return ((zzgku) obj).zza.equals(this.zza);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(zzgku.class, this.zza);
    }

    public final String toString() {
        return "LegacyKmsAead Parameters (keyUri: " + this.zza + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzggq
    public final boolean zza() {
        return false;
    }

    public final String zzc() {
        return this.zza;
    }
}
