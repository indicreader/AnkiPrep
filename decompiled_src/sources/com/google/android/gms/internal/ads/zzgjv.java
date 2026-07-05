package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzgjv extends zzghi {
    private final int zza;
    private final zzgjt zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgjv(int i, zzgjt zzgjtVar, zzgju zzgjuVar) {
        this.zza = i;
        this.zzb = zzgjtVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgjv)) {
            return false;
        }
        zzgjv zzgjvVar = (zzgjv) obj;
        return zzgjvVar.zza == this.zza && zzgjvVar.zzb == this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(zzgjv.class, Integer.valueOf(this.zza), this.zzb);
    }

    public final String toString() {
        return "AesGcmSiv Parameters (variant: " + String.valueOf(this.zzb) + ", " + this.zza + "-byte key)";
    }

    @Override // com.google.android.gms.internal.ads.zzggq
    public final boolean zza() {
        return this.zzb != zzgjt.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzgjt zzc() {
        return this.zzb;
    }
}
